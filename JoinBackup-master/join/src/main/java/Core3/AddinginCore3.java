package Core3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;

public class AddinginCore3 extends TestStep
{

	public static int i = 1;
	@FindBy(xpath = "//button[4]")
	WebElement mute;
	
	public AddinginCore3(Runner runner) 
	{
		super(runner);
		webDriver.manage().window().maximize();
	}

	public static String meetinglink ="https://join-staging-portal.telebu.com/TJ-bwso5twkzwiwxp4";
	@Override
	
	protected void step() throws KiteTestException
	{	
		webDriver.get(meetinglink);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = webDriver.switchTo().alert();
		alert.accept();	
		System.out.println("Joined the call sucessfully");	
	}
	
	
	@Override
	public String stepDescription() {
		
		return "Joining the sample application URL";
	}

}