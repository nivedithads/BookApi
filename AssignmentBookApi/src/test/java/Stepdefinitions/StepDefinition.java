package Stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.databind.JsonNode;

import Book.values.Id;
import Book.values.SelfLink;
import BookTests.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {
	Id id;
	SelfLink selfLink;
	JsonNode jsonNode;

	@Given("Request to Google Books Api")
	public void request_to_google_books_api() throws IOException, InterruptedException {
		jsonNode = jsonNodeofUrl();
		// throw new io.cucumber.java.PendingException();
	}

	@When("Extract id from the Response")
	public void extract_id_from_the_response() {
	 id = new Id(jsonNode);
		// throw new io.cucumber.java.PendingException();
	}

	@Then("^verify (.+) is same as extracted id$")
	public void verify_id_is_same_as_extracted_id(String exp) throws IOException {
		String idValue = id.idData().toString();
		Assert.assertEquals(idValue, exp);
	}

	@When("Extract selflink from the Response")
	public void extract_selfLink_from_the_response() {
		selfLink = new SelfLink(jsonNode);
	}

	@Then("^verify (.+) is same as extracted selflink$")
	public void verify_books_volume_is_same_as_extracted_kind(String  expected) throws IOException {
		String selfLinkValue=selfLink.selfLinkData().toString();
	//	System.out.println(selfLinkValue);
		Assert.assertEquals(selfLinkValue, expected);
		
		
	}
}
