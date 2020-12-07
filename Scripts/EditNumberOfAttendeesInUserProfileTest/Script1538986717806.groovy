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

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(DailyVisitVisitType)

String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
		DailyVisitVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(DailyVisitVisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

//div[@class="uservisit-entry-content"]//div[text()='Test Name207']
def object = new TestObject('RegisteredGroupProfile')

object.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + StudentName) +'\']')

WebUI.verifyElementPresent(object, 0)

WebUI.click(object, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0)

WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

WebUI.verifyElementPresent(findTestObject('UserProfile/EditAttendeesOptionInUserProfile'), 0)

WebUI.click(findTestObject('UserProfile/EditAttendeesOptionInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('UserProfile/EditAttendeesHeaderInEditAttendeesModal'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/NumberOfAttendeesDropDown'), 0)

WebUI.waitForElementVisible(findTestObject('UserProfile/NumberOfAttendeesDropDown'), 0)

WebUI.click(findTestObject('UserProfile/NumberOfAttendeesDropDown'))

WebUI.click(findTestObject('UserProfile/5 OptionInNumberOfAttendeeDropdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UserProfile/SaveNowButtonInEditAttendeesModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('UserProfile/SaveNowButtonInEditAttendeesModal'), 0)

WebUI.verifyElementNotPresent(findTestObject('UserProfile/EditAttendeesHeaderInEditAttendeesModal'), 0)

WebUI.verifyElementText(findTestObject('UserProfile/NumberOfGuestsDivisionInIndividualProfile'), '4 GUESTS')

WebUI.refresh()

WebUI.verifyElementText(findTestObject('DailyVisitsPage/Registered/NumberOfGuestsInRegistratnsPage'), '4 Guests')

