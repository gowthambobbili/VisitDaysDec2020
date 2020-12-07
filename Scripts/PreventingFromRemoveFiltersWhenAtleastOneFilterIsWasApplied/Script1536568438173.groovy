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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/AnalyticsLeftNav'))

//WebUI.verifyElementPresent(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), 0)
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), "When click Analytics lef nav, the shown filters button is not present in the analytics page")

WebUI.click(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'))

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/VisitTypeFilterDropdownInAnalytics'), 0)

WebUI.click(findTestObject('AnalyticsPage/VisitTypeFilterDropdownInAnalytics'))

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/FirstVisitTypeInVisitTypeFilterInAnalytics'), 0)

WebUI.click(findTestObject('AnalyticsPage/FirstVisitTypeInVisitTypeFilterInAnalytics'))

WebUI.verifyElementNotPresent(findTestObject('AnalyticsPage/HideFilterButtonInAnalytics'), 0)

if(!(WebUI.verifyElementPresent(findTestObject('AnalyticsPage/ClearFilterButtonInAnalytics'), 0, FailureHandling.OPTIONAL)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("Clear Filter buuuton is not present in Analtics page")
}

WebUI.click(findTestObject('AnalyticsPage/ClearFilterButtonInAnalytics'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), 0)

WebUI.click(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AnalyticsPage/EntryYearFilterInAnalytics'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AnalyticsPage/FirstVisitTypeInVisitTypeFilterInAnalytics'))

WebUI.verifyElementNotPresent(findTestObject('AnalyticsPage/HideFilterButtonInAnalytics'), 0)

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/ClearFilterButtonInAnalytics'), 0)

WebUI.click(findTestObject('AnalyticsPage/ClearFilterButtonInAnalytics'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), 0)

WebUI.click(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AnalyticsPage/LocationsFilterInAnaytics'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AnalyticsPage/FirstVisitTypeInVisitTypeFilterInAnalytics'))

WebUI.verifyElementNotPresent(findTestObject('AnalyticsPage/HideFilterButtonInAnalytics'), 0)

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/ClearFilterButtonInAnalytics'), 0)

