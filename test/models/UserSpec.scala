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



class UserSpec extends Specification {

  val valids: List[User] = List(
	User(NotAssigned, "asd@asd.cl", "asd", "1234"),
    User(NotAssigned, "sdf@sdf.cl", "sdf", "qwer")
  )
  
  val invalids: List[User] = List(
	User(NotAssigned, "asdasd.cl", "asd", "1234"),
	User(NotAssigned, "sdf@sdf.cl", "", "qwer"),
	User(NotAssigned, "dfg@sdf.cl", "dfg", ""),
	User(NotAssigned, "sdf@sdf.cl", "", ""),
	User(NotAssigned, "", "dfg", "1234")
  )
  /*
  "User" should {
    
    "create" in new WithApplication{
      
    	var res: Boolean = true
    	valids.map(m => {
    	  var c = User.create(m)
    	  res = res && (c != null)
    	  println("valid create: " + c)
    	})
    	res must equalTo(true)
    	
    	res = true
    	invalids.map(m => {
    	  var c = User.create(m)
    	  res = res && (c == null)
    	  println("invalid create: " + c)
    	})
    	res must equalTo(true)
    	
    }
    
    
  }
  *
  */
  
  
}