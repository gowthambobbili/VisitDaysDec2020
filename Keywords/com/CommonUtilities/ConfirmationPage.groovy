package com.CommonUtilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.List
import java.util.Map

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.omg.CORBA.Object
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


class ConfirmationPage {

	Random RandVar = new Random()
	Verifications Verify = new Verifications()
	NewMobiRegistration register = new NewMobiRegistration()

	//update555
	@Keyword
	def NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName(String VisitType, TestObject VisitTypeCategory, String NumberOfRequests) {

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementClickable(findTestObject('HomePageElements/AddAttendeeButton'), 0)
		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))
		return register.registerIndividual(VisitTypeCategory, VisitType)
	}



	//==================================================


	//oldmobi555
	@Keyword
	def RegistrationOfACombinationOfRequestAndInstant(String RequestVisitType, String InstantVisitType, TestObject VisitTypeCategory, String NumberOfRequests) {

		WebDriver driver = DriverFactory.getWebDriver()


		WebUI.waitForElementClickable(findTestObject('HomePageElements/AddAttendeeButton'), 0)

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		WebUI.delay(7)

		//not_run: WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IframeOfMobi'), "After clicking Add Attendee button Mobi is not open")

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)
		
		WebUI.waitForPageLoad(0)

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IndividualOptionInMobi'), "Individual option is not present in Mobi landing page")

		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/NextButtonInAddAttendee'), "Next button is not present in the landing page of Mobi")

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		//WebUI.waitForElementPresent(findTestObject('Add Attendee/ChooseADateLabelInAddAttendee'), 0)

		WebUI.delay(3)

		WebUI.waitForPageLoad(0)

		WebUI.click(VisitTypeCategory)

		//		WebUI.delay(17)
		//		if(VisitTypeCategory==findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))
		//		{
		//			WebUI.waitForElementPresent(findTestObject('Add Attendee/FiterByLocationCheckboxInOffCampus'), 0)
		//		}

		def Object1 = new TestObject("InstantVisitInMobi")

		Object1.addProperty("xpath",ConditionType.EQUALS, "//h1[text()='"+InstantVisitType+"']/../../../..//button[@class=' mobi-daily-visit--hours-item']")

		WebUI.verifyElementPresent(Object1, 0)

		WebUI.click(Object1)

		if(WebUI.verifyElementPresent(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 5, FailureHandling.OPTIONAL))
		{
			WebUI.waitForElementVisible(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 0)

			WebUI.click(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'))

			WebUI.waitForElementNotPresent(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 0)
		}

		WebUI.delay(3)

		def object = new TestObject("AddToMyItinerary")

		object.addProperty("xpath", ConditionType.EQUALS, "//h1[text()='"+RequestVisitType+"']/../../../..//button[text()='Add to My Itinerary']")

		WebUI.verifyElementPresent(object, 0)



		WebUI.click(object)

		driver.findElement(By.xpath(('//h1[text()=\'' + RequestVisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()

		String flag

		String SecondVisitTypeName

		if(NumberOfRequests=='multiple')
		{
			if(WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'), 0, FailureHandling.OPTIONAL))
			{
				SecondVisitTypeName = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameOfFirstAddToMyItineraryButtonInThePage'))
				WebUI.click(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'))
				flag = 'true'
			}
		}

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		//WebUI.verifyElementPresent(findTestObject('Add Attendee/TimePendingLabelInBuilderPage'), 0)

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

		//Random RandVar = new Random()

		String SecondName = 'Name'+RandVar.nextInt(5000)

		String Email = 'test'+RandVar.nextInt(10000)+'@gmail.com'

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		//		WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))
		//
		//		WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))
		//
		//		WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))

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

		return 'Test '+SecondName
	}



	//====================================================


	//update555
	@Keyword
	def NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName(String VisitType, TestObject VisitTypeCategory, String NumberOfRequests) {

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementVisible(findTestObject('HomePageElements/AddAttendeeButton'), 0)
		WebUI.waitForElementClickable(findTestObject('HomePageElements/AddAttendeeButton'), 0)
		WebUI.delay(4)
		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('HomePageElements/AddAttendeeButton'), "Add Attende button is not present in the home page")
		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))
		return register.registerIndividual(VisitTypeCategory, VisitType)
	}


	//oldmobi555
	/**
	 * @param VisitType
	 * @param VisitTypeCategory
	 * @param NumberOfRequests
	 * @return
	 */
	@Keyword
	def NavgateToConfirmationPageForIndividualRegistrationOfInstantVisitForTomorrow(String VisitType, TestObject VisitTypeCategory, String NumberOfRequests) {

		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.waitForElementClickable(findTestObject('HomePageElements/AddAttendeeButton'), 0)

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		WebUI.delay(7)

		//not_run: WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))


		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		//WebUI.waitForElementPresent(findTestObject('Add Attendee/ChooseADateLabelInAddAttendee'), 0)

		if(VisitTypeCategory==findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))
		{
			WebUI.click(findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'))
		}

		WebUI.delay(3)

		WebUI.waitForPageLoad(0)

		WebUI.verifyElementPresent(VisitTypeCategory, 0)

		WebUI.click(VisitTypeCategory)

		//WebUI.delay(17)
		if(VisitTypeCategory==findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))
		{
			WebUI.waitForElementPresent(findTestObject('Add Attendee/FiterByLocationCheckboxInOffCampus'), 0)
		}


		def Object = new TestObject("CreatedVisitInMobi")

		Object.addProperty("xpath",ConditionType.EQUALS, "//h1[text()='"+VisitType+"']/../../../..//button[@class=' mobi-daily-visit--hours-item']")

		WebUI.verifyElementPresent(Object, 0)

		WebUI.click(Object)

		if(WebUI.verifyElementPresent(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 5, FailureHandling.OPTIONAL))
		{
			WebUI.waitForElementVisible(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 0)

			WebUI.click(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'))

			WebUI.waitForElementNotPresent(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 0)
		}

		WebUI.delay(3)
		String flag

		String SecondVisitTypeName

		if(NumberOfRequests=='multiple')
		{
			if(WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'), 0, FailureHandling.OPTIONAL))
			{
				SecondVisitTypeName = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameOfFirstAddToMyItineraryButtonInThePage'))
				WebUI.click(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'))
				flag = 'true'
			}
		}
		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		//WebUI.verifyElementPresent(findTestObject('Add Attendee/TimePendingLabelInBuilderPage'), 0)

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

		//Random RandVar = new Random()

		String SecondName = 'Name'+RandVar.nextInt(5000)

		String Email = 'test'+RandVar.nextInt(10000)+'@gmail.com'

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		//		WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))
		//
		//		WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))
		//
		//		WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))
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

		return 'Test '+SecondName
	}






	//update555
	@Keyword
	def NavgateToConfirmationPageForIndividualRegistration(String VisitType, TestObject VisitTypeCategory, String NumberOfRequests, String Email) {

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))
		return register.registerIndividual(VisitTypeCategory, VisitType, ["email":Email])
	}

	@Keyword
	def ConfirmationPageVerificationForSingleRegistration(String VisitType)
	{
		WebUI.verifyElementPresent(findTestObject('Add Attendee/RegistrationSubmitterHeaderInConfirmationPageOfMobi'), 0)
		WebUI.delay(5)
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath("//div[@class='itinerary-visit']//h4[text()='"+VisitType+"']")).isDisplayed()
		driver.findElement(By.xpath("//div[@class='itinerary-visit']//h4[text()='"+VisitType+"']/..//div[contains(text(),'Time Pending')]")).isDisplayed()
		WebUI.verifyElementNotPresent(findTestObject('Add Attendee/AddToCalendarBUttonInConfirmationPage'), 0)
	}

	@Keyword
	def ConfirmationPageVerificationForMultipleRegistration(String VisitType, String SecondVisitTypeName)
	{

		WebUI.verifyElementPresent(findTestObject('Add Attendee/RegistrationSubmitterHeaderInConfirmationPageOfMobi'), 0)
		WebUI.delay(5)

		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath("//div[@class='itinerary-visit']//h4[text()='"+VisitType+"']")).isDisplayed()
		driver.findElement(By.xpath("//div[@class='itinerary-visit']//h4[text()='"+VisitType+"']/..//div[contains(text(),'Time Pending')]")).isDisplayed()

		if(SecondVisitTypeName!=null)
		{
			driver.findElement(By.xpath("//h4[text()='"+SecondVisitTypeName+"']")).isDisplayed()
			driver.findElement(By.xpath("//h4[text()='"+SecondVisitTypeName+"']/..//div[contains(text(),'Time Pending')]")).isDisplayed()
		}
		WebUI.verifyElementNotPresent(findTestObject('Add Attendee/AddToCalendarBUttonInConfirmationPage'), 0)

	}

	@Keyword
	def ConfirmationPageVerificationForARequestAndInstantRegistration(String VisitType, String VisitTypeHavingVisitHours)
	{
		WebUI.delay(5)
		WebDriver driver = DriverFactory.getWebDriver()

		driver.findElement(By.xpath("//div[@class='itinerary-visit']//h4[text()='"+VisitType+"']")).isDisplayed()
		//driver.findElement(By.xpath("//h4[text()='"+VisitType+"']/../..//h3[text()='TIME PENDING']")).isDisplayed()

		//		if(VisitTypeHavingVisitHours!=null)
		//		{z
		//			driver.findElement(By.xpath("//h4[text()='"+VisitTypeHavingVisitHours+"']")).isDisplayed()
		//			//driver.findElement(By.xpath("//h4[text()='"+VisitTypeHavingVisitHours+"']/..//div[contains(text(),'Time Pending')]")).isDisplayed()
		//		}
		WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToCalendarBUttonInConfirmationPage'), 0)
	}


	//mark555
	@Keyword
	def NavgateToConfirmationPageForGroupRequest(String VisitType, TestObject VisitTypeCategory, String NumberOfRequests)
	{
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		WebUI.delay(7)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForPageLoad(0)

		WebUI.click(VisitTypeCategory)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/VisitTypeDivisionInAddAttendee'), 0)

		WebUI.delay(5)

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()


		String SecondVisitTypeNameForGroup

		if(NumberOfRequests=='multiple')
		{
			if(WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'), 0, FailureHandling.OPTIONAL))
			{
				SecondVisitTypeNameForGroup = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameOfFirstAddToMyItineraryButtonInThePage'))
				WebUI.click(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'))

			}
		}

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')


		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/Group/YesOptionInAccessibilityNeedInGroup'), 5, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
		}

		//		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
		//			WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))
		//
		//			WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
		//		}

		String Email = 'test'+RandVar.nextInt(10000)+'@gmail.com'

		//		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), 'Name')

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), 'Test Org')

		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))


		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(4)

		return SecondVisitTypeNameForGroup

	}


	@Keyword
	def NavigateToConfirmationPageWithARqquestAndInstantVisit(TestObject VisitTypeCategory, String VisitType, String OrganisationName )
	{
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		WebUI.delay(7)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(VisitTypeCategory)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/VisitTypeDivisionInAddAttendee'), 0)

		WebUI.delay(5)

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()


		String VisitTypeHavingHours

		if(WebUI.verifyElementPresent(findTestObject('Add Attendee/FirstVIsitHoursInMobi'), 0, FailureHandling.OPTIONAL))
		{
			VisitTypeHavingHours = WebUI.getText(findTestObject('Add Attendee/FirstVisitHoursVisitName'))

			WebUI.click(findTestObject('Add Attendee/FirstVIsitHoursInMobi'))

			if(WebUI.verifyElementPresent(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 5, FailureHandling.OPTIONAL))
			{
				WebUI.waitForElementVisible(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 0)

				WebUI.click(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'))

				WebUI.waitForElementNotPresent(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 0)
			}

		}

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

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

		String Email = 'test'+RandVar.nextInt(10000)+'@gmail.com'

		//		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), 'user123')

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), OrganisationName)

		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))


		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(4)

		return VisitTypeHavingHours
	}

	//mark555
	@Keyword
	def NavgateToConfirmationPageForGroupRequestWithUserName(String VisitType, TestObject VisitTypeCategory, String NumberOfRequests)
	{
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.delay(4)

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('HomePageElements/AddAttendeeButton'), "Add Attendee button is not present in the home page")

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IframeOfMobi'), "Mobi is not opened when clicked on Add Attendee")

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IndividualOptionInMobi'), "After clicking Add Attendee button, Individual option is not present in Mobi")

		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.delay(4)

		WebUI.click(VisitTypeCategory)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/VisitTypeDivisionInAddAttendee'), 0)

		if(VisitTypeCategory==findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))
		{
			WebUI.waitForElementPresent(findTestObject('Add Attendee/FiterByLocationCheckboxInOffCampus'), 0)
		}

		//WebUI.delay(15)

		def object12 = new TestObject("CreatedVisitInMobi")

		object12.addProperty("xpath", ConditionType.EQUALS,"//h1[text()='"+VisitType+"']/../../../..//button[text()='Add to My Itinerary']")

		WebUI.verifyElementPresent(object12, 0)

		WebUI.click(object12)

		//		driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()
		//
		//		driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()


		String SecondVisitTypeNameForGroup

		if(NumberOfRequests=='multiple')
		{
			if(WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'), 0, FailureHandling.OPTIONAL))
			{
				SecondVisitTypeNameForGroup = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameOfFirstAddToMyItineraryButtonInThePage'))
				WebUI.click(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'))

			}
		}

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		//		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')
		//
		//		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')


		//		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/Group/YesOptionInAccessibilityNeedInGroup'), 3, FailureHandling.OPTIONAL)) {
		//			WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
		//		}

		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

			WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
		}

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		Random RandVar = new Random()

		String SecondName = 'Name'+RandVar.nextInt(9000).toString()

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), 'test@email.com')

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')


		//		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		String OrgName = 'Orgnazation'+RandVar.nextInt(9000).toString()

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), OrgName)

		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))


		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(4)

		return OrgName

	}


	//mark555
	@Keyword
	def NavgateToConfirmationPageForGroupRequestWithUserNameForInstantBook(String VisitType, TestObject VisitTypeCategory, String NumberOfRequests)
	{
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.delay(4)

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('HomePageElements/AddAttendeeButton'), "Add Attendee button is not present in the homepage")

		WebUI.waitForElementVisible(findTestObject('HomePageElements/AddAttendeeButton'), 0)

		WebUI.waitForElementClickable(findTestObject('HomePageElements/AddAttendeeButton'), 0)

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IframeOfMobi'), "On clicking Add Attende button the Mobi page is not opened")

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Add Attendee/IndividualOptionInMobi'), "Individual radio button is not shown in Mobi when opened by clicking Add Attendee button")

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.verifyElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)

		WebUI.delay(3)

		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForPageLoad(0)

		WebUI.click(VisitTypeCategory)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/VisitTypeDivisionInAddAttendee'), 0)

		if(VisitTypeCategory==findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))
		{
			WebUI.waitForElementPresent(findTestObject('Add Attendee/FiterByLocationCheckboxInOffCampus'), 0)
		}

		//		WebUI.delay(15)
		//
		//		driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()
		//
		//		driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()
		//
		//		driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()


		def Object1 = new TestObject("CreatedVisitInMobi")

		Object1.addProperty("xpath",ConditionType.EQUALS, "//h1[text()='"+VisitType+"']/../../../..//button[@class=' mobi-daily-visit--hours-item']")

		WebUI.verifyElementPresent(Object1, 0)

		WebUI.click(Object1)

		if(WebUI.verifyElementPresent(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 5, FailureHandling.OPTIONAL))
		{
			WebUI.waitForElementVisible(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 0)

			WebUI.click(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'))

			WebUI.waitForElementNotPresent(findTestObject('Add Attendee/Yes,AddButtonInRegistrationClosedModal'), 0)
		}

		WebUI.delay(3)

		String SecondVisitTypeNameForGroup

		if(NumberOfRequests=='multiple')
		{
			if(WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'), 0, FailureHandling.OPTIONAL))
			{
				SecondVisitTypeNameForGroup = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameOfFirstAddToMyItineraryButtonInThePage'))
				WebUI.click(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'))

			}
		}

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		//		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')
		//
		//		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')


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

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')


		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		String OrgName = 'Orgnazation'+RandVar.nextInt(9000).toString()

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), OrgName)
		//
		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))
		//

		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(4)

		return OrgName

	}


	//mark555
	@Keyword
	def NavgateToConfirmationPageForGroupRequestWithGivenEmail(String VisitType, TestObject VisitTypeCategory, String NumberOfRequests, String Email)
	{
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		WebUI.delay(7)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForPageLoad(0)

		WebUI.click(VisitTypeCategory)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/VisitTypeDivisionInAddAttendee'), 0)

		WebUI.delay(5)

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

		driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()


		String SecondVisitTypeNameForGroup

		if(NumberOfRequests=='multiple')
		{
			if(WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'), 0, FailureHandling.OPTIONAL))
			{
				SecondVisitTypeNameForGroup = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameOfFirstAddToMyItineraryButtonInThePage'))
				WebUI.click(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'))

			}
		}

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		WebUI.delay(3)

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')


		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/Group/YesOptionInAccessibilityNeedInGroup'), 3, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
		}

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

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		String OrgName = 'Orgnazation'+RandVar.nextInt(9000).toString()

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), OrgName)

		//		WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
		//
		//		WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))


		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(4)

		return OrgName

	}

	//oldmobi
	@Keyword
	def CompleteRegistration(List VisitTypes, def VisitTypeCategory, def RegistrantType = 'individual')
	{
		if(RegistrantType=='individual')
		{
			WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)
			WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

			WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

			def Email = "testemail"+RandVar.nextInt(10000)+"@gmail.com"

			def LastName = "user"+RandVar.nextInt(100000)

			WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

			WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

			WebUI.delay(4)

			WebUI.waitForPageLoad(0)

			WebUI.click(VisitTypeCategory)

			if(VisitTypeCategory==findTestObject('Object Repository/Add Attendee/DailyVisitsOptionInAddAttendee'))
			{
				WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))
			}
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'), 10, FailureHandling.OPTIONAL))
			{
				WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))
			}

			WebUI.delay(6)

			println VisitTypes.size()
			for(def i=0;i<VisitTypes.size();i++)
			{
				WebUI.delay(6)
				Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":VisitTypes[i]]), "The Created visit type is not present in Mobi")
				WebUI.click(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":VisitTypes[i]]))
			}

			WebUI.delay(6)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'), 0)

			WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

			WebUI.delay(5)

			WebUI.waitForElementVisible(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

			WebUI.waitForElementClickable(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

			WebUI.delay(2)

			WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

			WebUI.delay(5)

			WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))

			WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))

			//			if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), 3, FailureHandling.OPTIONAL)) {
			//				WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
			//			}

			if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 3, FailureHandling.OPTIONAL))
			{
				WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

				WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
			}
			//			WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))


			//			WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

			WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'test')

			WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), LastName)

			WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

			WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

			//			WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))

			//			WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))
			//
			//			WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))
			//
			//			WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))
			//
			//			WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))
			//
			//			WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))
			WebUI.sendKeys(findTestObject('Object Repository/Add Attendee/DateOfBirthNewField'),"1999-02-14")

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

			//			WebUI.click(findTestObject('Add Attendee/OptinalObjectInRegistrationPage'))
			//
			//			WebUI.click(findTestObject('Add Attendee/OptionalTestDropDownSelect'))

			//			WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

			WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

			WebUI.delay(3)

			return "test "+LastName

		}
		else
		{
			WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

			WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

			WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

			WebUI.verifyElementPresent(findTestObject('Add Attendee/GroupOptionInAddAttendee'), 0)

			WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

			WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

			WebUI.click(VisitTypeCategory)

			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'), 10, FailureHandling.OPTIONAL))
			{
				WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))
			}

			WebUI.delay(6)

			println VisitTypes.size()
			for(def i=0;i<VisitTypes.size();i++)
			{
				WebUI.delay(6)
				Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":VisitTypes[i]]), "The Created visit type is not present in Mobi")
				WebUI.click(findTestObject('Object Repository/Add Attendee/VisitTimeButtonInMobi(VisitType)', ["VisitType":VisitTypes[i]]))
			}

			WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

			WebUI.waitForElementVisible(findTestObject('Add Attendee/RegisterButtonInAddAttendee'), 0)

			WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

			//			WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

			//			WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')
			//
			//
			////			if (WebUI.verifyElementPresent(findTestObject('Add Attendee/Group/YesOptionInAccessibilityNeedInGroup'), 3, FailureHandling.OPTIONAL)) {
			////				WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
			////			}
			//
			//				if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
			//					WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))
			//
			//				WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
			//			}
			//
			////		    WebUI.sendKeys(findTestObject('Object Repository/UserProfile/Details/OrganisationName'),OrgName)
			//
			//		    WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

			Random RandVar = new Random()

			String SecondName = 'Name'+RandVar.nextInt(9000).toString()

			//			WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstNameInStudentInformationPage'),0)

			WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

			WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

			WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), 'test@email.com')

			WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')
			WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

			WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')

			//			WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

			String OrgName = 'Orgnazation'+RandVar.nextInt(9000).toString()

			WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), OrgName)

			WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

			WebUI.delay(2)

			WebUI.switchToDefaultContent()
		}
	}


	@Keyword
	def confirmationPageTest(List Visits, def RegistrationMethod, def CountOfRequests, def CountOfInstant, def InstantVisitTime = "8:00 am - 9:00 am")
	{
		def VisitType
		def VisitTypeMethod
		for(def i=0;i<Visits.size();i++)
		{
			VisitType = Visits[i].split("-")[0]
			VisitTypeMethod = Visits[i].split("-")[1]
			if(Visits[i].split("-")[1]=='r')
			{
				if((Visits.size()==1) || (Visits.size()==CountOfRequests))
				{
					Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/VisitTypeInConfirmationPage(VisitType)', ["VisitType":VisitType]), "While registering to " +RegistrationMethod+", the request visit type is not shown in the Mobi confirmation page")
					if((Visits.size()!=CountOfRequests))
						Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/TimePendingLabelOfRequestVisitType(VisitType)'), "While registering to "+RegistrationMethod+", the Time Pending label is not shown for request visit in the Mobi confirmation  page")
				}
				else
				{
					Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/TimePendingVisitTypesInMobiConfirmationPage(VisitType)', ["VisitType":VisitType]), "While registering to "+RegistrationMethod+", The request visit type is not shown in the Mobi confirmation page")
					//Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/TimePendingLabelOfRequestVisitType(VisitType)', ["VisitType":VisitType]), "While registering to "+RegistrationMethod+", the Time Pending label is not shown for request visit in the Mobi confirmation  page")
				}
			}
			else
			{
				if((Visits.size()==1) || (Visits.size()==CountOfInstant))
				{
					Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/VisitTypeInConfirmationPage(VisitType)', ["VisitType":VisitType]), "While registering to " +RegistrationMethod+", the Instant visit type is not shown in the Mobi confirmation page")
					Verify.VerifyTextMatch(WebUI.getText(findTestObject('Object Repository/Add Attendee/ScheduledVisitTimeInMobiConfirmation(VisitType)',["VisitType":VisitType])), InstantVisitTime, "While registerring to "+RegistrationMethod+", in the confirmation page the Scheduled(Instant) vistit time shows incorrect")
				}
				else
				{
					Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Add Attendee/ScheduledVisitTypesInMobiConfirmationPage(VisitType)', ["VisitType":VisitType]), "While registering to" +RegistrationMethod+ ", the instant visit is not shown in the Confirmation page of Mobi")
					Verify.VerifyTextMatch(WebUI.getText(findTestObject('Object Repository/Add Attendee/ScheduledVisitTimeInMobiConfirmation(VisitType)',["VisitType":VisitType])), InstantVisitTime, "While registerring to "+RegistrationMethod+", in the confirmation page the Scheduled(Instant) vistit time shows incorrect")
				}
			}
		}
	}
}

