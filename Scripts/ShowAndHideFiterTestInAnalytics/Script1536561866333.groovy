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

WebUI.click(findTestObject('HomePageElements/AnalyticsLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), "When click Analytics left nav, the show filters button is not present in the page")

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), 0)

WebUI.click(findTestObject('AnalyticsPage/ShowFiltersButtonInReports'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/VisitTypeFilterDropdownInAnalytics'), 0)

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/EntryYearFilterInAnalytics'), 0)

WebUI.verifyElementPresent(findTestObject('AnalyticsPage/LocationsFilterInAnaytics'), 0)

WebUI.click(findTestObject('AnalyticsPage/HideFilterButtonInAnalytics'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('AnalyticsPage/VisitTypeFilterDropdownInAnalytics'), 0)

WebUI.verifyElementNotPresent(findTestObject('AnalyticsPage/EntryYearFilterInAnalytics'), 0)

WebUI.verifyElementNotPresent(findTestObject('AnalyticsPage/LocationsFilterInAnaytics'), 0)

