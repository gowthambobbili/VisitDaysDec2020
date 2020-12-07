//package com.CommonUtilities
//
//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//
//import com.kms.katalon.core.annotation.Keyword
//import com.kms.katalon.core.checkpoint.Checkpoint
//import com.kms.katalon.core.checkpoint.CheckpointFactory
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
//import com.kms.katalon.core.model.FailureHandling
//import com.kms.katalon.core.testcase.TestCase
//import com.kms.katalon.core.testcase.TestCaseFactory
//import com.kms.katalon.core.testdata.TestData
//import com.kms.katalon.core.testdata.TestDataFactory
//import com.kms.katalon.core.testobject.ObjectRepository
//import com.kms.katalon.core.testobject.TestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
//import com.kms.katalon.core.webui.driver.DriverFactory
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
//import com.sun.org.apache.xpath.internal.operations.String
//
//import internal.GlobalVariable
//
//import MobileBuiltInKeywords as Mobile
//import WSBuiltInKeywords as WS
//import WebUiBuiltInKeywords as WebUI
//import org.openqa.selenium.WebDriver as WebDriver
//import org.openqa.selenium.WebElement as WebElement
//import org.openqa.selenium.By as By
//
//public class SearchFunctionalityVerification {
//
//	@Keyword
//	def VerifySearchResults(String SearchItem) {
//		WebUI.delay(2)
//
//		WebDriver driver = DriverFactory.getWebDriver()
//
//		int NumberOfListElementsAfterSearch = driver.findElements(By.xpath('(//span[@class="user-details"]/b)')).size()-2
//
//		for (int x = 1; x <= NumberOfListElementsAfterSearch; x++) {
//			WebUI.delay(2)
//
//			String ListItem = driver.findElement(By.xpath(('(//span[@class="user-details"]/b)['+x+']'))).getText()
//
//			println ListItem
//
//			if (ListItem.toLowerCase().contains(SearchItem.toLowerCase())) {
//				WebUI.verifyMatch('a', 'a', false)
//			} else {
//				WebUI.verifyMatch('b', 'a', false)
//			}
//		}
//	}
//}
