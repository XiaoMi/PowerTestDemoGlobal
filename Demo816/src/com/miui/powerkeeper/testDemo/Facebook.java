package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class Facebook
{
	private Automator am;

	Facebook(Automator automator, long time)
	{
		this.am = automator;
		Utils.log("Facebook"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));

		long startTime = System.currentTimeMillis();
		long runningTime = time;
		
		while (System.currentTimeMillis() - startTime < runningTime)
		{
			try
			{
				Utils.excuteCMD("am start -n com.facebook.katana/.LoginActivity");
				Utils.sleepMs(5 * 1000);
				
				swipeDown(3);
				Utils.sleepMs(1 * 1000);
				swipeUp(3);
				Utils.sleepMs(1 * 1000);

				new UiObject(new UiSelector().resourceId("com.facebook.katana:id/friend_requests_tab"))
				.clickAndWaitForNewWindow();
				Utils.sleepMs(2 * 1000);
				swipeDown(3);
				Utils.sleepMs(1 * 1000);
				swipeUp(3);
				Utils.sleepMs(1 * 1000);

				new UiObject(new UiSelector().resourceId("com.facebook.katana:id/bookmarks_tab"))
				.clickAndWaitForNewWindow();
				Utils.sleepMs(2 * 1000);
				swipeDown(3);
				Utils.sleepMs(1 * 1000);
				swipeUp(3);
				Utils.sleepMs(1 * 1000);
				
				am.back(2);
				
				am.home(2);

			} catch (Exception e)
			{
				Utils.catchException(e, "Facebook");
				am.back(2);
				am.home(2);
			}
		}
		am.back(2);

		
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
