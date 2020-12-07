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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.callTestCase(findTestCase('Surveys -Student App Tests/NavigateToSurveyPage'), [:], FailureHandling.STOP_ON_FAILURE)

String charset = ('A'..'Z') + ('0'..'9').join()

int AcceptableLength = 800

int AtCapacity = 1000

int AboveCapacity = 1005

String BelowCount = RandomStringUtils.random(AcceptableLength, charset.toCharArray())

String AtCount = RandomStringUtils.random(AtCapacity, charset.toCharArray())

String AboveCount = RandomStringUtils.random(AboveCapacity, charset.toCharArray())

InitialCharecterCount = WebUI.getText(findTestObject('Survey-Student App Objects/CharacterCount'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(InitialCharecterCount, '0 / 10000', 'The initial character count for the survey text area is shown incorrect')

WebUI.click(findTestObject('Survey-Student App Objects/TextAreaInSurveyQuestion'))

WebUI.sendKeys(findTestObject('Survey-Student App Objects/TextAreaInSurveyQuestion'), BelowCount)

CountAfterEntering800Chracteres = WebUI.getText(findTestObject('Survey-Student App Objects/CharacterCount'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(CountAfterEntering800Chracteres, '800 / 10000', 'When entered 800 characteres into the text area, the caracer count is shown incorrect')

CurrentUrl = WebUI.getUrl()

WebUI.navigateToUrl(CurrentUrl)

//WebUI.delay(15)
WebUI.clearText(findTestObject('Survey-Student App Objects/TextAreaInSurveyQuestion'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Survey-Student App Objects/TextAreaInSurveyQuestion'), AtCount)

CountAfterEntering1000Chracteres = WebUI.getText(findTestObject('Survey-Student App Objects/CharacterCount'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(CountAfterEntering1000Chracteres, '1000 / 10000', 'When entered 1000 characteres into the text area, the caracer count is shown incorrect')

WebUI.navigateToUrl(CurrentUrl)

WebUI.clearText(findTestObject('Survey-Student App Objects/TextAreaInSurveyQuestion'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Survey-Student App Objects/TextAreaInSurveyQuestion'), AboveCount)

CountAfterEntering1005Chracteres = WebUI.getText(findTestObject('Survey-Student App Objects/CharacterCount'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(CountAfterEntering1005Chracteres, '1005 / 1000', 'When entered 1005 characteres into the text area, the caracer count is shown incorrect')

