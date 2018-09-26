import scala.io.Source
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListMap
import scala.collection.mutable.Stack

object Main extends App
{
   
   
    
     val bufferedSource = Source.fromFile("texting.txt").getLines.flatMap(_.split("\\W+"))
    //Garret Hall https://stackoverflow.com/questions/15487413/scala-beginners-simplest-way-to-count-words-in-file
    val freq = scala.collection.mutable.Map[String,Integer]()
    val wordList = scala.collection.mutable.ArrayBuffer[String]()
    val reserveList = scala.collection.mutable.ArrayBuffer[String]()
    var countStack = Stack[String]()
    
    var length = args(0).toInt
    var lastWords = args(1).toInt
    var topWords = args(2).toInt
    
    for(word <- bufferedSource){
        
       if(word.length > length)
       {
           
           if(wordList.size >= lastWords)
           {
              reserveList += wordList.remove(0)
           }
            wordList += word
    
        }
        
    }

        val totalList = wordList ++ reserveList;

   
   val hmap = totalList.groupBy(i => i).mapValues(_.size)
    //credit to 
    //username: noego
    //link: https://stackoverflow.com/questions/11448685/scala-how-can-i-count-the-number-of-occurrences-in-a-list
  
   val x = collection.mutable.ListMap(hmap.toSeq.sortBy(_._2):_*)
   
   
   
    for ((k,v) <- x) countStack.push(k,v.toString)
    
    var count = 0
    for(count <- 1 to topWords)
    {
        val key = countStack.pop()
        val value = countStack.pop()
        printf(value + " " + key + "\n")
    }
   
    
    //Acknowledgements: Much of the boilerplate code that helped with the project was given by Alvin Alexander author of the Scala Cookbook
    //11.5 Concatenating lists
    //11.8 ArrayBuffer 
    //11.17 Traversing a Map 
}