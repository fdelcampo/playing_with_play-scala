package models

import play.api.db._
import play.api.Play.current

//import play.data.validation.Constraints.{Email, Required}
import play.data.validation.Constraints._


import anorm._
import anorm.SqlParser._

//@Entity
case class User(
    id: Pk[Long] = NotAssigned, 
    email: String, 
    name: String, 
    password: String
){
  def getRoles(): Seq[Role] = Role.findByUserId(id.get)
  def addRole(role_id: Long) = User.addRole(id.get,role_id)
  def removeRole(role_id: Long) = User.removeRole(id.get, role_id)
}


object User {

  /**
   * Parse a User from a ResultSet
   */
  val simple = {
    get[Pk[Long]]("users.id") ~
    get[String]("users.email") ~
    get[String]("users.name") ~
    get[String]("users.password") map {
      case id~email~name~password => User(id, email, name, password)
    }
  }
  
  def apply(email: String, name: String, password: String): User = User(NotAssigned, email, name, password)
  
  //def unapply(user: User) = Some(user.email, user.name, user.password)
  // ((t: User) => Some(t.email, t.name, t.password))
  
  // -- Queries
  
  /**
   * Retrieve a User from id.
   */
  def findById(id: Long): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM users WHERE id = {id}").on(
        'id -> id
      ).as(User.simple.singleOpt)
    }
  }
  
  /**
   * Retrieve a User from email.
   */
  def findByEmail(email: String): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM users WHERE email = {email}").on(
        'email -> email
      ).as(User.simple.singleOpt)
    }
  }
  
  /**
   * Retrieve all users.
   */
  def findAll: Seq[User] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM users").as(User.simple *)
    }
  }
  
  /**
   * Authenticate a User.
   */
  def authenticate(email: String, password: String): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
         SELECT * FROM users
         WHERE email = {email} AND password = {password}
        """
      ).on(
        'email -> email,
        'password -> password
      ).as(User.simple.singleOpt)
    }
  }
   
  /**
   * Create a User.
   */
  def create(user: User): User = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          INSERT INTO users(email, name, password) VALUES (
            {email}, {name}, {password}
          )
        """
      ).on(
        'email -> user.email,
        'name -> user.name,
        'password -> user.password
      ).executeUpdate()
    }
    user
  }
  
  /**
   * Update a User
   */
   def update(id: Long, user: User): User = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          UPDATE users
          SET email = {email}, name = {name}, password = {password}
          WHERE id = {id}
        """
      ).on(
        'id -> id,
        'email -> user.email,
        'name -> user.name,
        'password -> user.password
      ).executeUpdate()
      user
    }
  }
  
  /**
   * Delete a User.
   */
  def delete(id: Long): Boolean = {
    DB.withConnection { implicit connection =>
      val ret = SQL(
        """
          DELETE FROM users
          WHERE id = {id}
        """
      ).on(
        'id -> id
      ).executeUpdate()
      ret > 0
    }
  }
  
  /**
   * Create a relation User Role.
   */
  def addRole(user_id: Long, role_id: Long): Boolean = {
    
	var ret = false
    DB.withConnection { implicit connection =>
      ret = SQL(
        """
          SELECT COUNT(*) FROM role_user
    	  WHERE role_id = {role_id} AND user_id = {user_id}
        """
      ).on(
        'role_id -> role_id,
        'user_id -> user_id
      ).as(scalar[Long].single) > 0
    }
      
	if (!ret){
        DB.withConnection { implicit connection =>
        ret = SQL(
	        """
	          INSERT INTO role_user(role_id, user_id) VALUES (
	            {role_id}, {user_id}
	          )
        	"""
	      ).on(
	        'role_id -> role_id,
	        'user_id -> user_id
	      ).executeUpdate() > 0
	      ret
        }
	  } else {
	    false
	  }  
    }
  
  /**
   * Remove a relation User Role.
   */
  def removeRole(user_id: Long, role_id: Long): Boolean = {
    DB.withConnection { implicit connection =>
      val ret = SQL(
        """
          DELETE FROM role_user
          WHERE user_id = {user_id} AND role_id = {role_id}
        """
      ).on(
        'user_id -> user_id,
        'role_id -> role_id
      ).executeUpdate()
      println(ret)
      ret > 0
    }
  }
  
  /**
   * Check if a user has a role
   */
  def hasRole(role_id: Long, user: String): Boolean = {
    DB.withConnection { implicit connection =>
      val ret = SQL(
        """
          SELECT COUNT(users.id) FROM users 
          JOIN role_user ON role_user.user_id = users.id 
          WHERE role_user.role_id = {role_id} and users.email = {email}
        """
      ).on(
        'role_id -> role_id,
        'email -> user
      ).as(scalar[Long].single)
      ret > 0
    }
  }

  
}