package com.juaracoding.UjianMingguKeTiga;

import com.juaracoding.UjianMingguKeTiga.drivers.DriverSingleton;
import com.juaracoding.UjianMingguKeTiga.pages.Registrasi;
import com.juaracoding.UjianMingguKeTiga.pages.login;
import com.juaracoding.UjianMingguKeTiga.pages.AddtoCart;
import com.juaracoding.UjianMingguKeTiga.pages.Dashboard;
import com.juaracoding.UjianMingguKeTiga.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainApp {
    public static void main(String[] args) {
        DriverSingleton.getInstance(Constants.CHROME);
        WebDriver driver = DriverSingleton.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        // Dashboard
        Dashboard dashboard = new Dashboard();
        driver.get(Constants.URL);
        dashboard.dashboard();

        // Registrasi
        Registrasi register = new Registrasi();
        driver.get(Constants.URL_LOGIN);
        register.registerForm("Jessy Dimpudus", "jessy@dimpudus.com", "Jeba1811");

        driver.navigate().back();
        driver.navigate().refresh();

        // masuk
        login login = new login();
        login.loginForm("jessy@dimpudus.com", "Jeba1811");

        //Item one product
        AddtoCart addCart = new AddtoCart();
        driver.get(Constants.URL_SHOP);
        js.executeScript("window.scrollBy(0,300)");
        addCart.shopItem();

        // Add item in cart
        driver.get(Constants.URL_DETAIL_SHOP);
        js.executeScript("window.scrollBy(0,300)");
        addCart.addToCart();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}