package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._


import models._
import views._
import anorm._


object Persons extends Controller with Secured{

  val personForm: Form[Person] = Form(
      mapping(
          "firstname" -> nonEmptyText,
          "primarylastname" -> nonEmptyText,
          "secondlastname" -> nonEmptyText,
          "runnumber" -> number,
          "rundv" -> nonEmptyText(1,1),
          "genre" -> nonEmptyText,
          "birth" -> date("yyyy-MM-dd"),
          "nationality" -> text
          
      )((firstname, primarylastname, secondlastname, runnumber, rundv, genre, birth, nationality) => Person(NotAssigned, firstname, primarylastname, secondlastname, runnumber, rundv, genre, birth, nationality))
      ((t: Person) => Some(t.firstname, t.primarylastname, t.secondlastname, t.runnumber, t.rundv, t.genre, t.birth, t.nationality))
  )
  
  
  def create = HasRoleOf(Role.findByName("Importar Titulados").get.id.get ) { _ => implicit request =>
    Ok(html.persons.create(personForm, Genres.list, Nationalities.list))
  }
  
  def addPerson = HasRoleOf(Role.findByName("Importar Titulados").get.id.get ) { _ => implicit request =>
    try{
    personForm.bindFromRequest.fold(
      errors => {
        println(errors)
        BadRequest(html.persons.create(errors, Genres.list, Nationalities.list))
      },
      person => { Person.create(person)
        Redirect(routes.Persons.list).flashing(
              "success" -> "Person add"
          )
      }
    )
    } catch {
      case ex: Exception =>
        println(ex.getMessage())
        Ok(ex.getStackTraceString)
    }
  }
  
  def list = HasRoleOf(Role.findByName("Importar Titulados").get.id.get ) { _ => implicit request =>
    Ok(html.persons.list(Person.findAll))
  }
  
  def delete(person_id: Long) = HasRoleOf(Role.findByName("Importar Titulados").get.id.get ) { _ => implicit request =>
    if (Person.delete(person_id)) {
      Redirect(routes.Persons.list).flashing(
      "success" -> "Person delete"
    )
    } else {
      NotFound
    }
    
  }
  
  def show(person_id: Long) = HasRoleOf(Role.findByName("Importar Titulados").get.id.get ) { _ => implicit request => {
	render{
	  case Accepts.Html() => 
	    Person.findById(person_id).map {
		      person => 
		        Ok(html.persons.show(person_id, personForm.fill(person), Genres.list, Nationalities.list))//.as("text/html")
		    }.getOrElse(NotFound)
	  case Accepts.Xml() =>
	    Person.findById(person_id).map {
		      person => 
		        Ok(person.toXml).as("text/xml")
		    }.getOrElse(NotFound)
	
	  case Accepts.Json() =>
	    Person.findById(person_id).map {
		      person => 
		        Ok(person.toJson).as("text/json")
		    }.getOrElse(NotFound)
	  }
  	}
  }
    
  
  def showXML(person_id: Long) = HasRoleOf(Role.findByName("Importar Titulados").get.id.get ) { _ => implicit request =>
    Person.findById(person_id).map {
      person => 
        Ok(person.toXml).as("text/xml")
        //renderXml({person.toXml})
    }.getOrElse(NotFound)
  }
  
  
  def update(person_id: Long) = HasRoleOf(Role.findByName("Usuarios").get.id.get ) { _ => implicit request =>
    Person.update(person_id, personForm.bindFromRequest.get)
    Redirect(routes.Persons.list).flashing(
      "success" -> "Update OK person"
    )
  }

  
}