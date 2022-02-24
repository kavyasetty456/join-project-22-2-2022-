package Core3;

import org.webrtc.kite.tests.KiteBaseTest;
import org.webrtc.kite.tests.TestRunner;

public class AddingInCore3Test extends KiteBaseTest
{

	@Override
	protected void populateTestSteps(TestRunner runner) 
	{
		
		runner.addStep(new AddinginCore3(runner));
	}

}
