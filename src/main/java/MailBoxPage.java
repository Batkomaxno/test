import org.openqa.selenium.*;

public class MailBoxPage {
    By newMail = By.xpath("//span[contains(text(),'Написать письмо')]");
    By mailTo = By.xpath("(//input[@type='text'])[1]");
    By subject = By.name("Subject");
    By body = By.xpath("(*//div[@dir='true']/../div/div/div)[1]");
    By send = By.xpath("//span[contains(text(),'Отправить')]");
    By status = By.xpath("//div[@class='layer__header']");

    private final WebDriver driver;

    public MailBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewMail() {
        driver.findElement(newMail).click();
    }

    public By getNewMailButton() {
        return newMail;
    }

    public void setTextMailTo(String value) {
        driver.findElement(mailTo).sendKeys(value);
    }

    public By getMailTo() {
        return mailTo;
    }

    public void setSubject(String value) {
        driver.findElement(subject).sendKeys(value);
    }

    public void setBody(String value) {
        driver.findElement(body).click();
        driver.findElement(body).sendKeys(value);
    }
    public void clickSend() {
        driver.findElement(send).click();
    }

    public String getStatusText() {
        try {
            return driver.findElement(status).getText();
        } catch (NoSuchElementException e) {
        } return "NoNoSuchElementException";
    }

}
