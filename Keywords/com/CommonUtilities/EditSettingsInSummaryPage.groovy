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

class VisitTypeSummaryPage {

	@Keyword
	def EditSettingsInSummaryPageInDailyVisitsAndEvents(TestObject VisitTypeCategory) {


		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(VisitTypeCategory)

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Daily Visit Visit Type' + random_num

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

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInVisitTypeNameFieldInSummaryPage'))

		WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		String EditedName = "Modified visit type name"+rand.nextInt(100000)

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), EditedName)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), 'Modified Visit Name')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), EditedName)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		// WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RegistrantTypeInSummaryPage'), 'Individuals And Groups')

		//not_run: WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantionMethodFieldInSummaryPage'),
		//FailureHandling.STOP_ON_FAILURE)

		//not_run: WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantionMethodFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RequestRadioButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RegistrationMethodInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(6, 1))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCheckInMethodFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/AutomatedTextMessageInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CheckInMethodInSummaryPage'), 'Automated Text Message')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CheckInMethodInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(2, 1))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInWaysToMeetFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/OnlineCheckBoxInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/OnlineTextFieldInSummaryPage'), 'Edit Settings Test')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/WaysToMeetInSummaryPage'), 0)

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/WaysToMeetInSummaryPage'), 'In Person , Online')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/WaysToMeetInSummaryPage'), findTestData('TestDataForVisitTypeSumaryFields').getValue(
				3, 1))

		//==================================//

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInPhotoFieldInSummaryPage'),
				0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInPhotoFieldInSummaryPage'))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/AddNowButtonInSummaryPage'))


		String userDir = System.getProperty('user.dir')

		WebUI.uploadFile(findTestObject('Object Repository/VisitTypesPage/UploadZoneForVisitTypePhoto'),
				userDir + '\\VisitTypePhoto\\albright college.png')

		//WebUI.uploadFile(findTestObject('VisitTypesPage/UploadZoneForVisitTypePhoto'), 'D:\\VisitDays-Automation\\tests\\VisitTypePhoto\\albright college.png')

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'),
				0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypePhotoInSummaryPage'), 0)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInDescriptionFieldInSummaryPage'),
				0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInDescriptionFieldInSummaryPage'))

		WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescriptionTextFieldInSummaryPageWhenAlreadyDescriptionExist'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescriptionTextFieldInSummaryPageInBlankState'), 'Description Edit Test')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescrpitionInSummaryPage'), 'Description Edit Test')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescrpitionInSummaryPage'), findTestData('TestDataForVisitTypeSumaryFields').getValue(
				4, 1))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCloseRegistrationOnFieldInSummaryPage'),
				0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCloseRegistrationOnFieldInSummaryPage'))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDaysBeforeVisitRadioButton'))

		WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDayBeforeVisitTextBoxToEnterNumberOfDays'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDayBeforeVisitTextBoxToEnterNumberOfDays'), '2')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

		//		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseRegistrationOnInSummaryPage'), '02 Days Before Visit')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseRegistrationOnInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(5, 1))
		//=====================================
		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/SearchVisitTypesTextBox'), 0)

		//===============================(to search and delete visit type)=========================

		//WebUI.click(findTestObject('VisitTypesPage/VisitTypeToVerifyIndetailsTabAndDelete'), FailureHandling.STOP_ON_FAILURE)

		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath("//h4[text()='"+EditedName+"']")).click()

		WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), EditedName)

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CheckInMethodInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(2, 1))

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/WaysToMeetInSummaryPage'), findTestData('TestDataForVisitTypeSumaryFields').getValue(
				3, 1))

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescrpitionInSummaryPage'), findTestData('TestDataForVisitTypeSumaryFields').getValue(
				4, 1))

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseRegistrationOnInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(5, 1))

		//WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

		WebUI.click(findTestObject('VisitTypesPage/DeleteButtonInDetailsPageOfVisitType'))

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/FirstCheckboxInDeleteVisitTypeModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/FirstCheckboxInDeleteVisitTypeModal'))

		WebUI.click(findTestObject('VisitTypesPage/SecondCheckBoxInDeleteVisitTypeModal'))

		WebUI.click(findTestObject('VisitTypesPage/ThierdCheckBoxInDeleteVisitTypeModal'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameTextBoxInDeleteVisitTypeModal'), EditedName)

		WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeInDeleteVisitTypeModal'))

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'))



	}


	@Keyword
	def EditSettingsInSummaryPageInOffCampus(TestObject VisitTypeCategory) {

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(VisitTypeCategory)

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(10000)

		def VisitTypeName = 'Test off campus Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		//WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInVisitTypeNameFieldInSummaryPage'))

		WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		String ModifiedVisitName = 'Modified off campus visit type Name'+rand.nextInt(90000)

		//driver.findElement(By.xpath("//h4[text()='"+EditedName+"']")).click()================//=====//=========

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), ModifiedVisitName)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), 'Modified Visit Name')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), ModifiedVisitName)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantionMethodFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RequestRadioButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RegistrationMethodInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(6, 1))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCheckInMethodFieldInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/AutomatedTextMessageInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), FailureHandling.STOP_ON_FAILURE)

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CheckInMethodInSummaryPage'), 'Automated Text Message')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CheckInMethodInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(2, 1))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInPhotoFieldInSummaryPage'),
				0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInPhotoFieldInSummaryPage'))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/AddNowButtonInSummaryPage'))

		String userDir = System.getProperty('user.dir')

		WebUI.uploadFile(findTestObject('Object Repository/VisitTypesPage/UploadZoneForVisitTypePhoto'),
				userDir + '\\VisitTypePhoto\\albright college.png')

		//WebUI.uploadFile(findTestObject('VisitTypesPage/UploadZoneForVisitTypePhoto'), 'D:\\VisitDays-Automation\\tests\\VisitTypePhoto\\albright college.png')

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'),
				0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypePhotoInSummaryPage'), 0)


		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInDescriptionFieldInSummaryPage'),
				0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInDescriptionFieldInSummaryPage'))

		WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescriptionTextFieldInSummaryPageWhenAlreadyDescriptionExist'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescriptionTextFieldInSummaryPageInBlankState'), 'Description Edit Test')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescrpitionInSummaryPage'), 'Description Edit Test')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescrpitionInSummaryPage'), findTestData('TestDataForVisitTypeSumaryFields').getValue(
				4, 1))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCloseRegistrationOnFieldInSummaryPage'),
				0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCloseRegistrationOnFieldInSummaryPage'))

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDaysBeforeVisitRadioButton'))

		WebUI.clearText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDayBeforeVisitTextBoxToEnterNumberOfDays'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseDayBeforeVisitTextBoxToEnterNumberOfDays'), '2')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

		//WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseRegistrationOnInSummaryPage'), '02 Days Before Visit')

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseRegistrationOnInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(5, 1))

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)

		//WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/SearchVisitTypesTextBox'), 0)

		//================================//================///================

		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath("//h4[text()='"+ModifiedVisitName+"']")).click()

		//WebUI.click(findTestObject('VisitTypesPage/VisitTypeToVerifyIndetailsTabAndDelete'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), ModifiedVisitName)

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CheckInMethodInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(2, 1))

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/DescrpitionInSummaryPage'), findTestData('TestDataForVisitTypeSumaryFields').getValue(
				4, 1))

		WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/CloseRegistrationOnInSummaryPage'), findTestData(
				'TestDataForVisitTypeSumaryFields').getValue(5, 1))

		//WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

		WebUI.click(findTestObject('VisitTypesPage/DeleteButtonInDetailsPageOfVisitType'))

		//driver.findElement(By.xpath("//h4[text()='"+ModifiedVisitName+"']")).click()

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/FirstCheckboxInDeleteVisitTypeModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/FirstCheckboxInDeleteVisitTypeModal'))

		WebUI.click(findTestObject('VisitTypesPage/SecondCheckBoxInDeleteVisitTypeModal'))

		WebUI.click(findTestObject('VisitTypesPage/ThierdCheckBoxInDeleteVisitTypeModal'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameTextBoxInDeleteVisitTypeModal'), ModifiedVisitName)

		WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeInDeleteVisitTypeModal'))

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'))

	}
}