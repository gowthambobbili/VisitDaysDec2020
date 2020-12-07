import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
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

WebUI.click(findTestObject('HomePageElements/SurveyLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYieldTab'),
		'Applicants & Yield tab is not  present in the Survey page')

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYieldTab'))

def CurrentUrl = WebUI.getUrl()

def StudentDetails = WebUI.callTestCase(findTestCase('API Testcases/RegisterAUserAndGetSurveyCode'), [('SurveyLink') : 'https://metapod-student.visitdays.com/bbtesting/surv/\r\n'],
FailureHandling.STOP_ON_FAILURE)

def VisitType = StudentDetails.get('VisitType')

CustomKeywords.'com.CommonUtilities.SurveyMethods.CompleteSurveyAndReturnTheListOfTextAreaQuestions'()

WebUI.navigateToUrl(CurrentUrl)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AllReadyAppliedTab'),
		'AllReady Applied tab is not present in the Applicants&Yield page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/HaventAppliedTab'),
		'Haven\'t Applied tab is not present in the Applicants & Yield page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/HaventAppliedTab'),
		'Haven\'t Applied tab is not present in the Applicants & Yield page')

//WebUI.click(findTestObject('Survey-Admin App Objects/ApplicantsAndYield/HaventAppliedTab'))

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/DateRangeFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), 0)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), "When click Today shortcut button in the calendar the calendar is not getting closed")


WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/VisitTypeFilter'))

WebUI.click(findTestObject('Survey-Admin App Objects/Response Page/VisitTypeInVisitTypeFilter(Variable)', [('VisitType') : VisitType]))

def AlreadyAppliedCount = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AlreadyAppliedCount')).trim()

println AlreadyAppliedCount

def CompletionRate = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/CompletionRateAndTotalSurveysCount')).trim()

println CompletionRate

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(AlreadyAppliedCount, "1 (100%)", "The count of Already Appllied In Applicants&Yield page is shown in correct, Expected: 1 (100%), Actual: "+AlreadyAppliedCount)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(CompletionRate, "Completion Rate: 100.00%\nTotal Surveys: 1", "The count of Completion Rate and Total surveys In Applicants&Yield page is shown incorrect, Expected: Completion Rate: 100.00%\nTotal Surveys: 1, Actual: "+CompletionRate)





