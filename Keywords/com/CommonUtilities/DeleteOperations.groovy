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


class DeleteOperations {

	@Keyword
	def DeleteVisitType() {

		WebUI.click(findTestObject('VisitTypesPage/DeleteButtonInDetailsPageOfVisitType'))

		WebUI.click(findTestObject('VisitTypesPage/FirstCheckboxInDeleteVisitTypeModal'))

		WebUI.click(findTestObject('VisitTypesPage/SecondCheckBoxInDeleteVisitTypeModal'))

		WebUI.click(findTestObject('VisitTypesPage/ThierdCheckBoxInDeleteVisitTypeModal'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameTextBoxInDeleteVisitTypeModal'), 'Modified Visit Name')

		WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeInDeleteVisitTypeModal'))

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'))
	}

	@Keyword
	def DeleteGivenVisitType(String VisitType) {

		WebUI.click(findTestObject('VisitTypesPage/DeleteButtonInDetailsPageOfVisitType'))

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/FirstCheckboxInDeleteVisitTypeModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/FirstCheckboxInDeleteVisitTypeModal'))

		WebUI.click(findTestObject('VisitTypesPage/SecondCheckBoxInDeleteVisitTypeModal'))

		WebUI.click(findTestObject('VisitTypesPage/ThierdCheckBoxInDeleteVisitTypeModal'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameTextBoxInDeleteVisitTypeModal'), VisitType)

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/DeleteVisitTypeInDeleteVisitTypeModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeInDeleteVisitTypeModal'))

		WebUI.waitForElementVisible(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'))
	}
}
