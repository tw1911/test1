package com.tw1911.test1;

import com.beust.jcommander.Parameter;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GoogleSearchTests {

    @DataProvider(name = "browser-provider", parallel = true)
    public Object[] provide() throws Exception {
        return new Object[]{"firefox", "chrome"};

    }

    @Test(dataProvider = "browser-provider", threadPoolSize = 2)
    public void testGoogleSearch(String browser){
        SelenideDriver driver = new SelenideDriver(new SelenideConfig()
                .browser(browser)
                .driverManagerEnabled(true)
                .remote("http://devedu-05:4444/wd/hub")
                .headless(true));
        driver.open("http://google.com");
        driver.$(By.name("q")).setValue("Тестовое задание");
        driver.$(By.xpath("//input[@value='Поиск в Google']")).click();
        driver.$(By.id("resultStats")).shouldBe(Condition.visible);
        driver.close();

    }
    @BeforeClass
    public static void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterClass
    public static void tearDown(){
        SelenideLogger.removeListener("allure");
    }
}
