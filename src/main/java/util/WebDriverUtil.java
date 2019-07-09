package util;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class WebDriverUtil {


    public static WebElement findElement(WebDriver driver, By locator) {

        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(WebDriver driver, By locator) {

        return driver.findElements(locator);
    }


    public static boolean isElementDisplayed(WebDriver driver, By locator) {

        return findElements(driver, locator)
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .isPresent();
    }


}



