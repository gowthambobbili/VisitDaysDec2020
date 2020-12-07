import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String Single = 'Single'

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

//==================
not_run: WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

not_run: WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), '11:00 PM')

not_run: WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

not_run: WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '11:45 PM')

//==================
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

WebUI.delay(4)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

String Group = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisit'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), FailureHandling.STOP_ON_FAILURE)

def VisitTypeInFiter = new TestObject('VisitType in VisitType Filter in index page')

VisitTypeInFiter.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.delay(3)

WebUI.click(VisitTypeInFiter)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/CurrentCapacityFilterDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/AtStudentRegistrationsCapacityOptionInCurrentCapacityFilter'))

def visit = new TestObject('visit in visit index page')

visit.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

if (!(WebUI.verifyElementPresent(visit, 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After appying \'At Student Registration Capacity\' filter in index page, the visits that are at registratins capacity are not shownare')
}

WebUI.click(visit)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

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

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(VisitTypeInFiter)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/CurrentCapacityFilterDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/AtSeatingCapacityOptionInCurrentCapacity'))

if (!(WebUI.verifyElementPresent(visit, 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After appying \'At Seating Capacity\' filter in index page, the visits that are at registratins capacity are not shownare')
}

WebUI.click(findTestObject('DailyVisitsPage/CurrentCapacityFilterDropDown'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/AtStudentRegistrationsCapacityOptionInCurrentCapacityFilter'))

if(!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EmptyStateMessageInVisitIndexPage'), 0)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After applying Current Capacity filter that does not match with existing visits then the empty state message is not shown in visit index page')
}









