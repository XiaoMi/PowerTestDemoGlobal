package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class LauchWeather
{
	private Automator am;

	LauchWeather(Automator automator, long time)
	{
		this.am = automator;
		Utils.log("Weather"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));

		long startTime = System.currentTimeMillis();
		long runningTime = time;
		
		while (System.currentTimeMillis() - startTime < runningTime)
		{
			try
			{
				Utils.excuteCMD("am start -n com.yahoo.mobile.client.android.weather/.ui.WeatherMainActivity");
				Utils.sleepMs(5 * 1000);

				am.back(1);
				Utils.sleepMs(1 * 1000);

				
			} catch (Exception e)
			{
				Utils.catchException(e, "Weather");
				am.back(1);
				Utils.sleepMs(1 * 1000);
			}
		}

		am.home(2);
		
	}

}
