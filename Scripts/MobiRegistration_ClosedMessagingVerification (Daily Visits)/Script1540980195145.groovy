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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))


WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

WebUI.click(findTestObject('SettingsPage/AccountBasicsNav'))

WebUI.verifyElementPresent(findTestObject('SettingsPage/Account Basics/MainContactEmailInAccountBasics'), 0)

MainContactEmail = WebUI.getText(findTestObject('SettingsPage/Account Basics/MainContactEmailInAccountBasics'))

WebUI.click(findTestObject('Object Repository/HomePageElements/SchoolProdoutNav'))

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithNumberOfDaysToCloseRegistration'(
    3)

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

String VisitUrl = WebUI.getUrl()

String VisitId = VisitUrl.split('visits/')[1]

print(VisitUrl)

String MobiUrl = GlobalVariable.EvrUrl+ VisitId

WebUI.navigateToUrl(MobiUrl)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

if (!(WebUI.verifyElementText(findTestObject('Add Attendee/Mobi/MessageInMobi'), 'Registration has closed for ' + VisitType, 
    FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Registration Closed warning message not shown for the visit in progress, in Mobi')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Add Attendee/Mobi/MainContactEmailInMobi'), MainContactEmail, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Incorrect Main contact email is shown in Mobi Regstration full waring page')

  WebUI.takeScreenshot()
}

WebUI.navigateToUrl(VisitUrl)

//WebUI.switchToDefaultContent()

