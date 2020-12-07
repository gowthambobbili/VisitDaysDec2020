import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.FilterByVisitTypeInequestPage.FilterByVisitTypeTestInRequestsPage'()

WebUI.click(findTestObject('Requests/VisitTypeFilterDropDown'))

WebUI.click(findTestObject('Requests/AllOptionInVisitTypeFilterDropdown'))

WebUI.click(findTestObject('Requests/ScheduledRadioButton'))

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.FilterByVisitTypeInequestPage.FilterByVisitTypeTestInRequestsPage'()

not_run: WebUI.click(findTestObject('Requests/VisitTypeFilterDropDown'))

not_run: WebUI.click(findTestObject('Requests/AllOptionInVisitTypeFilterDropdown'))

not_run: WebUI.click(findTestObject('Requests/ExpiredRadioButton'))

not_run: WebUI.delay(2)

not_run: CustomKeywords.'com.CommonUtilities.FilterByVisitTypeInequestPage.FilterByVisitTypeTestInRequestsPage'()

