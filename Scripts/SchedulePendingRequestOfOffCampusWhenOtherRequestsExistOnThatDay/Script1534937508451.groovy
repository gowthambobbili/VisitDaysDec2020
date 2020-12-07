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

Random RandVar = new Random()

String Email = ((('test' + RandVar.nextInt(100)) + 'user') + RandVar.nextInt(9000)) + '@gmail.com'

String OffCampusVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestOffCampusVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusWithRequestVisitType'(OffCampusVisitType)

not_run: String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistration'(
    OffCampusVisitType, findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), Single, Email)

//WebUI.refresh()
//CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()
not_run: WebUI.delay(4)

not_run: WebUI.refresh()

not_run: CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

not_run: driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']/../../../..//button')).click()

not_run: CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

not_run: WebUI.verifyElementNotPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0, FailureHandling.OPTIONAL)

not_run: WebUI.delay(2)

not_run: WebUI.click(findTestObject('Requests/ScheduledRadioButton'))

not_run: WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueue'), 0)

not_run: WebUI.delay(2)

not_run: driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']')).isDisplayed()

not_run: CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

not_run: CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

not_run: WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

not_run: String SecondStudentNameWithSameEmail = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistration'(
    OffCampusVisitType, findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), Single, Email)

//CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()
not_run: WebUI.delay(4)

not_run: WebUI.refresh()

not_run: CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

not_run: driver.findElement(By.xpath(('//span[text()=\'' + SecondStudentNameWithSameEmail) + '\']/../../../..//button')).click()

not_run: if (WebUI.verifyElementPresent(findTestObject('ScheduleModalObjects/ScheduleNewVisitButton'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ScheduleModalObjects/ScheduleNewVisitButton'))
}

not_run: WebUI.waitForElementPresent(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), 0)

not_run: WebUI.click(findTestObject('ScheduleModalObjects/ContinueButtonInScheduleRequestModal'))

not_run: WebUI.verifyElementPresent(findTestObject('ScheduleModalObjects/ErrorMessageForOverlappingTimes'), 0)

not_run: WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

not_run: WebUI.clearText(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

not_run: WebUI.sendKeys(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), '10:00 AM')

not_run: WebUI.click(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

not_run: WebUI.clearText(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

not_run: WebUI.sendKeys(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'), '11:00 AM')

not_run: WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

not_run: WebUI.click(findTestObject('ScheduleModalObjects/ContinueButtonInScheduleRequestModal'))

not_run: WebUI.click(findTestObject('ScheduleModalObjects/ScheduleRequestButtonInScheduleRequestModal'))

not_run: WebUI.verifyElementNotPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0, FailureHandling.OPTIONAL)

not_run: WebUI.delay(2)

not_run: WebUI.click(findTestObject('Requests/ScheduledRadioButton'))

not_run: WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueue'), 0)

not_run: WebUI.delay(2)

not_run: driver.findElement(By.xpath(('//span[text()=\'' + SecondStudentNameWithSameEmail) + '\']')).isDisplayed()

not_run: CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

not_run: CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

not_run: WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

String OrganisationName = 'Organisation' + RandVar.nextInt(100000)

String InstantVisitType = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavigateToConfirmationPageWithARqquestAndInstantVisit'(
    findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), OffCampusVisitType, OrganisationName)

WebUI.delay(4)

WebUI.refresh()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

driver.findElement(By.xpath(('//span[text()=\'' + OrganisationName) + '\']/../../../..//button')).click()

if (WebUI.verifyElementPresent(findTestObject('ScheduleModalObjects/ScheduleNewVisitButton'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('ScheduleModalObjects/ScheduleNewVisitButton'))
}

WebUI.waitForElementPresent(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), 0)

WebUI.click(findTestObject('ScheduleModalObjects/ContinueButtonInScheduleRequestModal'))

WebUI.verifyElementPresent(findTestObject('ScheduleModalObjects/ErrorMessageForOverlappingTimes'), 0)

WebUI.click(findTestObject('ScheduleModalObjects/ErrorMessageForOverlappingTimes'))

WebUI.delay(2)

WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.clearText(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))

WebUI.sendKeys(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'), '2:00 PM')

WebUI.click(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

WebUI.clearText(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'))

WebUI.sendKeys(findTestObject('ScheduleModalObjects/EndDateInScheduleRequestModal'), '3:00 PM')

//WebUI.click(findTestObject('ScheduleModalObjects/StartTimeFieldInScheduleRequestModal'))
WebUI.click(findTestObject('ScheduleModalObjects/ContinueButtonInScheduleRequestModal'))

WebUI.click(findTestObject('ScheduleModalObjects/ScheduleRequestButtonInScheduleRequestModal'))

WebUI.verifyElementNotPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0, FailureHandling.OPTIONAL)

WebUI.delay(2)

WebUI.click(findTestObject('Requests/ScheduledRadioButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueue'), 0)

WebUI.delay(2)

driver.findElement(By.xpath(('//span[text()=\'' + OrganisationName) + '\']')).isDisplayed()

