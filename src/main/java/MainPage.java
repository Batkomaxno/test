import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage
{
    private By login = By.id("mailbox:login");
    private By submit = By.id("mailbox:submit");
    private By password = By.id("mailbox:password");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLogin(String value) {
        driver.findElement(login).sendKeys(value);
    }

    public void setPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public By getLogin() {
        return login;
    }

    public By getPass() {
        return password;
    }

    public void clickSubmit() {
        driver.findElement(submit).click();
    }
}
