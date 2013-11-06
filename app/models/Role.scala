package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Role(id: Pk[Long], name: String, route: String)


object Role {

  /**
   * Parse a Role from a ResultSet
   */
  val simple = {
    get[Pk[Long]]("roles.id") ~
    get[String]("roles.name") ~
    get[String]("roles.route") map {
      case id~name~route => Role(id, name, route)
    }
  }
  
  // -- Queries
  
  /**
   * Retrieve a Role from id.
   */
  def findById(id: Long): Option[Role] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM roles WHERE id = {id}").on(
        'id -> id
      ).as(Role.simple.singleOpt)
    }
  }
  
  /**
   * Retrieve a Role from user id.
   */
  def findByUserId(id: Long): Seq[Role] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM roles WHERE id IN (SELECT role_id FROM role_user WHERE role_user.user_id = {id})").on(
        'id -> id
      ).as(Role.simple *)
    }
  }
  
  /**
   * Retrieve a Role from name.
   */
  def findByName(name: String): Option[Role] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM roles WHERE name = {name}").on(
        'name -> name
      ).as(Role.simple.singleOpt)
    }
  }
  
  /**
   * Retrieve all roles.
   */
  def findAll: Seq[Role] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM roles").as(Role.simple *)
    }
  }
   
  /**
   * Create a Role.
   */
  def create(role: Role): Role = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          INSERT INTO roles(name, route) VALUES (
            {name}, {route}
          )
        """
      ).on(
        'name -> role.name,
        'route -> role.route
      ).executeUpdate()
      
      role
      
    }
  }
  
  /**
   * Update a Role
   */
   def update(id: Long, role: Role): Role = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          UPDATE roles
          SET name = {name}, route = {route}
          WHERE id = {id}
        """
      ).on(
        'id -> id,
        'name -> role.name,
        'route -> role.route
      ).executeUpdate()
      
      role
    }
  }
  
  /**
   * Delete a Role.
   */
  def delete(id: Long) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          DELETE FROM roles WHERE id = {id}
        """
      ).on(
        'id -> id
      ).executeUpdate()      
    }
  }
  
  
  
}