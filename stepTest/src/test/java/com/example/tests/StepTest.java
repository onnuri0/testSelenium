package com.example.tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StepTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	/*
	 * 크롬일 경우 Web Driver 셋팅
	CHROMEDRIVER_FILE_PATH = "F:/programs/eclipse-jee-neon-3-win32-x86_64/webdrive/chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_FILE_PATH);
	driver = new ChromeDriver();
	*/
	
	// Firefox 일경우 web Driver 셋팅
	String CHROMEDRIVER_FILE_PATH = "F:/programs/eclipse-jee-neon-3-win32-x86_64/webdrive/geckodriver.exe";
	System.setProperty("webdriver.gecko.driver", CHROMEDRIVER_FILE_PATH);
	driver = new FirefoxDriver();
	
	baseUrl = "http://localhost:8080/ex1/";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testStep() throws Exception {
	  System.out.println(baseUrl);
    driver.get(baseUrl);
//    driver.get("http://seleniumhq.com");
    driver.findElement(By.name("step1")).click();
    driver.findElement(By.id("id")).clear();
    driver.findElement(By.id("id")).sendKeys("apple");
    driver.findElement(By.id("pw")).clear();
    driver.findElement(By.id("pw")).sendKeys("Wkddlfksmd");
    driver.findElement(By.id("nextStep")).click();
    driver.findElement(By.cssSelector("input.inputb")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
