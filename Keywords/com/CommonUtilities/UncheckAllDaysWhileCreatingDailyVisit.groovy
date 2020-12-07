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


class UncheckAllDaysWhileCreatingDailyVisit {

	@Keyword
	def UncheckallDaysCheckboxes() {
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/MondayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/MondayCheckBoxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/MondayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/TuesdayCheckBoxINput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/TuesdayCheckBoxINput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/TuesdayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/WednessDayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/WednessDayCheckBoxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/WednesdayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/ThursdayCheckboxInputField'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/ThursdayCheckboxInputField'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/ThursdayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/FridayCheckboxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/FridayCheckboxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/FridayCheckBoxInCreateDailyVisitPage'))
			}
		}
	}



	@Keyword
	def CheckallDaysCheckboxes() {
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/MondayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/MondayCheckBoxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/MondayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/TuesdayCheckBoxINput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/TuesdayCheckBoxINput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/TuesdayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/WednessDayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/WednessDayCheckBoxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/WednesdayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/ThursdayCheckboxInputField'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/ThursdayCheckboxInputField'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/ThursdayCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/FridayCheckboxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/FridayCheckboxInput'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/FridayCheckBoxInCreateDailyVisitPage'))
			}
		}
	}




	@Keyword
	def UncheckallSecondDaysCheckboxes() {
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput(Second)'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput(Second)'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage(Second)'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SundayCheckBoxInput(Second)'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/SundayCheckBoxInput(Second)'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage(Second)'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/MondayCheckBoxInput(Second)'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/MondayCheckBoxInput(Second)'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/MondayCheckBoxInCreateDailyVisitPage(Second)'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/TuesdayCheckBoxINput(Second)'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/TuesdayCheckBoxINput(Second)'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/TuesdayCheckBoxInCreateDailyVisitPage(Second)'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/WednessDayCheckBoxInput(Second)'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/WednessDayCheckBoxInput(Second)'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/WednesdayCheckBoxInCreateDailyVisitPage(Second)'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/ThursdayCheckboxInputField(Second)'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/ThursdayCheckboxInputField(Second)'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/ThursdayCheckBoxInCreateDailyVisitPage(Second)'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/FridayCheckboxInput(Second)'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementChecked(findTestObject('DailyVisitsPage/FridayCheckboxInput(Second)'), 0, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('DailyVisitsPage/FridayCheckBoxInCreateDailyVisitPage(Second)'))
			}
		}
	}
}
