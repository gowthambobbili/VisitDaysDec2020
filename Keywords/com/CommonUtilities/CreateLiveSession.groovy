package com.CommonUtilities
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.*;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


public class CreateLiveSession {
	Random rd=new Random()
	Random rd2=new Random()
	Random rd3=new Random()
	Date dNow = new Date()
	Date tomorow = new Date(dNow.getTime() + (1000 * 60 * 60 * 24))
	SimpleDateFormat ft =new SimpleDateFormat ("MM/dd/yyyy")
	String meetdate=(ft.format(dNow)).toString()
	//	def meetdate=meetdates.substring(0,5)
	def tomorowdate=(ft.format(tomorow)).toString()
	SimpleDateFormat time=new SimpleDateFormat("hh:mm a");
	String time1=(time.format(dNow)).toString()
	String hours=time1.substring(0, 2);
	String meridian=time1.substring(6,7);
	int hourstoInt=Integer.parseInt(hours);
	int hoursadd=hourstoInt+2;
	String endHours=String.valueOf(hoursadd)
	String endTimeMeridian=meridian
	def num=rd.nextInt(100000)
	def sessionname="TestSession"+num
	def ZoomId="https://zoom.us/j/12345678"
	def attachment="https://visitdays.com/"
	def providerName=GlobalVariable.ConventionProvider
	//	def conName=GlobalVariable.createdConventionName
	@Keyword
	def selectConvention() {
		WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

		WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink',['ConventionProvider':providerName]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

		WebUI.waitForPageLoad(5)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/CreateButtonInLiveSessions'))

		WebUI.waitForPageLoad(5)
		
		WebUI.delay(3)

		def ConventionName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/getNameOfFirstConvention'))

		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ClickFirstConventionInCreatingLiveSessions'))

		//		WebUI.click(findTestObject('ConventionsPageAdmin/SelectFirstConvention',['ConventionName':GlobalVariable.createdConventionName]))

		//		return GlobalVariable.createdConventionName

		return ConventionName

	}
	@Keyword
	def selectFixedLengthConvention(def conName)
	{
		WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

		WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/CreateButtonInLiveSessions'))

		WebUI.waitForPageLoad(5)

		//		def ConventionName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/getNameOfFirstConvention'))

		//		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ClickFirstConventionInCreatingLiveSessions'))

		WebUI.click(findTestObject('ConventionsPageAdmin/SelectFirstConvention',['ConventionName':conName]))

		return conName

		//				return ConventionName
	}
	@Keyword
	def enterLiveSessionDetailsAndTime() {
		println(meridian)

		if(hours=="11" && meridian=="A")
		{
			endTimeMeridian="P";
		}

		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/Name field'),sessionname)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/Descriptionfield'),"this is test description")

		println(meetdate)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/dateFieldAtStartTime'),meetdate)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),hours)

		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),"00")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),meridian)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/Duration minutes text field'),'60')

		if(hours=="11" && meridian=="P")
		{
			endTimeMeridian="A";
			meetdate=tomorowdate;
		}

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/DateFieldAtEndTime'), 3, FailureHandling.OPTIONAL))
		{
			WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/DateFieldAtEndTime'),meetdate)

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'))

			WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),endHours)

			WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),"00")

			WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),endTimeMeridian)
		}
		return sessionname
	}
	@Keyword
	def enterLiveSessionDetailsAndFutureTime() {

		if(hours=="11" && meridian=="A")
		{
			meridian="p";
		}

		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/Name field'),sessionname)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/Descriptionfield'),"this is test description")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/dateFieldAtStartTime'),tomorowdate)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),hours)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),"00")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),meridian)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/Duration minutes text field'),'60')

		if(hours=="11" && meridian=="P")
		{
			endTimeMeridian="A";
			meetdate=tomorowdate;
		}

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/DateFieldAtEndTime'), 0, FailureHandling.OPTIONAL))
		{
			WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/DateFieldAtEndTime'),tomorowdate)

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'))

			WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),endHours)

			WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),"00")

			WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),endTimeMeridian)
		}
		return sessionname
	}
	@Keyword
	def enterLiveSessionDetailsAndTimeForFixedLengthConventions()
	{
		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/Name field'),sessionname)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/Descriptionfield'),"this is test description")

		println(meetdate)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/dateFieldAtStartTime'),meetdate)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),hours)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),"00")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),meridian)

		if(!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/ConventionsPageAdmin/DateFieldAtEndTime'),0,FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed('end date time field is shhown for fixed length sessions')
		}
		if(!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),0,FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed('end time field is shhown for fixed length sessions')
		}
		return sessionname
	}
	@Keyword
	def enterLiveSessionDetailsAndTimeForFutureTimeFixedLengthConventions()
	{
		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/Name field'),sessionname)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/Descriptionfield'),"this is test description")

		println(meetdate)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/dateFieldAtStartTime'),tomorowdate)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),hours)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),"00")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),meridian)

		if(!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/ConventionsPageAdmin/DateFieldAtEndTime'),0,FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed('end date time field is shhown for fixed length sessions')
		}
		if(!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),0,FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed('end time field is shhown for fixed length sessions')
		}
		return sessionname
	}

	@Keyword
	def enterZoomIdAndAddAssigne() {

		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/ZoomMeetingField'),ZoomId)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/CapacityField'),"5")

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/ClickOnTagsDropDown'),3,FailureHandling.OPTIONAL))
		{
			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ClickOnTagsDropDown'))

			WebUI.delay(4)

			def tagsCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionsPageAdmin/SelectTagsdropDownInSessionsPage'),0).size()

			def tagNumber=rd3.nextInt(tagsCount)

			def tagName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/selectTagsDropsessions',['tagsCount':tagsCount]))

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/selectTagsDropsessions',['tagsCount':tagsCount]))

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AddButtonOfTagsDrop'))
		}
		WebUI.scrollToElement(findTestObject('Object Repository/ConventionsPageAdmin/AssigneesDropDown'),0,FailureHandling.OPTIONAL)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AssigneesDropDown'))

		WebUI.delay(5)

		def AssigneesCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionsPageAdmin/SelectAssigneByDropDownSessions'),0).size()

		def AssigneeNo =rd2.nextInt(AssigneesCount)

		def assigneeName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/selectDropSessions', ['Index':AssigneeNo]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/selectDropSessions',['Index':AssigneeNo]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Add button of add assigne'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/upload photo'))

		String userDir = System.getProperty('user.dir')

		WebUI.uploadFile(findTestObject('Object Repository/ConventionsPageAdmin/BrowsePhotoAddress'),userDir + '\\studentimg.jpg')

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ApplybuttoninPhotoUpload'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/SaveButton'))

		//		WebUI.waitForElementNotPresent(findTestObject('Object Repository/ConventionsPageAdmin/SaveButton'), 0)

		WebUI.delay(5)

		return ZoomId
	}
	@Keyword
	def enterZoomIdAndAddAssigneeIncludingTags()
	{
		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/ZoomMeetingField'),ZoomId)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/CapacityField'),"5")

		def tagName

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/ClickOnTagsDropDown'),3,FailureHandling.OPTIONAL))
		{

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ClickOnTagsDropDown'))

			WebUI.delay(4)

			def tagsCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionsPageAdmin/SelectTagsdropDownInSessionsPage'),0).size()

			def tagNumber=rd.nextInt(tagsCount)

			tagName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/selectTagsDropsessions',['tagsCount':tagsCount]))

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/selectTagsDropsessions',['tagsCount':tagsCount]))

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AddButtonOfTagsDrop'))

		}

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AssigneesDropDown'))

		WebUI.delay(5)

		def AssigneesCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionsPageAdmin/SelectAssigneByDropDownSessions'),0).size()

		def AssigneeNo =rd3.nextInt(AssigneesCount)

		def assigneeName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/selectDropSessions', ['Index':AssigneeNo]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/selectDropSessions',['Index':AssigneeNo]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Add button of add assigne'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/upload photo'))

		String userDir = System.getProperty('user.dir')

		WebUI.uploadFile(findTestObject('Object Repository/ConventionsPageAdmin/BrowsePhotoAddress'),userDir + '\\studentimg.jpg')

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ApplybuttoninPhotoUpload'))

		WebUI.scrollToElement(findTestObject('Object Repository/ConventionsPageAdmin/AddAnotherAttachmentButton'),3, FailureHandling.OPTIONAL)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AddAnotherAttachmentButton'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/AttachmentLinkField'),attachment)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/AttachmentName'),"VisitDays")

		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/SaveButton'))

		WebUI.delay(3)

		return tagName

		//		WebUI.waitForElementNotPresent(findTestObject('Object Repository/ConventionsPageAdmin/SaveButton'), 0)


	}
}