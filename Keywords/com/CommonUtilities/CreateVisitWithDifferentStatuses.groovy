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
import com.sun.org.apache.xpath.internal.operations.Bool

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



class CreateVisitWithDifferentStatuses {

	@Keyword
	def CreateDailyVisitWithInprogressTimes(String VisitType) {

		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));
		String CurrentTime = (ft.format(dNow)).toString()

		String Meridiem = CurrentTime.split(' ')[1]

		String HoursString = CurrentTime.split(' ')[0]

		//		int Hours = Integer.parseInt(HoursString)
		//
		//
		//
		//		String StartTime = Hours - 1
		//
		//		StartTime = ((StartTime.toString() + ':00') + Meridiem)
		//
		//		String EndTime = Hours + 1
		//
		//		EndTime = ((EndTime.toString() + ':00') + Meridiem)

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

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))


		//==================
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}
	@Keyword
	def CreateDailyVisitWithInprogressTimesAndHideAdmins(String VisitType) {

		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));
		String CurrentTime = (ft.format(dNow)).toString()

		String Meridiem = CurrentTime.split(' ')[1]

		String HoursString = CurrentTime.split(' ')[0]

		//		int Hours = Integer.parseInt(HoursString)
		//
		//
		//
		//		String StartTime = Hours - 1
		//
		//		StartTime = ((StartTime.toString() + ':00') + Meridiem)
		//
		//		String EndTime = Hours + 1
		//
		//		EndTime = ((EndTime.toString() + ':00') + Meridiem)

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

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))


		//==================
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('Object Repository/DailyVisitsPage/HideAdminsButton'))

		//		WebUI.scrollToElement(findTestObject('Object Repository/DailyVisitsPage/AssignNowInDailyVisit'), 0)

		//		WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AssignNowInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 0)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))


		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	def CreateSessionVisitWithinProgressTimes(String VisitType) {

		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));
		String CurrentTime = (ft.format(dNow)).toString()

		String Meridiem = CurrentTime.split(' ')[1]

		String HoursString = CurrentTime.split(' ')[0]

		WebUI.waitForElementPresent(findTestObject('Object Repository/CreateSession/visitType'),0)

		WebUI.click(findTestObject('Object Repository/CreateSession/visitType'))

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('Object Repository/CreateSession/VirtualSettingsNone'))


		WebUI.click(findTestObject('Object Repository/CreateSessionsType/NextButton'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		String VisitName=WebUI.getText(findTestObject('Object Repository/CreateSession/VisitNameData'))

		WebUI.click(findTestObject('Object Repository/CreateSession/PublishButton'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(5)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		return VisitName
	}

	@Keyword
	def CreateSessionWithInprogresSameStartAndEndTimes(String VisitType) {
		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));
		String CurrentTime = (ft.format(dNow)).toString()

		def EndTime

		def Minutes = Integer.parseInt((CurrentTime.split(":")[1]).split(" ")[0])

		println "Minutes   "+Minutes

		if(56 <= Minutes && Minutes<= 59) {
			String Hours = (Integer.parseInt(CurrentTime.split(":")[0])+1).toString()
			EndTime = Hours+":00"+CurrentTime.split(" ")[1]
		}
		else {
			Minutes = Minutes+1
			EndTime = CurrentTime.split(":")[0]+":"+(Minutes).toString()+" "+CurrentTime.split(" ")[1]
		}

		String Meridiem = CurrentTime.split(' ')[1]

		String HoursString = CurrentTime.split(' ')[0]

		WebUI.waitForElementPresent(findTestObject('Object Repository/CreateSession/visitType'),0)

		WebUI.click(findTestObject('Object Repository/CreateSession/visitType'))

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('Object Repository/CreateSession/VirtualSettingsNone'))


		WebUI.click(findTestObject('Object Repository/CreateSessionsType/NextButton'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		String VisitName=WebUI.getText(findTestObject('Object Repository/CreateSession/VisitNameData'))

		WebUI.click(findTestObject('Object Repository/CreateSession/PublishButton'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(5)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		return VisitName
	}





	@Keyword
	def CreateDailyVisitWithInprogresSameStartAndEndTimes(String VisitType, Boolean ChannelTypeFlag=true) {
		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));
		String CurrentTime = (ft.format(dNow)).toString()

		def EndTime

		def Minutes = Integer.parseInt((CurrentTime.split(":")[1]).split(" ")[0])

		println "Minutes   "+Minutes

		if(56 <= Minutes && Minutes<= 59) {
			String Hours = (Integer.parseInt(CurrentTime.split(":")[0])+1).toString()
			EndTime = Hours+":00"+CurrentTime.split(" ")[1]
		}
		else {
			Minutes = Minutes+1
			EndTime = CurrentTime.split(":")[0]+":"+(Minutes).toString()+" "+CurrentTime.split(" ")[1]
		}

		String Meridiem = CurrentTime.split(' ')[1]

		String HoursString = CurrentTime.split(' ')[0]

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

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)

		//WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))
		//
		//		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		if(ChannelTypeFlag)
		{
			WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

			WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

			WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))
		}
		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}



	@Keyword
	def CreateEventWithInprogressTimes(String VisitType) {

		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));

		String CurrentTime = (ft.format(dNow)).toString()

		//		String Meridiem = CurrentTime.split(' ')[1]
		//
		//		String HoursString = CurrentTime.split(' ')[0]

		//		int Hours = Integer.parseInt(HoursString)
		//
		//		String StartTime = Hours - 1
		//
		//		StartTime = ((StartTime.toString() + ':00') + Meridiem)
		//
		//		String EndTime = Hours + 1
		//
		//		EndTime = ((EndTime.toString() + ':00') + Meridiem)

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		//driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()


		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		//==================
		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		//==================
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}
	@Keyword
	def CreateEventWithInprogressTimesAndHideAdmins(String VisitType) {

		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));

		String CurrentTime = (ft.format(dNow)).toString()

		//		String Meridiem = CurrentTime.split(' ')[1]
		//
		//		String HoursString = CurrentTime.split(' ')[0]

		//		int Hours = Integer.parseInt(HoursString)
		//
		//		String StartTime = Hours - 1
		//
		//		StartTime = ((StartTime.toString() + ':00') + Meridiem)
		//
		//		String EndTime = Hours + 1
		//
		//		EndTime = ((EndTime.toString() + ':00') + Meridiem)

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		//driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()


		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		//==================
		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		//==================
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('Object Repository/DailyVisitsPage/HideAdminsButton'))

		//		WebUI.scrollToElement(findTestObject('Object Repository/DailyVisitsPage/AssignNowInDailyVisit'), 0)

		WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AssignNowInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 0)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	def CreateOffCampusWithInprogressTimes(String VisitType) {

		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));

		String CurrentTime = (ft.format(dNow)).toString()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(5)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def CreateOffCampusWithInprogressTimesAndHideAdmins(String VisitType) {

		Date dNow = new Date( );
		SimpleDateFormat ft =
				new SimpleDateFormat ("hh:mm a");
		System.out.println("Current Date: " + ft.format(dNow));

		String CurrentTime = (ft.format(dNow)).toString()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), CurrentTime)

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('Object Repository/DailyVisitsPage/HideAdminsButton'))

		//		WebUI.scrollToElement(findTestObject('Object Repository/DailyVisitsPage/AssignNowInDailyVisit'), 0)

		//		WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AssignNowInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 0)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(5)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)
	}




	//==================Registration closed ================================//



	@Keyword
	def CreateDailyVisitWithPastTimes(String VisitType)
	{

		//		Date dNow = new Date( );
		//		SimpleDateFormat ft =
		//				new SimpleDateFormat ("hh a");
		//		System.out.println("Current Date: " + ft.format(dNow));
		//		String CurrentTime = (ft.format(dNow)).toString()
		//
		//		String Meridiem = CurrentTime.split(' ')[1]
		//
		//		String HoursString = CurrentTime.split(' ')[0]
		//
		//		int Hours = Integer.parseInt(HoursString)
		//
		//		String StartTime = Hours - 3
		//
		//		StartTime = ((StartTime.toString() + ':00') + Meridiem)
		//
		//		String EndTime = Hours - 2
		//
		//		EndTime = ((EndTime.toString() + ':00') + Meridiem)

		String StartTime = '12:00 AM'

		String EndTime = '12:05 AM'

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

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)

		//==================
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		return StartTime
	}
	@Keyword
	def CreateSessionWithInPastTimes(String VisitType)
	{
		String StartTime = '12:00 AM'

		String EndTime = '12:05 AM'

		WebUI.waitForElementPresent(findTestObject('Object Repository/CreateSession/visitType'),0)

		WebUI.click(findTestObject('Object Repository/CreateSession/visitType'))

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), StartTime)

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)

		//		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		//		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('Object Repository/CreateSession/VirtualSettingsNone'))


		WebUI.click(findTestObject('Object Repository/CreateSessionsType/NextButton'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		String VisitName=WebUI.getText(findTestObject('Object Repository/CreateSession/VisitNameData'))

		WebUI.click(findTestObject('Object Repository/CreateSession/PublishButton'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(5)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		return VisitName

	}


	@Keyword
	def CreateEventWithInPastTimes(String VisitType)
	{


		String StartTime = '12:00 AM'

		String EndTime = '12:05 AM'

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		//driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		//==================
		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), StartTime)

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)

		//==================
		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		return StartTime
	}


	@Keyword
	def CreateOffCampusWithInPastTimes(String VisitType)
	{


		String StartTime = '12:00 AM'

		String EndTime = '12:05 AM'

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)


		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), StartTime)

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)
		return StartTime
	}


	//======================Future times=================================//


	@Keyword
	def CreateDailyVisitWithFutureTimes(String VisitType)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		//WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/EndDateToPublishFourVisitsInASeries'))

		//		//==================
		//		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))
		//
		//		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), StartTime)
		//
		//		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))
		//
		//		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)
		//
		//		//==================

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), 0)) {
				WebUI.click(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), 0)) {
				WebUI.click(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage'))
			}
		}

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.refresh()

	}



	@Keyword
	def CreateRequestDailyVisitWithFutureTimes(String VisitType)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		//WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/EndDateToPublishFourVisitsInASeries'))

		//		//==================
		//		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))
		//
		//		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), StartTime)
		//
		//		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))
		//
		//		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)
		//
		//		//==================

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), 0)) {
				WebUI.click(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), 0)) {
				WebUI.click(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage'))
			}
		}

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		//WebUI.delay(4)
		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

		WebUI.clearText(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'))

		//driver.findElement(By.xpath("//span[text()='test user1']/..//i")).click()

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'mahesh test')

		WebUI.click(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	def CreateDailyVisitWithFutureTimesOtherThenDefaultTimes(String VisitType)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

		//WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/EndDateToPublishFourVisitsInASeries'))

		//==================
		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), '10:00 AM')

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '11:00 AM')

		//==================

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SatrurdayCheckBoxInput'), 0)) {
				WebUI.click(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage'))
			}
		}

		if (WebUI.verifyElementClickable(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), FailureHandling.OPTIONAL)) {
			if (WebUI.verifyElementNotChecked(findTestObject('DailyVisitsPage/SundayCheckBoxInput'), 0)) {
				WebUI.click(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage'))
			}
		}

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	def CreateEventWithInFutureTimes(String VisitType)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		//driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}


	@Keyword
	def CreateEventWithRequestVisitTypeWithFutureTimes(String VisitTypeName)
	{
		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.click(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item":VisitTypeName]))

		//driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		//WebUI.delay(4)
		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

		WebUI.clearText(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'))

		//driver.findElement(By.xpath("//span[text()='test user1']/..//i")).click()

		//.scrollToElement(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'mahesh')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(3)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)
	}



	@Keyword
	def CreateOffCampusWithFutureTimes(String VisitType)
	{
		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

		object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

		WebUI.click(object)

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

	}
	@Keyword
	def CreateSessionWithFutureTimes(String VisitType)
	{
		WebUI.waitForElementPresent(findTestObject('Object Repository/CreateSession/visitType'),0)

		WebUI.click(findTestObject('Object Repository/CreateSession/visitType'))

		WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'),'10:00 AM')

		WebUI.click(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

		WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '11:00 AM')

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.click(findTestObject('Object Repository/CreateSession/VirtualSettingsNone'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		//		WebUI.click(findTestObject('Object Repository/CreateSessionsType/NextButton'))


		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		def VisitName=WebUI.getText(findTestObject('Object Repository/CreateSession/VisitNameData'))

		WebUI.click(findTestObject('Object Repository/CreateSession/PublishButton'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(5)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		return VisitName

	}


	@Keyword
	def CreateOffCampusWithRequestVisitTypeWithFutureTimes(String VisitTypeName)
	{

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.click(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item":VisitTypeName]))

		//driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

		WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

		WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

		WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'), 0)

		//WebUI.delay(4)
		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'test user')

		WebUI.delay(2)

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

		WebUI.clearText(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'))

		//driver.findElement(By.xpath("//span[text()='test user1']/..//i")).click()

		//WebUI.scrollToElement(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'), 0, FailureHandling.OPTIONAL)

		WebUI.sendKeys(findTestObject('DailyVisitsPage/RequestOwnerSearchBoxInDailyVisit'), 'mahesh')

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/SecondAdminUserInAssignRequestOwnerList'))

		//		WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

		//		WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.delay(4)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)
	}





}
