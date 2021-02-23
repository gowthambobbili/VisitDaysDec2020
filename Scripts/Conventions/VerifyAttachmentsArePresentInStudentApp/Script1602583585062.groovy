import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

def meetname=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterLiveSessionDetailsAndTime'()

CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterZoomIdAndAddAssigneeIncludingTags'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.waitForElementClickable(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'), 0)

//WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.waitForPageLoad(0)

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

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':meetname]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the created live session in admin is not present in the student app")
}
CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':meetname]),0)
//WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':meetname]))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/AdditionalResourcesViewButton'),5,FailureHandling.OPTIONAL)))
{
		KeywordUtil.markFailed("the attachment button in admin is not present in the student app")
}
	
WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/AdditionalResourcesViewButton'))

WebUI.delay(5)

WebUI.switchToWindowIndex(0)


