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


class VisitTypeCreationUserflow {

	Verifications Verify = new Verifications()
	@Keyword
	def CreateVisitTypeWithSpecifiedValues(Map VisitTypeDetails){

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		def VisitType

		if(!(VisitTypeDetails.containsKey("VisitType"))){
			WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))
			VisitType = "DailyVisit"
		}
		else if(VisitTypeDetails.get("VisitType")=='OffCampus'){
			WebUI.click(findTestObject('Object Repository/VisitTypesPage/OffCampusOption'))
			VisitType = "OffCampus"
		}
		else{
			WebUI.click(findTestObject('Object Repository/VisitTypesPage/eventOption'))
			VisitType = "Event"
		}

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		if(!(VisitTypeDetails.containsKey("RegistrantType"))){
			WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))
			WebUI.delay(2)
			WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))
		}
		else if(VisitTypeDetails.get("RegistrantType")=="Ind"){
			WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))
		}
		else{
			WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))
		}

		if(!(VisitTypeDetails.containsKey("RegistrationMethod"))){
			WebUI.click(findTestObject('Object Repository/VisitTypesPage/InstantBookRadioButton'))
		}
		else{
			WebUI.click(findTestObject('Object Repository/VisitTypesPage/RequestRadioButton'))
		}

		WebUI.scrollToElement(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'), 0)

		if(!(VisitTypeDetails.containsKey("CheckInMethod"))){
			WebUI.click(findTestObject('Object Repository/VisitTypesPage/ManualCheckInOnlyRadioButton'))
		}
		else if(VisitTypeDetails.get("CheckInMethod")=="Automated"){
			WebUI.click(findTestObject('Object Repository/VisitTypesPage/AutomatedTextMessageRadioButton'))
		}
		else{
			WebUI.click(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'))
		}

		if(VisitType!="OffCampus"){

			WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

			if(!(VisitTypeDetails.containsKey("WaysToMeet"))){
				WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))
			}
			else if(VisitTypeDetails.get("WaysToMeet")=="Online"){
				WebUI.click(findTestObject('Object Repository/VisitTypesPage/OnlineCheckbox'))
				Verify.VerifyElementPresent(findTestObject('Object Repository/VisitTypesPage/OnlineWaysToMeetDescriptionTextfield'), "While creating a visit type, When click Online Checkibox in Ways to meet division, the textbox is not shown")
				WebUI.sendKeys(findTestObject('Object Repository/VisitTypesPage/OnlineWaysToMeetDescriptionTextfield'), "Online instructions")
			}
			else if(VisitTypeDetails.get("WaysToMeet")=="Phone"){
				WebUI.scrollToElement(findTestObject('Object Repository/VisitTypesPage/PhoneCheckbox'), 0)
				WebUI.click(findTestObject('Object Repository/VisitTypesPage/PhoneCheckbox'))
				Verify.VerifyElementPresent(findTestObject('Object Repository/VisitTypesPage/PhonewaysToMeetDescription'), "While creating a visit type, When click Phone Checkibox in Ways to meet division, the textbox is not shown")
				WebUI.sendKeys(findTestObject('Object Repository/VisitTypesPage/PhonewaysToMeetDescription'), "Phone instructions")
			}
			else{
				WebUI.click(findTestObject('Object Repository/VisitTypesPage/OnlineCheckbox'))
				Verify.VerifyElementPresent(findTestObject('Object Repository/VisitTypesPage/OnlineWaysToMeetDescriptionTextfield'), "While creating a visit type, When click Online Checkibox in Ways to meet division, the textbox is not shown")
				WebUI.sendKeys(findTestObject('Object Repository/VisitTypesPage/OnlineWaysToMeetDescriptionTextfield'), "Online instructions")
				WebUI.scrollToElement(findTestObject('Object Repository/VisitTypesPage/PhoneCheckbox'), 0)
				WebUI.click(findTestObject('Object Repository/VisitTypesPage/PhoneCheckbox'))
				Verify.VerifyElementPresent(findTestObject('Object Repository/VisitTypesPage/PhonewaysToMeetDescription'), "While creating a visit type, When click Phone Checkibox in Ways to meet division, the textbox is not shown")
				WebUI.sendKeys(findTestObject('Object Repository/VisitTypesPage/PhonewaysToMeetDescription'), "Phone instructions")
			}
		}

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test description ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		if(!(VisitTypeDetails.containsKey("CloseRegistration"))){
			WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))
		}
		else{
			WebUI.click(findTestObject('Object Repository/VisitTypesPage/CloseNumberofDaysDaysTextBox'))
			WebUI.sendKeys(findTestObject('Object Repository/VisitTypesPage/CloseRegistrationTextbox'), VisitTypeDetails.get("CloseRegistration"))
		}

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}
}