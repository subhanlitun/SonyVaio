package UIelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strFinal,strCurrent;
		int count,i;
		strFinal="";
		//setting of chromedriver property
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Subh\\Desktop\\Selenium\\Drivers\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//storing the elements in List
		List<WebElement> legElem =driver.findElements(By.tagName("legend"));
		count=legElem.size();
		System.out.println("Number of legend tags are   :" + count);
		for(i=0;i<=count-1;i++)//iterating each element
		{
			strCurrent=legElem.get(i).getText();//storing the first element
			strFinal=strFinal+"#"+strCurrent;//merging alltexts in a single string
			
			
		}
		System.out.println("Final string is   :" + strFinal);
		
		//finding links from footer class
		int links,n;
		String currentlinktext;
		List<WebElement> footer = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		links=footer.size();//getting the size of the footer elements
		System.out.println("Number of links in footer are   :" + links);
		for(n=0;n<links;n++) //iterating each links present in the footer class 
		{
			currentlinktext=footer.get(n).getText();//getting the text from first link
			System.out.println(currentlinktext.toUpperCase());//printing the text in UPPERCASE
		}

	}


}
