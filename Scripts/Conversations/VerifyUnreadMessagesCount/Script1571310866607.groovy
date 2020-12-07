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

println PhoneNumber
//WebUI.delay(65)

//def StudentName = CustomKeywords.'com.CommonUtilities.Conversations.RegisterAStudentWithGivenPhoneNumber'(PhoneNumber)

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegisteredStudent(Name)', ["Name":StudentName]), "The registered student is not in the details page")

WebUI.click(findTestObject('Object Repository/HomePageElements/ConversationsIcon'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Coversations/InboxLeftNav'), 0)

def SmsCount

//WebUI.delay(5)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Coversations/UnreadMessagesCountBadge'), 10, FailureHandling.OPTIONAL) && WebUI.getText(findTestObject('Object Repository/Coversations/UnreadMessagesCountBadge'))!="")
{
	SmsCount = Integer.parseInt((WebUI.getText(findTestObject('Object Repository/Coversations/UnreadMessagesCountBadge'))))
}
else
{
	SmsCount = 0
}

CustomKeywords.'com.CommonUtilities.Conversations.NavigateToSimulatedSmsPage'()

def SmsContent = "Test sms "+Random.nextInt(1000000)

CustomKeywords.'com.CommonUtilities.Conversations.SendSms'(PhoneNumber, SmsContent)

WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/messenger/inbox/conversations")

CustomKeywords.'com.CommonUtilities.Conversations.verifySmsCount'(SmsCount)













