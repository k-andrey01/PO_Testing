package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ServicesPage {
    public void goDisk(){
        $(By.xpath("//*[@id=\"cloud\"]/div[1]/div/a")).click();
    }
    public boolean atPage()
    {
        return (WebDriverRunner.url().contains(ConfProperties.getProperty("servURL")));
    }
}
