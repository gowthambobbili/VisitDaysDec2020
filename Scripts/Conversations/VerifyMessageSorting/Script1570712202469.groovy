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

def num1 = Random.nextInt(10).toString()

def num2 = Random.nextInt(10).toString()

def PhoneNumber = "20155501"+num1+num1

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def VisitType = CustomKeywords.'com.CommonUtilities.VisitTypeCreationUserflow.CreateVisitTypeWithSpecifiedValues'([:])

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

def StudentName = CustomKeywords.'com.CommonUtilities.Conversations.RegisterAStudentWithGivenPhoneNumber'(PhoneNumber)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/Details Page/RegisteredStudent(Name)', ["Name":StudentName]), "The registered student is not in the details page")

CustomKeywords.'com.CommonUtilities.Conversations.NavigateToSimulatedSmsPage'()

def Sms1 = "Test sms "+Random.nextInt(1000000)
def Sms2 = "Test sms "+Random.nextInt(1000000)
def Sms3 = "Test sms "+Random.nextInt(1000000)

def SmsList = [Sms1, Sms2, Sms3]

for(int Sms=0;Sms<3;Sms++)
{
	WebUI.clearText(findTestObject('Object Repository/Self serve objects/SimulatedSms/PhoneNumberField'))
	CustomKeywords.'com.CommonUtilities.Conversations.SendSms'(PhoneNumber, SmsList[Sms])
	WebUI.delay(4)
}

WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/messenger/inbox/conversations")

CustomKeywords.'com.CommonUtilities.Conversations.VerifyLatestMessageIsShownOnTheConversation'(StudentName, Sms3)

WebUI.click(findTestObject('Object Repository/Coversations/FirstConversationInTheList'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Coversations/SmsTextArea'), 0)

CustomKeywords.'com.CommonUtilities.Conversations.VerifyMessagesOrderInConveration'(SmsList)










