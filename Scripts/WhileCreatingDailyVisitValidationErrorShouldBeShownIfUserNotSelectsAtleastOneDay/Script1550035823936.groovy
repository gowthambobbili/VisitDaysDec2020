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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitTypeName = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilter')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitTypeName) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

CustomKeywords.'com.CommonUtilities.UncheckAllDaysWhileCreatingDailyVisit.UncheckallDaysCheckboxes'()

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('FlashMessage'), 'While creating Daily visit the validation message is not shown After clicking next button in details page without selecting atleast one day')

CustomKeywords.'com.CommonUtilities.UncheckAllDaysWhileCreatingDailyVisit.CheckallDaysCheckboxes'()

WebUI.click(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.UncheckAllDaysWhileCreatingDailyVisit.UncheckallSecondDaysCheckboxes'()

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('FlashMessage'), 'While creating Daily visit the validation message is not shown After clicking next button in details page without selecting atleast one day')

