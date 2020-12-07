package com.CommonUtilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class sample {
	@Keyword
	def CheckTheOrder(TestObject Option, String Question, String ExpectedOption) {
		String FirstOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/FirstOption'))

		String SecondOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/SecondOption'))

		String ThirdOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/ThirdOption'))

		if(WebUI.verifyElementPresent(findTestObject('Survey-Student App Objects/ThirdOption'), 2, FailureHandling.OPTIONAL)) {
			String FourthOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/FourthOption'))
		}

		if (!(WebUI.verifyElementText(Option, ExpectedOption, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed(('For the question '+ Question+' the first option is shown wrong as' +
					FirstOptionText) + '. Expected First option is: '+ExpectedOption)

			WebUI.takeScreenshot()
		}
	}
}
