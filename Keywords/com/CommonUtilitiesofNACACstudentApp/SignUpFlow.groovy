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
	def dob="02-11-1997"
	def firstname="test"+num
	def lastname="user"
	@Keyword
	def SignupforStudentType() {
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
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButton'))
		return password
	}
	@Keyword
	def enterStudentType() {
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentTypeInSecondPage'))
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))
	}
	@Keyword
	def enterFirstName() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FirstnameTextField'),firstname)

		return firstname
	}
	@Keyword
	def enterLastName() {
		WebUI.setText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/LastNameTextField'),lastname)

		return lastname
	}
	@Keyword
	def enterAddressDetails() {
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/CellPhoneNumberField'),"(484) 693-0061")
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/CountryDropDown'))
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/USACountryInDropDown'))
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/AddressLineOne'),"test address")
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/AddressLineTwo'),"test address two")
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/CityTextField'),"New York")
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StateDropDown'))
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/NewYorkStateInDropDown'))
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/PostalOrZipCode'),"10002")
		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/DOBtextField'),0)

		return "NewYork"
	}
	@Keyword
	def enterDOB() {
		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/DOBtextfielldlabel'))
		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/DOBtextField'),'01-12-1995')
	}
	@Keyword
	def enterLastSchoolstudied() {
		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/Current or Last School'), 0)

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/Current or Last School'),"Test school")



		return "Test school"
	}
	@Keyword
	def selectApplicantType() {

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ProgramsTesxField'),"Agriculture")

		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FirstYearCollegeStudent'),0)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/InternationalStudent'))

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/High school graduation year'),"2016")

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/spring2022'))

		WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/American or Indian checkbox'), 0)

		WebUI.check(findTestObject('Object Repository/NacacStudentApp/SignUpPage/WhiteCheckBox'))

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/MaleOption'))

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FriendsOption'))

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))

		WebUI.delay(5)

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/ContinueButtoninSecondpage'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/UpcomingOptionInHomePage'),0)
	}
}

