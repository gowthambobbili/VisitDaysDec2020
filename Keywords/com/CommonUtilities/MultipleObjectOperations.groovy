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
import org.openqa.selenium.WebElement
import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class MultipleObjectOperations {

	@Keyword
	def GetVisitTypesFromVisitTypeDropDownWhileCreating(String VisitType) {

		List var = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/DailyVisitsPage/allvisittypes'), 0)

		String[] allNames = new String[1000]

		for (int j = 0; j < var.size; j++) {
			allNames[j] = var[j].getText()

			println(var[j].getText())

			println(j)
		}

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		for (int i = 0; i < var.size; i++) {

			def VisitTypeFromFromVisitTypesDropdownWhilecreatingDailyVisit = new TestObject("VisitTypeFromDailyVisits");

			VisitTypeFromFromVisitTypesDropdownWhilecreatingDailyVisit.addProperty("xpath", ConditionType.EQUALS, "//*[text()='"+allNames[i]+"']")

			WebUI.verifyElementPresent(VisitTypeFromFromVisitTypesDropdownWhilecreatingDailyVisit, 0)
		}
	}
}