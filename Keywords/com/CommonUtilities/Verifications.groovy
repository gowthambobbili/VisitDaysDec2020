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
import com.kms.katalon.core.webui.keyword.builtin.VerifyElementPresentKeyword
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


class Verifications {

	@Keyword
	def VerifyElementPresent(TestObject object, String FailureDescription) {
		if(!(WebUI.verifyElementPresent(object, 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(FailureDescription)
		}
	}

	@Keyword
	def VerifyElementPresentAndStopExecutionIfFailed(TestObject object, String FailureDescription) {
		if(!(WebUI.verifyElementPresent(object, 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(FailureDescription)
		}
	}

	@Keyword
	def VerifyElementNotPresent(TestObject object, String FailureDescription) {
		if(!(WebUI.verifyElementNotPresent(object, 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(FailureDescription)
		}
	}

	@Keyword
	def VerifyElementNotPresentStopExecutionIfFailed(TestObject object, String FailureDescription) {
		if(!(WebUI.verifyElementNotPresent(object, 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(FailureDescription)
		}
	}

	@Keyword
	def VerifyVisitPresentInMobi(String VisitType) {
		def VisitInMobi = new TestObject("Created visit in Mobi")
		VisitInMobi.addProperty("xpath", ConditionType.EQUALS, "//strong[text()='"+VisitType+"']/../../../..//button[@class=' mobi-daily-visit--hours-item']")
		if(!(WebUI.verifyElementPresent(VisitInMobi, 0))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("The created visit is not shown in Mobi")
		}
	}

	@Keyword
	def VerifyTextMatch(String ActualText, String ExpectedText, String FailureDescription) {
		if(!(WebUI.verifyMatch(ActualText, ExpectedText, false, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(FailureDescription)
		}
	}

	@Keyword
	def VerifyElementNotClickable(TestObject Element, String FailureDescription){
		if(!(WebUI.verifyElementNotClickable(Element, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(FailureDescription)
		}
	}
	@Keyword
	def VerifyElementClickable(TestObject Element, String FailureDescription){
		if(!(WebUI.verifyElementClickable(Element, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(FailureDescription)
		}
	}

	@Keyword
	def VerifyElementVisible(TestObject Element, String FailureDescription){
		if(!(WebUI.verifyElementVisible(Element, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(FailureDescription)
		}
	}

	@Keyword
	def VerifyElementNotVisible(TestObject Element, String FailureDescription){
		if(!(WebUI.verifyElementNotVisible(Element, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(FailureDescription)
		}
	}

	@Keyword
	def verifyElementChecked(TestObject element, String failureDescription){

		if(!(WebUI.verifyElementChecked(element, 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(failureDescription)
		}
	}

	@Keyword
	def verifyElementNotChecked(TestObject element, String failureDescription){

		if(!(WebUI.verifyElementNotChecked(element, 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed(failureDescription)
		}
	}
}

