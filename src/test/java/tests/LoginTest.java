package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterEach
    public void tearDown(){
        if (driver!=null){
            driver.close();
        }
    }
    @Test
    public void testValidLogin(){
        //Given
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");

        //When
        loginPage.clickLogin();

        //Then
        String title = driver.getTitle();
        assertEquals("OrangeHRM", title);
    }

    @Test
    public void testInvalidUsernameLogin(){
        //Given
        loginPage.enterUsername("Admi");
        loginPage.enterPassword("admin123");

        //When
        loginPage.clickLogin();

        //Then
        String exception = loginPage.getExceptionMessage();
        assertEquals("Invalid credentials", exception);
    }
}
