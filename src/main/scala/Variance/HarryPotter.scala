package Variance

object HarryPotter extends App {

  trait House {
    def name: String
  }
  class Gryffindor extends House {
    override def name: String = "gryffindor"
  }
  class Hufflepuff extends House {
    override def name: String = "hufflepuff"
  }
  class Ravenclaw extends House {
    override def name: String = "ravenclaw"
  }
  class Slytherin extends House {
    override def name: String = "slytherin"
  }

//  Covariance: Gryffindor is a type of House
  class HousesList[+T]{
    def addHouse[P >: T](element: P): HousesList[P] = new HousesList[P]
    def getName[P >: T](element: P): String = element.toString
}

  val ch: HousesList[House] = new HousesList[Gryffindor]
  println(ch)

  val emptyList = new HousesList[Gryffindor]
  val houses = emptyList.addHouse(new Hufflepuff)
  val moreHouses = houses.addHouse(new Ravenclaw)
  val evenMoreHouses = moreHouses.addHouse(new Slytherin)

//  println(evenMoreHouses.getName)
}
