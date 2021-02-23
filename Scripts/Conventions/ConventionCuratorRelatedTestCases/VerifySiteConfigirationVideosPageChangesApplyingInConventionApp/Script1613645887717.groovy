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

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Videos Tab'))

if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show filters for videos tab'), 0, FailureHandling.OPTIONAL)))
{
	WebUI.check(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show filters for videos tab'))
}

WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show filters for videos tab'))

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Save Button'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Preview Button'))

WebUI.switchToWindowIndex(1)

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/ClickOnFiltersIconInVideosPage'))

WebUI.waitForPageLoad(0)

if(!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/VerifyVideosFilter'),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Videos filters model except tags is shown even after deactivating tags in self config page")	
}

WebUI.closeWindowIndex(1, FailureHandling.OPTIONAL)

WebUI.switchToWindowIndex(0)

WebUI.check(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show filters for videos tab'))

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Save Button'))

WebUI.delay(2)
