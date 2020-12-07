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



class SortTestInLocations {

	@Keyword
	def VerifySortingInLocations() {
		WebDriver driver = DriverFactory.getWebDriver()

		int NumberOflocations = driver.findElements(By.xpath('//td[@style=\'touch-action: manipulation; -ms-touch-action: manipulation; cursor: pointer;\']')).size()

		def AllLocationNamesInTheList = new String[NumberOflocations]

		def AllLocationNamesInTheListAc = new String[NumberOflocations]

		//def AllLocationNamesInTheListAcForAO = new String[NumberOflocations]

		for (int Index = 1; Index <= NumberOflocations; Index++) {
			String LocationNameWithAddress = driver.findElement(By.xpath(('(//td[@style=\'touch-action: manipulation; -ms-touch-action: manipulation; cursor: pointer;\'])[' +
					Index) + ']')).getText()

			(AllLocationNamesInTheList[(Index - 1)]) = (LocationNameWithAddress.split('\n')[0])
		}

		for (int arrayElements = 0; arrayElements < NumberOflocations; arrayElements++) {
			WebUI.verifyMatch(AllLocationNamesInTheList[arrayElements], AllLocationNamesInTheList.sort()[arrayElements], false)
		}

		WebUI.click(findTestObject('SettingsPage/Locations/LocationsHeader'))

		for (int IndexafterclickLocationsHeader = 1; IndexafterclickLocationsHeader <= NumberOflocations; IndexafterclickLocationsHeader++) {
			String LocationNameWithAddressAc = driver.findElement(By.xpath(('(//td[@style=\'touch-action: manipulation; -ms-touch-action: manipulation; cursor: pointer;\'])[' +
					IndexafterclickLocationsHeader) + ']')).getText()

			(AllLocationNamesInTheListAc[(IndexafterclickLocationsHeader - 1)]) = (LocationNameWithAddressAc.split('\n')[0])
		}

		for (int arrayElements = 0; arrayElements < NumberOflocations; arrayElements++) {
			WebUI.verifyMatch(AllLocationNamesInTheListAc[arrayElements], AllLocationNamesInTheList.reverse()[arrayElements], false)
		}
	}

	@Keyword
	def SortingInLocations()
	{
		List Locations = []
		def NumberOfLocations = WebUiBuiltInKeywords.findWebElements(findTestObject('Object Repository/SettingsPage/Locations/LocationsCommonObjects')).size()
		for(def i=1;i<=NumberOfLocations;i++)
		{
			Locations.add(WebUI.getText(findTestObject('Object Repository/SettingsPage/Locations/LocationsName(Index)', ["Index":i])).split("\n")[0])
		}
		//Locations.reverse()
		def SortedLocations = Locations.sort()
		if(!(Locations.equals(SortedLocations))
		{
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("In the locations page, the locations are not in sorted order initially")
		}


		//WebUI.click(findTestObject('SettingsPage/Locations/LocationsHeader'))
	}

}
