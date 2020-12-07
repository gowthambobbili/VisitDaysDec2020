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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebDriver driver = DriverFactory.getWebDriver()

WebUI.callTestCase(findTestCase('Surveys -Student App Tests/NavigateToSurveyPage'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.SurveyMethods.CompleteSurveyAndReturnTheListOfTextAreaQuestions'()

CurrentUrl = WebUI.getUrl(FailureHandling.STOP_ON_FAILURE)

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')

WebUI.switchToWindowIndex(1)

WebUI.navigateToUrl(CurrentUrl)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/FacebookIconInConfirmationPage'),
		'When navigated to already submitted survey link, the confitrmation page is not shown')

if (!(WebUI.verifyElementPresent(findTestObject('Survey-Student App Objects/FacebookIconInConfirmationPage'), 0))) {
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('When navigated to already submitted survey link, the confitrmation page is not shown')
} else {
	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
}


