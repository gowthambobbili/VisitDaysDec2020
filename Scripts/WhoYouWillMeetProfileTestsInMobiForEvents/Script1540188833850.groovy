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

String EventVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateInstantEventVisitByAssigningUsers'(EventVisitVisitType)

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)

WebUI.waitForElementVisible(findTestObject('HomePageElements/AddAttendeeButton'), 0)

WebUI.waitForElementClickable(findTestObject('HomePageElements/AddAttendeeButton'), 0)

WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/EventsOptionInAddAttendee'))

WebUI.delay(3)

def object = new TestObject('CretedVisitNameInMobi')

object.addProperty('xpath', ConditionType.EQUALS, ('//h1[text()=\'' + EventVisitVisitType) + '\']')

WebUI.scrollToElement(object, 0)

WebUI.click(object)

WebUI.verifyElementText(findTestObject('Add Attendee/VisitNameInVisitDescriptionInMobi'), EventVisitVisitType)

WebUI.verifyElementPresent(findTestObject('Add Attendee/WhoWillYouMeetHeaderInMobi'), 0)

if (!(WebUI.verifyElementPresent(findTestObject('Add Attendee/WhoYouWillMeetUserProfile'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Who You Will Meet Admin profile is not shown for Events')

    WebUI.takeScreenshot()
}

WebUI.switchToDefaultContent()

