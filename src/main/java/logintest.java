import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class logintest {
  WebDriver driver;

  @BeforeTest
  public void setUp() {

  System.setProperty("webdriver.chrome.driver","./drv/chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  driver.get("https://mail.ru");
}

  @AfterTest
  public void close_driver() {
    driver.close();
  }


  @Test
  public void Simpletest() {
    WebDriverWait wait;
    MainPage main = new MainPage(driver);
    wait = new WebDriverWait(driver, 15);
    WebElement login = wait.until(ExpectedConditions.elementToBeClickable(main.getLogin()));
    main.setLogin(TestConstants.MAIL_LOGIN);
    main.clickSubmit();
    WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(main.getPass()));
    main.setPassword(TestConstants.MAIL_PASSWORD);
    main.clickSubmit();

    MailBoxPage mailBox = new MailBoxPage(driver);
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(mailBox.getNewMailButton()));
    mailBox.clickNewMail();
    WebElement mailTo = wait.until(ExpectedConditions.elementToBeClickable(mailBox.getMailTo()));
    mailBox.setTextMailTo("k.n.ivanov@mail.ru");
    mailBox.setSubject("Тестовое письмо");
    mailBox.setBody("Отправка тестового письма");
    mailBox.clickSend();
    String status = mailBox.getStatusText();
    System.out.println("status = " + status);
    System.out.println("Тест завершен Успешно");

  }
}



