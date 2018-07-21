package com.automation.tests;

import com.automation.BaseClass;
import com.automation.screens.AlertPopUp;
import org.testng.annotations.Test;

public class DismissTheAlert  extends BaseClass {

    @Test
    public void dismissAlert() {
        AlertPopUp.tapOnAllowButton();
    }
}
