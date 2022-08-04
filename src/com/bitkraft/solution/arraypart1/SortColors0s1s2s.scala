package com.bitkraft.solution.arraypart1

import scala.collection.mutable.ListBuffer

object SortColors0s1s2s {
  def swap(array: Array[Int], i: Int, j: Int): Array[Int] = {
    val tmp = array(i)
    array(i) = array(j)
    array(j) = tmp
    array
  }

  def getSortedArray(nums: Array[Int]): Array[Int] = {
    var low: Int = 0
    var mid: Int = 0
    var high: Int = nums.length - 1

    while(mid <= high) {
      if(nums(mid) == 0) {
        swap(nums, low, mid)
        low += 1
        mid += 1
      } else if(nums(mid) == 1) {
        mid += 1
      } else {
        swap(nums, mid, high)
        high -= 1
      }
    }
    nums
  }

  def main(args: Array[String]): Unit = {
    val array = Array(2,0,2,1,1,2)
    val result = getSortedArray(array)
    println(result.mkString(", "))
  }
}