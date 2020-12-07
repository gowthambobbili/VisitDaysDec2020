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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusWithInstantVisitTypeWithCapacity'(VisitType)

CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
    VisitType, findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

def object3 = new TestObject('CapacityFilledOnVisitCard')

object3.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']/../../..//p[text()=\'Capacity Filled\']/..//h3')

String CapacityFilledOnVisitCard = WebUI.getText(object3)

String ExpectedCapcityFilledOnVisitCard = '1.00%'

if (!(WebUI.verifyMatch(CapacityFilledOnVisitCard, ExpectedCapcityFilledOnVisitCard, false, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Capacity Filled is shown wrong on visit card in index page for Individual registration')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CheckInButton'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInProgressBar'), 0))) {
    KeywordUtil.markFailed('Check in bar is not shown on visit card in registrants page for Individual check in')

    WebUI.takeScreenshot()
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.delay(2)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

def filter = new TestObject('VisitTypeInVIistTypeFilter')

filter.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(filter)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInProgressBar'), 0))) {
    KeywordUtil.markFailed('Check in bar is not shown on visit card in Index page for Individual check in')

    WebUI.takeScreenshot()
}

//=============================
CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForGroupRequestWithUserNameForInstantBook'(
    VisitType, findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

//CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)
WebUI.refresh()

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.click(filter)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

String CapacityFilledOnVisitCardForGroup = WebUI.getText(object3)

String ExpectedCapcityFilledOnVisitCardForGroup = '2.00%'

if (!(WebUI.verifyMatch(CapacityFilledOnVisitCardForGroup, ExpectedCapcityFilledOnVisitCardForGroup, false, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Capacity Filled is shown wrong on visit card in index page for Group registration')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/CheckinAllButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/CheckinAllButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInProgressBar'), 0))) {
    KeywordUtil.markFailed('Check in bar is not shown on visit card in registrants page for Group check in')

    WebUI.takeScreenshot()
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.delay(2)

WebUI.refresh()

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(3)

WebUI.click(filter)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInProgressBar'), 0))) {
    KeywordUtil.markFailed('Check in bar is not shown on visit card in Index page for Group check in')

    WebUI.takeScreenshot()
}

