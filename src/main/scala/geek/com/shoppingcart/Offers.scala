package geek.com.shoppingcart


object Offers {

  def buyOneGetOneFree(numOfItems: Int, priceOfOne: Double) : Double = {
    ((numOfItems / 2) + (numOfItems % 2)) * priceOfOne
  }

  def ThreePriceOfTwo(numOfItems: Int, priceOfOne: Double) : Double = {
    (2 * (numOfItems/3) + (numOfItems %3)) * priceOfOne
  }

  def offer(item: String): Int => Double = {
    val price: Double = ShoppingCart.getPrice(item)
    item toLowerCase() match {
      case "apple" => (numOfItems:Int) => buyOneGetOneFree(numOfItems, price)
      case "orange" => (numOfItems:Int) => ThreePriceOfTwo(numOfItems, price)
      case _ => (numberOfItems:Int) => numberOfItems * price
    }
  }
}
