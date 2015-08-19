package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class Sleep
{
	private Automator am;

	Sleep(Automator automator)
	{
		this.am = automator;
		Utils.log("Sleep"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));
		

		String packagename = "";
		if (am.brandName().equals("samsung"))
		{
			packagename = "com.sec.android.app.clockpackage";
		}
		else if (am.brandName().equals("Xiaomi"))
		{
			packagename = "com.android.deskclock";
		}
		else if (am.brandName().equals("lge"))
		{
			packagename = "com.lge.clock";
		}else
		{
			packagename = "com.google.android.deskclock";
		}

		while (true)
		{
			Utils.sleepMs(5000);
			if (am.getCurrentPackageName().equals(packagename))
			{
				System.out.println("packagename get");
				break;
			}
		}

		wakeupPhone();
		am.home(1);
	}
	
	public void wakeupPhone()
	{

		if (am.brandName().equals("Xiaomi"))
		{
			Utils.sleepMs(1 * 1000);
			swipeLockscreenUp();
		} else if (am.brandName().equals("samsung"))
		{
			Utils.sleepMs(1 * 1000);
			am.swipe(540, 1600, 1080, 1600);
			Utils.sleepMs(1 * 1000);
			swipeLockscreenUp();
			am.home(2);
		} else if (am.brandName().equals("google"))
		{
			am.volumedown();
			Utils.sleepMs(5 * 1000);
			am.back(2);		
		} else if (am.brandName().equals("lge"))
		{
			UiObject app = new UiObject(new UiSelector().text("Dismiss"));
			if (app != null && app.exists())
			{
				try {
					app.click();
				} catch (Exception e){
					Utils.catchException(e, "Sleep");
				}
			}
		} else
		{
			Utils.sleepMs(1 * 1000);
			swipeLockscreenUp();			
		}
	}

	public void swipeLockscreenUp()
	{
		am.wakeUp();
		am.swipe(am.mDeviceDisplayWidth * 5 / 10, am.mDeviceDisplayHeight * 8 / 10,
				am.mDeviceDisplayWidth * 5 / 10, am.mDeviceDisplayHeight * 3 / 10);
		Utils.sleepMs(1 * 1000);
		am.home(2);
	}

	public void swipeLockscreenRight()
	{
		am.wakeUp();
		am.swipe(am.mDeviceDisplayWidth * 4 / 10, am.mDeviceDisplayHeight * 4 / 10,
				am.mDeviceDisplayWidth * 9 / 10, am.mDeviceDisplayHeight * 4 / 10);
		Utils.sleepMs(1 * 1000);
		am.home(2);
	}
}
