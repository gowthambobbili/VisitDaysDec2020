package com.CommonUtilitiesofNACACstudentApp
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
import com.CommonUtilities.Verifications

class SmokeTests {
	/**
	 * smoke test re-usables
	 */

	Verifications verify = new Verifications()
	@Keyword
	def verifyPersonalInfoPage() {

		def rootPath = "Object Repository/NacacStudentApp/PersonalInfo/"
		List elements = [
			"AddressLineOne",
			"AddressLineTwo",
			"AmericanIndianOrAlaskaNativeOption",
			"ApplicantTypeHeader",
			"AsianOption",
			"BlackOrAfricanAmericanOption",
			"cityField",
			"CounselorOption",
			"CountryDropdown",
			"CurrentOrLastSchoolField",
			"dobField",
			"EthinticityHeader",
			"FallOptions",
			"FamilyOption",
			"FirstNameFIeld",
			"FirstYearCollegeStudentOption",
			"FriendsOption",
			"GraduationYearField",
			"HispanicOrLatinxOption",
			"HowDidYouHearAboutVirtualFairHeader",
			"IntendedEnrollmentYearHeader",
			"InternatioalStudentOption",
			"LastNameFIeld",
			"NativeHawaiianOption",
			"OtherOptionInHowDidYouHear",
			"OthherOptionInEtinticity",
			"PhoneNumberField",
			"PostalCodeField",
			"PreferNotToAnswerInEthinticity",
			"PreferNotToAnswerOptionInHowDidYouHear",
			"SpotifyOption",
			"SpringOptions",
			"StateField",
			"TeacherOption",
			"TransferStudentOption",
			"UsVeteranStudent",
			"WhiteOption"
		]
		for(element in elements) {
			verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the Personal info page the "+element+" is not present")
		}
	}

	@Keyword
	def verifyMyAccountPage() {

		def rootPath = "Object Repository/NacacStudentApp/Account/"
		List elements = [
			"CookiePolicyLink",
			"EmailHeader",
			"LegalHeader",
			"LogoutButton",
			"PrivacyPolicy",
			"TermsOfServiceLink",
			"TypeHeader"
		]
		for(element in elements) {
			verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the My Account page the "+element+" is not present")
		}
	}

	@Keyword
	def verifyVideoFiltersModal() {

		def rootPath = "Object Repository/NacacStudentApp/Filters/"
		List elements = [
			"AssosiatesCheckbox",
			"BachelorsCheckbox",
			"CollegeAdvertisingCheckbox",
			"CollegeAndUniversityExhibitorsCheckbox",
			"FiltersCloseButton",
			"InternationalCheckbox",
			"LargeOption",
			"MajorsDropdown",
			"MediumCheckbox",
			"PrivateCheckbox",
			"PublicCheckbox",
			"ShowButton",
			"SmallCheckbox",
			"StatesDropdown",
			"TagsDropdown",
			"UnitedStatesCheckbox",
			"VideosFiltersHeader"
		]
		for(element in elements) {
			verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the Videos Filters modal the "+element+" is not present")
		}
	}

	@Keyword
	def verifyCollegesPage() {

		def rootPath = "Object Repository/NacacStudentApp/Colleges/"
		List elements = [
			"AssosiatesCheckbox",
			"BachelorsCheckbox",
			"CollegeAdvertisingCenterCheckbox",
			"CollegeAndUniversityExhibitors",
			"CollegesCount",
			"CollegesTab",
			"FilterHeader",
			"LargeCheckbox",
			"LiveSessionsTab",
			"MajorsDropdown",
			"MediumCheckbox",
			"PrivateCheckbox",
			"PublicCheckbox",
			"RegisterButton",
			"SearchField",
			"SearchhByStateDropdown",
			"ShowInternationalLoocationsDropdown",
			"SmallCheckbox",
			"SortButton"
		]
		for(element in elements) {
			verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the Colleges page the "+element+" is not present")
		}
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/Colleges/SortButton'))
		for(element in ["A-ZOption", "Z-AOption"]) {
			verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the Colleges page the "+element+" is not present")
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/Colleges/FirstCollege'), 15, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/NacacStudentApp/Colleges/FirstCollege'))
			for(element in [
				"FavoriteIcon",
				"ScheduleAMeetingButton",
				"UpcomingEventsTab",
				"VideosTab"
			]) {
				verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the College page the "+element+" is not present")
			}
			WebUI.click(findTestObject('Object Repository/NacacStudentApp/Colleges/ScheduleMeetingHeader'))
			verify.VerifyElementPresent(findTestObject('Object Repository/NacacStudentApp/Colleges/ScheduleMeetingHeader'), "When click Schedule meeting button the pop up is not getting opened")
			verify.VerifyElementPresent(findTestObject('Object Repository/NacacStudentApp/Colleges/DateDropdown'), "In Schedule meeting Modal the Date dropdown is not present")
			verify.VerifyElementPresent(findTestObject('Object Repository/NacacStudentApp/Colleges/ScheduleNowButton'), "In Schedule meeting Modal the Schedule Now button is not present")
			verify.VerifyElementPresent(findTestObject('Object Repository/NacacStudentApp/Colleges/CloseScheduleMeetingModalButton'), "In Schedule meeting Modal the Close(X) button is not present")
			WebUI.click(findTestObject('Object Repository/NacacStudentApp/Colleges/CloseScheduleMeetingModalButton'))
			verify.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/NacacStudentApp/Colleges/ScheduleMeetingHeader'), "When click Close button in Schedule meeting modal then the Schedule meeting modal is not getting closed")
		}
	}


	@Keyword
	def verifyLiveSessionsPage() {

		def rootPath = "Object Repository/NacacStudentApp/Colleges/"
		List elements = [
			"AllTimesButton",
			"SearchField",
			"TagsDropdown",
			"LocationsDropdown",
			"ShowInternationalLoocationsDropdown",
			"MajorsDropdown",
			"PrivateCheckbox",
			"PublicCheckbox",
			"AssosiatesCheckbox",
			"BachelorsCheckbox",
			"SmallCheckbox",
			"MediumCheckbox",
			"LargeCheckbox",
			"CollegeAdvertisingCenterCheckbox",
			"CollegeAndUniversityExhibitors"
		]
		for(element in elements) {
			verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the Live Sessions page the "+element+" is not present")
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/Colleges/Livesessions'), 10, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/NacacStudentApp/Colleges/Livesessions'))
			verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/NacacStudentApp/Colleges/JoinLiveSessionButton'), "In Live Session page the Join Live Session button is not shown")
		}
	}
}