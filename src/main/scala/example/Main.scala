package example

import java.util.Date

object Main {

  def math(x: Double, y: Double, z: Double, f: (Double, Double) => Double): Double = f(f(x,y), z)

  def logPartiallyAppliedFunc(date: Date, message: String): Unit = {
    println(date + "   " + message)
  }

  def add(x: Int, y: Int) = x + y
  def addCurry(x: Int) = (y: Int) => x + y
  def addCurryShorter(x: Int) (y: Int) = x + y

  var number = 10
  val add: Int => Int = (x: Int) => {
    number = x + number
    number
  }

  def main(args: Array[String]): Unit = {
    println("\nHiger Order Functions")
    // val result = math(50, 20, 10, (x,y) => x max y)
    // the same by using syntactic sugar
    val result = math(50, 20, 10, _ max _)
    println(result)


    println("\nPartially Applied Functions")
    val sum = (a: Int, b: Int, c: Int) => a + b + c
    println(sum(10, 20, 30)) // fully applied function, provide params to all args
    val f = sum(10, _, _: Int) // _ as wild card, partially applied function
    println(f(20, 30))

    val date = new Date
    val newLog = logPartiallyAppliedFunc(date, _: String)
    newLog("The message 1")
    newLog("The message 2")
    newLog("The message 3")


    println("\nHow to use closures in Scala")
    println("\nA closure is a function which uses one or more" +
      "variables declared outside this function")
    number = 100
    println(add(20))


    println("\nFunction Currying in Scala")
    println("\nCurrying is the technique of " +
      "transforming a function that takes multiple arguments " +
      "into a function that takes a single argument" +
      "")
    println(add(20, 10))
    println(addCurry(20)(10))
    val sum40 = addCurry(40)
    println(sum40(100))
    println(addCurryShorter(100)(200))
    val sum50 = addCurryShorter(50)_ // need to provide wild char if use scala curry syntax
    println(sum50(400))


    println("\nStrings")
    val num1 = 75
    val num2 = 100.25
    val str1: String = "Hello World"
    val str2: String = " Max"
    println(str1.length())
    println(str1.concat(str2))

    val str: Unit = printf("(%d -- %f -- %s", num1, num2, str1)
    println(str)
    println("(%d -- %f -- %s".format(num1, num2, str1))


    println("\nArray: Fixed size and same data type")
    val myArr: Array[Int] = new Array[Int](4) // default value of Array datatype initialized
    val myArray2 = new Array[Int](5)
    myArr(0) = 20
    myArr(1) = 30
    myArr(2) = 40
    myArr(3) = 50
    println(myArr) // print address of array
    for (x <- myArr) {
      println(x)
    }
    for (i <- myArr.indices) { // i <- 0 to (myArr-1)
      println(myArr(i))
    }


    println("\nLists: Collection of same data type element," +
      "array are mutable, list are immutable (linked list)")
    val myList: List[Int] = List(1, 2, 4, 5, 6,7, 8)
    val names: List[String] = List("Max", "Tom", "John")
    println(0 :: myList) // :: is a cons, prepend 0 to list and output, not change the original list
    println(myList)
    println(names)
    println(1 :: 5 :: 9 :: Nil) // List(1, 5, 9)
    println(myList.head) // 1
    println(myList.tail) // 2, 4, 5, 6,7, 8
    println(myList.isEmpty)
    println(List.fill(5)(2)) // 2, 2, 2, 2, 2
    myList.foreach( println )

    var sumTotal : Int = 0
    myList.foreach( sumTotal += _)
    println(sumTotal)

    for (name <- names) println(name)

    println(names(2))


    println("\nScala Sets")
    println("A collection of different elements of same data types," +
      "cannot have duplicate values inside them," +
      "by default immutable," +
      "not ordered, can't use index" +
      "")
    val mySet: Set[Int] = Set(1, 2, 3, 4, 5, 5) // 1, 2, 3, 4, 5 (no duplicate element
    val mySet2: Set[Int] = Set(6,5,4,3,6,7)
    var mySetMutable = scala.collection.mutable.Set(1, 2, 3, 4, 5, 5)
    val namesSet: Set[String] = Set("Max", "Tom", "John")
    println(mySet + 10) // 5, 10, 1, 2, 3, 4
    println(mySet)      // 5, 1, 2, 3, 4
    println(mySet(8))   // false, check if element exists in index
    println(mySet.head)
    println(mySet.tail)
    println(mySet.isEmpty)

    println(mySet ++ mySet2) // concat sets
    println(mySet.++(mySet2))
    println(mySet.&(mySet2)) // give the intersection of 2 set (values that exist in both set)
    println(mySet.intersect(mySet2))
    println(mySet.max)
    println(mySet.min)


    println("\nScala Maps")
    println("Collection of key-value pairs," +
      "keys are unique in maps")
    val myMap: Map[Int, String] = {
      Map(801 -> "Max", 802 -> "Tom", 804 -> "June")
    }
    val myMap2: Map[Int, String] = {
      Map(805 -> "Bob")
    }
    println(myMap)
    println(myMap(801))
    println(myMap.keys) // Set(801, 802, 804)
    println(myMap.values)
    println(myMap.isEmpty)

    myMap.keys.foreach { key =>
      println("key " + key + ", value " + myMap(key))
    }

    println(myMap.contains(801))
    println(myMap ++ myMap2)


    println("\nScala Tuples")
    println("A class that can contain different kind of element," +
      "immutable")
    val myTuple = (1, 2, "Hello", true)
    val myTuple2 = new Tuple2(1, 2)
    val myTuple3 = new Tuple3(1, 2, "Hello") // up to 22 element in Tuple
    val myTuple4 = new Tuple4(1, 2, "Hello", (2, 3))
    println(myTuple)
    println(myTuple._1)
    println(myTuple._2)
    println(myTuple._3) // Hello
    println(myTuple._4)

    myTuple.productIterator.foreach {
      i => println(i)
    }
    println(1 -> "Tom") // create a Tuple (1,Tom)
    println(1 -> "Tom" -> true) // ((1,Tom),true)

    println(myTuple4._4._2) // 3


    println("\nScala Options Type")
    println("A container which cah give you two values," +
      "it can give you an instance of Some or None")
    val lst = List(1, 2, 3)
    val map = Map(1 -> "Tom", 2 -> "Max", 3 -> "John")
    val opt: Option[Int] = Some(5)
    val opt2: Option[Int] = None
    println(lst.find(_ > 6)) // return Option[Int] type -> None
    println(lst.find(_ > 2).get) // 3
    println(map.get(1)) // Some(Tom)
    println(map.getOrElse(5, "No name found"))

    println(opt2.isEmpty) // true



    println("\nScala map flatten and filter")
    println("Map: iterate over a collection, then apply a func to each element of that collection")
    val lst2 = List(1, 2, 3, 5, 6, 8, 20)
    val map2 = Map(1 -> "Tom", 2 -> "Max", 3 -> "John")
    println(lst2.map(_ * 2)) // List(2, 4, 6, 10, 12, 16, 40)
    // println(lst2.map(x => x * 2)) // the same result
    // println(myMap.mapValues(x => "hi" + x)) // deprecated?
    println("hello".map(_.toUpper)) // HELLO

    println(List(List(1, 2, 3), List(3, 4, 5)).flatten) // 1, 2, 3, 3, 4, 5
    println(lst2.flatMap(x => List(x, x+1 ))) // map then flatten
                                              // List(1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 20, 21)
    println(lst2.map(x => List(x, x+1))) // List(List(1, 2), List(2, 3), List(3, 4), List(5, 6), List(6, 7), List(8, 9), List(20, 21))

    // predicate is a function that returns a boolean value
    // filter is used with predicate
    println(lst2.filter(x => x%2 == 0)) // List(2, 6, 8, 20)



    println("\nScala Reduce, fold or scan (Left/Right)")
    println("Reduce: takes an associative binary operator function as a parameter " +
      "and apply it to elements of array")
    val lst3 = List(1, 2, 3, 5, 7, 10, 13)
    val lst4 = List("A", "B", "C")
    println(lst3.reduceLeft(_ + _)) // 41
    println(lst3.reduceLeft((x,y) => {
      println(x+", " + y)
      x + y
    }))
    println(lst4.reduceLeft(_ + _)) // ABC

    println(lst3.reduceLeft(_ - _)) // -39
    println(lst3.reduceRight(_ - _)) // 7
    println(lst3.reduceRight((x,y) => {
      println(x+", " + y)
      x - y
    }))

    // the same as reduce with a start value
    println(lst3.foldLeft(0)(_ + _)) // 41
    println(lst4.foldLeft("z")(_ + _)) // zABC

    // scan: give the map of intermediate result
    println(lst3.scanLeft(100)(_ + _)) // List(100, 101, 103, 106, 111, 118, 128, 141)
    println(lst4.scanLeft("z")(_ + _)) // List(z, zA, zAB, zABC)
  }
}








