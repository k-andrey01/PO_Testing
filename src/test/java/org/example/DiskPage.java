package org.example;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class DiskPage {
    public void clickFile(){
        $(By.xpath("//*[@id=\"app\"]/div/div/div[4]/div[2]/div/div/div[3]/div/div[1]")).click();
    }

    public File downloadFile(){
        try {
            return $(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/button[1]")).download();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clickAdd(){
        $(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div[1]/span[1]/span[2]/div/input")).uploadFile(new File(ConfProperties.getProperty("image")));
    }
}
