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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/EditLinkInDateDivision'))

WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

String ModifiedDate = WebUI.getText(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('After edit and clicking save button the Save button is not getting hidden and the chanes are not getting saved')
}

String DateInDateField = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/DateInDateField'))

ActualTimeBeforeEdit = WebUI.getText(findTestObject('OffCampusPage/TimeInTimesDivisionForOffCampus'))

String ActualTimeZoneBeforeEdit = ActualTimeBeforeEdit.split("09:00 AM ")[1]

if (!(DateInDateField.contains(ModifiedDate))) {
	KeywordUtil.markFailedAndStop('In summary page the modified date is not shown in summary page after clicking save button')
}

WebUI.click(findTestObject('DailyVisitsPage/EditLinkInTimesDivisionInSUmaryPage'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'), 0)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), '10:00 AM')

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'), '11:00 AM')

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('After edit and clicking save button the Save button is not getting hidden and the chanes are not getting saved')
}

ModifiedTime = WebUI.getText(findTestObject('OffCampusPage/TimeInTimesDivisionForOffCampus'))

// format: 08:00 AM IST - 09:00 AM IST
if (!(WebUI.verifyMatch(ModifiedTime, '10:00 AM '+ActualTimeZoneBeforeEdit+' - 11:00 AM '+ActualTimeZoneBeforeEdit, false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After modifying the time and click save button in Times division, the modified times are not shown in summary page')
}

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInLocationDivision'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/LocationsDropDown'))

LocationTobeSelectInLocationsDropdown = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/SecondLocationNameInLocationsDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SecondLocationNameInLocationsDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('After edit and clicking save button the Save button is not getting hidden and the chanes are not getting saved')
}

ModifiedLocation = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/LocationInLocationDivision'))

if (!(WebUI.verifyMatch(ModifiedLocation.toLowerCase(), LocationTobeSelectInLocationsDropdown.toLowerCase(), false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After modifying the location in summary page the and clicking save button the modified location is not shown in the location division')
}

WebUI.click(findTestObject('DailyVisitsPage/EditLInkInCapacityDivision'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '10')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '10')

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'),
		0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionOneInHowManyGuestsAreProspectiveStudentsAllowedToBring'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('After edit and clicking save button the Save button is not getting hidden and the chanes are not getting saved')
}

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Details Page/CapacityInCapacityDivision'), '10 Seats', FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After modifying the maximum number of allowed visits the modyfied Capacity is not shown in capacity division')
}

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Details Page/MaximumRegitrationsInCapacityDivision'), '10 Registrations',
FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After modifying the maximum capacity for the visit, the modyfied "Maximum Registrants" is not shown in capacity division')
}

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Details Page/GuestsPerProspectiveStudentsInCapacityDivision'),
'1', FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After modyfing the "Guests Per Prospective Student", the modyfied "Guests Per Prospective Student" is not shown in capacity division')
}

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/EditLinkInUsersAssignedDivision'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInUsersAssignedDivision'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/SearchUserSearchboxInAssignUsersPage'), 0)

WebUI.sendKeys(findTestObject('DailyVisitsPage/SearchUserSearchboxInAssignUsersPage'), 'mahesh test')

WebUI.click(findTestObject('DailyVisitsPage/AddSymbolOfMaheshTestInAssignUsersPage'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('After edit and clicking save button the Save button is not getting hidden and the chanes are not getting saved')
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/MaheshTestProfileInUsersAssigedDivision'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('Assigned user is in summary page is not shown in \'User Assigned\' division')
}

//=========================================================================
WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.delay(4)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

def date = new TestObject('DateOnVisitCardInIndexPage')

date.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']/../..//span')

String dateOnVisitCard = WebUI.getText(date)

if (!(dateOnVisitCard.contains(ModifiedDate))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('If user edits the date in summary page and publish a visit, then the visit is not published with the modified date in summary page')
}

def visit = new TestObject('CreatedVisitInIndexPage')

visit.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

WebUI.click(visit)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

if (!(WebUI.verifyMatch(ModifiedTime, '10:00 AM '+ActualTimeZoneBeforeEdit+' - 11:00 AM '+ActualTimeZoneBeforeEdit, false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('Modifications made for Times in summary page are not shown in details page after publishing the visit')
}

if (!(WebUI.verifyMatch(ModifiedLocation.toLowerCase(), LocationTobeSelectInLocationsDropdown.toLowerCase(), false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('Modifications made for Location in summary page are not shown in details page after publishing the visit')
}

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Details Page/CapacityInCapacityDivision'), '10 Seats', FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('Modifications made for Capacity in summary page are not shown in details page after publishing the visit')
}

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Details Page/MaximumRegitrationsInCapacityDivision'), '10 Registrations',
FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop(' modifications the made for maximum capacity for the visit in summary page are not shown in details page after publishing the visit')
}

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Details Page/GuestsPerProspectiveStudentsInCapacityDivision'),
'1', FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('Modifications made for "Guests Per Prospective Student" in summary page are not shown in the detials page after publishing the visit')
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/MaheshTestProfileInUsersAssigedDivision'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('Modifications made for assigned users in summary page are not shown in the details page, ater creating the visit')
}

