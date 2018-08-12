package scripts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestInvalidLogin extends BaseTest {
	@Test
	public void testInvalidLogin() throws InterruptedException{
		Logger log = LogManager.getLogger(TestInvalidLogin.class.getName());
		LoginPage lp = new LoginPage(driver);
		log.debug("Fetching the total row count...");
		int rowCount = Lib.getRowCount("InvalidLogin");
		log.info("total row count retrieved successfully");
		for (int i = 1; i <= rowCount ; i++) {
			String username = Lib.getCellValue("InvalidLogin", i, 0);
			String password = Lib.getCellValue("InvalidLogin", i, 1);
			//Set username
			lp.setUsername(username);
			Thread.sleep(2000);
			//set password
			lp.setPassword(password);
			Thread.sleep(2000);
			//click on Login button
			lp.clickLogin();
			Thread.sleep(4000);
		}
	}
}
