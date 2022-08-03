package com.bitkraft.solution.arraypart1

import scala.collection.mutable.ListBuffer

object KadanesAlgorithmMaximumSubArray {
  def getMaxSubArray(nums: Array[Int]): Int = {
    var sub_array: ListBuffer[Int] = ListBuffer[Int]()
    var max_so_far: Int = Int.MinValue
    var max_end_here: Int = 0
    var start_idx: Int = 0

    for(idx <- nums.indices) {
      max_end_here = max_end_here + nums(idx)

      if(max_end_here > max_so_far) {
        sub_array.clear()
        max_so_far = max_end_here
        sub_array += start_idx
        sub_array += idx
      }

      if(max_end_here < 0) {
        max_end_here = 0
        start_idx = idx + 1
      }
    }
    max_so_far
  }

  def main(args: Array[String]): Unit = {
    //val array = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val array = Array(-2, -1, -1)
    val result = getMaxSubArray(array)
    println(result)
  }
}