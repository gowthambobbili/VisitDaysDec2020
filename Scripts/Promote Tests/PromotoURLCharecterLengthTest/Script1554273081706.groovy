import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.Clipboard as Clipboard
import java.awt.datatransfer.DataFlavor as DataFlavor
import java.awt.datatransfer.Transferable as Transferable

Random Rvar = new Random()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

String CampaignName = CustomKeywords.'com.CommonUtilities.Promote.CreateCampaignWithGivenVisitTypes'('Facebook', VisitType)

def CampaignLinkOnaPublishedCampaign = new TestObject('Campaign link on the published campaign')

CampaignLinkOnaPublishedCampaign.addProperty('xpath', ConditionType.EQUALS, ('(//div[text()=\'' + CampaignName) + '\']/../..//a)[2]')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(CampaignLinkOnaPublishedCampaign,
		'Campaign link is not present on published campaign')

def CopyToClipBoardButton = new TestObject('Copy to clip board button')

CopyToClipBoardButton.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + CampaignName) + '\']/../..//div[@class=\'col-md-4 keyword-assigned\']//button[@class=\'copyable copy-btn ember-view\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(CopyToClipBoardButton, 'Copy to clipboard buton is not present on the campaign')

WebUI.click(CopyToClipBoardButton)

Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard()

Transferable t = cb.getContents(cb)

String ClipboardContent = t.getTransferData(DataFlavor.stringFlavor).toString()

println(ClipboardContent)

String CampaignLinkText = WebUI.getText(CampaignLinkOnaPublishedCampaign)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'('https://myvst.co/v/' + CampaignLinkText, ClipboardContent,
		'When clicked on copy to clipboard button the link not getting copied')

WebUI.click(CampaignLinkOnaPublishedCampaign)

WebUI.switchToWindowIndex(1)

WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/IframeOfMobi'), 0)

String UrlAfterClickingTheCampaignLink = WebUI.getUrl()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(UrlAfterClickingTheCampaignLink, GlobalVariable.CampaignUrl +
		CampaignLinkText, 'When clicked on the campaign link, it\'s navigated to an incorrect url')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/IframeOfMobi'),
		'Mobi is not opened when navigated to a valid campaign link')

WebUI.switchToFrame(findTestObject('Object Repository/Add Attendee/IframeOfMobi'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/IndividualOptionInMobi'),
		'When navigated to the campaign link the Individual option in mobi is not shown')

WebUI.click(findTestObject('Object Repository/Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'),
		'Right arrow (To go to next date) is not prensent in the Mobi')

WebUI.click(findTestObject('Object Repository/Add Attendee/RightArrowToNavigateNextDate'))

def FilteredVisitInCampignLink = new TestObject('Filtered visit in campaign link')

FilteredVisitInCampignLink.addProperty('xpath', ConditionType.EQUALS, "//strong[text()='"+VisitType+"']")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(FilteredVisitInCampignLink,
		'When navigated to the campaign link, The filtered visit is not shown in the mobi')

