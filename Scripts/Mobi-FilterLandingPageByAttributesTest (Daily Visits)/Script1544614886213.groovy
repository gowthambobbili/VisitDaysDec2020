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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(DailyVisitVisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(DailyVisitVisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

String DailyVisitUrl = WebUI.getUrl()

String DailyVisitID = DailyVisitUrl.split('visits/')[1]

def DailyVisitInMobi = new TestObject('Created Daily visit in Mobi')

DailyVisitInMobi.addProperty('xpath', ConditionType.EQUALS, ('//strong[text()=\'' + DailyVisitVisitType) + '\']')

WebUI.navigateToUrl(NoFilterUrl)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/IndividualOptionInMobi'), 
    'If user navigates to No Filterng Mobi campaign link then the audiance page is not shown')

WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), 
    'If user navigates to No Filterng Mobi campaign link then the Daily Visits are not shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/EventsOptionInAddAttendee'), 
    'If user navigates to No Filterng Mobi campaign link then the Evens are not shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), 
    'If user navigates to No Filterng Mobi campaign link then the Off-Campus visits are page is not shown')

//Verifications of visits
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(DailyVisitInMobi, 'Created Daily visit is not shown in the Mobi campaign link without filters')

WebUI.switchToDefaultContent()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.waitForElementVisible(findTestObject('HomePageElements/VisitTypesLeftNav'), 0)

WebUI.waitForElementClickable(findTestObject('HomePageElements/VisitTypesLeftNav'), 0)

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'), FailureHandling.STOP_ON_FAILURE)

String DailyVisitVisitTypeId = CustomKeywords.'com.CommonUtilities.EditRegistrantType.ChangeRegistrantTypeToGroupsOnly'(
    DailyVisitVisitType)

println(DailyVisitVisitTypeId)

WebUI.navigateToUrl(GroupFilter)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/CloseButtonInAddAttendee'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/IndividualOptionInMobi'), 
    'If user navigates to Group Filtered Mobi campaign link then the audiance page is Still shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(DailyVisitInMobi, 'If user navigates to Group Filtered Mobi campaign link then The corresponding daily visits are not shown')

WebUI.navigateToUrl(IndividualFilter)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/CloseButtonInAddAttendee'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/IndividualOptionInMobi'), 
    'If user navigates to Individual Filtered Mobi campaign link then the audiance page is still shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(DailyVisitInMobi, 'If user navigates to Individual Filtered Mobi campaign link then The Group specific daily visits are shown')

WebUI.navigateToUrl(DailyVisitsCategoryFilter)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/CloseButtonInAddAttendee'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)

WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), 
    'If user navigates to Daily Visits filtered Mobi campaign link then Daily Visits tab is still shown in mobi')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/EventsOptionInAddAttendee'), 
    'If user navigates to Daily Visits filtered Mobi campaign link then Events tab is still shown in mobi')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), 
    'If user navigates to Daily Visits filtered Mobi campaign link then OffCampus tab is still shown in mobi')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(DailyVisitInMobi, 'If user navigates to Daily Visits filtered Mobi campaign link then The corresponding daily visits are not shown')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateTospecifiedEventType'(DailyVisitVisitTypeId)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

//WebUI.waitForElementPresent(findTestObject('Add Attendee/CloseButtonInAddAttendee'), 0)
WebUI.waitForElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)

WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(DailyVisitInMobi, 'If user navigates to Daily visit event type Filtered Mobi campaign link then The corresponding daily visits are not shown in Mobi')

WebUI.click(findTestObject('Add Attendee/EventsOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/FirstVisitInMobi'), 
    '\'If user navigates to Daily visit event type Filtered Mobi campaign link then The Events are shown under events tab which are not belongs to the visit type id in the link\'')

WebUI.click(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/FirstVisitInMobi'), 
    'If user navigates to Daily visit event type Filtered Mobi campaign link then The Off-Campus visits are shown under Off-Campus tab which are not belongs to the visit type id in the link')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateTospecifiedEventId'(DailyVisitID)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 
    'If user navigates to campaign link which is filtered for a group visit id then the review page is not shown')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateToGivenCategoryAndAudienceLink'(GroupAudience, DailyVisitCategory)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Daily visits & Groups then the audience page is shown ( Audience is page is not expected to show')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Daily visits & Groups then Daily visits tab is still shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/EventsOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Daily visits & Groups then Events tab is still shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Daily visits & Groups then the Off-Campus tab is shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(DailyVisitInMobi, 'If user naviagates to a link which is filtered for Daily visits & Groups then the corresponding daily visits are not shown')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateToGivenVisitIdAndAudienceLink'(GroupAudience, DailyVisitID)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 
    'If user naviagates to a link which is filtered for Daily visits Id & Groups then the corresponding Review page is not shown')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateToGivenVisitTypeIdAndAudienceLink'(GroupAudience, DailyVisitVisitTypeId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Daily visits visit ID & Groups then the audience page is shown ( Audience is page is not expected to show)')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(DailyVisitInMobi, 'If user naviagates to a link which is filtered for Daily visits visit type ID & Groups then the corresponding daily visits are not shown')

