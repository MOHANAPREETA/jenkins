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

public class LogoutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public LogoutPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}

	public void logout() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Base.sleep();
		driver.findElement(Locators.logout).click();
		Base.sleep();

	}

	public boolean validatelogout() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
			// pass the extent report
			Reporter.generateReport(driver, extTest, Status.PASS, "Log out");
			return true;

		} catch (TimeoutException te) {
			// TODO: handle exception
			Reporter.generateReport(driver, extTest, Status.FAIL, "Error");
			return false;

		}
	}
}
