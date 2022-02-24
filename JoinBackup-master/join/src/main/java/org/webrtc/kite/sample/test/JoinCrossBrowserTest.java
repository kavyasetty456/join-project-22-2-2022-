  package org.webrtc.kite.sample.test;

import org.webrtc.kite.sample.pages.HostJoinPage;
import org.webrtc.kite.sample.steps.HostMeetingJoinStep;
import org.webrtc.kite.sample.steps.ParticipantsMeetingJoinStep;
import org.webrtc.kite.tests.KiteBaseTest;
import org.webrtc.kite.tests.TestRunner;

public class JoinCrossBrowserTest extends KiteBaseTest {
	
	
	public static Boolean isHostExist = true;

	@Override
	protected void payloadHandling() {
	}

	@Override
	public void populateTestSteps(TestRunner runner) {


		
		if(isHostExist){
			HostJoinPage host = new HostJoinPage(runner);
			
			
		runner.addStep(new HostMeetingJoinStep(runner));
		
		isHostExist=false;

		}
		else{
			System.out.println("in participants");
		runner.addStep(new ParticipantsMeetingJoinStep(runner));
		
		}
		
		
		
		 	
		}

}
