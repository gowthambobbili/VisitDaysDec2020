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

String OffCampusVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(OffCampusVisitVisitType)

String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
    OffCampusVisitVisitType, findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(OffCampusVisitVisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegisteredTab'), 0)

def Object = new TestObject('RegisteredStudentProfile')

Object.addProperty('xpath', ConditionType.EQUALS, ('(//div[text()=\'' + StudentName) + '\'])[1]')

WebUI.verifyElementPresent(Object, 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInButton'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/NotHereButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CheckInButton'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInProgressBar'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/CheckedInTab'))

WebUI.verifyElementPresent(Object, 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/Yes,ChangeButtonInChangeStatusModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/Yes,ChangeButtonInChangeStatusModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('DailyVisitsPage/Registered/Yes,ChangeButtonInChangeStatusModal'), 0, FailureHandling.STOP_ON_FAILURE)

//WebUI.waitForElementNotVisible(findTestObject('DailyVisitsPage/Registered/Yes,ChangeButtonInChangeStatusModal'), 0, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementNotPresent(Object, 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/CheckInProgressBar'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/NotHereTab'))

WebUI.verifyElementPresent(Object, 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'), 0)

