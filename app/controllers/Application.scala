package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models._
import views._


object Application extends Controller with Secured{

  /**
   * Index page.
   *
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  } 
  */
  
  def index = IsAuthenticated { username => _ => User.findByEmail(username).map { user =>
      Ok(
        views.html.index(user)
      )
    }.getOrElse(
        Redirect(routes.Auth.login).flashing(
              "warning" -> "Debes Autentificarte"
          )
    )
  }
  
  def welcome = Action {
    Ok(views.html.welcome())
  }
  
  def degrees_admin = IsAuthenticated { username => _ => User.findByEmail(username).map { user =>
      Redirect(routes.Persons.list)
    }.getOrElse(
        Redirect(routes.Auth.login).flashing(
              "warning" -> "Debes Autentificarte"
          )
    )
  }
  
}

