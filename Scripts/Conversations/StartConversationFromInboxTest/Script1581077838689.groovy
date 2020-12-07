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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

Random Random = new Random()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def VisitType = CustomKeywords.'com.CommonUtilities.VisitTypeCreationUserflow.CreateVisitTypeWithSpecifiedValues'([:])

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

def PhoneNumber = CustomKeywords.'com.CommonUtilities.Conversations.GenerateRanodPhoneNumber'()

def StudentName = CustomKeywords.'com.CommonUtilities.Conversations.RegisterAStudentWithGivenPhoneNumber'(PhoneNumber)

WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/messenger/inbox/conversations")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/SearchBox'), "In Conversations page the search field is not present")

WebUI.clearText(findTestObject('Object Repository/Coversations/SearchBox'))

WebUI.sendKeys(findTestObject('Object Repository/Coversations/SearchBox'), "rendom text 43")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/SeaerchEmptyState'), "When the search text is matched with any student then the empty state message is not shown")

WebUI.sendKeys(findTestObject('Object Repository/Coversations/SearchBox'), StudentName)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/SearchhResult(studentName)', ["studentName":StudentName]), "When Search with student name the search results are not shown")

WebUI.click(findTestObject('Object Repository/Coversations/SearchhResult(studentName)', ["studentName":StudentName]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/SmsTextArea'), "When Select a user from search results, the sms text area is not shown")

WebUI.sendKeys(findTestObject('Object Repository/Coversations/SmsTextArea'), "Test sms")

def num1 = Random.nextInt(10).toString()

def num2 = Random.nextInt(10).toString()

PhoneNumber = "20155501"+num1+num1

println PhoneNumber














