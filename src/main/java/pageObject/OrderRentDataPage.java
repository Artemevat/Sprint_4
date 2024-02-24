package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderRentDataPage {

    private WebDriver driver;
    public OrderRentDataPage(WebDriver driver){
        this.driver = driver;
    }

    //локатор поля даты
    private By orderRentDataWhenDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор поля срок аренды
    private By orderRentDataRentalPeriod = By.className("Dropdown-placeholder");
    //локатор срок аренды сутки - 1
    private By orderRentDataRentalPeriodOneDay = By.xpath(".//*[@class='Dropdown-option'][1]");
    //локатор срок аренды сутки - 2
    private By orderRentDataRentalPeriodTwoDays = By.xpath(".//*[@class='Dropdown-option'][2]");
    //локатор срок аренды сутки - 3
    private By orderRentDataRentalPeriodThreeDays = By.xpath(".//*[@class='Dropdown-option'][3]");
    //локатор срок аренды сутки - 4
    private By orderRentDataRentalPeriodFourDays = By.xpath(".//*[@class='Dropdown-option'][4]");
    //локатор срок аренды сутки - 5
    private By orderRentDataRentalPeriodFiveDays = By.xpath(".//*[@class='Dropdown-option'][5]");
    //локатор срок аренды сутки - 6
    private By orderRentDataRentalPeriodSixDays = By.xpath(".//*[@class='Dropdown-option'][6]");
    //локатор срок аренды сутки - 7
    private By orderRentDataRentalPeriodSevenDays = By.xpath(".//*[@class='Dropdown-option'][7]");
    //локатор цвета чёрный жемчуг
    private  By orderRentDataColorBlackPearl = By.id("black");
    //локатор цвета серая безысходность
    private  By orderRentDataColorGrayHopelessness = By.id("grey");
    //локатор поля комментарий
    private By orderRentDataComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор кнопки Заказать
    private By orderRentDataOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");


    //методы
    //метод выбора даты
    public void enterOrderRentDataWhenDelivery(String data){
        driver.findElement(orderRentDataWhenDelivery).clear();
        driver.findElement(orderRentDataWhenDelivery).sendKeys(data);
        driver.findElement(orderRentDataWhenDelivery).sendKeys(Keys.ENTER);
    }
    //метод выбора срока
    public void chooseOrderRentDataRentalPeriod(int days){
        driver.findElement(orderRentDataRentalPeriod).click();
        if (days == 1){
            driver.findElement(orderRentDataRentalPeriodOneDay).click();
        } else if (days == 2) {
            driver.findElement(orderRentDataRentalPeriodTwoDays).click();
        } else if (days == 3) {
            driver.findElement(orderRentDataRentalPeriodThreeDays).click();
        } else if (days == 4) {
            driver.findElement(orderRentDataRentalPeriodFourDays).click();
        } else if (days == 5) {
            driver.findElement(orderRentDataRentalPeriodFiveDays).click();
        } else if (days == 6) {
            driver.findElement(orderRentDataRentalPeriodSixDays).click();
        } else if (days == 7) {
            driver.findElement(orderRentDataRentalPeriodSevenDays).click();
        }
    }
    //метод выбора цвета черный жемчуг
    public void clickOrderRentDataColorBlackPearl(){
        driver.findElement(orderRentDataColorBlackPearl).click();
    }
    //метод выбора цвета серая безысходность
    public void clickOrderRentDataColorGrayHopelessness (){
        driver.findElement(orderRentDataColorGrayHopelessness).click();
    }
    //метод выбора цвета из 2-х
    private static final String COLOR_BLACK_PEARL = "black";
    private static final String COLOR_GRAY_HOPELESSNESS = "gray";

    public void chooseColor(String color){
        if (color.equals(COLOR_BLACK_PEARL)){
            clickOrderRentDataColorBlackPearl();
        } else if (color.equals(COLOR_GRAY_HOPELESSNESS)) {
            clickOrderRentDataColorGrayHopelessness();
        }
    }
    //метод заполнения комментария
    public void enterOrderRentDataComment(String comment){
        driver.findElement(orderRentDataComment).sendKeys(comment);
    }
    //метод нажатия кнопки Заказать
    private void clickOrderRentDataOrderButton(){
        driver.findElement(orderRentDataOrderButton).click();
    }
    //собирательный метод заполнения данных про аренду и нажатия кнопки Заказать
    public void enterRentDataPage(String data, int days, String color, String comment){
        enterOrderRentDataWhenDelivery(data);
        chooseOrderRentDataRentalPeriod(days);
        chooseColor(color);
        enterOrderRentDataComment(comment);
        new WebDriverWait(driver, 3);
        clickOrderRentDataOrderButton();
    }
}

