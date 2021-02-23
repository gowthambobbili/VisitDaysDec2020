import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

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

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('ConventionCurators/ConventionStatsOptionInThreeDotMenu',['ConventionName':conventionName]),0)

WebUI.waitForPageLoad(0)

String liveSessionsCount=WebUI.getText(findTestObject('Object Repository/ConventionCurators/Convention stats page/GetliveSessionsCount'))

println liveSessionsCount

String beforeAddingCount=liveSessionsCount.split(" ")[0];

println beforeAddingCount

int beforeCount=Integer.parseInt(beforeAddingCount)

println beforeCount

CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

def meetname=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterLiveSessionDetailsAndTime'()

println conventionName

def ZoomId=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterZoomIdAndAddAssigne'()

int estimatedCount=beforeCount+1

println estimatedCount

WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('Object Repository/ConventionCurators/ThreeDorMenuInConVentionsPageList',['ConventionName':conventionName]), 0, FailureHandling.OPTIONAL)

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/ConventionCurators/ThreeDorMenuInConVentionsPageList',['ConventionName':conventionName]),0)

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('ConventionCurators/ConventionStatsOptionInThreeDotMenu',['ConventionName':conventionName]),0)

WebUI.waitForPageLoad(0)

WebUI.refresh()

String liveSessionsCountAfterAddingSession=WebUI.getText(findTestObject('Object Repository/ConventionCurators/Convention stats page/GetliveSessionsCount'))

println liveSessionsCountAfterAddingSession

String afterAddingCount=liveSessionsCountAfterAddingSession.split(" ")[0];

println afterAddingCount

int afterCount=Integer.parseInt(afterAddingCount)

if(estimatedCount!=afterCount)
{
	KeywordUtil.markFailed("live sessions count in summary page is showing wrong")
}
