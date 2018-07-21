package com.automation.tests;

import com.automation.BaseClass;
import com.automation.Labels;
import com.automation.screens.ProductManual;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by joe on 5/26/2018.
 */
public class CheckOrderAndProductList extends BaseClass {

    @Test
    public  void test(){
        BaseClass.waitUntilPageLoads(Labels.xPath);
        sleep(5000);
        ProductManual.productListFromApp();
    }
}
