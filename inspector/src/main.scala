import scala.quoted.Quotes
import scala.quoted.quotes
import scala.tasty.inspector as ins

class MyInspector extends ins.Inspector:
  def inspect(using Quotes)(tastys: List[ins.Tasty[quotes.type]]): Unit =
    println(tastys.length)
    for tasty <- tastys do
      println(tasty.ast.pos.sourceFile)



def main(args: Array[String]): Unit =
  ins.TastyInspector.inspectTastyFilesInJar(
    args.head
  )(new MyInspector)

