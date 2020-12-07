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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//import java.awt.geom.Arc2D.Float
import java.text.DecimalFormat

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/SurveyLeftNav'),
		'Surveys left nav is not present in home page')

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToSurveySummaryPage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/7DaysTab'),
		'In Surveys summary page the 7 Days tab is not present')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/30DaysTab'),
		'In Surveys summary page the 30 Days tab is not present')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/12MonthsTab'),
		'In Surveys summary page the 12 Months tab is not present')

def SurveysSummaryPageUrl = WebUI.getUrl()

WebUI.waitForPageLoad(0)

def NumberOfSurveysCompletedIn7Days
def SurveyResposeRate7Days

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/EmptyStateObject'), 5, FailureHandling.OPTIONAL)||(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))=='-')) {
	NumberOfSurveysCompletedIn7Days = '0'
	SurveyResposeRate7Days = '0%'
} else {
	if(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))=='-')
	{
		NumberOfSurveysCompletedIn7Days = '0'
	}
	else
	{
		NumberOfSurveysCompletedIn7Days = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys')))
	}

	if(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))=='-')
	{
		SurveyResposeRate7Days = '0%'
	}
	else
	{
		SurveyResposeRate7Days = Float.parseFloat((WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))).split('%')[0])
	}

	println SurveyResposeRate7Days
}

WebUI.click(findTestObject('Survey-Admin App Objects/30DaysTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/30DaysSelectedState'),
		'When click on 30 Days tab, the tab is not getting selected')

def NumberOfSurveysCompletedIn30Days
def SurveyResposeRate30Days

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/EmptyStateObject'), 5, FailureHandling.OPTIONAL)||(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))=='-')) {
	NumberOfSurveysCompletedIn30Days = '0'
	SurveyResposeRate30Days = '0%'
} else {

	if(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))=='-')
	{
		NumberOfSurveysCompletedIn30Days = '0'
	}
	else
	{
		NumberOfSurveysCompletedIn30Days = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys')))
	}


	if(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))=='-')
	{
		SurveyResposeRate30Days = '0%'
	}

	else
	{
		SurveyResposeRate7Days = Float.parseFloat((WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))).split('%')[0])
	}

	println SurveyResposeRate30Days
}

WebUI.delay(2)

WebUI.click(findTestObject('Survey-Admin App Objects/12MonthsTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/12MonthsSelectedState'),
		'When click on 12 Months tab, the tab is not getting selected')

def NumberOfSurveysCompletedIn12Months
def SurveyResposeRate12Months

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/EmptyStateObject'), 5, FailureHandling.OPTIONAL)||(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))=='-')) {
	NumberOfSurveysCompletedIn12Months = '0'
	SurveyResposeRate12Months = 0
} else {

	if(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))=='-')
	{
		NumberOfSurveysCompletedIn12Months = '0'
	}
	else
	{
		NumberOfSurveysCompletedIn12Months = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys')))
	}

	if(WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))=='-')
	{
		SurveyResposeRate12Months = '0%'
	}

	else
	{
		SurveyResposeRate12Months = Float.parseFloat((WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/SurveyResponceRatePercentage'))).split('%')[0])
	}

	println SurveyResposeRate12Months
}

def VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithInprogresSameStartAndEndTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.delay(30)

def SurveyLink = CustomKeywords.'com.CommonUtilities.SurveysApi.RegisterAStudentAndReturnTheSurveyLink'()

println(SurveyLink)

WebUI.navigateToUrl(SurveyLink)

CustomKeywords.'com.CommonUtilities.SurveyMethods.CompleteSurveyAndReturnTheListOfTextAreaQuestions'()

WebUI.navigateToUrl(SurveysSummaryPageUrl)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/7DaysSelectedState'),
		'When navigated to the survey summary URL directly, the 7 Days is not getting selected by default')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'), "In the Survey-summary page, under 12months tab, current day's itineraries are shown")

WebUI.click(findTestObject('Survey-Admin App Objects/30DaysTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/30DaysSelectedState'),
		'When click on 30 Days tab, the tab is not getting selected')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'), "In the Survey-summary page, under 12months tab, current day's itineraries are shown")

WebUI.click(findTestObject('Survey-Admin App Objects/12MonthsTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/12MonthsSelectedState'),
		'When click on 12 Months tab, the tab is not getting selected')

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'), "In the Survey-summary page, under 12months tab, current day's itineraries are shown")

if(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'), 5, FailureHandling.OPTIONAL) || (WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/NumberOfCompletedSurveys'))=="0")
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("In the Survey-summary page, under 12months tab, current day's itineraries count is shown")
}







