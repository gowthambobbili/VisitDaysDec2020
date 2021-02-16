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
	KeywordUtil.markFailed("Convention stats option is not shown after clicking on three dot menu")
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/LaunchCreatedConvention',['ConventionName':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("launch option is not shown after clicking on three dot menu")
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/EditConvention',['ConventionName':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("edit option is not shown after clicking on three dot menu")
}
WebUI.scrollToElement(findTestObject('Object Repository/ConventionCurators/LaunchCreatedConvention',['ConventionName':conventionName]), 0, FailureHandling.OPTIONAL)

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/ConventionCurators/EditConvention',['ConventionName':conventionName]),0)

WebUI.waitForPageLoad(0)

WebUI.waitForElementPresent(findTestObject('Object Repository/ConventionCurators/ViewConventions/ThreeDotMenu'),0)

WebUI.click(findTestObject('Object Repository/ConventionCurators/ViewConventions/ThreeDotMenu'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ConventionCurators/ViewConventions/DeleteConvention'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/ViewConventions/EnterConventionNameInDeleteField'),conventionName)

WebUI.waitForElementClickable(findTestObject('Object Repository/ConventionCurators/ViewConventions/Ok Delete Button'), 0)

WebUI.click(findTestObject('Object Repository/ConventionCurators/ViewConventions/Ok Delete Button'))

WebUI.delay(2)


if(!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/ConventionCurators/CreatedConvention'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Created Convention is not deleted")
}

