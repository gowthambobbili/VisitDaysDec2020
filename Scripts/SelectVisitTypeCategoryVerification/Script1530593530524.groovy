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

WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypeHeaderwhileCreatingVisitType'), 'Create Visit Type')

WebUI.refresh()

WebUI.click(findTestObject('VisitTypesPage/eventOption'))

WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypeHeaderwhileCreatingVisitType'), 'Create Visit Type')

WebUI.refresh()

WebUI.click(findTestObject('VisitTypesPage/OffCampusOption'))

WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypeHeaderwhileCreatingVisitType'), 'Create Visit Type')

not_run: WebUI.delay(10)

not_run: if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/AppcuesPopupbutton')) == true) {
    not_run: WebUI.click(findTestObject('VisitTypesPage/AppcuesPopupbutton'))
}

