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


class PageNavigations {
	/**
	 * Navigation flows
	 */

	@Keyword
	def NavigateToVisitTypes() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/visit-types")
		WebUI.waitForElementPresent(findTestObject('Object Repository/VisitTypesPage/SearchVisitTypesTextBox'), 0)
	}

	@Keyword
	def NavigateToDailyVisits() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/visits/daily")
		WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/CreateDailyVisitButton'), 0)
	}

	@Keyword
	def NavigateToEvents() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/visits/events")
		WebUI.waitForElementPresent(findTestObject('Object Repository/EventsPage/CreateEventButton'), 0)
	}

	@Keyword
	def NavigateToOffCampus() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/visits/off-campus")
		WebUI.waitForElementPresent(findTestObject('Object Repository/OffCampusPage/CreateOffCampusButton'), 0)
	}

	@Keyword
	def NavigateToRequests() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/requests")
		WebUI.waitForElementPresent(findTestObject('Object Repository/Requests/VisitTypeFilterDropDown'), 0)
	}

	@Keyword
	def NavigateToAnalytics() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/visits/analytics")
		WebUI.waitForElementPresent(findTestObject('Object Repository/AnalyticsPage/ExportDataButtonInReports'), 0)
	}

	@Keyword
	def NavigateToQuestions() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/mobi/questions")
		WebUI.waitForElementPresent(findTestObject('Object Repository/VisitTypesPage/QuestionsOption'), 0)
	}

	@Keyword
	def NavigateToLocations() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/settings/locations")
		WebUI.waitForElementPresent(findTestObject('Object Repository/SettingsPage/SearchLocationsSearachBoxInLocations'), 0)
	}

	@Keyword
	def NavigateToMobi() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/mobi/settings")
		WebUI.waitForElementPresent(findTestObject('Object Repository/MobiPage/GeneratePreviewButtonInMobi'), 0)
	}

	@Keyword
	def NavigateToUsers() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/my-team/staffs")
		WebUI.waitForElementPresent(findTestObject('Object Repository/TeamManagement/SearchUsersSearchBoxInUsersDeactivatedTab'), 0)
	}

	@Keyword
	def NavigateApplicantsAndYieldPage() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/my-team/staffs")
		WebUI.waitForElementPresent(findTestObject('Object Repository/TeamManagement/SearchUsersSearchBoxInUsersDeactivatedTab'), 0)
	}

	@Keyword
	def NavigateToSurveySummaryPage() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/survey")
		//WebUI.waitForElementPresent(findTestObject('Object Repository/TeamManagement/SearchUsersSearchBoxInUsersDeactivatedTab'), 0)
	}

	@Keyword
	def NavigateToSurveyPerformPage() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/survey/performance")
		//WebUI.waitForElementPresent(findTestObject('Object Repository/TeamManagement/SearchUsersSearchBoxInUsersDeactivatedTab'), 0)
	}

	@Keyword
	def NavigateToAccountBasics() {
		WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/settings/institution")
		WebUI.waitForElementPresent(findTestObject('Object Repository/SettingsPage/Account Basics/EditButtonInInstitutionLogo'), 0)
	}
}














