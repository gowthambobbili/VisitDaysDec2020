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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

//driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInTimeDivision'))

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), '11:00 AM')

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'), '9:00 AM')

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/RequiredInputErrorMessage'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After entering an invalid Time in Times division of Events in the Summary page, i.e \'End Time\' earlier than \'Start Time\' \'Required Input\' error message is not shown')

	WebUI.takeScreenshot()
}

//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)
WebUI.scrollToElement(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)
if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/EditLinkInTimeDivision'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('User is allowed to save invalid times while creating Event (End time earlier than Start time)')
}

not_run: WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

not_run: WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

not_run: WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

not_run: WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

not_run: WebUI.delay(4)

not_run: WebUI.refresh()

not_run: WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

