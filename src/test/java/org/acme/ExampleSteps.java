package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ExampleSteps {
	String result;
	String person;

	HelloClient service = new HelloClient();

	@When("I call the hello service")
	public void iCallTheHelloService() {
		result = service.getHello();
	}

	@Then("I get the answer {string}")
	public void iGetTheAnswer(String string) {
		Assert.assertEquals(string,result);
	}

	@When("I call the getPerson service")
	public void iCallGetPerson() throws JsonProcessingException {
		person = JsonHelper.serialize(service.getPerson());
	}

	@Then("I get the person with name {string} and address {string}")
	public void iGetThePerson(String name, String address) throws JsonProcessingException {
		Assert.assertEquals(JsonHelper.serialize(new Person(name, address)), person);
	}
}

