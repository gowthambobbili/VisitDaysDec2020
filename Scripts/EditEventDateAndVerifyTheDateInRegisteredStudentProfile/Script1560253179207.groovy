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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateEventWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

def studentName = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInDateDivisionOfEvent'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/DateField'))

WebUI.click(findTestObject('EventsPage/ImmediateNextDateToTheCurrentDateInEventDetailsPage'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('DailyVisitsPage/Details Page/SaveButton'),
		'After editing Event date and click Save button the save button is still shown and the date is not getting saved')

DateAfterEditing = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/DateInEventsSummaryPage'))

WebUI.click(findTestObject('DailyVisitsPage/RegistrantsTabInVisitCard'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/RegisteredStudent(Name)', ["Name":studentName]))

WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/FirstVisitInUserProfileVisits'), 0)

def DateInUserProfile = WebUI.getText(findTestObject('Object Repository/UserProfile/DateInUserProfile'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(DateInUserProfile.split("day, ")[1], DateAfterEditing, "After editing the event time, the time in the user profile is not shown the latest date")
