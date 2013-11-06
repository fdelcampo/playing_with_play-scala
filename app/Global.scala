import play.api._

import models._
import anorm._

import java.util.{Date}
import java.text._

object Global extends GlobalSettings {
  
  override def onStart(app: Application) {
    InitialData.insert()
  }
  
}

/**
 * Initial set of data to be imported 
 * in the sample application.
 */
object InitialData {
  
  def date(str: String) = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str)
  
  def insert() = {
    
    if(User.findAll.isEmpty) {
      
      Seq(
        User(NotAssigned,"fdelcampo@inria.cl", "Fernando del Campo", "1234"),
        User(NotAssigned,"test1@asd.cl", "Test1", "1234"),
        User(NotAssigned,"asdf@asdf.cl","sadf","1234")
      ).map(user => User.create(user))
      
    }
    
    if(Role.findAll.isEmpty){
      Seq(
          Role(NotAssigned, "Usuarios", "/usuarios"),
          Role(NotAssigned, "Importar Titulados", "/importar_titulados"),
          Role(NotAssigned, "Construir Resolución", "/construir_resolucion"),
          Role(NotAssigned, "Aprobar Resolución", "/aprobar_resolucion"),
          Role(NotAssigned, "Rechazar Resolución", "/rechazar_resolucion"),
          Role(NotAssigned, "Firmar Diploma", "/firmar")
      ).map(role => Role.create(role))
    }
    
    User.findByEmail("fdelcampo@inria.cl").get.addRole(1)
    User.findByEmail("fdelcampo@inria.cl").get.addRole(2)
    User.findByEmail("fdelcampo@inria.cl").get.addRole(3)
    User.findByEmail("test1@asd.cl").get.addRole(2)
    
    if(Person.findAll.isEmpty) {
      List(
    	  Person(NotAssigned, "Fernando", "del Campo", "Vergara", 16014182, "4", "Masculino", new Date(1984-1900, 12-1, 11), "Chile")
      ).map(person => Person.create(person))
    }

    
  }
}