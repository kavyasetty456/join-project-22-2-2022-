package org.webrtc.kite.sample.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;

public class GetOTPFunctionality extends BasePage {

	By email = By.xpath("//input[@id='identifierId']");
	By pswd = By.xpath("//input[@name='password']");
	By nextButton = By.xpath("//*[@id='passwordNext']/span");
	By profilelogoValidation = By.xpath("//span[@class='gb_xa gbii']");
	By inboxEmails = By.xpath("//span[@class='bog']//span");
	By totalmsg = By.xpath("//div[2]/table/tbody/tr[3]/td/div/span[last()]");
	By oTPBox = By.xpath("//div[@class='otp__container']/input");

	public GetOTPFunctionality(Runner runner) {
		super(runner);
	}

	public void enterEmail(String emailID) {
		WebElement emailField = webDriver.findElement(email);
		webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Actions actions = new Actions(webDriver);
		actions.moveToElement(emailField);
		actions.click();
		actions.sendKeys(emailID, Keys.ENTER);
		actions.build().perform();
	}

	public void enterPassword(String password) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		webDriver.findElement(pswd).sendKeys(password, Keys.ENTER);
		webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	public void EmailVerification(String emailSubject) {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		List<WebElement> emailThreads = webDriver.findElements(inboxEmails);
		// System.out.println(emailThreads.size());
		for (int i = 0; i < emailThreads.size(); i++) {
			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				System.out.println("email clicked");
				break;
			}
		}
	}

	public String getOTP() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String myText = webDriver.findElement(totalmsg).getText();
		String[] splited = myText.split("\\s+");
		int index = splited.length - 1;
		System.out.println("Your OTP is " + splited[index]);
		return splited[index];

	}

	public void enterOTP(String otpval) {

		List<WebElement> ele = webDriver.findElements(oTPBox);
		for (int i = 0; i < otpval.length(); i++) {
			char j = otpval.charAt(i);
			// System.out.println("digit: " + j);
			String s = Character.toString(j);
			ele.get(i).sendKeys(s);
		}
	}

	public void clickEmail() {
		((JavascriptExecutor) webDriver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs.get(1));
		webDriver.get("https://mail.google.com");

		enterEmail("imran.mohammad@smscountry.com");// Enter email id
		enterPassword("imran315093");// Enter password
		EmailVerification("Email Verification");// Enter email subject you want to click

		String oTPValue = getOTP();
		webDriver.close();
		webDriver.switchTo().window(tabs.get(0));
		enterOTP(oTPValue);
	}

}
