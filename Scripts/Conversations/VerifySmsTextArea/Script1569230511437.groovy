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
import org.openqa.selenium.Keys as Keys

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/ConversationsIcon'),
		'The Text sms icon is not present in the homw page')

WebUI.click(findTestObject('Object Repository/HomePageElements/ConversationsIcon'))

WebUI.click(findTestObject('Object Repository/Coversations/FirstConversationInTheList'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Coversations/SmsTextArea'),
		'When click on a conversation, the sms text area is not present')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotClickable'(findTestObject('Object Repository/Coversations/SendButton'),
		'When there is no text entered in the sms text area, the send button is clickable')

def RandomString = 'abc defgh ijklm nopqrs tuvwxyz 01234567 '

def IntialSmsCount = WebUI.getText(findTestObject('Object Repository/Coversations/TextCount'))

println(IntialSmsCount)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(IntialSmsCount, '0/160', 'When there is no text entered in the sms text area, the count shows incorrect. Expected: 0/160, actual: ' +
		IntialSmsCount)

WebUI.sendKeys(findTestObject('Object Repository/Coversations/SmsTextArea'), RandomString)

def SmsCount = WebUI.getText(findTestObject('Object Repository/Coversations/TextCount'))

println(SmsCount)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(SmsCount, '40/160', 'After entering 40 charecteres in the sms text area, the count shows incorrect. Expected: 40/160, actual: ' +
		SmsCount)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementClickable'(findTestObject('Object Repository/Coversations/SendButton'),
		'After enetring text in Sms text area, the Send button is not clickable(Disabled)')

WebUI.sendKeys(findTestObject('Object Repository/Coversations/SmsTextArea'), RandomString)

WebUI.sendKeys(findTestObject('Object Repository/Coversations/SmsTextArea'), RandomString)

WebUI.sendKeys(findTestObject('Object Repository/Coversations/SmsTextArea'), RandomString)

SmsCount = WebUI.getText(findTestObject('Object Repository/Coversations/TextCount'))

println(SmsCount)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(SmsCount, '160/160 (2 SMS)', 'When enter 160 charecters in the sms text area the count shows incorrect. Expected: 160/160 (2 SMS), Actual: ' +
		SmsCount)

WebUI.click(findTestObject('Object Repository/Coversations/SmsTextArea'))

WebUI.sendKeys(findTestObject('Coversations/SmsTextArea'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE))

SmsCount = WebUI.getText(findTestObject('Object Repository/Coversations/TextCount'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(SmsCount, '158/160', 'After entering 160 charecters if clear two charecters, the count is shown incorrect. Expected: 158/160 (2 SMS), Actual: ' +
		SmsCount)








