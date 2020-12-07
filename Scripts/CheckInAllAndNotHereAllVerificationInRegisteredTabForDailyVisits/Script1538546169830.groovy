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

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(DailyVisitVisitType)

//not_run: String OrganisationName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForGroupRequestWithUserNameForInstantBook'(
//DailyVisitVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

not_run: CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(DailyVisitVisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegisteredTab'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'),
		'Add Registrant button is not present in Registered tab of visit')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String OrganisationName = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

def Object = new TestObject('RegisteredStudentProfile')

Object.addProperty('xpath', ConditionType.EQUALS, ('(//div[text()=\'' + OrganisationName) + '\'])[1]')

WebUI.refresh()
WebUI.verifyElementPresent(Object, 0)

not_run: WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInButton'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/CheckinAllButtonInRegisteredTab'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/NotHereButton'), 0)

not_run: WebUI.click(findTestObject('DailyVisitsPage/CheckInButton'))

WebUI.click(findTestObject('DailyVisitsPage/Registered/CheckinAllButtonInRegisteredTab'))

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

