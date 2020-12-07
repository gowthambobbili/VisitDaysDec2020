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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String VisitType = WebUI.callTestCase(findTestCase('Reusable Test Cases/GetExistingDailyVisitOrCreateANewDailyVisit'), [:],
FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'),
		'Add Registrants button is not present in Details page of the selected Daily Visit to add visitor directly to the visit')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/HeaderDivisionIndAddVistitorDirectlyToVisitMobi'), 0)

HeaderColor = WebUI.getCSSValue(findTestObject('DailyVisitsPage/HeaderDivisionIndAddVistitorDirectlyToVisitMobi'), 'background-color')

ButtonColor = WebUI.getCSSValue(findTestObject('DailyVisitsPage/ButtonDivisionInMobiWhileAddingVisitorDirectlyToVisit'),
		'background-color')

println(HeaderColor)

println(ButtonColor)

if (!(WebUI.verifyMatch(HeaderColor, ExpectedHeaderColor, false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('While adding visitor directly to visit The header color is not default mobi color (Header color should be the visit days default mobi color)')
}

if (!(WebUI.verifyMatch(ButtonColor, ExpectedButtonColor, false, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('While adding visitor directly to visit The Button color is not Default mobi color (Button color should be the visit days default mobi color)')
}

