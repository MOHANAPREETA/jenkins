package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Objectrepository.Locators;
import utils.Base;
import utils.Reporter;

public class CustomerInformationPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	public CustomerInformationPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public boolean addCustomerDetails() {
		driver.findElement(Locators.FirstName).sendKeys("Preeta");
		Base.sleep();
		driver.findElement(Locators.LastName).sendKeys("Sekar");
		Base.sleep();
		driver.findElement(Locators.Zip).sendKeys("638111");
		Base.sleep();
		driver.findElement(Locators.Continuebutton).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Overview']")));
			// pass the extent report
			Reporter.generateReport(driver, extTest, Status.PASS, "checked overview");
			return true;

		} catch (TimeoutException te) {
			// TODO: handle exception
			Reporter.generateReport(driver, extTest, Status.FAIL, "Wrong Info");
			return false;

		}

	}

}
