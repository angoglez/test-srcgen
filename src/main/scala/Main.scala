
import cats.effect._
import cats.implicits._
import higherkindness.droste.data._
import higherkindness.droste._
import higherkindness.droste.data.Mu
import higherkindness.skeuomorph.openapi.{JsonSchemaF, ParseOpenApi}

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {



    val parser  = ParseOpenApi.parseYamlOpenApi[IO, Mu[JsonSchemaF]]()


  }
}