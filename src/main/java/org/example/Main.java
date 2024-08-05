package org.example;

import config.BaseDriver;

public class Main extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://ithillel.ua/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();
        Thread.sleep(50000);
        driver.quit();
    }
}