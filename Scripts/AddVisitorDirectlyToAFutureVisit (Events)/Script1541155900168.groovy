import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword as Keyword
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

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateEventWithInFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

String Student = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def status = new TestObject('Checkin Symbol in user profile')

status.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Student) + '\']')

if (!(WebUI.verifyElementPresent(status, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('After registering an individual directly to a visit the individual is not shown in registered tab')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInButton'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('After adding an individual directly to a future visit the individual is Checked in ')

    WebUI.takeScreenshot()
}

