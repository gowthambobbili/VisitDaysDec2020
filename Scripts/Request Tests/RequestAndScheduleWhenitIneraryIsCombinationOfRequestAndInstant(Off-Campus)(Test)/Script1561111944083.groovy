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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String RequestVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(RequestVisitType)

String InstantVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(InstantVisitType)

List Visits = [InstantVisitType, RequestVisitType]

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

def IndividualStudent = CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'(Visits, findTestObject('Object Repository/Add Attendee/DailyVisitsOptionInAddAttendee'))

WebUI.navigateToUrl(GlobalVariable.StagingUrl)

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

def object = new TestObject('ScheduleButton')

object.addProperty('xpath', ConditionType.EQUALS, ('//p[text()=\'' + RequestVisitType) + '\']/../../../..//button')

WebUI.verifyElementPresent(object, 0)

WebUI.click(object)

if (WebUI.verifyElementPresent(findTestObject('ScheduleModalObjects/ScheduleNewVisitButton'), 0, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('ScheduleModalObjects/ScheduleNewVisitButton'))
}

WebUI.waitForElementPresent(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), 0)

def VisitTimes = WebUI.getText(findTestObject('Object Repository/ScheduleModalObjects/VisitTimeInScheduleVisitmodal'))

def StartTime = VisitTimes.split(" - ")[0]

def EndtTime = VisitTimes.split(" - ")[1]

EndtTime = EndtTime.split(": ")[0].trim()+EndtTime.split(": ")[1]

WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.clearText(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.sendKeys(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), StartTime)

WebUI.click(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

WebUI.clearText(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

WebUI.sendKeys(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'), EndtTime)

WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.click(findTestObject('ScheduleModalObjects/ContinueButtonInScheduleRequestModal'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('ScheduleModalObjects/ErrorMessageForOverlappingTimes'), "After registering to a combination of request and instant visit, if user tries to schedule the request visit with overlapping times with instant visit the error message is not shown and the user is allowed to schdedule with overlapping times")

WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.clearText(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.sendKeys(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), '1:00 PM')

WebUI.click(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

WebUI.clearText(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

WebUI.sendKeys(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'), '2:00 PM')

WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.click(findTestObject('ScheduleModalObjects/ContinueButtonInScheduleRequestModal'))

WebUI.click(findTestObject('ScheduleModalObjects/ScheduleRequestButtonInScheduleRequestModal'))

WebUI.waitForElementNotPresent(findTestObject('Requests/ScheduleButtonInScheduleRequestModal'), 0)

def object2 = new TestObject('ScheduledRequest')

object2.addProperty('xpath', ConditionType.EQUALS, ('//span[text()=\'' + IndividualStudent) + '\']')

WebUI.verifyElementNotPresent(object2, 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(object2, "After scheduling request, the request is still shown in the Requested tab")

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Requests/ScheduledRadioButton'), 0)

WebUI.click(findTestObject('Requests/ScheduledRadioButton'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(object2, "After scheduling the off-campus request, the visit is not shown in Scheduled tab")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(RequestVisitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/RequestRadioButtonInRegistrationMethodFilter'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegisteredStudent(Name)', ["Name":IndividualStudent]), "When registered for a combination of request and instant visits and the request is scheduled, in the registered tab of the  request visit the visitor is still shown in Pending tab")

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/ScheduledTabOnRequestVisitCard'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegisteredStudent(Name)', ["Name":IndividualStudent]), "When registered for a combination of request and instant visits, the visitor is not shown in the Registered tab of instant visit")

WebUI.click(findTestObject('HomePageElements/Visits/OffCampusLeftNav'))

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(InstantVisitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegisteredStudent(Name)', ["Name":IndividualStudent]), "When registered for a combination of request and instant visits, the visitor is not shown in the Registered tab of Request visit")



































