package com.knoldus


object IOBasedOperationDriver extends App {
  val classObject =new IOBasedOpearation
  val listOfFileInDirectory= classObject.getListOfFile("/home/knoldus/Downloads/assignment-scala01-1.zip/TestThread/src/main/scala/com/knoldus/")

  val listOfUpdatedFile =classObject.transformFile(listOfFileInDirectory,"/home/knoldus/Downloads/assignment-scala01-1.zip/TestThread/src/main/scala/com/",List.empty[String])
  classObject.wordCount("/home/knoldus/Downloads/assignment-scala01-1.zip/TestThread/src/main/scala/com/knoldus/ConnectionTrait.scala","/home/knoldus/Downloads/assignment-scala01-1.zip/TestThread/src/main/scala/com/")

}
