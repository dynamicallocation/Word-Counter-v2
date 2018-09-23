import scala.io.Source
import scala.collection.mutable.ListBuffer

object Hello extends App
{
    var head = new ListBuffer[String]
    val bufferedSource = Source.fromFile("texting.txt").getLines.flatMap(_.split("\\W+"))
    //Garret Hall https://stackoverflow.com/questions/15487413/scala-beginners-simplest-way-to-count-words-in-file
    val freq = scala.collection.mutable.Map[String,Integer]()
    for(word <- bufferedSource){
        
        head += word
        
    }
    //bufferedSource.close
    

    //scala cookbook Chapter 12 
    /* for((e,count) <- head.zipWithIndex)
     {
    
         val words = head.remove(count)
         if(freq.contains(word))
            freq.put(word,freq(word)+ 1)
         else
            freq.put(word,1)
         
         
     }*/
   val map = head.groupBy(identity).mapValues(_.size)
   
   for ((k,v) <- map) println(s"key : $k, value: $v")
   
    //ohruunuruus https://stackoverflow.com/questions/15487413/scala-beginners-simplest-way-to-count-words-in-file
    
    
}