package demo;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepDefs {

	private MyAppDriver driver;

	@Before
	public void init() {
		driver = new MyAppDriver();
	}

	@Given("^I am at the google homepage$")
	public void i_am_at_the_google_homepage() throws Throwable {
		driver.open("http://www.google.com");
	}

	@When("^search for (.*)$")
	public void search_for_cucumber(String query) throws Throwable {
		driver.search(query);
	}

	@Then("^I shoud see several results$")
	public void i_shoud_see_several_results() throws Throwable {
		driver.assertThatElementsAreFound();
	}

	@After
	public void cleanup() {
		driver.closeApp();
	}

}
