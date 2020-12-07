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
import java.text.*;

class Testing {

	@Keyword
	def CreateDailyVisitVisitWithStartTimeWithIn30Minutes(String VisitType) {


		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");

		String CurrentTime = (ft.format(dNow)).toString()

		println CurrentTime

		String Meridian = CurrentTime.split(' ')[1]


		String hrs = CurrentTime.split(':')[0]

		int IntHrs  = Integer.parseInt(hrs)

		println IntHrs+410

		int minutes = Integer.parseInt((CurrentTime.split(' ')[0]).split(':')[1])

		println minutes+100

		if(minutes>30 && IntHrs<11) {
			minutes = minutes-29
			IntHrs = IntHrs+1
		}
		else if(minutes>30 && IntHrs>11 && Meridian=='AM') {
			minutes = minutes-29
			IntHrs = IntHrs+1
			IntHrs = 12-IntHrs
			Meridian=='PM'
		}
		else {
			minutes = minutes+29
		}

		String StartTime = IntHrs.toString()+':'+minutes.toString()+' '+Meridian

		println StartTime

		int EndTimeInt = IntHrs+1

		String EndTime = EndTimeInt.toString()+':'+'10'+' '+Meridian

		println EndTime


		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

		//==================
		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), StartTime)

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)

		//==================
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)



	}
}