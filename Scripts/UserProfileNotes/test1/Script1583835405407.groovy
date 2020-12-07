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

def visitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(visitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(visitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

def studentName = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

println studentName

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegisteredStudent(Name)', ["Name":studentName]))

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/UserProfile/NotesTab'), "notes tab is not shown in the user profile")
//
//WebUI.click(findTestObject('Object Repository/UserProfile/NotesTab'))
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/UserProfile/NotesTextArea'), "notes text area is not present in notes tab of user profile")
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/UserProfile/EmptyStateInNotes'), "whwn no note is added the empty state was not shown")
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotClickable'(findTestObject('Object Repository/UserProfile/SaveButtonInDetailsTab'),"save button is clicking when no data is entered in to text box")
//
//WebUI.setText(findTestObject('Object Repository/UserProfile/NotesTextArea'),"entering some data into text field")
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/UserProfile/SaveButtonInDetailsTab'),"save button is not clicked even also entered the data in text box")

WebUI.setViewPortSize(375,812)

WebUI.click(findTestObject('Object Repository/UserProfile/DetailsTabInUserProfile'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/UserProfile/EditButtonInDetailsTab'),"edit button is clickable when opening user details tab")

WebUI.click(findTestObject('Object Repository/UserProfile/EditButtonInDetailsTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/UserProfile/SaveButtonInDetailsTab'),"save button is clickable when the notes is not edited")

WebUI.setText(findTestObject('Object Repository/UserProfile/FirstNameTextBoxInDetailsTab') ,"testname")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/UserProfile/SaveButtonInDetailsTab'),"save button is clickable when the notes is edited")

WebUI.click(findTestObject('Object Repository/UserProfile/SaveButtonInDetailsTab'))



