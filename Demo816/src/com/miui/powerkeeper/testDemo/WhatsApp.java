package com.miui.powerkeeper.testDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.miui.powerkeeper.testDemo.tools.Automator;
import com.miui.powerkeeper.testDemo.tools.Utils;

public class WhatsApp
{
	private Automator am;

	WhatsApp(Automator automator, long time)
	{
		this.am = automator;
		Utils.log("WhatsApp"
				+ new SimpleDateFormat("MMddHHmm").format(new Date()));

		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < time)
		{
			try
			{
				Utils.sleepMs(5 * 1000);
				System.out.println("starting chat");
				chat(time - (System.currentTimeMillis() - startTime));
			} catch (Exception e)
			{
				Utils.catchException(e, "WhatsApp");
				am.back(3);
				Utils.sleepMs(1 * 1000);
				am.home(2);
				System.out.println("running catch");
			}
		}
		am.back(3);
		am.home(2);
	}

	private void chat(long waittime) throws UiObjectNotFoundException
	{
		Utils.excuteCMD("am start -n com.whatsapp/.Main");
		Utils.sleepMs(2 * 1000);
		
		System.out.println("chat(): start");
		
		UiObject chatName = new UiObject(new UiSelector().text("India 819"));
		chatName.clickAndWaitForNewWindow();

		UiObject inputText = new UiObject(
				new UiSelector().className("android.widget.EditText"));

		long sTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - sTime < waittime)
		{
			if (chatName.exists() && chatName.isSelected())
			{
				chatName.click();
				System.out.println("chat(): chatName is pressed");
			}
			
			System.out.println("chat(): press edit text");

			inputText.click();
			Utils.sleepMs(1 * 1000);
			inputText.clearTextField();
			Utils.sleepMs(1 * 1000);
			inputText.setText("819");
			Utils.sleepMs(1 * 1000);


			new UiObject(new UiSelector().resourceId("com.whatsapp:id/send")).click();
			Utils.sleepMs(10 * 1000);
			System.out.println("chat(): message is send");

			am.back(2);
			Utils.sleepMs(10 * 1000);
		}
	}
}
