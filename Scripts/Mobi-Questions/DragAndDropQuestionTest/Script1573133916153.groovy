import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Keys as Keys

WebUI.navigateToUrl(GlobalVariable.StagingUrl+'institutions/' +GlobalVariable.Institution+'/platform/mobi/questions')

WebUI.click(findTestObject('Object Repository/VisitTypesPage/ActiveTabInQuestions'))

WebUI.waitForElementPresent(findTestObject('Object Repository/MobiPage/Questions/QuestionCard(index)', [('index') : 1]), 0)

def numberOfQuestions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/AllQestionNames'), 0).size()

def activeQuestions = []

def activeQuestionsAfterReorder = []

def currentQuestion

def activeQuestionsToVerifyInMobi = []

for(def i=1; i<=numberOfQuestions;i++)
{
	activeQuestions.add(WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionName(index)', ["index":i])))
}

println activeQuestions

WebUI.scrollToElement(findTestObject('Object Repository/MobiPage/Questions/QuestionCard(index)', [('index') : 1]), 0)

WebUI.delay(3)

WebUI.dragAndDropToObject(findTestObject('Object Repository/MobiPage/Questions/DragAndDropIcon'), findTestObject('Object Repository/MobiPage/Questions/QuestionCard(index)',
		[('index') : 4]))


for(def i=1; i<=numberOfQuestions;i++)
{
	activeQuestionsAfterReorder.add(WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionName(index)', ["index":i])))
}


for(def i=1; i<=numberOfQuestions;i++)
{
	currentQuestion = WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionName(index)', ["index":i]))
	if(!(currentQuestion.contains("Test Question")))
		activeQuestionsToVerifyInMobi.add(currentQuestion)
}

println activeQuestionsAfterReorder

def item = activeQuestions.remove(0)

activeQuestions.add(2, item)

println activeQuestions

if(activeQuestions!=activeQuestionsAfterReorder)
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("After changing the order of question by drag and drop, questions are shown in incorrect order")
}

def visittypeDetails = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()

def visittype = visittypeDetails.visitType

def visitTypeId = visittypeDetails.get("visitTypeId")

println visitTypeId

CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitTypeId)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(visittype)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), "Add Registrant button is not present in the visit to register a student")

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

WebUI.switchToFrame(findTestObject('Object Repository/Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/IndividualOptionInMobi'), 0)

WebUI.click(findTestObject('Object Repository/Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Object Repository/Add Attendee/RegisterButtonInAddAttendee'))

def numberOfMobiQuestions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Add Attendee/MobiQuestions'), 0).size()

def mobiQuestions = []

def question

for(def j=1;j<=numberOfMobiQuestions;j++)
{
	question = WebUI.getText(findTestObject('Object Repository/Add Attendee/Mobiquestion(index)', ["index":j]))
	if(question=="Home Address")
	{
		mobiQuestions.add("Address")
		continue
	}
	if(question=="Address Line 2" || question=="Country" || question=="City/Town" || question=="State/Province" || question=="Zip")
	{
		continue
	}
	if(question.contains("(optional)"))
	{
		question = question.split("optional")[0]
		question = question.substring(0, question.length()-2)
		mobiQuestions.add(question)
	}
	else
	{
		mobiQuestions.add(question)
	}
}

println mobiQuestions

assert mobiQuestions==activeQuestionsToVerifyInMobi

WebUI.switchToDefaultContent()




