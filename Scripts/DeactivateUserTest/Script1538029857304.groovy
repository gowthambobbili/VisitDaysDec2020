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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.server.DefaultDriverFactory as DefaultDriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/MyTeamLeftNav'))

WebUI.verifyElementPresent(findTestObject('TeamManagement/InviteUserButtonInUsers'), 0)

WebUI.click(findTestObject('TeamManagement/InviteUserButtonInUsers'))

WebUI.verifyElementPresent(findTestObject('TeamManagement/InvitrUserFormObjects/InviteNewUserHeaderInInviteUserModal'),
		0)

Random RandVar = new Random()

String FirstName = 'SampleUser'

String SecondName = RandVar.nextInt(100000)

String Email = 'Testemail' + RandVar.nextInt(100000)

WebUI.waitForElementVisible(findTestObject('TeamManagement/InvitrUserFormObjects/FirstsNameFieldInInviteUserForm'), 0)

WebUI.sendKeys(findTestObject('TeamManagement/InvitrUserFormObjects/FirstsNameFieldInInviteUserForm'), FirstName)

WebUI.sendKeys(findTestObject('TeamManagement/InvitrUserFormObjects/LastNameFieldInInviteUserForm'), SecondName)

WebUI.sendKeys(findTestObject('TeamManagement/InvitrUserFormObjects/EmailFieldInInviteUserForm'), Email)

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/DomainDropdownInInviteUserForm'))

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/FirstDomainOptionInDomainDropdown'))

WebUI.sendKeys(findTestObject('TeamManagement/InvitrUserFormObjects/RoleFieldInInInviteUserForm'), 'Tester')

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/PermissionLevelDropdown'))

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/SchoolAdminOptionInPermissionLevelDropDown'))

WebUI.verifyElementClickable(findTestObject('TeamManagement/InvitrUserFormObjects/SendInviteButtonInInviteUserForm'))

WebUI.click(findTestObject('TeamManagement/InvitrUserFormObjects/SendInviteButtonInInviteUserForm'))

WebUI.verifyElementNotPresent(findTestObject('TeamManagement/InvitrUserFormObjects/InviteNewUserHeaderInInviteUserModal'),
		10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('TeamManagement/Users/FirstUserNameInUsersList'), 0)

WebUI.delay(2)

String User = (FirstName + ' ') + SecondName

WebUI.sendKeys(findTestObject('TeamManagement/SearchUsersSearchBoxInUsersActiveTab'), User)

if(!(WebUI.waitForElementPresent(findTestObject('TeamManagement/Users/FirstUserNameInUsersList'), 0)))
{
	KeywordUtil.markFailedAndStop("The invited user is not shown in the Users list")

	WebUI.takeScreenshot()
}

WebUI.delay(2)



def InvitedUser = new TestObject("ThreeDotMenuOfInvitedUser")

InvitedUser.addProperty("xpath", ConditionType.EQUALS, "//b[text()='"+User+"']/../../..//i[text()=\'more_vert\']")

WebUI.click(InvitedUser)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/DeactivateUserOption'), 0)

WebUI.click(findTestObject('TeamManagement/Users/DeactivateUserOption'))

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/DeactivatUserModal'), 0)

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('TeamManagement/Users/DeactivateButtonInDeactivateModal'), 0)

WebUI.click(findTestObject('TeamManagement/Users/DeactivateButtonInDeactivateModal'))

WebUI.waitForElementNotPresent(findTestObject('TeamManagement/Users/DeactivateButtonInDeactivateModal'), 0)

WebUI.click(findTestObject('FlashMessage'), FailureHandling.OPTIONAL)

WebUI.delay(2)

WebUI.waitForElementClickable(findTestObject('TeamManagement/DeactivatedTabInUsers'), 0)

WebUI.click(findTestObject('TeamManagement/DeactivatedTabInUsers'))

WebUI.sendKeys(findTestObject('TeamManagement/SearchUsersSearchBoxInUsersDeactivatedTab'), User)

WebUI.delay(3)

def userprofile = new TestObject("InvitedUserInUsersList")

userprofile.addProperty("xpath", ConditionType.EQUALS, "//b[text()='"+User+"']")

if(!(WebUI.verifyElementPresent(userprofile, 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("The deactivated user is not shown in the Deactivate list")

	WebUI.takeScreenshot()
}

//WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/FirstUserNameInUsersList'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('TeamManagement/Users/ReactivateButtonInDeactivatedTab'))

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/ConfirmReactivationHeaderInConfirmReactivationModal'), 0)

WebUI.waitForElementVisible(findTestObject('TeamManagement/Users/ReactivateUserButtonInReactivateConfirmationPopop'), 0)

WebUI.click(findTestObject('TeamManagement/Users/ReactivateUserButtonInReactivateConfirmationPopop'))

WebUI.waitForElementNotVisible(findTestObject('TeamManagement/Users/ConfirmReactivationHeaderInConfirmReactivationModal'),
		0)

not_run: WebUI.sendKeys(findTestObject('TeamManagement/SearchUsersSearchBoxInUsersDeactivatedTab'), User)

WebUI.delay(2)

//WebUI.waitForElementNotPresent(findTestObject('TeamManagement/Users/FirstUserNameInUsersList'), 0)

WebUI.click(findTestObject('TeamManagement/ActiveTabInUsers'))

WebUI.waitForElementPresent(findTestObject('TeamManagement/Users/FirstUserNameInUsersList'), 0)

WebUI.delay(3)

if(!(WebUI.verifyElementPresent(userprofile, 0, FailureHandling)))
{
	KeywordUtil.markFailed("The reactivated user is not shown in the active users list")

	WebUI.takeScreenshot()
}
