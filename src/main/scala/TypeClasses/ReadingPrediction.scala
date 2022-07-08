package TypeClasses

object ReadingPrediction extends App {

  trait Technical
  trait Fiction

  trait ReadingPrediction[T] {
    def predictReadingTime(numberOfPages: Int): Double
  }

  implicit object TechnicalBookPrediction extends ReadingPrediction[Technical]{
    override def predictReadingTime(numberOfPages: Int): Double = numberOfPages*2.0
  }

  implicit object FictionBookPrediction extends ReadingPrediction[Fiction]{
    override def predictReadingTime(numberOfPages: Int): Double = numberOfPages*0.5
  }

  def predict[T](numberOfPages: Int)(implicit bookName: ReadingPrediction[T]): Double = {
    bookName.predictReadingTime(numberOfPages)
  }

  object TheDataWarehouseToolkit extends Technical
  object HarryPotter extends Fiction

//  val theDataWarehouseToolkit: ReadingPrediction[Technical] = new ReadingPrediction[Technical] {
//    override def predictReadingTime(numberOfPages: Int): Double = 32
//  }

//  TheDataWarehouseToolkit.predict(32)
}
