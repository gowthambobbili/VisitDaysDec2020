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
import java.text.*;
import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class FilterInIndexPage {

	@Keyword
	def ApplyFiltersInIndexPage(String VisitType) {
		WebDriver driver = DriverFactory.getWebDriver()

		Date today=new Date();
		long ltime=today.getTime()+10*24*60*60*1000;
		Date today8=new Date(ltime);
		SimpleDateFormat ft =
				new SimpleDateFormat ("MMM d, yyyy");

		Date Start =new Date();

		String ReturnDate = ft.format(Start).toString()+' - '+ft.format(today8)


		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		if(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 5, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)
		}

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

		WebUI.waitForPageLoad(0)

		WebUI.delay(2)

		def filter = new TestObject("Creted Visit Type In VisitType filter In index page")

		filter.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitType+"']")

		WebUI.click(filter)

		WebUI.delay(3)

		WebUI.click(findTestObject('DailyVisitsPage/CurrentCapacityFilterDropDown'))

		WebUI.click(findTestObject('DailyVisitsPage/AllOptionInCurrentCapacityFilter'))

		WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

		WebUI.clearText(findTestObject('DailyVisitsPage/DateRangeFilterTextField'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/DateRangeFilterTextField'), ReturnDate)

		int ApplyButtonCount = driver.findElements(By.xpath("//button[text()='Apply' and @disabled=not('disabled')]")).size()

		def ApplyButton = new TestObject("Apply Button In Index Page")

		ApplyButton.addProperty("xpath", ConditionType.EQUALS, "(//button[text()='Apply' and @disabled=not('disabled')])["+ApplyButtonCount+"]")

		WebUI.click(ApplyButton)

		//WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'), 0)
		//WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

		WebUI.delay(3)

		WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

		WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

		def CreatedVisit = new TestObject("Created visit in index page")

		CreatedVisit.addProperty("xpath", ConditionType.EQUALS, "(//h4[@class='visit-type-title' and text()='"+VisitType+"'])[1]")


		if(!(WebUI.verifyElementPresent(CreatedVisit, 0, FailureHandling.OPTIONAL)))
		{
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("The created visit with visit type "+VisitType+" is not shown in the index page after applying filters")
		}
		//		WebUI.click(findTestObject('Object Repository/DailyVisitsPage/ClickOnVisitCard'))
	}


	@Keyword

	def ApplyFiltersInIndexPageForAllActiveVisits() {
		WebDriver driver = DriverFactory.getWebDriver()

		Date today=new Date();
		long ltime=today.getTime()+10*24*60*60*1000;
		Date today8=new Date(ltime);
		SimpleDateFormat ft =
				new SimpleDateFormat ("MMM d, yyyy");

		Date Start =new Date();

		String ReturnDate = ft.format(Start).toString()+' - '+ft.format(today8)


		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		if(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 5, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)
		}

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

		WebUI.delay(2)

		driver.findElement(By.xpath("//li[text()='All']")).click()

		WebUI.delay(3)

		WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

		WebUI.clearText(findTestObject('DailyVisitsPage/DateRangeFilterTextField'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/DateRangeFilterTextField'), ReturnDate)

		int ApplyButtonCount = driver.findElements(By.xpath("//button[text()='Apply']")).size()

		def ApplyButton = new TestObject("Apply Button In Index Page")

		ApplyButton.addProperty("xpath", ConditionType.EQUALS, "//button[text()='Apply']["+ApplyButtonCount+"]")

		WebUI.click(ApplyButton)

		//WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'), 0)
		//WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

		WebUI.delay(3)

		WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

		WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))


	}


	@Keyword
	def ApplyFiltersForSpecificDayInIndexPage(String VisitType, String Month, String Day, String Year)
	{
		WebDriver driver = DriverFactory.getWebDriver()

		String DateToEnter = Month+' '+Day+', '+Year+' - '+Month+' '+Day+', '+Year

		println DateToEnter

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		if(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 5, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)
		}

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

		WebUI.delay(2)

		def filter = new TestObject("Creted Visit Type In VisitType filter In index page")

		filter.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitType+"']")

		WebUI.click(filter)

		WebUI.delay(3)

		WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

		WebUI.clearText(findTestObject('DailyVisitsPage/DateRangeFilterTextField'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/DateRangeFilterTextField'), DateToEnter)

		int ApplyButtonCount = driver.findElements(By.xpath("//button[text()='Apply' and @disabled=not('disabled')]")).size()

		def ApplyButton = new TestObject("Apply Button In Index Page")

		ApplyButton.addProperty("xpath", ConditionType.EQUALS, "//button[text()='Apply' and @disabled=not('disabled')]["+ApplyButtonCount+"]")

		WebUI.click(ApplyButton)

		//WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'), 0)
		//WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

		WebUI.delay(3)

		WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

		WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

		def CreatedVisit = new TestObject("Created visit in index page")
		CreatedVisit.addProperty("xpath", ConditionType.EQUALS, "(//h4[@class='visit-type-title' and text()='"+VisitType+"'])[1]")

		if(!(WebUI.verifyElementPresent(CreatedVisit, 0, FailureHandling.OPTIONAL)))
		{
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("The created visit with visit type "+VisitType+" is not shown in the index page after applying filters")
		}
	}
}
