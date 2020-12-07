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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class SurveyMethods {
	Verifications Verifications = new Verifications()
	@Keyword
	def CompleteSurvey() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'), 0)

		String Question

		while(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'), 10, FailureHandling.OPTIONAL)) {
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
	def CompleteSurveyAndReturnTheListOfTextAreaQuestions() {
		String CurrentQuestion
		def textAreaQuestionsResponses = [:]
		String temp
		while(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), 5, FailureHandling.OPTIONAL)) {
			CurrentQuestion = WebUI.getText(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'))

			temp = CompleteTheSurveyAndReturnTheListOfTextAreaQuestions(CurrentQuestion)

			if(temp != null) {
				textAreaQuestionsResponses.put('"'+temp.split("&")[0]+'"', temp.split("&")[1])
			}

			WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))

			Verifications.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Student App Objects/QuestionVariableFiled', ['Question':CurrentQuestion]), "When click Next button in Surveys, the question is not getting changed")
		}

		Verifications.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Student App Objects/SubmitButton'), "When click Submit button in last Surveys question, The page still shows submmit button")

		return textAreaQuestionsResponses
	}

	def CompleteTheSurveyAndReturnTheListOfTextAreaQuestions(String Question) {

		Random RandVar = new Random()
		String QuestionResponses = "Automation test for the text area responses"+RandVar.nextInt(1000000)
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'), 5, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'))
		}
		else {
			WebUI.sendKeys(findTestObject('Object Repository/Survey-Student App Objects/TextAreaInSurveyQuestion'), QuestionResponses)
			return Question+"&"+QuestionResponses
		}
	}

	@Keyword
	def verifyQuestionPresentInSurvey(String question) {

		def isQuestionPresent = false
		while(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/SubmitButton'), 2, FailureHandling.OPTIONAL))) {
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/QuestionObject(question)', ["question":question]), 2, FailureHandling.OPTIONAL)) {
				isQuestionPresent = true
				break
			}
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/SkipButton'), 2, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/SkipButton'))
			}

			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'), 2, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'))
			}
			else {
				WebUI.sendKeys(findTestObject('Object Repository/Survey-Student App Objects/TextAreaInSurveyQuestion'), "test")
			}
			WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))
		}

		if(!isQuestionPresent) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("The survey question 'How likely to enroll?' is not shown for the itinerary with apllicant status as Applied")
		}
	}


	@Keyword
	def goToSurveyQuestionsPage() {

		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/survey/questions")
		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/AddQuestionButton'), "When navigate to the Survey questions page, the Add Question button is not shown")
	}


	@Keyword
	def clickAddQuestioButton() {

		WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/AddQuestionButton'))
		WebUI.delay(1)
		def url = WebUI.getUrl()
		if(!(url.endsWith("/questions/new"))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("When click Add Question button, the add question page is not opened")
		}
	}

	@Keyword
	def enterQuestionName(String questionName) {

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/QuestionNameTextField'), "In add new question page the Question name field is not present")
		WebUI.sendKeys(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/QuestionNameTextField'), questionName)
	}

	@Keyword
	def selectQuestionType(String questionType) {

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/questionTypeDropdown'), "Question type dropdown is not present in the Add question page")
		WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/questionTypeDropdown'))
		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/QuestionTypeOption(type)', ["type":"List"]), "The List option is not present in the question type dropdown")
		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/QuestionTypeOption(type)', ["type":"Text"]), "The Text option is not present in the question type dropdown")
		if(questionType.equalsIgnoreCase("list")) {
			questionType = "List"
		}
		if(questionType.equalsIgnoreCase("text")) {
			questionType = "Text"
		}
		WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/QuestionTypeOption(type)', ["type":questionType]))
	}

	@Keyword
	def verifyDefaultListChoices() {

		def numberOfDefaultListChoices = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/ListChoices'), 0).size()
		if(!(numberOfDefaultListChoices==2)) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("When select List option in the question type dropdown the default two choices are not shown")
		}
	}

	@Keyword
	def enterDataInChoices(String choiceIndex) {

		WebUI.sendKeys(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/ListChoice(index)', ["index":choiceIndex]), choiceIndex)
	}


	@Keyword
	def selectAudience(String audience="all") {

		if(audience=="all") {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/AllOption'))
		}
		if(audience=="ind") {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/IndividualOption'))
		}
		if(audience=="grp") {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/GroupOption'))
		}
	}

	@Keyword
	def selectVisitTypeRadioButton(String visitType="all") {

		if(visitType=="all") {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/AllCurrentAndFutureVisitTypesOptions'))
		}
		if(visitType=="none") {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/NoneOption'))
		}
		if(visitType=="specific") {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/SpecificVisitTypeOption'))
		}
	}

	@Keyword
	def enableRequired() {

		if(WebUI.getAttribute(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/RequiredCheckbox'), "class").contains("selected")) {
			KeywordUtil.logInfo("Question marked as required")
		}
		else {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/RequiredCheckbox'))
		}
	}

	@Keyword
	def makeQuestionOptional() {

		if(WebUI.getAttribute(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/RequiredCheckbox'), "class").contains("selected")) {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/RequiredCheckbox'))
		}
		else {
			KeywordUtil.logInfo("Question marked as optional")
		}
	}

	@Keyword
	def clickSaveButton() {

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/SaveButton'), "Save button is not present in the create new question page")
		WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/SaveButton'))
		Verifications.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/SaveButton'), "When click Save button the button is still shown and the question is not getting saved")
	}

	@Keyword
	def selectSpecificVisitType(List visitTypes) {

		WebUI.waitForElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/VisitTypesDivision'), 0)
		def count = visitTypes.size()
		for(def i=0;i<count;i++) {
			WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/VisitTypeInList(visitType)', ["visitType":visitTypes[i]]))
		}
	}

	@Keyword
	def getActiveSurveyQuestions() {

		WebUI.delay(14)
		def activeQuestions = []
		def questionsCount = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/QuestionInList'), 0).size()
		for(int i=1;i<=questionsCount;i++) {
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/VisitTypesCount(index)', ["index":i]), 1, FailureHandling.OPTIONAL)) {
				println WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/VisitTypesCount(index)', ["index":i]))
				if(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/VisitTypesCount(index)', ["index":i])).trim()=="1 Visit Type"||WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/VisitTypesCount(index)', ["index":i])).trim()=="2 Visit Types"||WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/InactiveLabelOfQuestion(index)', ["index":i]), 1, FailureHandling.OPTIONAL)) {
					KeywordUtil.logInfo("Skipped the inactive question")
				}
				else {
					activeQuestions.add(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/IndividualQuestionInList(index)', ["index":i])).trim())
				}
			}
		}

		println activeQuestions
	}
}











