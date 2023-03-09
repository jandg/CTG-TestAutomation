package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import framework.BasicTest;
import manager.DriverManager;

public class TrainingTestsParameterized extends BasicTest{
	
	public TrainingTestsParameterized() {
		initializePages();
	}
	

	@ParameterizedTest
	@CsvSource({
		"adm,superduper,Unable to log in with the given credentials. Please try again.",
		"admin,wrong,Unable to log in with the given credentials. Please try again.",
		",,Please fill in all the fields."
	})
	public void login(String username, String password, String error) {

		loginPage.loginWith(username, password);
		assertEquals(error, loginPage.getErrorMessage());
	}

	@BeforeEach
	public void beforeTest() {
		menuPage.clickLogout();
	}
	
	
	@AfterAll
	public static void afterAllTests() {
		DriverManager.killDriver();
	}

}
