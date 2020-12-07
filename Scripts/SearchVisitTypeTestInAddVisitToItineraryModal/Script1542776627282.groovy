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

String InstantVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String RequestVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(RequestVisitType)

String InstantVisitTypeToCreateVisit = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(InstantVisitTypeToCreateVisit)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(InstantVisitTypeToCreateVisit)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Group = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

def ThereDotMenu = new TestObject('ThreeDotMenuOFRegisteredStudent')

ThereDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Group) + '\']/../..//i[text()=\'more_vert\']')

CustomKeywords.'com.CommonUtilities.NewMobiRegistration.switchToDefaultContent'()

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

WebUI.click(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

def visit = new TestObject('VisitType name in available search dropdown')

visit.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + InstantVisitType) + '\']')

if (!(WebUI.verifyElementNotPresent(visit, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('VisitType which does not have published visits is shown in available visits search dropdown in "Add Visit To My Itinerary" modal')

	WebUI.takeScreenshot()
}

visit.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + RequestVisitType) + '\']')

if (!(WebUI.verifyElementNotPresent(visit, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('When loaded visits for a instant visit in Add visit to itinerary modal "Request visit types" are shown in search dropdown')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'), FailureHandling.STOP_ON_FAILURE)

def object = new TestObject('Request visit type in add visit to itinerary modal')

object.addProperty('xpath', ConditionType.EQUALS, ('//strong[text()=\'' + RequestVisitType) + '\']')

if (!(WebUI.verifyElementNotPresent(object, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('When loaded visits for a instant visit in Add visit to itinerary modal "Request visit types" are shown in Add visit to itinerary modal')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelButtonInAddVisitToItineraryModal'))

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/CancelButtonInAddVisitToItineraryModal'), 0)

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

def VisitTypeInVisitTypesList = new TestObject('VisitTypeInVIsitTypeLList')

VisitTypeInVisitTypesList.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + InstantVisitType) + '\']')

WebUI.click(VisitTypeInVisitTypesList)

WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'))

WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

WebUI.waitForElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimesOtherThenDefaultTimes'(
		InstantVisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(InstantVisitTypeToCreateVisit)

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

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

WebUI.click(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

visit.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + InstantVisitType) + '\']')

if (!(WebUI.verifyElementNotPresent(visit, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The visit type which registrant type is "Group" was shown while adding visit to Individual itinerary')

	WebUI.takeScreenshot()
}

