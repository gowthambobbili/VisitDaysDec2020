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

//WebUI.waitForElementPresent(findTestObject('VisitTypesPage/SearchVisitTypesTextBox'), 0)

if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0, FailureHandling.OPTIONAL) ==
	false) {
		String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeAndBeInVisitTypesPage'()
	}
	
WebUI.click(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'))

WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

WebUI.click(findTestObject('VisitTypesPage/ArchiveVisitTypeButton'))

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/ArchiveVisitTypeHeaderInArchiveModal'), 0)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/MessageInArchiveVisitTypeModal'), 0)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstCheckBoxInArchiveVisitTypeModal'), 0)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/secondCheckBoxInArchiveVisitTypeModal'), 0)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EnterVisitTypeTextBoxInArchiveVisitTypeModal'), 0)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/EnterVisitTypeTextBoxInArchiveVisitTypeModal'), 0)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/DontArchiveButtonInArchiveVisitTypeModal'), 0)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/AciveVisitTypeButtonInModal'), 0)

