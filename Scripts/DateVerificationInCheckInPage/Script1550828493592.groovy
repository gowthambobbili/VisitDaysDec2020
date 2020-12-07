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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/CheckInLeftNav'),
		'Check In left nav is not present in homepage')

WebUI.click(findTestObject('HomePageElements/CheckInLeftNav'))

ActualDateInCheckInPage = WebUI.getText(findTestObject('CheckInPage/TodaysDateInCheckInPage'))

println(ActualDateInCheckInPage)

String ExpectedDate = CustomKeywords.'com.CommonUtilities.Times.GetDateInRequiredFormat'('EEEE, MMMM dd')

println(ExpectedDate)

WebUI.verifyMatch(ActualDateInCheckInPage, ExpectedDate, false)

int NumberOfVisitsInCheckIn = driver.findElements(By.xpath('//h4[@class=\'visit-type-title\']')).size()

def DateAndTimeOfEachVisit = new TestObject('Date and time of visit')

String DateAndTimeOnVisit

String TodayMonthAndDate = CustomKeywords.'com.CommonUtilities.Times.GetDateInRequiredFormat'("MMMM dd")

for (int i = 1; i <= NumberOfVisitsInCheckIn; i++) {
	DateAndTimeOfEachVisit.addProperty('xpath', ConditionType.EQUALS, ('(//div[@class=\'col-xs-12 col-md-5 desktop-align-right mobile-align-left\']//span)[' +
			i) + ']')

	DateAndTimeOnVisit = WebUI.getText(DateAndTimeOfEachVisit)

	DateAndTimeOnVisit = (DateAndTimeOnVisit.split(', ')[0])

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(DateAndTimeOnVisit, TodayMonthAndDate, "In Check In page, visits with other than today's date are shown")
}

