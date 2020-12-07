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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/MobiLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('MobiPage/GeneratePreviewButtonInMobi'), 
    'Generate preview button is not shown in Mobi page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('MobiPage/EditLinkInMobi'), 
    'Edit link is not presernt in Mobi page')

WebUI.click(findTestObject('MobiPage/GeneratePreviewButtonInMobi'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

String BgcolorOfPageInMobi = WebUI.getCSSValue(findTestObject('MobiPage/MobiHeaserrInPreview'), 'background-color')

println(BgcolorOfPageInMobi)

WebUI.navigateToUrl('https://metapod-student.visitdays.com/albrightsandbox/surv/F7EAYQFB?useNew')

WebUI.waitForElementPresent(findTestObject('Survey-Student App Objects/PageHeroDIvision'), 0)

String BgcolorOfPageHero = WebUI.getCSSValue(findTestObject('Survey-Student App Objects/PageHeroDIvision'), 'background-color')

println(BgcolorOfPageHero)

if (!(WebUI.verifyMatch(BgcolorOfPageHero, BgcolorOfPageInMobi, false, FailureHandling.OPTIONAL))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('The page hero back ground color in the survey page is shown incorrect')
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Survey-Student App Objects/SubmitButton'), 
    "Submit button is not present in the Survey page")

if (!(WebUI.verifyElementNotClickable(findTestObject('Survey-Student App Objects/SubmitButton'), FailureHandling.OPTIONAL))) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop('Submit button is cliackable even before answering all mandetory survey questions')
}

