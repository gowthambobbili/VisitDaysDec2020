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



class RescheduleMethods {

	@Keyword
	def RescheduleIndividualVisit(String StudentName, String VisitType) {
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.delay(2)

		driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']/../../../..//i[text()=\'more_vert\']')).click()

		WebUI.delay(2)

		driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']/../../../..//i[text()=\'restore\']')).click()

		WebUI.verifyElementPresent(findTestObject('Requests/DayAndTimeInRescheduleModal'), 0)

		WebUI.delay(2)

		driver.findElement(By.xpath(('//div[@class=\'vd-modal-body reschedule-body scrollable-modal-body modal-body ember-view\']//div[@class=\'visit-name\' and text()=\'' +
				VisitType) + '\']'))

		WebUI.click(findTestObject('Requests/CheckBoxInRescheduleModal'))

		WebUI.scrollToElement(findTestObject('Requests/SelectADateToRescheduleCalendar'), 0)

		WebUI.click(findTestObject('Requests/SelectADateToRescheduleCalendar'))

		//Date today = Calendar.getInstance().getTime();
		//
		//println today.toString().split(" ")[2]
		int NumberOFEnableDates = driver.findElements(By.xpath('//td[@class=\'day\']')).size()

		for (int i = 1; i <= NumberOFEnableDates; i++)
		{
			driver.findElement(By.xpath("(//td[@class='day'])["+i+"]")).click()

			//driver.findElement(By.xpath("//td[@class='day' and text()="+var+"]")).click()

			if(WebUI.verifyElementPresent(findTestObject('Requests/FirstAvailbleVisitTypeInRescheduleModal'), 6))
			{
				break
			}

		}

		if (WebUI.verifyElementPresent(findTestObject('Requests/FirstAvailbleVisitTypeInRescheduleModal'), 6)) {

			String RescheduledVisitType = driver.findElement(By.xpath("(//div[@class='header-box'])[1]")).getText()

			driver.findElement(By.xpath('(//div[@class=\'multiselect-checkboxes ember-view\']//input)[1]')).click()

			WebUI.scrollToElement(findTestObject('Requests/SelectNumberOfAttendeesDropdown'), 0)

			WebUI.click(findTestObject('Requests/SelectNumberOfAttendeesDropdown'))

			WebUI.click(findTestObject('Requests/SelectTwoInNumberOfAttendeesDropDown'))

			WebUI.click(findTestObject('Requests/RescheduleButtonInRescheduleModal'))

			WebUI.delay(3)
		}
	}


	@Keyword
	def RescheduleGroupVisit(String StudentName, String VisitType)
	{
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.delay(2)

		driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']/../../../..//i[text()=\'more_vert\']')).click()

		WebUI.delay(2)

		driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']/../../../..//i[text()=\'restore\']')).click()

		WebUI.verifyElementPresent(findTestObject('Requests/DayAndTimeInRescheduleModal'), 0)

		WebUI.delay(2)

		driver.findElement(By.xpath(('//div[@class=\'vd-modal-body reschedule-body scrollable-modal-body modal-body ember-view\']//div[@class=\'visit-name\' and text()=\'' +
				VisitType) + '\']'))

		WebUI.click(findTestObject('Requests/CheckBoxInRescheduleModal'))

		WebUI.scrollToElement(findTestObject('Requests/SelectADateToRescheduleCalendar'), 0)

		WebUI.click(findTestObject('Requests/SelectADateToRescheduleCalendar'))

		//Date today = Calendar.getInstance().getTime();
		//
		//println today.toString().split(" ")[2]
		int NumberOFEnableDates = driver.findElements(By.xpath('//td[@class=\'day\']')).size()

		for (int i = 1; i <= NumberOFEnableDates; i++)
		{
			driver.findElement(By.xpath("(//td[@class='day'])["+i+"]")).click()

			//driver.findElement(By.xpath("//td[@class='day' and text()="+var+"]")).click()

			if(WebUI.verifyElementPresent(findTestObject('Requests/FirstAvailbleVisitTypeInRescheduleModal'), 6))
			{
				break
			}

		}

		if (WebUI.verifyElementPresent(findTestObject('Requests/FirstAvailbleVisitTypeInRescheduleModal'), 6)) {

			String RescheduledVisitType = driver.findElement(By.xpath("(//div[@class='header-box'])[1]")).getText()

			driver.findElement(By.xpath('(//div[@class=\'multiselect-checkboxes ember-view\']//input)[1]')).click()

			//					WebUI.scrollToElement(findTestObject('Requests/SelectNumberOfAttendeesDropdown'), 0)
			//
			//					WebUI.click(findTestObject('Requests/SelectNumberOfAttendeesDropdown'))
			//
			//					WebUI.click(findTestObject('Requests/SelectTwoInNumberOfAttendeesDropDown'))

			WebUI.scrollToElement(findTestObject('Requests/NumberOfStudentsTextboxUnderNumberOfAttendeesDivision'), 0)

			WebUI.sendKeys(findTestObject('Requests/NumberOfStudentsTextboxUnderNumberOfAttendeesDivision'), '2')

			WebUI.sendKeys(findTestObject('Requests/NumberOfChaperonesTextBoxUnderNumberOfAttendees'), '2')

			WebUI.click(findTestObject('Requests/RescheduleButtonInRescheduleModal'))

			WebUI.delay(3)
		}

	}

}
