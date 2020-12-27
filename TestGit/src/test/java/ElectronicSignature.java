
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAndHoldAction;

public class ElectronicSignature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		WebDriver d = new ChromeDriver();

		d.navigate().to("https://szimek.github.io/signature_pad/");

		d.manage().window().maximize();

		WebElement element = d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/canvas[1]"));

		Actions draw = new Actions(d);

		 Action signature =	draw.moveToElement(element, 50, 50) // start points x axis and y axis.
				.clickAndHold(element).moveByOffset(100, 60).moveByOffset(0, 0).moveByOffset(0, 90).moveByOffset(90, 50)
				.moveByOffset(100, 0).moveByOffset(-300, 0).moveByOffset(-50, -200).release(element).build();
		 
		 
		 signature.perform();
		// creer la chaine(build) plus exécuter le tt(perform) =>marboutin bba3thhom
        //clickdroit de souris => release
		 
		 /***********save us png button****************/
		 
		
		 d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/button[1]")).click();
	}

}
