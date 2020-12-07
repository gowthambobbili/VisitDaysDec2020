import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

/*
 CustomKeywords.'com.CommonUtilities.SelfServeUtilities.LoginToSelfServeTool'()
 //http://vd-api-staging-pikachu.herokuapp.com/web/bbtesting/institution_settings/1431/edit
 WebUI.navigateToUrl(GlobalVariable.SelfServeUrl+GlobalVariable.Institution+"/institution_settings")
 def Setting1 = 'surveys_add_question'
 WebUI.click(findTestObject('Object Repository/Self serve objects/EditButtonOfSpecifiedInstitutioinSetting(setting)', ["setting":Setting1]))
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Self serve objects/Survey_app_yieldHeader'), "The Survey_add_question setting is not getting opened")
 def SettingUrl = WebUI.getUrl()
 def FlagValue = WebUI.getAttribute(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "value")
 println FlagValue
 CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()
 WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
 WebUI.waitForElementClickable(findTestObject('Object Repository/Survey-Admin App Objects/Questions'), 0)
 WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions'))
 if(FlagValue=='true')
 {
 CustomKeywords.'com.CommonUtilities.SelfServeUtilities.VerifyWhenSurvey_App_YieldFlagisTrue'(SettingUrl)
 }
 else
 {
 CustomKeywords.'com.CommonUtilities.SelfServeUtilities.VerifyWhenSurvey_App_YieldFlagisFalse'(SettingUrl)
 }
 */

CustomKeywords.'com.CommonUtilities.SelfServeUtilities.LoginToSelfServeTool'()

WebUI.navigateToUrl(GlobalVariable.SelfServeUrl+"bbtesting/institution_settings")

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Self serve objects/FlagAndStatus(flag, status)', ["flag":"survey_pro", "status":"true"]), 10, FailureHandling.OPTIONAL))
{
	VerifyWhenFlagIsTrue()
	WebUI.navigateToUrl(GlobalVariable.SelfServeUrl+"bbtesting/institution_settings")
	WebUI.click(findTestObject('Object Repository/Self serve objects/EditButtonOfSpecifiedInstitutioinSetting(setting)', ["setting":"survey_pro"]))
	WebUI.clearText(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'))
	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "false")
	WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'))
	WebUI.waitForElementNotPresent(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), 0, FailureHandling.STOP_ON_FAILURE)
	VerifyWhenFlagIsFalse()
}

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Self serve objects/FlagAndStatus(flag, status)', ["flag":"survey_pro", "status":"false"]), 10, FailureHandling.OPTIONAL))
{
	VerifyWhenFlagIsFalse()
	WebUI.navigateToUrl(GlobalVariable.SelfServeUrl+"bbtesting/institution_settings")
	WebUI.click(findTestObject('Object Repository/Self serve objects/EditButtonOfSpecifiedInstitutioinSetting(setting)', ["setting":"survey_pro"]))
	WebUI.clearText(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'))
	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "true")
	WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'))
	WebUI.waitForElementNotPresent(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), 0, FailureHandling.STOP_ON_FAILURE)
	VerifyWhenFlagIsTrue()
}

def VerifyWhenFlagIsTrue()
{
	CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()
	WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
	WebUI.click(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Survey/StarIcon(element)', ["element":"Applicants & Yield"]), "When the 'Survey_pro' flag is true, the star symbol is shown on the Applicants&yueld nav element ")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When the 'survey_pro' flag is true, the promo page is shown for Applicants&yield page")
	WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/PerformanceTab'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Survey/StarIcon(element)', ["element":"Performance"]), "When the 'Survey_pro' flag is true, the star symbol is shown on the Performance nav element ")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When the 'survey_pro' flag is true, the promo page is shown for Survey-performance page")
	WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/AddQuestionButton'), "When login to admin account, Add Question button is not present in Questions page")
	WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/AddQuestionButton'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/IntercomIframe'), "When 'survey_pro' flag is true, if user clicks 'Add Question' button in Survey-Questions page, the Intercom is not opening")

}

def VerifyWhenFlagIsFalse()
{
	CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()
	WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
	WebUI.click(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Survey/StarIcon(element)', ["element":"Applicants & Yield"]), "When the 'Survey_pro' flag is false, the star symbol is not shown on the Applicants&yield nav element")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When the 'survey_pro' flag is false, the promo page is not shown in Applicants&yield page")
	WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/PerformanceTab'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Survey/StarIcon(element)', ["element":"Performance"]), "When the 'Survey_pro' flag is false, the star symbol is not shown on the Performance nav element")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When the 'survey_pro' flag is false, the promo page is not shown in Performance page")
	WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions'))
	WebUI.click(findTestObject('Object Repository/Survey-Admin App Objects/Questions page/AddQuestionButton'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When 'survey_pro' flag is false, if user clicks 'Add Question' button in Survey-Questions page, the Survey-promo page is not shown")

}












