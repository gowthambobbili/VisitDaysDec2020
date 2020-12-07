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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToUsers'()

WebUI.click(findTestObject('TeamManagement/InviteUserButtonInUsers'))

WebUI.verifyElementPresent(findTestObject('TeamManagement/InvitrUserFormObjects/FirstsNameFieldInInviteUserForm'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/InvitrUserFormObjects/LastNameFieldInInviteUserForm'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/InvitrUserFormObjects/EmailFieldInInviteUserForm'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/InvitrUserFormObjects/DomainDropdownInInviteUserForm'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/InvitrUserFormObjects/RoleDropdownInInviteUserForm'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/InvitrUserFormObjects/PermissionLevelDropdown'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/InvitrUserFormObjects/SendInviteButtonInInviteUserForm'), 0)

String FirstName = 'Test'

WebUI.sendKeys(findTestObject('TeamManagement/InvitrUserFormObjects/FirstsNameFieldInInviteUserForm'), FirstName)

def lastname = CustomKeywords.'com.CommonUtilities.InviteUserutilities.LastName'()

WebUI.sendKeys(findTestObject('TeamManagement/InvitrUserFormObjects/LastNameFieldInInviteUserForm'), lastname)

def Email = CustomKeywords.'com.CommonUtilities.InviteUserutilities.RandomEmail'()

WebUI.sendKeys(findTestObject('TeamManagement/InvitrUserFormObjects/EmailFieldInInviteUserForm'), Email)

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/DomainDropdownInInviteUserForm'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/FirstDomainOptionInDomainDropdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('TeamManagement/InvitrUserFormObjects/RoleFieldInInInviteUserForm'), 'Test Role')

WebUI.scrollToElement(findTestObject('TeamManagement/InvitrUserFormObjects/PermissionLevelDropdown'), 0)

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/PermissionLevelDropdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/SchoolAdminOptionInPermissionLevelDropDown'), FailureHandling.STOP_ON_FAILURE)

//aa = WebUI.getText(findTestObject('TeamManagement/InvitrUserFormObjects/FirstsNameFieldInInviteUserForm'))
//
//println(aa)
WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/SendInviteButtonInInviteUserForm'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3, FailureHandling.OPTIONAL)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('TeamManagement/InviteUserButtonInUsers'), 0)

WebDriver driver = DriverFactory.getWebDriver()

def object = new TestObject("InvitedUserInUsersList")

object.addProperty("xpath", ConditionType.EQUALS, "//b[text()='"+FirstName+' '+lastname+"']")

if(!(WebUI.verifyElementPresent(object, 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailedAndStop("The Invited User is not shown in the Users list")
	WebUI.takeScreenshot()
}

//driver.findElement(By.xpath(((('//b[text()=\'' + FirstName) + ' ') + lastname) + '\']')).isDisplayed()

