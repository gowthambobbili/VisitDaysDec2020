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


class Quit {

	Verifications Verifications = new Verifications()

	@Keyword
	def QuitMobi() {
		WebUI.delay(3)
		WebUI.switchToDefaultContent()
		WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)
	}

	@Keyword
	def CloseMobiInConfirmationPage() {
		WebUI.delay(2)
		WebUI.switchToDefaultContent()
		WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)
		Verifications.VerifyElementNotPresentStopExecutionIfFailed(findTestObject("Object Repository/Add Attendee/CompleteButtonInAddAttendee"), "When clicked the Complete button the mobi is not getting closed")
	}

	@Keyword
	def CloseMobiInConfirmationPageForInstantBook() {
		WebUI.delay(2)
		WebUI.switchToDefaultContent()
		WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)
		Verifications.VerifyElementNotPresentStopExecutionIfFailed(findTestObject("Object Repository/Add Attendee/CompleteButtonInAddAttendee"), "When clicked the Complete button the mobi is not getting closed")
	}

	@Keyword
	def ExitMobi() {
		WebUI.click(findTestObject('Add Attendee/CloseButtonInAddAttendee'))
		WebUI.waitForElementPresent(findTestObject('Add Attendee/QuitButtonInExitConfirmationPopupInMobi'), 0)
		WebUI.delay(3)
		WebUI.click(findTestObject('Add Attendee/QuitButtonInExitConfirmationPopupInMobi'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(2)
		WebUI.switchToDefaultContent()
		WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)
	}
}
