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

//Map VisitDetails = WebUI.callTestCase(findTestCase('API Testcases/RegisterAUserAndGetSurveyCode'), [('SurveyLink') : 'https://metapod-student.visitdays.com/bbtesting/surv/\r\n'],
//FailureHandling.STOP_ON_FAILURE)

GlobalVariable.temp = false

Map VisitDetails = WebUI.callTestCase(findTestCase('API Testcases/GetSurveyCodeForVisitWithhPhoneWaysToMeet'), [('SurveyLink') : 'https://metapod-student.visitdays.com/bbtesting/surv/\r\n'],
FailureHandling.STOP_ON_FAILURE)

def VisitType = VisitDetails.VisitType

def StudentName = VisitDetails.StudentName

WebUI.navigateToUrl(GlobalVariable.StudentAppUrl+GlobalVariable.Institution+"/itineraries/"+VisitDetails.SurveyCode)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/ItineraryPage/VisitType(visittype)', ["visittype":VisitType]), "When navigate to the itinerary page of the student "+StudentName+", the visit type is not shown")

WebUI.click(findTestObject('Object Repository/ItineraryPage/VisitType(visittype)', ["visittype":VisitType]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/ItineraryPage/MeetingInstructionsData'), "In the itinerary page the ways to meet data is not shown for the visit type with Phone ways to meet")

def MeetingInstructions = WebUI.getText(findTestObject('Object Repository/ItineraryPage/MeetingInstructionsData')).trim()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(MeetingInstructions, "Phone instructions", "The meeting isntructions in itinerary page are shown incorrect for a visit type with phone ways to meet. Actual: "+MeetingInstructions+", Expected: "+"Phone instructions")

def VisitDetailsUrl = WebUI.getUrl()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToVisitTypes'()

WebUI.click(findTestObject('Object Repository/VisitTypesPage/RequiredVisitType(VisitType)', ["VisitType":VisitType]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/VisitTypesPage/DetailsTabInVisitTypes'), "Details tab is not shown when click on a visit type in Visit types page")

WebUI.click(findTestObject('Object Repository/VisitTypesPage/DetailsTabInVisitTypes'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/VisitTypesPage/VisitTypesSummaryPage/EditButtonInWaysToMeetFieldInSummaryPage'), "In the visit type details pahe, Edit button is not present for ways to meet")

WebUI.scrollToElement(findTestObject('Object Repository/VisitTypesPage/VisitTypesSummaryPage/EditButtonInWaysToMeetFieldInSummaryPage'), 0)

WebUI.click(findTestObject('Object Repository/VisitTypesPage/VisitTypesSummaryPage/EditButtonInWaysToMeetFieldInSummaryPage'))

WebUI.scrollToElement(findTestObject('Object Repository/VisitTypesPage/PhoneCheckbox'), 0)

WebUI.click(findTestObject('Object Repository/VisitTypesPage/PhoneCheckbox'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/VisitTypesPage/PhonewaysToMeetDescription'), "When uncheck the Phone checkbox, the phone textbox is not getting hidden")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/VisitTypesPage/OnlineCheckbox'), "While editing a visit type, Online checkbox is not present in the ways to meet divisio")

WebUI.click(findTestObject('Object Repository/VisitTypesPage/OnlineCheckbox'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/VisitTypesPage/OnlineWaysToMeetDescriptionTextfield'), "While editing a visit type in details page, when click Online checkbox, the textbox is not shown")

WebUI.sendKeys(findTestObject('Object Repository/VisitTypesPage/OnlineWaysToMeetDescriptionTextfield'), "Online instructions")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), "Save button is not shown while editing the ways to meet of visit type in the details page")

WebUI.click(findTestObject('Object Repository/VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), "After editing ways to meet in visit type details page, and clicking save button the save button is not getting hidden and the changes are not getting saved")

WebUI.navigateToUrl(VisitDetailsUrl)

WebUI.waitForPageLoad(20)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/ItineraryPage/MeetingInstructionsData'), "In the itinerary page the ways to meet data is not shown for the visit type with Online ways to meet")

MeetingInstructions = WebUI.getText(findTestObject('Object Repository/ItineraryPage/MeetingInstructionsData')).trim()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(MeetingInstructions, "Online instructions", "The meeting isntructions in itinerary page are shown incorrect for a visit type with phone ways to meet. Actual: "+MeetingInstructions+", Expected: "+"Phone instructions")



//def VisitDetails = CustomKeywords.'com.CommonUtilities.ApiCalls.GetItineraryIdOfstudentRegisteredToAvisit'('1811613')
//
//def SurveyCode = CustomKeywords.'com.CommonUtilities.ApiCalls.GetSurveyCode'(VisitDetails)
//
//println SurveyCode














