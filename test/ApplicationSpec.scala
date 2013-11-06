package test

import controllers.routes

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

import models._


import play.api.libs.iteratee._
import play.api.libs.concurrent._


/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends Specification {
  
  "Application" should {
    
    "send 404 on a bad request" in {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/werq")) must beNone        
      }
    }
    
    "redirect to the login page" in {
      running(FakeApplication()) {
        val res = route(FakeRequest(GET, "/")).get
        
        status(res) must equalTo(SEE_OTHER)
        redirectLocation(res) should equalTo(Some("/login"))
        
      }
    }
    
    
  }
  
  "Auth" should {
    
    "send 404 on a bad request" in {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/login/werq")) must beNone        
      }
    }
    
    "render the login page" in {
      running(FakeApplication()) {
        val res = route(FakeRequest(GET, "/login")).get
        
        status(res) must equalTo(OK)
        contentType(res) must beSome.which(_ == "text/html")
        charset(res) must beSome("utf-8")
        contentAsString(res) must contain ("Sign in")
      }
    }

    "respond to the correct authenticate" in {

      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(POST, "/login").withFormUrlEncodedBody(
            "email" -> "test1@asd.cl",
            "password" -> "1234"
            ))
        
        status(res) must equalTo(SEE_OTHER)
        session(res).get("email") must equalTo(Some("test1@asd.cl"))

        
      }
	}
    
    "respond to the incorrect authenticate" in {

      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(POST, "/login").withFormUrlEncodedBody(
            "email" -> "tsdaf@assf.cl",
            "password" -> "fail"
            ))
        
        status(res) must equalTo(FORBIDDEN)
        session(res).get("email") must equalTo(None)
        
      }
	}
    
    
    
    
  }
  
  "Privileges for admin users" should {
    
    "list users" in {
      
      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(GET, "/usuarios").withSession("email" -> "fdelcampo@inria.cl")
        )
        status(res) must equalTo(OK)
        //session(res).get("email") must equalTo(Some("fdelcampo@inria.cl"))
        contentAsString(res) must contain ("sadf")
        contentAsString(res) must contain ("Test1")
        contentAsString(res) must contain ("Nombre")
        contentAsString(res) must contain ("Usuarios")
        contentAsString(res) must contain ("Editar")
        
      }
    }
    
    
    "create user" in {
      
      running(FakeApplication()) {
        val Some(resbe) = route(FakeRequest(GET, "/usuarios").withSession("email" -> "fdelcampo@inria.cl")
        )
        status(resbe) must equalTo(OK)
        contentAsString(resbe) must not contain ("testnew")
        val Some(res) = route(FakeRequest(POST, "/usuarios").withSession("email" -> "fdelcampo@inria.cl").withFormUrlEncodedBody(
        		"email" -> "testnew@asd.cl",
        		"name" -> "testnew",
        		"password" -> "123456"
        	)
        )
        status(res) must equalTo(SEE_OTHER)
        val Some(resnew) = route(FakeRequest(GET, "/usuarios").withSession("email" -> "fdelcampo@inria.cl")
        )
        status(resnew) must equalTo(OK)
        contentAsString(resnew) must contain ("testnew")
        
        
      }
    }
    
    
      "create bad user" in {
      
      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(POST, "/usuarios").withSession("email" -> "fdelcampo@inria.cl").withFormUrlEncodedBody(
        		"email" -> "testnew",
        		"name" -> "testnew",
        		"password" -> "123456"
        	)
        )
        status(res) must equalTo(BAD_REQUEST)
        
        val Some(resnew) = route(FakeRequest(POST, "/usuarios").withSession("email" -> "fdelcampo@inria.cl").withFormUrlEncodedBody(
        		"email" -> "testnew@asd.cl",
        		"name" -> "testnew",
        		"password" -> "1234"
        	)
        )
        status(resnew) must equalTo(BAD_REQUEST)
        
        val Some(resnew2) = route(FakeRequest(POST, "/usuarios").withSession("email" -> "fdelcampo@inria.cl").withFormUrlEncodedBody(
        		"email" -> "testnew@asd.cl",
        		"name" -> "",
        		"password" -> "123456"
        	)
        )
        status(resnew2) must equalTo(BAD_REQUEST)
        
        
      }
    }
      
      
      
    "update user" in {
      
      running(FakeApplication()) {
        val Some(resbe) = route(FakeRequest(GET, "/usuarios/2").withSession("email" -> "fdelcampo@inria.cl")
        )
        status(resbe) must equalTo(OK)
        contentAsString(resbe) must contain ("Test1")
        contentAsString(resbe) must not contain ("Test1new")
        val Some(res) = route(FakeRequest(PUT, "/usuarios/2").withSession("email" -> "fdelcampo@inria.cl").withFormUrlEncodedBody(
        		"email" -> "test1@asd.cl",
        		"name" -> "Test1new",
        		"password" -> "123456"
        	)
        )
        status(res) must equalTo(SEE_OTHER)
        val Some(resnew) = route(FakeRequest(GET, "/usuarios/2").withSession("email" -> "fdelcampo@inria.cl")
        )
        status(resnew) must equalTo(OK)
        contentAsString(resnew) must contain ("Test1new")
        
        
      }
    }
    
    "delete user" in {
      
      running(FakeApplication()) {
        val Some(resbe) = route(FakeRequest(GET, "/usuarios/2").withSession("email" -> "fdelcampo@inria.cl")
        )
        status(resbe) must equalTo(OK)
        contentAsString(resbe) must contain ("Test1")
        val Some(res) = route(FakeRequest(DELETE, "/usuarios/2").withSession("email" -> "fdelcampo@inria.cl"))
            
        status(res) must equalTo(SEE_OTHER)
        val Some(resnew) = route(FakeRequest(GET, "/usuarios/2").withSession("email" -> "fdelcampo@inria.cl")
        )
        status(resnew) must equalTo(NOT_FOUND)
        
        
      }
    }
    
    
    "add role to user" in {
      
      running(FakeApplication()) {
        val Some(resbe) = route(FakeRequest(GET, "/usuarios/2/removerole/4").withSession("email" -> "fdelcampo@inria.cl"))
        status(resbe) must equalTo(NOT_FOUND)

        val Some(res) = route(FakeRequest(GET, "/usuarios/2/addrole/4").withSession("email" -> "fdelcampo@inria.cl"))
        status(res) must equalTo(SEE_OTHER)
        
        val Some(resnew) = route(FakeRequest(GET, "/usuarios/2/removerole/4").withSession("email" -> "fdelcampo@inria.cl"))
        status(resnew) must equalTo(SEE_OTHER)
        
        
      }
    }
    
    
    "remove role to user" in {
      
      running(FakeApplication()) {
        val Some(resbe) = route(FakeRequest(GET, "/usuarios/2/addrole/2").withSession("email" -> "fdelcampo@inria.cl"))
        status(resbe) must equalTo(NOT_FOUND)

        val Some(res) = route(FakeRequest(GET, "/usuarios/2/removerole/2").withSession("email" -> "fdelcampo@inria.cl"))
        status(res) must equalTo(SEE_OTHER)
        
        val Some(resnew) = route(FakeRequest(GET, "/usuarios/2/addrole/2").withSession("email" -> "fdelcampo@inria.cl"))
        status(resnew) must equalTo(SEE_OTHER)
        
        
      }
    }
    
    
  }
  
  
  
  
  "Without privileges for admin users" should {
    
    "list users" in {
      
      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(GET, "/usuarios").withSession("email" -> "test1@asd.cl")
        )
        status(res) must equalTo(FORBIDDEN)

        
      }
    }
    
    
    "create user" in {
      
      running(FakeApplication()) {
        
        val Some(res) = route(FakeRequest(POST, "/usuarios").withSession("email" -> "test1@asd.cl").withFormUrlEncodedBody(
        		"email" -> "testnew@asd.cl",
        		"name" -> "testnew",
        		"password" -> "1234"
        	)
        )
        status(res) must equalTo(FORBIDDEN)

        
      }
    }
    
    
      "create bad user" in {
      
      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(POST, "/usuarios").withSession("email" -> "test1@asd.cl").withFormUrlEncodedBody(
        		"email" -> "testnew",
        		"name" -> "testnew",
        		"password" -> "1234"
        	)
        )
        status(res) must equalTo(FORBIDDEN)
        
        
        
      }
    }
      
      
      
    "update user" in {
      
      running(FakeApplication()) {

        val Some(res) = route(FakeRequest(PUT, "/usuarios/2").withSession("email" -> "test1@asd.cl").withFormUrlEncodedBody(
        		"email" -> "test1@asd.cl",
        		"name" -> "Test1new",
        		"password" -> "1234"
        	)
        )
        status(res) must equalTo(FORBIDDEN)
        
        
      }
    }
    
    "delete user" in {
      
      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(DELETE, "/usuarios/2").withSession("email" -> "test1@asd.cl")) 
        status(res) must equalTo(FORBIDDEN)

      }
    }
    
    
    "add role to user" in {
      
      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(GET, "/usuarios/2/addrole/4").withSession("email" -> "test1@asd.cl"))
        status(res) must equalTo(FORBIDDEN) 
        
      }
    }
    
    
    "remove role to user" in {
      
      running(FakeApplication()) {
        val Some(res) = route(FakeRequest(GET, "/usuarios/2/removerole/2").withSession("email" -> "test1@asd.cl"))
        status(res) must equalTo(FORBIDDEN)
        
        
      }
    }
    
    
  }
  
}


