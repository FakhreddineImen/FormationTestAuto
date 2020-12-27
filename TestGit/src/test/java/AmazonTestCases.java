
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTestCases {

	WebDriver d;

	public void temps(int ms) {

		try { // la meilleur solution que utiliser throws interrupted exception
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Before // methode qui va être executer avant chaque test
	public void Run() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		d = new ChromeDriver(); // Arrange
		d.navigate().to("https://www.amazon.com");
		d.manage().window().maximize();

	}

	@Test
	public void newAmazonTitleValid() {

		String actualResult = d.getTitle(); // Act
		System.out.println(actualResult);

		String expectedResult = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"; // Act

		Assert.assertEquals(actualResult, expectedResult); // assert

	}

	@Test
	public void newAmazonTitleValidmustFailed() { // scenario de test

		String actualResult = d.getTitle(); // Act
		System.out.println(actualResult);

		String expectedResult = "oldTitle"; // Act

		Assert.assertNotEquals(actualResult, expectedResult); // assert

	}

	@Test
	public void textMustExist() { // scenario de test

		AssertTextinTitle("imen");

		temps(5000);// appeler la méthode temps()
	}

	@Test
	public void textMustNotExist() { // scenario de test

		Assert.assertFalse(d.getTitle().contains("imen"));
		// you can use findby element
		// contains string toujours

	}

	public void AssertTextinTitle(String ExpectedResult) { // ma méthode générique

		Assert.assertTrue(d.getTitle().contains(ExpectedResult));
		// you can use findby element
		// contains string toujours

		/* autre methode */

		boolean expectedresult2 = d.getTitle().contains(ExpectedResult);
		Assert.assertFalse(expectedresult2);
	}
	
	@Test
	public void assertGoogleREonseTimeLeddThan() {
		assertResponseTimeLessThan("https://google.com/",5000);
	}


	// mesurer le temps de loading d'une page
	public void assertResponseTimeLessThan(String url, int msTime) {
		// actuel<expected
		long start = System.currentTimeMillis();
		d.get(url);
		long end = System.currentTimeMillis();
		
		long duration= end - start;
		
		Assert.assertTrue(msTime>duration);

	}
	
	@After
	public void tearDown() {
		d.quit();
	}

}
