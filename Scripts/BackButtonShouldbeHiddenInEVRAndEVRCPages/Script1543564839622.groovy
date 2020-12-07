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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckinAndGroupRegistrantType'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

def visit = new TestObject('Created Visit In Index Page')

visit.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

WebUI.click(visit)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

String VisitUrl = WebUI.getUrl()

String VisitId = VisitUrl.split('visits/')[1]

String MobiUrl = GlobalVariable.EvrUrl + VisitId

WebUI.navigateToUrl(MobiUrl)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

WebUI.delay(2)

if (!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/BackButtonInMobi'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Back button is shown in EVR page (Back button is not expected to show in EVR & EVRC pages)')

    WebUI.takeScreenshot()
}

String EVRCUrl = GlobalVariable.EvrcUrl + VisitId

WebUI.navigateToUrl(EVRCUrl)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

WebUI.delay(2)

if (!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/BackButtonInMobi'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Back button is shown in EVRC page (Back button is not expected to show in EVR & EVRC pages)')

    WebUI.takeScreenshot()
}

