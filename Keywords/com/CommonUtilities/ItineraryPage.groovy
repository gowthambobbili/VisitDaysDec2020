package com.CommonUtilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.google.common.base.Verify
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


class ItineraryPage {
	/**
	 * Get the required data from account basics
	 */
	PageNavigations Navigate = new PageNavigations()
	Verifications Verify = new Verifications()
	@Keyword
	def GetDataFromAccountbasics() {
		Navigate.NavigateToAccountBasics()
		Map AccountBasicsDetails = [:]
		AccountBasicsDetails.put("MainContactEmail", WebUI.getText(findTestObject('Object Repository/SettingsPage/Account Basics/MainContactEmailInAccountBasics')))
		AccountBasicsDetails.put("MainContactPhone", WebUI.getText(findTestObject('Object Repository/SettingsPage/Account Basics/MainContactPhoneInAccountBasics')))

		Map FaceBookDetails = [:]

		Map TwitterDetails = [:]

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/SettingsPage/Account Basics/FacebookLink'), 10, FailureHandling.OPTIONAL)) {
			FaceBookDetails.put("IsFacebookPresent",true)
			FaceBookDetails.put("FacebookLink", WebUI.getText(findTestObject('Object Repository/SettingsPage/Account Basics/FacebookLink')))
		}
		else {
			FaceBookDetails.put("IsFacebookPresent",false)
		}

		AccountBasicsDetails.put("Facebook", FaceBookDetails)

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/SettingsPage/Account Basics/TwitterLink'), 10, FailureHandling.OPTIONAL)) {

			TwitterDetails.put("IsTwitterPresent", true)
			TwitterDetails.put("TwitterLink", WebUI.getText(findTestObject('Object Repository/SettingsPage/Account Basics/TwitterLink')))
		}
		else {
			TwitterDetails.put("IsTwitterPresent", false)
		}

		AccountBasicsDetails.put("Twitter", TwitterDetails)

		return AccountBasicsDetails
	}

	@Keyword
	def GetDataFromLocation(){
		Navigate.NavigateToLocations()
		Map Location = [:]
		Location.put("LocationName", WebUI.getText(findTestObject('Object Repository/SettingsPage/Locations/FirstLocationInLocationsList')))
		WebUI.click(findTestObject('Object Repository/SettingsPage/Locations/FirstLocationInLocationsList'))
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/SettingsPage/Locations/DeleteButtonInDeleteLocationPopup'), "When click on location the Location Details modal is not shown")

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/SettingsPage/Locations/WhereToMeetInstructionsInLocationDetailsModal'), 10, FailureHandling.OPTIONAL)) {
			Location.put("IsWhereToMeetPresent", true)
			Location.put("WhereToMeet", WebUI.getText(findTestObject('Object Repository/SettingsPage/Locations/WhereToMeetInstructionsInLocationDetailsModal')))
		}
		else {
			Location.put("IsWhereToMeetPresent", false)
		}

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkInstructionsInLocationsDetailsModal'), 10, FailureHandling.OPTIONAL)) {
			Location.put("IsWhereToParkPresent", true)
			Location.put("WhereToPark", WebUI.getText(findTestObject('Object Repository/SettingsPage/Locations/WhereToParkInstructionsInLocationsDetailsModal')))
		}
		else {
			Location.put("IsWhereToParkPresent", false)
		}

		return Location
	}

	@Keyword
	def DateSuffix(int date){
		switch (date % 10) {
			case 1:
				return "st";
				break;
			case 2:
				return "nd";
				break;
			case 3:
				return "rd";
				break;
			default:
				return "th";
				break;
		}
	}

	@Keyword
	def VerifyItineraryPage(def AccountBasics, String VisitDate, String VisitType, String VisitTime="8:00 AM - 9:00 AM"){

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/ItineraryPage/VisitType(visittype)', ["visittype":VisitType]), "In the Itinerary page, the visit type "+VisitType+" is not shown")
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/ItineraryPage/DateOfItinerary'), "In the Itinerary page, the visit type "+VisitType+" is not shown")
		def DateInItineraryPage = WebUI.getText(findTestObject('Object Repository/ItineraryPage/DateOfItinerary')).trim()
		Verify.VerifyTextMatch(DateInItineraryPage, VisitDate, "Incorrect date shown in the itinerary page, expected: "+VisitDate+", Actual: "+DateInItineraryPage)
	}
}



