package org.example;

import config.BaseDriverImpl;
import java.security.Key;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main extends BaseDriverImpl {

    public static final String DROPDOWNLIST = ".inputBox-DS-EntryPoint1-1";
    public static final String WEATHER_LINK = "https://www.msn.com/en-xl/weather/forecast/";

    public static void main(String[] args) throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(WEATHER_LINK);

            String originalWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();

            for (String window : allWindows) {
                if (!window.equals(originalWindow)) {
                    driver.switchTo().window(window);
                    driver.close();
                }


                try {
                    driver.findElement(By.id("onetrust-reject-all-handler")).click();
                } catch (Exception e) {
                    System.out.println("Кнопка отказа от куки не найдена.");
                }

                WebElement dropdownList = driver.findElement(By.cssSelector(DROPDOWNLIST));
                dropdownList.click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='m-locs']/div/div/div/input")));
                inputField.click();
                inputField.sendKeys("Dnipro");
                inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Dnipro, Dnipropetrovsk Oblast, Ukraine']")));
                inputField.sendKeys(Keys.ENTER);

                wait.until(ExpectedConditions.titleContains("Dnipro"));
                System.out.println(driver.getTitle());
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.findElement(By.xpath("//*[@id=\"OverviewCurrentTemperature\"]/a")).getText());

                Thread.sleep(5000);
                driver.quit();

            }
    }
}
