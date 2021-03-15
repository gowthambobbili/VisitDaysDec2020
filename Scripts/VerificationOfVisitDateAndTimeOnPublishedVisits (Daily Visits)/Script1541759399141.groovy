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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), 0)) {
		WebUI.click(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage'))
	}
}

if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), 0)) {
		WebUI.click(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage'))
	}
}

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

String DateInSummaryPage = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/DateInSummaryPage'))

DateInSummaryPage = DateInSummaryPage.split('\n')[0]

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.delay(4)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

def visitname = new TestObject('VisitInVIsitIndex')

visitname.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

int NumberOfVisits = driver.findElements(By.xpath(('//h4[text()=\'' + VisitType) + '\']')).size()

if (!(WebUI.verifyMatch(NumberOfVisits.toString(), '3', false))) {
	KeywordUtil.markFailed(('Only ' + NumberOfVisits.toString()) + 'are published but expected number of visits: 3')

	WebUI.takeScreenshot()
}

def Time = new TestObject('VisitDateAndTimeOnVisitCard')

Time.addProperty('xpath', ConditionType.EQUALS, ('(//div[@class=\'col-xs-12 col-md-5 desktop-align-right mobile-align-left\']//span)[1]'))


String DateAndTime = DateAndTime = WebUI.getText(Time)

println(DateAndTime)

//char[] yearArray=DateInSummaryPage.toCharArray()
def lengthofDateInSUmmaryPage=DateInSummaryPage.length()

println(lengthofDateInSUmmaryPage)

def year=DateInSummaryPage.substring(lengthofDateInSUmmaryPage -5,lengthofDateInSUmmaryPage)

println(year)


if (!(WebUI.verifyMatch((DateInSummaryPage.split('-'))[0].trim()+','+  year+', 8:00 AM - 9:00 AM', DateAndTime, false))) {
	KeywordUtil.markFailed(('The time on visit card is shown wrong in visit index page'))

	WebUI.takeScreenshot()
}

