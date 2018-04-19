import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    By loginlocator = By.id("inputLogin");
    By passlocator = By.id("inputPassword");
    By submitlocator = By.xpath("//button[@type='submit']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeinputLogin(String inputLogin) {
        driver.findElement(loginlocator).sendKeys(inputLogin);
        return this;
    }

    public LoginPage typeinputPassword(String inputPassword) {
        driver.findElement(passlocator).sendKeys(inputPassword);
        return this;
    }

    public HomePage submitLogin() {
        driver.findElement(submitlocator).submit();
        return new HomePage(driver);
    }

    public LoginPage submitLoginFail()
    {
        driver.findElement(submitlocator).submit();
        return new LoginPage(driver);
    }

    public HomePage LoginFail(String inputLogin, String inputPassword) {
        typeinputLogin("operato");
        typeinputPassword("operator");
        return submitLogin();
    }

    public HomePage LoginFail1(String inputLogin, String inputPassword) {
        typeinputLogin("operator");
        typeinputPassword("operato");
        return submitLogin();
    }

    public HomePage LoginAs(String inputLogin, String inputPassword) {
        typeinputLogin("operator");
        typeinputPassword("operator");
        return submitLogin();
    }
}
