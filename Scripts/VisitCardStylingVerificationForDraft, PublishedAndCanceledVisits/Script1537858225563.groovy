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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String DailyVIsitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

driver.findElement(By.xpath(('//li[text()=\'' + DailyVIsitVisitType) + '\']')).click()

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

driver.findElement(By.xpath(('//li[text()=\'' + DailyVIsitVisitType) + '\']')).click()

WebUI.delay(4)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

WebUI.delay(4)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/DraftOptionInStatusFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

//div[@class="shadow __7422f pointer-on-hover ember-view"]//div[@class="row no-override bg-yellow"]//p[text()='Saved as Draft']
int NumberOFDraftedVisits = driver.findElements(By.xpath('//div[@class=\'shadow __7422f pointer-on-hover ember-view\']//div[@class=\'row no-override bg-yellow\']//p[text()=\'Saved as Draft\']')).size()

println(NumberOFDraftedVisits)

//WebUI.delay(20)
for (int i = 1; i <= NumberOFDraftedVisits; i++) {
    String SavedAsDraftTextOnDraftedVisit = driver.findElement(By.xpath(('(//div[@class=\'shadow __7422f pointer-on-hover ember-view\']//div[@class=\'row no-override bg-yellow\']//p[text()=\'Saved as Draft\'])[' + 
            i) + ']')).getText()

    WebUI.verifyMatch('Saved as Draft', SavedAsDraftTextOnDraftedVisit, false)
}

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EditDraftButtonInDraftVisitModal'), 0)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/EditDraftButtonInDraftVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/EditDraftButtonInDraftVisitModal'), FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EditDraftButtonInDraftVisitModal'), 0)
WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

//CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()
WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.delay(10)

//WebUI.refresh()
WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

driver.findElement(By.xpath(('//li[text()=\'' + DailyVIsitVisitType) + '\']')).click()

WebUI.delay(4)

//WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))
//
//WebUI.delay(4)
WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

WebUI.delay(4)

//WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))
//WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))
WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/PublishedVisitBlueCard'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Yes,IUnderstoodCheckBoxInCancelDailyVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Yes,IUnderstoodCheckBoxInCancelDailyVisitModal'))

WebUI.click(findTestObject('DailyVisitsPage/ThisInstanceOnlyRadioButtonInCancelVisitModal'))

WebUI.click(findTestObject('DailyVisitsPage/ThisInstanceOnlyRadioButtonInCancelVisitModal'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'))

not_run: WebUI.waitForElementNotPresent(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 
    'After canceling the visit the Cancel visit modal is not getting closed')

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/CanceledOptionInStatusFilter'))

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

driver.findElement(By.xpath(('//li[text()=\'' + DailyVIsitVisitType) + '\']')).click()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RedCardOnCanceledVisit'), 0)

