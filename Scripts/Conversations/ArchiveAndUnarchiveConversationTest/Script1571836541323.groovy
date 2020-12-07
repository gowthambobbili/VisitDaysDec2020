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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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

CustomKeywords.'com.CommonUtilities.Conversations.NavigateToSimulatedSmsPage'()

def SmsContent = "Test sms "+Random.nextInt(1000000)

WebUI.waitForPageLoad(3)

CustomKeywords.'com.CommonUtilities.Conversations.SendSms'(PhoneNumber, SmsContent)

WebUI.delay(3)

WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/messenger/inbox/conversations")

println StudentName

CustomKeywords.'com.CommonUtilities.Conversations.VerifyLatestMessageIsShownOnTheConversation'(StudentName, SmsContent)



//if(StudentName.contains())

WebUI.click(findTestObject('Object Repository/Coversations/Conversation(student)', ["student":StudentName]))

WebUI.click(findTestObject('Object Repository/Coversations/archiveButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/UnArchiveIcon'), "When Click On Archive button, the Un archove button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/UnArchiveConversationButton'), "When Click On Archive button, the Unarchive Conversation button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/SmsTextArea'), "When Click On Archive button, Sms text area is still shown")

WebUI.click(findTestObject('Object Repository/Coversations/UnArchiveIcon'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/archiveButton'), "When click Unarchive button, the archive button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/SmsTextArea'), "When click Unarchive button, the Sms text area is not shown")



