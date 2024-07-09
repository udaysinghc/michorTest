package com.healthPro.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BowserHandle{
	@Given("^Launch the browser$")
	public void Launch_the_browser() throws Throwable {
		System.out.println("test browser");
	}

	@And("^close the broswer$")
	public void close_the_broswer() throws Throwable {

	}
}
