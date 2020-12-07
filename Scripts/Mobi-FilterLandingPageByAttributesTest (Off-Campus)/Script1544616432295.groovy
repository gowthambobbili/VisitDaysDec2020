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

String OffCampusVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(OffCampusVisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(OffCampusVisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

String OffCampusVisittUrl = WebUI.getUrl()

String OffCampusVisitID = OffCampusVisittUrl.split('visits/')[1]

def OffCampusVisitInMobi = new TestObject('Created Off-Campus in Mobi')

OffCampusVisitInMobi.addProperty('xpath', ConditionType.EQUALS, ('//strong[text()=\'' + OffCampusVisitType) + '\']')

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
    'If user navigates to No Filterng Mobi campaign link then the Off-Campus tab is not shown')

WebUI.click(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(OffCampusVisitInMobi, 'If user navigates to No Filterng Mobi campaign link then Off-Campus visits are not shown')

WebUI.switchToDefaultContent()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.waitForElementVisible(findTestObject('HomePageElements/VisitTypesLeftNav'), 0)

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'), FailureHandling.STOP_ON_FAILURE)

String OffCampusVisitTypeId = CustomKeywords.'com.CommonUtilities.EditRegistrantType.ChangeRegistrantTypeToGroupsOnly'(OffCampusVisitType)

println(OffCampusVisitTypeId)

WebUI.navigateToUrl(GroupFilter)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/IndividualOptionInMobi'), 
    'If user navigates to Group Filtered Mobi campaign link then the audiance page is Still shown')

WebUI.click(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(OffCampusVisitInMobi, 'If user navigates to Group Filtered Mobi campaign link then The corresponding Events are not shown')

WebUI.navigateToUrl(IndividualFilter)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/IndividualOptionInMobi'), 
    'If user navigates to Individual Filtered Mobi campaign link then the audiance page is still shown')

WebUI.click(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(OffCampusVisitInMobi, 'If user navigates to Individual Filtered Mobi campaign link then The Group specific Off-Campus visits are shown')

WebUI.navigateToUrl(OffCampusCategoryFilter)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

//WebUI.waitForElementPresent(findTestObject('Add Attendee/CloseButtonInAddAttendee'), 0)
WebUI.waitForElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)

WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), 
    'If user navigates to Off-Campus filtered Mobi campaign link then Daily Visits tab is still shown in mobi')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/EventsOptionInAddAttendee'), 
    'If user navigates to Off-Campus filtered Mobi campaign link then Events tab is still shown in mobi')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), 
    'If user navigates to Off-campus filtered Mobi campaign link then OffCampus tab is still shown in mobi')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(OffCampusVisitInMobi, 'If user navigates to Off-Campus filtered Mobi campaign link then The corresponding Off-Campus visits are not shown')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateTospecifiedEventType'(OffCampusVisitTypeId)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

//WebUI.waitForElementPresent(findTestObject('Add Attendee/CloseButtonInAddAttendee'), 0)
WebUI.waitForElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)

WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(OffCampusVisitInMobi, 'If user navigates to Off-Campus event type Filtered Mobi campaign link then The corresponding Off-Campus visits are not shown in Mobi')

WebUI.click(findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/FirstVisitInMobi'), 
    '\'If user navigates toOff-Campus event type Filtered Mobi campaign link then The Daily visits are shown under Daily visits tab which are not belongs to the visit type id in the link\'')

WebUI.click(findTestObject('Add Attendee/EventsOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/FirstVisitInMobi'), 
    'If user navigates to Off-Campus event type Filtered Mobi campaign link then The corresponding Events are not shown in Mobi')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateTospecifiedEventId'(OffCampusVisitID)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 
    'If user navigates to campaign link which is filtered for a group visit id then the review page is not shown')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateToGivenCategoryAndAudienceLink'(GroupAudience, OffCampusCategory)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Off-Campus & Groups then the audience page is shown ( Audience is page is not expected to show)')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Off-Campus & Groups then Events tab is still shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/EventsOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Off-Campus & Groups then Events tab is still shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Off-Campus & Groups then the Off-Campus tab is shown')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(OffCampusVisitInMobi, 'If user naviagates to a link which is filtered for Off-Campus category & Groups then the corresponding off campus visits are not shown')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateToGivenVisitIdAndAudienceLink'(GroupAudience, OffCampusVisitID)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 
    'If user naviagates to a link which is filtered for Off-Campus ID & Groups then the Review page is not shown')

CustomKeywords.'com.CommonUtilities.MobiUrlNavigations.NavigateToGivenVisitTypeIdAndAudienceLink'(GroupAudience, OffCampusVisitTypeId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 
    'If user naviagates to a link which is filtered for Event Type ID & Groups then the Audience page is shown ( Audience is page is not expected to show)')

WebUI.click(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(OffCampusVisitInMobi, 'If user naviagates to a link which is filtered for Off-Campus Visit ID & Groups then the corresponding off campus visits are not shown')

