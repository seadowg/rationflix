package test

import org.scalatest.FunSpec

import play.api.test._
import play.api.test.Helpers._

class IntegrationSpec extends FunSpec {
  
  describe("/index") {

    it("has the correct welcome message") {
      running(TestServer(3333), HTMLUNIT) { browser =>
        browser.goTo("http://localhost:3333/")
        assert(browser.pageSource.contains("Welcome to Rationflix"))
      }
    }
    
  }
  
}