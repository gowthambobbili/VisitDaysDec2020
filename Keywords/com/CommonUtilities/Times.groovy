package com.CommonUtilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.googlecode.javacv.CanvasFrame.Exception
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
import java.time.LocalDateTime
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.text.SimpleDateFormat;


class Times {

	Date dNow = new Date( );

	@Keyword
	def GetTimeForStatusTimeStampInUserProfile() {
		SimpleDateFormat ft =
				new SimpleDateFormat ("MMM d, yyyy h:mm a");
		println("Current Date: " + ft.format(dNow));
		return (ft.format(dNow)).toString()
	}

	@Keyword
	def GetTimeForTodayDateInDayViewOfCalendar() {
		SimpleDateFormat ft =
				new SimpleDateFormat ("MMM. d, yyyy");
		println("Today's Date: " + ft.format(dNow));
		return (ft.format(dNow)).toString()
	}


	@Keyword
	def GetTimeTodayHeaderInMonthViewOfCalendar() {
		SimpleDateFormat ft =
				new SimpleDateFormat ("MMM. yyyy");
		println("Today's Date: " + ft.format(dNow));
		return (ft.format(dNow)).toString()
	}


	@Keyword
	def GetTimeForDateRangeFilter() {
		Date today=new Date();
		long ltime=today.getTime()+10*24*60*60*1000;
		Date today8=new Date(ltime);
		SimpleDateFormat ft =
				new SimpleDateFormat ("MMM d, yyyy");
		Date Start =new Date();
		String ReturnDate = ft.format(Start).toString()+' - '+ft.format(today8)
		println ReturnDate
		return ReturnDate
	}

	@Keyword
	def GetTomorrowDay() {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
		String CurrentDay =  simpleDateformat.format(dNow)
		return CurrentDay
	}


	@Keyword
	def GetCurrentMonth() {
		String[] monthName= ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
		Calendar cal = Calendar.getInstance()
		String month = monthName[cal.get(Calendar.MONTH)]
		return month
	}

	@Keyword
	def GetDateInRequiredFormat(String DateFormat) {
		SimpleDateFormat ft = new SimpleDateFormat (DateFormat);
		String CurrentDay =  ft.format(dNow)
		return CurrentDay
	}


	@Keyword
	def AddOrSubtractDatesAndReturnInreequiredFormat(int DaysToAddOrSubtract, String DateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dNow);
		cal.add(Calendar.DATE, DaysToAddOrSubtract);
		Date dateBefore30Days = cal.getTime();
		println dateBefore30Days
		SimpleDateFormat ft = new SimpleDateFormat (DateFormat);
		String FinalDay =  ft.format(dateBefore30Days)
		return FinalDay
	}

	@Keyword
	def ConvertTimeTo24HoursFormat(String Time) {
		SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm aa");
		SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm");
		String time24 = outFormat.format(inFormat.parse(Time));
		return time24
	}

	@Keyword
	def CampareTwoDates(String Date1, String Date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, h:mm a");
		Date date1 = sdf.parse(Date1);
		Date date2 = sdf.parse(Date2);
		return date1.compareTo(date2)
	}
}









