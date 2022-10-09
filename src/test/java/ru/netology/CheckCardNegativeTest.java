package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckCardNegativeTest {

        private WebDriver driver;

        @BeforeAll
        static void setUpAll() {
            WebDriverManager.chromedriver().setup();
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
        void shouldCheckCardNegative1() {
            driver.get("http://localhost:9999/");
            driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Ivanov Ivan"); // ФИО на латинице
            driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79251234567");
            driver.findElement(By.className("checkbox")).click();
            driver.findElement(By.tagName("button")).click();
            String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
            String actual = driver.findElement(By.className("input__sub")).getText();
            Assertions.assertEquals(expected, actual);
        }
    @Test
    void shouldCheckCardNegative2() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).isDisplayed(); // пропущено ФИО
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79251234567");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.className("input__sub")).getText();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCheckCardNegative3() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("$@#$@#$@#"); // вместо ФИО специсимволы
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79251234567");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.className("input__sub")).getText();
        Assertions.assertEquals(expected, actual);
    }
}




