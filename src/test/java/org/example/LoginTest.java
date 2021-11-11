package org.example;
import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {
    /**
     * осуществление первоначальной настройки
     */
    @Before
    public void setup(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        //определение пути до драйвера и его настройка
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.proxyEnabled = false;
        open(ConfProperties.getProperty("loginpage"));
}

    //@Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LogIn();
        Thread.sleep(1000);
        Assert.assertTrue(WebDriverRunner.url().equals(ConfProperties.getProperty("logURL")));
        switchTo().window(getWebDriver().getWindowHandle()).close();}

    //@Test
    public void serviceTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();
        loginPage.LogIn();
        profilePage.goServices();
        Thread.sleep(1000);
        Assert.assertTrue(WebDriverRunner.url().equals(ConfProperties.getProperty("servURL")));
        switchTo().window(getWebDriver().getWindowHandle()).close();
    }

    //@Test
    public void postTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();
        loginPage.LogIn();
        profilePage.goProfileIcon();
        profilePage.goPost();
        Thread.sleep(1000);
        System.out.println(WebDriverRunner.url());
        Assert.assertTrue(WebDriverRunner.url().equals(ConfProperties.getProperty("postURL")));
        switchTo().window(getWebDriver().getWindowHandle()).close();
    }

    //@Test
    public void getFile(){
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();
        ServicesPage servicesPage = new ServicesPage();
        DiskPage diskPage = new DiskPage();
        loginPage.LogIn();
        profilePage.goServices();
        servicesPage.goDisk();
        File statementPdf = null;
        try {
            diskPage.clickFile();
            statementPdf=diskPage.downloadFile();
            PDF pdf = new PDF(statementPdf);
            //System.out.println(pdf.text);
            assertThat(pdf, PDF.containsText("Sergey’s travelling."));
        } catch (IOException e) {
            e.printStackTrace();
        }
        switchTo().window(getWebDriver().getWindowHandle()).close();
    }

    //@Test
    public void addFile(){
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();
        ServicesPage servicesPage = new ServicesPage();
        DiskPage diskPage = new DiskPage();
        loginPage.LogIn();
        profilePage.goServices();
        servicesPage.goDisk();
        diskPage.clickAdd();
        if ($(By.xpath("//*[@id=\"app\"]/div/div/div[4]/div[2]/div/div/div[3]/div/div[10]")).isDisplayed()){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchTo().window(getWebDriver().getWindowHandle()).close();
    }

    @After
    public void end() throws InterruptedException {
        Thread.sleep(5000);
    }
}