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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String Single = 'single'

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(DailyVisitVisitType)

String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName'(
		DailyVisitVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

//WebUI.refresh()
CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']')).click()

WebUI.waitForElementPresent(findTestObject('UserProfile/VisitsTabInUserProfile'), 0)

WebUI.delay(5)

def object = new TestObject("ScheduleButtonOfARequestInProfile")

object.addProperty("xpath", ConditionType.EQUALS, '//h3[text()=\'' + DailyVisitVisitType+ '\']/..//span[text()=\'Schedule\']')

WebUI.click(object)

//driver.findElement(By.xpath(('//h3[text()=\'' + DailyVisitVisitType) + '\']/..//span[text()=\'Schedule\']')).click()

CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

WebUI.delay(5)

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), 'bodavulaharichandana@gmail.com')

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), 'Kishore1234')

WebUI.click(findTestObject('LoginPage/SignInButton'))

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

//WebUI.click(findTestObject('Requests/ScheduledRadioButton'))
//
//WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueueOrEmptyStateInRequests'), 0)
//
//WebUI.delay(2)
//
//driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']')).isDisplayed()
//
//CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()
//
//WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)
//
//WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(1, 1))
//
//WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(1, 2))
//
//WebUI.click(findTestObject('LoginPage/SignInButton'))
//
//WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)
//
