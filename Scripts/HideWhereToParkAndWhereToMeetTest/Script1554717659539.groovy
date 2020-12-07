import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.locks.Condition

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable



def VerifyHideFunctionality(String LocationType = 'OnCampus')
{
	Random Rvar = new Random()

	String LocationName = 'Location' + Rvar.nextInt(10000)

	CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/SettingsLeftNav'),
			'Settings left nav is not present in home page')

	WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('SettingsPage/AddLocationButtonInLocaions'),
			'Add Location button is not present in Location page')

	WebUI.click(findTestObject('SettingsPage/AddLocationButtonInLocaions'))

	WebUI.waitForElementVisible(findTestObject('SettingsPage/Locations/LocationNameTextfield'), 0)

	WebUI.sendKeys(findTestObject('SettingsPage/Locations/LocationNameTextfield'), LocationName)

	WebUI.sendKeys(findTestObject('SettingsPage/Locations/AddressLine1TextField'), findTestData('Location Details').getValue(
			2, 1))

	WebUI.sendKeys(findTestObject('SettingsPage/Locations/CityTextField'), findTestData('Location Details').getValue(4, 1))

	WebUI.click(findTestObject('SettingsPage/Locations/StateTextField'))

	WebUI.click(findTestObject('SettingsPage/Locations/SelectALinStateDropDown'))

	WebUI.click(findTestObject('SettingsPage/Locations/CountryTextField'))

	WebUI.click(findTestObject('SettingsPage/Locations/SelectIndiaInCountryDropdown'))

	WebUI.sendKeys(findTestObject('SettingsPage/Locations/ZipCodeTextfield'), findTestData('Location Details').getValue(7, 1))


	if(LocationType=='OnCampus')
	{
		WebUI.click(findTestObject('SettingsPage/Locations/OnCampusRadioButton'))
	}
	else
	{
		WebUI.click(findTestObject('SettingsPage/Locations/OffCampusRadioButton'))
	}

	WebUI.click(findTestObject('SettingsPage/Locations/NextButtonInLocationDetailsForm'))

	WebUI.delay(3)

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('SettingsPage/Locations/WhereToMeetToggleButton'),
			'Where to Meet toggle button is not present in the Location details page')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('SettingsPage/Locations/WhereToParkToggleButton'),
			'Where to Park toggle button is not present in the Location details page')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotClickable'(findTestObject('SettingsPage/Locations/CreateButtonInLocationDetailsPage'),
			'When where to meet and where to park text fields are empty, the Create button is in enabled state')

	WebUI.verifyElementChecked(findTestObject('SettingsPage/Locations/WhereToMeetToggleButton'), 0)

	WebUI.verifyElementChecked(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkToggleButton'), 0)

	WebUI.click(findTestObject('SettingsPage/Locations/WhereToMeetToggleButton'), FailureHandling.STOP_ON_FAILURE)

	if (!(WebUI.verifyElementNotChecked(findTestObject('SettingsPage/Locations/WhereToMeetToggleButton'), 0))) {
		WebUI.takeScreenshot()

		KeywordUtil.markFailedAndStop('When click the Where to meet toggle button then the button is not turning off')
	}

	WebUI.click(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkToggleButton'), FailureHandling.STOP_ON_FAILURE)

	if (!(WebUI.verifyElementNotChecked(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkToggleButton'),
	0))) {
		WebUI.takeScreenshot()

		KeywordUtil.markFailedAndStop('When click the Where to park toggle button then the button is not turning off')
	}

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/SettingsPage/Locations/CreateButtonInLocationDetailsPage'),
			'When disabled where to park and where to meet options then the Create button is not getting enabled')

	WebUI.click(findTestObject('SettingsPage/Locations/WhereToMeetToggleButton'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotClickable'(findTestObject('SettingsPage/Locations/CreateButtonInLocationDetailsPage'),
			'When only where to meet text field is enabled and no field is empty, the Create button is in enabled state')

	WebUI.sendKeys(findTestObject('Object Repository/SettingsPage/Locations/WhereToMeetTextField'), 'where to meet description')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/SettingsPage/Locations/CreateButtonInLocationDetailsPage'),
			'When Where to meet text field is enabled and entered the date then the Create button is not getting enebled')

	WebUI.click(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkToggleButton'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotClickable'(findTestObject('SettingsPage/Locations/CreateButtonInLocationDetailsPage'),
			'When where to meet & where to park text fields are enabled Where to park field is empty, the Create button is in enabled state')

	WebUI.sendKeys(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkInstructionsTextField'), 'where to park description')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/SettingsPage/Locations/CreateButtonInLocationDetailsPage'),
			'When Where to meet & where to park text fields are enabled and entered the date in both fields then the Create button is not getting enebled')

	WebUI.click(findTestObject('SettingsPage/Locations/CreateButtonInLocationDetailsPage'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('SettingsPage/Locations/CreateButtonInLocationDetailsPage'),
			"While creating location, if user clicks Create button in location details page then the Modal is not getting closed")

	def CreatedLocation = new TestObject("Created location in locations list")

	CreatedLocation.addProperty("xpath", ConditionType.EQUALS, "//td[text()='"+LocationName+"']")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(CreatedLocation, "Created location is not present in Locations list")

	def editLinkOnCreatedLocation = new TestObject("Edit button of created location")

	editLinkOnCreatedLocation.addProperty("xpath", ConditionType.EQUALS, "//td[text()='"+LocationName+"']/..//a[text()='Edit']")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(editLinkOnCreatedLocation, "Edit button is not present on the created location")

	WebUI.click(editLinkOnCreatedLocation)

	String WhereToMeetDescription = WebUI.getText(findTestObject('Object Repository/SettingsPage/Locations/WhereToMeetDescription'))

	String WhereToParkDescription = WebUI.getText(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkInstructionsTextField'))

	//CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(WhereToMeetDescription, "where to meet description", "Where to meet description given while creating a location is not match with description after creating")

	//CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(WhereToParkDescription, "where to park description", "Where to meet description given while creating a location is not match with description after creating")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/SettingsPage/Locations/SaveButtonInLocationDetailsPage'),
			'While editing a location, if user disabled where to meet field then the Save button is not in enabled state')

	WebUI.click(findTestObject('SettingsPage/Locations/WhereToMeetToggleButton'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/SettingsPage/Locations/SaveButtonInLocationDetailsPage'),
			'While editing a location, if only where to meet text field is disabled, the Save button is in disabled state')

	WebUI.click(findTestObject('SettingsPage/Locations/WhereToMeetToggleButton'))

	WebUI.clearText(findTestObject('Object Repository/SettingsPage/Locations/WhereToMeetTextField'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotClickable'(findTestObject('Object Repository/SettingsPage/Locations/SaveButtonInLocationDetailsPage'),
			'Whle editing the location, if where to meet text field is enabled and cleared, the Create button is in disabled state')


	WebUI.sendKeys(findTestObject('Object Repository/SettingsPage/Locations/WhereToMeetTextField'), "edit Meeting instuctions")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/SettingsPage/Locations/SaveButtonInLocationDetailsPage'),
			'While editing a location, if where to meet text field is enabled and entered date, the Save button is in disabled state')

	WebUI.click(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkToggleButton'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/SettingsPage/Locations/SaveButtonInLocationDetailsPage'),
			'While editing a location, if only where to park text field is disabled, the Save button is in disabled state')

	WebUI.click(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkToggleButton'))

	WebUI.clearText(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkInstructionsTextField'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotClickable'(findTestObject('Object Repository/SettingsPage/Locations/SaveButtonInLocationDetailsPage'),
			'While editing the location, if where to park text field is enabled and cleared, the save button is in disabled state')


	WebUI.sendKeys(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkInstructionsTextField'), "edit parking instuctions")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/SettingsPage/Locations/SaveButtonInLocationDetailsPage'),
			'While editing a location, if where to park text field is enabled and entered date, the Save button is in disabled state')

}

VerifyHideFunctionality()
VerifyHideFunctionality("OffCampus")


