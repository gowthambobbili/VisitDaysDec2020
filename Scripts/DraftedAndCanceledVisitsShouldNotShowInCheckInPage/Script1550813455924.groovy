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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

WebDriver driver = DriverFactory.getWebDriver()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def VisitTypeInVisitTypeDropdown = new TestObject('Visit type in visit type dropdown')

VisitTypeInVisitTypeDropdown.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(VisitTypeInVisitTypeDropdown)

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'), 0)
WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'), 0)
WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'), 0)
WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'), 0)
WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/SaveAsDraftButtonInSummaryPage'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/YesSaveAndExitButtonInSaveOfDraftModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/YesSaveAndExitButtonInSaveOfDraftModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/YesSaveAndExitButtonInSaveOfDraftModal'), 0)

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 20, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

def VisitTypeInVisitTypeDorpdownInIndexPage = new TestObject('Visit type in visit type dropdown in index page')

VisitTypeInVisitTypeDorpdownInIndexPage.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(VisitTypeInVisitTypeDorpdownInIndexPage)

WebUI.delay(4)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

WebUI.delay(4)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/DraftOptionInStatusFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

int NumberOFDraftedVisits = driver.findElements(By.xpath('//div[@class=\'shadow __7422f pointer-on-hover ember-view\']//div[@class=\'row no-override bg-yellow\']//p[text()=\'Saved as Draft\']')).size()

println(NumberOFDraftedVisits)

//WebUI.delay(20)
for (int i = 1; i <= NumberOFDraftedVisits; i++) {
	String SavedAsDraftTextOnDraftedVisit = driver.findElement(By.xpath(('(//div[@class=\'shadow __7422f pointer-on-hover ember-view\']//div[@class=\'row no-override bg-yellow\']//p[text()=\'Saved as Draft\'])[' +
			i) + ']')).getText()

	WebUI.verifyMatch('Saved as Draft', SavedAsDraftTextOnDraftedVisit, false)
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/CheckInLeftNav'),
		'Check In lefe nav is not present in the home page')

WebUI.click(findTestObject('HomePageElements/CheckInLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('DailyVisitsPage/CreateDailyVisitButton'),
		'After clicking Check in button the page is still in the Daily visits page')

def VisitTypeInCheckInPage = new TestObject('Drafted visit in checkin page')

VisitTypeInCheckInPage.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(VisitTypeInCheckInPage,
		'Drafted visit type is shown in Check In page')

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 20, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

//def VisitTypeInVisitTypeDorpdownInIndexPage = new TestObject('Visit type in visit type dropdown in index page')
//
//VisitTypeInVisitTypeDorpdownInIndexPage.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')
WebUI.click(VisitTypeInVisitTypeDorpdownInIndexPage)

WebUI.delay(4)

//WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))
//
//WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'), 0)
//
//WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))
//
//WebUI.delay(4)
WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/DraftOptionInStatusFilter'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'),
		'After filtering the drafted visits are not shown in the index page')

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/EditDraftButtonInDraftVisitModal'),
		'On clicking drafted visit the Edit draft modal is not shown')

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/EditDraftButtonInDraftVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/EditDraftButtonInDraftVisitModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AssignLaterButtonInDailyVisit'),FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))


WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('HomePageElements/CheckInLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(VisitTypeInCheckInPage,
		'The published visit with today start time is not shown in Check in page')

WebUI.click(VisitTypeInCheckInPage)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'),
		'When clicked on a visit in Check In page the details tab of the visit is not shown')

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/CancelDailyVisitButton'),
		'Cancel Daily Visit button is not present in the daily visit page')

WebUI.click(findTestObject('DailyVisitsPage/CancelDailyVisitButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/ThisInstanceOnlyRadioButtonInCancelVisitModal'),
		'When clicked Cancel Daily Visit button the Cancel Daily Visit modal is not present')

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/ThisInstanceOnlyRadioButtonInCancelVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/ThisInstanceOnlyRadioButtonInCancelVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Yes,IUnderstoodCheckBoxInCancelDailyVisitModal'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'),
		'Cancel Now button is not shown in the Cancel Daily Visit modal')
WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'),
		'After clicking Cancel Now button in Cancel Daily visit modal the modal is not getting closed')

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

//CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)
def object4 = new TestObject('CancelledLabelOnCancledVisitCard')

object4.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']/../../../..//p[text()=\'Canceled\']')

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(2)

def object3 = new TestObject('VisitTypeInVisitTypeFilter')

object3.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object3)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/CanceledOptionInStatusFilter'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailed('The visits are not getting canceled ')
}

if (!(WebUI.verifyElementPresent(object4, 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailed('After canceling the visit canceled label not shown on the visit (Visit not canceled )')
}

WebUI.click(findTestObject('HomePageElements/CheckInLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('CheckInPage/TodaysDateInCheckInPage'),
		'Check In page is not opened when clicked in Check In left  nav')

WebUI.delay(4)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(VisitTypeInCheckInPage,
		'Canceled visits are shown in Check In page')

