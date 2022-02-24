package org.webrtc.kite.sample.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cosmosoftware.kite.exception.KiteInteractionException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;

public class ParticipantsJoinPage extends BasePage {

	public ParticipantsJoinPage(Runner runner) {
		super(runner);
		webDriver.manage().window().maximize();
		System.out.println(runner.getWebDriver() + "participant join page");

	}

	public static String meetinglink = null;

	public static int i = 1;

	@FindBy(xpath = "//button[@class='transprent__button']")
	WebElement skip;

	@FindBy(xpath = "//input[@name='userName']")
	WebElement meetingname;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement next;

	@FindBy(xpath = "//div[@class='paper width-md nickname-popup']/div/div/label")
	WebElement permissionmsg;

	public void browsercheck() {
		webDriver.get("https://www.google.com/");

	}

	public void joinMeetingRoom() {

		meetinglink = HostJoinPage.roomId;

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		meetinglink = HostJoinPage.roomId;

		System.out.println(meetinglink);
		webDriver.navigate().to(meetinglink);
		System.out.println(webDriver + "join with link");
		// webDriver.get(meetinglink);

	}

	public void joinWebinarRoom() {

		meetinglink = HostJoinPage.webinarRoomId;

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// meetinglink=HostJoinPage.webinarRoomId;

		System.out.println(meetinglink);
		// webDriver.navigate().to(meetinglink);
		System.out.println(webDriver + "join with link");
		webDriver.get(meetinglink);

	}

	public void SkipEchotest() throws InterruptedException {

		Thread.sleep(2000);

		if (skip.isDisplayed()) {
			skip.click();
		}

		else {
			logger.info(permissionmsg.getText());
			webDriver.close();
		}
	}

	public void meetingname() {
		System.err.println("in meetingname fill");
		int max = 90;
		int min = 65;
		int range = max - min + 1;
		char rand = (char) ((char) ((Math.random() * range) + 1) + min);
		meetingname.sendKeys(rand + "");
		System.out.println();

		System.out.println("meeting name done");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		next.click();

	}
}
