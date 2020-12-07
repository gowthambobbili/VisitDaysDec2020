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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
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

String Single = 'single'

String DailyVisitsVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(DailyVisitsVisitType)

//String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName'(
//		DailyVisitsVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

def CurrentUrl = WebUI.getUrl()

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

def StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'([DailyVisitsVisitType], CurrentUrl)

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']/../../../..//button')).click()

CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

WebUI.verifyElementNotPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0, FailureHandling.OPTIONAL)

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(2, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(2, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

//WebUI.sendKeys(findTestObject('Add Attendee/AddAttendeeSearchBox'), StudentName)
//
//WebUI.verifyElementPresent(findTestObject('Add Attendee/SearchResultsForAddAttendee'), 0)
//
//WebUI.click(findTestObject('Add Attendee/SearchResultsForAddAttendee'), FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

WebUI.click(findTestObject('Requests/ScheduledRadioButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueue'), 0)

//driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']')).click()

def object = new TestObject("RequestedStudentInRequestQueue")

object.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+StudentName+"']")

WebUI.click(object)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.verifyElementText(findTestObject('UserProfile/ApplicationStatusInUserProfile'), 'Applied')

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.verifyElementPresent(findTestObject('Add Attendee/CheckInButtonInUserProfile'), 0)

WebUI.verifyElementPresent(findTestObject('Add Attendee/CheckInButtonInUserProfile'), 0)

WebUI.click(findTestObject('Add Attendee/CheckInButtonInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Add Attendee/CheckInButtonInUserProfile'), 0)

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

WebUI.click(findTestObject('UserProfile/DetailsTabInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UserProfile/EditButtonInDetailsTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('UserProfile/FirstNameTextBoxInDetailsTab'), '1')

WebUI.sendKeys(findTestObject('UserProfile/LastNameTextBoxInDetailsPage'), '2')

WebUI.clearText(findTestObject('UserProfile/CellPhoneNumberTextFieldInDetailsTab'))

WebUI.sendKeys(findTestObject('UserProfile/CellPhoneNumberTextFieldInDetailsTab'), '5555555555')

WebUI.click(findTestObject('UserProfile/SaveButtonInDetailsTab'))

WebUI.verifyElementNotPresent(findTestObject('UserProfile/SaveButtonInDetailsTab'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/EditButtonInDetailsTab'), 0)

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('UserProfile/EditButtonInDetailsTab'), 0)

