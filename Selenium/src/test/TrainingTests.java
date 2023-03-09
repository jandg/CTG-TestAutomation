package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import framework.BasicTest;
import manager.DriverManager;


public class TrainingTests extends BasicTest{

	
	public TrainingTests() {
		super.initializePages();
	}
	
	//Logging in with correct username / correct password
	@Test
	public void LoginCorrect() {
		//menuPage.clickLogout();
		loginPage.loginAsAdmin();
		assertTrue("The welcome page is not reached", welcomePage.isWelcomeMessageDisplayed());
	}
	
	//Logging in with correct username / incorrect password
	@Test
	public void LoginIncorrectPassword() {
		//menuPage.clickLogout();
		loginPage.loginWith("admin", "failed");
		assertFalse("The welcome page is reached", welcomePage.isWelcomeMessageDisplayed());
	}
		
	//Logging in with incorrect username
	@Test
	public void LoginIncorrectUsername() {
		//menuPage.clickLogout();
		loginPage.loginWith("test","test");
		assertFalse("The welcome page is reached", welcomePage.isWelcomeMessageDisplayed());
	}
	
	@BeforeEach
	public void logout() {
		System.out.println("logout");
		menuPage.clickLogout();
	}
	
	@AfterAll
	public static void shutOff() {
		System.out.println("shutoff");
		DriverManager.killDriver();
	}

}
