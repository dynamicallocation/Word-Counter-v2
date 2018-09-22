import scala.io.Source

object Hello extends App
{
    val bufferedSource = Source.fromFile("texting.txt");
    for(line <- bufferedSource.getLines){
        println(line.toUpperCase)
    }
    bufferedSource.close
    //scala cookbook Chapter 12 
}