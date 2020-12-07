
package com.CommonUtilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class AddVisitorDirectlyToTheVisit {

	Verifications Verifications = new Verifications()
	NewMobiRegistration register = new NewMobiRegistration()

	//update555
	@Keyword
	def AddIndividualDirectlyToTheVisit(String Accessibility = 'false') {

		def nameOfStudent = register.registerIndividualDirectlyFromVisit([:])
		register.switchToDefaultContent()
		WebUI.refresh()
		return nameOfStudent
	}

	//update555
	@Keyword
	def AddIndividualDirectlyToARequestVisit() {

		return register.registerIndividualDirectlyFromVisit([:])
	}


	//update555
	@Keyword
	def AddGroupDirectlyToAVisit() {
		return register.registerAGroupDirectlyFromVisit([:])
	}


	//update555
	@Keyword
	def AddIndividualDirectlyToTheVisitAndReturnAllAnswers() {

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))

		WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))

		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), 3, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
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

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

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

		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))


		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(3)

		WebUI.switchToDefaultContent()

		WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)

		List <String> Responces = []

		Responces.add(0, SecondName)

		Responces.add(1,Email)

		return Responces
	}

	//update555
	@Keyword
	def AddGroupDirectlyToAVisitAndReturnResponces() {
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.verifyElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)

		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForElementVisible(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')


		//		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/Group/YesOptionInAccessibilityNeedInGroup'), 3, FailureHandling.OPTIONAL)) {
		//			WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
		//		}

		//		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
		//			WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))
		//
		//			WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
		//		}

		//		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		Random RandVar = new Random()

		String SecondName = 'Name'+RandVar.nextInt(9000).toString()

		String Email = 'test'+RandVar.nextInt(10000)+'@gmail.com'

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

//		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		String OrgName = 'Orgnazation'+RandVar.nextInt(9000).toString()

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), OrgName)
		//
		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))


		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(2)

		WebUI.switchToDefaultContent()

		WebUI.waitForElementPresent(findTestObject('HomePageElements/AddAttendeeButton'), 0)

		WebUI.refresh()

		//		List <String> GroupResponces = [SecondName, Email, OrgName]
		return OrgName

	}

	def AddAttendeToSessionInperson()
	{

		WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/plusattendesymbol'),0)

		WebUI.click(findTestObject('Object Repository/Add Attendee/plusattendesymbol'))

		//     WebUI.click(findTestObject('Object Repository/HomePageElements/AddAttendeeButton')	)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/InPersonInAddAttende'),0)

		WebUI.click(findTestObject('Object Repository/Add Attendee/InPersonInAddAttende'))

		WebUI.click(findTestObject('Object Repository/Add Attendee/RegisterButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))

		WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))

		WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

		WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))

		Random RandVar = new Random()

		String SecondName = 'Name'+RandVar.nextInt(5000)

		String Email = 'test'+RandVar.nextInt(10000)+'@gmail.com'

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))

		WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))

		WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))

		WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))

		WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))

		WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))

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

		WebUI.sendKeys(findTestObject('Add Attendee/HomeAddressInStudentInformationPage'), 'Test address 123')

		WebUI.click(findTestObject('Add Attendee/CountryDropdownInStudentInformationPage'))

		WebUI.click(findTestObject('Add Attendee/UnitedStatesOptionInCountryDropdown'))

		WebUI.sendKeys(findTestObject('Add Attendee/CityOrTownInStudentInformationPage'), 'Test city')

		WebUI.click(findTestObject('Add Attendee/StateOrProvinceDropdownInStudentInformationPage'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Add Attendee/StateOrProvinceOption'), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('Add Attendee/ZipCodeInStudentInformationPage'), '50001')

		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))


		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))



		WebUI.delay(3)

		WebUI.switchToDefaultContent()

		//		return student


	}

}
