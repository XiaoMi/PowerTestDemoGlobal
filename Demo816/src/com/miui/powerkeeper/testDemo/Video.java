package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class Video
{
	private Automator am;

	Video (Automator automator, long time)
	{
		this.am = automator;
		Utils.log("Video"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));
		long startTime = System.currentTimeMillis();
		long runningTime = time;

		while (System.currentTimeMillis() - startTime < runningTime)
		{
			try
			{
				run();
			} catch (UiObjectNotFoundException e)
			{
				Utils.catchException(e, "Video");
				am.back(5);
			}
		}
		am.home(2);
	}

	private void run() throws UiObjectNotFoundException
	{
		UiObject folder = new UiObject(new UiSelector().text("Download"));
		UiObject video = new UiObject(new UiSelector().text("XiaomiPhone"));
		UiObject popNote = new UiObject(
				new UiSelector().text("Do you wish to resume from where you stopped?"));

		Utils.excuteCMD("am start -n com.mxtech.videoplayer.ad/.ActivityMediaList");
		Utils.sleepMs(3000);
		folder.click();
		video.click();
		if(popNote.exists()) {
			new UiObject(new UiSelector().text("Start over")).click();
		}
		Utils.sleepMs(30000);
		am.back(3);
		Utils.sleepMs(1000);
		am.back();
	}
}
