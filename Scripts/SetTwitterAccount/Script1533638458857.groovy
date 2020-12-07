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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By


CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()
WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))
WebUI.click(findTestObject('SettingsPage/AccountBasicsNav'))
WebUI.scrollToElement(findTestObject('SettingsPage/Account Basics/EditButtonInSocialMediaDivision'), 0)
WebUI.click(findTestObject('SettingsPage/Account Basics/EditButtonInSocialMediaDivision'))
WebUI.click(findTestObject('SettingsPage/Account Basics/TwitterTextboxInSocialMediaAccounts'))
WebUI.clearText(findTestObject('SettingsPage/Account Basics/TwitterTextboxInSocialMediaAccounts'))
Random var = new Random()
rand = var.nextInt(100)
String Twitter = 'Test' + rand
WebUI.sendKeys(findTestObject('SettingsPage/Account Basics/TwitterTextboxInSocialMediaAccounts'), Twitter)
WebUI.click(findTestObject('SettingsPage/Account Basics/SaveButtonInSocialmedia'))
WebUI.refresh()
WebUI.scrollToElement(findTestObject('SettingsPage/Account Basics/EditButtonInSocialMediaDivision'), 0)
WebDriver driver = DriverFactory.getWebDriver()
String User = driver.findElement(By.xpath('//a[text()="https://twitter.com/taco"]')).getText()
String UserLink = User.split('/')[3]
WebUI.verifyMatch(UserLink, Twitter, false)


