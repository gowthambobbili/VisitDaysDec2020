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

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('VisitTypesPage/AddAQuestionButtonInQuestion'),
		'Questions page is not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('VisitTypesPage/Questions/AccessibilityNeedQuestionInQuestionsList'),
		'Do have accessibility need question is not shown in the questions list in Questions page')

WebUI.click(findTestObject('VisitTypesPage/Questions/AccessibilityNeedQuestionInQuestionsList'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('VisitTypesPage/Questions/SearchBoxInUpdateQuestionsPage'),
		'Accessibility Need question is not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('VisitTypesPage/UpdateButtonInQuestions'),
		'\'Update\' button is present in \'Do you have an accessibility need?\' question')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('VisitTypesPage/Questions/MandetoryQuestionMessageInQuestionsPage'),
		'"This question is required for all visit types" message is not shown for individual accessibility question')

WebUI.click(findTestObject('VisitTypesPage/QuestionsOption'))

WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddAQuestionButtonInQuestion'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('VisitTypesPage/Questions/GroupRadioButtonInQuestions'),
		'Groupradio button is not present in Questions page')

WebUI.click(findTestObject('VisitTypesPage/Questions/GroupRadioButtonInQuestions'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('VisitTypesPage/Questions/GroupAccessibilityNeedQuestionIQuestionsPage'),
		'\'Does any guest have an accessibility need?\' questions is not present in Group questions page')

WebUI.click(findTestObject('VisitTypesPage/Questions/GroupAccessibilityNeedQuestionIQuestionsPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('VisitTypesPage/Questions/SearchBoxInUpdateQuestionsPage'),
		'Group accessibility Need question is not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('VisitTypesPage/UpdateButtonInQuestions'),
		'\'Update\' button is present in \'Does any guest have an accessibility need?\' question')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('VisitTypesPage/Questions/MandetoryQuestionMessageInQuestionsPage'),
		'"This question is required for all visit types" message is not shown for Group accessibility question')

