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



class PopoverVerification {

	//mark555
	@Keyword
	def MyItineraryPopoverVerification(String VisitType, TestObject VisitTypeCategory)
	{

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		WebUI.delay(7)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.delay(3)

		WebUI.click(VisitTypeCategory)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/FiterByLocationCheckboxInOffCampus'), 0)

		WebUI.delay(20)
		WebUI.delay(15)
		driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

		driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

		WebUI.delay(15)

		WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))

		WebUI.delay(2)

		//		WebUI.verifyElementText(findTestObject('Add Attendee/VisitTypeNameInPopOver'), VisitType)

		//		WebUI.click(findTestObject('Add Attendee/CloseButtonInMyItineraryPopover'))

		WebUI.delay(2)

		def object = new TestObject("CreatedVisitInMobi")

		object.addProperty("xpath", ConditionType.EQUALS, "//strong[text()='"+VisitType+"']/../../../..//button[text()='Add to My Itinerary']")

		WebUI.verifyElementPresent(object, 0)

		WebUI.click(object)

		driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()

		WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))

		WebUI.delay(2)

		WebUI.verifyElementText(findTestObject('Add Attendee/VisitTypeNameInPopOver'), VisitType)

		println(object)

		WebUI.click(findTestObject('Add Attendee/CloseButtonInMyItineraryPopover'))

		WebUI.delay(2)
	}

}
