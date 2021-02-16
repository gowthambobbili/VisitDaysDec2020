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

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.junit.After
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class LoginAsDifferentUserPermissions {

	Verifications Verify = new Verifications()
	@Keyword
	def LoginAsReadOnlyUser() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl(GlobalVariable.StagingUrl)

		WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(2, 1))

		WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(2, 2))

		WebUI.click(findTestObject('LoginPage/SignInButton'))

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)
	}



	@Keyword
	def LoginAsEditorUser() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl(GlobalVariable.StagingUrl)

		WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(4, 1))

		WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(4, 2))

		WebUI.click(findTestObject('LoginPage/SignInButton'))

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)
	}

	@Keyword
	def LoginAsSchoolAdmin() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		//WebUI.navigateToUrl(findTestData('LoginData').getValue(3, 1))

		//WebUI.navigateToUrl("https://charizard-admin.visitdays.com/")

		//WebUI.navigateToUrl("https://pikachu-admin.visitdays.com/")

		WebUI.navigateToUrl(GlobalVariable.StagingUrl)

		WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(1, 1))

		WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(1, 2))

		WebUI.click(findTestObject('LoginPage/SignInButton'))

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

		WebUI.waitForElementPresent(findTestObject('Object Repository/HomePageElements/SchoolProdoutNav'), 0)

		WebUI.click(findTestObject('Object Repository/HomePageElements/SchoolProdoutNav'))

	}


	@Keyword
	def LoginAsAdminUserToAdminVisitDays() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://admin.visitdays.com/')

		WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(1, 1))

		WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(1, 2))

		WebUI.click(findTestObject('LoginPage/SignInButton'))

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)
	}


	@Keyword
	def LoginAsEditorUserToAdminVisitDays() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://admin.visitdays.com/')

		WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(4, 1))

		WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(4, 2))

		WebUI.click(findTestObject('LoginPage/SignInButton'))

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)
	}
	@Keyword
	def LoginToNacacStudentAppAsStudent() {
		//		WebUI.openBrowser('')
		//
		//		WebUI.maximizeWindow()

		WebUI.navigateToUrl(GlobalVariable.studenturl+"login/")

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/EmailTextField'),findTestData('NacacstudentLoginData').getValue(1, 1))

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/PasswordTextField'),findTestData('NacacstudentLoginData').getValue(1, 2))

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoginButton'))

		WebUI.waitForPageLoad(5)

		WebUI.delay(5)
	}
	@Keyword
	def LoginToNacacStudentAppAsStudentInNewBrowser() {
		WebUI.openBrowser('')
		//
		WebUI.maximizeWindow()

		WebUI.navigateToUrl(GlobalVariable.studenturl+"login/")

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/EmailTextField'),findTestData('NacacstudentLoginData').getValue(1, 1))

		WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/SignUpPage/PasswordTextField'),findTestData('NacacstudentLoginData').getValue(1, 2))

		WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoginButton'))

		WebUI.waitForPageLoad(0)
	}


	@Keyword
	def LoginAsReadOnlyUserToAdminVisitDays() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://admin.visitdays.com/')

		WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(2, 1))

		WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(2, 2))

		WebUI.click(findTestObject('LoginPage/SignInButton'))

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)
	}


	@Keyword
	def NavigateToHomePage() {

		WebUI.navigateToUrl(GlobalVariable.StagingUrl)
		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)
		WebUI.waitForElementPresent(findTestObject('Object Repository/HomePageElements/SchoolProdoutNav'),0)
		WebUI.click(findTestObject('Object Repository/HomePageElements/SchoolProdoutNav'))
	}
	@Keyword
	def NavigateToNacacHomePage() {

		WebUI.navigateToUrl(GlobalVariable.studenturl+'events')
		WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/UpcomingOptionInHomePage'), 0)
	}

	@Keyword
	def NavigateToHomePageInAdminVisitDays() {

		WebUI.navigateToUrl(GlobalVariable.StagingUrl)

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)
	}

	@Keyword
	def Logout() {

		WebUI.navigateToUrl(GlobalVariable.StagingUrl)

		WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

		WebUI.click(findTestObject('HomePageElements/ProfileAvatar'))

		WebUI.click(findTestObject('ElementsUnderProfileAvatar/LogoutOption'))

		Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('LoginPage/EmailTextBox'), "After logout the Login page is not shown")
	}
	@Keyword
	def LoginToSelfServeUrl() {
		WebUI.navigateToUrl(GlobalVariable.SelfServeUrl)

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/EmailTextBox'), findTestData('LoginData').getValue(5, 1))

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/PasswordTextField'), findTestData('LoginData').getValue(5, 2))

		WebUI.click(findTestObject('Object Repository/Self serve objects/LoginButton'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/HomeInTopNav'),0)
	}
	@Keyword
	def VerifyCheckinPageDateStampWithCurrentDate() {

		def date = new Date()

		String dateInString = date.toString()

		String actualDate = dateInString.substring(4, 10)

		println(actualDate)

		//CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.LoginAsSchoolAdmin'()

		WebUI.click(findTestObject('HomePageElements/CheckInLeftNav'))

		WebUI.waitForElementPresent(findTestObject('CheckInPage/TodaysDateInCheckInPage'), 0)

		String TodaysDate = WebUI.getText(findTestObject('CheckInPage/TodaysDateInCheckInPage'))

		println(TodaysDate)

		String TodaysDateInString = TodaysDate.toString()

		String[] afs = TodaysDateInString.split(',')

		println(afs[0])

		println(afs[1])

		String requiredPartOfDate = afs[1].trim()

		String[] requiredPartOfDateSplit = requiredPartOfDate.split(' ')

		String fourLetterMonthName = requiredPartOfDateSplit[0]

		String threeLetterMonthName = fourLetterMonthName.substring(0, 3)

		String fianalString = (threeLetterMonthName + ' ') + (requiredPartOfDateSplit[1])

		println(fianalString)

		WebUI.verifyMatch(fianalString, actualDate, false)

	}

	@Keyword
	def DuplicateNameCheck(TestObject VisitType) {

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.delay(10)

		WebUI.click(findTestObject('VisitTypesPage/AppcuesPopupbutton'))


		if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0) == true) {
			def FirstVisitTypeName = WebUI.getText(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'))

			println(FirstVisitTypeName)

			WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

			WebUI.click(findTestObject(VisitType))

			WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

			WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), FirstVisitTypeName)

			WebUI.verifyElementText(findTestObject('VisitTypesPage/DuplicateVisitTypeErrorMessage'), 'Two visit types can\'t have the same name')

			WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

			WebUI.click(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'))

			//WebUI.click(findTestObject('VisitTypesPage/OnlineCheckbox'))

			WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'), FailureHandling.STOP_ON_FAILURE)

			WebUI.verifyElementPresent(findTestObject('VisitTypesPage/DuplicateVisitTypeErrorMessage'), 0)
		} else {
			println('There are no VisitTypes Exist')
		}
	}

	@Keyword
	def VerifLocationInLocationsList(String LocationName) {

		def object = new TestObject("CretedLocation");
		object.addProperty("xpath", ConditionType.EQUALS, "//*[text()='"+LocationName+"']");

		if(!(WebUI.verifyElementPresent(object, 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailedAndStop("Created Location is not shown in the locations list")
		}
	}
}
