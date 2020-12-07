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


def visitType1Detail = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()

def visitType = visitType1Detail.visitType

def visitTypeId = visitType1Detail.get("visitTypeId")

println visitTypeId

CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitTypeId)

CustomKeywords.'com.CommonUtilities.MobiInstance.goToMobiScriptPage'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickCreateButton'()

def displayName = CustomKeywords.'com.CommonUtilities.MobiInstance.enterDisplayName'()

CustomKeywords.'com.CommonUtilities.MobiInstance.selectAudience'("ind")

CustomKeywords.'com.CommonUtilities.MobiInstance.selectSpecificVisit'(visitType)

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.verifySuccessMessage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Save button while creating instance, the save button is still shown")

CustomKeywords.'com.CommonUtilities.MobiInstance.verifyTheCreatedInstance'(displayName, "1 Visit, Individuals")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickPreviewButton'(displayName)

WebUI.switchToFrame(findTestObject('Object Repository/Add Attendee/IframeOfMobi'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/VisitTypeInVisitConfirmationPage(visitType)', ["visitType":visitType]), "When click on preview of instance with specific visit type and only groups, the selected visit is not shown directly")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/RegisterButtonInAddAttendee'), "When click on preview of instance with specific visit type and only groups, the Register button is not shown")






