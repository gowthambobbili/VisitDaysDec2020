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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

def visitType1Detail = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()

def visitType = visitType1Detail.visitType

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/MobiPage/Questions/AddQuestionButton'), "Add Question button is not present in the Mobi-questions page")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/AddQuestionButton'))

CustomKeywords.'com.CommonUtilities.AddQuestion.verifyAddQuestionPageElements'()

def questionName = CustomKeywords.'com.CommonUtilities.AddQuestion.getRandomQuestionName'()

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/QuestionTypeDropdown'))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/ListOptionInQuestionTypeDropdown'))

def numberOfChoices = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/ListChoises'), 0).size()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/MobiPage/Questions/AddAnswerChoicesButton'), "Add Answer Choices button is not shown in the Add Question page")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/AddAnswerChoicesButton'))

def numberOfChoicesAfterAddingOne = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/ListChoises'), 0).size()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(numberOfChoicesAfterAddingOne.toString(), (numberOfChoices+1).toString(), "When click Add Answer choice button the option is not added")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SaveButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/QuestionNameErrorField'), "When No data entered in Question name field and click Save button, the Required error message is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/AudienceErrorField'), "When No data entered in Audience field and click Save button, the Required error message is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/VisitTypeErrorField'), "When No data entered in Visit type field and click Save button, the Required error message is not shown")

def numberOfErrorsOfChoices = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/AnswerChoicesErrorField'), 0).size()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(numberOfErrorsOfChoices.toString(), numberOfChoicesAfterAddingOne.toString(), "When click Save button without entering data in Choices the Required validation error is not shown for all the choices")

WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/QuestionNameTextBox'), questionName)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/QuestionNameErrorField'), "When Enter data in Question name field the Required error message is still shown")

WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/ListChoise(index)', ["index":'1']), "First")

WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/ListChoise(index)', ["index":'2']), "Second")

WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/ListChoise(index)', ["index":'3']), "third")

def numberOfErrorsafterEnteringData = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/AnswerChoicesErrorField'), 0).size()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(numberOfErrorsafterEnteringData.toString(), "0", "When enter data in all list choices the Required validation error is still shown")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/AllOptionInAudience'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/AudienceErrorField'), "When Enter data in Audience field the Required error message is still shown")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SpecificVisitTypeRadioButton'))

WebUI.delay(3)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/VisitTypesPanel'), "When click Specific visit type radio button, the visit type are not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/VisitTypeInSpecificVisitTypes(visittype)', ["visittype":visitType]), "The visit type "+visitType+" is not shown when select the specific visit type radio button")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/VisitTypeInSpecificVisitTypes(visittype)', ["visittype":visitType]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/VisitTypeErrorField'), "When Enter data in visit type field the Required error message is still shown")


