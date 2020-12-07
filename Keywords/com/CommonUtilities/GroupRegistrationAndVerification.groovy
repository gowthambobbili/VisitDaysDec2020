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

class Registraions {

	//mark555
	@Keyword
	def GroupRegistrationAndVerification(String VisitTypeName, TestObject VisitType) {
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

		WebUI.delay(7)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(VisitType)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/VisitTypeDivisionInAddAttendee'), 0)

		WebUI.delay(5)

		driver.findElement(By.xpath(('//strong[text()=\'' + VisitTypeName) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

		driver.findElement(By.xpath(('//strong[text()=\'' + VisitTypeName) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

		driver.findElement(By.xpath(('//strong[text()=\'' + VisitTypeName) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyProspectiveStudentsQuestion'), '3')

		WebUI.sendKeys(findTestObject('Add Attendee/Group/HowmanyChaperonesQuestion'), '3')


		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/Group/YesOptionInAccessibilityNeedInGroup'), 0, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
		}

		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

			WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
		}

//		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

		WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), 'Name')

		WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), 'test@email.com')

		WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

		WebUI.click(findTestObject('Add Attendee/Group/NoOptionInYourGroupBeEatingLunchQuestion'))

		WebUI.sendKeys(findTestObject('Add Attendee/Group/OrganizationNameQuestionInGropupRegistration'), 'Test Org')

		WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

		WebUI.delay(4)

		WebUI.click(findTestObject('Add Attendee/CloseButtonInAddAttendee'))

		WebUI.switchToDefaultContent()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

		WebUI.refresh()

		if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 0, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
		}

		WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

		WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

		WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))

		driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

		WebUI.click(findTestObject('Object Repository/HomePageElements/RequesuFilterRadioButton'))

		WebUI.delay(3)

		driver.findElement(By.xpath(('//div[@class=\'shadow __visit__visit-card__7422f pointer-on-hover ember-view\']//h4[text()=\'' +
				VisitTypeName) + '\']')).click()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/PendingTabInRequestVisit'), 0)

		String GroupStudentNameForOffCampus = 'Test Name'

		driver.findElement(By.xpath(('//div[contains(text(),\'' + GroupStudentNameForOffCampus) + '\')]')).isDisplayed()
	}

	@Keyword
	def IndividualRegistration() {
	}
}
