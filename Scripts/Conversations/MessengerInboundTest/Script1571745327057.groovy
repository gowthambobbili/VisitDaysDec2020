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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

Random Random = new Random()

def num1 = Random.nextInt(10).toString()

def num2 = Random.nextInt(10).toString()

def PhoneNumber = "20155501"+num1+num1

println PhoneNumber

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def VisitType = CustomKeywords.'com.CommonUtilities.VisitTypeCreationUserflow.CreateVisitTypeWithSpecifiedValues'([:])

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

def StudentName = CustomKeywords.'com.CommonUtilities.Conversations.RegisterAStudentWithGivenPhoneNumber'(PhoneNumber)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegisteredStudent(Name)', ["Name":StudentName]), "The registered student is not in the details page")

WebUI.waitForPageLoad(4)

CustomKeywords.'com.CommonUtilities.Conversations.NavigateToSimulatedSmsPage'()

def SmsContent = "Test sms "+Random.nextInt(1000000)

CustomKeywords.'com.CommonUtilities.Conversations.SendSms'(PhoneNumber, SmsContent)

//WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/albrightsandbox/messenger/inbox/conversations")
WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/messenger/inbox/conversations")

def FirstuserInConvesations = WebUI.getText(findTestObject('Object Repository/Coversations/FirstConversationInTheList'))

if(!(FirstuserInConvesations.contains(StudentName)))
{
	WebUI.takeScreenshot()
//	KeywordUtil.markFailedAndStop("The inbound message is not shown in conversations")
}

WebUI.click(findTestObject('Object Repository/Coversations/FirstConversationInTheList'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/SmsTextArea'), "When click on a open conversation, the sms text area is not shown")

WebUI.delay(7)

def LatestInboundSms = WebUI.getText(findTestObject('Object Repository/Coversations/LatestInboundSms'))

println LatestInboundSms

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(LatestInboundSms, SmsContent, "The sent sms content and the revoeved sms content is not matching. Sent content: "+SmsContent+", Received content:"+LatestInboundSms)






