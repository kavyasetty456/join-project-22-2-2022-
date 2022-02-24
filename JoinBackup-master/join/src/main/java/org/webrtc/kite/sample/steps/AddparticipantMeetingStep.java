package org.webrtc.kite.sample.steps;

import org.webrtc.kite.sample.pages.AddParticipantMeeting;
import org.webrtc.kite.sample.pages.AddParticipantWebinar;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;

public class AddparticipantMeetingStep extends TestStep{
	
	
	AddParticipantMeeting add=null;

	public AddparticipantMeetingStep(Runner runner) {
		super(runner);
        add= new AddParticipantMeeting(runner);
	}

	
	protected void step() throws KiteTestException {
		
		try {
			add.joinMeetingRoom(); 

			add.SkipEchotest();

			add.meetingname();

			//meetingPage.handraise();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Override
	public String stepDescription() {
		
		return "this is the participant script";
	}


}
