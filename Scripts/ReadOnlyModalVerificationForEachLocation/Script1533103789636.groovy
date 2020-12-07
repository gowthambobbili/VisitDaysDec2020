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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

WebUI.waitForElementPresent(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), 0)

WebDriver driver = DriverFactory.getWebDriver()

int CountOfLocations = driver.findElements(By.xpath('//td[@style=\'touch-action: manipulation; -ms-touch-action: manipulation; cursor: pointer;\']')).size()

Random RandomLication = new Random()

//int LocationIndexToClick = RandomLication.nextInt(CountOfLocations)

for (int Location = 1; Location <= CountOfLocations/2; Location++) {

	driver.findElement(By.xpath(('(//td[@style=\'touch-action: manipulation; -ms-touch-action: manipulation; cursor: pointer;\'])[' +
			Location) + ']')).click()

	WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/NameHeaderInnLocationDetailsModal'), 0)

	WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/AddressHeaderInLocationDetailsModal'), 0)

	WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/TimeZoneHeaderInLocationDetailsModal'), 0)

	WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/TypeHeaderInLocationDetailsModal'), 0)

	WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/WhereToMeetInstructionsInLocationDetailsPage'), 0)

	WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/WhereToParkInstructionsHeaderInLocartionDetailsPage'),
			0)

	WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/DeleteButtonInLocationDetailsModal'), 0)

	WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/EditButtonInLocationDetailsMOdal'), 0)
	
	WebUI.waitForElementVisible(findTestObject('SettingsPage/Locations/CloseButtonInLocationDetailsModal'), 0)

	WebUI.click(findTestObject('SettingsPage/Locations/CloseButtonInLocationDetailsModal'))

	WebUI.waitForElementVisible(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), 0)
}

