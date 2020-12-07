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
import java.text.SimpleDateFormat;


class CalendarMethods {

	WebDriver driver = DriverFactory.getWebDriver()
	Verifications Verifications = new Verifications()

	@Keyword
	def MonthNumber(String MonthShortName) {
		int value
		switch (MonthShortName) {
			case "Jan":
				value = 01
				break

			case "Feb":
				value = 02
				break

			case "Mar":
				value = 03
				break

			case "Apr":
				value = 04
				break

			case "May":
				value = 05
				break

			case "Jun":
				value = 06
				break

			case "Jul":
				value = 07
				break

			case "Aug":
				value = 08
				break

			case "Sep":
				value = 09
				break

			case "Oct":
				value = 10
				break

			case "Nov":
				value = 11
				break

			case "Dec":
				value = 12
				break
		}
		return value.toString()
	}


	@Keyword
	def ReturnMonthHeader(String YorM) {
		String Header = WebUI.getText(findTestObject('Calendar/CalenderHeaderText'))

		println Header

		if(YorM == 'Y') {
			return Header.split(". ")[1]
		}
		else if(YorM=='M') {
			return Header.split(". ")[0]
		}
	}


	@Keyword
	def VerifyVisitPresentInFirstDayOfMonthView(String VisitType) {

		def VisitInVeryfirstDayOfMonthInMoreVisits = new TestObject("Visit in very first day in the calendar month view(in the more visits modal")
		VisitInVeryfirstDayOfMonthInMoreVisits.addProperty("xpath", ConditionType.EQUALS, "//div[text()='"+VisitType+"']")
		if(WebUI.verifyElementPresent(findTestObject("Object Repository/Calendar/MoreVisitsLinkInFirstDateOfMonthView"), 8, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject("Object Repository/Calendar/MoreVisitsLinkInFirstDateOfMonthView"))
			Verifications.VerifyElementPresentAndStopExecutionIfFailed(VisitInVeryfirstDayOfMonthInMoreVisits, "Visits are not shown for the very first day in Month view (There is a visit \'"+VisitType+"\' on very first date of the month view but it's not shown)")
		}
		else {
			def VisitInVeryfirstDayOfMonth = new TestObject("Visit in very first day in the calendar month view")
			VisitInVeryfirstDayOfMonth.addProperty("xpath", ConditionType.EQUALS, "(//div[@class='cal-month-date'])[1]/..//span[@class='cal-month-visit__title' and text()='"+VisitType+"']")
			if(!(WebUI.verifyElementPresent(VisitInVeryfirstDayOfMonth, 0, FailureHandling.OPTIONAL))) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("Visits are not shown for the very first day in Month view (There is a visit \'"+VisitType+"\' on very first date of the month view but it's not shown)")
			}
		}
	}

	@Keyword
	def VerifyVisitPresentInLastDayOfMonthView(String VisitType) {
		int NumberOfDaysInCalendarView = driver.findElements(By.xpath("//div[@class='cal-month-date']")).size()
		def VisitInVeryLastDayOfMonthInMoreVisits = new TestObject("Visit in very first day in the calendar month view(in the more visits modal")
		VisitInVeryLastDayOfMonthInMoreVisits.addProperty("xpath", ConditionType.EQUALS, "//div[text()='"+VisitType+"']")
		def MoreVisitsLinkInTheListDayOfMonthView = new TestObject("More visits link in the last day of month view in calendar")
		MoreVisitsLinkInTheListDayOfMonthView.addProperty("xpath", ConditionType.EQUALS, "(//div[@class='cal-month-date'])["+NumberOfDaysInCalendarView+"]/..//div[@class='cal-month-visit cal-month-visit__more']")
		if(WebUI.verifyElementPresent(MoreVisitsLinkInTheListDayOfMonthView, 8, FailureHandling.OPTIONAL)) {
			WebUI.click(MoreVisitsLinkInTheListDayOfMonthView)
			Verifications.VerifyElementPresentAndStopExecutionIfFailed(VisitInVeryLastDayOfMonthInMoreVisits, "Visits are not shown for the very Last day in Month view (There is a visit \'"+VisitType+"\' on very Last date of the month view but it's not shown)")
		}
		else {

			def VisitInVeryfirstDayOfMonth = new TestObject("Visit in very first day in the calendar month view")
			VisitInVeryfirstDayOfMonth.addProperty("xpath", ConditionType.EQUALS, "(//div[@class='cal-month-date'])["+NumberOfDaysInCalendarView+"]/..//span[@class='cal-month-visit__title' and text()='"+VisitType+"']")
			if(!(WebUI.verifyElementPresent(VisitInVeryfirstDayOfMonth, 0, FailureHandling.OPTIONAL))) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("Visits are not shown for the very Last day in Month view (There is a visit \'"+VisitType+"\' on very Last date of the month view but it's not shown)")
			}
		}
	}



	//@Keyword
	def ReturnTheLastDateFromMonthView() {

		Verifications Verify = new Verifications()

		Calendar cal = Calendar.getInstance();

		Verify.VerifyElementPresent(findTestObject('Calendar/MonthViewObject'), 'After clicking Month tab in Calendar page Month view is not getting opened')

		WebUI.delay(2)

		String FirstDayInMonthView = WebUI.getText(findTestObject('Calendar/FirstDayInMonthView'))

		int Day = Integer.parseInt(FirstDayInMonthView.split(' ')[1])

		String MonthString = FirstDayInMonthView.split(' ')[0]

		String RefVar = MonthString+' '+FirstDayInMonthView.split(' ')[1]

		println ("ref var: "+RefVar)

		int year

		if(MonthString=="Nov")
		{
			if(Day>=21)
			{
				year = (cal.get(Calendar.YEAR)-1)
			}
		}
		else if(MonthString=="Dec")
		{
			if(Day>=1)
			{
				year = (cal.get(Calendar.YEAR)-1)
			}
		}
		else
		{
			year = (cal.get(Calendar.YEAR))
		}
		int Month = Integer.parseInt(MonthNumber(MonthString))
		//int Year = Integer.parseInt(ReturnMonthHeader('Y'))
		println ("before add a day year "+year)
		println ("day: " +Day)
		println ("Month: " +Month)
		SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
		//Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, Day);
		cal.set(Calendar.MONTH, Month-1);
		cal.set(Calendar.YEAR, year);
		cal.add(Calendar.DAY_OF_MONTH, 34);
		println dateFormat.format(cal.getTime()).toString()
		return dateFormat.format(cal.getTime()).toString()
	}


	@Keyword
	def Testmethod()
	{
		Calendar cal = Calendar.getInstance();
		int NumberOfDaysInCalendarView = driver.findElements(By.xpath("//div[@class='cal-month-date']")).size()
		def LastDayInCalendar = new TestObject("Last day in month view of caledar")
		LastDayInCalendar.addProperty("xpath", ConditionType.EQUALS, "(//div[@class='cal-month-date'])["+NumberOfDaysInCalendarView+"]")
		String LastDayText = WebUI.getText(LastDayInCalendar)
		String Result
		String DayTextFromCalendar
		String Year
		def DayObject = new TestObject("Days in calendar")

		for(int i=NumberOfDaysInCalendarView; i>0; i--)
		{
			DayObject.addProperty("xpath", ConditionType.EQUALS, "(//div[@class='cal-month-date'])["+i+"]")
			DayTextFromCalendar = WebUI.getText(DayObject)
			if(DayTextFromCalendar.length()>2)
			{
				break
			}
		}
		if(LastDayText==DayTextFromCalendar)
		{
			Result = DayTextFromCalendar
		}
		else
		{
			Result = DayTextFromCalendar.split(" ")[0]+' '+LastDayText
		}

		if(DayTextFromCalendar.split(" ")[0]=='Jan')
		{
			Year = (cal.get(Calendar.YEAR)+1).toString()
		}
		else
		{
			Year = (cal.get(Calendar.YEAR)).toString()
		}

		String FinalDate =Result+' '+Year

		return FinalDate
	}

}