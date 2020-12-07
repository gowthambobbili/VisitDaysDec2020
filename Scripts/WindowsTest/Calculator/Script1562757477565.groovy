import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import java.util.concurrent.TimeUnit
import org.junit.Assert
import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.windows.WindowsDriver
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults")
CalculatorSession.findElementByName("One").click();
CalculatorSession.findElementByName("Plus").click();
CalculatorSession.findElementByName("Seven").click();
CalculatorSession.findElementByName("Equals").click();
//Assert.assertEquals("8", _GetCalculatorResultText());

