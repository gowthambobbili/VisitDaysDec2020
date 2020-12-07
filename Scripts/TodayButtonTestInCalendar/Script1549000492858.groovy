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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String TodaysDate = CustomKeywords.'com.CommonUtilities.Times.GetTimeForTodayDateInDayViewOfCalendar'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/CalendarLeftNav'),
		'Calendar left nav is not present in home page')

WebUI.click(findTestObject('HomePageElements/CalendarLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/CalendarObject'),
		'"After clicking Calendar left nav the calendar is not getting opened"')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/DayTab'),
		'"Day tab is not present in Calendar"')

WebUI.click(findTestObject('Calendar/DayTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/DayViewObject'),
		'After clicking Day tab in calendar the day view is not opened')

WebUI.delay(2)

if (!(WebUI.verifyElementText(findTestObject('Calendar/HeaderTextInDayView'), TodaysDate, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop((('In the day view of the Calendar the header not shown today\'s date(Expected date: ' +
			TodaysDate) + ' but the Actual date: )') + WebUI.getText(findTestObject('Calendar/HeaderTextInDayView')))
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/ForwardArrowInCalendarHeader'),
		'In the day view of the calendar forward arrow is not shown to switch the days')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/BackArrowInCalendar'),
		'In the day view of the calendar back arrow is not shown to switch the days')

WebUI.click(findTestObject('Calendar/ForwardArrowInCalendarHeader'))

if (!(WebUI.verifyNotMatch(WebUI.getText(findTestObject('Calendar/HeaderTextInDayView')), TodaysDate, false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After clicking the Forward arrow button calendar day view the date is not getting changed in the header')
}

WebUI.click(findTestObject('Calendar/TodayButton'))

WebUI.delay(2)

if (!(WebUI.verifyElementText(findTestObject('Calendar/HeaderTextInDayView'), TodaysDate, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('Today button is not working in the day view of the Calendar ')
}

String TodayDayAndMOnth = ((TodaysDate.split(',')[0].split('. ')[0]) + ' ') + (TodaysDate.split(',')[0].split('. ')[1])

if (!(WebUI.verifyElementText(findTestObject('Calendar/DayWithMonth'), TodayDayAndMOnth, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop((('After clicking the Today button in the day view the calendar not shown the today\'s date (Expected: ' +
			TodayDayAndMOnth) + ', Actual: ') + WebUI.getText(findTestObject('Calendar/DayWithMonth')))
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/WeekTab'),
		'Week tab is not present in the calendar')

WebUI.click(findTestObject('Calendar/WeekTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/WeekViewObject'),
		'After clicking Week tab week view is not shown in the calendar')

String CalendarHeaderInWeekView = WebUI.getText(findTestObject('Calendar/CalenderHeaderText'))

WebDriver driver = DriverFactory.getWebDriver()

def DayAndMonthInWeekView = new TestObject('Day and month in week view of calendar')

String DayInCalendarWeekView

String DayFlag = false

for (int i = 1; i <= 7; i++) {
	DayAndMonthInWeekView.addProperty('xpath', ConditionType.EQUALS, ('(//div[@class=\'cal-week-day-date\'])[' + i) + ']')

	DayInCalendarWeekView = WebUI.getText(findTestObject('Calendar/DayWithMonth'))

	if (DayInCalendarWeekView == TodayDayAndMOnth) {
		DayFlag = true

		break
	}
}

if (DayFlag == false) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('On clicking week tab of calendar, current week is not shown')
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/ForwardArrowInCalendarHeader'),
		'In the Week view of the calendar forward arrow is not shown to switch the days')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/BackArrowInCalendar'),
		'In the Week view of the calendar back arrow is not shown to switch the days')

WebUI.click(findTestObject('Calendar/ForwardArrowInCalendarHeader'))

if (WebUI.verifyElementText(findTestObject('Calendar/HeaderTextInDayView'), DayInCalendarWeekView, FailureHandling.OPTIONAL)) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After clicking forward arrow in Week view of the calednar next week calendar is not shown')
}

WebUI.click(findTestObject('Calendar/TodayButton'))

if (!(WebUI.verifyElementText(findTestObject('Calendar/HeaderTextInDayView'), CalendarHeaderInWeekView, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After clicking Today button in week view the current week is not shown in the header')
}

String DayFlagAfterClickinfTodayButton = false

for (int j = 1; j <= 7; j++) {
	DayAndMonthInWeekView.addProperty('xpath', ConditionType.EQUALS, ('(//div[@class=\'cal-week-day-date\'])[' + j) + ']')

	DayInCalendarWeekView = WebUI.getText(findTestObject('Calendar/DayWithMonth'))

	if (DayInCalendarWeekView == TodayDayAndMOnth) {
		DayFlagAfterClickinfTodayButton = true

		break
	}
}

if (DayFlagAfterClickinfTodayButton == false) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('If user clicks today button in Week view, the current week calendar is not shown')
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/MonthTab'),
		'Month tab is not present in Calendar')

WebUI.click(findTestObject('Calendar/MonthTab'))

WebUI.delay(2)

String MonthHeader = CustomKeywords.'com.CommonUtilities.Times.GetTimeTodayHeaderInMonthViewOfCalendar'()

if (!(WebUI.verifyElementText(findTestObject('Calendar/CalenderHeaderText'), MonthHeader, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop((('If user clicks on Month tab in the calendar then the header not shown the current month(Expected: ' +
			MonthHeader) + 'Actual: ') + WebUI.getText(findTestObject('Calendar/CalenderHeaderText')))
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/ForwardArrowInCalendarHeader'),
		'In the Month view of the calendar forward arrow is not shown to switch the days')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Calendar/BackArrowInCalendar'),
		'In the Month view of the calendar back arrow is not shown to switch the days')

WebUI.click(findTestObject('Calendar/ForwardArrowInCalendarHeader'))

if (WebUI.verifyElementText(findTestObject('Calendar/CalenderHeaderText'), MonthHeader, FailureHandling.OPTIONAL)) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('If user clicks the forward arrow in the calendar then next month calendar is not shown')
}

WebUI.click(findTestObject('Calendar/TodayButton'))

WebUI.delay(2)

if (!(WebUI.verifyElementText(findTestObject('Calendar/CalenderHeaderText'), MonthHeader, FailureHandling.OPTIONAL)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("When user clicks Today button in Month view of the calendar the header shows incorrect month")
}

if(!(WebUI.verifyTextPresent(MonthHeader.split('. ')[0]+' 1', false)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("If user clicks today button in the month view of the calender then current month calendar is not shown(Header shown correctly)")
}



