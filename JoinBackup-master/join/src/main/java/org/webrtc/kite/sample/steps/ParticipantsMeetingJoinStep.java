
package org.webrtc.kite.sample.steps;

import org.webrtc.kite.sample.pages.ParticipantsJoinPage;
import org.webrtc.kite.sample.pages.ParticipantsMeetingPage;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;

public class ParticipantsMeetingJoinStep extends TestStep {

	public ParticipantsMeetingPage meetingPage = null;
	public ParticipantsJoinPage joinpage = null;

	public ParticipantsMeetingJoinStep(Runner runner) {
		super(runner);

		joinpage = new ParticipantsJoinPage(runner);
		meetingPage = new ParticipantsMeetingPage(runner);
	}

	@Override
	protected void step() throws KiteTestException {

		try {
			System.out.println("in participants step");

			joinpage.joinMeetingRoom();

			joinpage.SkipEchotest();

			joinpage.meetingname();

			meetingPage.InstantMSG();

			meetingPage.mute();
			
			 meetingPage.video_off();
			 
			// meetingPage.lockRoomTest();
			//meetingPage.hangup();
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Override
	public String stepDescription() { // TODO Auto-generated method
		return "add participants";
	}

}
