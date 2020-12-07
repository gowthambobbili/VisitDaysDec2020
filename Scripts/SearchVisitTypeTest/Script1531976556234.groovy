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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

WebUI.waitForElementPresent(findTestObject('VisitTypesPage/SearchVisitTypesTextBox'), 0)

if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0, FailureHandling.OPTIONAL)) {
	WebDriver driver = DriverFactory.getWebDriver()

	int NumberOfListElements = driver.findElements(By.xpath('//div[@class="vt-info flex-center"]//h4')).size()

	Random rand = new Random()

	def random_num = rand.nextInt(NumberOfListElements)

	if(random_num==0)
	{
		random_num = 1
	}

	String SearchItem = driver.findElement(By.xpath(('(//div[@class="vt-info flex-center"]//h4)[' + random_num) + ']')).getText()

	WebUI.sendKeys(findTestObject('Object Repository/VisitTypesPage/SearchVisitTypesTextBox'), SearchItem)

	WebUI.delay(3)

	//int ListElementsAfterSearch = driver.findElements(By.xpath('//div[@class="vt-info flex-center"]//h4')).size()


	WebUI.verifyElementText(findTestObject('VisitTypesPage/NameOnFirstVisitCard'), SearchItem)

	int CountOfSearchResults = driver.findElements(By.xpath('//div[@class="vt-info flex-center"]//h4')).size()

	WebUI.verifyMatch(CountOfSearchResults.toString(), '1', false)

} else {
	println('There are no visit types created to verify the search functionaliy')
}

