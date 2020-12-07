import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Checkbox as Checkbox
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

String VisitTypeToAddItinerary = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimesOtherThenDefaultTimes'(
		VisitTypeToAddItinerary)

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String Single = 'Single'

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '1')

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '10')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionOneInHowManyGuestsAreProspectiveStudentsAllowedToBring'))

//WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))
WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

not_run: CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitTypeToAddItinerary)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0))) {
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Individual1 = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitTypeToAddItinerary)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0))) {
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Individual = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def ThereDotMenu = new TestObject('ThreeDotMenuOFRegisteredStudent')

ThereDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Individual) + '\']/../..//i[text()=\'more_vert\']')

WebUI.click(ThereDotMenu)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')

	WebUI.takeScreenshot()
}

WebUI.delay(2)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
		0)

def Checkbox = new TestObject('Visit Checkbox in Add visit to itinerary modal')

Checkbox.addProperty('xpath', ConditionType.EQUALS, ('(//strong[text()=\'' + VisitType) + '\']//following::div[@class=\'multiselect-checkboxes ember-view\']//input)[1]')

WebUI.click(Checkbox)

def OvercapacityCheckbox = new TestObject('I understand want to go over capacity checkbox in Add visit to itinerary modal')

OvercapacityCheckbox.addProperty('xpath', ConditionType.EQUALS, ('//strong[text()=\'' + VisitType) + '\']//following::div[@class=\'over-capacity-warning\']//label[contains(text(),\'I understand and want to go over capacity\')]')

if (!(WebUI.verifyElementPresent(OvercapacityCheckbox, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('On select a visit at Maximum registrations in "Add visit to itinerary modal, "I Understand and wnt to go overcapacity" Checkbox is not shown')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/OveCapacityWarningMessageInAddVisitToItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('On select a visit at Maximum registrations in "Add visit to itinerary modal, "Registration at capacity" warning message is not shown')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Registered/OveCapacityWarningMessageInAddVisitToItineraryModal'),
('error\n' + VisitType) + ' at 8:00 AM - 9:00 AM will go over capacity by 1 registration(s)', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The over capacity warning message shown incorrect on selecting visit which is at maximum registrations')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelButtonInAddVisitToItineraryModal'))

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/CancelButtonInAddVisitToItineraryModal'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/VisitAtCapacityHeadInVisitAtCapactyModal'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('Visit At Capaity Modal is not shown for the visit which is at capacity')

	WebUI.takeScreenshot()
}

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/No,DontAddButtonInVisitAtCapacityModal'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/Yes, AddRegistrantButtonInVisitAtCapacityModal'),
		0)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/No,DontAddButtonInVisitAtCapacityModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/No,DontAddButtonInVisitAtCapacityModal'))

WebUI.waitForElementNotPresent(findTestObject('DailyVisitsPage/Registered/No,DontAddButtonInVisitAtCapacityModal'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInCapacityDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '10')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '1')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Details Page/ThisInstanceOnlyRadioButtonInEditVisitModal'),
		0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/ThisInstanceOnlyRadioButtonInEditVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveNowButtonInEditVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveNowButtonInEditVisitModal'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitTypeToAddItinerary)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0))) {
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.click(ThereDotMenu)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')

	WebUI.takeScreenshot()
}

WebUI.delay(2)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
		0)

WebUI.click(Checkbox)

if (!(WebUI.verifyElementPresent(OvercapacityCheckbox, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('On select a visit at Maximum registrations in "Add visit to itinerary modal, "I Understand and wnt to go overcapacity" Checkbox is not shown')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/OveCapacityWarningMessageInAddVisitToItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('On select a visit at Maximum registrations in "Add visit to itinerary modal, "Registration at capacity" warning message is not shown')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Registered/OveCapacityWarningMessageInAddVisitToItineraryModal'),
('error\n' + VisitType) + ' at 8:00 AM - 9:00 AM will go over capacity by 1 seat(s)', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The over capacity warning message shown incorrect on selecting visit which is at maximum registrations')

	WebUI.takeScreenshot()
}

