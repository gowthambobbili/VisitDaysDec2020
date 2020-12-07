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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

//CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(VisitTypeName)
CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateRequestDailyVisitWithFutureTimes'(VisitTypeName)
//CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitTypeName)
String Single = 'Single'

//String RegisteredStudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName'(
//		VisitTypeName, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

List ListOfVisitTypes =  [VisitTypeName]

String RegisteredStudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'(ListOfVisitTypes, findTestObject('Object Repository/Add Attendee/DailyVisitsOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Requests/StudentNameInRequestsPage(student)', ["student": RegisteredStudentName]), "The requested student profile is not present in the pending tab of requests page")

WebUI.click(findTestObject('Object Repository/Requests/StudentNameInRequestsPage(student)', ["student": RegisteredStudentName]))
//driver.findElement(By.xpath(('//span[text()="' + RegisteredStudentName) + '"]')).click()

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

StudentNameInUserProfile = WebUI.getText(findTestObject('UserProfile/StudentNameInUserProfile'))

println StudentNameInUserProfile

WebUI.verifyMatch(StudentNameInUserProfile, RegisteredStudentName, false, FailureHandling.CONTINUE_ON_FAILURE)

NumberOfAttendees = WebUI.getText(findTestObject('UserProfile/NumberOfGuestInIndividualProfile'))

WebUI.verifyMatch(NumberOfAttendees, 'NO GUESTS', false, FailureHandling.STOP_ON_FAILURE)

