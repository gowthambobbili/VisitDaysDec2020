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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitType)

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 10, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

def object = new TestObject('VisitTypeInVisitTypeFilter')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/ActiveOptionInStatusFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

int NumberOfVisitsInIndexPage = driver.findElements(By.xpath('//div[@class=\'shadow __visit__visit-card__7422f pointer-on-hover ember-view\']')).size()

for (int i = 1; i <= NumberOfVisitsInIndexPage; i++) {
    String VisitTypeNameOnVisitCard = driver.findElement(By.xpath(('(//div[@class=\'shadow __visit__visit-card__7422f pointer-on-hover ember-view\']//h4)[' + 
            i) + ']')).getText()

    WebUI.verifyMatch(VisitTypeNameOnVisitCard, VisitType, false)
}

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AllDatesAndTimesRadioButtonInCancelVisitModal'), 0)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AllDatesAndTimesRadioButtonInCancelVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AllDatesAndTimesRadioButtonInCancelVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Yes,IUnderstoodCheckBoxInCancelDailyVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'))

WebUI.click(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'))

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

def object2 = new TestObject('VisitTypeInVisitTypeFilter')

object2.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object2)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/CanceledOptionInStatusFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

int NumberOfCanceledVisitsInIndexPage = driver.findElements(By.xpath('//div[@class="shadow __7422f pointer-on-hover ember-view"]')).size()

def object1 = new TestObject('CanceldVisitInIndexPage')

for (int j = 1; j <= NumberOfCanceledVisitsInIndexPage; j++) {
    object1.addProperty('xpath', ConditionType.EQUALS, ('(//div[@class=\'shadow __7422f pointer-on-hover ember-view\']//p[text()=\'Canceled\'])[' + 
        j) + ']')

    WebUI.verifyElementPresent(object1, 0)
}

