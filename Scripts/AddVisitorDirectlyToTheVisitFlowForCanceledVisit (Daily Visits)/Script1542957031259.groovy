import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Cancel visit button is not present in details page of daily visit')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/CancelDailyVisitButton'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AllDatesAndTimesRadioButtonInCancelVisitModal'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Cancel daily visit modal is not shown when user clicks Cancel Daily visit button')

    WebUI.takeScreenshot()
}

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AllDatesAndTimesRadioButtonInCancelVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/ThisInstanceOnlyRadioButtonInCancelVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Yes,IUnderstoodCheckBoxInCancelDailyVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('After selecting the check box and clicking Cancel Now button in Cancel daily visit modal, the modal is not getting closed')

    WebUI.takeScreenshot()
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/CanceledOptionInStatusFilter'))

WebUI.delay(2)

def CancledVisit = new TestObject('Canceled Visit in visit index page')

CancledVisit.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

if (!(WebUI.verifyElementPresent(CancledVisit, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('The visit is not getting canceld')

    WebUI.takeScreenshot()
}

WebUI.click(CancledVisit)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Add Registrant button is not shown canceld visit')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementNotClickable(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Add Registrant button is not disabled for the canceld visit, button is expected to disable for canceld visits')

    WebUI.takeScreenshot()
}

