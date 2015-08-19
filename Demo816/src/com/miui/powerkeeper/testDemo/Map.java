package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

//import android.os.RemoteException;

//import android.graphics.Rect;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class Map extends UiAutomatorTestCase
{
	private Automator am;

	Map(Automator automator, long time)
	{
		this.am = automator;
		Utils.log("Map"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));

		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < time)
		{
			try
			{
				navigation(time - (System.currentTimeMillis() - startTime));
			} catch (Exception e)
			{
				Utils.catchException(e, "Map");
				am.back(4);
				Utils.sleepMs(1 * 1000);
				am.back(4);
				Utils.sleepMs(1 * 1000);
				am.home(2);
			}
		}

		am.back(4);
		am.home(2);
	}

	private void navigation(long waittime) throws UiObjectNotFoundException
	{
		Utils.excuteCMD("am start -n com.google.android.apps.maps/com.google.android.maps.MapsActivity");
		Utils.sleepMs(6 * 1000);

		UiObject searchbar = new UiObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/search_omnibox_text_box"));
		if (searchbar == null || !searchbar.exists())
		{
			searchbar = new UiObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/textbox"));
			if (searchbar == null || !searchbar.exists())
			{
				searchbar = new UiObject(new UiSelector().resourceId("com.google.android.apps.maps:id/textbox"));
			}
		}
		
		searchbar.clickAndWaitForNewWindow();

		Utils.sleepMs(2 * 1000);
		UiObject res = new UiObject(new UiSelector().text("The Lalit New Delhi"));
		if (res == null || !res.exists())
		{
			res = new UiObject(new UiSelector().text("lalit hotel"));
		}
		
		res.clickAndWaitForNewWindow();
		Utils.sleepMs(2 * 1000);
		
		
		UiObject destination = new UiObject(new UiSelector().resourceId("com.google.android.apps.maps:id/distancebutton_content"));
		if(destination == null || !destination.exists())
		{
			destination = new UiObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/distancebutton_travelmode_icon"));
			if(destination == null || !destination.exists())
			{
				destination = new UiObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/placepage_directions_button"));
			}
		}
		
		destination.clickAndWaitForNewWindow();
		Utils.sleepMs(5 * 1000);
		
		UiObject navigationButton = new UiObject(new UiSelector().text("Start navigation"));
		navigationButton.clickAndWaitForNewWindow();

		UiObject textbar = new UiObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/navigation_stepcuefirstline_textbox"));
		if (textbar == null || !textbar.exists())
		{
			textbar = new UiObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/primaryroad_textbox"));
		}
		textbar.click();
		Utils.sleepMs(2 * 1000);
		
		UiObject rightarrow = new UiObject(new UiSelector().resourceId("com.google.android.apps.maps:id/arrowviewpager_rightarrow"));
		if(rightarrow == null || !rightarrow.exists())
		{
			rightarrow = new UiObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/arrowviewpager_rightarrow"));
			if(rightarrow == null || !rightarrow.exists())
			{
				rightarrow = new UiObject(new UiSelector().description("Show next"));
			}
		}

		for (int i=0;i<8;i++)
		{
			rightarrow.click();
			Utils.sleepMs(2 * 1000);
		}		
	}
}