package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationOrderPage {
    private WebDriver driver;

    public ConfirmationOrderPage(WebDriver driver){
        this.driver = driver;
    }

    //локатор кнопки Да на всплывающем окне подтверждения
    private By confirmationOrderButtonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //метод нажатия на кнопку Да
    public void clickConfirmationOrderButtonYes(){
        driver.findElement(confirmationOrderButtonYes).click();
    }
}

