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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateEventWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInTimeDivision'))

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), '11:00 AM')

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'), '9:00 AM')

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/RequiredInputErrorMessage'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After entering an invalid Time in Times division of Events in the details page, i.e \'End Time\' earlier than \'Start Time\' \'Required Input\' error message is not shown')

	WebUI.takeScreenshot()
}

//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

if(!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/EditLinkInTimeDivision'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailedAndStop("User is allowed to save invalid Event times (End time earlier than Start time)")
}

