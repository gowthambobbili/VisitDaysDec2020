import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

WebUI.click(findTestObject('SettingsPage/AccountBasicsNav'))

WebUI.click(findTestObject('SettingsPage/Account Basics/EditButtonInEmailSettingsDivision'))

WebUI.delay(2)

int inputscount = driver.findElements(By.xpath('//div[text()=\'Email Settings\']/../../..//input')).size()

String NumberOFDomainsBeforeDelete = driver.findElements(By.xpath('//div[text()=\'Email Settings\']/../../..//input')).size().toString()

Random RandVar = new Random()

String ActualDomainName = ('testdomain' + RandVar.nextInt(2000)) + '.com'

WebUI.click(findTestObject('SettingsPage/Account Basics/AddMoreButtonInEmailsSettingsDivisionInAccountBasics'))

WebUI.delay(2)

driver.findElement(By.xpath(('(//div[text()=\'Email Settings\']/../../..//input)[' + inputscount) + ']')).sendKeys(ActualDomainName)

WebUI.click(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'))

WebUI.verifyElementNotPresent(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'), 0)

WebUI.click(findTestObject('SettingsPage/Account Basics/EditButtonInEmailSettingsDivision'))

driver.findElement(By.xpath(('(//button[text()=\'Remove\'])[' + inputscount) + ']')).click()

WebUI.click(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'))

WebUI.click(findTestObject('SettingsPage/Account Basics/EditButtonInEmailSettingsDivision'))
//int NumberOFDomainsAfterDelete = driver.findElements(By.xpath('//div[text()=\'Email Settings\']/../../..//input')).size().toString()
WebUI.delay(2)

String NumberOFDomainsAfterDelete = driver.findElements(By.xpath('//div[text()=\'Email Settings\']/../../..//input')).size().toString()

WebUI.verifyMatch(NumberOFDomainsBeforeDelete, NumberOFDomainsAfterDelete, false)

