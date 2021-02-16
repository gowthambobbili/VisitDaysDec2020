import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def institutionName=CustomKeywords.'com.CommonUtilities.GetInstitutionName.getInstitutionNameFromAdminApp'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateMeeting.getConvention'()

def assigneeName=CustomKeywords.'com.CommonUtilities.CreateMeeting.enterMeetingDetailsAndTimeWithNonZeroFifteenMinTimeIntervals'()

def zoomId=CustomKeywords.'com.CommonUtilities.CreateMeeting.enterZoomId'()

WebUI.waitForElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/MeetingsTimeErrorMessage'),0, FailureHandling.OPTIONAL)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/MeetingsTimeErrorMessage'),0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed('Meetings availabilities are not showning error message')
}


