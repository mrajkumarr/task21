package task21;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Frames {
	public static void main(String[] args) throws InterruptedException 
	{
		//Launching the browser
		WebDriver driver = new EdgeDriver();

		// Navigating the URL
		driver.navigate().to("https://the-internet.herokuapp.com/windows");

		//Using ImplicitlyWait for page to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Maximizing the browser 
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		//Switching to new window and converting the set to list
		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<>(window);

		//Using get(index)
		driver.switchTo().window(list.get(1));

		//Validating the text 
		String text = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();

		if (text.equals("New Window")) 
		{
			System.out.println("\nText matches -> " +text);
		}
		else 
		{
			System.out.println("\nText match failed " + text);
		}

		Thread.sleep(1000);

		// Closing the new  window
		//driver.close();

		// Switching to parent window
		driver.switchTo().window(list.get(0));

		String parentText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();

		//Validating the parent window
		if (parentText.equals("Opening a new window")) 
		{
			System.out.println("\nParent window is active -> " + parentText);
		} 
		else
			System.out.println("\nParent window is not active");

		Thread.sleep(1000);
		
		// closing the browser
		//driver.quit();
	}
}


