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


class AddQuestion {
	/**
	 * Add question methods
	 */

	Verifications verifications = new Verifications()
	Random random = new Random()

	@Keyword
	def verifyAddQuestionPageElements() {

		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Questions/QuestionNameTextBox'), "Question name textbox is not present in the Add Question page")
		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Questions/QuestionTypeDropdown'), "Question type dropdown is not present in the Add Question page")
		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Questions/AllOptionInAudience'), "All option is not present in the Add Question page Audience")
		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Questions/SpecificVisitTypeRadioButton'), "Specific visit type radio button is not present in the Add Question page")
		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Questions/SaveButton'), "Save button is not present in the Add Question page")
	}


	@Keyword
	def getRandomQuestionName() {

		return "Test Question"+random.nextInt(100000)
	}
}