package com.knoldus

import java.io.{File, FileWriter}


trait ConnectionTrait {
  def getListOfFile(dir: String): List[File]

  def readAndTransform(filename: File, outputDir: String): String

  def wordCount(fileName: String, outputDir: String): Map[String, Int]
}
