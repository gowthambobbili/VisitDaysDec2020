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

def visitType1Detail = CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitTypeUsingApi'()

def visitType = visitType1Detail.visitType

def visitTypeId = visitType1Detail.get("visitTypeId")

println visitTypeId

CustomKeywords.'com.CommonUtilities.ApiCalls.createVisitUsingApi'(visitTypeId)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(visitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

def visitId = WebUI.getUrl().split("visits/")[1]

println visitId

CustomKeywords.'com.CommonUtilities.SelfServeUtilities.LoginToSelfServeTool'()

for(int i=1;i<=87;i++)
{

	Random Random = new Random()

	def num1 = Random.nextInt(10).toString()

	def num2 = Random.nextInt(10).toString()

	def PhoneNumber = "20155501"+num1+num1

	println PhoneNumber

	CustomKeywords.'com.CommonUtilities.ApiCalls.registerIndividual'(["visitId":visitId, "visitTypeId":visitTypeId, "phoneNumber":PhoneNumber])

	CustomKeywords.'com.CommonUtilities.Conversations.NavigateToSimulatedSmsPage'()

	def SmsContent = "Test sms "+Random.nextInt(1000000)

	CustomKeywords.'com.CommonUtilities.Conversations.SendSms'(PhoneNumber, SmsContent)
}

//
////WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/albrightsandbox/messenger/inbox/conversations")
//WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/messenger/inbox/conversations")
//
//def FirstuserInConvesations = WebUI.getText(findTestObject('Object Repository/Coversations/FirstConversationInTheList'))
//
////if(!(FirstuserInConvesations.contains(StudentName)))
////{
////	WebUI.takeScreenshot()
////	KeywordUtil.markFailedAndStop("The inbound message is not shown in conversations")
////}




