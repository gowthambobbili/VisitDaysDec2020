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


class EditRegistrantType {

	@Keyword
	def ChangeRegistrantTypeToGroupsOnly(String VisitType) {
		def VisitTypeInList = new TestObject("Visit Type In visit types list")
		VisitTypeInList.addProperty("xpath", ConditionType.EQUALS, "//h4[text()='"+VisitType+"']")
		WebUI.waitForElementClickable(VisitTypeInList, 0)
		WebUI.click(VisitTypeInList)
		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'), 0)

		String VisitTypeUrl = WebUI.getUrl()

		String VisitTypeId = (VisitTypeUrl.split("visit-type/"))[1]

		WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

		if (!(WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'),
		0))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('The Edit link is not shown while editing the visit type in \'Registrant Type\' division')
		}

		println(VisitTypeId)

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'))

		if (WebUI.verifyElementChecked(findTestObject('VisitTypesPage/VisitTypesSummaryPage/IndividualRegistrantTypeCheckboxInputField'),
		3, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))
		}

		if (WebUI.verifyElementNotChecked(findTestObject('VisitTypesPage/VisitTypesSummaryPage/GroupRegistrantTypeCheckBoxInputField'),
		0, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))
		}

		WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

		if(!(WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("After editing the 'Registrant Type' and cilcking the Save button the save button is not getting hiddne and the chages are not getting saved")
		}


		return VisitTypeId
	}
}









