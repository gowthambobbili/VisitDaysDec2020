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

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitTypeName)

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitTypeName)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegisteredTab'), 0)

WebUI.verifyElementText(findTestObject('DailyVisitsPage/Registered/EmptyStateTextInRegisteredTab'), 'Hmmm.... there aren\'t any results',
		FailureHandling.CONTINUE_ON_FAILURE)

String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
		VisitTypeName, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/RegisteredTab'), 0)

def Object = new TestObject('RegisteredStudentProfile')

Object.addProperty('xpath', ConditionType.EQUALS, ('(//div[text()=\'' + StudentName) + '\'])[1]')

WebUI.verifyElementPresent(Object, 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ThreeDotMenu'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ThreeDotMenu'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/RescheduleOptionIn3DotMenu'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ResendConfirmationOptionIn3DotMenu'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/RescheduleOptionIn3DotMenu'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/DontRescheduleButtonInRescheduleModal'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/DontRescheduleButtonInRescheduleModal'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/Registered/DontRescheduleButtonInRescheduleModal'))

WebUI.waitForElementNotPresent(findTestObject('DailyVisitsPage/Registered/DontRescheduleButtonInRescheduleModal'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ThreeDotMenu'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ThreeDotMenu'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ResendConfirmationOptionIn3DotMenu'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/CancelButtonInResendConfirmationModal'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/CancelButtonInResendConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelButtonInResendConfirmationModal'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('DailyVisitsPage/Registered/CancelButtonInResendConfirmationModal'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ThreeDotMenu'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ThreeDotMenu'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/DontCancelButtonInCancelRegistrationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/DontCancelButtonInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/DontCancelButtonInCancelRegistrationModal'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('DailyVisitsPage/Registered/DontCancelButtonInCancelRegistrationModal'), 0,
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(Object)

WebUI.verifyElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/VisitsTabInUserProfile'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/MainThreedotMenuInUserProfile'), 0)

WebUI.waitForElementClickable(findTestObject('UserProfile/MainThreedotMenuInUserProfile'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('UserProfile/MainThreedotMenuInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('UserProfile/MergeOption'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/DeleteLabelInUserProfile'), 0)

