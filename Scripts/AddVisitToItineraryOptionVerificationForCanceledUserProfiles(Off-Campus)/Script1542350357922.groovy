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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

String Individual = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def IndividualProfile = new TestObject('Registered Individual Student')

IndividualProfile.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + 
    Individual) + '\']')

WebUI.verifyElementPresent(IndividualProfile, 0)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

String Group = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

CustomKeywords.'com.CommonUtilities.NewMobiRegistration.switchToDefaultContent'()

def GroupProfile = new TestObject('Registered Individual Student')

GroupProfile.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + Group) + 
    '\']')

WebUI.verifyElementPresent(GroupProfile, 0)

//WebUI.click(IndividualProfile)
def ThreeDotMenu = new TestObject('Three Dot Menu Of Registered Individual Student In Registered Tab')

ThreeDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Individual) + '\']/../..//i[text()=\'more_vert\']')

WebUI.click(ThreeDotMenu)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'))

WebUI.waitForElementVisible(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'), 
    0)

WebUI.click(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTab'), 0)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/CanceledTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(IndividualProfile, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailedAndStop('The canceled Individual profile is not shown in the Canceled tab')

    WebUI.takeScreenshot()
}

WebUI.click(IndividualProfile)

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailedAndStop('After canceling the group registration the Three dot menu is not shown in Group leader profile')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

if (!(WebUI.verifyElementNotPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('"Add Visit To Itinerary" option is shown in canceled Individual student profile(Three dot menu)')

    WebUI.takeScreenshot()
}

WebUI.refresh()

WebUI.waitForElementPresent(GroupProfile, 0)

def GroupThreeDotMenu = new TestObject('Three Dot Menu Of Registered Individual Student In Registered Tab')

GroupThreeDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Group) + '\']/../..//i[text()=\'more_vert\']')

WebUI.waitForElementClickable(GroupThreeDotMenu, 0)

WebUI.click(GroupThreeDotMenu)

WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'))

WebUI.waitForElementVisible(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'), 
    0)

WebUI.click(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

not_run: WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTab'), 0)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/CanceledTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(GroupProfile, 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailedAndStop('Canceled Group profile is not shown in the Canceled tab')

    WebUI.takeScreenshot()
}

WebUI.click(GroupProfile)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/OffsetFromUserprofile'))

WebUI.delay(3)

WebUI.click(GroupProfile)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailedAndStop('After canceling the group registration the Three dot menu is not shown in Group leader profile')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

if (!(WebUI.verifyElementNotPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailedAndStop('"Add Visit To Itinerary" option is shown in canceled Group leader profile(Three dot menu)')

    WebUI.takeScreenshot()
}

