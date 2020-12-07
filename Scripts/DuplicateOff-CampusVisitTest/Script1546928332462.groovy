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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'),
		'Detials tab is not present in visit')

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

String Time = WebUI.getText(findTestObject('OffCampusPage/TimeInTimesDivisionForOffCampus'))

String Timezone = Time.split("09:00 AM ")[1]

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/DuplicateVisitButton'),
		'Duplicate Off-Campus button in not present in the off-campus visit \'Datails\' page')

WebUI.click(findTestObject('DailyVisitsPage/DuplicateVisitButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'),
		'Duplicate off campus modal is not shown after clicking "Duplicate Off campus visit" button in Detials page')

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'),
		'After clicking \'Duplicate\' button in \'Duplicate Off Campus Visit\' modal the modal is not getting closed')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('EventsPage/DateFieldInCreateEventPage'),
		'After duplicating a visit the detials page is not shown')

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), 0)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), '9:00 AM')

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'), '10:00 AM')

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/SelectedAssignNowButton'),
		'After duplicating an Off-Campus visit, \'Assigned Now\' button is getting deselected in User Assigned division')

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

String ExpectedTimeAfterEditingDuplicateVisit = '09:00 AM '+Timezone+' - 10:00 AM '+Timezone

String expected = WebUI.getText(findTestObject('OffCampusPage/TimeInTimesDivisionForOffCampus'))

println expected

println ExpectedTimeAfterEditingDuplicateVisit

WebUI.verifyElementText(findTestObject('OffCampusPage/TimeInTimesDivisionForOffCampus'), ExpectedTimeAfterEditingDuplicateVisit)

