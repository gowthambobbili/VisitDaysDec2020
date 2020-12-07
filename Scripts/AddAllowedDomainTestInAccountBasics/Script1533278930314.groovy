import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.junit.After as After
import org.openqa.selenium.By as By
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))
//
WebUI.click(findTestObject('Object Repository/SettingsPage/Settings'))

WebUI.click(findTestObject('SettingsPage/AccountBasicsNav'))
//
WebUI.waitForElementPresent(findTestObject('SettingsPage/Account Basics/EditButtonInEmailSettingsDivision'), 0)
//
WebUI.click(findTestObject('SettingsPage/Account Basics/EditButtonInEmailSettingsDivision'))
//
WebDriver driver = DriverFactory.getWebDriver()
//
int NumberOfExistingDomains = driver.findElements(By.xpath('//input[@class="form-control"]')).size()
//
WebUI.click(findTestObject('SettingsPage/Account Basics/AddMoreButtonInEmailsSettingsDivisionInAccountBasics'))
//
Random domVariable = new Random()
//
int RandomNumberForDomain = domVariable.nextInt(100)
//
String TestDomain = ('testDomain' + RandomNumberForDomain) + '.com'
//
driver.findElement(By.xpath(('(//input[@class="form-control"])[' + NumberOfExistingDomains) + ']')).sendKeys(TestDomain)
//
int AutomatedRedirectEmailField = NumberOfExistingDomains + 1
//
String AutomatedRedirectEmail = ('testemail' + RandomNumberForDomain) + '@qualitlabs.com'
//
driver.findElement(By.xpath(('(//input[@class="form-control"])[' + AutomatedRedirectEmailField) + ']')).clear()
//
driver.findElement(By.xpath(('(//input[@class="form-control"])[' + AutomatedRedirectEmailField) + ']')).sendKeys(AutomatedRedirectEmail)
//
WebUI.click(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'))
//
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'), "In Account basics, after edit the Allowed domains and click Save button the button is not getting disappeared and the modifications are not getting saved")
//
driver.findElement(By.xpath(('//p[contains(text(),' + TestDomain) + ')]')).isDisplayed()
//
println(AutomatedRedirectEmail)
//
WebUI.verifyElementText(findTestObject('SettingsPage/Account Basics/AutomatedRedirectEmailInAccountBasics'), AutomatedRedirectEmail)
//
