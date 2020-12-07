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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitTypeName)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitTypeName)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/DuplicateVisitButton'),
		'"Duplicate Daily Visit" button is not present in Details page of daily visit ')

WebUI.click(findTestObject('DailyVisitsPage/DuplicateVisitButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'),
		'"Duplica Daily Visit" modal is not shown when user click "Duplicate Daily Visit" button')

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After clicking \'Duplicate\' button in \'Duplicate Daily Visit\' modal the modal is not getting closed')
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitHeader'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After clicking \'Duplicate\' button in \'Duplicate Daily Visit\' The create daily visit page is not shown')
}

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), 0)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), '9:00 AM')

WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '10:00 AM')

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

UpdatedLocation = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/SecondLocationNameInLocationsDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SecondLocationNameInLocationsDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'),
		'After duplicating a Daily Visit, if user clicks next button in Details page then Capacity page is not shown')

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'),
		'After duplicating a Daily Visit, if user clicks next button in "Capacity" page then "Assign Users" page is not shown')

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'),
		'After duplicating a Daily Visit, if user clicks next button in "Assign Users" page then "Summary" page is not shown')

String Times = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/TimeInTimesDivision'))

if (!(WebUI.verifyMatch(Times, '09:00 AM - 10:00 AM', false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After editing the Times of Duplicated visit, the Times changes in Details page are not reflected in summary page')
}

String LocationInSummaryPage = WebUI.getText(findTestObject('Object Repository/DailyVisitsPage/Details Page/LocationInLocationDivision'))

if (!(WebUI.verifyMatch(LocationInSummaryPage, UpdatedLocation, false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After editing the Location of Duplicated visit, the Location changes in Details page are not reflected in summary page')
}

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.delay(4)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitTypeName)

//int NumberOfVisits = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'), 0).size()
int NumberOfVisits = driver.findElements(By.xpath('//h4[@class=\'visit-type-title\']')).size()

if (!(WebUI.verifyMatch(NumberOfVisits.toString(), '6', false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop(('After pubishing a duplicated visit by changing the times there should be 6 visits (3 previous visits & 3 new visits) But there are only ' +
			NumberOfVisits) + ' are present')
}

String TimeOnVisitCard

def timefield = new TestObject('TimeAndDateOnVisitCard')

for (int i = 2; i <= 6; i++) {
	timefield.addProperty('xpath', ConditionType.EQUALS, ((('(//h4[text()=\'' + VisitTypeName) + '\']/../..//span)[') +
			i) + ']')

	TimeOnVisitCard = WebUI.getText(timefield)

	TimeOnVisitCard = TimeOnVisitCard.split(',')[1].trim()

	if (WebUI.verifyMatch(TimeOnVisitCard, '8:00 AM - 9:00 AM', false, FailureHandling.OPTIONAL)) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop('In the duplicated visit if user edits the Times and publishes, then the visit is published with the previous times')
	}

	if (!(WebUI.verifyMatch(TimeOnVisitCard, '9:00 AM - 10:00 AM', false, FailureHandling.OPTIONAL))) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop('In the duplicated visit if user publish the visit by editing the times, then the visit is published with Incorrect times')
	}

	i = (i + 1)
}

