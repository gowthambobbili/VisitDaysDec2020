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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebDriver driver = DriverFactory.getWebDriver()

driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
//WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))
//driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()
//WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))
//WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))
WebUI.delay(5)

not_run: WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeTitleOnVisitCard'), 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: driver.findElement(By.xpath(('//h4[@class=\'visit-type-title\' and text()=\'' + VisitType) + '\']')).isDisplayed()

CustomKeywords.'com.CommonUtilities.Registraions.GroupRegistrationAndVerification'(VisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'))

WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

WebUI.delay(7)

not_run: WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/ChooseADateLabelInAddAttendee'), 0)

WebUI.delay(3)

driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

driver.findElement(By.xpath(('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.verifyElementPresent(findTestObject('Add Attendee/TimePendingLabelInBuilderPage'), 0)

WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))

WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))

if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

    WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
}

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), FirstName)

WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), LastName)

WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), CellPhoneNumber)

WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))

WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))

WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))

WebUI.sendKeys(findTestObject('Add Attendee/HomeAddressInStudentInformationPage'), HomeAddress)

WebUI.click(findTestObject('Add Attendee/CountryDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/UnitedStatesOptionInCountryDropdown'))

WebUI.sendKeys(findTestObject('Add Attendee/CityOrTownInStudentInformationPage'), City)

WebUI.click(findTestObject('Add Attendee/StateOrProvinceDropdownInStudentInformationPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/StateOrProvinceOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Add Attendee/ZipCodeInStudentInformationPage'), ZipCode)

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/ApplicationStatusDropdown'))

WebUI.click(findTestObject('Add Attendee/AppliedOptionInApplicationStatus'))

WebUI.click(findTestObject('Add Attendee/FreshmanOptionInWhatKindOfApplicantYouAre'))

WebUI.click(findTestObject('Add Attendee/ExpectedEntryYearDropdown'))

WebUI.click(findTestObject('Add Attendee/2022OptionInExpectedEntryYear'))

WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolDropDown'))

WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), 'testschool')

WebUI.click(findTestObject('Add Attendee/FirsrtOptionInCurrentOrLastSchool'))

WebUI.click(findTestObject('Add Attendee/AcademicInterestsDropdown'))

WebUI.click(findTestObject('Add Attendee/FirstOptionInAcademicInterests'))

WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

WebUI.delay(3)

// daily visit verification completed

WebUI.click(findTestObject('Add Attendee/CloseButtonInAddAttendee'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/HomePageElements/VisitTypesLeftNav'))

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))

driver.findElement(By.xpath(('//li[text()=\'' + VisitType) + '\']')).click()

WebUI.click(findTestObject('Object Repository/HomePageElements/RequesuFilterRadioButton'))

WebUI.delay(3)

driver.findElement(By.xpath(('//div[@class=\'shadow __visit__visit-card__7422f pointer-on-hover ember-view\']//h4[text()=\'' + 
        VisitType) + '\']')).click()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/PendingTabInRequestVisit'), 0)

String StudentName = FirstName + LastName

driver.findElement(By.xpath(('//div[contains(text(),\'' + StudentName) + '\')]')).isDisplayed()

//==========End of Daily Visit Verification========

String EventVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestEventVisitType'()

// daily visit verification completed =================
//event verification
WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

//WebDriver driver = DriverFactory.getWebDriver()
driver.findElement(By.xpath(('//li[text()=\'' + EventVisitType) + '\']')).click()

WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
//WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))
//driver.findElement(By.xpath(('//li[text()=\'' + EventVisitType) + '\']')).click()
//WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))
//WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))
WebUI.delay(5)

not_run: WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeTitleOnVisitCard'), 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: driver.findElement(By.xpath(('//h4[@class=\'visit-type-title\' and text()=\'' + EventVisitType) + '\']')).isDisplayed()

CustomKeywords.'com.CommonUtilities.Registraions.GroupRegistrationAndVerification'(EventVisitType, findTestObject('Add Attendee/EventsOptionInAddAttendee'))

WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

WebUI.delay(7)

not_run: WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/EventsOptionInAddAttendee'))

WebUI.delay(5)

driver.findElement(By.xpath(('//strong[text()=\'' + EventVisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

driver.findElement(By.xpath(('//strong[text()=\'' + EventVisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

driver.findElement(By.xpath(('//strong[text()=\'' + EventVisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.verifyElementPresent(findTestObject('Add Attendee/TimePendingLabelInBuilderPage'), 0)

WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))

WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))

if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

    WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
}

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), FirstName)

WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), LastName)

WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), CellPhoneNumber)

WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))

WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))

WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))

WebUI.sendKeys(findTestObject('Add Attendee/HomeAddressInStudentInformationPage'), HomeAddress)

WebUI.click(findTestObject('Add Attendee/CountryDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/UnitedStatesOptionInCountryDropdown'))

WebUI.sendKeys(findTestObject('Add Attendee/CityOrTownInStudentInformationPage'), City)

WebUI.click(findTestObject('Add Attendee/StateOrProvinceDropdownInStudentInformationPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/StateOrProvinceOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Add Attendee/ZipCodeInStudentInformationPage'), ZipCode)

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/ApplicationStatusDropdown'))

WebUI.click(findTestObject('Add Attendee/AppliedOptionInApplicationStatus'))

WebUI.click(findTestObject('Add Attendee/FreshmanOptionInWhatKindOfApplicantYouAre'))

WebUI.click(findTestObject('Add Attendee/ExpectedEntryYearDropdown'))

WebUI.click(findTestObject('Add Attendee/2022OptionInExpectedEntryYear'))

WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolDropDown'))

WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), 'testschool')

WebUI.click(findTestObject('Add Attendee/FirsrtOptionInCurrentOrLastSchool'))

WebUI.click(findTestObject('Add Attendee/AcademicInterestsDropdown'))

WebUI.click(findTestObject('Add Attendee/FirstOptionInAcademicInterests'))

WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

WebUI.delay(3)

WebUI.click(findTestObject('Add Attendee/CloseButtonInAddAttendee'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/HomePageElements/VisitTypesLeftNav'))

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))

driver.findElement(By.xpath(('//li[text()=\'' + EventVisitType) + '\']')).click()

WebUI.click(findTestObject('Object Repository/HomePageElements/RequesuFilterRadioButton'))

WebUI.delay(3)

driver.findElement(By.xpath(('//div[@class=\'shadow __visit__visit-card__7422f pointer-on-hover ember-view\']//h4[text()=\'' + 
        EventVisitType) + '\']')).click()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/PendingTabInRequestVisit'), 0)

String StudentNameForEvent = FirstName + LastName

driver.findElement(By.xpath(('//div[contains(text(),\'' + StudentNameForEvent) + '\')]')).isDisplayed()

//End of Event Verification==============
//Begining of Off Campus verification 
CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String OffCampusVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestOffCampusVisitType'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

//WebDriver driver = DriverFactory.getWebDriver()
driver.findElement(By.xpath(('//li[text()=\'' + OffCampusVisitType) + '\']')).click()

WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/DailyVisitsPage/TimesHeaderInCreateDailyVisitPage'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstUserInRequestOwnerList'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
//WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))
//driver.findElement(By.xpath(('//li[text()=\'' + OffCampusVisitType) + '\']')).click()
//WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))
//WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))
WebUI.delay(5)

not_run: WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeTitleOnVisitCard'), 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: driver.findElement(By.xpath(('//h4[@class=\'visit-type-title\' and text()=\'' + OffCampusVisitType) + '\']')).isDisplayed()

CustomKeywords.'com.CommonUtilities.Registraions.GroupRegistrationAndVerification'(OffCampusVisitType, findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

WebUI.delay(7)

not_run: WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/FiterByLocationCheckboxInOffCampus'), 0)

WebUI.delay(5)

driver.findElement(By.xpath(('//strong[text()=\'' + OffCampusVisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

driver.findElement(By.xpath(('//strong[text()=\'' + OffCampusVisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

driver.findElement(By.xpath(('//strong[text()=\'' + OffCampusVisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.verifyElementPresent(findTestObject('Add Attendee/TimePendingLabelInBuilderPage'), 0)

WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))

WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))

if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedInGroup'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

    WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
}

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), FirstName)

WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), LastName)

WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), CellPhoneNumber)

WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))

WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))

WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))

WebUI.sendKeys(findTestObject('Add Attendee/HomeAddressInStudentInformationPage'), HomeAddress)

WebUI.click(findTestObject('Add Attendee/CountryDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/UnitedStatesOptionInCountryDropdown'))

WebUI.sendKeys(findTestObject('Add Attendee/CityOrTownInStudentInformationPage'), City)

WebUI.click(findTestObject('Add Attendee/StateOrProvinceDropdownInStudentInformationPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/StateOrProvinceOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Add Attendee/ZipCodeInStudentInformationPage'), ZipCode)

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/ApplicationStatusDropdown'))

WebUI.click(findTestObject('Add Attendee/AppliedOptionInApplicationStatus'))

WebUI.click(findTestObject('Add Attendee/FreshmanOptionInWhatKindOfApplicantYouAre'))

WebUI.click(findTestObject('Add Attendee/ExpectedEntryYearDropdown'))

WebUI.click(findTestObject('Add Attendee/2022OptionInExpectedEntryYear'))

WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolDropDown'))

WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), 'testschool')

WebUI.click(findTestObject('Add Attendee/FirsrtOptionInCurrentOrLastSchool'))

WebUI.click(findTestObject('Add Attendee/AcademicInterestsDropdown'))

WebUI.click(findTestObject('Add Attendee/FirstOptionInAcademicInterests'))

WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

WebUI.delay(3)

WebUI.click(findTestObject('Add Attendee/CloseButtonInAddAttendee'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/HomePageElements/VisitTypesLeftNav'))

WebUI.click(findTestObject('HomePageElements/Visits/OffCampusLeftNav'))

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 0, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDV'))

driver.findElement(By.xpath(('//li[text()=\'' + OffCampusVisitType) + '\']')).click()

WebUI.click(findTestObject('Object Repository/HomePageElements/RequesuFilterRadioButton'))

WebUI.delay(3)

driver.findElement(By.xpath(('//div[@class=\'shadow __visit__visit-card__7422f pointer-on-hover ember-view\']//h4[text()=\'' + 
        OffCampusVisitType) + '\']')).click()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/PendingTabInRequestVisit'), 0)

String StudentNameForOffCampus = FirstName + LastName

driver.findElement(By.xpath(('//div[contains(text(),\'' + StudentNameForOffCampus) + '\')]')).isDisplayed()

