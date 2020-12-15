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


class NewMobiRegistration {
	/**
	 * Mobi registrations
	 */

	Verifications verifications = new Verifications()
	Random randVar = new Random()

	/**
	 * Register a Individual directly from visit
	 */
	@Keyword
	def registerIndividualDirectlyFromVisit(Map studentDetails) {

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.delay(5)

		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IndividualOptionInMobi'), "After clicking Add Registrant ([+]) button Individual option is not shown in the Mobi")

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)
		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))
		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))
		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		return answerIndividualQuestions(studentDetails)
	}

	/**
	 * Go to the mobi questions page
	 */
	@Keyword
	def gotoQuestionsPageInMobi() {

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IndividualOptionInMobi'), "After clicking Add Registrant ([+]) button Individual option is not shown in the Mobi")

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)
		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))
		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))
		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))
	}


	/**
	 * Register a group directly from visit
	 */
	@Keyword
	def registerAGroupDirectlyFromVisit(Map groupDetails) {

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)
		WebUI.verifyElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)
		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))
		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))
		WebUI.waitForElementVisible(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)
		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		return answerGroupQuestions(groupDetails)
	}

	/**
	 * Individual registration in Mobi
	 */
	@Keyword
	def registerIndividual(def VisitTypeCategory, def visitType, Map studentDetails=[:]){

		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IframeOfMobi'), "After clicking Add Attendee button Mobi is not open")
		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.delay(3)
		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IndividualOptionInMobi'), "Individual option is not present in Mobi landing page")
		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))
		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/NextButtonInAddAttendee'), "Next button is not present in the landing page of Mobi")
		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))
		WebUI.delay(3)
		WebUI.waitForPageLoad(0)
		WebUI.click(VisitTypeCategory)

		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":visitType]), "Created visit is not present in the Mobi")
		WebUI.click(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":visitType]))
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 3, FailureHandling.OPTIONAL))
			WebUI.click(findTestObject('Object Repository/Add Attendee/Yes,AddButtonInRegistrationClosedModal'))
		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))
		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		return answerIndividualQuestions(studentDetails)
	}

	/**
	 * Group registration in Mobi
	 */
	@Keyword
	def registerGroup(def VisitTypeCategory, def visitType, Map studentDetails=[:]){
	}


	@Keyword
	def answerIndividualQuestions(Map studentDetails) {

		//		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
		//		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)
		WebUI.delay(3)
		WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))
		if(studentDetails.containsKey("guests")) {
			WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown', ["number":studentDetails.get("guests")]))
		}
		else {
			WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown', ["number":"1"]))
		}

		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), 3, FailureHandling.OPTIONAL)) {

			if(studentDetails.containsKey("accessibility")) {
				WebUI.click(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'))
				verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/AccessibilityTextArea'), "Accesibility text area is not present in Mobi")
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
		String SecondName = 'Name'+randVar.nextInt(5000)
		String Email
		if(studentDetails.containsKey("email"))
		{
			Email =  studentDetails.get("email")
		}
		else
		{
			Email = 'test'+randVar.nextInt(10000)+'@gmail.com'
		}
		String defaultFirstName = 'Test'
		if(studentDetails.containsKey("firstName"))
		{
			WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), studentDetails.get("firstName"))
			defaultFirstName = studentDetails.get("firstName")
		}
		else
		{
			WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), defaultFirstName)
		}
		if(studentDetails.containsKey("lastName"))
		{
			WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), studentDetails.get("lastName"))
			SecondName = studentDetails.get("lastName")
		}
		else
		{
			WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)
		}

		if(studentDetails.containsKey("email"))
		{
			WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), studentDetails.get("email"))
		}
		else
		{
			WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)
		}

		if(studentDetails.containsKey("phone"))
		{
			WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), studentDetails.get("phone"))
		}
		else
		{
			WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), "5555555555")
		}

		//		WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))
		//		WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))
		//		WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))
		//		WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))
		//		WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))
		//		WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))
		//		WebUI.click(findTestObject('Object Repository/Add Attendee/DateOfBirthNewField'))
		WebUI.sendKeys(findTestObject('Object Repository/Add Attendee/DateOfBirthNewField'),"1999-02-14")
		WebUI.sendKeys(findTestObject('Add Attendee/HomeAddressInStudentInformationPage'), 'Test address 123')
		WebUI.click(findTestObject('Add Attendee/CountryDropdownInStudentInformationPage'))
		WebUI.click(findTestObject('Add Attendee/UnitedStatesOptionInCountryDropdown'))
		WebUI.sendKeys(findTestObject('Add Attendee/CityOrTownInStudentInformationPage'), 'Test city')
		WebUI.click(findTestObject('Add Attendee/StateOrProvinceDropdownInStudentInformationPage'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Add Attendee/StateOrProvinceOption'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Add Attendee/ZipCodeInStudentInformationPage'), '50001')
		//		WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/ApplicationStatusDropdown'))

		if(studentDetails.containsKey("applicantStatus"))
		{
			WebUI.click(findTestObject('Add Attendee/AppliedOptionInApplicationStatus', ["status":"Not applied"]))
		}
		else
		{
			WebUI.click(findTestObject('Add Attendee/AppliedOptionInApplicationStatus', ["status":"Applied"]))
		}

		WebUI.click(findTestObject('Add Attendee/FreshmanOptionInWhatKindOfApplicantYouAre'))
		WebUI.click(findTestObject('Add Attendee/ExpectedEntryYearDropdown'))

		if(studentDetails.containsKey("entryYear"))
		{
			WebUI.click(findTestObject('Object Repository/Add Attendee/ExpectedEntryYear', ["year":studentDetails.get("entryYear")]))
		}
		else
		{
			WebUI.click(findTestObject('Add Attendee/2022OptionInExpectedEntryYear'))
		}

		WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolDropDown'))
		WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), 'testschool')
		WebUI.click(findTestObject('Add Attendee/FirsrtOptionInCurrentOrLastSchool'))
		if(WebUI.verifyElementPresent(findTestObject('Add Attendee/AcademicInterestsDropdown'), 3, FailureHandling.OPTIONAL))
		{
			WebUI.click(findTestObject('Add Attendee/AcademicInterestsDropdown'))
			WebUI.click(findTestObject('Add Attendee/FirstOptionInAcademicInterests'))
		}

		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))

		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))
		//verifications.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Add Attendee/IframeOfMobi'), "After completing the registration the mobi is not getting closed")
		//WebUI.switchToDefaultContent()
		WebUI.delay(3)
		return defaultFirstName+' '+SecondName

	}

	@Keyword
	def answerGroupQuestions(Map groupDetails){

		if(groupDetails.containsKey("students"))
		{
			WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), groupDetails.get("students"))
		}
		else
		{
			WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')
		}

		if(groupDetails.containsKey("chaperones"))
		{
			WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), groupDetails.get("chaperones"))
		}
		else
		{
			WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')
		}

		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/Group/YesOptionInAccessibilityNeedInGroup'), 3, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
		}

		//		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
		//			WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))
		//
		//			WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
		//		}

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		String SecondName = 'Name'+randVar.nextInt(9000).toString()

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), 'test@email.com')

		if(groupDetails.containsKey("phone"))
		{
			WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), groupDetails.get("phone"))
		}
		else
		{
			WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')
		}

		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		String OrgName = 'Orgnazation'+randVar.nextInt(9000).toString()

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), OrgName)

		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(2)

		//		WebUI.switchToDefaultContent()
		//
		//		WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)

		return OrgName
	}

	@Keyword
	def switchToDefaultContent()
	{
		verifications.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Add Attendee/IframeOfMobi'), "After completing the registration the mobi is not getting closed")
		WebUI.switchToDefaultContent()
		WebUI.delay(3)
	}
}











