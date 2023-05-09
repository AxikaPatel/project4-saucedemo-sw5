package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlistener.CustomListener;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductsPage extends Utility
{
    public ProductsPage()
    {
        PageFactory.initElements(driver,this);

    }

    @CacheLookup
    @FindBy(linkText = "Products")
    WebElement productText;

    public String verifyText()
    {
        Reporter.log("Verify Text");
        CustomListener.test.log(Status.PASS,"Verify Products");
        return getTextFromElement(productText);

    }

    public int verifyProductList()
    {
        Reporter.log("verify product");
        CustomListener.test.log(Status.PASS," Verify that six products are displayed on page");
      return getSize(By.xpath("//div[@class='inventory_item']"));
    }
}
