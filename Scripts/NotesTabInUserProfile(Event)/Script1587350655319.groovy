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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithKeywordCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateEventWithInprogressTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'),
		"Add registrant button([+]) is not present in the daily visit page")

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Student = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

WebUI.click(findTestObject('Object Repository/CreateSession/RegistrantsListtab'))

WebUI.click(findTestObject('Object Repository/UserProfile/NotesTab'))

WebUI.click(findTestObject('Object Repository/UserProfile/EditButtonInNotesTabInUserProfile'))

WebUI.sendKeys(findTestObject('Object Repository/UserProfile/TextAreaInNotesTabInUserProfile'),'this is text area in noters tab')

WebUI.click(findTestObject('Object Repository/UserProfile/SaveButtonInNotesTab'))

WebUI.click(findTestObject('Object Repository/UserProfile/EditButtonInNotesTabInUserProfile'))

WebUI.clearText(findTestObject('Object Repository/UserProfile/TextAreaInNotesTabInUserProfile'), FailureHandling.STOP_ON_FAILURE)

//WebUI.clearText(findTestObject('Object Repository/UserProfile/TextAreaInNotesTabInUserProfile'))

WebUI.sendKeys(findTestObject('Object Repository/UserProfile/TextAreaInNotesTabInUserProfile'),'this is text area in noters tab with new description')

WebUI.click(findTestObject('Object Repository/UserProfile/SaveButtonInNotesTab'))
