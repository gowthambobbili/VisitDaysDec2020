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

def StudentDetails = WebUI.callTestCase(findTestCase('API Testcases/RegisterAUserAndGetSurveyCode'), [('SurveyLink') : 'https://metapod-student.visitdays.com/bbtesting/surv/\r\n'],
FailureHandling.STOP_ON_FAILURE)

String StudentName = StudentDetails.get("StudentName")

String CurrentUrl = StudentDetails.get("CurrentUrl")

String VisitType = StudentDetails.get("VisitType")

println StudentName

println CurrentUrl

def TextAreaQuestionsResponses = CustomKeywords.'com.CommonUtilities.SurveyMethods.CompleteSurveyAndReturnTheListOfTextAreaQuestions'()

def TextAreaQuestionsQuestions = TextAreaQuestionsResponses.keySet()

WebUI.navigateToUrl(CurrentUrl)

WebUI.click(findTestObject('HomePageElements/SurveyLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Admin App Objects/ResponseTab'),
		"Responses tab is  not present in the Surveys page")

WebUI.click(findTestObject('Survey-Admin App Objects/ResponseTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/VisitTypeFilter'), "Visit type filter is not present in the Responses page")

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/VisitTypeFilter'))

WebUI.click(findTestObject('Survey-Admin App Objects/Response Page/VisitTypeInVisitTypeFilter(Variable)', ["VisitType":VisitType]))

NumberOfTextAreaQuestions = TextAreaQuestionsQuestions.size()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/QuestionInResponsesPage(variable)', ["Question":TextAreaQuestionsQuestions.getAt(1)]), "When Loaded the Survey-Responses, the default filters includes current day's itineraries")

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/DateRangeFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), 0)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TodayShortCutInDatePicker'), "When click Today shortcut button in the calendar the calendar is not getting closed")

String TimeStamp = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null, "MMM dd, yyyy")

String CompletionRate

String TotalResponses

WebUI.delay(3)

for(int i=0;i<NumberOfTextAreaQuestions;i++)
{
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/QuestionInResponsesPage(variable)', ["Question":TextAreaQuestionsQuestions.getAt(i)]), "The text input question which was answered in survey is not shown in responses page")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/RegisteredInstitutionUserNameOnTextAreaResponse(variable)', ["Question":TextAreaQuestionsQuestions.getAt(i), "Visitor":StudentName]), "Name of the institution user is not shown on the text area response cards")
	println TextAreaQuestionsResponses.get(TextAreaQuestionsQuestions.getAt(i))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TextResponse(variable)', ["Question":TextAreaQuestionsQuestions.getAt(i), "Response":TextAreaQuestionsResponses.get(TextAreaQuestionsQuestions.getAt(i))]), "Text area response is not shown in the responses page")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TimeStampOnTextAreaResponse(variable)', ["Question":TextAreaQuestionsQuestions.getAt(i), "Date":TimeStamp]), "The itinerary Date shows incorrect on the text area response card")

	CompletionRate = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/CompletionRateOfTextResponses(variable)', ["Question":TextAreaQuestionsQuestions.getAt(i)]))
	println CompletionRate
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(CompletionRate, "Completion Rate: 100%", "The  completion rate on text response card is shown incorrect")
	TotalResponses = WebUI.getText(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/TotalResponsesOfTextResponse(variable)', ["Question":TextAreaQuestionsQuestions.getAt(i)]))
	println TotalResponses
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(TotalResponses, "Total Responses: 1", "The  Total responses on text response card is shown incorrect")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ViewDetailsButtonOnSpecificTextResponse', ["Question":TextAreaQuestionsQuestions.getAt(i)]), "View Details button is not present on the text area response  card")
}

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ViewDetailsButtonOnSpecificTextResponse', ["Question":TextAreaQuestionsQuestions.getAt(0)]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ViewDetailsButtonOnSpecificTextResponse', ["Question":TextAreaQuestionsQuestions.getAt(0)]), "When click View Details button, the expanded view is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/VisitTypeFilter'), "When click View Details button, the expanded view is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/AllAnswers(1)TabInTextResponsesExpandedView'), "In the expanded view of text area responses, the All Answers tab is not present")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ContactButton'), "In the expanded view of text area responses, the Contact button is not present")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ViewProfileButton'), "In the expanded view of text area responses, the Contact button is not present")

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/ViewProfileButton'))

WebUI.delay(3)

String UserNameInUserProfile = WebUI.getText(findTestObject('Object Repository/UserProfile/StudentNameInUserProfile'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('UserProfile/OffsetFromUserprofile'), "When click View Profile button in the expanded view of Text area response, the profile is not opened")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(UserNameInUserProfile, StudentName, "When click the View Profile button in the expanded view of Text response, incorrect user profile is shown")

WebUI.clickOffset(findTestObject('UserProfile/OffsetFromUserprofile'), 10, 10)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/CloseButtonInExpandedViewOfTextResponse'), "The close button is not present in the expanded view of text response")

WebUI.waitForElementVisible(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/CloseButtonInExpandedViewOfTextResponse'), 0)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/CloseButtonInExpandedViewOfTextResponse'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Response Page/CloseButtonInExpandedViewOfTextResponse'), "When click close button in the exppanded view of text area response,it's not getting closed")












