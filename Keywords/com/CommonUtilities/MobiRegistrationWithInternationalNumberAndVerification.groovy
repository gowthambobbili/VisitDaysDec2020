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


class MobiRegistrationWithInternationalNumberAndVerification {

	//mark555
	@Keyword
	def RegisterAnIndividualWithInternationalNumberAndVerifyValidation() {
		WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

		String VisitUrl = WebUI.getUrl()

		String VisitId = VisitUrl.split('visits/')[1]

		print(VisitUrl)

		String MobiUrl = GlobalVariable.EvrUrl+ VisitId

		WebUI.navigateToUrl(MobiUrl)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		//==================
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

		String SecondName = 'Name' + RandVar.nextInt(5000)

		String Email = ('test' + RandVar.nextInt(10000)) + '@gmail.com'

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '+1-613-555-0149')

		if(!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/ErrorFieldInMobi'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering Canada number(+1-613-555-0149) in Cell Phone Number field a validation error is shown in mobi")
			WebUI.takeScreenshot()
		}

		WebUI.clearText(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'))

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '+44 7911123456')

		if(!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/ErrorFieldInMobi'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering UK number(+44 7911123456) in Cell Phone Number field a validation error is shown in mobi")
			WebUI.takeScreenshot()
		}

		WebUI.clearText(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'))

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '+86 189 111 1234')

		if(!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/ErrorFieldInMobi'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering Chaina number(+86 189 111 1234) in Cell Phone Number field a validation error is shown in mobi")
			WebUI.takeScreenshot()
		}

		WebUI.clearText(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'))

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '+919111111111')

		if(!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/ErrorFieldInMobi'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering an Indian number in Cell Phone Number field a validation error is shown in mobi")
			WebUI.takeScreenshot()
		}

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

		if(!(WebUI.verifyElementPresent(findTestObject('Add Attendee/ApplicationStatusDropdown'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering an International number in student details page the page is not navigating to the next page")
			WebUI.takeScreenshot()
		}

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

		WebUI.delay(3)

		//		WebUI.waitForElementPresent(findTestObject('Add Attendee/ConfirmedHeaderInMobiConfirmationPage'), 0)
		//
		//		WebUI.waitForElementPresent(findTestObject('Add Attendee/CloseButtonInMobi'), 0)
		//
		//		WebUI.click(findTestObject('Add Attendee/CloseButtonInMobi'))
		WebUI.switchToDefaultContent()

		String Student = 'Test ' + SecondName

		WebUI.navigateToUrl(VisitUrl)

		def Individual = new TestObject('registeredStudentInRegisteredTab')

		Individual.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + Student) +
				'\']')

		if (!(WebUI.verifyElementPresent(Individual, 0))) {
			KeywordUtil.markFailed('The studeunt registered from Mobi is not shown in the registered tab of the corresponding visit')

			WebUI.takeScreenshot()
		}

		return Individual
	}


	//mark555
	@Keyword
	def RegisterAGrouplWithInternationalNumberAndVerifyValidation()
	{
		WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

		String VisitUrl = WebUI.getUrl()

		String VisitId = VisitUrl.split('visits/')[1]

		print(VisitUrl)

		String MobiUrl = GlobalVariable.EvrUrl+ VisitId

		WebUI.navigateToUrl(MobiUrl)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 3)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.verifyElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)

		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForElementVisible(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')

		//
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

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), 'test@email.com')



		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		String OrgName = 'Orgnazation'+RandVar.nextInt(9000).toString()

		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), OrgName)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '+1-613-555-0149')

		if(!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/ErrorFieldInMobi'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering Canada number(+1-613-555-0149) in Cell Phone Number field a validation error is shown in mobi")
			WebUI.takeScreenshot()
		}

		WebUI.clearText(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'))

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '+44 7911123456')

		if(!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/ErrorFieldInMobi'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering UK number(+44 7911123456) in Cell Phone Number field a validation error is shown in mobi")
			WebUI.takeScreenshot()
		}

		WebUI.clearText(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'))

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '+86 189 111 1234')

		if(!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/ErrorFieldInMobi'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering Chaina number(+86 189 111 1234) in Cell Phone Number field a validation error is shown in mobi")
			WebUI.takeScreenshot()
		}

		WebUI.clearText(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'))

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '+919111111111')

		if(!(WebUI.verifyElementNotPresent(findTestObject('Add Attendee/ErrorFieldInMobi'), 0, FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("While registering an individual, After entering an Indian number in Cell Phone Number field a validation error is shown in mobi")
			WebUI.takeScreenshot()
		}


		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(4)

		WebUI.switchToDefaultContent()

		String GroupName = OrgName

		WebUI.navigateToUrl(VisitUrl)

		def Group = new TestObject('registeredStudentInRegisteredTab')

		Group.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + GroupName) +'\']')

		if (!(WebUI.verifyElementPresent(Group, 0))) {
			KeywordUtil.markFailed('The studeunt registered from Mobo is not shown in the registered tab of the corresponding visit')

			WebUI.takeScreenshot()
		}

		return Group

	}
}