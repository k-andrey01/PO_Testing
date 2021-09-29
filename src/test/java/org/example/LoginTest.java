package org.example;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup(){
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.findElement(By.id("passp-field-login")).sendKeys("k.andrey01");
        driver.findElement(By.id("passp:sign-in")).click();
        driver.findElement(By.id("passp-field-passwd")).sendKeys("fifa14");
        driver.findElement(By.id("passp:sign-in")).click();
    }

    @BeforeClass
    public static void setup2(){
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/button[1]")).click();

        String myWin = null;
        Set<String> newWin = driver.getWindowHandles();
        Iterator<String> iterator = newWin.iterator();
        while (iterator.hasNext()){
            myWin = iterator.next();
        }

        driver.switchTo().window(myWin);
        driver.findElement(By.name("email")).sendKeys("89513552256");
        driver.findElement(By.name("pass")).sendKeys("fifa14");
        driver.findElement(By.id("install_allow")).click();
    }
}