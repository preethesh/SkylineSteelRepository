package com.automation.screens;

import com.automation.BaseClass;
import org.testng.Assert;

import static com.automation.BaseClass.*;

public class AlertPopUp {

    public static void tapOnAllowButton() {
        Assert.assertTrue(isAlertDisplayed(), "alert is not displayed");
        Assert.assertTrue(findElementByIdAndClick("com.android.packageinstaller:id/permission_allow_button"));
    }
}
