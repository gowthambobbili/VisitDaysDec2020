import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def visitTypeDetails = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()

def visitType = visitTypeDetails.get("visitType")

def visitTypeId = visitTypeDetails.get("visitTypeId")

println visitTypeId

CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitTypeId)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(visitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

def visitId = WebUI.getUrl().split("visits/")[1]

println visitId

def  surveyCode = CustomKeywords.'com.CommonUtilities.ApiCalls.registerIndividual'(["visitId":visitId, "visitTypeId":visitTypeId]).get("surveyCode")

println surveyCode

WebUI.navigateToUrl(GlobalVariable.StudentAppUrl+GlobalVariable.Institution+"/surv/"+surveyCode)

WebUI.waitForElementPresent(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), 0)

//WebUI.navigateToUrl("https://charizard-student.visitdays.com/bbtesting/surv/OCLRNUXS")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'),
		'When navigated to a survey link the question is not shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'),
		'In student survey page the Next button is not present in the first question page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/BackButtonInSurveyPage'),
		'In Student survey page Back button is shown for the first question')

WebUI.verifyElementNotClickable(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))

String Question = WebUI.getText(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'),
5, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'))
} else {
	WebUI.sendKeys(findTestObject('Object Repository/Survey-Student App Objects/TextAreaInSurveyQuestion'), 'Test data')
}

WebUI.verifyElementClickable(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))

WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/QuestionObject(question)',
		[('question') : Question]), 'While completing a survey, When click Next button, the question is not getting changed')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/BackButtonInSurveyPage'),
		'While completing the survey Back button is not present when go to the second questions')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'),
		'While completing the survey Next button is not present in the second questions page')

if (!(WebUI.verifyElementClickable(findTestObject('Object Repository/Survey-Student App Objects/BackButtonInSurveyPage')))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('While completing the survey, the Back button is in not clicakable in the second question page')
}

def SecondQuestion = WebUI.getText(findTestObject('Object Repository/Survey-Student App Objects/QuestionFieldInSurvey'))

WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/BackButtonInSurveyPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/QuestionObject(question)',
		[('question') : Question]), 'While completing a survey, when click Back button in the second question page, the page is not navigated to the first questions')

if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'), 0)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("While completing a survey, If user clicks back button in the second question page then the answer submitted for the first question is not pre-filled")
}

WebUI.doubleClick(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/QuestionObject(question)',[('question') : SecondQuestion]), "While completing a survey, When double click on the Next button the next question is getting skipped without submitting the answer")



