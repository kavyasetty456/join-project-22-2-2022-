package org.webrtc.kite.sample.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cosmosoftware.kite.exception.KiteInteractionException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.pages.BasePage;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


public class AddParticipantWebinar extends BasePage {


	public static final String TELEBU_PAGE = "https://join.telebu.com/";
	
	public AddParticipantWebinar(Runner runner) {
		super(runner);
		
		webDriver.manage().window().maximize();
		
	}

	public static String Webinarlink ="https://staging-join.telebu.com/broadcast/C3iCkkkr3";
	public static boolean handRaise = false;

	public static int i = 1;

	@FindBy(xpath = "//button[@class='transprent__button']")
	WebElement skip;
	
	@FindBy(xpath = "/html/body/app-root/web-component/call/main/div[3]/echo-test/section/div[4]/button[1]")
	WebElement done;

	@FindBy(xpath = "//input[@name='userName']")
	WebElement meetingname;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement next;

	@FindBy(xpath = "//div[@class='paper width-md nickname-popup']/div/div/label")
	WebElement permissionmsg;
	
	
	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[2]/ul/li[2]")
	WebElement chat;

	@FindBy(xpath = "//input[@placeholder='Type a Message']")
	WebElement textbox;

	@FindBy(xpath = "//button[@class='chatsend__button']")
	WebElement sendmsg;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[1]/span")
	WebElement screenShare;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[2]/span")
	WebElement mute;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[3]/span")
	WebElement video_off;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[4]/span")
	WebElement hangup;

	@FindBy(xpath = "//*[@id=\"js--networkstatsbtn\"]")
	WebElement connection_stats;

	@FindBy(xpath = "/html/body/app-root/web-component/broadcast/main/section[1]/div[3]/div[2]/div[1]/ul/li[1]")
	WebElement handraise;

	@FindBy(xpath = "/html/body/app-root/web-component/call/main/section[1]/div[3]/div[2]/div[1]/ul/li[1]/span")
	WebElement lockRoom;
	@FindBy(xpath = "/html/body/app-root/web-component/call/main/div[3]/room-lock/section/div[3]/button")
	WebElement lockroomverify;
	
	
	public void joinWebinarRoom() {

		
		// webDriver.navigate().to(meetinglink);
		System.out.println(webDriver + "join with link");
		webDriver.get(Webinarlink);

	}

	public void SkipEchotest() throws InterruptedException
	{

		//Thread.sleep(5000);
		//System.out.println(skip.isDisplayed());
		try {
			waitUntilVisibilityOf(skip, 10);
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		skip.click();
		
	}

	public void meetingname() {
		System.err.println("in meetingname fill");
		/*
		 * int max = 90; int min = 65; int range = max - min + 1; char rand = (char)
		 * ((char) ((Math.random() * range) + 1) + min);
		 */
		meetingname.sendKeys("BOT" + i++);
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
	
	public void InstantMSG() throws InterruptedException

	{
		System.out.println("in instant msg");

		Thread.sleep(4000);

		chat.click();
		try {
			waitUntilAvailabilityOf(textbox, 5);
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textbox.sendKeys("hello host", Keys.ENTER);
		System.out.println("msg sent");
		// sendmsg.click();
    
	}

	public void mute() {

		mute.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mute.click();
	}

	public void video_off() {

		video_off.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		video_off.click();

	}

	public void handraise() {
		if (handRaise == false) {
			handRaise = true;

			handraise.click();

			System.out.println("handRaised");
		} else {
			System.out.println("handRaise is going on");
		}
	}

	
public void hangup() {
		
		try {
			Thread.sleep(15000);
			waitUntilVisibilityOf(hangup, 10000);
			hangup.click();
			webDriver.close();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KiteInteractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void lockRoomTest() {

	

	((JavascriptExecutor) webDriver).executeScript("window.open()");
	ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
	webDriver.switchTo().window(tabs.get(1));

	webDriver.get("https://staging-join.telebu.com/meeting/RGCpXK7o");
	String veri = lockroomverify.getText();
	assertEquals("Home", veri);
	webDriver.close();
	webDriver.switchTo().window(tabs.get(0));
	
	}
	
	
	public void get_browser_console_log()
	{
		LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            
        }
	}
	
	
	
}
