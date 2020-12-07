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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/MyTeamLeftNav'))

WebUI.click(findTestObject('TeamManagement/InviteUserButtonInUsers'))

WebUI.verifyElementPresent(findTestObject('TeamManagement/SingleSignOnEnabledHeaderInSingleSignOnModal'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/SingleSignOnDescriptionInSingleSignOnEnabledModal'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.waitForElementClickable(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.verifyElementVisible(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/ThreeDotMenuButton'), 0)

WebUI.click(findTestObject('TeamManagement/Users/ThreeDotMenuButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/ChangePermissionLevelOption'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/DeactivateUserOption'), 0)

WebUI.click(findTestObject('TeamManagement/Users/ChangePermissionLevelOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('TeamManagement/SingleSignOnEnabledHeaderInSingleSignOnModal'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/SingleSignOnDescriptionInSingleSignOnEnabledModal'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.waitForElementClickable(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.verifyElementVisible(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/ThreeDotMenuButton'), 0)

WebUI.click(findTestObject('TeamManagement/Users/ThreeDotMenuButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/DeactivatUserModal'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Users/DeactivateUserOption'), 0)

WebUI.click(findTestObject('TeamManagement/Users/ChangePermissionLevelOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('TeamManagement/SingleSignOnEnabledHeaderInSingleSignOnModal'), 0)

WebUI.verifyElementPresent(findTestObject('TeamManagement/SingleSignOnDescriptionInSingleSignOnEnabledModal'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.waitForElementClickable(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.verifyElementVisible(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

WebUI.waitForElementVisible(findTestObject('TeamManagement/DeactivatedTabInUsers'), 0)

WebUI.click(findTestObject('TeamManagement/DeactivatedTabInUsers'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/TeamManagement/Users/ReactivateButtonInDeactivatedTab'), 
    0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/TeamManagement/Users/ReactivateButtonInDeactivatedTab'))

    WebUI.verifyElementPresent(findTestObject('TeamManagement/SingleSignOnEnabledHeaderInSingleSignOnModal'), 0)

    WebUI.verifyElementPresent(findTestObject('TeamManagement/SingleSignOnDescriptionInSingleSignOnEnabledModal'), 5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

    WebUI.waitForElementClickable(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)

    WebUI.verifyElementVisible(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('TeamManagement/OkButtonInSingleSignOnEnabledModal'), 0)
}

