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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(1, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(1, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(VisitTypeName)

String Single = 'Single'

String OrganisationName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForGroupRequestWithUserName'(
    VisitTypeName, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(2, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(2, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

driver.findElement(By.xpath(('//span[text()="' + OrganisationName) + '"]')).click()

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/TopThreeDotMenuInUserProfile'))

WebUI.verifyElementNotPresent(findTestObject('UserProfile/DeleteLabelInUserProfile'), 0)

