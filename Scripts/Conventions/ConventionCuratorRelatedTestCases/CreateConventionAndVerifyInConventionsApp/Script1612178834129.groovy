import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String conventionName=CustomKeywords.'com.CommonUtilities.CreateNewConvention.createNewConventionWithUpcomingDates'()

WebUI.click(findTestObject('Object Repository/ConventionCurators/MyConventionsLeftNav'))

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('Object Repository/ConventionCurators/ThreeDorMenuInConVentionsPageList',['ConventionName':conventionName]), 0, FailureHandling.OPTIONAL)

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/ConventionCurators/ThreeDorMenuInConVentionsPageList',['ConventionName':conventionName]),0)

WebUI.delay(2)

if(!(WebUI.verifyElementPresent(findTestObject('ConventionCurators/ConventionStatsOptionInThreeDotMenu',['ConventionName':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Convention stats ption is not shown after clicking on three dot menu")
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/LaunchCreatedConvention',['ConventionName':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("launch option is not shown after clicking on three dot menu")
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/EditConvention',['ConventionName':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("edit option is not shown after clicking on three dot menu")
}

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

if(!(WebUI.verifyElementPresent(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("created convention is not shown in the conventions app")
}