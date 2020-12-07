import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateEventWithInFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

TestObject Individual = CustomKeywords.'com.CommonUtilities.MobiRegistrations.RegisterAnIndividualThroughMobiAndReturnTheStudetName'()

WebUI.click(Individual)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/CheckInButtonInUserProfile'))

WebUI.waitForElementPresent(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), 0)

WebUI.delay(3)

String Status = WebUI.getText(findTestObject('UserProfile/StatusFieldInUserProfile'))

println(Status)

String CurrentTime = CustomKeywords.'com.CommonUtilities.Times.GetTimeForStatusTimeStampInUserProfile'()

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), CurrentTime)

if (!(WebUI.verifyElementText(findTestObject('UserProfile/StatusFieldInUserProfile'), 'check\ntest user1 checked in', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After admin changing the status, the status is shown incorrect in user profile (not shown admins\'s name in status)')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'))

WebUI.waitForElementVisible(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

WebUI.delay(3)

String CurrentTime1 = CustomKeywords.'com.CommonUtilities.Times.GetTimeForStatusTimeStampInUserProfile'()

WebUI.verifyElementText(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), CurrentTime1)

if (!(WebUI.verifyElementText(findTestObject('UserProfile/StatusFieldInUserProfile'), 'block\ntest user1 marked not here',
FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After admin changes the status(Check in/Not here) the status not shown incorrect in user profile (not shows admins\'s name in status message)')

	WebUI.takeScreenshot()
}

WebUI.refresh()

TestObject Group = CustomKeywords.'com.CommonUtilities.MobiRegistrations.RegisterGroupThroughMobiAndReturnTheGroupName'()

WebUI.click(Group)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/CheckInAllButtonInUserProfile'))

WebUI.waitForElementPresent(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), 0)

WebUI.delay(3)

String GroupStatus = WebUI.getText(findTestObject('UserProfile/StatusFieldInUserProfile'))

println(GroupStatus)

String GroupCurrentTime = CustomKeywords.'com.CommonUtilities.Times.GetTimeForStatusTimeStampInUserProfile'()

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), GroupCurrentTime)

if (!(WebUI.verifyElementText(findTestObject('UserProfile/StatusFieldInUserProfile'), 'check\ntest user1 checked in', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After admin changes the status the status is shown incorrect in user profile (not shown admins\'s name in status)')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'))

WebUI.waitForElementVisible(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

WebUI.delay(3)

String CurrentTime2 = CustomKeywords.'com.CommonUtilities.Times.GetTimeForStatusTimeStampInUserProfile'()

WebUI.verifyElementText(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), CurrentTime2)

if (!(WebUI.verifyElementText(findTestObject('UserProfile/StatusFieldInUserProfile'), 'block\ntest user1 marked not here',
FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After admin changes the status(Check in/Not here) the status not shown incorrect in user profile (not shows admins\'s name in status message)')

	WebUI.takeScreenshot()
}

