package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class LauchBrowser
{
	private Automator am;

	LauchBrowser(Automator automator, long time)
	{
		this.am = automator;
		Utils.log("Browser"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));

		long startTime = System.currentTimeMillis();
		long runningTime = time;
		
		while (System.currentTimeMillis() - startTime < runningTime)
		{
			try
			{
				Utils.excuteCMD("am start -n com.UCMobile.intl/com.uc.browser.InnerUCMobile");
				Utils.sleepMs(5 * 1000);
				
				am.back(1);
				Utils.sleepMs(500);
				am.back(1);
				Utils.sleepMs(500);
				am.back(1);
				Utils.sleepMs(500);

				
			} catch (Exception e)
			{
				Utils.catchException(e, "Browser");
				am.back(1);
				Utils.sleepMs(500);
				am.back(1);
				Utils.sleepMs(500);
				am.back(1);
				Utils.sleepMs(500);
			}
		}

		am.home(2);
		
	}
}
