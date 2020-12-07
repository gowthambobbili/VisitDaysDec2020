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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0, FailureHandling.OPTIONAL))) {
	String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

	CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(DailyVisitVisitType)

	WebUI.delay(3)

	WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

	WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)
}

WebUI.delay(8)

int NumberOfVisits = driver.findElements(By.xpath('//div[@class=\'shadow __visit__visit-card__7422f pointer-on-hover ember-view\']//div[@class=\'col-xs-12 col-md-5 desktop-align-right mobile-align-left\']/span')).size()

for (int i = 1; i <= NumberOfVisits; i++) {
	String DateOnVisitCard = driver.findElement(By.xpath(('(//div[@class=\'shadow __visit__visit-card__7422f pointer-on-hover ember-view\']//div[@class=\'col-xs-12 col-md-5 desktop-align-right mobile-align-left\']/span)[' +
			i) + ']')).getText()

	DateOnVisitCard = (DateOnVisitCard.split(',')[0])

	DateOnVisitCard = (DateOnVisitCard.split(' ')[1])

	println(DateOnVisitCard)

	Date today = Calendar.getInstance().getTime()

	String todayDateString = today.toString().split(' ')[2]


	println todayDateString

	int todayDate = Integer.parseInt(todayDateString)

	if(todayDate<10)
	{
		todayDateString = todayDateString[1]
	}
//	else
//	{
//		todayDate.toString()
//	}

	WebUI.verifyMatch(DateOnVisitCard, todayDateString, false)
}

