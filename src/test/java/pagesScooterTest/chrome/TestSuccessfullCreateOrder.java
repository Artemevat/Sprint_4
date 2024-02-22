package pagesScooterTest.chrome;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.*;

@RunWith(Parameterized.class)
public class TestSuccessfullCreateOrder {

    @Before
    public void setUp() {
        //подключение драйвера браузера
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

    private WebDriver driver;
    private final String locationButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String data;
    private final int days;
    private final String color;
    private final String comment;

    //конструктор класса
    public TestSuccessfullCreateOrder(String locationButton, String name, String surname, String address, String metro, String phone, String data, int days, String color, String comment){
        this.locationButton = locationButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.data = data;
        this.days = days;
        this.color = color;
        this.comment = comment;
    }

    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getDataCreateOrder(){
        return new Object[][]{
                {"up", "Татьяна", "Артемьева", "Парковая", "Митино", "89111111111", "26.02.2024", 3, "black", ""},
                {"down", "Александр", "Казанцев", "Просторная", "Сокольники","89121221212", "29.02.2024", 7, "gray", "с комментарием" },
        };
    }

    @Test
    public void createOrderScooter(){
        //создать объект главной страницы
        MainPageScooter objMainPageScotter = new MainPageScooter(driver);
        //открыть сайт
        objMainPageScotter.openMainPageScooter();
        //закрыть панель куки
        objMainPageScotter.clickCloseCookieButton();
        //нажать Заказать
        objMainPageScotter.chooseOrderButton(locationButton);
        //создать объект страницы данных клиента для заказа
        OrderClientDataPage objOrderClientDataPage = new OrderClientDataPage(driver);
        //заполнить данные по клиенту
        objOrderClientDataPage.enterOrderClientDataPage(name, surname, address, metro, phone);
        //создать объект страницы данных об аренде
        OrderRentDataPage objOrderRentDataPage = new OrderRentDataPage(driver);
        //заполнить данные об аренде и нажать Заказать
        objOrderRentDataPage.enterRentDataPage(data, days, color, comment);
        //создать объект страницы подтверждения заказа
        ConfirmationOrderPage objConfirmationOrderPage = new ConfirmationOrderPage(driver);
        //нажать Да - подтвердить заказ
        objConfirmationOrderPage.clickConfirmationOrderButtonYes();
        //создать объект страницы успешного заказа
        SuccessfulOrderPage objSuccessfulOrderPage = new SuccessfulOrderPage(driver);
        //проверить, что есть сообщение об успешном заказе
        Assert.assertTrue(objSuccessfulOrderPage.successfulOrderTextIsDisplayed());
    }
}
