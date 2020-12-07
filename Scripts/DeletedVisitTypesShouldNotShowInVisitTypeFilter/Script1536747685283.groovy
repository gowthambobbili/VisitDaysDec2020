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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

String DailyVisitVisitType = WebUI.callTestCase(findTestCase('Reusable Test Cases/GetExistingDailyVisitOrCreateANewDailyVisit'),
		[:], FailureHandling.STOP_ON_FAILURE)


VerifyDeletedVisitShouldNotPresentInFilters(DailyVisitVisitType, "Daily")

String EventVisitVisitType = WebUI.callTestCase(findTestCase('Reusable Test Cases/GetExistingEventOrCreateANewEvent'), [:],FailureHandling.STOP_ON_FAILURE)


VerifyDeletedVisitShouldNotPresentInFilters(EventVisitVisitType, "Event")

String OffCampusVisitType = WebUI.callTestCase(findTestCase('Reusable Test Cases/GetExistingOff-CampusVisitOrCreateANewOff-CampusVisit'), [:], FailureHandling.STOP_ON_FAILURE)

VerifyDeletedVisitShouldNotPresentInFilters(OffCampusVisitType, "Off")

def VerifyDeletedVisitShouldNotPresentInFilters(String VisitType, String VisitCategory) {
	WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

	def VisitTypeInVisitTypesList = new TestObject('Visit type in visit types page')

	VisitTypeInVisitTypesList.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(VisitTypeInVisitTypesList,
			('The created visit type ' + VisitType) + ' is not present in visit types list')

	WebUI.click(VisitTypeInVisitTypesList)

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'),
			'Details tab is not present in the visit type')

	WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

	CustomKeywords.'com.CommonUtilities.DeleteOperations.DeleteGivenVisitType'(VisitType)

	WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

	WebUI.waitForElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0)

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(VisitTypeInVisitTypesList,
			'The deleted visit type is shown in visit types page')

	if(VisitCategory=="Daily")
	{
		CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()
	}
	else if(VisitCategory=="Event")
	{
		CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()
	}
	else
	{
		CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()
	}

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'),
			'Visit type filter dropdown is not present in the daily visit index page')

	WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

	def VisitTypeInVisitTypeDropdown = new TestObject('deleted visit type in visit type filter')

	VisitTypeInVisitTypeDropdown.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

//	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(VisitTypeInVisitTypeDropdown,
//			'The deleted visit type is shown in the visit type filter dropdown in daily visit index page')
}

