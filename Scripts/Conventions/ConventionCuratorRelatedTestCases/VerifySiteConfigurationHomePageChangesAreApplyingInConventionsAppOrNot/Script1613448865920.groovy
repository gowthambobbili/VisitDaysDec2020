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

if(WebUI.verifyElementChecked(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show Custom Label switch'), 0, FailureHandling.OPTIONAL))
{
	WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show Custom Label switch'))
}
if(WebUI.verifyElementChecked(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show custom headline on home page'), 0, FailureHandling.OPTIONAL))
{
	WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show custom headline on home page'))
}
if(WebUI.verifyElementChecked(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Empty state for convention switch'), 0, FailureHandling.OPTIONAL))
{
	WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Empty state for convention switch'))
}

WebUI.check(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show Custom Label switch'))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Custom Nav label text field'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("After clicking on show custom label switch, the text box for entering label is not shown")
}


WebUI.check(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show custom headline on home page'))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Custom headline textfield'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("After clicking on show custom headline switch, the text box for entering label is not shown")
}
WebUI.check(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Empty state for convention switch'))

WebUI.delay(2)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Custom Header text field for empty state'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("After clicking on empty state switch, the text box for entering custom header text label is not shown")
}

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Custom Message text field for empty state'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("After clicking on empty state switch, the text box for entering custom message text label is not shown")
}
WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Empty state for convention switch'))

String customNavLabelText="TESTERNAVLABEL"

String customHeadLineText="Test HeadLine"

String customHeadLineTextConcatination="Upcoming "+customHeadLineText

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Custom Nav label text field'),customNavLabelText)

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Custom headline textfield'), customHeadLineText)

WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Save Button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Preview Button'), 0)

//marking the code as comment because the applied changes will take 15 min to reflect in conventions app due to cahe time

//WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Preview Button'))
//
//WebUI.switchToWindowIndex(1)
//
//WebUI.waitForPageLoad(0)
//
//String customNavLabel=WebUI.getText(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/GetTextFromEventsTopNav'))
//
//println customNavLabel
//
//if(!(customNavLabelText==customNavLabel))
//{
//	KeywordUtil.markFailed(customNavLabelText+"not matches with"+customNavLabel)
//}
//
//String customHeaderText=WebUI.getText(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/getTextFromCustomHeader'))
//
//if(!(customHeadLineTextConcatination==customHeaderText))
//{
//	KeywordUtil.markFailed(customHeaderText+" not matches with "+customHeadLineTextConcatination)
//}
//WebUI.closeWindowIndex(1, FailureHandling.OPTIONAL)
//
//WebUI.switchToWindowIndex(0)
//
WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show Custom Label switch'))
//
WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show custom headline on home page'))
//
WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Empty state for convention switch'))
//
WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Save Button'))
//
WebUI.delay(2)
