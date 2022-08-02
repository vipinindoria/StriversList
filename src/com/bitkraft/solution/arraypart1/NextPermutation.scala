package com.bitkraft.solution.arraypart1

object NextPermutation {
  def swap(array: Array[Int], i: Int, j: Int): Array[Int] = {
    val tmp = array(i)
    array(i) = array(j)
    array(j) = tmp
    array
  }

  def reverse(array: Array[Int], i: Int, j: Int): Array[Int] = {
    var a: Int = i
    var b: Int = j
    while (a < b) {
      swap(array, a, b)
      a = a + 1
      b = b - 1
    }
    array
  }

  def getNextPermutation(nums: Array[Int]): Array[Int] = {
    var idx1: Int = nums.length - 2

    while(idx1 >= 0 && nums(idx1) > nums(idx1 + 1)) {
      idx1 = idx1 -1
    }
    if (idx1 >= 0) {
      var idx2: Int = nums.length - 1
      while (nums(idx2) <= nums(idx1)) {
        idx2 = idx2 - 1
      }
      swap(nums, idx1, idx2)
    }
    reverse(nums, idx1 + 1, nums.length - 1)
    nums
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 3, 2)
    val result = getNextPermutation(array)
    println(result.mkString(", "))
  }
}