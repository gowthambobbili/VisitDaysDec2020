package com.CommonUtilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.ConditionType
//import com.kms.katalon.core.testobject.TestObject
import java.text.SimpleDateFormat;
import java.util.Date

import internal.GlobalVariable

public class CreateMeeting {

	Random rd=new Random()

	Date dNow=new Date()

	Date tomorow = new Date(dNow.getTime() + (1000 * 60 * 60 * 24))

	Date dropDownFormat=new Date()

	SimpleDateFormat ft2 =new SimpleDateFormat ("EEEEE, MMMM d, yyyy");

	SimpleDateFormat ft =new SimpleDateFormat ("MM/dd/yyyy")

	//	def dropDate=(ft2.format(dropDownFormat)).toString()

	def dropDate=(ft2.format(tomorow)).toString()

	String meetdate=(ft.format(dNow)).toString()

	def tomorowDate=(ft.format(tomorow)).toString()

	//	def meetdate=meetdates.substring(0,2)

	def zoomId="https://zoom.us/j/12345678"


	@Keyword
	def getConvention() {

		WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

		WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink',['ConventionProvider':GlobalVariable.ConventionProvider]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/LiveSessionleftNavInSubMenu'))

		WebUI.delay(5)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/CreateButtonInLiveSessions'))

		WebUI.waitForPageLoad(0)

		WebUI.delay(3)

		def ConventionName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/getNameOfFirstConvention'))

		WebUI.delay(2)

		return ConventionName

		//		return GlobalVariable.createdConventionName
	}

	@Keyword
	def getInstitutionName() {


		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/MeetingsLeftNav'))

		WebUI.waitForPageLoad(0)

		def institutionfullName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/SelectInstitutionName'))

		int ind=institutionfullName.indexOf("swap_horiz");

		String institution=institutionfullName.substring(0,ind);

		String institutionName=institution.trim()


		println institutionName

		return institutionName
	}

	@Keyword
	def enterMeetingDetailsAndTime() {
		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/MeetingsLeftNav'))

		WebUI.waitForPageLoad(5)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AddAvailabilityButton'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AssigneeDropDownButtonInMeetings'))

		def assigneesCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionsPageAdmin/SelectAssigneFromDropDownByIndex'),0).size()

		def assigneeNo =rd.nextInt(assigneesCount)

		def assigneeName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/selectdrop',['Index':assigneeNo]))

		println assigneeName

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/SelectDropImg',['Index':assigneeNo]),10,FailureHandling.OPTIONAL))) {
			//			def num=assigneeName.indexOf(' ')
			def num=2

			def assigneeNameWithspaces=assigneeName.substring(num+1,(assigneeName.length()))

			assigneeName=assigneeNameWithspaces.trim()

		}

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/selectdrop',['Index':assigneeNo]))

		WebUI.delay(6)

		//		def assigneeName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/GetTextFromsSelectAssigne'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/MeetingDateTextField'),tomorowDate)


		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/StartTimeInMeetings'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/StartTimeInMeetings'),'11')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/StartTimeInMeetings'),'15')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/StartTimeInMeetings'),'p')

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/EndTimeInMeetings'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/EndTimeInMeetings'),'11')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/EndTimeInMeetings'),'45')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/EndTimeInMeetings'),'p')

		return assigneeName

	}
	@Keyword
	def enterMeetingDetailsAndTimeWithNonZeroFifteenMinTimeIntervals()
	{
		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/MeetingsLeftNav'))

		WebUI.waitForPageLoad(5)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AddAvailabilityButton'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AssigneeDropDownButtonInMeetings'))

		def assigneesCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionsPageAdmin/SelectAssigneFromDropDownByIndex'),0).size()

		def assigneeNo =rd.nextInt(assigneesCount)

		def assigneeName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/selectdrop',['Index':assigneeNo]))

		println assigneeName

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/SelectDropImg',['Index':assigneeNo]),10,FailureHandling.OPTIONAL))) {
			//			def num=assigneeName.indexOf(' ')
			def num=2

			def assigneeNameWithspaces=assigneeName.substring(num+1,(assigneeName.length()))

			assigneeName=assigneeNameWithspaces.trim()

		}

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/selectdrop',['Index':assigneeNo]))

		WebUI.delay(6)

		//		def assigneeName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/GetTextFromsSelectAssigne'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/MeetingDateTextField'),tomorowDate)


		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/StartTimeInMeetings'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/StartTimeInMeetings'),'11')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/StartTimeInMeetings'),'01')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/StartTimeInMeetings'),'p')

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/EndTimeInMeetings'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/EndTimeInMeetings'),'11')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/EndTimeInMeetings'),'40')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/EndTimeInMeetings'),'p')

		return assigneeName
	}
	@Keyword
	def enterZoomId() {
		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/ZoomInputFieldInMeetings'),zoomId)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/SaveButtonInMeetings'))

		WebUI.delay(7)

		return zoomId
	}
	@Keyword
	def selectDateDropDownFormat() {
		return dropDate
	}
}

