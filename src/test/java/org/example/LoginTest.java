package org.example;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    /**
     * осуществление первоначальной настройки
     */
    @Before
    public void setup(){
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver=new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
}

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.pressEnter();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.pressEnter();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://passport.yandex.ru/profile")); }

    @Test
    public void serviceTest() throws InterruptedException{
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.pressEnter();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.pressEnter();
        profilePage.goServices();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://passport.yandex.ru/profile/services"));
    }

    @Test
    public void postTest() throws InterruptedException{
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.pressEnter();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.pressEnter();
        profilePage.goProfileIcon();
        profilePage.goPost();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://mail.yandex.ru/u2709/?uid=1487109730#tabs/relevant"));
    }

    @After
    public void end() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

//    @BeforeClass
//    public static void setup2(){
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        WebDriver driver = new ChromeDriver();
//        //окно разворачивается на полный экран
//        driver.manage().window().maximize();
//        //задержка на выполнение теста = 10 сек.
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        //получение ссылки на страницу входа из файла настроек
//        driver.get(ConfProperties.getProperty("loginpage"));
//        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/button[1]")).click();
//
//        String myWin = null;
//        Set<String> newWin = driver.getWindowHandles();
//        Iterator<String> iterator = newWin.iterator();
//        while (iterator.hasNext()){
//            myWin = iterator.next();
//        }
//
//        driver.switchTo().window(myWin);
//        driver.findElement(By.name("email")).sendKeys("89513552256");
//        driver.findElement(By.name("pass")).sendKeys("fifa14");
//        driver.findElement(By.id("install_allow")).click();
//    }
}