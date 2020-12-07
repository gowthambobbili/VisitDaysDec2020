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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String VisitType = WebUI.callTestCase(findTestCase('Reusable Test Cases/GetExistingDailyVisitOrCreateANewDailyVisit'), [:], 
    FailureHandling.STOP_ON_FAILURE)

String Team = WebUI.callTestCase(findTestCase('CreateTeamUserFlowToNotSetTeamPhoto'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 
    'Details tab is not present for a daily visit')

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/Details Page/EditLinkInUsersAssignedDivision'), 
    'Edit button is not present for Assigned users division in the details page of the visit')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInUsersAssignedDivision'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'), 
    'Assign now button is not shown in the details page "Users assigned" division')

WebUI.click(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/TeamsTabInUsersAssignedDivision'), 
    'Teams tab is not present in details page users assigned division ')

WebUI.click(findTestObject('DailyVisitsPage/TeamsTabInUsersAssignedDivision'))

def TeamInUserAssignedDIvision = new TestObject('Team in user assigned division')

TeamInUserAssignedDIvision.addProperty('xpath', ConditionType.EQUALS, '//span[text()=\'Automation1197\']/..//i')

WebUI.click(TeamInUserAssignedDIvision)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/SaveBUttonInSummaryPage'), 
    'Save button is not present in details page Users assigned division')

WebUI.click(findTestObject('DailyVisitsPage/SaveBUttonInSummaryPage'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Details Page/AllDatesAndTimesRadioButtonInEditVisitModal'), 
    0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/AllDatesAndTimesRadioButtonInEditVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Details Page/SaveNowButtonInEditVisitModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveNowButtonInEditVisitModal'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('DailyVisitsPage/Details Page/SaveNowButtonInEditVisitModal'), 
    'After clicking save not button in edti visit type modal the modal is not getting closed')

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

