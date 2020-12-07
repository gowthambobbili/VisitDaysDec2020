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


class VisitTypeOperations {

	@Keyword
	def ArchiveVisitType(String VisitType) {
		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0)

		def Object2 = new TestObject('CreatedVisitTypeInVisitTypesList')

		Object2.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

		WebUI.click(Object2)

		WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/ArchiveVisitTypeButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ArchiveVisitTypeButton'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstCheckBoxInArchiveVisitTypeModal'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/secondCheckBoxInArchiveVisitTypeModal'), 0)

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/FirstCheckBoxInArchiveVisitTypeModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/FirstCheckBoxInArchiveVisitTypeModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('VisitTypesPage/secondCheckBoxInArchiveVisitTypeModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('VisitTypesPage/EnterVisitTypeTextBoxInArchiveVisitTypeModal'), VisitType)

		WebUI.click(findTestObject('VisitTypesPage/AciveVisitTypeButtonInModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/AciveVisitTypeButtonInModal'), 0)
	}
}