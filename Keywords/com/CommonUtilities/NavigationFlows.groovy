package com.CommonUtilities
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



class NavigationFlows {

	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword
	def NavigateToRequestQueue() {

		WebUI.click(findTestObject('Object Repository/HomePageElements/SchoolProdoutNav'))

		WebUI.delay(5)
		
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/RequestsOption'),0)
		
		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
//		WebUI.click(findTestObject('HomePageElements/RequestsOption'))
		//
		//		WebUI.delay(2)
		//
		//		WebUI.waitForElementClickable(findTestObject('Add Attendee/ViewAllRequestsOption'), 0, FailureHandling.CONTINUE_ON_FAILURE)
		//
		//		WebUI.delay(2)
		//
		//		WebUI.click(findTestObject('Add Attendee/ViewAllRequestsOption'))

		WebUI.waitForElementPresent(findTestObject('Add Attendee/VisitRequestQueueHeaderInRequests'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueueOrEmptyStateInRequests'), 0)

		WebUI.delay(2)
	}
}