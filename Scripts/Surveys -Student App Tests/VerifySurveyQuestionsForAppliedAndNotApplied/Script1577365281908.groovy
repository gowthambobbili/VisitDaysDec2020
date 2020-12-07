import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

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

def  surveyCode = CustomKeywords.'com.CommonUtilities.ApiCalls.registerIndividual'(["visitId":visitId, "visitTypeId":visitTypeId]).get(surveyCode)

println surveyCode

WebUI.navigateToUrl(GlobalVariable.StudentAppUrl+GlobalVariable.Institution+"/surv/"+surveyCode)

WebUI.waitForElementPresent(findTestObject('Object Repository/Survey-Student App Objects/NextButtonInSurveyPage'), 0)

CustomKeywords.'com.CommonUtilities.SurveyMethods.verifyQuestionPresentInSurvey'("How likely are you to enroll?")







