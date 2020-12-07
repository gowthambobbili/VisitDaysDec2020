import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateEventWithInFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

def visit = new TestObject('Created Visit In Index Page')

visit.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

if (!(WebUI.verifyElementPresent(visit, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('The created visit is not shown in the visit index page after applying filters')

    WebUI.takeScreenshot()
}

WebUI.click(visit)

TestObject Individual = CustomKeywords.'com.CommonUtilities.MobiRegistrationWithInternationalNumberAndVerification.RegisterAnIndividualWithInternationalNumberAndVerifyValidation'()

WebUI.click(Individual)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.waitForElementVisible(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

WebUI.click(findTestObject('UserProfile/DetailsTabInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('UserProfile/Details/CellPhoneNumber'), MobileNumber)

WebUI.refresh()

TestObject Group = CustomKeywords.'com.CommonUtilities.MobiRegistrationWithInternationalNumberAndVerification.RegisterAGrouplWithInternationalNumberAndVerifyValidation'()

WebUI.click(Group)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.waitForElementVisible(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

WebUI.click(findTestObject('UserProfile/DetailsTabInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.scrollToElement(findTestObject('UserProfile/Details/CellPhoneNumber'), 0)

WebUI.verifyElementText(findTestObject('UserProfile/Details/CellPhoneNumber'), MobileNumber)

