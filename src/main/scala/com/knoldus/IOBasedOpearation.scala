package com.knoldus

import scala.io.Source
import java.io.{File, FileWriter}


class IOBasedOpearation extends ConnectionTrait {

 override def getListOfFile(dir: String): List[File] = {
    val file = new File(dir)
    if (file.exists && file.isDirectory) {
      file.listFiles.toList
    } else {
      List[File]()
    }
  }

  override def readAndTransform(filename: File, outputDir: String): String = {
    val copyFileName = filename.getName
    val fw = new FileWriter(s"$outputDir/" + copyFileName)
    for (line <- Source.fromFile(filename.toString).getLines) {
      fw.write(line.toUpperCase() + "\n")
      println(line)
    }
    fw.close()
    fw.toString
  }


  def transformFile(listOfFile: List[File], outputDir: String, resultedString: List[String]): List[String] = {
    listOfFile match {
      case Nil => resultedString

      case head :: Nil if (head.isFile) => {
        val x: String = readAndTransform(head, outputDir)
        x :: resultedString
      }

      case head :: tail if (head.isFile) => {
        val x = readAndTransform(head, outputDir)
        transformFile(tail, outputDir, x :: resultedString)
      }
    }
  }

   override def wordCount(fileName: String, outputDir: String): Map[String, Int] = {
    val fw = new FileWriter(s"$outputDir/" + fileName.split("/").last)
    val resultMap: Map[String, Int] = scala.io.Source.fromFile(fileName).getLines.flatMap(_.split("[\" \" \\.]")).foldLeft(Map.empty[String, Int]) { (count, word) => count + (word.toLowerCase -> (count.getOrElse(word.toLowerCase, 0) + 1)) }

    fw.write(resultMap.toString())
    fw.close
    resultMap

  }

}

