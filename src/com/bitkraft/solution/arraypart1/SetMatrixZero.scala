package com.bitkraft.solution.arraypart1

object SetMatrixZero {

  // Approach 1
  /*def setZeroes(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val m = matrix.length
    val n = matrix(0).length

    var row_idx: Array[Int] = Array.fill(m) { -1 }
    var col_idx: Array[Int] = Array.fill(n) { -1 }

    for(row <- 0 until m) {
      for (col <- 0 until n) {
        if(matrix(row)(col) == 0) {
          row_idx(row) = 0
          col_idx(col) = 0
        }
      }
    }

    println(row_idx.mkString(", "))
    println(col_idx.mkString(", "))

    for(row <- 0 until m) {
      for (col <- 0 until n) {
        if(row_idx(row) == 0 || col_idx(col) == 0) {
          matrix(row)(col) = 0
        }
      }
    }
    matrix
  }*/

  // Approach 2
  def setZeroes(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val m = matrix.length
    val n = matrix(0).length
    var col0 = -1

    for(row <- 0 until m) {
      if (matrix(row)(0) == 0) { col0 = 0 }
      for (col <- 1 until n) {
        if(matrix(row)(col) == 0) {
          matrix(row)(0) = 0
          matrix(0)(col) = 0
        }
      }
    }

    for(row <- m-1 to 0 by -1) {
      for (col <- n-1 to 1 by -1) {
        if(matrix(row)(0) == 0 || matrix(0)(col) == 0) {
          matrix(row)(col) = 0
        }
      }
      if (col0 == 0) matrix(row)(0) = 0
    }
    matrix
  }

  def main(args: Array[String]): Unit = {
    //val matrix = Array(Array(1,1,1,1,1), Array(1,0,1,1,1), Array(1,1,1,0,1))
    //val matrix = Array(Array(1,1,1), Array(1,0,1), Array(1,0,1), Array(0,0,1))
    val matrix = Array(Array(0,1,2,0), Array(3,4,5,2), Array(1,3,1,5))
    val result = setZeroes(matrix)
    result.foreach(row => println(row.mkString(", ")))
  }
}