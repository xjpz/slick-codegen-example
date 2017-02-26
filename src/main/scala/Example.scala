object Tables extends {
  // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  val profile = slick.driver.MySQLDriver
} with demo.Tables


import Tables.profile.api._
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps


object Example extends App {
  //   connection info for a pre-populated throw-away, in-memory db for this demo, which is freshly initialized on every run
  //  val url = "jdbc:h2:mem:test;INIT=runscript from 'src/main/sql/create.sql'"
  //  val db = Database.forURL(url, driver = "org.h2.Driver")

  var url = "jdbc:mysql://127.0.0.1:3306/blog"
  val username = "root"
  val pwd = "123456"


  val db = Database.forURL(url = url, user = username, password = pwd, driver = "com.mysql.jdbc.Driver")
  ////   Using generated code. Our Build.sbt makes sure they are generated before compilation.
  val q = Tables.User.filter(_.id === 1).map(_.name).result.headOption

  println(Await.result(db.run(q), 60 seconds))

}
