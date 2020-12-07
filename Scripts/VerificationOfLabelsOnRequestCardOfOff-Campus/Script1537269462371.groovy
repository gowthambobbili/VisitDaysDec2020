import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String Single = 'single'

String OffCampusVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestOffCampusVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusWithRequestVisitType'(OffCampusVisitType)

String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName'(
		OffCampusVisitType, findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), Single)

//WebUI.refresh()
CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

driver.findElement(By.xpath(('//div[@class="visit-name"]//p[text()="' + OffCampusVisitType) + '"]')).click()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegistrantsTabInVisitCard'), 0)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/RequestUnderPendingTab'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RequestUnderPendingTab'), 0)

String PendingLabel = WebUI.getText(findTestObject('DailyVisitsPage/PendingTabInRequestVisit'))

println(PendingLabel)

WebUI.verifyMatch(PendingLabel.charAt(PendingLabel.length() - 2).toString(), '1', false, FailureHandling.CONTINUE_ON_FAILURE)

//driver.findElement(By.xpath(('//div[contains(text(),\'' + StudentName) + '\')]/../..//span[text()=\'Schedule\']')).click()
WebUI.click(findTestObject('DailyVisitsPage/ScheduleButtonOnFirstRequestUnderPendingTab'))

WebUI.waitForElementPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0)

CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/ScheduledTabOnRequestVisitCard'), 0)

WebUI.delay(6)

WebUI.click(findTestObject('DailyVisitsPage/ScheduledTabOnRequestVisitCard'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ScheduledRequestUnderScheduledTab'), 0)

String ScheduledLabel = WebUI.getText(findTestObject('DailyVisitsPage/ScheduledTabOnRequestVisitCard'))

println(ScheduledLabel)

WebUI.verifyMatch(ScheduledLabel.charAt(ScheduledLabel.length() - 2).toString(), '1', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/ScheduledRequestUnderScheduledTab'))

WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0)

WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UserProfile/CancleRegistrationOptionInUsereProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('UserProfile/CancelRegistrationHeaderInCancelRegistrationModal'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

WebUI.waitForElementVisible(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'))

WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'))

WebUI.waitForElementNotPresent(findTestObject('UserProfile/CancelRegistrationHeaderInCancelRegistrationModal'), 0)

WebUI.delay(2)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'))

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledVisitUnderCanceledTab'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CanceledVisitUnderCanceledTab'), 0)

String CanceledLabel = WebUI.getText(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'))

println(CanceledLabel)

WebUI.verifyMatch(CanceledLabel.charAt(CanceledLabel.length() - 2).toString(), '1', false, FailureHandling.CONTINUE_ON_FAILURE)

String OrganisationName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForGroupRequestWithUserName'(
		OffCampusVisitType, findTestObject('Add Attendee/OffCampusOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

driver.findElement(By.xpath(('//div[@class="visit-name"]//p[text()=\''+ OffCampusVisitType) + '\']')).click()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegistrantsTabInVisitCard'), 0)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/RequestUnderPendingTab'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RequestUnderPendingTab'), 0)

String GroupPendingLabel = WebUI.getText(findTestObject('DailyVisitsPage/PendingTabInRequestVisit'))

println(GroupPendingLabel)

WebUI.verifyMatch(GroupPendingLabel.charAt(GroupPendingLabel.length() - 2).toString(), '1', false, FailureHandling.CONTINUE_ON_FAILURE)

//driver.findElement(By.xpath(('//div[contains(text(),\'' + StudentName) + '\')]/../..//span[text()=\'Schedule\']')).click()
WebUI.click(findTestObject('DailyVisitsPage/ScheduleButtonOnFirstRequestUnderPendingTab'))

WebUI.waitForElementPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0)

CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/ScheduledTabOnRequestVisitCard'), 0)

WebUI.delay(6)

WebUI.click(findTestObject('DailyVisitsPage/ScheduledTabOnRequestVisitCard'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ScheduledRequestUnderScheduledTab'), 0)

String GroupScheduledLabel = WebUI.getText(findTestObject('DailyVisitsPage/ScheduledTabOnRequestVisitCard'))

println(GroupScheduledLabel)

//WebUI.verifyMatch(GroupScheduledLabel.charAt(GroupScheduledLabel.length() - 2).toString(), '1', false, FailureHandling.CONTINUE_ON_FAILURE)

//if(!(WebUI.verifyMatch(GroupScheduledLabel.charAt(GroupScheduledLabel.length() - 2).toString(), '1', false, FailureHandling.OPTIONAL)))
//{
//	WebUI.takeScreenshot()
//	KeywordUtil.markFailed("After Scheduling a group the count on scheuled tab is not getting updated, Actual value - "+GroupScheduledLabel.charAt(GroupScheduledLabel.length() - 2).toString()+", Expected value - 1")
//}

WebUI.click(findTestObject('DailyVisitsPage/ScheduledRequestUnderScheduledTab'))

WebUI.waitForElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0)

WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UserProfile/CancleRegistrationOptionInUsereProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('UserProfile/CancelRegistrationHeaderInCancelRegistrationModal'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

WebUI.waitForElementVisible(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'))

WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'))

WebUI.waitForElementNotPresent(findTestObject('UserProfile/CancelRegistrationHeaderInCancelRegistrationModal'), 0)

WebUI.delay(2)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'))

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledVisitUnderCanceledTab'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CanceledVisitUnderCanceledTab'), 0)

String GroupCanceledLabel = WebUI.getText(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'))

println(GroupCanceledLabel)

//WebUI.verifyMatch(GroupCanceledLabel.charAt(GroupCanceledLabel.length() - 2).toString(), '2', false, FailureHandling.CONTINUE_ON_FAILURE)
//{
//	WebUI.takeScreenshot()
//	KeywordUtil.markFailedAndStop("After canceling a group the count on Canceld tab is not getting updated")
//
//}
