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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String Single = 'single'

String Multiple = 'multiple'

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(DailyVisitVisitType)

String StudentNameForSingleRequest = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName'(
    DailyVisitVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

String VisitTypeOfRegisteredStudent = driver.findElement(By.xpath(('(//span[text()=\'' + StudentNameForSingleRequest) + 
        '\']/../../../..//a//p)[1]')).getText()

driver.findElement(By.xpath(('//span[text()=\'' + StudentNameForSingleRequest) + '\']')).click()

WebUI.waitForElementPresent(findTestObject('UserProfile/VisitsTabInUserProfile'), 0)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.delay(5)

driver.findElement(By.xpath(('//h3[text()="'+VisitTypeOfRegisteredStudent+'"]'))).isDisplayed()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

String StudentNameForMultipleRequest = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName'(
    DailyVisitVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Multiple)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

String VisitTypeOfRegisteredStudentForMultipleRequests = driver.findElement(By.xpath(('(//span[text()=\'' + StudentNameForMultipleRequest) + 
        '\']/../../../..//a//p)[1]')).getText()

driver.findElement(By.xpath(('//span[text()=\'' + StudentNameForMultipleRequest) + '\']')).isDisplayed()

driver.findElement(By.xpath(('//span[text()=\'' + StudentNameForMultipleRequest) + '\']')).click()

WebUI.waitForElementPresent(findTestObject('UserProfile/VisitsTabInUserProfile'), 0)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.delay(5)

driver.findElement(By.xpath(('//h3[text()="'+VisitTypeOfRegisteredStudentForMultipleRequests+'"]'))).isDisplayed()

Random RandVar = new Random()

String SecondName = 'Name' + RandVar.nextInt(10000)

String StudentNameForRequestAndInstantBook = 'Test ' + SecondName

String InstantVisitTypeName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavigateToConfirmationPageWithARqquestAndInstantVisit'(
    findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), DailyVisitVisitType, SecondName)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

WebUI.delay(10)

String VisitTypeOfRegisteredStudentForOneRequestAndOneInstant = driver.findElement(By.xpath(('(//span[text()=\'' + StudentNameForRequestAndInstantBook) + 
        '\']/../../../..//a//p)[1]')).getText()

driver.findElement(By.xpath(('//span[text()=\'' + StudentNameForRequestAndInstantBook) + '\']')).isDisplayed()

driver.findElement(By.xpath(('//span[text()=\'' + StudentNameForRequestAndInstantBook) + '\']')).click()

WebUI.waitForElementPresent(findTestObject('UserProfile/VisitsTabInUserProfile'), 0)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.delay(5)

driver.findElement(By.xpath(('//h3[text()=\'' + VisitTypeOfRegisteredStudentForOneRequestAndOneInstant) + '\']/..//button')).click()


