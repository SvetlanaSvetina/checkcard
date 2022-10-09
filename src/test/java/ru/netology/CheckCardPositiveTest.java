package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckCardPositiveTest {

    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        //  System.setProperty("webdriver.chrome.driver", "driver/chromedriver"); как на лекции
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
    void shouldCheck1() {
        driver.get("http://localhost:9999/");

    }
}