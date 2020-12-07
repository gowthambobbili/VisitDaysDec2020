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

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

not_run: WebUI.delay(10)

not_run: WebUI.click(findTestObject('VisitTypesPage/AppcuesPopupbutton'))

if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0, FailureHandling.OPTIONAL) == 
false) {
    String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeAndBeInVisitTypesPage'()
}

def FirstVisitTypeName = WebUI.getText(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'))

println(FirstVisitTypeName)

WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), FirstVisitTypeName)

WebUI.verifyElementText(findTestObject('VisitTypesPage/DuplicateVisitTypeErrorMessage'), 'Two visit types can\'t have the same name')

WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

WebUI.scrollToElement(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'), 0)

WebUI.click(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'))

WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

//WebUI.click(findTestObject('VisitTypesPage/OnlineCheckbox'))
WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/DuplicateVisitTypeErrorMessage'), 0)

WebUI.refresh()

WebUI.click(findTestObject('VisitTypesPage/eventOption'))

WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), FirstVisitTypeName)

WebUI.verifyElementText(findTestObject('VisitTypesPage/DuplicateVisitTypeErrorMessage'), 'Two visit types can\'t have the same name')

WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

WebUI.scrollToElement(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'), 0)

WebUI.click(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'))

WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

//WebUI.click(findTestObject('VisitTypesPage/OnlineCheckbox'))
WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/DuplicateVisitTypeErrorMessage'), 0)

WebUI.refresh()

WebUI.click(findTestObject('VisitTypesPage/OffCampusOption'))

WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), FirstVisitTypeName)

WebUI.verifyElementText(findTestObject('VisitTypesPage/DuplicateVisitTypeErrorMessage'), 'Two visit types can\'t have the same name')

WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

WebUI.scrollToElement(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'), 0)

WebUI.click(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'))

//WebUI.click(findTestObject('VisitTypesPage/OnlineCheckbox'))
WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('VisitTypesPage/DuplicateVisitTypeErrorMessage'), 0)

