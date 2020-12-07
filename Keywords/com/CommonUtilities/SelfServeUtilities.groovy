package com.CommonUtilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class SelfServeUtilities {

	Verifications Verify = new Verifications()
	LoginAsDifferentUserPermissions Navigate = new LoginAsDifferentUserPermissions()

	@Keyword
	def LoginToSelfServeTool() {

		WebUI.navigateToUrl(GlobalVariable.SelfServeUrl)

		WebUI.waitForPageLoad(5)

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/EmailTextBox'), "The self serve tool is not getting opened")

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/EmailTextBox'), 'test.user1@qualitlabs.com')

		WebUI.setEncryptedText(findTestObject('Object Repository/Self serve objects/PasswordTextField'), "vGm4WD5Mwh5DcgtLXIeBlg==")

		WebUI.click(findTestObject('Object Repository/Self serve objects/LoginButton'))
	}



	@Keyword
	def TestTrue(String SettingUrl, String PageName, String FlagName, TestObject ObjectToBePresent) {
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "Survvey promo page is shown in "+PageName+" page even if the "+FlagName+" flag is true in institutions_settings")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(ObjectToBePresent, "When "+FlagName+" flag is true the "+PageName+" page is not shown")
		WebUI.navigateToUrl(SettingUrl)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), 0)
		WebUI.clearText(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'))
		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "false")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "Update Institution setting button is not present for the "+FlagName+" setting")
		WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'))
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "In "+FlagName+" self serve setting, after changing the value to false and clicking Update institute settings button, the page is stil shown and the flag is not getting saved")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/FlagAndStatus(flag, status)', ["flag":FlagName, "status":"false"]), "In "+FlagName+" self serve setting, after changing the value to false and clicking Update institute settings button, it shows true in settings page")

		Navigate.NavigateToHomePage()
		WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'), 0)
		WebUI.click(LeftNav)
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When set the "+FlagName+" flag to false, the survey promote page is not shown in "+PageName+" page")
		Navigate.NavigateToHomePage()
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/survey/yield?tabShown=applied")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When set the "+FlagName+" flag to false, if user navigate to the page using url the survey promote page is not shown in "+PageName+" page")
	}

	@Keyword
	def VerifyWhenSurvey_App_YieldFlagisTrue(SettingUrl) {
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "Survvey promo page is shown in Applicants&Yield page even if the 'Survey_app_yield' flag is true in institutions_settings")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AllReadyAppliedTab'), "When 'the Survey_app_yield' flag is true the Applicants&Yield page is not shown")
		SetSurveyAppYieldFlagToFalse(SettingUrl)
		Navigate.NavigateToHomePage()
		WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'), 0)
		WebUI.click(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'))
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When set the Survey_apps_yield flag to false, the survey promote page is not shown in Applicants & yield page")
		Navigate.NavigateToHomePage()
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/survey/yield?tabShown=applied")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When set the Survey_apps_yield flag to false, if user navigate to the page using url the survey promote page is not shown in Applicants & yield page")
	}


	@Keyword
	def VerifyWhenSurvey_App_YieldFlagisFalse(def SettingUrl) {
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "Survvey promo page is not shown in Applicants&Yield page even if the 'Survey_app_yield' flag is False in institutions_settings")
		SetSurveyAppYieldFlagToTrue(SettingUrl)
		Navigate.NavigateToHomePage()
		WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'), 0)
		WebUI.click(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'))
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "The Survvey promo page is shown even if the 'Survey_app_yield' flag is set to true in institutions_settings")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AllReadyAppliedTab'), "When 'the Survey_app_yield' flag is set to true, the Applicants&Yield page is not getting opened")
		Navigate.NavigateToHomePage()
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/survey/yield?tabShown=applied")
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When user navogates to Applicants & yield using url, the Survvey promo page is shown even if the 'Survey_app_yield' flag is set to true in institutions_settings")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AllReadyAppliedTab'), "When 'the Survey_app_yield' flag is set to true, if user navigates to the Applicants&Yield page using url then the page is not getting opened")
	}

	@Keyword
	def SetSurveyAppYieldFlagToFalse(def SettingUrl) {
		WebUI.navigateToUrl(SettingUrl)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), 0)
		WebUI.clearText(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'))
		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "false")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "Update Institution setting button is not present for the 'Survey_app_yield' setting")
		WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'))
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "In Survey_app_yield self serve setting, after changing the value to false and clicking Update institute settings button, the page is stil shown and the flag is not getting saved")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/Survey_app_yieldFalse'), "In Survey_app_yield self serve setting, after changing the value to false and clicking Update institute settings button, it shows true in settings page")
	}

	@Keyword
	def SetSurveyAppYieldFlagToTrue(def SettingUrl) {
		WebUI.navigateToUrl(SettingUrl)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), 0)
		WebUI.clearText(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'))
		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "true")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "Update Institution setting button is not present for the 'Survey_app_yield' setting")
		WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'))
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "In Survey_app_yield self serve setting, after changing the value to true and clicking Update institute settings button, the page is stil shown and the flag is not getting saved")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/Survey_app_yieldTrue'), "In Survey_app_yield self serve setting, after changing the value to true and clicking Update institute settings button, it shows false in settings page")
	}

	@Keyword
	def VerifyWhenSurvey_PerformanceFlagisTrue(SettingUrl) {
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "Survvey promo page is shown in Applicants&Yield page even if the 'Survey_app_yield' flag is true in institutions_settings")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AllReadyAppliedTab'), "When 'the Survey_Performance' flag is true the Survey performance page is not shown")
		SetSurveyAppYieldFlagToFalse(SettingUrl)
		Navigate.NavigateToHomePage()
		WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'), 0)
		WebUI.click(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'))
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When set the Survey_Performance flag to false, the survey promote page is not shown in Servey performance page")
		Navigate.NavigateToHomePage()
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/survey/yield?tabShown=applied")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When set the Survey_Performance flag to false, if user navigate to the page using url the survey promote page is not shown in Survey performance page")
	}


	@Keyword
	def VerifyWhenSurvey_PerformanceFlagisFalse(def SettingUrl) {
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "Survvey promo page is not shown in Survey performance page even if the 'Survey_performance' flag is False in institutions_settings")
		SetSurveyAppYieldFlagToTrue(SettingUrl)
		Navigate.NavigateToHomePage()
		WebUI.click(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'), 0)
		WebUI.click(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'))
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "The Survvey promo page is shown even if the 'Survey_performance' flag is set to true in institutions_settings")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AllReadyAppliedTab'), "When 'the Survey_performance' flag is set to true, the Survey performance page is not getting opened")
		Navigate.NavigateToHomePage()
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/survey/yield?tabShown=applied")
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/SurveyPromoPageObject'), "When user navigates to Survey Performance using url, the Survvey promo page is shown even if the 'Survey_performance' flag is set to true in institutions_settings")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AllReadyAppliedTab'), "When 'the Survey_performance' flag is set to true, if user navigates to the Survey_ page using url then the page is not getting opened")
	}

	@Keyword
	def SetSurvey_PerformanceFlagToFalse(def SettingUrl) {
		WebUI.navigateToUrl(SettingUrl)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), 0)
		WebUI.clearText(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'))
		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "false")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "Update Institution setting button is not present for the 'Survey_performance' setting")
		WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'))
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "In Survey_performance self serve setting, after changing the value to false and clicking Update institute settings button, the page is stil shown and the flag is not getting saved")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/Survey_app_yieldFalse'), "In Survey_performance self serve setting, after changing the value to false and clicking Update institute settings button, it shows true in settings page")
	}

	@Keyword
	def SetSurvey_PerformancedFlagToTrue(def SettingUrl) {
		WebUI.navigateToUrl(SettingUrl)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), 0)
		WebUI.clearText(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'))
		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "true")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "Update Institution setting button is not present for the 'Survey_performance' setting")
		WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'))
		Verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "In Survey_performance self serve setting, after changing the value to true and clicking Update institute settings button, the page is stil shown and the flag is not getting saved")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/Survey_app_yieldTrue'), "In Survey_performance self serve setting, after changing the value to true and clicking Update institute settings button, it shows false in settings page")
	}
}
