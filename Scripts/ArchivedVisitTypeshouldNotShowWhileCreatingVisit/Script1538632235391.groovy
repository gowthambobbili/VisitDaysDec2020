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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.server.DefaultDriverFactory as DefaultDriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item": DailyVisitVisitType]), "the created Daily visits visit type is not shown in the visit type dropdown of daily visit index page")

String EventVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item": EventVisitType]), "the created Event visit type is not shown in the visit type dropdown of Events index page")

String OffCampusVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item": OffCampusVisitType]), "the created Off campus visit type is not shown in the visit type dropdown of Off campus index page")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.verifyElementPresent(findTestObject('EventsPage/CreateEventButton'), 0)

WebUI.click(findTestObject('EventsPage/CreateEventButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item": DailyVisitVisitType]), "Daily visit visit type is shown in the visit type dropdown of crete event page")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.verifyElementPresent(findTestObject('OffCampusPage/CreateOffCampusButton'), 0)

WebUI.click(findTestObject('OffCampusPage/CreateOffCampusButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item": EventVisitType]), "Daily visit visit type is shown in the visit type dropdown of crete Off campus page")

CustomKeywords.'com.CommonUtilities.VisitTypeOperations.ArchiveVisitType'(DailyVisitVisitType)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/CreateDailyVisitButton'))

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item":EventVisitType]), "Event visit type is shown in the visit type dropdown of Create Event page")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.verifyElementPresent(findTestObject('OffCampusPage/CreateOffCampusButton'), 0)

WebUI.click(findTestObject('OffCampusPage/CreateOffCampusButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item":EventVisitType]), "Event visit type is shown in the visit type dropdown of Create Off campus page")

CustomKeywords.'com.CommonUtilities.VisitTypeOperations.ArchiveVisitType'(EventVisitType)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.click(findTestObject('EventsPage/CreateEventButton'))

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item":EventVisitType]), "Archived Event visit type is shown in visit type dropdown of crete event dropdown page")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item":OffCampusVisitType]), "Off campus visit type is shown in visit type dropdown of Create Daily visit page")

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.verifyElementPresent(findTestObject('EventsPage/CreateEventButton'), 0)

WebUI.click(findTestObject('EventsPage/CreateEventButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item":OffCampusVisitType]), "Off campus visit type is shown in visit type dropdown of Create Off campus page")

CustomKeywords.'com.CommonUtilities.VisitTypeOperations.ArchiveVisitType'(OffCampusVisitType)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.click(findTestObject('OffCampusPage/CreateOffCampusButton'))

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/ItemInPowerSelectDropdown(Item)', ["Item":OffCampusVisitType]), "Archived Off campus visit type is shown in visit type dropdown while creating Off campus visit")


