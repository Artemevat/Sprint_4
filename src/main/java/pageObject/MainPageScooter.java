package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageScooter {

    private WebDriver driver;
    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //локатор для верхней кнопки Заказать
    private By topOrderButton = By.className("Button_Button__ra12g");

    //локатор для нижней кнопки Заказать
    private By bottomOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    //локатор для вопросов
    private By buttonImportantQuestions = By.xpath(".//*[@class = 'accordion__button']");

    //локатор для ответов
    private By answerImportantQuestions = By.xpath(".//*[@class = 'accordion__panel' and not(@hidden)]/p");

    //массив ожидаемых ответов
    private String[] expectedAnswerImportantQuestions = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    //локатор кнопки закрыть куки
    private By closeCookieButton = By.id("rcc-confirm-button");

    //константа адреса страницы
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    //метод открытия страницы
    public void openMainPageScooter(){
        driver.get(PAGE_URL);
    }

    //метод нажатия панели куки
    public void clickCloseCookieButton(){
        driver.findElement(closeCookieButton).click();
    }

    //метод нажатия на верхнюю кнопку заказать
    public void clickTopOrderButton(){
        driver.findElement(topOrderButton).click();
    }

    //метод нажатия на нижнюю кнопку заказать (с прокруткой до кнопки)
    public void clickBottomOrderButton() {
        WebElement element = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(bottomOrderButton).click();
    }

    //метод выбора кнопки Заказать
    private static final String UP_LOCATION_PAGE = "up";
    private static final String DOWN_LOCATION_PAGE = "down";

    public void chooseOrderButton(String locationButton){
        if (locationButton.equals(UP_LOCATION_PAGE)){
            clickTopOrderButton();
        } else if (locationButton.equals(DOWN_LOCATION_PAGE)) {
            clickBottomOrderButton();
        }
    }

    //лист элементов с вопросами
    private List<WebElement> getImportantQuestions(){
        return driver.findElements(buttonImportantQuestions);
    }

    //клик по вопросу в зависимости от индекса
    public void clickButtonsImportantQuestions(int listIndex){
        WebElement element = driver.findElement(buttonImportantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //подождать отображения
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonImportantQuestions));
        getImportantQuestions().get(listIndex).click();
    }

    //получить ответ на вопрос
    public String getAnswerImportantQuestions(int listIndex){
        return driver.findElement(answerImportantQuestions).getText();
    }

    //метод сравнения ответа с ожидаемым текстом ответа раздела Вопросы о важном
    public boolean contentAnswerImportantQuestions(int listIndex){
        //By answer = answersImportantQuestionsArray[listIndex];
        By answer = buttonImportantQuestions;
        String expectedAnswer = expectedAnswerImportantQuestions[listIndex];
        //подождать пока загрузится
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(answer));
        return driver.findElement(answer).isDisplayed() && getAnswerImportantQuestions(listIndex).equals(expectedAnswer);
    }
}