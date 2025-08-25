package Objectrepository;
import org.openqa.selenium.By;

public class Locators {

	//below
	public static By username=By.id("user-name");
	public static By password = By.id("password");
	public static By loginbutton=By.id("login-button");
	
	//below is locatore for select product page
	public static By Productname=By.xpath("//div[text()='Sauce Labs Backpack']");
	public static By cart=By.id("add-to-cart");
	public static By checkout=By.id("checkout");
	public static By FirstName=By.id("first-name");
	public static By LastName=By.id("last-name");
	public static By Zip=By.id("postal-code");
	public static By Continuebutton=By.id("continue");
	public static By logout=By.xpath("//a[text()='Logout']");
	
}
