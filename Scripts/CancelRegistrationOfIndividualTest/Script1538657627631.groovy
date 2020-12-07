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

String EventVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateEventWithInFutureTimes'(EventVisitVisitType)

String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
    EventVisitVisitType, findTestObject('Add Attendee/EventsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(EventVisitVisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegisteredTab'), 0)

def Object = new TestObject('RegisteredStudentProfile')

Object.addProperty('xpath', ConditionType.EQUALS, ('(//div[text()=\'' + StudentName) + '\'])[1]')

WebUI.verifyElementPresent(Object, 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInButton'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/NotHereButton'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ThreeDotMenu'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ThreeDotMenu'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'), FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 0)
//WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 0)
WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/SelectVisitsYouWouldLikeToSelectCheckBoxInCancelRegistrationModal'), 
    0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/SelectVisitsYouWouldLikeToSelectCheckBoxInCancelRegistrationModal'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Registered/IUnderstandThisActionCheckBoxInCancelRegitrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'))

WebUI.verifyElementPresent(Object, 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/CanceledTabInCanceledDivision'))

WebUI.verifyElementPresent(Object, 0)

