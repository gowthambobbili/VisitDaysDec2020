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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisit'()

not_run: WebUI.closeBrowser()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.LoginAsReadOnlyUser'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/VisitTypeFilterTextFieldInDV'), 'Automation Test1')

WebUI.click(findTestObject('DailyVisitsPage/SelectHighlightedVisitTypeInFilter'))

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInDateRangeFilterCalander'))

WebUI.click(findTestObject('DailyVisitsPage/LastDateInDateRangeFilterCalander'))

WebUI.click(findTestObject('DailyVisitsPage/EmptySpaceInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisits'))

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EditLInkInCapacityDivision'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EditLinkInLocationDivision'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EditLinkInUserAssignedDivision'), 0)

WebUI.closeBrowser()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.LoginAsSchoolAdmin'()

