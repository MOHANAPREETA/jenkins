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

public class AddToCartPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	public AddToCartPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public boolean clickAddToCart() {
		driver.findElement(Locators.cart).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove")));
			// pass the extent report
			Reporter.generateReport(driver, extTest, Status.PASS, "Added to cart");
			return true;

		} catch (TimeoutException te) {
			// TODO: handle exception
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to add in cart");
			return false;

		}

	}
	public boolean clickCartIcon() {
		driver.findElement(By.className("shopping_cart_link")).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Cart']")));
			// pass the extent report
			Reporter.generateReport(driver, extTest, Status.PASS, "Added to cart");
			return true;

		} catch (TimeoutException te) {
			// TODO: handle exception
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to add in cart");
			return false;

		}
	}
	
}
