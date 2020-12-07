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

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPageForAllActiveVisits'()

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/CurrentCapacityFilterInVisitIndexPage'))

WebUI.delay(1)

WebUI.click(findTestObject('DailyVisitsPage/NoRegistrationsOptionInCurrentCapacityDropDown'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

String VisitType

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0, FailureHandling.OPTIONAL)) {
    VisitType = WebUI.getText(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))
} else {
    VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

    CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

    CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

    def visit = new TestObject('Created Visit In Index Page')

    visit.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

    if (!(WebUI.verifyElementPresent(visit, 0))) {
        WebUI.takeScreenshot()

        KeywordUtil.markFailed('The created visit is not present in visit index page')
    }
}

return VisitType

