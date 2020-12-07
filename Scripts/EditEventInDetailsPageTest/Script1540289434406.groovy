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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String EventVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateEventWithInstantVisitType'(EventVisitType)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

WebUI.delay(3)

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 0)) {
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

driver.findElement(By.xpath(('//li[text()=\'' + EventVisitType) + '\']')).click()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), FailureHandling.STOP_ON_FAILURE)

String DateBeforeEdit = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/DateInDateField'))

//WebUI.click(findTestObject('DailyVisitsPage/EditLinkInDateDivision'), FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('DailyVisitsPage/Details Page/DateField'), FailureHandling.STOP_ON_FAILURE)

//String CurrentActiveDate = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/CurrentActiveDay'))
//
//String DateToModift = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/FirstActiveDayInCalendar'))
//
//WebUI.click(findTestObject('DailyVisitsPage/Details Page/FirstActiveDayInCalendar'), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)
//
//String DateAfterEdit = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/DateInDateField'))
//
//WebUI.verifyNotMatch(DateAfterEdit, DateBeforeEdit, false)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/EditLinkInLocationDivision'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInLocationDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/LocationsDropDown'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/LocationsDropDown'), FailureHandling.STOP_ON_FAILURE)

NewLocation = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/SecondLocationNameInLocationsDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SecondLocationInLocationsDropDown'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After editng Location and click save button the Save and Cancel buttons are not getting disappeared and the location is not getting saved')

	WebUI.takeScreenshot()
}

TimeBeforeEditing = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/TimeInTimeDivision'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInTimeDivision'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'), 0)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/StartTimeTextBox'), '9:00 AM')

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/EndTimeTextBox'), '10:00 AM')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

WebUI.delay(4)

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('After editng Event time and clicking save button the save button is not getting hidden and the event times are not getting saved')
}

TimeAfterEditing = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/TimeInTimeDivision'))

WebUI.verifyNotMatch(TimeAfterEditing, TimeBeforeEditing, false)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Details Page/EditLinkInCapacityDivision'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/EditLinkInCapacityDivision'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInCapacityDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'),
		0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'),
		0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '10')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '5')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionOneInHowManyGuestsAreProspectiveStudentsAllowedToBring'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))


WebUI.delay(3)

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After editng Capacity and click save button, the Save and Cancel buttons are not getting disappeared and the Capicity is not getting saved')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/ExpectedGuestsPerProspectiveStudentCountAfterEditing'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After edit and click sava the capacity is not getting updated with the latest values')

	WebUI.takeScreenshot()
}

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Details Page/EditLinkInUsersAssignedDivision'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInUsersAssignedDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/SearchUserSearchboxInAssignUsersPage'), 0)

WebUI.sendKeys(findTestObject('DailyVisitsPage/SearchUserSearchboxInAssignUsersPage'), 'mahesh test')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/AddIconOfUserMaheshTestInUserAssignedDivision'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

WebUI.delay(2)

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After editng User Assign and click save button, the Save and Cancel buttons are not getting disappeared and the Assigned user is not getting saved')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/ExpectedUserAssignedInUserAssignedDivision'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After assigne a user user in Details page and clicking save the user is not shown in User Assigned division in Details page')

	WebUI.takeScreenshot()
}

WebUI.refresh()

LocationAfterEditing = WebUI.getText(findTestObject('DailyVisitsPage/Details Page/LocationInLocationDivision'))

if (!(WebUI.verifyMatch(LocationAfterEditing.toLowerCase(), NewLocation.toLowerCase(), false, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After edit and click save button the latest Location is getting updated, but after reloading the page the latest Location is not shown in the Locations division')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/ExpectedGuestsPerProspectiveStudentCountAfterEditing'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After edit and click save the capacity is getting updated, but after reload the page the latest values are not shown in Capacity Division In Details page')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Details Page/ExpectedUserAssignedInUserAssignedDivision'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After assign a user user in Details page and clicking save the user is shown in User Assigned division in Details page, but after the page reload the Assigned user is not shown')

	WebUI.takeScreenshot()
}

