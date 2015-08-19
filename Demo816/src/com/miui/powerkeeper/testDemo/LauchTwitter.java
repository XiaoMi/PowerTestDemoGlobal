package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class LauchTwitter
{
	private Automator am;

	LauchTwitter(Automator automator, long time)
	{
		this.am = automator;
		Utils.log("Twitter"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));

		long startTime = System.currentTimeMillis();
		long runningTime = time;
		
		while (System.currentTimeMillis() - startTime < runningTime)
		{
			try
			{
				Utils.excuteCMD("am start com.twitter.android/.LoginActivity");
				Utils.sleepMs(3 * 1000);
				
				swipeDown(3);
				Utils.sleepMs(1 * 1000);
				swipeUp(3);
				Utils.sleepMs(1 * 1000);
				
				am.back(1);
				Utils.sleepMs(1 * 1000);

				
			} catch (Exception e)
			{
				Utils.catchException(e, "Twitter");
				am.back(1);
				Utils.sleepMs(1 * 1000);
			}
		}

		am.home(2);
		
	}
	
	private void swipeDown(int times)
	{
		for (int i = 0; i < times; i++)
		{
			am.swipe(am.mDeviceDisplayWidth / 2, am.mDeviceDisplayHeight / 2,
					am.mDeviceDisplayWidth / 2, am.mDeviceDisplayHeight / 4);
			Utils.sleepMs(2 * 1000);
		}
	}
	
	private void swipeUp(int times)
	{
		for (int i = 0; i < times; i++)
		{
			am.swipe(am.mDeviceDisplayWidth / 2, am.mDeviceDisplayHeight / 2,
					am.mDeviceDisplayWidth / 2, am.mDeviceDisplayHeight * 3 / 4);
			Utils.sleepMs(2 * 1000);
		}
	}
}
