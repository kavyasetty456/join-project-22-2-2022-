package org.webrtc.kite.sample.steps;

import org.junit.Test;
import org.webrtc.kite.sample.pages.GetOTPFunctionality;
import org.webrtc.kite.sample.pages.HostJoinPage;
import org.webrtc.kite.sample.pages.HostMeetingPage;
import org.webrtc.kite.tests.KiteBaseTest;

import io.cosmosoftware.kite.interfaces.Runner;
import io.cosmosoftware.kite.steps.TestStep;

public class HostMeetingJoinStep extends TestStep {

	static HostJoinPage hostPage = null;

	static HostMeetingPage hostmeetingPage = null;
	
	
	public HostMeetingJoinStep(Runner runner) {
		super(runner);
		hostPage = new HostJoinPage(runner);
		hostmeetingPage = new HostMeetingPage(runner);
		

	}

	@Override
	protected void step() {

		try {
			hostPage.createRoom();

			hostPage.ShareMeetingLink();

			hostPage.StartMeeting();

			hostPage.SkipEchotest();

			hostPage.meetingname();

			hostmeetingPage.mute();

			hostmeetingPage.InstantMSG();

			hostmeetingPage.video_off();
			
			hostmeetingPage.totalMembers();
			
			hostmeetingPage.Videocheck();
			
			//hostmeetingPage.GridView();
			
			//hostmeetingPage.ScreenShare();
			
			//hostmeetingPage.lockRoomTest();
			
			//hostmeetingPage.hangup();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String stepDescription() {
		return "open join and setup room";
	}

}
