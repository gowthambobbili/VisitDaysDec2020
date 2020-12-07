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
import com.kms.katalon.core.webui.keyword.builtin.VerifyElementPresentKeyword

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


class Conversations extends Verifications{
	/**
	 * Conversations
	 */
	Verifications verify = new Verifications()
	SelfServeUtilities SelfServe = new SelfServeUtilities()


	@Keyword
	def GenerateRanodPhoneNumber() {

		Random Random = new Random()
		def num1 = Random.nextInt(10).toString()
		def num2 = Random.nextInt(10).toString()
		def PhoneNumber = "20155501"+num1+num1
	}



	@Keyword
	def NavigateToSimulatedSmsPage() {

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/InstitutionHeaderInSelfServe'), 10, FailureHandling.OPTIONAL)) {
			println "skip"
		}
		else {
			SelfServe.LoginToSelfServeTool()
		}
		WebUI.navigateToUrl(GlobalVariable.SelfServeUrl+GlobalVariable.Institution+"/simulated_sms_messages")
		WebUI.refresh()
	}


	@Keyword
	def SendSms(String Number, String BodyContent) {

		verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/SimulatedSms/PhoneNumberField'), "In Simulated sms page, the phone number input field is not present")
		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/SimulatedSms/PhoneNumberField'), Number)
		verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/SimulatedSms/SmsBodyField'), "In simulated sms page, the body content input field is not present")
		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/SimulatedSms/SmsBodyField'), BodyContent)
		verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Self serve objects/SimulatedSms/SaveSmsButton'), "In simulated sms page, the Save sms button is not present")
		WebUI.click(findTestObject('Object Repository/Self serve objects/SimulatedSms/InstitutionSpecificNumberCheckbox'))
		WebUI.click(findTestObject('Object Repository/Self serve objects/SimulatedSms/SaveSmsButton'))
		WebUI.delay(3)
	}

	//mark555
	@Keyword
	def RegisterAStudentWithGivenPhoneNumber(String PhoneNumber, String Accessibility = 'false') {

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)
		if(!(WebUI.verifyElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("After clicking Add Registrant ([+]) button Individual option is not shown in the Mobi")
		}
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)
		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))
		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))
		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))
		WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))
		WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))
		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), 3, FailureHandling.OPTIONAL)) {
			if(Accessibility!='false') {
				WebUI.click(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'))
				verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/AccessibilityTextArea'), "Accesibility text area is not present in Mobi")
				WebUI.sendKeys(findTestObject('Object Repository/Add Attendee/AccessibilityTextArea'), "Test description")
			}
			else {
				WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
			}
		}
		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 3, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

			WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
		}
		//		WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))
		Random RandVar = new Random()
		String SecondName = 'Name'+RandVar.nextInt(5000)
		String Email = 'test'+RandVar.nextInt(10000)+'@gmail.com'
		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')
		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)
		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)
		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), PhoneNumber)
		WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))
		WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))
		WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))
		WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))
		WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))
		WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))
		WebUI.sendKeys(findTestObject('Add Attendee/HomeAddressInStudentInformationPage'), 'Test address 123')
		WebUI.click(findTestObject('Add Attendee/CountryDropdownInStudentInformationPage'))
		WebUI.click(findTestObject('Add Attendee/UnitedStatesOptionInCountryDropdown'))
		WebUI.sendKeys(findTestObject('Add Attendee/CityOrTownInStudentInformationPage'), 'Test city')
		WebUI.click(findTestObject('Add Attendee/StateOrProvinceDropdownInStudentInformationPage'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Add Attendee/StateOrProvinceOption'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Add Attendee/ZipCodeInStudentInformationPage'), '50001')
		//		WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))
		WebUI.click(findTestObject('Add Attendee/ApplicationStatusDropdown'))
		WebUI.click(findTestObject('Add Attendee/AppliedOptionInApplicationStatus'))
		WebUI.click(findTestObject('Add Attendee/FreshmanOptionInWhatKindOfApplicantYouAre'))
		WebUI.click(findTestObject('Add Attendee/ExpectedEntryYearDropdown'))
		WebUI.click(findTestObject('Add Attendee/2022OptionInExpectedEntryYear'))
		WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolDropDown'))
		WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), 'testschool')
		WebUI.click(findTestObject('Add Attendee/FirsrtOptionInCurrentOrLastSchool'))
		WebUI.click(findTestObject('Add Attendee/AcademicInterestsDropdown'))
		WebUI.click(findTestObject('Add Attendee/FirstOptionInAcademicInterests'))
		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))
		verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Add Attendee/IframeOfMobi'), "After completing the registration the mobi is not getting closed")
		WebUI.switchToDefaultContent()
		WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)
		return 'Test '+SecondName
	}

	@Keyword
	def verifySmsCount(int OldSmsCount){

		WebUI.waitForElementPresent(findTestObject('Object Repository/Coversations/InboxLeftNav'), 0)
		def LatestSmsCount = Integer.parseInt(WebUI.getText(findTestObject('Object Repository/Coversations/UnreadMessagesCountBadge')))
		def ActualCount = (LatestSmsCount).toString()
		def ExpectedCount = (OldSmsCount+1).toString()
		verify.VerifyTextMatch(ActualCount, ExpectedCount, "After sending an inbouned message the unread sms count shows incorrect. Expected: "+ActualCount+" Expected:"+ExpectedCount)
		WebUI.click(findTestObject('Object Repository/Coversations/FirstConversationInTheList'))
		verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Coversations/SmsTextArea'), "When click on the conversation, the sms text area is not shown")
		if(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Coversations/UnreadMessagesCountBadge'), 10, FailureHandling.OPTIONAL)) {
			ActualCount = '0'
		}
		else {
			ActualCount = WebUI.getText(findTestObject('Object Repository/Coversations/UnreadMessagesCountBadge'))
		}
		ExpectedCount = (Integer.parseInt(ExpectedCount)-1).toString()
		verify.VerifyTextMatch(ActualCount, ExpectedCount, "After sending an inbouned message the unread sms count shows incorrect. Expected: "+ActualCount+" Expected:"+ExpectedCount)
	}

	@Keyword
	def VerifyLatestMessageIsShownOnTheConversation(String Student, String LatestMessage){

		def FirstConversation = WebUI.getText(findTestObject('Object Repository/Coversations/FirstConversationInTheList')).trim()
		println Student
		println FirstConversation
		//verify.VerifyTextMatch(FirstConversation, Student, "The latest conversation in not shown in the conversations page. Expected: "+FirstConversation+", Actual: "+Student)
		if(!(FirstConversation.contains(Student)))
		{
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("The latest converation in not shown in the conversations page. Expected: "+FirstConversation+", Actual: "+Student)
		}
		def MessageOnFirstConversation = WebUI.getText(findTestObject('Object Repository/Coversations/MessageShownOnTheConversation')).trim()
		verify.VerifyTextMatch(MessageOnFirstConversation, LatestMessage, "The latest message is not shown on the conversation. Actual: "+MessageOnFirstConversation+", Expected: "+LatestMessage)
	}

	@Keyword
	def VerifyMessagesOrderInConveration(List Messages){

		def sms
		for(int i=0;i<3;i++) {
			sms = WebUI.getText(findTestObject('Object Repository/Coversations/LatestInboundSms', ["index":i]))
			verify.VerifyTextMatch(sms, Messages[3-i], "The messages are not in sorted order")
		}
	}
}







