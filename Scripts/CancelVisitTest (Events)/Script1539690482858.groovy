import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.xmlbeans.impl.regex.Token.ConditionToken as ConditionToken
import org.junit.After as After
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

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateEventWithInstantVisitType'(VisitType)

String Individual = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
    VisitType, findTestObject('Add Attendee/EventsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.delay(3)

String Group = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForGroupRequestWithUserNameForInstantBook'(
    VisitType, findTestObject('Add Attendee/EventsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

def object = new TestObject('RegisteredIndividualStudent')

object.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + Individual) + 
    '\']')

def object2 = new TestObject('RegisteredGroup')

object2.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + Group) + '\']')

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.verifyElementPresent(object, 0)

WebUI.verifyElementPresent(object2, 0)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Yes,IUnderstoodCheckBoxInCancelDailyVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Yes,IUnderstoodCheckBoxInCancelDailyVisitModal'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'))

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

//CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)
def object4 = new TestObject('CancelledLabelOnCancledVisitCard')

object4.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']/../../../..//p[text()=\'Canceled\']')

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(2)

def object3 = new TestObject('VisitTypeInVisitTypeFilter')

object3.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object3)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/CanceledOptionInStatusFilter'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

if (!(WebUI.verifyElementPresent(object4, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('After canceling the visit canceled label not shown on the visit (Visit not canceled )')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CanceledTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

if (!(WebUI.verifyElementPresent(object, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('After Cacelling the visit the Individual student profiles are not shown in the Canceled tab')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(object2, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('After Cancelling the visit which has Group and Individual registrations, the Group profiles are not shown in the Canceled tab')

    WebUI.takeScreenshot()
}

