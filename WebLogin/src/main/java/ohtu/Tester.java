package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");


        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        


        
        
        sleep(2);
        
        //WebElement element = driver.findElement(By.linkText("login"));
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        // tulostetaan sivu konsoliin
        //System.out.println(driver.getPageSource());        

        sleep(2);
 
        Random r = new Random();
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");        
        element.sendKeys("wrong");        
        element = driver.findElement(By.name("signup"));

        
        
        sleep(2);
        element.submit();

        // sleep(3);
        // element = driver.findElement(By.name("ohtu"));
        // sleep(4);
        // element.submit();         

        // sleep(5);
        // element = driver.findElement(By.name("logout"));
        // sleep(6);
        // element.submit();        
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
