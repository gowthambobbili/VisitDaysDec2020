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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String InstantVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

String InstantVisitTypeToCreateVisit = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(InstantVisitTypeToCreateVisit)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(InstantVisitTypeToCreateVisit)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0))) {
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Group = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

def ThereDotMenu = new TestObject('ThreeDotMenuOFRegisteredStudent')

ThereDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Group) + '\']/../..//i[text()=\'more_vert\']')

WebUI.click(ThereDotMenu)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

if (!(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/AddVisitToItineraryEmptyStateMessage'),
10, FailureHandling.OPTIONAL)))
{

	if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')

		WebUI.takeScreenshot()
	}

	WebUI.delay(2)

	if (!(WebUI.verifyTextNotPresent(InstantVisitType, false, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('The Visit type which doesn\'t have any published visits is shown in \'Add Visit to itinerary\' modal')

		WebUI.takeScreenshot()
	}

	WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelButtonInAddVisitToItineraryModal'))

	WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/CancelButtonInAddVisitToItineraryModal'), 0)

}
else
{
	WebUI.click(findTestObject('Object Repository/DailyVisitsPage/CloseButtonInAddVisitToItineraryEmptystateModal'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/CloseButtonInAddVisitToItineraryEmptystateModal'),
			"On clicking Close button in Add visit to itinerary empty state modal the modal is not getting disappeared")
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.waitForElementPresent(findTestObject('OffCampusPage/CreateOffCampusButton'), 0)

WebUI.click(findTestObject('OffCampusPage/CreateOffCampusButton'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(InstantVisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(InstantVisitTypeToCreateVisit)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0))) {
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.click(ThereDotMenu)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

if (!(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/AddVisitToItineraryEmptyStateMessage'),
10, FailureHandling.OPTIONAL)))
{
	if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')
		WebUI.takeScreenshot()
	}
	WebUI.delay(2)
	def ConflictingVisit = new TestObject("Visit with conflicting times")
	ConflictingVisit.addProperty("xpath", ConditionType.EQUALS,"//strong[text()='"+InstantVisitType+"']")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(ConflictingVisit,
			"The visits with conflicting times are shown in Add Visit to itinerary modal")
}
else
{
	WebUI.click(findTestObject('Object Repository/DailyVisitsPage/CloseButtonInAddVisitToItineraryEmptystateModal'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/CloseButtonInAddVisitToItineraryEmptystateModal'),
			"On clicking Close button in Add visit to itinerary empty state modal the modal is not getting disappeared")
}
