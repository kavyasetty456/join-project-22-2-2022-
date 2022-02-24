package org.webrtc.kite.sample.test;


import org.webrtc.kite.sample.steps.AddParticipantWebinarStep;

import org.webrtc.kite.tests.KiteBaseTest;
import org.webrtc.kite.tests.TestRunner;

public class AddParticipantInWebinar extends KiteBaseTest {
	
	public static Boolean isHostExist = true;

	@Override
	protected void payloadHandling() {
	}

	@Override
	public void populateTestSteps(TestRunner runner) {



		runner.addStep(new AddParticipantWebinarStep(runner));
		
		}
		
		
		
		 	
		

}
