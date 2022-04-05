package TypeClasses

// Reference: https://www.baeldung.com/scala/type-classes

object Library extends App {

//  case class Genre(name: String)
//  case class Location(name: String)
//  case class Size(size: Int)
  case class Public(name: String)
  case class Private(name: String)

  trait Library[T]{
    def getType(value: T): String
  }

  def show[T](value: T)(implicit library: Library[T]): Unit = println(library.getType(value))

  implicit val publicLibrary: Library[Public] = new Library[Public] {
    def getType(value: Public): String = s"Type: ${value.name}"
  }

  implicit val privateLibrary: Library[Private] = new Library[Private] {
    def getType(value: Private): String = s"Type: ${value.name}"
  }

  show(Public("public"))
  show(Private("private"))
}
