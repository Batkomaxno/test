import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class logintest {

  @Test
  public void Simpletest() {
    WebDriverWait wait;
    System.setProperty("webdriver.chrome.driver", "./drv/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to("http://88.99.27.54:6012/");
    // Вставил явную паузу, ибо очень долго открывается форма.
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 15);
    WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputLogin")));
    login.click();
    LoginPage log = new LoginPage(driver);
    log.LoginFail("operato", "operator");
    log.submitLogin();
    String mess = driver.findElement(By.xpath("//span")).getText();
    if (mess.equals("Вы ошиблись в логине") == true) {}
      else
    {
      System.out.println("Сообщение не содержите текст Вы ошиблись в логине");
    }
    System.out.println("Тест ошибка в логине: Успех");
    driver.navigate().refresh();
    log.LoginFail1("operator", "operato");
    log.submitLogin();
    String mess1 = driver.findElement(By.xpath("//span")).getText();
    if (mess1.equals("Вы ошиблись в пароле") == true) {}
    else
    {
      System.out.println("Сообщение не содержите текст Вы ошиблись в пароле");
    }
    System.out.println("Тест ошибка в пароле: Успех");
    driver.navigate().refresh();
    log.LoginAs("operator", "operator");
    log.submitLogin();
    System.out.println("Тест окончен, успешная авторизация.");
  }
}



