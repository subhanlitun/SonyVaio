package UIelements;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UIhandlingSel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Subh\\Desktop\\Selenium\\Drivers\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Page title is : " + driver.getTitle());

		WebElement Radionbt1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		if (Radionbt1.isDisplayed()) {
			System.out.println("Name of RadiobBUtton is \"Radio Button Example\" ");
			// WebElement Radion1=driver.findElement(By.xpath("//input[@value='radio1']"));
			Radionbt1.click();
		} else {
			System.out.println("RadioButton 1 is disabled");
		}
		WebElement Radion3 = driver.findElement(By.xpath("//input[@value='radio3']"));
		if (Radion3.isDisplayed()) {
			System.out.println("RadiobBUtton3 enabled \"RadiobBUtton3isEnabled\" ");
			Radion3.click();

		} else {
			// Radion3.click();
			System.out.println("RadiobBUtton3 is clicked \"RadiobBUtton3isClicked\" ");
		}
		String expectedText = "Suggession Class Example";
		WebElement suggession = driver.findElement(By.id("select-class-example"));
		String suggession1 = suggession.getText();
		if (expectedText.equalsIgnoreCase(suggession1)) {
			System.out.println("The expected text is same as actual text --- " + suggession1);
			WebElement countries = driver.findElement(By.id("autocomplete"));
			countries.click();
			// countries.clear();
			countries.sendKeys("India");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='ui-menu-item-wrapper' and text()='India']")).click();

		} else {
			System.out.println("The expected text doesn't match the actual text --- " + suggession1);
		}
		String expecteddrpdwn = "Dropdown Example";
		WebElement dropdown = driver.findElement(By.xpath("//legend[text()='Dropdown Example']"));
		String drpdwnexample = dropdown.getText();
		if (expecteddrpdwn.equalsIgnoreCase(drpdwnexample)) {
			System.out.println("The expected text is same as actual text --- " + drpdwnexample);
			Select drpoption = new Select(driver.findElement(By.id("dropdown-class-example")));
			drpoption.selectByVisibleText("Option2");
		} else {
			System.out.println("The eoption could not be selected --- " + expecteddrpdwn);
		}
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		boolean isSelected = checkbox.isSelected();
		if (isSelected == false) {
			checkbox.click();
		}

		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(3000);
		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Page title is : " + driver.getTitle());
				driver.close(); // closing child window
				
				
			}
		}
		driver.switchTo().window(parentWindow);
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("Swagatika");
		WebElement alertbtn = driver.findElement(By.xpath("//input[@id='alertbtn']"));
		alertbtn.click();
		Alert alert = driver.switchTo().alert();
		String strAlertText = alert.getText();
		System.out.println("The alert text captured is :  "+strAlertText);
		Thread.sleep(3000);
		alert.accept();
	}

}
