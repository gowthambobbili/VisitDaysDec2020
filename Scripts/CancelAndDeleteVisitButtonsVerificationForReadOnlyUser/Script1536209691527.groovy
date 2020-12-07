import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.server.DefaultDriverFactory as DefaultDriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(1, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(1, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(VisitTypeName)

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(2, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(2, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/CancelDailyVisitButton'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/DuplicateDailyVIsitButton'), 2, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(1, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(1, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

