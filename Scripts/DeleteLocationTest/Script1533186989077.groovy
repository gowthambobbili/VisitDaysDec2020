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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

Random DelVariable = new Random()

int RandomNumberForDelete = DelVariable.nextInt(500000)

String LocationToDelete = 'LocationName' + RandomNumberForDelete

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateLocation'(LocationToDelete)

WebUI.waitForElementPresent(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), 0)

WebUI.refresh()

WebUI.sendKeys(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), LocationToDelete)

WebUI.delay(2)

WebUI.click(findTestObject('SettingsPage/Locations/FirstLocationInLocationsList'))

WebUI.waitForElementVisible(findTestObject('SettingsPage/Locations/DeleteButtonInLocationDetailsModal'), 0)

WebUI.click(findTestObject('SettingsPage/Locations/DeleteButtonInLocationDetailsModal'))

WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/Yes, IUnderstandCheckBoxInDeleteLocationModal'), 0)

WebUI.waitForElementVisible(findTestObject('SettingsPage/Locations/Yes, IUnderstandCheckBoxInDeleteLocationModal'), 0)

WebUI.click(findTestObject('SettingsPage/Locations/Yes, IUnderstandCheckBoxInDeleteLocationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SettingsPage/Locations/DeleteButtonInDeleteLocationPopup'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('SettingsPage/Locations/DeleteButtonInDeleteLocationPopup'), 0)

WebUI.waitForElementPresent(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), 0)

WebUI.clearText(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), LocationToDelete)

WebUI.delay(4)

def object = new TestObject('DeletedLocation')

object.addProperty('xpath', ConditionType.EQUALS, ('//td[text()=\'' + LocationToDelete) + '\']')

WebUI.verifyElementNotPresent(object, 0)

