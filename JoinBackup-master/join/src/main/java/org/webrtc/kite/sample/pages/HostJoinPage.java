package org.webrtc.kite.sample.pages;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cosmosoftware.kite.exception.KiteInteractionException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;
import io.cosmosoftware.kite.util.WebDriverUtils;

public class HostJoinPage extends BasePage {

	private static final String TELEBU_PAGE = "https://join.telebu.com/";

	public static String roomId = "https://join.telebu.com/meeting/GnHccOJQ";
	public static String webinarRoomId = "https://staging-join.telebu.com/broadcast/O9xBMpyCK";
	public String meetingType = null;
	static GetOTPFunctionality otppage = null;

	public HostJoinPage(Runner runner) {
		super(runner);
		webDriver.get(TELEBU_PAGE);
		webDriver.manage().window().maximize();
		otppage = new GetOTPFunctionality(runner);
	}
    

	
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendotp;

	@FindBy(xpath = "//input[@class='input__control--text']")
	WebElement roomlink;

	@FindBy(xpath = "/html/body/app-root/web-component/home/main/section/section/section/room-info/div[2]/button")
	WebElement start;

	@FindBy(xpath = "/html/body/app-root/web-component/home/main/section/section/section/broadcast-info/div[2]/button")
	WebElement startWebinar;

	@FindBy(xpath = "//button[@class='transprent__button']")
	WebElement skip;

	@FindBy(xpath = "//input[@name='userName']")
	WebElement meetingname;

	@FindBy(xpath = "//div[@class='paper-foot']/button[@type='submit']")
	WebElement next;

	
	@FindBy(xpath = "/html/body/app-root/web-component/home/main/section/section/div/button[2]")
	WebElement selectWebinar;

	@FindBy(xpath = "//button[text()='Webinar']")
	WebElement Webinar;

	@FindBy(xpath = "//div[@class='paper width-md nickname-popup']/div/div/label")
	WebElement permissionmsg;

	@FindBy(xpath = "//video[@id='vid']")
	WebElement echoVideotest;

	public void createRoom() {
		email.sendKeys("imran.mohammad@smscountry.com");
		sendotp.click();
		otppage.clickEmail();

	}

	public void Selectwebinar() {

		selectWebinar.click();

	}

	public void ShareMeetingLink() {
		System.out.println("sharelink");
		try {
			waitUntilVisibilityOf(roomlink, 5);
		} catch (KiteInteractionException e) {

			e.printStackTrace();
		}
		roomId = roomlink.getAttribute("placeholder");
		System.out.println(roomId);

	}

	public void ShareWebinarLink() {
		System.out.println("sharelink");
		try {
			waitUntilVisibilityOf(roomlink, 5);
		} catch (KiteInteractionException e) {

			e.printStackTrace();
		}
		webinarRoomId = roomlink.getAttribute("placeholder");
		System.out.println(roomId);

	}

	public void StartMeeting() {
		try {
			waitUntilVisibilityOf(start, 5);
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start.click();
		System.out.println("click start");

	}

	public void StartWebinar() {
		try {
			waitUntilVisibilityOf(startWebinar, 5);
		} catch (KiteInteractionException e) {

			e.printStackTrace();
		}
		startWebinar.click();
		System.out.println("click start Webinar");

	}

	public void SkipEchotest() throws InterruptedException {

		Thread.sleep(2000);

		if (skip.isDisplayed() && echoVideotest.isDisplayed()) {
			skip.click();
		}

		else {
			logger.info(permissionmsg.getText());
			webDriver.close();
		}

		logger.info("skip echo in host");

	}

	public void meetingname() {
		logger.info("in meetingname fill");
		meetingname.clear();
		meetingname.sendKeys("HOST");
		logger.info("meeting name done in host");
		next.click();

	}
	
	
	public void Profile()
	{
		
	}

}
