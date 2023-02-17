package udemy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	WebDriver driver = new ChromeDriver();
	
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		    driver.get("https://gmail.com");
		driver.manage().window().maximize();
		    driver.findElement(By.id("identifierId")).sendKeys("test839786@gmail.com");
		    driver.findElement(By.id("identifierNext")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing786");
		    driver.findElement(By.id("passwordNext")).click();
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='T-I T-I-KE L3']")));
		    driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='agP aFw']")));
		    driver.findElement(By.xpath("//input[@class='agP aFw']")).sendKeys("test839786@gmail.com");
		    driver.findElement(By.xpath("//input[@class='agP aFw']")).sendKeys(Keys.ENTER);
		    WebElement Subject = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		    Subject.click();
		    Subject.sendKeys("Test Mail");
		  WebElement msg = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"));
		  msg.click();
		  msg.sendKeys("Test Email Body");

		  driver.findElement(By.xpath("//div[@class='J-JN-M-I J-J5-Ji Xv L3 T-I-ax7 T-I']")).click();

		 Actions action = new Actions(driver);
		WebElement label =driver.findElement(By.xpath("(//div[@class='J-N-Jz'])[9]")); 
		 action.moveToElement(label).perform();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
 WebElement social = driver.findElement(By.xpath("(//div[@class='J-LC-Jz'])[1]"));
 
 action.moveToElement(social).click().perform();

  WebElement sendbutton =   driver.findElement(By.xpath("//div[text()='Send']"));
  action.moveToElement(sendbutton).click().perform();
 
  driver.findElement(By.xpath("//div[@class='aAy aKe-aLe']")).click();

  List<WebElement> emails = driver.findElements(By.xpath("//table[@class='F cf zt']"));
List<WebElement> matchingEmails = new ArrayList<>();

wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("(//div[@class='vh'])[1]"))));	

for(WebElement email:emails) {
	
	if(!email.getText().contains("Ad")) {

		
		
	if(email.getText().contains("Test Email")) {
	
		matchingEmails.add(email);
	WebElement	requiremail =  matchingEmails.get(0);
	
        requiremail.findElement(By.xpath("(//span[@class='aXw T-KT'])")).click();

    
	}
}
}


wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='aXw T-KT'])")));



driver.findElement(By.xpath("(//div[@class='aAy aIf-aLe'])")).click();

List<WebElement> emailinbox = driver.findElements(By.xpath("//table[@class='F cf zt']/tbody/tr"));

List<WebElement> inboxmailmatch = new ArrayList<>();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
for(WebElement emailin:emailinbox) {
	if(emailin.getText().contains("Test Mail")) {

	inboxmailmatch.add(emailin);
	inboxmailmatch.get(0).click();
	}
	

}

  driver.findElement(By.xpath("(//div[@class='T-I J-J5-Ji T-I-Js-Gs mw T-I-ax7 L3'])[2]")).click();

  

WebElement labelverify =     driver.findElement(By.xpath("//div[@class='J-LC J-Ks-KO J-LC-JR-Jp']"));


	if(labelverify.isEnabled()) {
		System.out.println("Mail is label with Social");
	}else {
		System.out.println("Mail is not label with social");
	}
	
	String expsubject = "Test Mail";
	
	String actsubject =  driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	
	if(expsubject.equals(actsubject)) {
		System.out.println("Subject is verified");
	}else {
		System.out.println("Subject is not verified");
	}
	
String	expbody = "Test Email Body";

String actbody = driver.findElement(By.xpath("(//div[@class='a3s aiL '])[1]")).getText();

if(expbody.equals(actbody)) {
	System.out.println("Body is verified");
}else {
	System.out.println("Body is not verified");
}

driver.quit();
	}
}


