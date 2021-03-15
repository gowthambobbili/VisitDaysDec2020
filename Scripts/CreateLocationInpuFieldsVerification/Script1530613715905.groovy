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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

not_run: WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

not_run: WebUI.waitForElementPresent(findTestObject('SettingsPage/AddLocationButtonInLocaions'), 0)

not_run: WebUI.click(findTestObject('SettingsPage/AddLocationButtonInLocaions'))

Random rand = new Random()

random_num = rand.nextInt(100000)

def LocName = 'Location Name' + random_num

not_run: WebUI.waitForElementVisible(findTestObject('SettingsPage/Locations/LocationNameTextfield'), 0)

not_run: WebUI.sendKeys(findTestObject('SettingsPage/Locations/LocationNameTextfield'), LocName)

not_run: WebUI.sendKeys(findTestObject('SettingsPage/Locations/AddressLine1TextField'), findTestData('Location Details').getValue(
2, 1))

not_run: WebUI.sendKeys(findTestObject('SettingsPage/Locations/AddressLine2TextField'), findTestData('Location Details').getValue(
3, 1))

not_run: WebUI.sendKeys(findTestObject('SettingsPage/Locations/CityTextField'), findTestData('Location Details').getValue(
4, 1))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/StateTextField'))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/SelectALinStateDropDown'))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/CountryTextField'))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/SelectIndiaInCountryDropdown'))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/TimeZoneDropdown'))

not_run: WebUI.click(findTestObject('SettingsPage/SelectAsiaKolkataTimeZone'))

not_run: WebUI.sendKeys(findTestObject('SettingsPage/Locations/ZipCodeTextfield'), findTestData('Location Details').getValue(
7, 1))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/OffCampusRadioButton'))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/OnCampusRadioButton'))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/NextButtonInLocationDetailsForm'))

not_run: WebUI.sendKeys(findTestObject('SettingsPage/Locations/WhereToMeetTextField'), findTestData('Location Details').getValue(
8, 1))

not_run: WebUI.sendKeys(findTestObject('SettingsPage/Locations/WhereToParkInstructionsTextField'), findTestData('Location Details').getValue(
9, 1))

not_run: WebUI.click(findTestObject('SettingsPage/Locations/CreateButtonInLocationDetailsPage'))

not_run: WebUiBuiltInKeywords.waitForElementPresent(findTestObject('SettingsPage/Locations/LocationCreatedFlashMessage'),
0)

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateLocation'(LocName)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('SettingsPage/Locations/LocationCreatedFlashMessage'), 0)

WebUI.sendKeys(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), LocName)

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.VerifLocationInLocationsList'(LocName)



