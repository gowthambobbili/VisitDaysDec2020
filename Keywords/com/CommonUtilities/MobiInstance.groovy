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
import groovy.json.JsonSlurper as JsonSlurper

class MobiInstance {
	/**
	 * Mobi instance reusable methods
	 */
	Verifications verifications = new Verifications()
	Random random = new Random()
	LoginAsDifferentUserPermissions login = new LoginAsDifferentUserPermissions()
	ApiCalls api = new ApiCalls()
	JsonSlurper js = new JsonSlurper()
	HtmlTable htmlTable = new HtmlTable()

	@Keyword
	def getRandomInstanceName() {

		return "Test instance"+random.nextInt(100000)
	}


	@Keyword
	def verifyValidationErrors() {

		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/DisplayNameError'), "When click Save without entering data in display name field the validation error message is not shown")
		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/DisplayNameError'), "When click Save without checking the Audience checkbox the validation error message is not shown")
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SelectDropdownInFilterByVisitCategorySection'))
		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/VisitCategoryError'), "When click Save without checking the Visit category checkbox the validation error message is not shown")
	}

	@Keyword
	def enterDisplayName(def mobiInstanceName = "Test instance"+random.nextInt(100000)) {

		//		def mobiInstanceName = "Test instance"+random.nextInt(100000)
		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/DisplayNameTextField'), "Display Name is not present in create instace page")
		WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Script/DisplayNameTextField'), mobiInstanceName)
		return mobiInstanceName
	}

	@Keyword
	def selectAudience(String audience="both") {

		if(audience=="both") {
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/IndividualsCheckbox'))
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/GroupsCheckBox'))
		}
		else if(audience=="ind") {
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/IndividualsCheckbox'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/GroupsCheckBox'))
		}
	}

	@Keyword
	def selectvisitCategory(String audience="all") {

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/MobiPage/Script/SelectDropdownInFilterByVisitCategorySection'), 3, FailureHandling.OPTIONAL))
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/SelectDropdownInFilterByVisitCategorySection'))
		if(audience=="all") {
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'))
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'))
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'))
		}
		if(audience=="daily") {
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'))
		}
		if(audience=="event") {
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'))
		}
		if(audience=="off") {
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'))
		}
	}


	@Keyword
	def selectSpecificVisit(String visitType) {

		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SpecificVisitTypeFilterSelectDropdown'))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SelectVisitTypeDrown'))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SpecificVisitTypeInDropdown(visitType)', ["visitType": visitType]))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/VisitDateDropdown'))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/FirstActiveDayInCalendar'))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SelectTimeDropdown'))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/FirstVisitTime'))
	}


	@Keyword
	def clickPreviewButton(String instanceName) {

		WebUI.click(findTestObject('Object Repository/MobiPage/Script/PreviewButton(instanceName)', ["instanceName":instanceName]))
	}


	@Keyword
	def enableVisitTypeCategory(String audience="all") {

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/MobiPage/Script/SelectDropdownInFilterByVisitCategorySection'), 3, FailureHandling.OPTIONAL))
			WebUI.click(findTestObject('Object Repository/MobiPage/Script/SelectDropdownInFilterByVisitCategorySection'))
		if(audience=="all") {
			if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'), 1, FailureHandling.OPTIONAL))) {
				WebUI.click(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'))
			}

			if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'), 1, FailureHandling.OPTIONAL))) {
				WebUI.click(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'))
			}
			if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'), 1, FailureHandling.OPTIONAL))) {
				WebUI.click(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'))
			}
		}
		if(audience=="daily") {
			if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'), 1, FailureHandling.OPTIONAL))) {
				WebUI.click(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'))
			}
		}
		if(audience=="event") {
			if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'), 1, FailureHandling.OPTIONAL))) {
				WebUI.click(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'))
			}
		}
		if(audience=="off") {
			if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'), 1, FailureHandling.OPTIONAL))) {
				WebUI.click(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'))
			}
		}
	}


	@Keyword
	def clickSaveButton() {

		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "Save button is not present in the Create mobi instance page")
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SaveButton'))
	}

	@Keyword
	def goToMobiScriptPage() {

		login.NavigateToHomePage()
		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/HomePageElements/MobiLeftNav'), "In the homepage the Mobi left nav element is not present")
		WebUI.click(findTestObject('Object Repository/HomePageElements/MobiLeftNav'))
		verifications.VerifyElementVisible(findTestObject('Object Repository/HomePageElements/Mobi/Mobi-ScriptLeftNav'), "When click Mobi left nav, the Script nav item is not shown")
		WebUI.click(findTestObject('Object Repository/HomePageElements/Mobi/Mobi-ScriptLeftNav'))
		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/CreateButton'), "When click Script left nav, the Create button is not shown")
	}


	@Keyword
	def clickCreateButton() {

		WebUI.click(findTestObject('Object Repository/MobiPage/Script/CreateButton'))
		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "Save button is not present in the Create mobi instance page")
	}

	@Keyword
	def verifySuccessMessage() {
		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Script/SuccessMessage'), "after entering data in all fields, When click Save button the success message is not shown")
	}

	@Keyword
	def verifyTheCreatedInstance(String instanceName, String expectedFilters) {

		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/Instance(instance)', ["instance":instanceName]), "The created instance is not shown in the list")
		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Script/InstanceId(instance)', ["instance":instanceName]), "For the created instance id is not generated")
		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Script/PreviewButtonOfInstance(instance)', ["instance":instanceName]), "For the created instance, Preview button is not shown")
		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Script/ThreeDotMenuOfInstance(instance)', ["instance":instanceName]), "For the created instance, three dot menu is not shown")

		def filtersIndex = htmlTable.getColumnIndex(["Floating", "Custom", "Name", "Filters"], "Filters")

		def filters = WebUI.getText(findTestObject('Object Repository/MobiPage/Script/FiltersInInstancesList(instance, index)', ["instance":instanceName, "index":filtersIndex])).trim()
		verifications.VerifyTextMatch(filters, expectedFilters, "For the newly creted Mobi instance, the Filters are shown incorrect")
	}

	@Keyword
	def createInstanceUsingApi() {
		/**
		 * Creates Mobi instance using API
		 * @param audience type of audience eg: '"individuals","groups"'
		 * @param visit category eg: '"daily","event","travel"'
		 */

		def mobiInstanceName = "Test instance"+random.nextInt(100000)
		def token = api.GetAccessToken()

		def resObject = WS.sendRequest(findTestObject('Object Repository/API Requests/Mobi Instances/CreateInstance', ["token":token, "instanceName":mobiInstanceName, "visitCategories":'"daily","event","travel"', "audience":'"individuals", "groups"']))
		def responseBody = resObject.responseBodyContent
		def instanceData = js.parseText(responseBody)
		println instanceData
		def id = instanceData.data.id
		return ["id":id, "instanceName":mobiInstanceName]
	}

	@Keyword
	def clickThreeDotMenu(String instanceName, String instanceId) {

		verifications.VerifyElementPresent(findTestObject('Object Repository/MobiPage/Script/ThreeDotMenuOfInstance(instance)', ["instance":instanceName]), "Three dot menu is not present for the instance "+instanceName)
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/ThreeDotMenuOfInstance(instance)', ["instance":instanceName]))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/EditButton(id,institution)', ["id":instanceId, "institution":GlobalVariable.Institution]))
	}
}




