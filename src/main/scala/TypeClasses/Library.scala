package TypeClasses

// Reference: https://www.baeldung.com/scala/type-classes

object Library extends App {

  case class Book(name: String) {
    def authorName: String = name match {
      case "Harry Potter" => "J.K Rowling"
      case "Twilight" => "Stephenie Meyer"
    }

    def genreName: String = name match {
      case "Harry Potter" => "adventure"
      case "Twilight" => "fantasy"
    }

    def numberOfPages: Int = name match {
      case "Harry Potter" => 300
      case "Twilight" => 400
    }
  }

  trait Library[T]{
    def getType(value: T): String
  }

  def getBookInfo[T](value: T)(implicit library: Library[T]): Unit = println(library.getType(value))

  implicit val book: Library[Book] = new Library[Book] {
    def getType(value: Book): String = s"Book: ${value.name}, Author: ${value.authorName}, Genre: ${value.genreName}, Number of Pages: ${value.numberOfPages}"
  }

  getBookInfo(Book("Harry Potter"))
}
