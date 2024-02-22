package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageScooter {

    private WebDriver driver;
    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //локатор для верхней кнопки Заказать
    private By topOrderButton = By.className("Button_Button__ra12g");

    //локатор для нижней кнопки Заказать
    private By bottomOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    //локаторы кнопок вопросов раздела Вопросы о важном
    private By buttonImportantQuestions_0 = By.id("accordion__heading-0");
    private By buttonImportantQuestions_1 = By.id("accordion__heading-1");
    private By buttonImportantQuestions_2 = By.id("accordion__heading-2");
    private By buttonImportantQuestions_3 = By.id("accordion__heading-3");
    private By buttonImportantQuestions_4 = By.id("accordion__heading-4");
    private By buttonImportantQuestions_5 = By.id("accordion__heading-5");
    private By buttonImportantQuestions_6 = By.id("accordion__heading-6");
    private By buttonImportantQuestions_7 = By.id("accordion__heading-7");

    //Массив кнопок вопросов
    private By[] buttonsImportantQuestionsArray = {buttonImportantQuestions_0, buttonImportantQuestions_1, buttonImportantQuestions_2, buttonImportantQuestions_3, buttonImportantQuestions_4, buttonImportantQuestions_5, buttonImportantQuestions_6, buttonImportantQuestions_7};

    //локаторы ответов на вопросы раздела о важном
    private By answerImportantQuestions_0 = By.xpath(".//div[@id='accordion__panel-0']/p");
    private By answerImportantQuestions_1 = By.xpath(".//div[@id='accordion__panel-1']/p");
    private By answerImportantQuestions_2 = By.xpath(".//div[@id='accordion__panel-2']/p");
    private By answerImportantQuestions_3 = By.xpath(".//div[@id='accordion__panel-3']/p");
    private By answerImportantQuestions_4 = By.xpath(".//div[@id='accordion__panel-4']/p");
    private By answerImportantQuestions_5 = By.xpath(".//div[@id='accordion__panel-5']/p");
    private By answerImportantQuestions_6 = By.xpath(".//div[@id='accordion__panel-6']/p");
    private By answerImportantQuestions_7 = By.xpath(".//div[@id='accordion__panel-7']/p");

    //Массив ответов на вопросы
    private By[] answersImportantQuestionsArray = {answerImportantQuestions_0, answerImportantQuestions_1, answerImportantQuestions_2, answerImportantQuestions_3, answerImportantQuestions_4, answerImportantQuestions_5, answerImportantQuestions_6, answerImportantQuestions_7};

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

    //как прописать вариации с разными кнопками Заказать?метод выбора кнопки
    private static final String UP_LOCATION_PAGE = "up";
    private static final String DOWN_LOCATION_PAGE = "down";

    public void chooseOrderButton(String locationButton){
        if (locationButton.equals(UP_LOCATION_PAGE)){
            clickTopOrderButton();
        } else if (locationButton.equals(DOWN_LOCATION_PAGE)) {
            clickBottomOrderButton();
        }
    }


    //Методы раздела Вопросы о важном
    //метод нажатия на кнопки в разделе Вопросы о важном (с прокруткой до кнопки)
    public void clickButtonsImportantQuestions(int listIndex) {
        By questions = buttonsImportantQuestionsArray[listIndex];
        WebElement element = driver.findElement(questions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //подождать отображения
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(questions));
        driver.findElement(questions).click();
    }

    //метод получения текста из ответов раздела Вопросы о важном
    public String getAnswerImportantQuestions(int listIndex){
        By answer = answersImportantQuestionsArray[listIndex];
        return driver.findElement(answer).getText();
    }
    //метод сравнения ответа с ожидаемым текстом ответа раздела Вопросы о важном
    public boolean contentAnswerImportantQuestions(int listIndex){
        By answer = answersImportantQuestionsArray[listIndex];
        String expectedAnswer = expectedAnswerImportantQuestions[listIndex];
        //подождать пока загрузится
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(answer));
        return driver.findElement(answer).isDisplayed() && getAnswerImportantQuestions(listIndex).equals(expectedAnswer);
    }
}