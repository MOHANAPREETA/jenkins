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

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public LoginPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}

	public boolean validateLogin(String uname, String pwd) {
		driver.findElement(Locators.username).sendKeys(uname);
		Base.sleep();
		driver.findElement(Locators.password).sendKeys(pwd);
		Base.sleep();
		driver.findElement(Locators.loginbutton).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
			
			// pass the extent report
			Reporter.generateReport(driver, extTest, Status.PASS, "Login Successful");
			return true;

		} catch (TimeoutException te) {
			// TODO: handle exception
			Reporter.generateReport(driver, extTest, Status.FAIL, "Login Failure");
			return false;

		}
	}
}
