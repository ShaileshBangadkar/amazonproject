package pageObjects;

import org.openqa.selenium.By;

import static baseClass.BaseClass.driver;

public class loginPage {
    private By procced = By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input");
    private By enterMobileNo = By.xpath("//*[@id='ap_email']");
    private By continu = By.xpath("//*[@id='continue']");
    private By password = By.xpath("//*[@id='ap_password']");
    private By signIn = By.xpath("//*[@id='signInSubmit']");
    private By address = By.xpath("//*[@id='shipToThisAddressButton']/span/input");
    public void clickOnProceed()
    {
        driver.findElement(procced).click();
    }
    public void enterMobileNo(String MOB){
        driver.findElement(enterMobileNo).sendKeys(MOB);
    }
    public void clickOnContinue()
    {
        driver.findElement(continu).click();
    }
    public void enterPassword(String PASS){
        driver.findElement(password).sendKeys(PASS);
    }
    public void clickOnSignIn()
    {
        driver.findElement(signIn).click();
    }

    public void useThisAddress() {
        driver.findElement(address).click();
    }
}
