package models

import java.util.{Date, Calendar}

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

import cl.inria.tdu.person._
import org.apache.xmlbeans.{XmlOptions, XmlObject}

import play.api.libs.json.Json



case class Person(
    id: Pk[Long] = NotAssigned,
    //id_person: Pk[Long] = NotAssigned,
    firstname: String,
    primarylastname: String,
    secondlastname: String,
    runnumber: Int,
    rundv: String,
    genre: String,
    birth: Date,
    nationality: String
){
  def toXml: String = {

    val run = RunType.Factory.newInstance()
    run.setNumber({runnumber})
    run.setDv({rundv})
    val person = PersonXMLType.Factory.newInstance()
    person.setId({id}.get)
    person.setFirstname({firstname})
    person.setPrimarylastname({primarylastname})
    person.setSecondlastname({secondlastname})
    person.setRun(run)
    person.setGenre({genre})
    var cal = Calendar.getInstance()
    cal.setTime( {birth} )
    person.setBirth(cal)
    person.setNationality({nationality})
    val doc = PersonXMLDocument.Factory.newInstance()
    doc.setPersonXML(person)
    val opts = new XmlOptions()
    opts.setSavePrettyPrint()
    doc.xmlText(opts)
  }
  
  def toJson = {
    	Json.obj(
    	    "id" -> id.get,
    	    "firstname" -> firstname,
    	    "primarylastname" -> primarylastname,
    	    "secondlastname" -> secondlastname,
    	    "runnumber" -> runnumber,
    	    "rundv" -> rundv,
    	    "genre" -> genre,
    	    "birth" -> birth,
    	    "nationality" -> nationality
    	)
  }
}



object Person {
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
    get[String]("persons.nationality") map {
      case id ~ firstname ~ primarylastname ~ secondlastname ~ runnumber ~ rundv ~ genre ~ birth ~ nationality => Person(id, firstname, primarylastname, secondlastname, runnumber, rundv, genre, birth, nationality)
    }
  }

  
  
  def create(person: Person): Pk[Long] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          INSERT INTO persons(firstname, primarylastname, secondlastname, runnumber, rundv, genre, birth, nationality) VALUES (
          {firstname}, {primarylastname}, {secondlastname}, {runnumber}, {rundv}, {genre}, {birth}, {nationality}
          )
        """
      ).on(
        'firstname -> person.firstname,
        'primarylastname -> person.primarylastname,
        'secondlastname -> person.secondlastname,
        'runnumber -> person.runnumber,
        'rundv -> person.rundv,
        'genre -> person.genre,
        'birth -> person.birth,
        'nationality -> person.nationality
      ).executeInsert()
    } match {
      case Some(long)	=> new Id[Long](long)
      case None			=> throw new Exception(
          "SQL Error - Did not save Person"
      )
    }
  }
  
  def update(id: Long, person: Person): Person = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          UPDATE persons
          SET firstname = {firstname}, primarylastname = {primarylastname}, secondlastname = {secondlastname}, runnumber = {runnumber}, rundv = {rundv}, genre = {genre}, birth = {birth}, nationality = {nationality}
          WHERE id = {id}
        """
      ).on(
        'id -> id,
        'firstname -> person.firstname,
        'primarylastname -> person.primarylastname,
        'secondlastname -> person.secondlastname,
        'runnumber -> person.runnumber,
        'rundv -> person.rundv,
        'genre -> person.genre,
        'birth -> person.birth,
        'nationality -> person.nationality
      ).executeUpdate()
      person
    }
  }
  
  def findAll: Seq[Person] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM persons").as(Person.simple *)
    }
  }
  
  def findById(id: Long): Option[Person] = {
	DB.withConnection { implicit connection =>
      SQL("SELECT * FROM persons WHERE id = {id}").on(
        'id -> id
      ).as(Person.simple.singleOpt)
    }
  }
  
  def findByRun(runnumber: Int): Option[Person] = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM persons WHERE runnumber = {runnumber}").on(
        'runnumber -> runnumber
      ).as(Person.simple.singleOpt)
    }
  }
  
  def delete(id: Long): Boolean = {
    DB.withConnection { implicit connection =>
      val ret = SQL(
        """
          DELETE FROM persons
          WHERE id = {id}
        """
      ).on(
        'id -> id
      ).executeUpdate()
      ret > 0
    }
  }
  
}





object Genres {
  val list = Seq(
      "--",
      "Masculino", 
      "Femenino"    
  )
}

object Nationalities {
  val list = Seq(
    "--",
	"Afganistán",
	"Albania",
	"Argelia",
	"Samoa Americana",
	"Andorra",
	"Angola",
	"Anguilla",
	"Antártida",
	"Antigua y Barbuda",
	"Argentina",
	"Armenia",
	"Aruba",
	"Australia",
	"Austria",
	"Azerbaiyán",
	"Bahamas",
	"Bahrein",
	"Bangladesh",
	"Barbados",
	"Bielorrusia",
	"Bélgica",
	"Belice",
	"Benín",
	"Bermudas",
	"Bután",
	"Bolivia",
	"Bosnia-Herzegovina",
	"Botswana",
	"Brasil",
	"Brunei Darussalam",
	"Bulgaria",
	"Burkina Faso",
	"Burundi",
	"Camboya",
	"Camerún",
	"Canadá",
	"Cabo Verde",
	"Islas Caimán",
	"República Centroafricana",
	"Chad",
	"Chile",
	"China",
	"Isla De Navidad, Isla Christmas",
	"Islas Cocos",
	"Colombia",
	"Comores",
	"República Democrática del Congo",
	"República del Congo",
	"Islas Cook",
	"Costa Rica",
	"Costa de Marfil",
	"Croacia",
	"Cuba",
	"Chipre",
	"República Checa",
	"Dinamarca",
	"Djibouti, Yibuti",
	"Dominica",
	"Dominicana, República",
	"Timor Oriental",
	"Ecuador",
	"Egipto",
	"El Salvador",
	"Guinea Ecuatorial",
	"Eritrea",
	"Estonia",
	"Etiopía",
	"Islas Malvinas",
	"Islas Feroe",
	"Fiyi",
	"Finlandia",
	"Francia",
	"Guayana Francesa",
	"Polinesia Francesa",
	"Tierras Australes y Antárticas Francesas",
	"Gabón",
	"Gambia",
	"Georgia",
	"Alemania",
	"Ghana",
	"Gibraltar",
	"Gran Bretaña",
	"Grecia",
	"Groenlandia",
	"Granada",
	"Guadalupe",
	"Guam",
	"Guatemala",
	"República Guinea",
	"Guinea Bissau",
	"Guyana",
	"Haiti",
	"Santa Sede, Vaticano, Ciudad del Vaticano",
	"Honduras",
	"Hong Kong",
	"Hungría",
	"Islandia",
	"India",
	"Indonesia",
	"Irán",
	"Iraq",
	"Irlanda",
	"Israel",
	"Italia",
	"Jamaica",
	"Japón",
	"Jordania",
	"Kazajstán",
	"Kenia",
	"Kiribati",
	"Corea del Norte",
	"Corea del Sur",
	"Kosovo",
	"Europa del Sur",
	"Kuwait",
	"Kirguistán",
	"Laos; oficialmente: República Democrática Popular Lao",
	"Letonia",
	"Líbano",
	"Lesotho",
	"Liberia",
	"Libia",
	"Liechtenstein",
	"Lituania",
	"Luxemburgo",
	"Macao",
	"Macedonia",
	"Madagascar",
	"Malawi",
	"Malasia",
	"Maldivas",
	"Malí",
	"Malta",
	"Islas Marshall",
	"Martinica",
	"Mauritania",
	"Mauricio",
	"Mayotte",
	"México",
	"Micronesia, Estados Federados de",
	"Moldavia",
	"Mónaco",
	"Mongolia",
	"Montenegro",
	"Montserrat",
	"Marruecos",
	"Mozambique",
	"Myanmar, Birmania",
	"Namibia",
	"Nauru",
	"Nepal",
	"Países Bajos, Holanda",
	"Antillas Holandesas",
	"Nueva Caledonia",
	"Nueva Zelanda",
	"Nicaragua",
	"Niger",
	"Nigeria",
	"Niue",
	"Marianas del Norte",
	"Noruega",
	"Omán",
	"Pakistán",
	"Palau",
	"Territorios Palestinos",
	"Panamá",
	"Papúa-Nueva Guinea",
	"Paraguay",
	"Perú",
	"Filipinas",
	"Isla Pitcairn",
	"Polonia",
	"Portugal",
	"Puerto Rico",
	"Qatar",
	"Reunión",
	"Rumanía",
	"Federación Rusa",
	"Ruanda",
	"San Cristobal y Nevis",
	"Santa Lucía",
	"San Vincente y Granadinas",
	"Samoa",
	"San Marino",
	"Santo Tomé y Príncipe",
	"Arabia Saudita",
	"Senegal",
	"Serbia",
	"Seychelles",
	"Sierra Leona",
	"Singapur",
	"Eslovaquia",
	"Eslovenia",
	"Islas Salomón",
	"Somalia",
	"Sudáfrica",
	"Sudán del Sur",
	"España",
	"Sri Lanka",
	"Sudán",
	"Surinam",
	"Swazilandia",
	"Suecia",
	"Suiza",
	"Siria",
	"Taiwan",
	"Tadjikistan",
	"Tanzania",
	"Tailandia",
	"Tíbet",
	"Timor Oriental",
	"Togo",
	"Tokelau",
	"Tonga",
	"Trinidad y Tobago",
	"Túnez",
	"Turquía",
	"Turkmenistan",
	"Islas Turcas y Caicos",
	"Tuvalu",
	"Uganda",
	"Ucrania",
	"Emiratos Árabes Unidos",
	"Reino Unido",
	"Estados Unidos",
	"Uruguay",
	"Uzbekistán",
	"Vanuatu",
	"Ciudad del Vaticano",
	"Venezuela",
	"Vietnam",
	"Islas Virgenes Británicas",
	"Islas Virgenes Americanas",
	"Wallis y Futuna",
	"Sáhara Occidental",
	"Yemen",
	"Zambia",
	"Zimbabwe"
  )
}
