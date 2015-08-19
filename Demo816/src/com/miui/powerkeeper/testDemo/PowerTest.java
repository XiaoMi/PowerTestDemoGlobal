package com.miui.powerkeeper.testDemo;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class PowerTest extends UiAutomatorTestCase
{

	public void test_PowerConsumption()
	{
		Utils.START_TIME = System.currentTimeMillis();
		Automator automator = new Automator(this.getUiDevice());
		Utils.log("819Demo");
		
		int loop = Integer.parseInt(this.getParams().getString("loop", "10"));
		
		Utils.sleepMs(30 * 1000);

		new Video(automator, 1 * 60 * 1000);
		new Map(automator, 1 * 60 * 1000);
		new News(automator, 1 * 60 * 1000);
		new Facebook(automator, 1 * 60 * 1000);
		new WhatsApp(automator, 1 * 60 * 1000);
		
		new LauchTwitter(automator, 30 * 1000);
		
		for (int iterator = 0; iterator < loop; iterator++)
		{

			Utils.sleepMs(30 * 1000);
			new Video(automator, 30 * 60 * 1000);//30
			new LauchBrowser(automator, 30 * 1000);
			
			new Map(automator, 30 * 60 * 1000);//30
			new LauchExplorer(automator, 30 * 1000);
			
			new News(automator, 20 * 60 * 1000);//20
			
			new Facebook(automator, 20 * 60 * 1000);//20
			new LauchWeather(automator, 30 * 1000);
			
			new WhatsApp(automator, 20 * 60 * 1000);//20				

			new Sleep(automator);
		}
	}

}
