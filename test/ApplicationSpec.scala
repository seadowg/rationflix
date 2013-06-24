package test

import org.scalatest.FunSpec

import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends FunSpec {
  
  describe("Application") {
    
    it("sends 404 on a bad request") {
      running(FakeApplication()) {
        assert(route(FakeRequest(GET, "/boum")).isEmpty)
      }
    }

    describe("index action") {

      it ("welcome the user") {
        running(FakeApplication()) {
          val home = route(FakeRequest(GET, "/")).get

          assert(status(home) == OK)
          assert(contentType(home).get == "text/html")
          assert(contentAsString(home).contains("Welcome to Rationflix"))
        }
      }
    }
  }
}