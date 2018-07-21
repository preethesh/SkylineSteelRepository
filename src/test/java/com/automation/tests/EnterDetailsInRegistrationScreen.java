package com.automation.tests;

import com.automation.BaseClass;
import com.automation.screens.Registration;
import org.testng.annotations.Test;

public class EnterDetailsInRegistrationScreen extends BaseClass {

    @Test
    public void enterDetails() {
        //AlertPopUp.tapOnAllowButton();
        Registration.isRegistrationScreenDisplayed();
        Registration.enterDataInRegistrationScreen();
        Registration.tapOnRegisterButton();
    }
}
