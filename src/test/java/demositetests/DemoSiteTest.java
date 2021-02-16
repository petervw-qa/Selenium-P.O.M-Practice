package demositetests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import demosite.DemoPagePortal;
import demosite.pages.AddUserPage;
import demosite.pages.LoginUserPage;

public class DemoSiteTest {

	private static WebDriver driver;

	@Before
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");

		driver = new ChromeDriver();
	}

	@After
	public static void cleanup() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://thedemosite.co.uk/index.php");

		DemoPagePortal website = PageFactory.initElements(driver, DemoPagePortal.class);
		AddUserPage addUserPage = PageFactory.initElements(driver, AddUserPage.class);
		LoginUserPage loginUserPage = PageFactory.initElements(driver, LoginUserPage.class);

		website.addUser();

		addUserPage.createUser("guest", "guest");

		website.loginUser();

		loginUserPage.loginUser("guest", "guest");

		String success = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
				.getText();

		assertEquals("**Successful Login**", success);

	}

}
