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

WebUI.navigateToUrl(GlobalVariable.SelfServeUrl)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Self serve objects/EmailTextBox'), "The self serve tool is not getting opened")

WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/EmailTextBox'), 'test.user1@qualitlabs.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Self serve objects/PasswordTextField'), "vGm4WD5Mwh5DcgtLXIeBlg==")

WebUI.click(findTestObject('Object Repository/Self serve objects/LoginButton'))

//http://vd-api-staging-pikachu.herokuapp.com/web/bbtesting/institution_settings/1431/edit

WebUI.navigateToUrl(GlobalVariable.SelfServeUrl+GlobalVariable.Institution+"/institution_settings")

def Setting1 = 'surveys_app_yield'

WebUI.click(findTestObject('Object Repository/Self serve objects/EditButtonOfSpecifiedInstitutioinSetting(setting)', ["setting":Setting1]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Self serve objects/Survey_app_yieldHeader'), "The Survey_app_yield setting is not getting opened")

def SettingUrl = WebUI.getUrl()

def FlagValue = WebUI.getAttribute(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "value")

println FlagValue

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()
WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
WebUI.waitForElementClickable(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'), 0)
WebUI.click(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'))

if(FlagValue=='true')
{
	CustomKeywords.'com.CommonUtilities.SelfServeUtilities.VerifyWhenSurvey_App_YieldFlagisTrue'(SettingUrl)
}
else
{
	CustomKeywords.'com.CommonUtilities.SelfServeUtilities.VerifyWhenSurvey_App_YieldFlagisFalse'(SettingUrl)
}















