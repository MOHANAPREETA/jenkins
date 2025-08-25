package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Pages.AddToCartPage;
import Pages.CheckoutPage;
import Pages.CustomerInformationPage;
import Pages.LoginPage;
import Pages.SelectProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.LogoutPage;
import Pages.OverviewPage;

public class PlaceOrderStepDefinition {
	LoginPage login;
	SelectProductPage Productpage;
	AddToCartPage result;
	CheckoutPage checkout;
	CustomerInformationPage info;
	OverviewPage finish;
	LogoutPage logout;

	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;

	@Given("the user is on the loginpage")
	public void the_user_is_on_the_loginpage() {
		String expRes = "https://www.saucedemo.com/";
		String actRes = driver.getCurrentUrl();
		Assert.assertEquals(actRes, expRes);

	}

	@When("the user enter username as {string} and password as {string} and click login button")
	public void the_user_enter_username_as_and_password_as_and_click_login_button(String userName, String Password) {
		login = new LoginPage(driver, extTest);
		boolean actRes = login.validateLogin(userName, Password);
		Assert.assertTrue(actRes);

	}

	@When("the user selects the product")
	public void the_user_selects_the_product() {
		Productpage = new SelectProductPage(driver, extTest);
		boolean actRes = Productpage.selectProduct();
		Assert.assertTrue(actRes);

	}

	@When("the user clicks on Add to cart button")
	public void the_user_clicks_on_add_to_cart_button() {
		result = new AddToCartPage(driver, extTest);
		boolean actRes = result.clickAddToCart();
		Assert.assertTrue(actRes);
	}

	@When("the user clicks on Cart icon")
	public void the_user_clicks_on_cart_icon() {
		boolean actRes = result.clickCartIcon();
		Assert.assertTrue(actRes);
	}

	@When("the user clicks on Checkout button")
	public void the_user_clicks_on_checkout_button() {
		checkout = new CheckoutPage(driver, extTest);
		boolean actRes = checkout.clickCheckout();
		Assert.assertTrue(actRes);
	}

	@When("the user enters customer information and click continue button")
	public void the_user_enters_customer_information_and_click_continue_button() {
		info = new CustomerInformationPage(driver, extTest);
		boolean actRes = info.addCustomerDetails();
		Assert.assertTrue(actRes);
	}

	@When("the user verifies the product and click Finish button")
	public void the_user_verifies_the_product_and_click_finish_button() {
		finish = new OverviewPage(driver, extTest);
		boolean actRes = finish.clickFinish();
		Assert.assertTrue(actRes);
	}

	@When("the user clicks the logout button")
	public void the_user_clicks_the_logout_button() {
		logout = new LogoutPage(driver, extTest);
		logout.logout();
	}

	@Then("the user validates the login button int the login page")
	public void the_user_validates_the_login_button_int_the_login_page() {
		boolean actRes = logout.validatelogout();
		Assert.assertTrue(actRes);
	}

}
