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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebDriver driver = DriverFactory.getWebDriver()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), FailureHandling.OPTIONAL)) {
    if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage'))
    }
}

if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), FailureHandling.OPTIONAL)) {
    if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), 3, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage'))
    }
}

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/SaveAsDraftButtonInSummaryPage'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/YesSaveAndExitButtonInSaveOfDraftModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/YesSaveAndExitButtonInSaveOfDraftModal'), FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(2)

driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'), 0)

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/DraftOptionInStatusFilter'))

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/DraftOptionInStatusFilter'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

int NumberOfVisits = driver.findElements(By.xpath('//h4[@class="visit-type-title"]')).size()

String NumberOfVisitsInIndexPage = NumberOfVisits.toString()

if (!(WebUI.verifyMatch('3', NumberOfVisitsInIndexPage, false, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailedAndStop(('After saving the visit as draft, all drafted visits are not shown in the index page : Expected 3 visits but shown only ' + 
        NumberOfVisits) + ' Visits')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/ThreeDotMenuForCancelledVisits'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DeleteAllDraftsButtonInIndexPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/DeleteAllDraftsButtonInIndexPage'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Yes,IUnderstandCheckboxInDeleteDailyVisitsModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Yes,IUnderstandCheckboxInDeleteDailyVisitsModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/DeleteButtonInDeleteDailyVisitsModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('DailyVisitsPage/DeleteButtonInDeleteDailyVisitsModal'), 0)

WebUI.click(findTestObject('FlashMessage'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.click(object)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/DraftOptionInStatusFilter'))

def visit = new TestObject('VisitInIndexPage')

visit.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

if (!(WebUI.verifyElementNotPresent(visit, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailedAndStop('After deleting the drafted visit from index page using \'Delete all Draft\' button the drafted visits are not deleted')

    WebUI.takeScreenshot()
}

