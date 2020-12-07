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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/ConversationsNav'), "Conversations nav icon is not present in the homepage")

WebUI.click(findTestObject('Object Repository/HomePageElements/ConversationsNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/InboxLeftNav'), "When click Conversations left nav, the Inbox tab is not shown")

def UserName = WebUI.getText(findTestObject('Object Repository/Coversations/UserNameOfFirstConversation'))

WebUI.click(findTestObject('Object Repository/Coversations/UserNameOfFirstConversation'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/Spinner'), "When click on a conversation, the loading spinner is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Coversations/SelectedState(username)', ["username":UserName]), "When click on a conversation the selected state is not shown. The selected conversation is: "+UserName)









