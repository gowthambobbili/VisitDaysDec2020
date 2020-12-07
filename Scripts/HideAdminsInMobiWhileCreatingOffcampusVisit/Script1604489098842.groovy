import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitTypes = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithKeywordCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithInprogressTimesAndHideAdmins'(VisitTypes)

WebUI.click(findTestObject('Object Repository/HomePageElements/AddAttendeeButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.delay(6)

WebUI.click(findTestObject('Object Repository/Add Attendee/OffCampusOptionInAddAttendee'))

WebUI.delay(6)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/VerifyAdminShownInDailyVisit',['VisitName':VisitTypes]),5,FailureHandling.OPTIONAL))
{
	KeywordUtil.markFailed('Admin users are not hideen in mobi')
}

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.delay(6)

WebUI.click(findTestObject('Object Repository/Add Attendee/OffCampusOptionInAddAttendee'))

WebUI.delay(6)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/VerifyAdminShownInDailyVisit',['VisitName':VisitTypes]),5,FailureHandling.OPTIONAL))
{
	KeywordUtil.markFailed('Admin users are not hideen in mobi of student link')
}

