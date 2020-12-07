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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By


CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestEventVisitType'()
CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateEventWithRequestVisitTypeWithFutureTimes'(VisitType)
WebUI.navigateToUrl(GlobalVariable.EvrUrl)
def Student = CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'([VisitType], findTestObject('Add Attendee/EventsOptionInAddAttendee'))
CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToRequests'()
WebUI.waitForElementPresent(findTestObject('Object Repository/Requests/VisitTypeFilterDropDown'), 0)
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/Requests/StudentNameInRequestsPage(student)', ["student":Student]), "After submitting a request the request is not shown in pending tab o requests page")
WebUI.click(findTestObject('Object Repository/HomePageElements/ProfileAvatar'))
WebUI.waitForElementVisible(findTestObject('Object Repository/ElementsUnderProfileAvatar/MyProfileOption'), 0)


WebUI.click(findTestObject('Object Repository/ElementsUnderProfileAvatar/MyProfileOption'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/ElementsUnderProfileAvatar/My Profile/EditButtonInAdminProfile'), "When click My profile in provile nav the admin profile is not shown")

def NameOfAdmin = WebUI.getText(findTestObject('Object Repository/ElementsUnderProfileAvatar/My Profile/AdminFullName')).trim()

WebUI.clickOffset(findTestObject('Object Repository/UserProfile/OffsetFromUserprofile'), 10, 10)

WebUI.waitForElementVisible(findTestObject('Object Repository/Requests/StudentNameInRequestsPage(student)', ["student":Student]), 0)

WebUI.click(findTestObject('Object Repository/Requests/StudentNameInRequestsPage(student)', ["student":Student]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('UserProfile/VisitsTabInUserProfile'), "When click reqquested Student name in pendinig tab of requests page, the student profile is not opened")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('UserProfile/ScheduleButtonOfASpecifiedStudent(visittype)', ["visittype":VisitType]), "After submitting a request the Schedule button is not shown in the requested student profile")

WebUI.click(findTestObject('UserProfile/ScheduleButtonOfASpecifiedStudent(visittype)', ["visittype":VisitType]))

CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

WebUI.delay(3)

def StatusMessage = WebUI.getText(findTestObject('Object Repository/UserProfile/StatusFieldInUserProfile'))

println StatusMessage

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(StatusMessage,"check\n"+NameOfAdmin+" scheduled request" , "After scheduling a request, incorrect error message is shown in the user profile")

def TimeStamp = WebUI.getText(findTestObject('Object Repository/UserProfile/StatusTimeFieldInUseProfile'))

println TimeStamp

def CurrentTime = CustomKeywords.'com.CommonUtilities.Times.GetTimeForStatusTimeStampInUserProfile'()

println CurrentTime

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(TimeStamp, CurrentTime, "After scheduling a visit, incorrect time stamp is shown in the user profile")

WebUI.clickOffset(findTestObject('Object Repository/UserProfile/OffsetFromUserprofile'), 10, 10)

WebUI.waitForElementVisible(findTestObject('Object Repository/Requests/ScheduledRadioButton'), 0)

WebUI.click(findTestObject('Object Repository/Requests/ScheduledRadioButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Requests/StudentNameInRequestsPage(student)', ["student":Student]), "After scheduling a request the visit is not shown in the Pending tab is the Requests page")

