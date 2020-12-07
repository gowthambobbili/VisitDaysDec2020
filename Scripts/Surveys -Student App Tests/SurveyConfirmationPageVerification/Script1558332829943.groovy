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

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/MobiLeftNav'),
		'Mobi left nav is not present in the home page')

WebUI.click(findTestObject('HomePageElements/MobiLeftNav'))

WebUI.click(findTestObject('Object Repository/HomePageElements/Mobi/Mobi-SettingsLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('MobiPage/GeneratePreviewButtonInMobi'),
		'When clicked Mobi left nav the Generate preview button is not shown')

String SecondaryColor = WebUI.getAttribute(findTestObject('MobiPage/SecondaryColorInMobi'), 'style')

SecondaryColor = (SecondaryColor.split(': ')[1].split(';')[0])

println(SecondaryColor)

if(GlobalVariable.Institution.equals("bbtesting"))

	WebUI.navigateToUrl(GlobalVariable.StudentAppUrl+"bbtesting/surv/8V7HDCOB")
else
	WebUI.navigateToUrl(SurveyLink)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/ThankyouTextInSurveyConfirmationPage'),
		'Thank you message is not shown in the Survey confirmation page')

String MessageInSurveyConfirmationPage = WebUI.getText(findTestObject('Survey-Student App Objects/MessageInSurveyConfirmationPage'))

println(MessageInSurveyConfirmationPage)

WebUI.waitForElementPresent(findTestObject('Survey-Student App Objects/FacebookIconInConfirmationPage'), 0)

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/FacebookIconInConfirmationPage'),
		'Facebook icon is not present in the survey confitmation page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/TwitterIconInSurveyConfirmationPage'),
		'Twitter icon is not present in the survey confirmation page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/MailIconInSurveyConfirmationPage'),
		'Mail icon is not present in the survey confirmation page')

WebUI.click(findTestObject('Survey-Student App Objects/FacebookIconInConfirmationPage'))

WebUI.switchToWindowIndex(1)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/FacebookHomePageLink'),
		'In the survey confirmation page, when clicked on Facebook icon the Facebook window is not opened ')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/FacebookEmailAdressField'),
		'In the Facebook window email id field is not present')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/FaceBookPasswordField'),
		'In the Facebook window passwod field is not present')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/FacebookLoginButton'),
		'In the Facebook window Login button is not present')

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/FacebookLoginButton'),
		'The facebook window is not getting closed in the survey confirmation page')

WebUI.click(findTestObject('Survey-Student App Objects/TwitterIconInSurveyConfirmationPage'))

WebUI.switchToWindowTitle('Share a link on Twitter')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/TwitterLogo'),
		'When clicked Twitter icon in the survey confirmation page the Twitter tab is not opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/TwitterShareMessageField'),
		'Twitter share message is not present in the Twitter window')

TwitterShareMessage = WebUI.getText(findTestObject('Survey-Student App Objects/TwitterShareMessageField'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(TwitterShareMessage.trim(), 'Just finished my visit with @Test8 via @VisitDays! https://s.visitdays.com/'+GlobalVariable.Institution+'/evr',
		'The twitter share message is shown incorrect')

WebUI.closeWindowTitle('Share a link on Twitter')

WebUI.switchToWindowIndex(0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/MailIconInSurveyConfirmationPage'),
		'Mail icon is not present in the survey confirmation page')

String ColourInConfirmationPage = WebUI.getCSSValue(findTestObject('Survey-Student App Objects/ConfirmationPageBackgroundColour'), 'background-color')

println(ColourInConfirmationPage)

String Colors = (SecondaryColor.split('rgb')[1])

SecondaryColor = ("rgba" + Colors)

println(SecondaryColor)

ColourInConfirmationPage = ColourInConfirmationPage.minus(", 1)")
ColourInConfirmationPage = ColourInConfirmationPage.concat(")")
println ColourInConfirmationPage
CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ColourInConfirmationPage, SecondaryColor, "The back ground color in the Survey confirmation page is shown incorrect")

