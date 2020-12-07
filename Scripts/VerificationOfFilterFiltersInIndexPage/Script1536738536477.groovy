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

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 10, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CurrentCapacityFilterInVisitIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegistrantTypeFilterLabel'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/IndividualsRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/GroupsRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/BothRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RequestRadioButtonInRegistrationMethodFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/BothRadioButtonInRegistrationMethodFilter'), 0)

WebUI.refresh()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.waitForElementPresent(findTestObject('EventsPage/CreateEventButton'), 0)

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 10, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CurrentCapacityFilterInVisitIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegistrantTypeFilterLabel'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/IndividualsRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/GroupsRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/BothRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RequestRadioButtonInRegistrationMethodFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/BothRadioButtonInRegistrationMethodFilter'), 0)

WebUI.refresh()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.waitForElementPresent(findTestObject('OffCampusPage/CreateOffCampusButton'), 0)

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 10, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CurrentCapacityFilterInVisitIndexPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegistrantTypeFilterLabel'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/IndividualsRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/GroupsRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/BothRadioButtonInRegistrantTypeFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RequestRadioButtonInRegistrationMethodFilter'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/BothRadioButtonInRegistrationMethodFilter'), 0)

