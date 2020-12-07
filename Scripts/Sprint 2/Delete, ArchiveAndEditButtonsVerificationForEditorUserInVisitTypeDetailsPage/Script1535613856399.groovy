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

//CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

if (WebUI.verifyElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0, FailureHandling.CONTINUE_ON_FAILURE)) {
    not_run: WebUI.waitForElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0)

    WebUI.click(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInVisitTypeNameFieldInSummaryPage'), 
        1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'), 
        1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantionMethodFieldInSummaryPage'), 
        1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCheckInMethodFieldInSummaryPage'), 
        1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInPhotoFieldInSummaryPage'), 
        3, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInDescriptionFieldInSummaryPage'), 
        1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCloseRegistrationOnFieldInSummaryPage'), 
        1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/DeleteButtonInDetailsPageOfVisitType'), 1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/ArchiveVisitTypeButton'), 1, FailureHandling.CONTINUE_ON_FAILURE)
} else {
    println('There are not visit types to verify')
}

