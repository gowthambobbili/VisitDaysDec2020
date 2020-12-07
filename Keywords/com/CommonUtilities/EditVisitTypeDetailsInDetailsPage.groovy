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


class EditVisitTypeDetailsInDetailsPage {

	@Keyword
	def EditDetailsofDailyVisitAndEventVisitTypes() {

		WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInVisitTypeNameFieldInSummaryPage'))

		WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), 'Modified Visit Name')

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

		if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
		true) {
			WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

			WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
		}

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), 'Modified Visit Name')
		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(1, 1))

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

	}

	@Keyword
	def EditDetailsofOffCampusVisitTypes() {

		WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInVisitTypeNameFieldInSummaryPage'))

		WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), 'Modified Visit Name')

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 5)

		if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE) ==
		true) {
			WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'))

			WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'))
		}

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), 'Modified Visit Name')
		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(1, 1))

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

	}
}