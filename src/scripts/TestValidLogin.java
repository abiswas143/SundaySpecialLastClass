package scripts;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin() throws InterruptedException{
		Logger log = LogManager.getLogger(TestValidLogin.class.getName());
		log.debug("creating the object of LoginPage pom class...");
		LoginPage lp = new LoginPage(driver);
		log.info("Object created successfully...");
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		//Set username
		lp.setUsername(username);
		Thread.sleep(2000);
		//set password
		lp.setPassword(password);
		Thread.sleep(2000);
		//click on Login button
		lp.clickLogin();
		//Apply some condition -- using Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		sa.assertAll();
	}
}
