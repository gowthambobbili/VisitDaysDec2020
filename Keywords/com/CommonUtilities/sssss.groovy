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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.sun.org.apache.xpath.internal.operations.String

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

public class sssss {

	@Keyword
	def SearchFunctionalityVerification(String xpath, TestObject SearchBoxObject, TestObject FirstListElementObject) {
		WebDriver driver = DriverFactory.getWebDriver()

		int NumberOfListElements = driver.findElements(By.xpath(xpath)).size()

		Random rand = new Random()

		for (def i = 0; i <= 3; i++) {
			def random_num = rand.nextInt(NumberOfListElements)

			if(random_num!=0) {
				String SearchItem = driver.findElement(By.xpath(('('+xpath+')['+random_num+']'))).getText()

				WebUI.sendKeys(SearchBoxObject, SearchItem)

				def var = WebUI.getText(FirstListElementObject, FailureHandling.STOP_ON_FAILURE)

				WebUI.verifyMatch(var, SearchItem, false)

				WebUI.clearText(SearchBoxObject)
			}
		}
	}
}
