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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

//String DailyVisiytVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()
//
//CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(DailyVisiytVisitType)
String OffCampusVisitTypeWithKeywordCheckin = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithKeywordCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusWithInstantVisitType'(OffCampusVisitTypeWithKeywordCheckin)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 0)) {
    WebUI.click(findTestObject('Object Repository/DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

driver.findElement(By.xpath(('//li[text()=\'' + OffCampusVisitTypeWithKeywordCheckin) + '\']')).click()

WebUI.click(findTestObject('DailyVisitsPage/BothRadioButtonInRegistrationMethodFilter'))

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

WebUI.refresh()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(3)

driver.findElement(By.xpath(('//li[text()=\'' + OffCampusVisitTypeWithKeywordCheckin) + '\']')).click()

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ApplyButtonInDateRangeFilter'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'), 0)

String Keyword = driver.findElement(By.xpath('(//div[@class=\'row no-override bg-blue\']//strong)[1]')).getText()

println(Keyword)

WebUI.refresh()

String OffCampusVisiytVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusWithInstantVisitType'(OffCampusVisiytVisitType)

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

WebUI.waitForElementPresent(findTestObject('VisitTypesPage/SearchVisitTypesTextBox'), 0)

WebUI.waitForElementPresent(findTestObject('VisitTypesPage/FirstVisitTypeInVisitTypesList'), 0)

driver.findElement(By.xpath(('//h4[text()=\'' + OffCampusVisiytVisitType) + '\']')).click()

WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInCheckInMethodFieldInSummaryPage'))

WebUI.click(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'))

WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

WebUI.click(findTestObject('VisitTypesPage/DeleteVisitTypeFlashMessage'))

WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

driver.findElement(By.xpath(('//li[text()=\'' + OffCampusVisiytVisitType) + '\']')).click()

WebUI.click(findTestObject('DailyVisitsPage/BothRadioButtonInRegistrationMethodFilter'))

WebUI.refresh()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.delay(3)

driver.findElement(By.xpath(('//li[text()=\'' + OffCampusVisiytVisitType) + '\']')).click()

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ApplyButtonInDateRangeFilter'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'), 0)

String KeywordOnOtherVisitOnSameDay = driver.findElement(By.xpath('(//div[@class=\'row no-override bg-blue\']//strong)[1]')).getText()

println(KeywordOnOtherVisitOnSameDay)

WebUI.verifyNotMatch(Keyword, KeywordOnOtherVisitOnSameDay, false)

