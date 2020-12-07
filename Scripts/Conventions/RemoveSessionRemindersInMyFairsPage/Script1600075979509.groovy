import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.util.KeywordUtil
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def ConventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

def meetName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterLiveSessionDetailsAndTime'()

def ZoomId=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterZoomIdAndAddAssigne'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonIconAccountBasics'))

String emailOfStudent=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/GetEmaildetailsFromAccountBasicsPage'))

println(emailOfStudent)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/EventsHomePage'))

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':ConventionName]))

WebUI.waitForPageLoad(0)

//WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'))
	
	WebUI.delay(5)
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':meetName]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the created live session in admin is not present in the student app")
}

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/JoinSessionButton',['createdSession':meetName]), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("join session button is not present in the live session of sessions page")
}

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/JoinSessionButton',['createdSession':meetName]))

WebUI.delay(5)

WebUI.delay(5)

WebUI.switchToWindowIndex(1)

def ZoomIdfromurl=WebUI.getUrl()

if(!(WebUI.verifyMatch(ZoomId, ZoomIdfromurl, false, FailureHandling.STOP_ON_FAILURE)))
{
	KeywordUtil.markFailed("the given zoomid in admin app and navigating page zoomid doesnot match")
	
}
WebUI.switchToWindowIndex(0)

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ItinenariesOption'), 0, FailureHandling.OPTIONAL)


WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ItinenariesOption'))

WebUI.delay(4)

WebUI.refresh()

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/VersifySessionInMyEventsPage',['SName':meetName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the registered session is not present in the My events page")
}
WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/RemoveButtonInMyFairs',['SessionName':meetName]))

WebUI.delay(5)

WebUI.refresh()

if((WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/VersifySessionInMyEventsPage',['SName':meetName]),5,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the removed session is still present in the My fairs page")
}