import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Date

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
import java.text.SimpleDateFormat;

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYieldTab'), 0)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYieldTab'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/VisitTypeFilter'), 0)

def ExpectedStartDate = CustomKeywords.'com.CommonUtilities.Times.AddOrSubtractDatesAndReturnInreequiredFormat'(-8, "yyyy-MM-dd")

def ExpectedEndDate = CustomKeywords.'com.CommonUtilities.Times.AddOrSubtractDatesAndReturnInreequiredFormat'(-1, "yyyy-MM-dd")

VerifyTheDefaultDateRange(ExpectedStartDate, ExpectedEndDate, "Survey-Applicants&yield")

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/PerformanceTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AlreadyAppliedCount'), "When click Performance tab the page is not shown")

VerifyTheDefaultDateRange(ExpectedStartDate, ExpectedEndDate, "Survey-Performance")

def VerifyTheDefaultDateRange(def ExpectedStartDate, def ExpectedEndDate, def Page)
{
	String ActualStartDate = WebUI.getAttribute(findTestObject('Survey-Admin App Objects/Response Page/startAndEndDateAttributes'), "start")

	String ActualEndDate = WebUI.getAttribute(findTestObject('Survey-Admin App Objects/Response Page/startAndEndDateAttributes'), "end")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ActualStartDate, ExpectedStartDate, "In the "+Page+" page the default date range in the date filter is shown incorrect")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ActualEndDate, ExpectedEndDate, "In the "+Page+" page the default date range in the date filter is shown incorrect")
}

