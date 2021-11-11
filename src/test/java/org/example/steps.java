package org.example;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static junit.framework.TestCase.assertTrue;

public class steps {
    LoginPg2 logPg = new LoginPg2();
    ProfilePage profilePage = new ProfilePage();
    ServicesPage servicesPage = new ServicesPage();
    DiskPg2 diskPage = new DiskPg2();
    PostPage postPage = new PostPage();

    @Given("Открыть passport.yandex.ru")
    public void open_pass_yandex() {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.proxyEnabled = false;
        Selenide.open("https://passport.yandex.ru/auth");
    }

    @And("Нажать на кнопку {string}")
    public void pressButtonWithText(String arg0) {
        if (arg0.equals("Войти")) {
            logPg.pressEnter();
        } else if (arg0.equals("Мои сервисы")) {
            profilePage.goServices();
        } else if (arg0.equals("Аватарка")) {
            profilePage.goProfileIcon();
        } else if (arg0.equals("Почта")) {
            profilePage.goPost();
        } else if (arg0.equals("Диск")) {
            servicesPage.goDisk();
        } else if (arg0.equals("Значок файла")) {
            diskPage.clickFile();
        }
    }

    @When("Ввести в поле {string} текст")
    public void typeToInputWithNameText(String arg0) {
        if (arg0.equals("Телефон или почта")) {
            logPg.inputLogin();
        } else if (arg0.equals("Введите пароль")) {
            logPg.inputPassword();
        }
    }

    @Then("На странице {string}")
    public void atPage(String arg0) throws InterruptedException {
        if (arg0.equals("Профиль")) {
            Thread.sleep(2000);
            assertTrue(profilePage.atPage());
            switchTo().window(getWebDriver().getWindowHandle()).close();
        } else if (arg0.equals("Мои сервисы")) {
            Thread.sleep(2000);
            assertTrue(servicesPage.atPage());
            switchTo().window(getWebDriver().getWindowHandle()).close();
        } else if (arg0.equals("Почта")) {
            Thread.sleep(2000);
            assertTrue(postPage.atPage());
            switchTo().window(getWebDriver().getWindowHandle()).close();
        }
    }

    @And("Загрузить файл на диск")
    public void addFile()
    {
        diskPage.clickAdd();
    }

    @Then("Файл появился на диске")
    public void isFileDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(diskPage.isFileDisplayed());
        switchTo().window(getWebDriver().getWindowHandle()).close();
    }

    @Then("Скачать и проверить файл")
    public void downloadDocument() throws IOException, InterruptedException {
        PDF pdf = diskPage.checkFile();
        Thread.sleep(2000);
        System.out.println(pdf.text);
        assertTrue(pdf.text.contains("Sergey’s travelling."));
        Thread.sleep(2000);
        switchTo().window(getWebDriver().getWindowHandle()).close();
    }
}
