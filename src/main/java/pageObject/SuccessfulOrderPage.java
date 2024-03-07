package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrderPage {

    private WebDriver driver;

    public SuccessfulOrderPage(WebDriver driver){
        this.driver = driver;
    }

    //локатор текста успешного создания заявки
    private By successfulOrderText = By.xpath(".//div[text()='Заказ оформлен']");
    //проверка, что текст об успешном создании присутствует
    public boolean successfulOrderTextIsDisplayed(){
        return driver.findElement(successfulOrderText).isDisplayed();
    }
}