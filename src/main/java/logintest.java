import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class logintest {
  WebDriver driver = null;

  @BeforeClass
  public void setUp() {
  System.out.println("Инициализруем браузер");
  driver = SDK.init_driver_chrome();
  driver.get("https://mail.ru");
}

  @AfterTest
  public void close_driver() {
    driver.close();
  }


  @Test
  public void main001() {
    driver.get("https://mail.ru");
    WebDriverWait wait;
    MainPage main = new MainPage(driver);
    wait = new WebDriverWait(driver, 15);
    WebElement login = wait.until(ExpectedConditions.elementToBeClickable(main.getLogin()));
    main.setLogin(TestConstants.MAIL_LOGIN);
    main.clickSubmit();
    WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(main.getPass()));
    main.setPassword(TestConstants.MAIL_PASSWORD);
    main.clickSubmit();
    System.out.println("Успешная авторизация");

    MailBoxPage mailBox = new MailBoxPage(driver);
    WebElement newMail = wait.until(ExpectedConditions.elementToBeClickable(mailBox.getNewMailButton()));
    mailBox.clickNewMail();
    WebElement mailTo = wait.until(ExpectedConditions.elementToBeClickable(mailBox.getMailTo()));
    mailBox.setTextMailTo("k.n.ivanov@mail.ru");
    mailBox.setSubject("Тестовое письмо");
    mailBox.setBody("Отправка тестового письма");
    mailBox.clickSend();
    System.out.println("Письмо отправлено");
    String status = mailBox.getStatusText();
    System.out.println("status = " + status);
    System.out.println("Тест завершен Успешно");

  }

  //Api тесты открытого сервиса https://reqres.in
  @Test
  public void main002() {
    //Метод POST
    String json = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
    given().contentType("application/json").body(json).when()
            .post("https://reqres.in/api/users").then().statusCode(201);

    //Дергаем GET
    given().contentType("application/json").when().
            get("https://reqres.in/api/users/2").then()
            .body("data.id", notNullValue())
            .body("data.email", notNullValue());

    //Дергаем PUT и проверяем изменения
    String json1 = "{\"name\":\"morpheus\",\"job\":\"zion resident\"}";
    String response = given().contentType("application/json").body(json1).when()
            .post("https://reqres.in/api/users/2").asString();
    String job = RestApi.get_value_from_json(response, "job");
    Assert.assertEquals(job, "zion resident");

    //Дергаем DELETE
    given().contentType("application/json").when().delete("https://reqres.in/api/users/2").then().statusCode(204);
  }
}



