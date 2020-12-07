import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

def meetname=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterLiveSessionDetailsAndTime'()

def tagName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterZoomIdAndAddAssigneeIncludingTags'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.waitForElementClickable(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'), 0)

//WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.waitForPageLoad(0)

WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/HomePageElements/tagsInFilter'),tagName)

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SelectTagFromList'))

WebUI.delay(5)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionInStudentApp',['createdSession':meetname]),10,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the created live session in admin is not present in the student app")
}
