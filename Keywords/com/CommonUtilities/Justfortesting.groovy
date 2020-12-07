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
import java.text.SimpleDateFormat;
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

import java.awt.geom.Arc2D.Float
import java.text.DateFormat
import java.text.ParseException;

import java.util.Date;


class Justfortesting {

	Verifications Verifications = new Verifications()

	@Keyword
	def JustForTesting() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'), 0)

		String Question

		while(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'), 10, FailureHandling.OPTIONAL)&&(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'), 10, FailureHandling.OPTIONAL))) {
			Question = WebUI.getText(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'))
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'))
				VerifyNextButtonIsEnabledAndClick()
				if((WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), 5, FailureHandling.OPTIONAL))) {
					String Condition = VerifyTheQuestionChangeOnClickingNextButton(Question)
					if(Condition=="break") {
						break
					}
				}
			}
			else {
				WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/TextAreaInSurveyQuestion'))
				WebUI.sendKeys(findTestObject('Object Repository/Survey-Student App Objects/TextAreaInSurveyQuestion'), "Test data")
				VerifyNextButtonIsEnabledAndClick()
				if((WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), 5, FailureHandling.OPTIONAL))||WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/SubmitButton'), 5, FailureHandling.OPTIONAL)) {
					String Condition2 = VerifyTheQuestionChangeOnClickingNextButton(Question)
					if(Condition2=="break") {
						break
					}
				}
			}
		}
	}
	//================================

	@Keyword
	def NewMethd(){
		while((WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'), 10, FailureHandling.OPTIONAL)))
		{
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'))
				if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), 10, FailureHandling.OPTIONAL)) {
					if(!(WebUI.verifyElementClickable(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), FailureHandling.OPTIONAL))) {
						WebUI.takeScreenshot()
						KeywordUtil.markFailedAndStop("After completing the question the Next button is not enabled")
						break
					}
					else {
						WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))
					}
				}
				else
				{
					break
				}
			}
		}
	}

	def VerifyNextButtonIsEnabledAndClick() {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), 10, FailureHandling.OPTIONAL)) {
			if(!(WebUI.verifyElementClickable(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), FailureHandling.OPTIONAL))) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("After completing the question the Next button is not enabled")
			}
			else {
				WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))
			}
		}
		else {
			if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/SubmitButton'), 0, FailureHandling.OPTIONAL))) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailed("Submit button is not present in the final question of survey")
			}
			else {
				WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/SubmitButton'))
				Verifications.VerifyElementPresentAndStopExecutionIfFailed('Object Repository/Survey-Student App Objects/MessageInSurveyConfirmationPage', "When click Submit button the confirmation page is not shown")
			}
		}
	}

	def VerifyTheQuestionChangeOnClickingNextButton(String Question) {
		String QuestionAfterClickingNext = WebUI.getText(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'))
		if(!(WebUI.verifyNotMatch(QuestionAfterClickingNext.trim(), Question.trim(), false, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed("When click the Next button the Next question is not shown in survey page")
			return "break"
		}
	}

	@Keyword
	def EventsTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, h:mm a");
		Date date1 = sdf.parse("May 14, 8:00 am");
		Date date2 = sdf.parse("May 7, 2:15 am");
		if(date1.compareTo(date2)<0)
		{
			println "pass"
		}
		else
		{
			println "fail"
		}
		println date1.compareTo(date2)
		date1 = sdf.parse("May 14, 8:00 am");
		date2 = sdf.parse("May 14, 8:00 am");
		println date1.compareTo(date2)
		date1 = sdf.parse("May 14, 8:00 am");
		date2 = sdf.parse("May 14, 8:00 pm");
		println date1.compareTo(date2)

	}
}





