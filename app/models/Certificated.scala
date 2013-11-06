package models

import java.util.{Date}
import anorm._

/*

case class Certificated (
	
    override val id: Pk[Long] = NotAssigned,
	//override val id: Pk[Long] = NotAssigned,
    firstname: String,
    primarylastname: String,
    secondlastname: String,
    runnumber: Int,
    rundv: String,
    genre: String,
    birth: Date,
    nationality: String,
    
    
    enrollment: String,
    degree: String
    
    
)


object Certificated{
  
  val simple = {
    get[Pk[Long]]("persons.id") ~ 
    //get[Name]("person.name") ~ 
    get[String]("persons.firstname") ~ 
    get[String]("persons.primarylastname") ~ 
    get[String]("persons.secondlastname") ~ 
    get[Int]("persons.runnumber") ~ 
    get[String]("persons.rundv") ~ // check char
    get[String]("persons.genre") ~ 
    get[Date]("persons.birth") ~
    get[String]("persons.nationality") ~
    get[String]("certificateds.enrollment") ~
    get[String]("certificateds.degree") map {
      case id ~ firstname ~ primarylastname ~ secondlastname ~ runnumber ~ rundv ~ genre ~ birth ~ nationality ~ enrollment ~ degree => {
        Person(id, firstname, primarylastname, secondlastname, runnumber, rundv, genre, birth, nationality)
        Certificated(id, enrollment, degree)
      }
          
    }
  }
  
  
}

*/


