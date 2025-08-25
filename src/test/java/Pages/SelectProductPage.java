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

public class SelectProductPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public SelectProductPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}

	public boolean selectProduct() {
		driver.findElement(Locators.Productname).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
			// pass the extent report
			Reporter.generateReport(driver, extTest, Status.PASS, "Product Selected");
			return true;

		} catch (TimeoutException te) {
			// TODO: handle exception
			Reporter.generateReport(driver, extTest, Status.FAIL, "Selection Failure");
            return false;
		}

	}

}
