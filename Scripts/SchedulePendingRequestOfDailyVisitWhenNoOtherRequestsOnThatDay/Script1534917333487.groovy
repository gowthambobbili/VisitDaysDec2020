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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
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

String DailyVisitsVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(DailyVisitsVisitType)

String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName'(
    DailyVisitsVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

//WebUI.refresh()
CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']/../../../..//button')).click()

CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

WebUI.verifyElementNotPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0, FailureHandling.OPTIONAL)

WebUI.delay(2)

not_run: WebUI.refresh()

WebUI.scrollToElement(findTestObject('Requests/AllReqestsInRequests'), 0)

WebUI.waitForElementClickable(findTestObject('Requests/ScheduledRadioButton'), 0)

WebUI.waitForElementClickable(findTestObject('Requests/ScheduledRadioButton'), 0)

WebUI.click(findTestObject('Requests/ScheduledRadioButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueue'), 0)

WebUI.delay(2)

def Object = new TestObject('RequestedStudent(Link to the student profile)')

Object.addProperty('xpath', ConditionType.EQUALS, ('//span[text()=\'' + StudentName) + '\']')

WebUI.verifyElementPresent(Object, 0)

//driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']')).isDisplayed()
CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

String GroupName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForGroupRequestWithUserName'(
    DailyVisitsVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

driver.findElement(By.xpath(('//span[text()=\'' + GroupName) + '\']/../../../..//button')).click()

CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

WebUI.verifyElementNotPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0, FailureHandling.OPTIONAL)

WebUI.delay(2)

not_run: WebUI.refresh()

WebUI.scrollToElement(findTestObject('Requests/AllReqestsInRequests'), 0)

WebUI.waitForElementClickable(findTestObject('Requests/ScheduledRadioButton'), 0)

not_run: WebUI.waitForElementClickable(findTestObject('Requests/ScheduledRadioButton'), 0)

not_run: WebUI.waitForElementClickable(findTestObject('Requests/ScheduledRadioButton'), 0)

WebUI.click(findTestObject('Requests/ScheduledRadioButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueue'), 0)

WebUI.delay(2)

def Object1 = new TestObject('RequestedGroup')

Object1.addProperty('xpath', ConditionType.EQUALS, ('//span[text()=\'' + GroupName) + '\']')

WebUI.verifyElementPresent(Object1, 0)

