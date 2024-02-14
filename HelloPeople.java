package task21;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HelloPeople {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Launching the browser
		WebDriver driver = new EdgeDriver();

		//Navigating the URL
		driver.navigate().to("https://the-internet.herokuapp.com/iframe");

		//Using ImplicitlyWait for page to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Maximizing the browser 
		driver.manage().window().maximize();

		// Xpath locator is used
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));

		//Switching to frame by element to enter the text
		driver.switchTo().frame(frameElement);

		//Using <p>  to locate the element
		WebElement locatetext = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
		
		//clear() used to clear the present text
		locatetext.clear();

		//New text is entered
		locatetext.sendKeys("Hello People");

	   //Printing on console
		WebElement text = driver.findElement(By.tagName("p"));
		System.out.println("\n Given Text -> " + text.getText());
		Thread.sleep(3000);

		// Closing the browser
		//driver.close();
	}

}
