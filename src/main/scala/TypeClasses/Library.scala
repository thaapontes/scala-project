package TypeClasses

object Library extends App {
  trait Library[T]{
    def genre(value: T): String
  }
}
