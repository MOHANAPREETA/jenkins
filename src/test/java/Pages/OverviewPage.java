package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Reporter;

public class OverviewPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	public OverviewPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public boolean clickFinish() {
		driver.findElement(By.id("finish")).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Complete!']")));
			// pass the extent report
			Reporter.generateReport(driver, extTest, Status.PASS, "Order checked");
			return true;

		} catch (TimeoutException te) {
			// TODO: handle exception
			Reporter.generateReport(driver, extTest, Status.FAIL, "Not checked");
			return false;

		}

	}
	}


