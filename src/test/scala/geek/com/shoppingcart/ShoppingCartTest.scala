package geek.com.shoppingcart


import org.specs2.mutable.Specification

class ShoppingCartTest extends Specification {

  "Price of an Apple" in {
    ShoppingCart.getPrice("apple") must be equalTo 0.60
  }

  "Price of an Orange" in {
    ShoppingCart.getPrice("orange") must be equalTo 0.25
  }

  "Price should be zero if it doesn't exist" in {
    ShoppingCart.getPrice("None") must be equalTo 0
  }

  "Price should work for both upper and lower case of items in the shop" in {
    ShoppingCart.getPrice("APPLE") must be equalTo 0.60
    ShoppingCart.getPrice("ORANGE") must be equalTo 0.25
  }


  "Price of 4 Apples to Checkout" in {
    ShoppingCart.checkout(Array("apple", "apple", "apple", "apple")) must be equalTo 2.4
  }

  "Price of 5 Apples to Checkout" in {
    ShoppingCart.checkout(Array("apple", "apple", "apple", "apple", "apple")) must be equalTo 3.0
  }

  "Price of 6 Apples to Checkout" in {
    ShoppingCart.checkout(Array("apple", "apple", "apple", "apple", "apple", "apple")) must be equalTo 3.6
  }

  "Price of 4 Oranges to Checkout" in {
    ShoppingCart.checkout(Array("orange", "orange", "orange", "orange")) must be equalTo 1
  }

  "Price of 5 Oranges to Checkout" in {
    ShoppingCart.checkout(Array("orange", "orange", "orange", "orange", "orange")) must be equalTo 1.25
  }

  "Price of 6 Oranges to Checkout" in {
    ShoppingCart.checkout(Array("orange", "orange", "orange", "orange", "orange", "orange")) must be equalTo 1.5
  }

  "Price of 1 Orange and 1 apple to Checkout" in {
    ShoppingCart.checkout(Array("orange", "apple")) must be equalTo 0.85
  }

  "Price of 2 apples and 1 orange to Checkout" in {
    ShoppingCart.checkout(Array("orange", "apple", "apple")) must be equalTo 1.45
  }

  "Price of 2 oranges and 2 apples to Checkout" in {
    ShoppingCart.checkout(Array("orange", "orange", "apple", "apple")) must be equalTo 1.70
  }
}
