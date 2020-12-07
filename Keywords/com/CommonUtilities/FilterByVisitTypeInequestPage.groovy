package com.CommonUtilities
import com.CommonUtilities.Verifications
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
import org.junit.After
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


class FilterByVisitTypeInequestPage {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def FilterByVisitTypeTestInRequestsPage() {
		Verifications Verify = new Verifications()

		if (WebUI.verifyElementPresent(findTestObject('Add Attendee/FirstRequestInQueue'), 0, FailureHandling.OPTIONAL)) {
			String VisitType = WebUI.getText(findTestObject('Object Repository/Requests/FirstRequestVisitTypeInRequestsPage'))

			Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Requests/VisitTypeFilterDropDown'), "Visit type filter drop-down is not present in Requests page")
			//			CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Requests/VisitTypeFilterDropDown'),
			//					"Visit type filter drop-down is not present in Requests page")

			WebUI.click(findTestObject('Requests/VisitTypeFilterDropDown'))

			def VisittypeInFilterDropDown = new TestObject("VisitType in visit type dropdown in requesets page")

			VisittypeInFilterDropDown.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+VisitType+"']")

			Verify.VerifyElementPresentAndStopExecutionIfFailed(VisittypeInFilterDropDown, "The visit type shown in the requests list is not shown in the visit type filter")

			//			CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(VisittypeInFilterDropDown,
			//					"The visit type shown in the requests list is not shown in the visit type filter")
			WebUI.click(VisittypeInFilterDropDown)

			//			CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Requests/FirstRequestVisitTypeInRequestsPage'),
			//					"After applying visit type filter in requests page the corresponding requests are not shown")

			Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/Requests/FirstRequestVisitTypeInRequestsPage'), "After applying visit type filter in requests page the corresponding requests are not shown")

			int CountOfRequestsAfterFiltering = driver.findElements(By.xpath("//div[@class='request-queue padding-bottom-12 space-between row']")).size()

			def VisitTypeAfterFiltering = new TestObject("Visit Type on request after filtering")

			for(int i=1;i<=CountOfRequestsAfterFiltering;i++)
			{
				VisitTypeAfterFiltering.addProperty("xpath", ConditionType.EQUALS, "((//div[@class='request-queue padding-bottom-12 space-between row'])["+i+"]//div[@class='visit-name']//p)[1]")
				if(!(WebUI.verifyElementText(VisitTypeAfterFiltering, VisitType, FailureHandling.OPTIONAL)))
				{
					WebUI.takeScreenshot()
					KeywordUtil.markFailedAndStop("After filtering by visit type in requests page the seatch results shown the visit types that are not filtered")
				}
			}

		}
		else
		{
			KeywordUtil.markWarning("There are no requests present in Requests view to verify the filter functionality")
		}
	}
}