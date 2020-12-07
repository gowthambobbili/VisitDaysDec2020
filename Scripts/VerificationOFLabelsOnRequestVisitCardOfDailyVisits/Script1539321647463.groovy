import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String Single = 'single'

String DailyVisitsVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(DailyVisitsVisitType)

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'([DailyVisitsVisitType], findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToRequests'()

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Requests/VisitLinkInRequestsList(visittype)', ["visittype":DailyVisitsVisitType]), "The submitted request is not shown in te requests queue")

WebUI.click(findTestObject('Object Repository/Requests/VisitLinkInRequestsList(visittype)', ["visittype":DailyVisitsVisitType]))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegistrantsTabInVisitCard'), 0)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/RequestUnderPendingTab'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RequestUnderPendingTab'), 0)

String PendingLabel = WebUI.getText(findTestObject('DailyVisitsPage/PendingTabInRequestVisit'))

println(PendingLabel)

WebUI.verifyMatch(PendingLabel.charAt(PendingLabel.length() - 2).toString(),'1' , false, FailureHandling.CONTINUE_ON_FAILURE)

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


WebUI.navigateToUrl(GlobalVariable.EvrUrl)

String OrganisationName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'([DailyVisitsVisitType], findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), 'grp')

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToRequests'()


driver.findElement(By.xpath(('//div[@class="visit-name"]//p[text()="' + DailyVisitsVisitType) + '"]')).click()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegistrantsTabInVisitCard'), 0)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/RequestUnderPendingTab'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RequestUnderPendingTab'), 0)

String GroupPendingLabel = WebUI.getText(findTestObject('DailyVisitsPage/PendingTabInRequestVisit'))

println(GroupPendingLabel)

WebUI.verifyMatch('1', GroupPendingLabel.charAt(GroupPendingLabel.length() - 2).toString(), false, FailureHandling.CONTINUE_ON_FAILURE)

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

//if(!(WebUI.verifyMatch(GroupScheduledLabel.charAt(GroupScheduledLabel.length() - 2).toString(), '1', false, FailureHandling.OPTIONAL)))
//{
//	WebUI.takeScreenshot()
//	KeywordUtil.markFailed("After Scheduling a group the count on scheuled tab is not getting updated, Actual value - "+GroupScheduledLabel.charAt(GroupScheduledLabel.length() - 2).toString()+", Expected value - 1")
//}

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

String GroupCanceledLabel = WebUI.getText(findTestObject('DailyVisitsPage/CanceledTabOnRequestVisitCard'))

println(GroupCanceledLabel)

//WebUI.verifyMatch(GroupCanceledLabel.charAt(GroupCanceledLabel.length() - 2).toString(), '2', false, FailureHandling.OPTIONAL)
//{
//	WebUI.takeScreenshot()
//	KeywordUtil.markFailedAndStop("After canceling a group the count on Canceld tab is not getting updated")
//
//}

