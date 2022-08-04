package com.bitkraft.solution.arraypart1

object BestTimeToBuyStocks {
  def getMin(a: Int, b: Int): Int = {
    if(a > b){
      b
    } else { a }
  }
  def getMax(a: Int, b: Int): Int = {
    if(a > b){
      a
    } else { b }
  }
  def getMaxProfit(prices: Array[Int]): Int = {
    var max_profit: Int = 0
    var min_price = Int.MaxValue
    for (idx <- prices.indices) {
      min_price = getMin(min_price, prices(idx))
      max_profit = getMax(max_profit, prices(idx) - min_price)
    }
    max_profit
  }

  def main(args: Array[String]): Unit = {
    //val array = Array(7,1,5,3,6,4)
    //val array = Array(7,6,4,3,1)
    //val array = Array(2, 4, 1)
    //val array = Array(2, 1, 4)
    val array = Array(3,3,5,0,0,3,1,4)
    val result = getMaxProfit(array)
    println(result)
  }
}