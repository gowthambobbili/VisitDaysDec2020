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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateEventWithInFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Add Registratnt button is not present in registered tab to add visitor directly to the visit')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Student = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

//div[@class="uservisit-entry-content"]//div[text()='Orgnazation5426']
def studentNameObject = new TestObject('Registered Individual In registered tab')

studentNameObject.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + 
    Student) + '\']')

WebUI.verifyElementPresent(studentNameObject, 0)

WebUI.click(studentNameObject)

CustomKeywords.'com.CommonUtilities.AddVisitToItineraryLabelInUserProfile.VerifyAddVisitToItineraryLabelInIndividualProfile'()

//===========
//===========
WebUI.refresh()

WebUI.waitForElementPresent(studentNameObject, 0)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Group = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

CustomKeywords.'com.CommonUtilities.NewMobiRegistration.switchToDefaultContent'()

studentNameObject.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + 
    Group) + '\']')

WebUI.verifyElementPresent(studentNameObject, 0)

WebUI.click(studentNameObject)

WebUI.delay(3)

CustomKeywords.'com.CommonUtilities.AddVisitToItineraryLabelInUserProfile.VerifyAddVisitToItineraryLabelInGroupProfile'()

