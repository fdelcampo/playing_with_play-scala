package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._


import models._
import views._
import anorm._


object Users extends Controller with Secured{
  

  val userForm: Form[User] = Form(
    mapping(
	      "email" -> email,
	      "name" -> nonEmptyText(6),
	      "password" -> nonEmptyText(6)
      ) (User.apply)((t: User) => Some(t.email, t.name, t.password))
  )


  def create = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    Ok(html.users.create(userForm))
  }
  
  
  def addUser = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    try{
    userForm.bindFromRequest.fold(
      errors => {
        println(errors)
        BadRequest(views.html.users.create(errors))
      },
      user => { User.create(user)
        Redirect(routes.Users.list).flashing(
              "success" -> "User add"
          )
      }
    )
    } catch {
      case ex: Exception =>
        println(ex.getMessage())
        Ok(ex.getStackTraceString)
    }
  }
  
  def delete(user_id: Long) = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    if (User.delete(user_id)) {
      Redirect(routes.Users.list).flashing(
      "success" -> "User delete"
    )
    } else {
      NotFound
    }
    
  }
  
  def show(user_id: Long) = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    User.findById(user_id).map {
      user => 
        Ok(html.users.show(user_id, userForm.fill(user)))
    }.getOrElse(NotFound)
  }
  
  def update(user_id: Long) = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    User.update(user_id, userForm.bindFromRequest.get)
    Redirect(routes.Users.list).flashing(
      "success" -> "Update OK user"
    )
  }
  
  def list = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    Ok(html.users.list(User.findAll, Role.findAll))
  }
  
  def userAddRole(user_id: Long, role_id: Long) = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    if (User.addRole(user_id, role_id))
	    Redirect(routes.Users.list).flashing(
	      "success" -> "Role add to user"
	    )
	else
	  NotFound
  }
  
  def userRemoveRole(user_id: Long, role_id: Long) = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    if (User.removeRole(user_id, role_id))
	    Redirect(routes.Users.list).flashing(
	      "success" -> "Role remove to user"
	    )
	else
	  NotFound
  }

}

