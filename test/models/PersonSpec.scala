package test.models

import controllers.routes
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import models._
import play.api.libs.iteratee._
import play.api.libs.concurrent._
import anorm.Id
import anorm.NotAssigned

import java.util.{Date}


class PersonSpec extends Specification {

  val valids: List[Person] = List(
	Person(NotAssigned, "firstname", "primarylastname", "secondlastname", 16014182, "4", "masculino", new Date(1984-1900,12-1,11), "Chile")
  )
  
  val invalids: List[Person] = List(
	Person(NotAssigned, "firstname", "primarylastname", "secondlastname", 0, null, "masculino", new Date(1984-1900,12-1,11), "Chile")
  )
  
  /*
  "Person" should {
    
    "create" in new WithApplication{
      
    	var res: Boolean = true
    	valids.map(m => {
    	  var c = Person.create(m)
    	  println("valid create: " + c)
    	  res = res && (c != null)
    	})
    	res must equalTo(true)
    	
    	res = true
    	invalids.map(m => {
    	  var c = Person.create(m)
    	  println("invalid create: " + c)
    	  res = res && (c == null)
    	})
    	res must equalTo(true)
    	
    }
    
    
  }
  *
  * 
  */
  
}