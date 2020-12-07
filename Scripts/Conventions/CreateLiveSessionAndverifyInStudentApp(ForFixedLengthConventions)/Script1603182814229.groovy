import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conName=GlobalVariable.createdConventionName

def ConventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectFixedLengthConvention'(conName)

def meetname=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterLiveSessionDetailsAndTimeForFixedLengthConventions'()

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
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':meetname]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the created live session in admin is not present in the student app")
}

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/JoinSessionButton',['createdSession':meetname]), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("join session button is not present in the live session of sessions page")
}

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/JoinSessionButton',['createdSession':meetname]))

WebUI.delay(5)

WebUI.switchToWindowIndex(1)

WebUI.waitForPageLoad(10)

def ZoomIdfromurl=WebUI.getUrl()

if(!(WebUI.verifyMatch(ZoomId, ZoomIdfromurl, false, FailureHandling.STOP_ON_FAILURE)))
{
	KeywordUtil.markFailed("the given zoomid in admin app and navigating page zoomid doesnot match")
	
}
WebUI.switchToWindowIndex(0)

WebUI.navigateToUrl(GlobalVariable.StagingUrl)

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink'))

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/VerifyLiveSession',['SessionName':meetname]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("created live session is not present in live sessions page of admin")
}

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ViewAttendiesButtonInLiveSessionsPage',['SessionName':meetname]))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/VerifyAttendeesListOfLiveSession',['EMAIL':emailOfStudent]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the student who view live session is not present in attendees list of live sessions page")
}