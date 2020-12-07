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

WebUI.navigateToUrl(SurveyLinkForCharizard)

if (!(WebUI.verifyElementPresent(findTestObject('Survey-Student App Objects/WhatIsYourImpressionOfOurSchoolQuestion'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('What was your impression of our school? question is not shown')

    WebUI.takeScreenshot()
}

String FirstOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/FirstOption'))

String SecondOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/SecondOption'))

String ThirdOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/ThirdOption'))

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/FirstOption'), 'favorite\nLoved It!', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'What was your impression of our school?\' the First option is shown wrong as' + 
        FirstOptionText) + '. Expected First option is: Loved It!')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/SecondOption'), 'sentiment_neutral\nIt\'s Okay', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'What was your impression of our school?\' the Second option is shown wrong as' + 
        SecondOptionText) + '. Expected Second option is: It\'s Okay')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/ThirdOption'), 'thumb_down\nNot My Style', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'What was your impression of our school?\' the Third option is shown wrong as' + 
        ThirdOptionText) + '. Expected Third option is: Not My Style')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('Survey-Student App Objects/ThirdOption'))

if (!(WebUI.verifyElementPresent(findTestObject('Survey-Student App Objects/HowHelpFullWereTheStudentOrStaffThatLedYourVisitQuestion'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('"How helpful were the students/staff that led your visit?" question is not shown')

    WebUI.takeScreenshot()
}

FirstOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/FirstOption'))

SecondOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/SecondOption'))

ThirdOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/ThirdOption'))

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/FirstOption'), 'favorite\nVery Helpful!', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'How helpful were the students/staff that led your visit?\' the first option is shown wrong as' + 
        FirstOptionText) + '. Expected first option is: Very Helpful!')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/SecondOption'), 'sentiment_neutral\nSort of Helpful', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'How helpful were the students/staff that led your visit?\' the Second option is shown wrong as' + 
        SecondOptionText) + '. Expected Second option is: Sort of Helpful')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/ThirdOption'), 'thumb_down\nNot Helpful', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'How helpful were the students/staff that led your visit?\' the Third option is shown wrong as' + 
        ThirdOptionText) + '. Expected Third option is: Not Helpful')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('Survey-Student App Objects/ThirdOption'))

if (!(WebUI.verifyElementPresent(findTestObject('Survey-Student App Objects/DidTheVisitIncreaseYourInterestInUs'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('"Did the visit increase your interest in us?" question is not shown')

    WebUI.takeScreenshot()
}

FirstOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/FirstOption'))

SecondOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/SecondOption'))

ThirdOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/ThirdOption'))

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/FirstOption'), 'favorite\nI\'m More Interested!', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'Did the visit increase your interest in us?\' the first option is shown wrong as' + 
        FirstOptionText) + '. Expected first option is: I am More Interested!')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/SecondOption'), 'sentiment_neutral\nI Feel The Same', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'Did the visit increase your interest in us?\' the Second option is shown wrong as' + 
        SecondOptionText) + '. Expected Second option is: I Feel The Same')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/ThirdOption'), 'thumb_down\nI\'m less Interested', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'Did the visit increase your interest in us?\' the Third option is shown wrong as' + 
        ThirdOptionText) + '. Expected Third option is: I am less Interested')

    WebUI.takeScreenshot()
}

WebUI.click(findTestObject('Survey-Student App Objects/ThirdOption'))

if (!(WebUI.verifyElementPresent(findTestObject('Survey-Student App Objects/HowLikelyAreYouToApplyQuestion'), 0, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('"How likely are you to apply?" question is not shown')

    WebUI.takeScreenshot()
}

FirstOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/FirstOption'))

SecondOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/SecondOption'))

ThirdOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/ThirdOption'))

String FourthOptionText = WebUI.getText(findTestObject('Survey-Student App Objects/FourthOption'))

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/FirstOption'), 'check\nAlready Applied', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'How likely are you to apply?\' the First option is shown wrong as' + FirstOptionText) + 
        '. Expected First option is: Already Applied')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/SecondOption'), 'favorite\nDefinitely Applying!', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'How likely are you to apply?\' the Second option is shown wrong as' + SecondOptionText) + 
        '. Expected Second option is: Definitely Applying!')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/ThirdOption'), 'sentiment_neutral\nMight Apply', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'How likely are you to apply?\' the Third option is shown wrong as' + ThirdOptionText) + 
        '. Expected Third option is: Might Apply')

    WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Survey-Student App Objects/FourthOption'), 'thumb_down\nUnlikely To Apply', FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed(('For the question \'How likely are you to apply?\' the Fourth option is shown wrong as' + FourthOptionText) + 
        '. Expected Fourth option is: Unlikely To Apply')

    WebUI.takeScreenshot()
}

