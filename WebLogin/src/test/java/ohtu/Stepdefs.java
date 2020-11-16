package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    

    @Given("user with username {string} with password {string} with passwordConfirmation {string} is created")
    public void userLoggingIn(String username, String password, String passwordConfirmation) {
        signUpWith(username, password, passwordConfirmation);   
    }

    @Given("continue to application mainpage is selected")
    public void mainpageIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click();
        driver.get(baseUrl);
        WebElement element2 = driver.findElement(By.linkText("logout"));       
        element2.click();
    }

    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }   
    
    // @Then("user is logged in")
    // public void userIsLoggedIn() {
    //     pageHasContent("Ohtu Application main page");
    // }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void incorrectUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }       

    @When("incorrect username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }      

    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   





    @Given("new user is selected")
    public void registerNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }
    @When("valid username {string} and password {string} and passwordConfirmation {string} are entered")
    public void correctUsernameAndPasswordAreGiven(String username, String password, String passwordConfirmation) {
        signUpWith(username, password, passwordConfirmation);
    }

    @When("invalid username {string} and password {string} and passwordConfirmation {string} are entered")
    public void inCorrectUsernameAndPasswordAreGiven(String username, String password, String passwordConfirmation) {
        signUpWith(username, password, passwordConfirmation);
    }

    @When("valid username {string} and incorrect password {string} and passwordConfirmation {string} are entered")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password, String passwordConfirmation) {
        signUpWith(username, password, passwordConfirmation);
    }

    @When("valid username {string} and correct password {string} and incorrect passwordConfirmation {string} are entered")
    public void incorrectPasswordConfirmationAreGiven(String username, String password, String passwordConfirmation) {
        signUpWith(username, password, passwordConfirmation);
    }




    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    } 



    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }


    private void signUpWith(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);        
        element = driver.findElement(By.name("signup"));
        element.submit();  
    }
}
