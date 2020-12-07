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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/SurveyLeftNav'),
		'Surveys left nav is not present in the home page')

WebUI.click(findTestObject('HomePageElements/SurveyLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/ConfigurationNav'),
		'Questions nav is not present in the home page')

WebUI.click(findTestObject('Survey-Admin App Objects/ConfigurationNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/AddQuestionButton'), "In Survey-Questions page, the Add Question button is not present")

WebUI.delay(3)

def questionCards = WebUI.findWebElements(findTestObject('Object Repository/Survey-Admin App Objects/QuestionPage1/QuestionCradsCount'),0)


def questionNames = WebUI.findWebElements(findTestObject('Object Repository/Survey-Admin App Objects/QuestionPage1/Questions'),0)
	
def editButtons=WebUI.findWebElements(findTestObject('Object Repository/Survey-Admin App Objects/QuestionPage1/editButton'),0)

def dragIcon=WebUI.findWebElements(findTestObject('Object Repository/Survey-Admin App Objects/QuestionPage1/dragIcon'),0)

def questionType=WebUI.findWebElements(findTestObject('Object Repository/Survey-Admin App Objects/QuestionPage1/questionType'),0)

def questionCardsCount=questionCards.size()

def questionNamesCount=questionNames.size()

def editButtonsCount=editButtons.size()

def dragIconCount=dragIcon.size()

def questionTypeCount=questionType.size()

println "editButtoncount"+editButtonsCount
println "DragIconCount"+dragIconCount
println "questionTypeCount"+questionTypeCount
println "quesCardscount"+questionCardsCount
println "questionNames"+questionNames
if((questionCardsCount!=questionNamesCount))
{
	fail("Question name is not shown on survey question cards")
}
if((questionCardsCount!=editButtonsCount))
{
	fail("edit button is not shown on survey question cards")
}
if((questionCardsCount!=dragIconCount))
{
	fail("drag icon is not shown on survey question cards")
}
if((questionCardsCount!=questionTypeCount))
{
	fail("question type is not shown on survey question cards")
}





def fail(String failureDescription)
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailed(failureDescription)
}








/*
 WebUI.delay(3)
 SummaryPageUrl = WebUI.getUrl()
 if (!(SummaryPageUrl.endsWith(ConfigurationPageUrlEndPoint))) {
 WebUI.takeScreenshot()
 KeywordUtil.markFailedAndStop('When click the Configuration tab then the page is not getting opened')
 }
 //CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/AddAQuestionButtonInSurveyPage'),
 //		'Add Question button is not present in the Surveys Configuration page')
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/HowLikelyAreYouToApply/HowLikelyAreYouToApplyQuestionLabel'),
 'The active question is not present in the survey configuration page')
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/HowLikelyAreYouToApply/IncludedInLabel'),
 'Included In: label is not shown on the active questions in survey configuration page')
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/HowLikelyAreYouToApply/AllVisitTypesLabelOnHowLikelyAreYouToApplyQuestion'),
 'All Visit types label is not shown on the question - How many Guests?')
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/HowLikelyAreYouToApply/QuestionType'),
 'Question type is not shown on the active question in survey configuration page')
 //CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Student App Objects/HowLikelyAreYouToApply/QuestionAttributes'),
 //		'Question attributes are not shown on the active question in survey configuration page')
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/Configuration page/PreviewAsButton'),
 "The Preview As button is present in survey-configuration page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/Configuration page/UpdateCoverPhotoButton'),
 "The Upload Cover Photo button is present in the survey-configuration page")
 */
