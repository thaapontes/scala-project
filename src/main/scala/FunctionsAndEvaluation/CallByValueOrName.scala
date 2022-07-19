package FunctionsAndEvaluation

object CallByValueOrName extends App {

  def callByValueFunctionExample(x: Int): Int = x + 1

  /*
  CALL BY VALUE
  2+3 will be evaluated BEFORE calling the function with the result as a parameter
  2+3 THEN callByValueFunctionExample(5)
   */
  callByValueFunctionExample(2+3)

  def callByNameFunctionExample(x: => Int): Int = x + 1
  /*
  CALL BY NAME
  2+3 will be evaluated EVERY time is used in the function
  2+3 is passed LITERALLY
   */
  callByNameFunctionExample(2+3)

  /*
  Call by name tricks
  #1 - Reevaluation: the parameter value can change every time is called (not stable even inside the function)
  #2 - Call by need: not evaluated until is used, combine call by name with lazy val
   */


}
