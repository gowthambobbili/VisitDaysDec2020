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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class SearchTest {

	@Keyword
	def SearchLocationTest() {
		WebDriver driver = DriverFactory.getWebDriver()

		int locations = driver.findElements(By.xpath('//p[@class=\'text-muted\']/..')).size()

		println locations

		Random rvar = new Random()

		int LocationIndexToSearch = rvar.nextInt(locations)

		if(LocationIndexToSearch==0) {
			LocationIndexToSearch=LocationIndexToSearch+1
		}

		String FullLocationNameToSearch = driver.findElement(By.xpath(('(//p[@class=\'text-muted\']/..)[' + LocationIndexToSearch) +']')).getText()
		
	
		String RequiredLocationName = FullLocationNameToSearch.split('\n')[0]
		

		WebUI.sendKeys(findTestObject('SettingsPage/SearchLocationsSearachBoxInLocations'), RequiredLocationName)

		WebUI.delay(2)

		String FullLocationNameInSearchResults = driver.findElement(By.xpath('(//p[@class=\'text-muted\']/..)[1]')).getText()

		String LocationNameInSearchResults = FullLocationNameInSearchResults.split('\n')[0]

		WebUI.verifyMatch(LocationNameInSearchResults, RequiredLocationName, false)
	}
}
