package pagesScooterTest.chrome;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPageScooter;

@RunWith(Parameterized.class)
public class TestImpotantQuestions {

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

    //номер индекса
    private final int listIndex;

    //конструктор класса раздела Вопросы о важном
    public TestImpotantQuestions(int listIndex){
        this.listIndex = listIndex;
    }

    //задаем индекс для выбора вопросов/ответов/ожидаемых значений
    @Parameterized.Parameters
    public static Object[][] getListIndex(){
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
        };
    }

    @Test
    public void isVisibleAnswerWhenClickButtonImportantQuestions(){
        //Создать объект главной страницы
        MainPageScooter objHomePageScooter = new MainPageScooter(driver);
        //открыть главную страницу
        objHomePageScooter.openMainPageScooter();
        //закрыть панель куки
        objHomePageScooter.clickCloseCookieButton();
        //нажимать по кнопкам вопросов раздела Вопросы о важном
        objHomePageScooter.clickButtonsImportantQuestions(listIndex);
        //сравнить ответ с ожидаемым ответом
        Assert.assertTrue(objHomePageScooter.contentAnswerImportantQuestions(listIndex));
    }

}
