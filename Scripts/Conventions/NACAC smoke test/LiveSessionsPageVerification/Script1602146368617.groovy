import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.waitForPageLoad(0)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/EventsHomePage'))

WebUI.waitForPageLoad(0)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/FirstConventionName'), 0, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/FirstConventionName'))
	WebUI.click(findTestObject('Object Repository/NacacStudentApp/Colleges/LiveSessionsTab'))
	CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SmokeTests.verifyLiveSessionsPage'()
	
}
else
{
	KeywordUtil.markPassed("There are no conventions present")
}
