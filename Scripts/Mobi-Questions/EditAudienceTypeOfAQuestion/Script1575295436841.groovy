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

CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitType1Detail.get("visitTypeId"))

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()

WebUI.click(findTestObject('Object Repository/VisitTypesPage/ActiveTabInQuestions'))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/BothRadioButtonInQuestionsPage'))

WebUI.delay(3)

def numberOfQuestions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/QuestionTypes'), 0).size()

for(def i=1;i<=numberOfQuestions;i++)
{
	if(WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionType(index)', ["index":i])).contains("accessibility")||WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionType(index)', ["index":i])).contains("Accessibility"))
	{
		WebUI.click(findTestObject('Object Repository/MobiPage/Questions/EditButton(index)', ["index":i]))
		break
	}
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/QuestionNameTextBox'), "When click Edit button in questions list, the Question textfield is not present to edit the question")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SpecificVisitTypeRadioButton'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/VisitTypeInSpecificVisitTypes(visittype)', ["visittype":visitType]))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/IndividualOption'))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SaveButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/SaveButton'), "When click Save button after editing the question, the Save button is still shown")

WebUI.click(findTestObject('Object Repository/HomePageElements/AddAttendeeButton'))

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('Object Repository/Add Attendee/IframeOfMobi'), 0)

WebUI.click(findTestObject('Object Repository/Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))

WebUI.click(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":visitType]))

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Object Repository/Add Attendee/RegisterButtonInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), "When set the question accessibility needs to only for Individual, the question is not shown for individual")

3.times
{
	WebUI.click(findTestObject('Object Repository/Add Attendee/BackButtonInMobi'))
}

WebUI.click(findTestObject('Object Repository/Add Attendee/GroupOptionInAddAttendee'))

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

//WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))

WebUI.click(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":visitType]))
WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))
WebUI.click(findTestObject('Object Repository/Add Attendee/RegisterButtonInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), "When set the question accessibility needs to only for Individual, the question is not shown for individual")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()

//******************

WebUI.click(findTestObject('Object Repository/VisitTypesPage/ActiveTabInQuestions'))

numberOfQuestions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/QuestionTypes'), 0).size()

for(def i=1;i<=numberOfQuestions;i++)
{
	if(WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionType(index)', ["index":i])).contains("accessibility")||WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionType(index)', ["index":i])).contains("Accessibility"))
	{
		WebUI.click(findTestObject('Object Repository/MobiPage/Questions/EditButton(index)', ["index":i]))
		break
	}
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/QuestionNameTextBox'), "When click Edit button in questions list, the Question textfield is not present to edit the question")

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SpecificVisitTypeRadioButton'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/VisitTypeInSpecificVisitTypes(visittype)', ["visittype":visitType]))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/GroupsOption'))

WebUI.click(findTestObject('Object Repository/MobiPage/Questions/SaveButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/SaveButton'), "When click Save button after editing the question, the Save button is still shown")

WebUI.click(findTestObject('Object Repository/HomePageElements/AddAttendeeButton'))

WebUI.delay(5)

WebUI.switchToFrame(findTestObject('Object Repository/Add Attendee/IframeOfMobi'), 0)

WebUI.click(findTestObject('Object Repository/Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))

WebUI.click(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":visitType]))

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Object Repository/Add Attendee/RegisterButtonInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), "When set the question accessibility needs to only for Groups, the question is shown for individual")

3.times
{
	WebUI.click(findTestObject('Object Repository/Add Attendee/BackButtonInMobi'))
}

WebUI.click(findTestObject('Object Repository/Add Attendee/GroupOptionInAddAttendee'))

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

//WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))

WebUI.click(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":visitType]))
WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))
WebUI.click(findTestObject('Object Repository/Add Attendee/RegisterButtonInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), "When set the question accessibility needs to only for Groupd, the question is not shown for Groups")








