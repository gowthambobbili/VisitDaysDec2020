import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import com.kms.katalon.core.util.KeywordUtil

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateMeeting.getConvention'()

def institutionName=CustomKeywords.'com.CommonUtilities.CreateMeeting.getInstitutionName'()

def assigneeName=CustomKeywords.'com.CommonUtilities.CreateMeeting.enterMeetingDetailsAndTime'()

def zoomId=CustomKeywords.'com.CommonUtilities.CreateMeeting.enterZoomId'()

def dateDropDown=CustomKeywords.'com.CommonUtilities.CreateMeeting.selectDateDropDownFormat'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonIconAccountBasics'))

String emailOfStudent=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/GetEmaildetailsFromAccountBasicsPage'))

println(emailOfStudent)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/EventsHomePage'))

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.delay(5)

//WebUI.click(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL))
{
	CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'),0)
//	WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'))
}
WebUI.waitForPageLoad(0)

//WebUI.scrollToElement(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]), 0, FailureHandling.OPTIONAL)

if(!(WebUI.verifyElementPresent(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]), 5, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed(institutionName+" is not found in exhibitors page")
}
CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]),0)

//WebUI.click(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]))

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

WebUI.delay(4)

WebUI.navigateToUrl(GlobalVariable.StagingUrl)

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink',['ConventionProvider':GlobalVariable.ConventionProvider]))

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ProspectsLeftnav'))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/VerifyAttendeesListOfLiveSession',['EMAIL':emailOfStudent]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the student who scheduled meeting is not present in attendees list of prospects page")
}


