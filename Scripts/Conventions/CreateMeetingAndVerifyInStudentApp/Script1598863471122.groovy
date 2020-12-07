import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
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
import com.kms.katalon.core.util.KeywordUtil
CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def institutionName=CustomKeywords.'com.CommonUtilities.GetInstitutionName.getInstitutionNameFromAdminApp'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateMeeting.getConvention'()

def assigneeName=CustomKeywords.'com.CommonUtilities.CreateMeeting.enterMeetingDetailsAndTime'()

def zoomId=CustomKeywords.'com.CommonUtilities.CreateMeeting.enterZoomId'()

def dateDropDown=CustomKeywords.'com.CommonUtilities.CreateMeeting.selectDateDropDownFormat'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.delay(5)

//WebUI.click(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'))
}

WebUI.waitForElementPresent(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]), 0)

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]))

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/Schedule A Meeting Button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SelectDateInSchedulemeeting'), 0)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SelectDateInSchedulemeeting'))

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SelectFirstOPtionInDateDropDownMeetings',['Date':dateDropDown]))

WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SelectTimeInSchedulemeeting'), 0)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SelectTimeInScheduleMeeting'))

//WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/GetNameFromAScheduleMeetDropDown'))

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SelectFirstOptionInTimeDropTime',['value':assigneeName]), 0,FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SelectFirstOptionInTimeDropTime',['value':assigneeName]))

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ScheduleNow Button'))

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ItinenariesOption'),0,FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ItinenariesOption'))

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/MyMeetingsOptionInItinenariesPage'))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/VerifyMeetingnameInMyMeetingsPage',['Names':assigneeName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the scheduled meeting is not present in the My meetings page")
}


