package com.bitkraft.solution.arraypart1

import scala.collection.mutable.ListBuffer

object PascalTriangle {
  def getPascalTriangle(numRows: Int): List[List[Int]] = {
    var pascal_triangle: ListBuffer[ListBuffer[Int]] = new ListBuffer[ListBuffer[Int]]()

    for(row_idx <- 0 until numRows) {
      var row: ListBuffer[Int] = ListBuffer(1)
      for(col_idx <- 1 until row_idx) {
        row += pascal_triangle(row_idx-1)(col_idx-1) + pascal_triangle(row_idx-1)(col_idx)
      }
      if (row_idx != 0) {
        row += 1
      }
      pascal_triangle += row
    }
    pascal_triangle.map(row => row.toList).toList
  }

  def main(args: Array[String]): Unit = {
    val result = getPascalTriangle(6)
    result.foreach(row => println(row.mkString(", ")))
  }
}