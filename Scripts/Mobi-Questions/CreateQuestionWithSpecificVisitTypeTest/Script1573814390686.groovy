import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
//
//
//def visitType1Detail = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()
//
//def visitType1 = visitType1Detail.visitType
//
//def visitType1Id = visitType1Detail.visitTypeId
//
//def visitType2Detail = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()
//
//def visitType2 = visitType2Detail.visitType
//
//def visitType2Id = visitType2Detail.visitTypeId
//
//CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitType1Id)
//
//CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitType2Id)
//
//CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()
//
//CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/MobiPage/Questions/AddQuestionButton'), "Add Question button is not present in the Mobi-questions page")
//
//WebUI.click(findTestObject('Object Repository/MobiPage/Questions/AddQuestionButton'))
//
//CustomKeywords.'com.CommonUtilities.AddQuestion.verifyAddQuestionPageElements'()
//
//def questionName = CustomKeywords.'com.CommonUtilities.AddQuestion.getRandomQuestionName'()
//
//WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/QuestionNameTextBox'), questionName)
//
//WebUI.click(findTestObject('Object Repository/MobiPage/Questions/QuestionTypeDropdown'))
//
//WebUI.click(findTestObject('Object Repository/MobiPage/Questions/TextOptionInQuestionTypeDropdown'))
//
//WebUI.click(findTestObject('Object Repository/MobiPage/Questions/AllOptionInAudience'))
//
//WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SpecificVisitTypeRadioButton'))
//WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SpecificVisitTypeRadioButton'))
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/MobiPage/Questions/VisitTypesPanel'), "When click Specific visit type radio button, the visit type are not shown")
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/MobiPage/Questions/VisitTypeInSpecificVisitTypes(visittype)', ["visittype":visitType1]), "The visit type "+visitType1+" is not shown when select the specific visit type radio button")
//
//WebUI.click(findTestObject('Object Repository/MobiPage/Questions/VisitTypeInSpecificVisitTypes(visittype)', ["visittype":visitType1]))
//
//WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SaveButton'))
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/SneakBar'), "When click Save button in the Add question page thne confirmation sneak bar is not shown")


def visitType1Detail = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()

def visitType1 = visitType1Detail.visitType

def visitTypeId1 = visitType1Detail.get("visitTypeId")

println visitTypeId1

CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitTypeId1)

def visitType2Detail = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()

def visitType2 = visitType2Detail.visitType

def visitTypeId2 = visitType2Detail.get("visitTypeId")

println visitTypeId2

CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitTypeId2)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/MobiPage/Questions/AddQuestionButton'), "Add Question button is not present in the Mobi-questions page")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/AddQuestionButton'))

CustomKeywords.'com.CommonUtilities.AddQuestion.verifyAddQuestionPageElements'()

def questionName = CustomKeywords.'com.CommonUtilities.AddQuestion.getRandomQuestionName'()

WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/QuestionNameTextBox'), questionName)

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/QuestionTypeDropdown'))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/ListOptionInQuestionTypeDropdown'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/ListChoises'), "For list question the choices are not shown")

WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/ListChoise(index)', ["index":'1']), "First")

WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/ListChoise(index)', ["index":'2']), "Second")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/AllOptionInAudience'))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SpecificVisitTypeRadioButton'))

WebUI.delay(3)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/VisitTypesPanel'), "When click Specific visit type radio button, the visit type are not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/VisitTypeInSpecificVisitTypes(visittype)', ["visittype":visitType1]), "The visit type "+visitType1+" is not shown when select the specific visit type radio button")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/VisitTypeInSpecificVisitTypes(visittype)', ["visittype":visitType1]))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SaveButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/SneakBar'), "When click Save button in the Add question page thne confirmation sneak bar is not shown")

WebUI.click(findTestObject('Object Repository/VisitTypesPage/ActiveTabInQuestions'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/QuestionInList(question)', ["question":questionName]), "The created List type question is not shown in the active questions tab")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(visitType1)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), "Add Registrant button is not present in the visit to register a student")

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

CustomKeywords.'com.CommonUtilities.NewMobiRegistration.gotoQuestionsPageInMobi'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/Add Attendee/DropdownOfQuestion(question)', ["question":questionName]), "The newly created List question is not present in the Mobi")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(visitType2)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), "Add Registrant button is not present in the visit to register a student")

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

CustomKeywords.'com.CommonUtilities.NewMobiRegistration.gotoQuestionsPageInMobi'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/DropdownOfQuestion(question)', ["question":questionName]), "The List question created for a specific visit type was shown for a visit other than the selected visit type")


