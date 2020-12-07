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

WebUI.waitForElementPresent(findTestObject('Object Repository/HomePageElements/RequestsOption'), 0)

def NumberOfRequests = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Requests/PendingRequestsCount')))

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestOffCampusVisitType'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithRequestVisitTypeWithFutureTimes'(VisitType)

def CurrentUrl = WebUI.getUrl()

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

//WebUI.delay(10))

def StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'([VisitType], findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

WebUI.navigateToUrl(CurrentUrl)

WebUI.waitForElementPresent(findTestObject('Object Repository/HomePageElements/RequestsOption'), 0)

def NumberOfRequestsAfterSubmittingARequest = WebUI.getText(findTestObject('Object Repository/Requests/PendingRequestsCount'))

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(NumberOfRequestsAfterSubmittingARequest, (NumberOfRequests+1).toString(), "After submitting a request the count on Request left nav is shown incorrect. Expected: "+(NumberOfRequests+1).toString()+", Actual: "+NumberOfRequestsAfterSubmittingARequest)

CustomKeywords.'com.CommonUtilities.CreateTestObject.clickElement'(findTestObject('Object Repository/HomePageElements/RequestsOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Requests/VisitTypeFilterDropDown'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/Requests/StudentNameInRequestsPage(student)', ["student":StudentName]), "After submitting a request, the request is not shown in Pending tab of Requests page")

