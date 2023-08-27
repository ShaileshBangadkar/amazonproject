package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.text.similarity.LevenshteinDistance;


import java.time.Clock;

import static baseClass.BaseClass.driver;
import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertTrue;

public class amazonPage {
    public static int minPrice;
    public static int maxPrice;

    public static String productName;
    public static WebElement priceProduct;
    public static String selectedProductName;


    private  By search = By.id("twotabsearchtextbox");
    private By searchButton = By.xpath("//input[@type='submit']");
    private By min = By.id("low-price");
    private By max = By.id("high-price");
    private By price = By.xpath("//span[@class='a-price-whole']");

    private By mrp = By.xpath("(//span[@class='a-price-whole'])[1]");
    private By nameOfSelectedProduct = By.xpath("//span[@id='productTitle']");

    private By textDisplayed = By.xpath("//span[text()='Shoes']");

    private By selectSize = By.xpath("//select[@name='dropdown_selected_size_name']");

    private By goToCart = By.xpath("//*[@id='sw-gtc']/span/a");

    private By cart = By.xpath("//input[@value='Add to Cart']");
    private By go = By.xpath("(//input[@type='submit'])[2]");
    private By checkoutProduct = By.xpath("(//span[@class='a-truncate-cut'])[1]");

    public void enterProduct(String product)
    {
        driver.findElement(search).sendKeys(product);
        productName = product;
    }
    public void clickOnSearchButton()
    {
        driver.findElement(searchButton).click();
    }

    public void enterMinPrice(String low){

        driver.findElement(min).sendKeys(low);
        minPrice= parseInt(low);

    }
    public void enterMaxPrice(String high){

        driver.findElement(max).sendKeys(high);
        maxPrice=parseInt(high);
    }
    public void priceOfProduct() {
//        String selectedProduct = driver.findElement(nameOfSelectedProduct).getText();
//        driver.findElement(nameOfSelectedProduct).click();
//        selectedProductName = driver.findElement(nameOfSelectedProduct).getText();

        priceProduct = driver.findElement(mrp);
        priceProduct.click();
        selectedProductName = driver.findElement(nameOfSelectedProduct).getText();


    }
    public void verifyProductDisplayed()
    {
Assert.assertEquals("Selected product displayed successfully",driver.findElement(textDisplayed).getText(),productName);
    }
    public void verifyFilteredPrice()
    {
        if( parseInt(driver.findElement(mrp).getText()) >= minPrice &&  parseInt(driver.findElement(price).getText()) <= maxPrice)
        {
           System.out.print("product price is as per filtered price");
        }
        else {
            System.out.print("product price is not as per filtered price");
        }
    }


    public void selectSizeOfProduct(String size) {
        scrollBy(selectSize);
        Select select = new Select(driver.findElement(selectSize));

        select.selectByVisibleText(size);
    }

      public void scrollBy(By webElement)
  {
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(webElement));
  }

    public void addToCart() {
        driver.findElement(cart).click();
    }

    public void clickOnGo() {

        driver.findElement(go).click();
    }

    public void clickOnGoToCart() throws InterruptedException {
        Thread.sleep(10000);
        WebElement cartvalue = driver.findElement(goToCart);
        cartvalue.click();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();",cartvalue);
    }

    public void VerifiedThatTheCorrectProductAndOptionsAreDisplayed() {

                String string1 = driver.findElement(checkoutProduct).getText();
                String string2 = selectedProductName;

                double similarity = calculateWordSimilarity(string1, string2);

                double similarityThreshold = 0.5; // Set your desired threshold
        boolean flag;
                if (similarity > similarityThreshold) {
                    System.out.println("The product is same");
                    flag=true;
                } else {
                    System.out.println("The product is different");
                    flag=false;
                }

           assertTrue("pass",flag);
        }

    private static double calculateWordSimilarity(String s1, String s2) {
        String[] words1 = s1.split("\\s+");
        String[] words2 = s2.split("\\s+");

        int matchingWords = 0;

        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equalsIgnoreCase(word2)) {
                    matchingWords++;
                    break; // Move to the next word in words1
                }
            }
        }

        int totalWords = Math.max(words1.length, words2.length);

        return (double) matchingWords / totalWords;
    }

        // Assert.assertTrue("Correct product not verified", selectedProductName.contains(driver.findElement(checkoutProduct).getText()));
    public void verifySameProductIsOnPage() {
                String pageSource = driver.getPageSource();
                String targetWord = productName;
                int wordCount = countWordOccurrences(pageSource, targetWord);
                System.out.println("The word '" + targetWord + "' appears " + wordCount + " times on the webpage.");
                assertTrue("Correct product is NOT searched",wordCount>10);
            }

    public void verifySummary() {
        Assert.assertEquals("order summary text not verified","Order Summary",driver.findElement(By.xpath("//*[@id='spc-order-summary']/h3")).getText());

    }
    private static int countWordOccurrences(String text, String word) {
        // Split the text into words
        String[] words = text.split("\\s+");

        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }

        return count;
    }
}


