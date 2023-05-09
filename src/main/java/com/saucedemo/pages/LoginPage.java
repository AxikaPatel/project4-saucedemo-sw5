package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlistener.CustomListener;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends Utility
{
    public LoginPage()
    {
        PageFactory.initElements(driver,this);

    }

    @CacheLookup
    @FindBy(xpath = "//input[@name='user-name']")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement clickOnLogin;

    //Enter “standard_user” username
    public void enterUserName(String username)
    {
        Reporter.log("Enter “standard_user” username");
        sendTextToElement(userNameField,username);
        CustomListener.test.log(Status.PASS,"Enter “standard_user” username" +username);
    }

    //Enter “secret_sauce” password
    public void enterPassword(String password)
    {
        Reporter.log("//Enter “secret_sauce” password");
        sendTextToElement(passwordField,password);
        CustomListener.test.log(Status.PASS,"Enter “secret_sauce” password" + password);
    }

    // Click on ‘LOGIN’ button
    public void clickOnLoginButton()
    {
        Reporter.log("// Click on ‘LOGIN’ button");
        clickOnElement(clickOnLogin);
        CustomListener.test.log(Status.PASS,"Click on ‘LOGIN’ button");
    }

    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement verifyProduct;
    //Verify the text “PRODUCTS”
    public void verifyProduct()
    {
        Reporter.log("//Verify the text “PRODUCTS”");
       String excpectedMessage = "Products";
       String actualMessage = getTextFromElement(verifyProduct);
        Assert.assertEquals(actualMessage,excpectedMessage);
        CustomListener.test.log(Status.PASS,"Verify the text “PRODUCTS”");
    }



}
