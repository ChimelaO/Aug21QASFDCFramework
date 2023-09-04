package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class SFDCListeners implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result) {
		BaseTest.test.info(MarkupHelper.createLabel(result.getName()+ " PASSED", ExtentColor.GREEN));
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		BaseTest.test.info(MarkupHelper.createLabel(result.getName()+ " FAILED", ExtentColor.RED));
		try {
			BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}