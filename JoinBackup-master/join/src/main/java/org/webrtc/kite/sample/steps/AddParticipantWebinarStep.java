package org.webrtc.kite.sample.steps;

import org.webrtc.kite.sample.pages.AddParticipantWebinar;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;

public class AddParticipantWebinarStep extends TestStep {
	
	AddParticipantWebinar add=null;

	public AddParticipantWebinarStep(Runner runner) {
		super(runner);
        add= new AddParticipantWebinar(runner);
	}

	@Override
	protected void step() throws KiteTestException {
		
		try {
			add.joinWebinarRoom();

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
