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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/SurveyLeftNav'),
		'Survey left nav is not present in the home page')

WebUI.click(findTestObject('HomePageElements/SurveyLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/ResponseTab'),
		'Responses secondary nav is not present in Survey page')

WebUI.click(findTestObject('Survey-Admin App Objects/ResponseTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/Response Page/DateRangeFilter'),
		'Date Range filter is not present in the Survey-Responses page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/Response Page/VisitTypeFilter'),
		'Visit Type filter is not present in the Survey-Responses page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/Response Page/EntryYearFilter'),
		'Entry Year filter is not present in the Survey-Responses page')

WebUI.click(findTestObject('Survey-Admin App Objects/Response Page/DateRangeFilter'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'),
		'In the date picker the today short cut is not present ')

WebUI.click(findTestObject('Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'))

//String TodayDate = CustomKeywords.'com.CommonUtilities.Times.GetDateInRequiredFormat'("MMM d, yyyy")

String EndDate = CustomKeywords.'com.CommonUtilities.Times.AddOrSubtractDatesAndReturnInreequiredFormat'(-7, "MMM d, yyyy")

String DateBefore7Ddays = CustomKeywords.'com.CommonUtilities.Times.AddOrSubtractDatesAndReturnInreequiredFormat'(-8, "MMM d, yyyy")

String FinalDate = DateBefore7Ddays+" - "+EndDate

String ActualStartDate = WebUI.getAttribute(findTestObject('Survey-Admin App Objects/Response Page/startAndEndDateAttributes'), "start")

String ActualEndDate = WebUI.getAttribute(findTestObject('Survey-Admin App Objects/Response Page/startAndEndDateAttributes'), "end")

ActualStartDate = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.formatStringDate'(ActualStartDate, "yyyy-MM-dd", "MMM d, yyyy")

ActualEndDate = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.formatStringDate'(ActualEndDate, "yyyy-MM-dd", "MMM d, yyyy")

String ActualDateRange = ActualStartDate+" - "+ActualEndDate

String ExpectedDate = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null, "MMM d, yyyy")

ExpectedDaterange = ExpectedDate+' - '+ExpectedDate

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ActualDateRange, ExpectedDaterange, "In the Responses page date picker, when click the Today shortcut button then tnhe current date is not selected in the calendar. Actual Date range: "+ActualDateRange+", +Expected Date range: "+ExpectedDaterange)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/EntryYearFilter'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/FirstYearInEntryYearDropDown'), "The dropdown elements are not present in the Entry year dropdown")

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/FirstYearInEntryYearDropDown'))

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/VisitTypeFilter'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/FirstVisittypeInVisitTypeDropDown'), 0, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/FirstVisittypeInVisitTypeDropDown'))
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ResetFiltersButton'), "When applied filters in responses page, the Reset Filters  button is not shown")

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ResetFiltersButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ResetFiltersButton'), "When click Reset filteres button in Responses page, the button ios not getting hidden")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/AllPlaceHolderInEntryYearFilter'), "When click the Reset Filters button in responses page the Entry Year is not reset to 'All'")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/AllVisitTypesPlaceHolderInVisitTypesFilter'), "When click the Reset Filters button in responses page the Visit Types filter is not reset to 'All Visit Types'")

String ActualStartDateAfterResettingFilters = WebUI.getAttribute(findTestObject('Survey-Admin App Objects/Response Page/startAndEndDateAttributes'), "start")

String ActualEndDateAfterResettingFilters= WebUI.getAttribute(findTestObject('Survey-Admin App Objects/Response Page/startAndEndDateAttributes'), "end")

String ActualDateRangeAfterResettingFilteres = ActualStartDateAfterResettingFilters+' - '+ActualEndDateAfterResettingFilters

String CurrentDate = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null, "yyyy-MM-dd")

String ExpectedEndDateAfterResettingFilters = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.addDays'(CurrentDate, "yyyy-MM-dd",-1)

String ExpectedStartDateAfterResettingFilters = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.addDays'(CurrentDate, "yyyy-MM-dd",-8)

String ExpectedDateRangeAfterResettingFilters = ExpectedStartDateAfterResettingFilters+' - '+ExpectedEndDateAfterResettingFilters

println ExpectedDateRangeAfterResettingFilters

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ActualDateRangeAfterResettingFilteres, ExpectedDateRangeAfterResettingFilters, "In the Responses page, when click the Reset filteres button the current Date range filter is not getting updated to past 7days. Actual Date range: "+ActualDateRangeAfterResettingFilteres+", +Expected Date range: "+ExpectedDateRangeAfterResettingFilters)
