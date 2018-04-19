import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    By chooselocator = By.xpath("//form/button");
    By filial = By.id("selectKitchen");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public  HomePage filial()
    {
        driver.findElement(filial).click();
        return this;
    }
    public MainPage chooselocator() {
        driver.findElement(chooselocator).submit();
        return new MainPage(driver);
    }
}
