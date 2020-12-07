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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

not_run: WebUI.delay(15)

not_run: WebUI.click(findTestObject('VisitTypesPage/AppcuesPopupbutton'))

//WebUI.click(findTestObject('VisitTypesPage/ActiveTab'))
if (!(WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0, FailureHandling.OPTIONAL))) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/EmptyStateMessageInVisitTypes'), 0)
} else {
	println('Cannot show Empty state due to Active Visit Types are present in Active tab')
}

//WebUI.verifyElementClickable(findTestObject('VisitTypesPage/ArchivedTab'), 0)
WebUI.click(findTestObject('VisitTypesPage/ArchivedTab'))

if (!(WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0, FailureHandling.OPTIONAL))) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/EmptyStateMessageInVisitTypes'), 0)
} else {
	println('Cannot show Empty state due to Archived Visit Types are there in Archived tab')
}

