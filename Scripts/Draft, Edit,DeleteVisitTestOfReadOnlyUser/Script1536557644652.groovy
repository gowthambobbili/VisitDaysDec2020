import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.locks.Condition

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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(1, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(1, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

//WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)
//
//WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))
//
//WebDriver driver = DriverFactory.getWebDriver()
//
//CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(VisitTypeName)
//==================
WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebDriver driver = DriverFactory.getWebDriver()

driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

WebUI.scrollToElement(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'), 0)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

//WebUI.delay(4)
WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

//driver.findElement(By.xpath("//span[text()='test user1']/..//i")).click()
//WebUI.scrollToElement(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)
WebUI.clearText(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'mahesh test')

WebUI.click(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/SaveAsDraftButtonInSummaryPage'))

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/YesSaveAndExitButtonInSaveOfDraftModal'), 0)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/YesSaveAndExitButtonInSaveOfDraftModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/YesSaveAndExitButtonInSaveOfDraftModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

//================
CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(2, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(2, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

WebUI.refresh()

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/DraftOptionInStatusFilter'))

WebUI.delay(4)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

def visit = new TestObject("CreatedVisitInVisitIndex")

visit.addProperty("xpath", ConditionType.EQUALS, "//h4[text()='"+VisitTypeName+"']")

WebUI.click(visit)

if(!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EditDraftButtonInDraftVisitModal'), 0)))
{
	KeywordUtil.markFailedAndStop("'Edit Draft' button is shown for read only user (Edit Draft button is expected to not to show for Readonly user)")
	WebUI.takeScreenshot()
}

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/DeleteDraftButtonInDratVisitModal'), 0)

