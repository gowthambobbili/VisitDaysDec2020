import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

def meetName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterLiveSessionDetailsAndTime'()

def zoomId=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterZoomIdAndAddAssigneWithLessThan20SeatingCapacity'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

//WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 2, FailureHandling.OPTIONAL)

while(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'),2,FailureHandling.OPTIONAL))
{

if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 2, FailureHandling.OPTIONAL))
{
	CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'),0)
//	WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'),FailureHandling.OPTIONAL)

}
WebUI.delay(3)
WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 2, FailureHandling.OPTIONAL)
}
	
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':meetName]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the created live session in admin is not present in the student app")
}
//WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':meetName]))

//if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LivebuttononSessions'), 0,FailureHandling.OPTIONAL)))
//{
//	KeywordUtil.markFailed("the live red colour label is not present in the live session of sessions page")
//}
WebUI.delay(5)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/JoinSessionButton',['createdSession':meetName]), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("join session button is not present in the live session of sessions page")
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SeatingCapacityWarningMessage',['SName':meetName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the seats left warning message is not shown in the My events page")
}