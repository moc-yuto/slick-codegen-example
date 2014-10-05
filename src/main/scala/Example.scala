object Tables extends{ // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  val profile = scala.slick.driver.MySQLDriver  
} with demo2.Tables
import Tables._
import Tables.profile.simple._

object Example extends App {
  val url = "jdbc:mysql://localhost/test"
  val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver", user = "root", password = "rootpasswd")

  // Using generated code. Our Build.sbt makes sure they are generated before compilation.
  db.withSession { implicit session =>
    println(IntTable.filter(_.id === 1).run)
  }
}
