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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('The Add registrant button is not shown in the registered tab to add visitor directly to the visit')

    WebUI.takeScreenshot()
}

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

List<String> IndividualResponces = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisitAndReturnAllAnswers'()

String Individual = 'Test ' + IndividualResponces.get(0)

WebUI.refresh()

if (!(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegiteredInvidualStudent',['Individual':Individual]), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('registered Individual Student is not shown in the registered tab')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegiteredInvidualStudent',['Individual':Individual]))

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/DetailsTabInUserProfile'))

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/EditButtonInDetailsTab'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Edit button is not shown in the Individual profile')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/EditButtonInDetailsTab'))

WebUI.delay(2)

WebUI.clickOffset(findTestObject('UserProfile/OffsetFromUserprofile'), 10, 10)

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/UnsavedChangesHeaderInUnsavedChangesModal'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('While editing student profile, on clicking away from the user profile "Unsaved Changes" modal is not shown')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/AbondonChangesButtonInUnsavedChangesModal'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('"Abandon Changes" button is not present in "Unsaved Changes" modal')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/KeepEditingButtonInUnsavedChangesModal'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('"Keep Editing" button is not present in "Unsaved Changes" modal')

    WebUI.takeScreenshot()
}

WebUI.waitForElementVisible(findTestObject('UserProfile/KeepEditingButtonInUnsavedChangesModal'), 0)

WebUI.click(findTestObject('UserProfile/KeepEditingButtonInUnsavedChangesModal'))

WebUI.delay(5)

WebUI.click(findTestObject('UserProfile/Details/CancelButton'))

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/FirstName'), 'Test'))) {
    KeywordUtil.markFailed('First name field in the individual profile shows wrong information')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/LastName'), IndividualResponces.get(0)))) {
    KeywordUtil.markFailed('Last name field in the individual profile shows wrong information')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/Email'), IndividualResponces.get(1)))) {
    KeywordUtil.markFailed('Incorrect Email is shown in the Indvidual profile')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/CellPhoneNumber'), MobileNumber))) {
    KeywordUtil.markFailed('Incorrect Mobile number is shown in the Indvidual profile')

    WebUI.takeScreenshot()
}

WebUI.clickOffset(findTestObject('UserProfile/OffsetFromUserprofile'), 10, 10)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

List<String> GroupResponces = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

String OrgName = GroupResponces.get(2)

def GroupObject = new TestObject('Registered Individual In Registered Tab')

GroupObject.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + OrgName) + '\']')

WebUI.click(GroupObject)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/DetailsTabInUserProfile'))

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/EditButtonInDetailsTab'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Edit button is not shown in the Group profile')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/EditButtonInDetailsTab'))

WebUI.delay(2)

WebUI.clickOffset(findTestObject('UserProfile/OffsetFromUserprofile'), 10, 10)

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/UnsavedChangesHeaderInUnsavedChangesModal'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('While editing Group profile, on clicking away from the user profile "Unsaved Changes" modal is not shown')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/AbondonChangesButtonInUnsavedChangesModal'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('"Abandon Changes" button is not present in "Unsaved Changes" modal')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/KeepEditingButtonInUnsavedChangesModal'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('"Keep Editing" button is not present in "Unsaved Changes" modal')

    WebUI.takeScreenshot()
}

WebUI.waitForElementVisible(findTestObject('UserProfile/KeepEditingButtonInUnsavedChangesModal'), 0)

WebUI.click(findTestObject('UserProfile/KeepEditingButtonInUnsavedChangesModal'))

WebUI.delay(5)

WebUI.click(findTestObject('UserProfile/Details/CancelButton'))

WebUI.delay(2)

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/OrganisationName'), OrgName, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('In Group profile the Organization name is shown incorrect')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/FirstName'), 'Test', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('In Group profile First name is shown incorrect')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/LastName'), GroupResponces.get(0), FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('In Group profile Last name is shown incorrect')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/Email'), GroupResponces.get(1), FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('In Group profile Email is shown incorrect')

    WebUI.takeScreenshot()
}

WebUI.scrollToElement(findTestObject('UserProfile/Details/CellPhoneNumber'), 0)

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/CellPhoneNumber'), MobileNumber, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('In Group profile Cell Phone Nummber is shown incorrect')

    WebUI.takeScreenshot()
}

