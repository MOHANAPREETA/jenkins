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
import utils.Reporter;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	public CheckoutPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public boolean clickCheckout() {
		driver.findElement(Locators.checkout).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Your Information']")));
			// pass the extent report
			Reporter.generateReport(driver, extTest, Status.PASS, "checkout accessed");
			return true;

		} catch (TimeoutException te) {
			// TODO: handle exception
			Reporter.generateReport(driver, extTest, Status.FAIL, "checkout accessed");
			return false;

		}

	}
}
