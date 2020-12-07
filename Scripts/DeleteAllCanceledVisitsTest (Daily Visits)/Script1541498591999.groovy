import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CancelDailyVisitButton'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AllDatesAndTimesRadioButtonInCancelVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AllDatesAndTimesRadioButtonInCancelVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Yes,IUnderstoodCheckBoxInCancelDailyVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/CancelNowButtonInCancelVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/DontCancelButtonInCancelVisitButtonModal'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(2)

driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/CanceledOptionInStatusFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/ThreeDotMenuForCancelledVisits'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DeleteAllCanceledButtonInIndexPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/DeleteAllCanceledButtonInIndexPage'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Yes,IUnderstandCheckBoxInDeleteVisitsModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Yes,IUnderstandCheckBoxInDeleteVisitsModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/DeleteButtonInDeleteVisitsModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Yes,IUnderstandCheckBoxInDeleteVisitsModal'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(2)

driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/CanceledOptionInStatusFilter'))

def visit = new TestObject("VisitsInVisitIndexPage")

visit.addProperty("xpath", ConditionType.EQUALS, "//h4[text()='"+VisitType+"']")

WebUI.delay(3)

if(!(WebUI.verifyElementNotPresent(visit, 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("After deleting all Canceled visits from index the canceled visits are still shown in index page")
	WebUI.takeScreenshot()
}


if(!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EmptyStateMessageInVisitIndexPage'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("The empty state messags is not shown in the visit index page")

	WebUI.takeScreenshot()
}





