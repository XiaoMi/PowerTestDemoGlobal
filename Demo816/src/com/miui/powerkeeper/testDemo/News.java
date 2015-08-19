package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class News
{
	private Automator am;

	News(Automator automator, long time)
	{
		this.am = automator;
		Utils.log("News"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));

		long startTime = System.currentTimeMillis();
		long runningTime = time;
		
		while (System.currentTimeMillis() - startTime < runningTime)
		{
			try
			{
				Utils.excuteCMD("am start -n bbc.mobile.news.ww/bbc.mobile.news.v3.app.TopLevelActivity");
				Utils.sleepMs(2 * 1000);

				UiObject app = new UiObject(new UiSelector().text("Top Stories"));
				if (app != null && app.exists())
				{
					app.clickAndWaitForNewWindow();
					Utils.sleepMs(2 * 1000);
					swipeDown(3);
					Utils.sleepMs(1 * 1000);
					swipeUp(3);
					Utils.sleepMs(1 * 1000);
				}

				UiObject music = new UiObject(new UiSelector().text("My News"));
				if (music != null && music.exists())
				{
					music.clickAndWaitForNewWindow();
					Utils.sleepMs(2 * 1000);
					swipeDown(3);
					Utils.sleepMs(1 * 1000);
					swipeUp(3);
					Utils.sleepMs(1 * 1000);
				}

				Utils.sleepMs(1 * 1000);
				am.back(1);
				Utils.sleepMs(1 * 1000);

				
			} catch (Exception e)
			{
				Utils.catchException(e, "News");
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
