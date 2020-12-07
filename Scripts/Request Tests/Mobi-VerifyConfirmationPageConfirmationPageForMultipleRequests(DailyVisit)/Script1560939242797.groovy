import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW


CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String RequestVisitType1 = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(RequestVisitType1)

String RequestVisitType2 = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(RequestVisitType2)

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/IframeOfMobi'), "When click Schedule visit button on the Mobi url, the mobi is not shown")

List VisitTypes = [RequestVisitType1, RequestVisitType2]

CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'(VisitTypes, findTestObject('Object Repository/Add Attendee/DailyVisitsOptionInAddAttendee'))

List VisitsWithRegistrationMethod = [RequestVisitType1+"-r", RequestVisitType2+"-r"]

def VerifyConfirmationPageVisitName=WebUI.getText(findTestObject('Object Repository/Add Attendee/ConfirmationPageTestVisitDetails'))

WebUI.verifyMatch(RequestVisitType1, VerifyConfirmationPageVisitName, false, FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'com.CommonUtilities.ConfirmationPage.confirmationPageTest'(VisitsWithRegistrationMethod, "multiple request visits(2)", 2, 0)

