package com.EmptyStateVerificationInTeamManagement
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

class EmptyStateVerificaiton {
	Verifications Verify = new Verifications()
	@Keyword
	def VerifyEmptyStateInActiveAndDeactiveTabsWhenNousersPresent() {
		WebDriver driver = DriverFactory.getWebDriver()

		String Active = driver.findElement(By.xpath("//span[contains(text(),'Active')]")).getText()

		String numberoflistelementsInActiveList = Active.split(' ')[1]

		if(numberoflistelementsInActiveList=='(0)') {
			Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/TeamManagement/Users/EmptyStateMessageInUsers'), "When there are no users in Active tab if Users page, the empty state message is not shown")
			WebUI.verifyElementText(findTestObject('TeamManagement/Users/EmptyStateMessageInUsers'), 'No deactivated users yet.')
		}
		else
			KeywordUtil.markPassed("Unable to verify the empty state as there are users present in Active tab")

		WebUI.click(findTestObject('TeamManagement/DeactivatedTabInUsers'))

		String Deactivated = driver.findElement(By.xpath("//span[contains(text(),'Deactivated')]")).getText()

		String numberoflistelementsInDeactivatedList = Deactivated.split(' ')[1]

		if(numberoflistelementsInDeactivatedList=='(0)') {
			Verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/TeamManagement/Users/EmptyStateMessageInUsers'), "When there are no users present in In active tab of users page, the empty state message is not shown")
			WebUI.verifyElementText(findTestObject('TeamManagement/Users/EmptyStateMessageInUsers'), 'No deactivated users yet.')
		}
		else
			KeywordUtil.markPassed("Unable to verify the empty state as there are users present in the In active tab")
	}
}