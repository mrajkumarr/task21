package task21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ThreeClass {

	public static void main(String[] args)
	{
			//Launching the browser
			WebDriver driver = new EdgeDriver();
			
			// Navigating the URL
			driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");

			//Using ImplicitlyWait for page to wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Maximizing the browser 
			driver.manage().window().maximize();

			WebElement top = driver.findElement(By.xpath("//frame[@name='frame-top']"));
			// Switching to top frame
			driver.switchTo().frame(top);

			// Verifying three frames on the page
			List<WebElement> frame = driver.findElements(By.tagName("frame"));
			String Size = String.valueOf(frame.size());
			if (Size.equals("3")) 
			{
				System.out.println("\nThree Frames Present");
			} else {
				System.out.println("\nFrames are less than three");
			}

			WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
			
			// Switching to left frame
			driver.switchTo().frame(leftFrame);

			// Locating the text 
			WebElement ele = driver.findElement(By.tagName("body"));
			String left = ele.getText();

			// Verifying left frame 
			
			if (left.equals("LEFT"))
			{
				System.out.println("\nLeft frame has -> " + left);
			} 
			else 
			{
				System.out.println("\nLeft frame have no text");
			}

			// Switching back to the top frame
			driver.switchTo().parentFrame();

			WebElement midframe = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
			
			// Switching to middle frame
			driver.switchTo().frame(midframe);

			// Locating the text 
			WebElement ele1 = driver.findElement(By.tagName("body"));
			String middleText = ele1.getText();

			// Verifying that the middle frame 
			
			if (middleText.equals("MIDDLE")) 
			{
				System.out.println("\nMiddle frame has -> " + middleText);
			} 
			else 
			{
				System.out.println("\nMiddle frame have no text");
			}

			// Switching back to the top frame
			driver.switchTo().parentFrame();
	       
			
			//Closing the driver
			// driver.close();
			
		}
}
