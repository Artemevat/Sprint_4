package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.SplittableRandom;

public class OrderClientDataPage {

    private WebDriver driver;

    public OrderClientDataPage(WebDriver driver){
        this.driver = driver;
    }

    //локатор для поля Имя
    private By orderClientDataName = By.xpath(".//input[@placeholder='* Имя']");
    //локатор для поля Фамилия
    private By orderClientDataSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор для поля Адрес
    private By orderClientDataAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля Станция метро
    private By orderClientDataMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //локатор для поля Телефон
    private By orderClientDataPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки Далее
    private By orderClientDataNextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");



    //методы
    //метод заполнения поля Имя (очистить+заполнить)
    public void enterOrderClientDataName(String name) {
        driver.findElement(orderClientDataName).clear();
        driver.findElement(orderClientDataName).sendKeys(name);
    }

    //метод заполнения поля Фамилия (очистить+заполнить)
    public void enterOrderClientDataSurname(String surname) {
        driver.findElement(orderClientDataSurname).clear();
        driver.findElement(orderClientDataSurname).sendKeys(surname);
    }

    //метод завполнения поля Адрес (очистить+заполнить)
    public void enterOrderClientDataAddress(String address) {
        driver.findElement(orderClientDataAddress).clear();
        driver.findElement(orderClientDataAddress).sendKeys(address);
    }
    //метод заполнения поля и выбора станции (очистить+заполнить+выбрать)
    public void selectOderClientDataMetroStation(String metro) {
        final String metroList = ".//div[@class='select-search__select']";
        final String metroStationSelected =String.format(metroList, metro);
        driver.findElement(orderClientDataMetroStation).click();
        driver.findElement(By.xpath(metroStationSelected)).click();
    }
    //метод заполнения поля Телефон (очистить+заполнить)
    public void enterOrderClientDataPhone(String phone){
        driver.findElement(orderClientDataPhone).sendKeys(phone);
    }

    //метод нажатия кнопки Далее
    public void clickOrderClientDataNextButton(){
        driver.findElement(orderClientDataNextButton).click();
    }

    //собирательный метод для заполнения полей и нажать Далее и подождать
    public void enterOrderClientDataPage(String name, String surname, String address, String metro, String phone){
        enterOrderClientDataName(name);
        enterOrderClientDataSurname(surname);
        enterOrderClientDataAddress(address);
        selectOderClientDataMetroStation(metro);
        enterOrderClientDataPhone(phone);
        clickOrderClientDataNextButton();
        new WebDriverWait(driver, 3);
    }

}