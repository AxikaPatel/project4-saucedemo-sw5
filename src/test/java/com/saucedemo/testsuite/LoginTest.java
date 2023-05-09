package com.saucedemo.testsuite;

import com.saucedemo.customlistener.CustomListener;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class LoginTest extends BaseTest
{
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        loginPage.verifyProduct();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();


        // Verify that six products are displayed on page
        int actualNumber = productsPage.verifyProductList();
        int expectedNumber = 6;
        Assert.assertEquals(actualNumber,expectedNumber);

    }
}
