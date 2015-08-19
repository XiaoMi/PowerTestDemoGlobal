package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class LauchExplorer
{
	private Automator am;

	LauchExplorer(Automator automator, long time)
	{
		this.am = automator;
		Utils.log("Explorer"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));

		long startTime = System.currentTimeMillis();
		long runningTime = time;
		
		while (System.currentTimeMillis() - startTime < runningTime)
		{
			try
			{
				Utils.excuteCMD("am start -n com.estrongs.android.pop/.view.FileExplorerActivity");
				Utils.sleepMs(5 * 1000);
				
				am.back(1);
				Utils.sleepMs(500);
				am.back(1);
				Utils.sleepMs(500);
				am.back(1);
				Utils.sleepMs(500);

				
			} catch (Exception e)
			{
				Utils.catchException(e, "Explorer");
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
