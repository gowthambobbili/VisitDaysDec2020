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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.server.DefaultDriverFactory as DefaultDriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebDriver driver = DriverFactory.getWebDriver()

driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'), 0)
WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'), 0)
WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'), 0)
WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddBlackoutDatesButtonInSummaryPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddBlackoutDatesButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/SelectADateFieldInBlackoutDatesDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/EnabledDateInBlackoutCalendar'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

BlackoutDateBeforeEdit = WebUI.getText(findTestObject('DailyVisitsPage/BlackoutDateInDateRangeDivision'))

WebUI.click(findTestObject('DailyVisitsPage/EditButtonInDateRangeDivision'))

WebUI.click(findTestObject('DailyVisitsPage/Remove(X)ButtonBesideBlackoutDate'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/CancelButtonInDateRangeDivision'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CancelButtonInDateRangeDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/SaveBUttonInSummaryPage'), 0)

BlackoutDateAfterEditAndClickCancel = WebUI.getText(findTestObject('DailyVisitsPage/BlackoutDateInDateRangeDivision'))

//WebUI.click(findTestObject('DailyVisitsPage/EditLinkInTimesDivisionInSUmaryPage'))

if (!(WebUI.verifyMatch(BlackoutDateAfterEditAndClickCancel, BlackoutDateBeforeEdit, false, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After modifying the data, if user clicks Cancel button then the modified data is getting saved in Blackout dates division')

	WebUI.takeScreenshot()
}

WebUI.scrollToElement(findTestObject('DailyVisitsPage/EditLinkInTimesDivisionInSUmaryPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/EditLinkInTimesDivisionInSUmaryPage'))

WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), '10:00 AM')

WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '11:00 AM')

WebUI.scrollToElement(findTestObject('DailyVisitsPage/CancleButtonInSummaryPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CancleButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/SaveBUttonInSummaryPage'), 0)

String TimeAfterClickingCancel = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/TimeInTimesDivision'))

println(TimeAfterClickingCancel)

if(WebUI.verifyMatch(TimeAfterClickingCancel, '10:00 AM - 11:00 AM', false, FailureHandling.OPTIONAL))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('After Editing Times and clicking Cancel button the times are getting saved')
}

