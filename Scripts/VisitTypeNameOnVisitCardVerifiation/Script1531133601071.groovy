import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.google.common.collect.FilteredEntryMultimap.Keys as Keys
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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

//CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisit'()
//
//CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()
//
//WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)
//
//WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
//
//WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))
//
//WebUI.sendKeys(findTestObject('DailyVisitsPage/VisitTypeFilterTextFieldInDV'), 'Automation Test1')
//
//WebUI.click(findTestObject('DailyVisitsPage/SelectHighlightedVisitTypeInFilter'))
//
//WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))
//
//WebUI.click(findTestObject('DailyVisitsPage/StartDateInDateRangeFilterCalander'))
//
//WebUI.click(findTestObject('DailyVisitsPage/LastDateInDateRangeFilterCalander'))
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/ApplyButtonInDateRangeFilter'))
//
//WebUI.click(findTestObject('DailyVisitsPage/EmptySpaceInDailyVisitsPage'))
//
////List VtNames = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/NameOnEachVisitCardInVisitIndex'), 0)
//List VtNames = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/NameOnEachVisitCardInVisitIndex'), 0)
//
//println(VtNames.size)
//
//println(VtNames[1].getText())
//
//println(VtNames[2].getText())
//
//for (i = 0; i < VtNames.size; i++) {
//	WebUI.verifyMatch(VtNames[i], 'Automation test1', false)
//}
//===========================================
CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitTypeName)

WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(2)

driver.findElement(By.xpath(('//li[text()=\'' + VisitTypeName) + '\']')).click()

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'), 0)

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

int NumberOfVisits = driver.findElements(By.xpath('//h4[@class=\'visit-type-title\']')).size()

def Object = new TestObject('NameOnVisitCard')

for (int i = 1; i <= NumberOfVisits; i++) {
	Object.addProperty('xpath', ConditionType.EQUALS, ('(//h4[@class=\'visit-type-title\'])[' + NumberOfVisits) + ']')

	String NameOnVisitCard = WebUI.getText(Object)

	WebUI.verifyMatch(NameOnVisitCard, VisitTypeName, false)
}


