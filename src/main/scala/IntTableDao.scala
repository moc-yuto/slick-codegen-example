object Tables extends{ // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  val profile = scala.slick.driver.MySQLDriver  
} with demo2.Tables
import Tables._
import Tables.profile.simple._
import scala.slick.collection.heterogenous._
import syntax._

object IntTableDao {
  val url = "jdbc:mysql://localhost/test"
  val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver", user = "root", password = "rootpasswd")

  // Using generated code. Our Build.sbt makes sure they are generated before compilation.
  def byId(id: Int) = db.withSession { implicit session =>
    println(IntTable.filter(_.id === 1).run)
  }

  def insert(row: IntTableRow) = db.withSession { implicit session =>
    IntTable.insert(row)
  }

  def main(args: Array[String]){
    byId(1)
    insert(2 :: Some(2) :: Some(3) :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: None :: HNil)
  }
}
