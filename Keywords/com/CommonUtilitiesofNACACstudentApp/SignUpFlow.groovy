package com.CommonUtilitiesofNACACstudentApp

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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class SignUpFlow {

	Random rd=new Random()
	def num=rd.nextInt(10000)
	def email="Test.user"+num+"@qualitlabs.com"
	def password="mahesh@1995"
	def Credentials
	def dateOfBirth="02-11-1997"
	def firstname="test"+num
	def lastname="user"
	def mobileNumber="+14846930061"
	@Keyword
	def SignupforStudentType() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.studenturl+"signup/")
		WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/SignUpPage/EmailTextField'), 0)
	}
	@Keyword
	def SignupforTeacherOrCounselorType() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.studenturl+"signup/")
		WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/SignUpPage/EmailTextField'), 0)
	}
	@Keyword
	def SignupforParentOrGuardainType() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.studenturl+"signup/")
		WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/SignUpPage/EmailTextField'), 0)
	}
	@Keyword
	def enterEmail() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/EmailTextField'),email)
		return email
	}
	@Keyword
	def enterPassword() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/PasswordTextField'),password)
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/CheckBoxInSignupPage'))
		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButton'), 0, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButton'))
		return password
	}
	@Keyword
	def enterStudentType() {
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentTypeInSecondPage'))
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))
	}
	@Keyword
	def enterTeacherOrCounselorType() {
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/CounselorOrTeacher'))
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))
	}
	@Keyword
	def enterParentOrGuardainType() {
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ParentOrGuardainType'))
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))
	}
	@Keyword
	def enterFirstName() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FirstnameTextField'),firstname)

		return firstname
	}
	@Keyword
	def enterParentFirstName() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/ParentFirstName'),firstname)

		return firstname
	}
	@Keyword
	def enterParentLastName() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/parentLastName'),lastname)

		return lastname
	}
	@Keyword
	def enterLastName() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/LastNameTextField'),lastname)

		return lastname
	}
	@Keyword
	def enterParentMobileNumber() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ParentDetailsPage/EnterParentMobileNumber'),mobileNumber)

		return mobileNumber
	}
	@Keyword
	def enterStudentDetailsForParentType() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ParentDetailsPage/StudentFirstName'),"Test")

		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ParentDetailsPage/StudentSecondName'),"Student")

		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ParentDetailsPage/StudentPhoneNumber'),mobileNumber)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))

		WebUI.delay(5)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/UpcomingOptionInHomePage'),0)
	}
	@Keyword
	def enterTeacherDetails() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FirstnameTextField'),firstname)

		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/LastNameTextField'),lastname)

		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ParentDetailsPage/EnterParentMobileNumber'),mobileNumber)

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/TeacherSchool'),"Test school")

		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/TeacherRadioButton'), 0)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/TeacherRadioButton'))

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))

		WebUI.delay(5)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/UpcomingOptionInHomePage'),0)
	}
	@Keyword
	def enterStudentMobileNumber() {
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/CellPhoneNumberField'),mobileNumber)

		return mobileNumber
	}
	@Keyword
	def enterAddressDetails() {
		//		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/CellPhoneNumberField'),"(484) 693-0061")
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/CountryDropDown'))
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/USACountryInDropDown'))
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/AddressLineOne'),"test address")
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/AddressLineTwo'),"test address two")
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/CityTextField'),"New York")
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StateDropDown'))
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/NewYorkStateInDropDown'))
		//		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/DummyStateInput'),'NewYork')
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/PostalOrZipCode'),"10002")
		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/PostalOrZipCode'),0)

		return "New York"
	}
	@Keyword
	def enterDOB() {
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/DOBtextfielldlabel'))
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/DOBtextField'), dateOfBirth)
		return dateOfBirth
	}
	@Keyword
	def enterLastSchoolstudied() {
		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/Current or Last School'), 0)

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/Current or Last School'),"Test school")



		return "Test school"
	}
	@Keyword
	def enterOrSelectPrograms() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ProgramsTesxField'),'Agriculture')

		//		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ProgramOrMajorsDropDownOption1'))

		return "Agriculture"
	}

	@Keyword
	def selectMajorsOptionFromDropDown() {
		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ProgramsTesxField'),0)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/MajorsFirstOptionSelect'))
	}
	@Keyword
	def selectApplicantType() {

		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FirstYearCollegeStudent'),0)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/InternationalStudent'))
	}
	@Keyword
	def enterHighSchoolGraduationYear(){

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/High school graduation year'),"2016")

		return "2016"
	}
	@Keyword
	def enterEnrollmentYear() {

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/spring2022'))
	}
	@Keyword
	def selectEthnicityField() {

		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/American or Indian checkbox'), 0)

		WebUI.check(findTestObject('Object Repository/NacacStudentApp/SignUpPage/WhiteCheckBox'))
	}
	@Keyword
	def selectGender() {

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/MaleOption'))
	}
	@Keyword
	def selectReferredByOption() {

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FriendsOption'))
	}
	@Keyword
	def clickContinueAfterEnteringStudentDetails() {

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))

		WebUI.delay(5)

		WebUI.waitForPageLoad(0)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/UpcomingOptionInHomePage'),0)
	}
}

