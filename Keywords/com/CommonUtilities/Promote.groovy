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


class Promote {

	Random Rvar = new Random()
	Verifications Verifications = new Verifications()
	@Keyword
	def CreateCampaignWithGivenVisitTypes(String SourceChannel, String... VisitTypes) {

		String CampaignName = 'Campaign' + Rvar.nextInt(10000)
		//VisitTypes.each { println "Adding column ${it}"}
		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('HomePageElements/PromoteIcon'),
				'Promote left nav is not present in homepage')

		WebUI.click(findTestObject('HomePageElements/PromoteIcon'))

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/PromotePage/CreateCampaignButton'),
				'Create Campaign button is not present in promote page')

		WebUI.click(findTestObject('PromotePage/CreateCampaignButton'))

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('PromotePage/CampaignNameInputField'),
				'Campaign Name input field is not present in Create Campain page')

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('PromotePage/EstimatedCostInputField'),
				'Estimated Cost input field is not present in Create Campain page')

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('PromotePage/sourceChannelDropdown'),
				'Source channel dropdown is not present in Create Campain page')

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('PromotePage/TrackingIdInputField'),
				'Tracking id input field is not present in Create Campain page')

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('PromotePage/AllVisitTypeButton'),
				'All Visit Types button is not present in Create Campaign page')

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('PromotePage/SelectVisitTypeButton'),
				'Select Visit Types button is not present in Create Campain page')

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('PromotePage/SpecificVisitTypeButton'),
				'Specific Visit Type button is not present in Create Campain page')

		WebUI.sendKeys(findTestObject('PromotePage/CampaignNameInputField'), CampaignName)

		WebUI.sendKeys(findTestObject('PromotePage/EstimatedCostInputField'), '1000')

		WebUI.scrollToElement(findTestObject('PromotePage/sourceChannelDropdown'), 0)

		WebUI.click(findTestObject('PromotePage/sourceChannelDropdown'))

		def ChannelTypeInDropdown = new TestObject('Channel type in channele type dropdown')

		ChannelTypeInDropdown.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + SourceChannel) + '\']')

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(ChannelTypeInDropdown, ('The chanenl ' +
				SourceChannel) + ' is not present in source channel dropdown')

		WebUI.scrollToElement(ChannelTypeInDropdown, 0)

		WebUI.click(ChannelTypeInDropdown)

		WebUI.scrollToElement(findTestObject('PromotePage/SelectVisitTypeButton'), 0)

		WebUI.click(findTestObject('PromotePage/SelectVisitTypeButton'), FailureHandling.STOP_ON_FAILURE)

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/PromotePage/SelectAVisitTypeDropdown'),
				'When clicked the Select Visit Type button then Select a visit type dropdown is not shown')

		def VisitTypeInselectAVisitTypeDropdown = new TestObject("visit type in select a visit type dropdown")

		def SelectedVisitTypeInRegistrationDivision = new TestObject("Selected visit type in registration division")

		VisitTypes.each
		{
			println ("${it}")
			VisitTypeInselectAVisitTypeDropdown.addProperty("xpath", ConditionType.EQUALS, "//li[text()='${it}']")
			WebUI.click(findTestObject('PromotePage/SelectAVisitTypeDropdown'))
			WebUI.click(VisitTypeInselectAVisitTypeDropdown)
			SelectedVisitTypeInRegistrationDivision.addProperty("xpath", ConditionType.EQUALS,"//button[text()='${it}']")
			Verifications.VerifyElementPresentAndStopExecutionIfFailed(SelectedVisitTypeInRegistrationDivision,
					"When selects a visit type in select a visit type dropdown, it is not shown in the registration division visit type selected is (Visit type selected - ${it})")
		}
		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/PromotePage/NextButton'), "Next button is not present in the create campaign page")

		WebUI.click(findTestObject('Object Repository/PromotePage/NextButton'))

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/PromotePage/ActivateNowButton'), "Activate Now button is not present in Summary page")

		WebUI.click(findTestObject('Object Repository/PromotePage/ActivateNowButton'))

		Verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/PromotePage/Yes,ActivateNowButtonInActivateModal'), "Activate modal is not shown when clicked Activate Now button")

		WebUI.waitForElementVisible(findTestObject('Object Repository/PromotePage/Yes,ActivateNowButtonInActivateModal'), 0)

		WebUI.click(findTestObject('Object Repository/PromotePage/Yes,ActivateNowButtonInActivateModal'))

		Verifications.VerifyElementNotPresentStopExecutionIfFailed(findTestObject('Object Repository/PromotePage/Yes,ActivateNowButtonInActivateModal'), "When click the Yes, Active now button in Activate modal the modal is not getting closed")

		def PublishedCampaignInPromotePage = new TestObject("Published campaign in promoto page")
		PublishedCampaignInPromotePage.addProperty("xpath", ConditionType.EQUALS, "//div[text()='"+CampaignName+"']")
		Verifications.VerifyElementPresentAndStopExecutionIfFailed(PublishedCampaignInPromotePage, "The published campaign "+ CampaignName+" is not present in promote page")
		return CampaignName
	}
}