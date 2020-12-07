import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/AccountBasicsInTopNav'))

WebUI.waitForPageLoad(10)

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SmokeTests.verifyMyAccountPage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonalInfoTabInAccountbasicspage'), "Personal Info tab is not present in the Account page")

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonalInfoTabInAccountbasicspage'))

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SmokeTests.verifyPersonalInfoPage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/NotificationstabInPersonalDeatailsPage'), "Notifications tab is not present in the Account page")

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/NotificationstabInPersonalDeatailsPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/Account/PreferenceHeader'), "Preferences header is not present in the Notifications tab")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/Account/EmailsCheckbox'), "Emails checkbox is not present in the Notifications tab")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/Account/TextMessagesCheckbox'), "Text Messages checkbox is not present in the Notifications tab")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/Intercom'), "Intercom icon is not present in the Notifications tab")

