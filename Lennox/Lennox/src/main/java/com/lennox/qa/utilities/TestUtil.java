package com.lennox.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.lennox.qa.base.BaseClass;

public class TestUtil extends BaseClass {

	public static long IMPLICIT_WAIT = 90;
	public static long PAGE_LOAD_TIMEOUT = 90;
	public static long SET_SCRIPT_TIMEOUT = 60;

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
