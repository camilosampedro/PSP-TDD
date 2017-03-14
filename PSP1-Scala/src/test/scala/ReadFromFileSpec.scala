import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
  * ReadFromFileSpec
  */
class ReadFromFileSpec extends FeatureSpec with GivenWhenThen {


  info("As a user from PSP1")
  info("I want to calculate the mean of a file compound by decimal numbers")
  info("So I don't have to type them manually")
  info("And save my time")

  feature("Calculate mean") {
    scenario("User sends a file with the numbers, one per line") {
      val fileName = getClass.getResource("test.txt").getFile
      Given("the file is not empty")
      assert(scala.io.Source.fromFile(fileName).getLines().nonEmpty)
      Given("the file has just numbers")
      assert(!scala.io.Source.fromFile(fileName).getLines().exists(!ReadFromFile.isAllDigits(_)))
      When("the mean is calculated for that file")
      val list = ReadFromFile.getListFromFile(fileName)
      val mean = list.mean
      Then("the result should be a decimal number")
      assert(mean.isInstanceOf[Double])
    }
  }
}
