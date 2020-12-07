import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.print.attribute.standard.NumberOfInterveningJobs as NumberOfInterveningJobs
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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

WebUI.delay(10)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/IframeOfMobi'),
		'When navigated to the mobi link the Mobi is not getting opened')
WebUI.switchToFrame(findTestObject('Object Repository/Add Attendee/IframeOfMobi'), 0)
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/IndividualOptionInMobi'),
		'Individual option not present in the mobi')
WebUI.click(findTestObject('Object Repository/Add Attendee/IndividualOptionInMobi'))
WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/DailyVisitsOptionInAddAttendee'),
		'Daily visits tab is not present in Mobi')

WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))
WebUI.delay(2)
def StartTimes = []
def StartTime
int NumberOfInstantVisits
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/FirstVisitInMobi'), 0, FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/FirstVIsitHoursInMobi'), 0, FailureHandling.OPTIONAL)) {
		NumberOfInstantVisits = driver.findElements(By.xpath('//div[@class="mobi-hours __51af0 ember-view"]//button[@class=" mobi-daily-visit--hours-item"]')).size()
		for (int times = 1; times <= NumberOfInstantVisits; times++) {
			StartTime = driver.findElement(By.xpath('(//div[@class="mobi-hours __51af0 ember-view"])['+times+']//button')).getText()
			if (StartTime == 'Add to My Itinerary') {
				WebUI.takeScreenshot()
				KeywordUtil.markFailed('The visits in mobi are in incorrect order')
			}
			StartTime = (StartTime.split(' - ')[0])
			StartTime = CustomKeywords.'com.CommonUtilities.Times.ConvertTimeTo24HoursFormat'(StartTime)
			StartTime = StartTime.replace(':', '.')
			StartTimes.add(Float.parseFloat(StartTime))
		}
		def ActualStartTimes = StartTimes
		println(ActualStartTimes)
		println(StartTimes.sort())
		if (!(ActualStartTimes == StartTimes.sort())) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed('The instant visits in mobi are not in order')
		}
	} else {
		KeywordUtil.markWarning('There are no Instant visits present in mobi to verify the order')
	}
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/FirstRequestInMobi'), 0, FailureHandling.OPTIONAL)) {
		def NumberOfRequests = driver.findElements(By.xpath('//button[@class=\' mobi-daily-visit--hours-item\']')).size()
		def AddToItineraryButton
		for (int requests = NumberOfInstantVisits + 1; requests <= NumberOfRequests; requests++) {
			AddToItineraryButton = driver.findElement(By.xpath(('(//div[@class=\'mobi-daily-visit--hours\'])[' + requests) +
					']//button')).getText()
			if (AddToItineraryButton != 'Add to My Itinerary') {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('Daily visits are not in order in Mobi')
			}
		}
	} else {
		KeywordUtil.markWarning('There are no Request visits present in mobi to verify the order')
	}
} else {
	KeywordUtil.markWarning('There are no Daily Visits present in mobi to verify the order')
}

/*
 * Verification of order of Events in Mobi
 */
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/EventsOptionInAddAttendee'),
		'Events tab is not present in Mobi')

WebUI.click(findTestObject('Object Repository/Add Attendee/EventsOptionInAddAttendee'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/FirstEventCardInMobiEvents'), 10, FailureHandling.OPTIONAL)) {
	int NumberOfEvents = driver.findElements(By.xpath('//div[@class="mobi-visit-type __989c9 mobi-visit-type--oncampus ember-view"]')).size()

	def DateAndTime1 = ((driver.findElement(By.xpath('(//div[@class=\'mobi-visit-type--visitdate\'])[1]')).getText().split(
			', ')[1]) + ', ') + (driver.findElement(By.xpath('(//button[@class=\' mobi-daily-visit--hours-item\'])[1]')).getText().split(
			' - ')[0])

	def DateAndTime2

	if (NumberOfEvents > 1) {
		for (int events = 2; events <= NumberOfEvents; events++) {
			DateAndTime2 = driver.findElement(By.xpath(('(//div[@class=\'mobi-visit-type--visitdate\'])[' + events) + ']')).getText().split(
					', ')[1]+(', ' + (driver.findElement(By.xpath(('(//button[@class=\' mobi-daily-visit--hours-item\'])[' +
					events) + ']')).getText().split(' - ')[0]))

			if (CustomKeywords.'com.CommonUtilities.Times.CampareTwoDates'(DateAndTime1, DateAndTime2) > 0) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('The events in Mobi are in incorrect order')
			}

			DateAndTime1 = DateAndTime2
		}
	} else {
		KeywordUtil.markWarning('There are no Instant events present in Mobi')
	}
} else {
	KeywordUtil.markWarning('There are no Events present in mobi to verify the order')
}

