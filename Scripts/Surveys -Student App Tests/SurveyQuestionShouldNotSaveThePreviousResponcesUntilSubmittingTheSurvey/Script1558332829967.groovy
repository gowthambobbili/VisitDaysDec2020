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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//WebUI.callTestCase(findTestCase('Surveys -Student App Tests/NavigateToSurveyPage'), [:], FailureHandling.STOP_ON_FAILURE)
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/QuestionFieldInSurvey'),
//		'When navigated to the survey link the survey questions are not shown (Wait time is 30 seconds)')

def token = CustomKeywords.'com.CommonUtilities.ApiCalls.GetAccessToken'()

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

String Question = WebUI.getText(findTestObject('Survey-Student App Objects/QuestionFieldInSurvey'))

println(Question)
def isRadioButton = false
def isTextAreaButton = false
if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'), 2, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/FirstRadioButtonInputField'))
	isRadioButton = true
}
else
{
	WebUI.sendKeys(findTestObject('Object Repository/Survey-Student App Objects/TextAreaInSurveyQuestion'), "test")
	isTextAreaButton = true
}

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Student App Objects/SkipButton'), 2, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/SkipButton'))
}
else
{
	WebUI.click(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'))
}

WebUI.navigateToUrl(GlobalVariable.StudentAppUrl+GlobalVariable.Institution+"/surv/"+surveyCode)

WebUI.waitForElementPresent(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), 0)

String questionAfterReloading = WebUI.getText(findTestObject('Survey-Student App Objects/QuestionFieldInSurvey'))

println(questionAfterReloading)

if(questionAfterReloading!=Question)
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("After completing a question if Student reloads the page then first question is not shown")
}

if(isRadioButton)
{
	if(!(WebUI.verifyElementNotChecked(findTestObject('Survey-Student App Objects/FirstRadioButtonInputField'), 0, FailureHandling.OPTIONAL)))
	{
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop("If Student bounces from survey after completing one survey question and again navigate to the same survey link then the previous answers are still shown")
	}
}


/*
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/FirstRadioButtonInSurveyQuestion'),
 'Radio button is not present for the first question')
 WebUI.click(findTestObject('Survey-Student App Objects/FirstRadioButtonInSurveyQuestion'))
 TestObject SurveyQuestion = new TestObject('Survey question')
 SurveyQuestion.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'survey-question-title\' and text()=\'' + Question) +
 '\']')
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(SurveyQuestion, 'After answering the question the the question the next question is not shown')
 SurveyUrl = WebUI.getUrl()
 WebUI.navigateToUrl(SurveyUrl)
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(SurveyQuestion, 'If Student bounces from survey after completing one survey question and again navigate to the same survey link then the answered question is not shown')
 if(!(WebUI.verifyElementNotChecked(findTestObject('Survey-Student App Objects/FirstRadioButtonInputField'), 0, FailureHandling.OPTIONAL)))
 {
 WebUI.takeScreenshot()
 KeywordUtil.markFailedAndStop("If Student bounces from survey after completing one survey question and again navigate to the same survey link then the previous answers are still shown")
 }
 */









