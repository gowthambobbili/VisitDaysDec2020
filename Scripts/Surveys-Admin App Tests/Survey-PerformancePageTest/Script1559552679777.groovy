import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.geom.Arc2D.Float as Float
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.lang.Float as Float



CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

//WebUI.click(findTestObject('HomePageElements/SurveyLeftNav'))
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/PerformanceTopNav'),
//		'Performance top nav is not present in the Surveys page')
//
//WebUI.click(findTestObject('Survey-Student App Objects/PerformanceTopNav'))

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToSurveyPerformPage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/Performance/DateRangeFilter'),
		'Date range filter is not present in survey-performance page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/Performance/EntryYearFilter'),
		'Entry Year filter is not present in survey-performance page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/Performance/VisitTypeFilter'),
		'Visit Type filter is not present in survey-performance page')

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/DateRangeFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), 0)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), "When click Today shortcut button in the calendar the calendar is not getting closed")
def NumberOfCompletedSurveysBeforeCompletionOfSurveys

def SurveyCompletionRateBeforeCompletingSurvey

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/Performance/EmptyStateObject'), 10, FailureHandling.OPTIONAL))
{
	NumberOfCompletedSurveysBeforeCompletionOfSurveys = 0
	SurveyCompletionRateBeforeCompletingSurvey = '0%'
}
else
{
	NumberOfCompletedSurveysBeforeCompletionOfSurveys = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys')))
	if(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))=="-")
	{
		SurveyCompletionRateBeforeCompletingSurvey = '0%'
	}
	else
	{
		SurveyCompletionRateBeforeCompletingSurvey = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))
	}
}

println NumberOfCompletedSurveysBeforeCompletionOfSurveys
println SurveyCompletionRateBeforeCompletingSurvey
//def SurveyCompletionRateBeforeCompletingSurvey = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))

SurveyCompletionRateBeforeCompletingSurvey = Float.parseFloat(SurveyCompletionRateBeforeCompletingSurvey.split('%')[0])

def CurrentUrl = WebUI.getUrl()

def Details = WebUI.callTestCase(findTestCase('API Testcases/RegisterAUserAndGetSurveyCode'), [('SurveyLink') : 'https://metapod-student.visitdays.com/bbtesting/surv/\r\n'],
FailureHandling.STOP_ON_FAILURE)

def VisitType = Details.get("VisitType")

WebUI.delay(15)

CustomKeywords.'com.CommonUtilities.SurveyMethods.CompleteSurveyAndReturnTheListOfTextAreaQuestions'()

WebUI.navigateToUrl(CurrentUrl)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/DateRangeFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), 0)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), "When click Today shortcut button in the calendar the calendar is not getting closed")

def NumberOfCompletedSurveysAfterCompletionOfSurveys = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(NumberOfCompletedSurveysAfterCompletionOfSurveys, ((NumberOfCompletedSurveysBeforeCompletionOfSurveys+1)).toString(), "Number of completed surveys shown incorrect in the survey-performance page")

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/DateRangeFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), 0)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), "When click Today shortcut button in the calendar the calendar is not getting closed")

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Performance/VisitTypeFilter'))

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Performance/VisitTypeInVisitTypeFilter(VisitType)', ["VisitType":VisitType]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/EmptyStateObject'), "When filterd  with Viist type in the Performance page, the empty state shown, even if there is data to show")

def NumberOfCompletedSurveysAfterApplyingVisitTypeFilter = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(NumberOfCompletedSurveysAfterApplyingVisitTypeFilter, "1", "When applied the visit types filter, the number of completed surveys shown incorrect in the survey-performance page")

def SurveyCompletionRateAfterApplyingVisitTypeFilter = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(SurveyCompletionRateAfterApplyingVisitTypeFilter, "100%", "When applied the visit types filter, the number of completed surveys shown incorrect in the survey-performance page")





