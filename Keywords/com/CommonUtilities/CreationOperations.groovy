package com.CommonUtilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class CreationOperations {

	WebDriver driver = DriverFactory.getWebDriver()
	PageNavigations Navigate = new PageNavigations()

	@Keyword
	def CreateDailyVisit() {
		PageNavigations navigate = new PageNavigations()
		String CurrentUrl  = WebUI.getUrl()
		if(CurrentUrl.contains('staging')) {

			WebUI.navigateToUrl('https://staging.visitdays.com/')
		}
		else {
			WebUI.navigateToUrl('https://admin.visitdays.com/')
		}
		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

		navigate.NavigateToDailyVisits()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/CreateDailyVisitButton'))

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/VisitTypeTextBoxWhileCreatingDV'), 'Automation Test1')

		WebUI.click(findTestObject('DailyVisitsPage/HilightedVisitTypeInVisitTypeDropDownInDV'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/CurrentDateInStartDateCalander'))

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/LocationTextFieldInDv'), 'Ctest')

		WebUI.click(findTestObject('DailyVisitsPage/HilightedOptionInLocation'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)
	}



	@Keyword

	def CreateVisitType(TestObject VisitTypeCategory, String action) {

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(VisitTypeCategory)

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		WebDriver driver = DriverFactory.getWebDriver()

		Random RandomNumberforVisitTypeName = new Random()

		String VisitTypeName = 'testVisitType'+RandomNumberforVisitTypeName.next(50000)

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)


		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/SearchVisitTypesTextBox'), 0)

		if(action=='create and edit') {
			driver.findElement(By.xpath("//h4[text()='"+VisitTypeName+"']")).click()

			//created and clicked on the created visit type========

			//WebUI.click(findTestObject('VisitTypesPage/VisitTypeToEditDettailsPage'), FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInVisitTypeNameFieldInSummaryPage'))

			WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			String ModifiedName = 'Modified Visit Name'+RandomNumberforVisitTypeName.next(50000)

			WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), ModifiedName)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

			if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
			true) {
				WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

				WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
			}

			//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), 'Modified Visit Name')
			WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), ModifiedName)

			WebUI.delay(3)

			WebUI.waitForElementClickable(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'),
					0)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'), FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

			if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
			true) {
				WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

				WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
			}

			// WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RegistrantTypeInSummaryPage'), 'Individuals And Groups')
			//not_run: WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantionMethodFieldInSummaryPage'),
			//FailureHandling.STOP_ON_FAILURE)
			//not_run: WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			//============

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantionMethodFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('VisitTypesPage/RequestRadioButtonInSummaryPage'), FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

			if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
			true)
			{
				WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

				WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
			}

			WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RegistrationMethodInSummaryPage'), findTestData(
					'TestDataForVisitTypeSumaryFields').getValue(6, 1))

			WebUI.delay(3)
			//============


			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCheckInMethodFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/AutomatedTextMessageInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

			if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
			true)
			{
				WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

				WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
			}

			//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CheckInMethodInSummaryPage'), 'Automated Text Message')
			WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CheckInMethodInSummaryPage'), findTestData(
					'TestDataForVisitTypeSumaryFields').getValue(2, 1))

			WebUI.delay(3)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInWaysToMeetFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/OnlineCheckBoxInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/OnlineTextFieldInSummaryPage'), 'Edit Settings Test')

			WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

			if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
			true) {
				WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

				WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
			}

			WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/WaysToMeetInSummaryPage'), 0)

			//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/WaysToMeetInSummaryPage'), 'In Person , Online')
			WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/WaysToMeetInSummaryPage'), findTestData('TestDataForVisitTypeSumaryFields').getValue(
					3, 1))

			WebUI.delay(3)

			WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInDescriptionFieldInSummaryPage'), 0)


			WebUI.waitForElementClickable(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInDescriptionFieldInSummaryPage'),
					0)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInDescriptionFieldInSummaryPage'))

			WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescriptionTextFieldInSummaryPageWhenAlreadyDescriptionExist'))

			WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescriptionTextFieldInSummaryPageInBlankState'), 'Description Edit Test')

			WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

			WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

			if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
			true)
			{
				WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

				WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
			}

			//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescrpitionInSummaryPage'), 'Description Edit Test')
			WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescrpitionInSummaryPage'), findTestData('TestDataForVisitTypeSumaryFields').getValue(
					4, 1))

			WebUI.delay(3)

			WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCloseRegistrationOnFieldInSummaryPage'),
					0)

			WebUI.waitForElementClickable(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCloseRegistrationOnFieldInSummaryPage'),
					0)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCloseRegistrationOnFieldInSummaryPage'))

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDaysBeforeVisitRadioButton'))

			WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDayBeforeVisitTextBoxToEnterNumberOfDays'))

			WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDayBeforeVisitTextBoxToEnterNumberOfDays'), '2')

			WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

			WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

			WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

			if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
			true) {
				WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

				WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
			}

			//		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseRegistrationOnInSummaryPage'), '02 Days Before Visit')
			WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseRegistrationOnInSummaryPage'), findTestData(
					'TestDataForVisitTypeSumaryFields').getValue(5, 1))

			WebUI.delay(3)

			//Visit type editing completed
			//deleteing visit type

			WebUI.click(findTestObject('VisitTypesPage/DeleteButtonInDetailsPageOfVisitType'))

			WebUI.click(findTestObject('VisitTypesPage/FirstCheckboxInDeleteVisitTypeModal'))

			WebUI.click(findTestObject('VisitTypesPage/SecondCheckBoxInDeleteVisitTypeModal'))

			WebUI.click(findTestObject('VisitTypesPage/ThierdCheckBoxInDeleteVisitTypeModal'))

			WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameTextBoxInDeleteVisitTypeModal'), ModifiedName)

			WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeInDeleteVisitTypeModal'))

			WebUI.waitForElementVisible(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'), 0)

			WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'))

		}
	}

	@Keyword

	def CreateOffCampusVisitType(TestObject VisitTypeCategory) {

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(VisitTypeCategory)

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), 'TestVisitType')

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/SearchVisitTypesTextBox'), 0)

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/SearchVisitTypesTextBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypeToEditDettailsPage'), FailureHandling.STOP_ON_FAILURE)
	}


	@Keyword

	def CreateLocation(String LocName)
	{

		Navigate.NavigateToLocations()

		WebUI.click(findTestObject('SettingsPage/AddLocationButtonInLocaions'))

		WebUI.waitForElementVisible(findTestObject('SettingsPage/Locations/LocationNameTextfield'), 0)

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/LocationNameTextfield'), LocName)

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/AddressLine1TextField'), findTestData('Location Details').getValue(
				2, 1))

		//WebUI.sendKeys(findTestObject('SettingsPage/Locations/AddressLine2TextField'), findTestData('Location Details').getValue(
		//3, 1))

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/CityTextField'), findTestData('Location Details').getValue(4, 1))

		WebUI.click(findTestObject('SettingsPage/Locations/StateTextField'))

		WebUI.click(findTestObject('SettingsPage/Locations/SelectALinStateDropDown'))

		WebUI.click(findTestObject('SettingsPage/Locations/CountryTextField'))

		WebUI.click(findTestObject('SettingsPage/Locations/SelectIndiaInCountryDropdown'))

		WebUI.click(findTestObject('SettingsPage/Locations/TimeZoneDropdown'))

		WebUI.click(findTestObject('SettingsPage/SelectAsiaKolkataTimeZone'))

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/ZipCodeTextfield'), findTestData('Location Details').getValue(7, 1))

		WebUI.scrollToElement(findTestObject('SettingsPage/Locations/OffCampusRadioButton'), 0)

		WebUI.click(findTestObject('SettingsPage/Locations/OffCampusRadioButton'))

		WebUI.click(findTestObject('SettingsPage/Locations/OnCampusRadioButton'))

		WebUI.click(findTestObject('SettingsPage/Locations/NextButtonInLocationDetailsForm'))

		WebUI.verifyElementPresent(findTestObject('SettingsPage/Locations/WhereToMeetTextField'), 0)

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/WhereToMeetTextField'), findTestData('Location Details').getValue(
				8, 1))

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/WhereToParkInstructionsTextField'), findTestData('Location Details').getValue(
				9, 1))

		WebUI.click(findTestObject('SettingsPage/Locations/CreateButtonInLocationDetailsPage'))

		WebUiBuiltInKeywords.waitForElementPresent(findTestObject('SettingsPage/Locations/LocationCreatedFlashMessage'), 0)


	}

	@Keyword

	def CreateOffCampusLocation(String LocName)
	{
		Navigate.NavigateToLocations()

		WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

		WebUI.waitForElementPresent(findTestObject('SettingsPage/AddLocationButtonInLocaions'), 0)

		WebUI.click(findTestObject('SettingsPage/AddLocationButtonInLocaions'))

		//		Random rand = new Random()
		//
		//		int random_num = rand.nextInt(100000)
		//
		//		def LocName = 'Location Name' + random_num

		WebUI.waitForElementVisible(findTestObject('SettingsPage/Locations/LocationNameTextfield'), 0)

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/LocationNameTextfield'), LocName)

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/AddressLine1TextField'), findTestData('Location Details').getValue(
				2, 1))

		//WebUI.sendKeys(findTestObject('SettingsPage/Locations/AddressLine2TextField'), findTestData('Location Details').getValue(
		//3, 1))

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/CityTextField'), findTestData('Location Details').getValue(4, 1))

		WebUI.click(findTestObject('SettingsPage/Locations/StateTextField'))

		WebUI.click(findTestObject('SettingsPage/Locations/SelectALinStateDropDown'))

		WebUI.click(findTestObject('SettingsPage/Locations/CountryTextField'))

		WebUI.click(findTestObject('SettingsPage/Locations/SelectIndiaInCountryDropdown'))

		WebUI.click(findTestObject('SettingsPage/Locations/TimeZoneDropdown'))

		WebUI.click(findTestObject('SettingsPage/SelectAsiaKolkataTimeZone'))

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/ZipCodeTextfield'), findTestData('Location Details').getValue(7, 1))

		WebUI.click(findTestObject('SettingsPage/Locations/OffCampusRadioButton'))

		//WebUI.click(findTestObject('SettingsPage/Locations/OnCampusRadioButton'))

		WebUI.click(findTestObject('SettingsPage/Locations/NextButtonInLocationDetailsForm'))

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/WhereToMeetTextField'), findTestData('Location Details').getValue(
				8, 1))

		WebUI.sendKeys(findTestObject('SettingsPage/Locations/WhereToParkInstructionsTextField'), findTestData('Location Details').getValue(
				9, 1))

		WebUI.click(findTestObject('SettingsPage/Locations/CreateButtonInLocationDetailsPage'))

		WebUiBuiltInKeywords.waitForElementPresent(findTestObject('SettingsPage/Locations/LocationCreatedFlashMessage'), 0)


	}



	@Keyword
	def CreateDailyVisitWithRequestVisitType(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def vobject = new TestObject("VIsitTypeInVisitTypeFilter")

		vobject.addProperty("xpath", ConditionType.EQUALS,"//li[text()='"+VisitTypeName+"']")

		WebUI.click(vobject)

		//driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		//.scrollToElement(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'), 0)

		WebUI.delay(2)
		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'), 0)
		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

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

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		//WebUI.delay(4)
		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

		WebUI.clearText(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'))

		//driver.findElement(By.xpath("//span[text()='test user1']/..//i")).click()

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'mahesh test')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}
	@Keyword
	def CreateDailyVisitWithInstantVisitType(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def object = new TestObject("VisitTypeInFilterWhileCreatingDailyVisit")

		object.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(object)


		//driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

		//		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))
		//
		//		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), '12:00 AM')
		//
		//		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))
		//
		//		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '12:00 AM')

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

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	//=====================with capacity======================

	@Keyword
	def CreateDailyVisitWithInstantVisitTypeWithCapacity(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def object = new TestObject("VisitTypeInFilter")

		object.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '100')

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '50')

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionFiveInHowManyGuestsAreAllowedDropDown'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}




	//================================


	@Keyword
	def CreateEventWithRequestVisitType(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		//WebUI.delay(4)
		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

		WebUI.clearText(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'))

		//driver.findElement(By.xpath("//span[text()='test user1']/..//i")).click()

		//.scrollToElement(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'mahesh')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(3)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)
	}


	@Keyword
	def CreateEventWithInstantVisitType(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.delay(2)

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		//		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))
		//
		//		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), '12:00 AM')
		//
		//		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))
		//
		//		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '11:59 PM')


		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	def CreateEventWithInstantVisitTypeWithCapacity(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '100')

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '50')

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionFiveInHowManyGuestsAreAllowedDropDown'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}




	@Keyword
	def CreateOffCampusWithRequestVisitType(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'), 0)

		//WebUI.delay(4)
		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.delay(2)

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

		WebUI.clearText(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'))

		//driver.findElement(By.xpath("//span[text()='test user1']/..//i")).click()

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'mahesh')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)
	}





	@Keyword
	def CreateOffCampusWithInstantVisitType(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def VisitTypeInFilter = new TestObject("Visit Type in visit type index page")

		VisitTypeInFilter.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(VisitTypeInFilter)

		//		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()
		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(3)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}




	@Keyword
	def CreateOffCampusWithInstantVisitTypeWithCapacity(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '100')

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '50')

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))

		WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionFiveInHowManyGuestsAreAllowedDropDown'))


		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}




	@Keyword
	def CreateDailyVisitWithRequestVisitTypeForFutureDates(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.delay(2)

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		//WebUI.delay(4)

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))


		WebUI.scrollToElement(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.click(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	//==================================


	@Keyword
	def CreateInstantDailyVisitByAssigningUsers(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def object = new TestObject("VisitTypeInFilter")

		object.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(object)



		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))


		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))


		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/SearchUserSearchboxInAssignUsersPage'), 'mahesh test')

		WebUI.delay(4)

		WebUI.click(findTestObject('DailyVisitsPage/AddSymbolOfMaheshTestInAssignUsersPage'))


		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}



	@Keyword
	def CreateInstantEventVisitByAssigningUsers(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		//driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		def VisitTypeObjetct = new TestObject("VisitTypeInVisitTypeDropDown")

		VisitTypeObjetct.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(VisitTypeObjetct)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/SearchUserSearchboxInAssignUsersPage'), 'mahesh test')

		WebUI.delay(4)

		WebUI.click(findTestObject('DailyVisitsPage/AddSymbolOfMaheshTestInAssignUsersPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}




	@Keyword
	def CreateInstantOffCampusVisitByAssigningUsers(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)


//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//		WebUI.click(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/SearchUserSearchboxInAssignUsersPage'), 'mahesh test')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/AddSymbolOfMaheshTestInAssignUsersPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	//*****************************calendar utilities**********************************//

	@Keyword
	def CreateDailyVisitWithInstantVisitTypeAndProvidedMonthAndDate(String VisitTypeName, String Month, String Day)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def object = new TestObject("VisitTypeInFilterWhileCreatingDailyVisit")

		object.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))



		def MonthInCalendar = new TestObject("Month in calendar")

		MonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//div[@class='datepicker-days']//th[@class='datepicker-switch']")

		WebUI.waitForElementVisible(MonthInCalendar, 0)

		WebUI.click(MonthInCalendar)

		def CurrentMonthInCalendar = new TestObject("Current month in calendar")

		CurrentMonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+Month+"']")

		WebUI.waitForElementVisible(CurrentMonthInCalendar, 0)

		WebUI.click(CurrentMonthInCalendar)

		def DateInCalendar = new TestObject("Date in calendar")

		DateInCalendar.addProperty("xpath", ConditionType.EQUALS, "(//td[text()='"+Day+"'])[1]")

		WebUI.waitForElementVisible(DateInCalendar, 0)

		WebUI.click(DateInCalendar)

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.waitForElementVisible(MonthInCalendar, 0)

		WebUI.click(MonthInCalendar)

		WebUI.waitForElementVisible(CurrentMonthInCalendar, 0)

		WebUI.click(CurrentMonthInCalendar)

		WebUI.waitForElementVisible(DateInCalendar, 0)

		WebUI.click(DateInCalendar)



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

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	def CreateDailyVisitWithInstantVisitTypeAndProvidedMonthDateAndYear(String VisitTypeName, String Month, String Day, String Year)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def object = new TestObject("VisitTypeInFilterWhileCreatingDailyVisit")

		object.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))


		def MonthInCalendar = new TestObject("Month in calendar")

		MonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//div[@class='datepicker-days']//th[@class='datepicker-switch']")

		WebUI.waitForElementVisible(MonthInCalendar, 0)

		WebUI.click(MonthInCalendar)

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/YearFieldInCalendar'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/YearFieldInCalendar'))

		def CurrentYear = new TestObject("Current year in calendar")

		CurrentYear.addProperty("xpath", ConditionType.EQUALS, "(//span[text()='"+Year+"'])[1]")

		WebUI.waitForElementVisible(CurrentYear, 0)

		WebUI.click(CurrentYear)

		def CurrentMonthInCalendar = new TestObject("Current month in calendar")

		CurrentMonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+Month+"']")

		WebUI.waitForElementVisible(CurrentMonthInCalendar, 0)

		WebUI.click(CurrentMonthInCalendar)

		def DateInCalendar = new TestObject("Date in calendar")

		DateInCalendar.addProperty("xpath", ConditionType.EQUALS, "(//td[@class='day' and text()='"+Day+"'])")



		WebUI.waitForElementVisible(DateInCalendar, 0)

		WebUI.click(DateInCalendar)

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.waitForElementVisible(MonthInCalendar, 0)

		WebUI.click(MonthInCalendar)

		WebUI.waitForElementVisible(CurrentMonthInCalendar, 0)

		WebUI.click(CurrentMonthInCalendar)

		WebUI.waitForElementVisible(DateInCalendar, 0)

		WebUI.click(DateInCalendar)



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

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	def CreateEventWithInstantVisitTypeAndProvidedMonthAndDate(String VisitTypeName, String Month, String Day)
	{
		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.delay(2)

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))


		def MonthInCalendar = new TestObject("Month in calendar")

		MonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//div[@class='datepicker-days']//th[@class='datepicker-switch']")

		WebUI.waitForElementVisible(MonthInCalendar, 0)

		WebUI.click(MonthInCalendar)

		def CurrentMonthInCalendar = new TestObject("Current month in calendar")

		CurrentMonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+Month+"']")

		WebUI.waitForElementVisible(CurrentMonthInCalendar, 0)

		WebUI.click(CurrentMonthInCalendar)

		def DateInCalendar = new TestObject("Date in calendar")

		DateInCalendar.addProperty("xpath", ConditionType.EQUALS, "(//td[text()='"+Day+"'])[1]")

		WebUI.waitForElementVisible(DateInCalendar, 0)

		WebUI.click(DateInCalendar)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	def CreateEventWithInstantVisitTypeAndProvidedMonthDateAndYear(String VisitTypeName, String Month, String Day, String Year)
	{
		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.delay(2)

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))


		def MonthInCalendar = new TestObject("Month in calendar")

		MonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//div[@class='datepicker-days']//th[@class='datepicker-switch']")

		WebUI.waitForElementVisible(MonthInCalendar, 0)

		WebUI.click(MonthInCalendar)

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/YearFieldInCalendar'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/YearFieldInCalendar'))

		def CurrentYear = new TestObject("Current year in calendar")

		CurrentYear.addProperty("xpath", ConditionType.EQUALS, "(//span[text()='"+Year+"'])[1]")

		WebUI.waitForElementVisible(CurrentYear, 0)

		WebUI.click(CurrentYear)

		def CurrentMonthInCalendar = new TestObject("Current month in calendar")

		CurrentMonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+Month+"']")

		WebUI.waitForElementVisible(CurrentMonthInCalendar, 0)

		WebUI.click(CurrentMonthInCalendar)

		def DateInCalendar = new TestObject("Date in calendar")

		DateInCalendar.addProperty("xpath", ConditionType.EQUALS, "(//td[@class='day' and text()='"+Day+"'])")

		WebUI.waitForElementVisible(DateInCalendar, 0)

		WebUI.click(DateInCalendar)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}




	@Keyword
	def CreateOffCampusVisitWithInstantVisitTypeAndProvidedMonthAndDate(String VisitTypeName, String Month, String Day)
	{
		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def VisitTypeInFilter = new TestObject("Visit Type in visit type index page")

		VisitTypeInFilter.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(VisitTypeInFilter)

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		def MonthInCalendar = new TestObject("Month in calendar")

		MonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//div[@class='datepicker-days']//th[@class='datepicker-switch']")

		WebUI.waitForElementVisible(MonthInCalendar, 0)

		WebUI.click(MonthInCalendar)

		def CurrentMonthInCalendar = new TestObject("Current month in calendar")

		CurrentMonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+Month+"']")

		WebUI.waitForElementVisible(CurrentMonthInCalendar, 0)

		WebUI.click(CurrentMonthInCalendar)

		def DateInCalendar = new TestObject("Date in calendar")

		DateInCalendar.addProperty("xpath", ConditionType.EQUALS, "(//td[text()='"+Day+"'])[1]")

		WebUI.waitForElementVisible(DateInCalendar, 0)

		WebUI.click(DateInCalendar)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), '1:00 PM')

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '2:00 PM')

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	def CreateOffCampusVisitWithInstantVisitTypeAndProvidedMonthDateAndYear(String VisitTypeName, String Month, String Day, String Year)
	{
		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		def VisitTypeInFilter = new TestObject("Visit Type in visit type index page")

		VisitTypeInFilter.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitTypeName+"']")

		WebUI.click(VisitTypeInFilter)

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))



		def MonthInCalendar = new TestObject("Month in calendar")

		MonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//div[@class='datepicker-days']//th[@class='datepicker-switch']")

		WebUI.waitForElementVisible(MonthInCalendar, 0)

		WebUI.click(MonthInCalendar)

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/YearFieldInCalendar'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/YearFieldInCalendar'))

		def CurrentYear = new TestObject("Current year in calendar")

		CurrentYear.addProperty("xpath", ConditionType.EQUALS, "(//span[text()='"+Year+"'])[1]")

		WebUI.waitForElementVisible(CurrentYear, 0)

		WebUI.click(CurrentYear)

		def CurrentMonthInCalendar = new TestObject("Current month in calendar")

		CurrentMonthInCalendar.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+Month+"']")

		WebUI.waitForElementVisible(CurrentMonthInCalendar, 0)

		WebUI.click(CurrentMonthInCalendar)

		def DateInCalendar = new TestObject("Date in calendar")

		DateInCalendar.addProperty("xpath", ConditionType.EQUALS, "(//td[@class='day' and text()='"+Day+"'])")

		WebUI.waitForElementVisible(DateInCalendar, 0)

		WebUI.click(DateInCalendar)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), '1:00 PM')

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '2:00 PM')

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}

}










