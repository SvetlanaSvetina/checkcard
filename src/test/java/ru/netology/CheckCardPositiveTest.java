package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckCardPositiveTest {

    private WebDriver driver; // подключаем веб-драйвер

    @BeforeAll
    static void setUpAll() {
        //  System.setProperty("webdriver.chrome.driver", "driver/chromedriver"); как на лекции
        WebDriverManager.chromedriver().setup(); // подключаем веб-менеджер драйвер
    }

    @BeforeEach
    void setUp() {
        // driver = new ChromeDriver(); как на лекции
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);

    }

    @AfterEach
    void tearsDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldCheckCardPossitive() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Иванов Иван"); // ФИО
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79251234567"); // номер телефона
        driver.findElement(By.className("checkbox")).click(); // чек-бокс
        driver.findElement(By.tagName("button")).click(); // кнопка "продолжить"
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        Assertions.assertEquals(expected, actual);
    }

}
