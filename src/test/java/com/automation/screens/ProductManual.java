package com.automation.screens;

import com.automation.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.automation.BaseClass.driver;
import static com.automation.BaseClass.sleep;
import static com.automation.BaseClass.waitUntilPageLoads;

/**
 * Created by joe on 5/9/2018.
 */
public class ProductManual {

    public static  void productListFromApp() {

        ArrayList<String> productList = new ArrayList<>();
        WebElement elementList = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]"));
        List<WebElement> mainClassList = elementList.findElements(By.className("android.view.View"));
        System.out.println("MainClassList size" + mainClassList.size());
        for(int i=0; i<mainClassList.size(); i++) {

            WebElement mainClass = mainClassList.get(i);
            int size = mainClass.findElements(By.className("android.view.View")).size();
            System.out.println("Subclass size" + size);
            //System.out.println("Dimension" + mainClass.getSize());
            //System.out.println(mainClass.getText());

            if(size == 5) {

                List<WebElement> subClassList = mainClass.findElements(By.className("android.view.View"));
                for(int j=0; j<subClassList.size(); j++) {
                    WebElement subElement = subClassList.get(j);
                    String text = subElement.getText();
                    System.out.println(text);
                    productList.add(text);
                }
            }

        }
    }
}
