package geek.com.shoppingcart


import scala.math.BigDecimal.RoundingMode


object ShoppingCart {

  private val priceList: Map[String, Double] = Map("apple" -> 0.60, "orange" -> 0.25)

  def price(item: String): Option[Double] = priceList.get(item toLowerCase())

  def getPrice(item: String): Double = {
    priceList.getOrElse(item toLowerCase(), 0)
  }

  def checkout(items: Array[String]): Double = {
    val totalCost = items.flatMap(price).sum
    BigDecimal(totalCost).setScale(2, RoundingMode.HALF_EVEN).toDouble
  }

  def checkoutOffers(items: Array[String]): Double = {
    val numOfApples: Int = items.count(p => p.equalsIgnoreCase("apple"))
    val numOfOranges: Int = items.count(p => p.equalsIgnoreCase("orange"))

    val totalCost = Offers.offer("apple")(numOfApples) + Offers.offer("orange")(numOfOranges)

    BigDecimal(totalCost).setScale(2, RoundingMode.HALF_EVEN).toDouble
  }

}