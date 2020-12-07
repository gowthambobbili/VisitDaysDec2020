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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

not_run: CustomKeywords.'com.CommonUtilities.CreationOperations.CreateVisitType'(findTestObject('VisitTypesPage/DailyVisitsOption'), 
    'create and edit')

not_run: CustomKeywords.'com.CommonUtilities.EditVisitTypeDetailsInDetailsPage.EditDetailsofDailyVisitAndEventVisitTypes'()

not_run: CustomKeywords.'com.CommonUtilities.DeleteOperations.DeleteVisitType'()

not_run: CustomKeywords.'com.CommonUtilities.CreationOperations.CreateVisitType'(findTestObject('VisitTypesPage/eventOption'))

not_run: CustomKeywords.'com.CommonUtilities.EditVisitTypeDetailsInDetailsPage.EditDetailsofDailyVisitAndEventVisitTypes'()

not_run: CustomKeywords.'com.CommonUtilities.DeleteOperations.DeleteVisitType'()

not_run: CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusVisitType'(findTestObject('VisitTypesPage/OffCampusOption'))

not_run: CustomKeywords.'com.CommonUtilities.EditVisitTypeDetailsInDetailsPage.EditDetailsofOffCampusVisitTypes'()

not_run: CustomKeywords.'com.CommonUtilities.DeleteOperations.DeleteVisitType'()

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

EditVisitType(DailyVisitVisitType)

def EditVisitType(String VisitType) {
    WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

    def CreatedVisitTypeInVisitTypesPage = new TestObject('Created visit type in visit types list in Visit types page')

    CreatedVisitTypeInVisitTypesPage.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(CreatedVisitTypeInVisitTypesPage, 
        'The created visit type is not present in the visit types list, in Visit types page')

    WebUI.click(CreatedVisitTypeInVisitTypesPage)

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'), 
        'Details tab is not present in the visit type')

    WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInVisitTypeNameFieldInSummaryPage'), 
        'In Details page, Edit Button is not present in Visit Type name division')

    WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInVisitTypeNameFieldInSummaryPage'))

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), 
        'In Details page, Visit type name text box is not present while editing')

    WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameTextBoxInSummaryPage'), ' Edit')

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 
        'In Details page, Save button is not present while editing visit type name ')

    WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 
        'In Details page, after editing the visit type name, if user clicks save button then the Edit vitit type modal is not shown')

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 
        'In Details page after editing the visit type, if user clicks save button then the in the edit visit type modal No Automated communications radio button is not present')

    WebUI.waitForElementVisible(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), 
        0)

    WebUI.click(findTestObject('VisitTypesPage/NoAutomatedCommuunicationRadioButtonInEditDetailsPopup'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('VisitTypesPage/ContinueButtonInEditVisitTypeModal'), FailureHandling.STOP_ON_FAILURE)

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 
        'In Details page after editing the visit type name, if user clicks save button then the Save button is not getting closed and the changes are not getting saved')

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('VisitTypesPage/EditVisitTypeModalInDetailsPage'), 
        'While editing Visit type name Edit visit type modal is not getting closed and the changes are not getting saved')

    WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/VisitTypeNameInSummaryPage'), VisitType + 
        ' Edit')

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'), 
        'In Details page of visit type Edit link is not present in Registrant type division')

    WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'))

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/IndividualsCheckBoxInSummaryPage'), 
        'While editing visit type in the Details page Individual checkbox is not present in Registrant type division')

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/GroupsLabelInSummaryPage'), 
        'While editing visit type in the Details page Group checkbox is not present in Registrant type division')

    WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/IndividualsCheckBoxInSummaryPage'))

    WebUI.verifyElementNotChecked(findTestObject('VisitTypesPage/VisitTypesSummaryPage/IndividualRegistrantTypeCheckboxInputField'), 
        0)

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 
        'Save button is not present in Registrant type division in Details page of visit type')

    WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 
        '"In Details page of visit type, after editing and clicking Save button in Registrant Type division, the Save button is not getting closed and the changes are not getting saved"')

    String RegistrantTypeAfterEditing = WebUI.getText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RegistrantTypeInSummaryPage'))

    if (WebUI.verifyElementText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RegistrantTypeInSummaryPage'), 'Individuals And Groups', 
        FailureHandling.OPTIONAL)) {
        WebUI.takeScreenshot()

        KeywordUtil.markFailedAndStop('After editing and saved the Registrant type, it shows the old data in details page')
    }
    
    CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(RegistrantTypeAfterEditing, 'Groups', 'While editing visit type the changes made in Registrant type division are not getting saved')

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantionMethodFieldInSummaryPage'), 
        'In Details page of visit type Edit link is not present in Registration method division')

    WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantionMethodFieldInSummaryPage'))

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/InstantBookInSummaryPage'), 
        'In Details page of visit type Instant Book radio button is not  present in Registration Method division')

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RequestRadioButtonInSummaryPage'), 
        'In Details page of visit type, Request radio button is not  present in Registration Method division')

    WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RequestRadioButtonInSummaryPage'))

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 
        'Save button is not present in Registration Method division in Details page of visit type')

    WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

    CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 
        '"In Details page of visit type, after editing and clicking Save button in Registration Method division, the button is not getting closed and the changes are not getting saved"')

    String RegistrationMethodAfterEditing = WebUI.getText(findTestObject('VisitTypesPage/VisitTypesSummaryPage/RegistrationMethodInSummaryPage'))
}

