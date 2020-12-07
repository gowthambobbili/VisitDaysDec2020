import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.waitForPageLoad(0)

//WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LiveSessionsTab'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ShowInternationalLocationsCheckboxFilter'))

WebUI.delay(4)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ClearAllButton'),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed('clear all button is not shown affter applying filters')
}

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ShowInternationalLocationsCheckboxFilter'))
