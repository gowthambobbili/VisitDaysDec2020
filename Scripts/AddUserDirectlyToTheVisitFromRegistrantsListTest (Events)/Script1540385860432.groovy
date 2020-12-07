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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateEventWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailedAndStop('\'Add Registrant\' button is not present in Registered tab to add user directly from visit')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

//===========
WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

VisitTypeNameInMobi = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameInRegistrationDescriptionPage'))

if (!(WebUI.verifyMatch(VisitTypeNameInMobi, VisitType, false, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('While adding user(Individual) from visit directly in mobi it is pointing the visit other than the actual visit')

    WebUI.takeScreenshot()
}

WebUI.verifyElementPresent(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

CustomKeywords.'com.CommonUtilities.Quit.ExitMobi'()

WebUI.switchToDefaultContent()

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

//===========
WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

VisitTypeNameInMobi = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameInRegistrationDescriptionPage'))

if (!(WebUI.verifyMatch(VisitTypeNameInMobi, VisitType, false, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('While adding user(Group) from visit directly in mobi it is pointing the visit other than the actual visit')

    WebUI.takeScreenshot()
}

WebUI.verifyElementPresent(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

CustomKeywords.'com.CommonUtilities.Quit.ExitMobi'()

WebUI.switchToDefaultContent()

