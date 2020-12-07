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


class AddVisitToItineraryLabelInUserProfile {

	Verifications ver = new Verifications()

	@Keyword
	def VerifyAddVisitToItineraryLabelInIndividualProfile() {

		WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown ')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The registered Individual student profile three dot menu')

			WebUI.takeScreenshot()
		}

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/CheckInButtonInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('Check in button is not shown in individual student profile')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/CheckInButtonInUserProfile'))

		WebUI.verifyElementNotPresent(findTestObject('UserProfile/CheckInButtonInUserProfile'), 0)

		WebUI.waitForElementPresent(findTestObject('UserProfile/StatusFieldInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown after changing the status to "Check in"')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The "Checked In" Individual student profile\'s three dot menu')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After check in the individual the "Change Status" link is not shown in user profile')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'))

		WebUI.waitForElementVisible(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

		WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

		//===========
		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown after changing the status to "Not Here"')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementNotPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is shown in The Individual student profile\'s three dot menu, whose status is "Not Here"')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		WebUI.click(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'))

		WebUI.waitForElementVisible(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

		WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After check in the individual, click "Change Status" link and change the status to "Not Here" and then again change the status to Check In then the "Three dot menu" is not shown in user profile')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After changing the "Not Here" status of indiviudal to "Check in" using Change Status link then the "Add Visit To Itinerary" Option is not shown ')

			WebUI.takeScreenshot()
		}

	}


	@Keyword
	def VerifyAddVisitToItineraryLabelInIndividualRegistrantThreeDotMenu(String Student) {

		def ThreeDotMenuOfIndividual = new TestObject('Three dot menu in Individual registrant')

		ThreeDotMenuOfIndividual.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Student) + '\']/../..//i[text()=\'more_vert\']')

		if (!(WebUI.verifyElementPresent(ThreeDotMenuOfIndividual, 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed('In Registered tab the three dot menu label is not shown')
		}

		WebUI.waitForElementPresent(ThreeDotMenuOfIndividual, 0)

		ver.VerifyElementPresentAndStopExecutionIfFailed(ThreeDotMenuOfIndividual, "Three dot menu is not present for individual in registered  tab")

		WebUI.click(ThreeDotMenuOfIndividual)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The registered Individual student three dot menu in Registered tab')
		}


		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CheckInButton'), 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed('Check in button is not shown in individual student Three dot menu in registered tab')
		}

		WebUI.click(findTestObject('DailyVisitsPage/CheckInButton'))

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/CheckInButton'), 0)

		ver.VerifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/CheckInProgressBar'), "After clicking check in button the check in bar is not shown")

		WebUI.delay(2)
		//WebUI.waitForElementPresent(findTestObject('UserProfile/StatusFieldInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(ThreeDotMenuOfIndividual, 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown after changing the status to "Check in"')
		}

		WebUI.waitForElementPresent(ThreeDotMenuOfIndividual, 0)

		//ver.VerifyElementPresentAndStopExecutionIfFailed(ThreeDotMenuOfIndividual, "After clicking check in button the three dot menu is not shown for the student in registered tab")

		WebUI.click(ThreeDotMenuOfIndividual)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The "Checked In" Individual student three dot menu')

			WebUI.takeScreenshot()
		}

		WebUI.waitForElementPresent(ThreeDotMenuOfIndividual, 0)

		WebUI.click(ThreeDotMenuOfIndividual)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'), 0, FailureHandling.OPTIONAL))) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailed('After check in the individual the "Change Status" link is not shown in Registered tab')
		}

		WebUI.delay(3)

		WebUI.click(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'))

		ver.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), "When clicked on Change status link Yes, Change button is not shown")

		WebUI.waitForElementVisible(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

		WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

		//===========

		ver.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/DailyVisitsPage/CheckInProgressBar'), "When changed the status from check in to Not Here the check in progress bar is not getting disappeared")

		WebUI.delay(2)

		//WebUI.waitForElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(ThreeDotMenuOfIndividual, 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown after changing the status to "Not Here"')
			WebUI.takeScreenshot()
		}

		WebUI.waitForElementPresent(ThreeDotMenuOfIndividual, 0)

		WebUI.click(ThreeDotMenuOfIndividual)

		if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is shown in The Individual student profile\'s three dot menu, whose status is "Not Here"')
			WebUI.takeScreenshot()
		}

		WebUI.waitForElementPresent(ThreeDotMenuOfIndividual, 0)

		WebUI.click(ThreeDotMenuOfIndividual)

		WebUI.click(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'))

		WebUI.waitForElementVisible(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

		WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

		ver.VerifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/CheckInProgressBar'), "After changing the status from Not Here to check in, the check in bar is not shown")

		WebUI.delay(2)

		//WebUI.waitForElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(ThreeDotMenuOfIndividual, 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After check in the individual, click "Change Status" link and change the status to "Not Here" and then again change the status to Check In then the "Three dot menu" is not shown in user profile')

			WebUI.takeScreenshot()
		}

		WebUI.waitForElementPresent(ThreeDotMenuOfIndividual, 0)

		WebUI.waitForElementClickable(ThreeDotMenuOfIndividual, 0)

		WebUI.click(ThreeDotMenuOfIndividual)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After changing the "Not Here" status of indiviudal to "Check in" using Change Status link then the "Add Visit To Itinerary" Option is not shown ')

			WebUI.takeScreenshot()
		}


		WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'))

		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

		WebUI.click(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'),
				0)

		WebUI.click(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementClickable(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

		WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementNotPresent(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTab'), 0)

		WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/CanceledTab'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementPresent(ThreeDotMenuOfIndividual, 0)

		WebUI.click(ThreeDotMenuOfIndividual)

		if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add itinerary To VIsit" Option is shown in the three dot menu of Cacneled Individual')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('DailyVisitsPage/RegisteredTab'))

	}


	@Keyword
	def VerifyAddVisitToItineraryLabelInGroupProfile()
	{
		WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown ')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The registered Group leader\'s profile three dot menu')

			WebUI.takeScreenshot()
		}

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/CheckInAllButtonInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('Check in button is not shown in Group leader\'s profile')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/CheckInAllButtonInUserProfile'))

		WebUI.verifyElementNotPresent(findTestObject('UserProfile/CheckInAllButtonInUserProfile'), 0)

		WebUI.waitForElementPresent(findTestObject('UserProfile/StatusFieldInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown after changing the status to "Check in"')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The "Checked In" Group leader profile\'s three dot menu')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After checked in the Group leader the "Change Status" link is not shown in user profile')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'))

		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

		WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

		//===========
		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown after changing the status to "Not Here"')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementNotPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is shown in The Group leader profile\'s three dot menu, whose status is "Not Here"')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		WebUI.click(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'))

		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

		WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After check in the Group leader, click "Change Status" link and change the status to "Not Here" and then again change the status to Check In then the "Three dot menu" is not shown in user profile')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

		if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/AddVisitToItineraryLabelInUserProfile'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After changing the "Not Here" status of indiviudal to "Check in" using Change Status link then the "Add Visit To Itinerary" Option is not shown ')

			WebUI.takeScreenshot()
		}

	}

	@Keyword
	def VerifyAddVisitToItineraryLabelInGroupRegistrantThreeDotMenu(String Group) {

		def ThreeDotMenuOfGroup = new TestObject('Three dot menu in Group registrant')

		ThreeDotMenuOfGroup.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Group) + '\']/../..//i[text()=\'more_vert\']')

		if (!(WebUI.verifyElementPresent(ThreeDotMenuOfGroup, 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In Registered tab the three dot menu label is not shown')

			WebUI.takeScreenshot()
		}

		WebUI.click(ThreeDotMenuOfGroup)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The registered Group three dot menu in Registered tab')

			WebUI.takeScreenshot()
		}

		WebUI.click(ThreeDotMenuOfGroup)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/CheckinAllButtonInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('Check in all button is not shown in Group Three dot menu in registered tab')

			WebUI.takeScreenshot()
		}

		WebUI.click(findTestObject('DailyVisitsPage/Registered/CheckinAllButtonInRegisteredTab'))

		WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/CheckinAllButtonInRegisteredTab'), 0)

		ver.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/DailyVisitsPage/CheckInProgressBar'), "After clicking check in button, the check in bar is not shown")

		WebUI.delay(2)

		//WebUI.waitForElementPresent(findTestObject('UserProfile/StatusFieldInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(ThreeDotMenuOfGroup, 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown after changing the status to "Check in"')

			WebUI.takeScreenshot()
		}

		WebUI.click(ThreeDotMenuOfGroup)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The "Checked In" Group  three dot menu')

			WebUI.takeScreenshot()
		}

		WebUI.click(ThreeDotMenuOfGroup)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After check in the Group the "Change Status" link is not shown in Registered tab')

			WebUI.takeScreenshot()
		}

		WebUI.delay(2)

		WebUI.click(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'))

		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

		WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

		ver.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/DailyVisitsPage/CheckInProgressBar'), "When canged the status from Check in to Not Here, the check in progress bar is not getting disappeared")

		WebUI.delay(2)

		//WebUI.waitForElementPresent(findTestObject('UserProfile/DetailsTabInUserProfile'), 0)

		if (!(WebUI.verifyElementPresent(ThreeDotMenuOfGroup, 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('In user profile the three dot menu label is not shown after changing the status to "Not Here"')

			WebUI.takeScreenshot()
		}

		WebUI.click(ThreeDotMenuOfGroup)

		if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add Visit To Itinerary" option is shown in The Group profile\'s three dot menu, whose status is "Not Here"')

			WebUI.takeScreenshot()
		}

		WebUI.click(ThreeDotMenuOfGroup)

		WebUI.delay(3)

		WebUI.click(findTestObject('DailyVisitsPage/Registered/ChangeStatusLink'))

		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

		ver.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), "When clicked the Chage status link, Yes, Change buutton is not shown")

		WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

		WebUI.delay(2)

		ver.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/DailyVisitsPage/CheckInProgressBar'), "When changed the status of group from Not Here to Check in, the check in progress bar is not shown")

		WebUI.delay(2)

		if (!(WebUI.verifyElementPresent(ThreeDotMenuOfGroup, 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After check in the Group, click "Change Status" link and change the status to "Not Here" and then again change the status to Check In then the "Three dot menu" is not shown in user profile')

			WebUI.takeScreenshot()
		}

		WebUI.click(ThreeDotMenuOfGroup)

		if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('After changing the "Not Here" status of Group to "Check in" using Change Status link then the "Add Visit To Itinerary" Option is not shown ')

			WebUI.takeScreenshot()
		}

		WebUI.delay(2)

		WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'))

		WebUI.waitForElementClickable(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

		WebUI.click(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementClickable(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'),
				0)

		WebUI.click(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementClickable(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

		WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

		WebUI.waitForElementNotPresent(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

		WebUI.refresh()

		WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTab'), 0)

		WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/CanceledTab'), 0)

		WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(ThreeDotMenuOfGroup)

		if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed('"Add itinerary To VIsit" Option is shown in the three dot menu of Cacneled Individual')

			WebUI.takeScreenshot()
		}


	}


}