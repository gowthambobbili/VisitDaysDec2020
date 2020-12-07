import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

def sessionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterLiveSessionDetailsAndFutureTime'()

def zoomId=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterZoomIdAndAddAssigne'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonIconAccountBasics'))

String emailOfStudent=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/GetEmaildetailsFromAccountBasicsPage'))

println(emailOfStudent)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/EventsHomePage'))

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.waitForPageLoad(0)

//WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.delay(5)

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'))
}
WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':sessionName]), 0)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':sessionName]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the created live session in admin is not present in the student app")
}

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/RemindMeButton',['createdSession':sessionName]), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Remind me button is not present in the live session of sessions page")
}
WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/RemindMeButton',['createdSession':sessionName]))

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ItinenariesOption'), 0, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ItinenariesOption'))

WebUI.delay(4)

WebUI.refresh()

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/VersifySessionInMyEventsPage',['SName':sessionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the registered session is not present in the My events page")
}