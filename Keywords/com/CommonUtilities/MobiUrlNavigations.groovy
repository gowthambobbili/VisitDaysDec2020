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


class MobiUrlNavigations {

	@Keyword
	def NavigateTospecifiedEventType(String VisittTypeId) {
		WebUI.navigateToUrl("https://pikachu-student.visitdays.com/bbtesting/ci/testing?eventTypes="+VisittTypeId)
	}

	@Keyword
	def NavigateTospecifiedEventId(String EventId) {
		WebUI.navigateToUrl("https://pikachu-student.visitdays.com/bbtesting/ci/testing?eventId="+EventId)
	}

	@Keyword
	def NavigateToGivenCategoryAndAudienceLink(String Audience, String Category) {
		WebUI.navigateToUrl("https://pikachu-student.visitdays.com/bbtesting/ci/testing?category="+Category+"&audience="+Audience)
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)
	}

	@Keyword
	def NavigateToGivenVisitTypeIdAndAudienceLink(String Audience, String VisitTypeId) {
		WebUI.navigateToUrl("https://pikachu-student.visitdays.com/bbtesting/ci/testing?eventTypes="+VisitTypeId+"&audience="+Audience)
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)
	}

	@Keyword
	def NavigateToGivenVisitIdAndAudienceLink(String Audience, String VisitId) {
		WebUI.navigateToUrl("https://pikachu-student.visitdays.com/bbtesting/ci/testing?eventId="+VisitId+"&audience="+Audience)
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)
	}
}





















