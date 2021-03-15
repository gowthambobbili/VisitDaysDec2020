import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'),0,FailureHandling.OPTIONAL))
{
   WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

   WebUI.waitForPageLoad(0)
}
WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionSettingsLeftNav'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPageLeftNav'))

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Individual Convention Pages tab'))

WebUI.delay(2)

if(WebUI.verifyElementChecked(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show custom messaging in tabs of convention pages'), 0, FailureHandling.OPTIONAL))
{
	WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show custom messaging in tabs of convention pages'))
}
WebUI.check(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show custom messaging in tabs of convention pages'))

String collegesText="EXHIBITORS"

String liveSessionsText="SESSIONS"

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Custom exhibitor tab text field'),collegesText)

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Custom live sessions tab text field'),liveSessionsText)

//if(WebUI.verifyElementChecked(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show filters for colleges tab switch'), 0, FailureHandling.OPTIONAL))
//{
//WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show filters for colleges tab switch'))
//}
//if(WebUI.verifyElementChecked(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show Filters for Live sessions tab switch'), 0, FailureHandling.OPTIONAL))
//{
//WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show Filters for Live sessions tab switch'))
//}
WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Save Button'))

//WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Preview Button'))
//
//WebUI.switchToWindowIndex(1)
//
//WebUI.waitForPageLoad(0)
//
//WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/ClickOnFirstConvention'))
//
//WebUI.waitForPageLoad(0)
//
//String collegesTabValue=WebUI.getText(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/GetTextFromCollegesTab'))
//
//if(collegesText!=collegesTabValue)
//{
//	KeywordUtil.markFailed(collegesText+" value given in selfconfig page not matches with "+collegesTabValue+" of convention app")
//}
//
//if(!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/VerifyFiltersModalInCollegesPage'), 0, FailureHandling.OPTIONAL)))
//{
//	KeywordUtil.markFailed("filters model is still shopwn in coollges tab of conventions app even in filters disabled state")
//}
//CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/GetTextFromLiveSessionsTab'), 0)
//
//WebUI.waitForPageLoad(0)
//
//String liveSessionsTabValue=WebUI.getText(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/GetTextFromLiveSessionsTab'))
//
//if(liveSessionsText!=liveSessionsTabValue)
//{
//	KeywordUtil.markFailed(liveSessionsText+" value given in selfconfig page not matches with "+liveSessionsTabValue+" of convention app")
//}
//if(!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/VerifyFilterModalInLiveSessionsTab'), 0, FailureHandling.OPTIONAL)))
//{
//	KeywordUtil.markFailed("filters model except tags is still shown in live sessions tab of conventions app even in filters disabled state")
//}
//
//WebUI.closeWindowIndex(1, FailureHandling.OPTIONAL)
//
//WebUI.switchToWindowIndex(0)
//
WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show custom messaging in tabs of convention pages'))

//WebUI.check(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show filters for colleges tab switch'))
//
//WebUI.check(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show Filters for Live sessions tab switch'))

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Save Button'))

