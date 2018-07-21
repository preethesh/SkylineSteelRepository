package com.automation.screens;

import com.automation.Labels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import static com.automation.BaseClass.*;

public class Registration {



    public static void isRegistrationScreenDisplayed() {
        Assert.assertTrue(waitUntilPageLoads(Labels.RegistrationScreenPath), "Registration screen is not displayed testing");

    }

    public static void enterDataInRegistrationScreen() {
        Assert.assertTrue(waitUntilNavigationIndicatorDismiss(Labels.LoadingIndicatorClassName));
        enterDetailsInTextFields("Name");
        enterDetailsInTextFields("Company");
        enterDetailsInTextFields("Email");

    }

    public static void enterDetailsInTextFields(String textFieldName) {

        List<WebElement>  editFieldList = driver.findElements(By.className("android.widget.EditText"));
        switch (textFieldName) {
            case "Name" :
                           WebElement nameTextField = editFieldList.get(0);
                           nameTextField.click();
                           nameTextField.sendKeys("testing");
                           driver.hideKeyboard();
                           break;
            case "Company":
                           WebElement companyTextField = editFieldList.get(1);
                           companyTextField.click();
                           companyTextField.sendKeys("test company");
                           driver.hideKeyboard();
                           break;
            case "Email":
                           WebElement emailTextField = editFieldList.get(2);
                           emailTextField.click();
                           emailTextField.sendKeys("test@a.in");
                           driver.hideKeyboard();
                           break;



        }


    }

    public static void tapOnRegisterButton() {

        Assert.assertTrue(findElementByXpathAndClick(Labels.RegisterButtonXpath), "Unable to tap on Register button");

    }


}
