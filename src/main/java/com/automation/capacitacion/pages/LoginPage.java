package com.automation.capacitacion.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://sahitest.com/demo/training/login.htm")
public class LoginPage extends PageObject {

	@FindBy(name = "user")
	WebElement txtUser;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "/html/body/center/div/form/table/tbody/tr[3]/td[2]/input")
	WebElement btnLogin;

	@FindBy(id = "errorMessage")
	WebElement lblMessage;

	public void login(String user, String password) {
		txtUser.sendKeys(user);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}

	public boolean validateMessage() {
		boolean isVisible = false;
		try {
			if (lblMessage.isDisplayed()) {
				isVisible = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isVisible;
	}

}
