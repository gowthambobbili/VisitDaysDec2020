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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By


WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'),
		'Details tab is  not shown i\n daily visit')

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/DuplicateDailyVIsitButton'),
		'Duplicate Daily Visit button is not present in the details page of daily visit')

WebUI.click(findTestObject('DailyVisitsPage/DuplicateDailyVIsitButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'),
		'On clicking Duplicate Daily visit button "Duplicate Daily Visit" modal is not shown ')

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('DailyVisitsPage/Details Page/DupicateButtonInDuplicateDailyVisitModal'),
		'After clicking Duplicate button in \'Duplicate Daily Visit\' modal the modal is not getting closed')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/CreateDailyVisitHeader'),
		'After duplicating a daily visit, Create daily visit page is not opened')

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), 0)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), '9:00 AM')

WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '10:00 AM')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'),
		'After duplicating a visit the "Next" button is not shown in the create daily visit page')

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'),
		'After duplicating a visit if user clicks "Next" button in "Details" page then the page is not navigated to Capacity page')

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

not_run: CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject(
'DailyVisitsPage/AssignNowInDailyVisit'), 'While editing duplicated visit if user clicks Next button in Capacity page then the is not navigating to the Summary page')

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

String TimeInSummaryPageAfterEditing = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/TimeInTimesDivision'))

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Details Page/TimeInTimesDivision'), '09:00 AM - 10:00 AM',
FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After duplicating a visit, if user edits the times in the details page then the time is not reflcted in Summary page')
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'),
		'After duplicating a visit, Publish button is not present in the summary page of the visit')

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'),
		'After clicking Publish button, Publish visit modal is not shown')

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'),
		'After clicking publish button in publish visit modal the modal is not getting closed')

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

def VisitTimesInIndexPage = new TestObject('Time on visits in index page')

WebUI.delay(3)

int NumberOfVisits = driver.findElements(By.xpath("//h4[@class='visit-type-title']")).size()

//WebUI.verifyMatch(NumberOfVisits.toString(), '8', false)

int countofNewVisitSeries = 0

int countofOldVisitSeries = 0

String TimeOnVisitCard

for(int i=1;i<=NumberOfVisits;i++)
{
	VisitTimesInIndexPage.addProperty('xpath', ConditionType.EQUALS, ('(//h4[text()="' + VisitType) + '"]/../..//span)['+i+']')

	TimeOnVisitCard = WebUI.getText(VisitTimesInIndexPage)

	TimeOnVisitCard = TimeOnVisitCard.split(', ')[1]

	if(TimeOnVisitCard=='9:00 AM - 10:00 AM')
	{
		countofNewVisitSeries = countofNewVisitSeries+1
	}
	else if(TimeOnVisitCard=='8:00 AM - 9:00 AM')
	{
		countofOldVisitSeries = countofOldVisitSeries+1
	}
}
//if(countofNewVisitSeries!=4)
//{
//	KeywordUtil.markFailed("After duplicating a visit series with 4 visits and publishing visit series just changing the time then "+countofNewVisitSeries.toString()+" visits are published with the updated time (expected 4 visits)")
//}
//
//if(countofOldVisitSeries!=4)
//{
//	KeywordUtil.markFailed("After duplicating a visit series with 4 visits and publishing visit series just changing the time then "+countofOldVisitSeries.toString()+" old visits are shown (expected to show 4 visits)")
//}



