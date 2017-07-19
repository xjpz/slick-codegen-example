object Tables extends {
  // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  val profile = slick.jdbc.MySQLProfile
} with demo.Tables


import Tables.profile.api._
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps


object Example extends App {

  var url = "jdbc:mysql://127.0.0.1:3306/blog"
  val username = "root"
  val pwd = "123456"

  val db = Database.forURL(url = url, user = username, password = pwd, driver = "com.mysql.jdbc.Driver")
  //   Using generated code. Our Build.sbt makes sure they are generated before compilation.
  val q = Tables.User.filter(_.id === 1).map(_.name).result.headOption

  println(Await.result(db.run(q), 60 seconds))

}
