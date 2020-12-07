import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))
//
WebUI.click(findTestObject('Object Repository/SettingsPage/Settings'))

WebUI.click(findTestObject('SettingsPage/AccountBasicsNav'))

WebUI.waitForElementPresent(findTestObject('SettingsPage/Account Basics/EditButtonInMainContactInformationDivision'), 0)
//
WebUI.click(findTestObject('SettingsPage/Account Basics/EditButtonInMainContactInformationDivision'))
//
WebDriver driver = DriverFactory.getWebDriver()
//
Random ContactInfoRandomVariable = new Random()
//
String MainContactEmail = ('Testemail' + ContactInfoRandomVariable.nextInt(100)) + '@gmail.com'
//
String MainContactNumber = '9876543210'
//
WebUI.clearText(findTestObject('SettingsPage/Account Basics/MainContactPhoneNumberTextBoxInAccountBasics'))
//
WebUI.sendKeys(findTestObject('SettingsPage/Account Basics/MainContactPhoneNumberTextBoxInAccountBasics'), MainContactNumber)
//
WebUI.clearText(findTestObject('SettingsPage/Account Basics/MainContactEmailTextBoxInAccountBasics'))
//
WebUI.sendKeys(findTestObject('SettingsPage/Account Basics/MainContactEmailTextBoxInAccountBasics'), MainContactEmail)
//
WebUI.click(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'))
//
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'), "In Account basics, after editing the main contact information and click Save button the button is not getting disappeared and the modifications are not getting saved")
//
WebUI.verifyElementText(findTestObject('SettingsPage/Account Basics/MainContactEmailInAccountBasics'), MainContactEmail)
//
WebUI.verifyElementText(findTestObject('SettingsPage/Account Basics/MainContactPhoneInAccountBasics'), MainContactNumber)
//
