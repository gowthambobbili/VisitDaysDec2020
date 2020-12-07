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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String RequestVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(RequestVisitType)

String InstantVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(InstantVisitType)

String Single = 'Single'

String IndividualStudent = CustomKeywords.'com.CommonUtilities.ConfirmationPage.RegistrationOfACombinationOfRequestAndInstant'(
    RequestVisitType, InstantVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

//p[text()='Test Visit Type67142']/../../../..//button
def object = new TestObject('ScheduleButton')

object.addProperty('xpath', ConditionType.EQUALS, ('//p[text()=\'' + RequestVisitType) + '\']/../../../..//button')

WebUI.verifyElementPresent(object, 0)

WebUI.click(object)

//CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

if (WebUI.verifyElementPresent(findTestObject('ScheduleModalObjects/ScheduleNewVisitButton'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ScheduleModalObjects/ScheduleNewVisitButton'))
}

WebUI.waitForElementPresent(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), 0)

WebUI.click(findTestObject('ScheduleModalObjects/ContinueButtonInScheduleRequestModal'))

WebUI.verifyElementPresent(findTestObject('ScheduleModalObjects/ErrorMessageForOverlappingTimes'), 0)

WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.clearText(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.sendKeys(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), '10:00 AM')

WebUI.click(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

WebUI.clearText(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

WebUI.sendKeys(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'), '11:00 AM')

WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.click(findTestObject('ScheduleModalObjects/ContinueButtonInScheduleRequestModal'))

WebUI.click(findTestObject('ScheduleModalObjects/ScheduleRequestButtonInScheduleRequestModal'))

WebUI.waitForElementNotPresent(findTestObject('Requests/ScheduleButtonInScheduleRequestModal'), 0)

//WebUI.verifyElementNotPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0, FailureHandling.OPTIONAL)
//
//WebUI.delay(2)
def object2 = new TestObject('ScheduledRequest')

object2.addProperty('xpath', ConditionType.EQUALS, ('//span[text()=\'' + IndividualStudent) + '\']')

WebUI.verifyElementNotPresent(object2, 0)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Requests/ScheduledRadioButton'), 0)

WebUI.click(findTestObject('Requests/ScheduledRadioButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(object2, 0)

