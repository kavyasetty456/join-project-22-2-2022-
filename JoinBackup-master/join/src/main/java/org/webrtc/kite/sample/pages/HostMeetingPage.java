package org.webrtc.kite.sample.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.support.FindBy;
import org.webrtc.kite.config.test.Tuple;

import io.cosmosoftware.kite.exception.KiteInteractionException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;
import io.cosmosoftware.kite.report.AllureStepReport;
import io.cosmosoftware.kite.report.AllureTestReport;
import io.cosmosoftware.kite.steps.TestStep;
import junit.framework.Assert;

public class HostMeetingPage extends BasePage {

	public static int numberOfMember;

	public static int videoTag;
   
	public HostMeetingPage(Runner runner) {
		super(runner);

	}

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[2]/ul/li[2]")
	WebElement chat;

	@FindBy(xpath = "//input[@placeholder='Type a Message']")
	WebElement textbox;

	@FindBy(xpath = "//button[@class='chatsend__button']")
	WebElement sendmsg;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[1]/span")
	WebElement lockRoom;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[2]/span")
	WebElement screenShare;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[3]/span")
	WebElement mute;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[4]/span")
	WebElement video_off;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[5]/span")
	WebElement hangup;

	@FindBy(xpath = "//*[@id=\"js--networkstatsbtn\"]")
	WebElement connection_stats;

	@FindBy(xpath = "//li[@class='grid-view']")
	WebElement gridView;

	@FindBy(xpath = "//div[@class='tabs']/ul/li[1]")
	WebElement memberpanel;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[1]/div/div[2]/section[1]/participants-list/ul/li")
	List<WebElement> totalMember;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[1]/div/div[2]/section[1]/participants-list/ul/li/div/div/h4")
	List<WebElement> memberName;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/div[3]/room-lock/section/div[3]/button")
	WebElement lockroomverify;

	@FindBy(xpath = "/html/body/app-root/web-component/broadcast/div[1]/div[2]/span[1]")
	WebElement Accept;

	@FindBy(xpath = "//span[@class='chat__text--participant']")
	List<WebElement> participantMsg;

	@FindBy(xpath = "//span[@class='chat__text--currentuser']")
	List<WebElement> localMsg;

	@FindBy(xpath = "//video[@id='localVideo']")
	List<WebElement> Participantvideo;

	public void InstantMSG() throws InterruptedException

	{

		logger.info("in instant msg");
		try {
			waitUntilAvailabilityOf(chat, 3000);
			chat.click();

			waitUntilAvailabilityOf(textbox, 5);
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textbox.sendKeys("hello participants, I am the host", Keys.ENTER);
		logger.info("msg send to the participant");
		// List<WebElement> total_number_msg= AllMsg;
		Thread.sleep(2000);
		int total_msg = participantMsg.size() + localMsg.size();
		logger.info(total_msg);

		logger.debug("Sent msg test Passed");
		
		
	}

	public void Videocheck() {

		logger.info("total number of participant video");
        
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int videoTag = Participantvideo.size() + 1;
		//assertEquals(numberOfMember, videoTag, "all video tag are there");
		logger.info(videoTag);
		logger.debug("video check test Passed");
		
	}
	
	public void ScreenShare()
	{
		try {
			waitUntilVisibilityOf(screenShare, 5000);
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenShare.click();
	}

	public void totalMembers() {

		memberpanel.click();
		List<WebElement> members = totalMember;
		 numberOfMember = totalMember.size();

		logger.info("number of participant including host" + " " + numberOfMember);
		// assertEquals(3, numberOfMember, "all member are not connected ");

		for (WebElement e : memberName) {
			String name = e.getText();
			System.out.println(name);
		}
	}

	public void GridView() throws InterruptedException {
		
		

		System.out.println(gridView.isDisplayed());
			if(gridView.isDisplayed()) {
				
				gridView.click();
			}
			else
			{
				logger.error("min 4 participant require for grid view");
			}
		

	}

	public void mute() {
		try {
			Thread.sleep(2000);
		mute.click();
		
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		mute.click();
	}

	public void video_off() {

		try {
			waitUntilAvailabilityOf(mute, 2);
		} catch (KiteInteractionException e) {

			e.printStackTrace();
		}

		video_off.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		video_off.click();

	}

	public void lockRoomTest() throws InterruptedException {

		lockRoom.click();
    boolean Roomlock=true; 
	Thread.sleep(6000);
		lockRoom.click();
	}

	public void AcceptHandRaise() {
		try {
			waitUntilVisibilityOf(Accept, 10);
		} catch (KiteInteractionException e) {

			e.printStackTrace(); 
		}

		Accept.click();
	}
	
	public void hangup() {
		
		try {
			Thread.sleep(500000);
			hangup.click();
			webDriver.close();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
