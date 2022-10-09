package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckCardNegativeTest {

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
        void shouldCheck2() {
            driver.get("http://localhost:9999/");

        }
    }

