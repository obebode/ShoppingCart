package geek.com.shoppingcart

import org.specs2.mutable.Specification

class OffersTest extends Specification {

  "Price of 2 apples should be 0.60 on the buy one get one free offer" in {
    Offers.buyOneGetOneFree(2, 0.60) must be equalTo 0.60
  }

  "Price of 3 apples should be 1.20 on the buy one get one free offer" in {
    Offers.buyOneGetOneFree(3, 0.60) must be equalTo 1.20
  }

  "Price of 3 oranges should be 0.50 on the buy 2 oranges for the price of 3 offer" in {
    Offers.ThreePriceOfTwo(3, 0.25) must be equalTo 0.50
  }

  "Price of 4 oranges should be 0.75 on the buy 2 oranges for the price of 3 offer" in {
    Offers.ThreePriceOfTwo(4, 0.25) must be equalTo 0.75
  }
  "Price of 5 oranges should be 1.00 on the buy 2 oranges for the price of 3 offer" in {
    Offers.ThreePriceOfTwo(5, 0.25) must be equalTo 1.00
  }

  "Buy One Get One free offer on Apples" in {
    Offers.offer("apple")(2) must be equalTo ShoppingCart.getPrice("apple")
  }

  "Buy Two and get Three  offer on Oranges" in {
    Offers.offer("orange")(3) must be equalTo (2 * ShoppingCart.getPrice("orange"))
  }

  "Buy One Orange and pay the normal price 0.25" in {
    Offers.offer("orange")(1) must be equalTo ShoppingCart.getPrice("orange")
  }
}
