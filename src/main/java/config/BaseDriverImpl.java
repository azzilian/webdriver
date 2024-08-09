package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;

public class BaseDriverImpl implements BaseDriver{

    public static WebDriver driver = initDriverChrome();

    public static  WebDriver initDriverChrome() {
        return new ChromeDriver();
    }

//    @Override
//    public WebDriver createDriver(Browser browser) {
//        switch(browser);
//    }
}
