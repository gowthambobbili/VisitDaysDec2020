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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By


WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestEventVisitType'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateEventWithRequestVisitType'(VisitType)

WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

WebUI.delay(7)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

//WebUI.waitForElementPresent(findTestObject('Add Attendee/ChooseADateLabelInAddAttendee'), 0)

WebUI.delay(6)

WebUI.click(findTestObject('Object Repository/Add Attendee/EventsOptionInAddAttendee'))

WebUI.delay(6)

driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Added\']')).isDisplayed()

WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))

WebUI.delay(2)

//WebUI.verifyElementText(findTestObject('Add Attendee/VisitTypeNameInPopOver'), VisitType)

WebUI.click(findTestObject('Add Attendee/CloseButtonInMyItineraryPopover'))

WebUI.delay(2)

String flag

String SecondVisitTypeName

//if (WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'), 0, FailureHandling.OPTIONAL)) {
//	SecondVisitTypeName = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameOfFirstAddToMyItineraryButtonInThePage'))
//
//	WebUI.click(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'))
//
//	WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))
//
//	WebUI.delay(2)
//
//	WebUI.verifyElementText(findTestObject('Add Attendee/SecondVisitTypeInMyItineraryPopover'), SecondVisitTypeName, FailureHandling.OPTIONAL)
//
//	flag = 'true'
//}
//
//if (flag == 'true') {
//	WebUI.click(findTestObject('Add Attendee/CloseButtonInMyItineraryPopover'))
//}

WebUI.delay(2)

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))

WebUI.delay(2)

//WebUI.verifyElementText(findTestObject('Add Attendee/VisitTypeNameInPopOver'), VisitType)

if (flag == 'true') {
	WebUI.verifyElementText(findTestObject('Add Attendee/SecondVisitTypeInMyItineraryPopover'), SecondVisitTypeName, FailureHandling.OPTIONAL)
}

WebUI.click(findTestObject('Add Attendee/CloseButtonInMyItineraryPopover'))

WebUI.delay(2)

WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))

//
WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))

//
//if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), 0, FailureHandling.OPTIONAL)) {
//   WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
//}
//
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 0, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

	WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
}

//
WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

//
WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))

//
WebUI.delay(2)

//
//WebUI.verifyElementText(findTestObject('Add Attendee/VisitTypeNameInPopOver'), VisitType)

if (flag == 'true') {
	WebUI.verifyElementText(findTestObject('Add Attendee/SecondVisitTypeInMyItineraryPopover'), SecondVisitTypeName, FailureHandling.OPTIONAL)
}

WebUI.click(findTestObject('Add Attendee/CloseButtonInMyItineraryPopover'))

WebUI.delay(2)

WebUI.click(findTestObject('Add Attendee/BackButtonInMobi'))

WebUI.click(findTestObject('Add Attendee/BackButtonInMobi'))

WebUI.click(findTestObject('Add Attendee/BackButtonInMobi'))

WebUI.click(findTestObject('Add Attendee/BackButtonInMobi'))
WebUI.click(findTestObject('Add Attendee/GroupOptionInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

//WebUI.waitForElementPresent(findTestObject('Add Attendee/ChooseADateLabelInAddAttendee'), 0)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Add Attendee/EventsOptionInAddAttendee'))

WebUI.delay(5)

driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).isDisplayed()

driver.findElement(By.xpath(('//h1[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')).click()

WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))

WebUI.delay(2)

//WebUI.verifyElementText(findTestObject('Add Attendee/VisitTypeNameInPopOver'), VisitType)

WebUI.click(findTestObject('Add Attendee/CloseButtonInMyItineraryPopover'))

WebUI.delay(2)

//=======
String Groupflag

String SecondVisitTypeNameInGroup
//
//if (WebUI.verifyElementPresent(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'), 0, FailureHandling.OPTIONAL)) {
//	SecondVisitTypeNameInGroup = WebUI.getText(findTestObject('Add Attendee/VisitTypeNameOfFirstAddToMyItineraryButtonInThePage'))
//
//	WebUI.click(findTestObject('Add Attendee/AddToMyItineraryRandomButtonInMobi'))
//
//	WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))
//
//	WebUI.delay(2)
//
//	WebUI.verifyElementText(findTestObject('Add Attendee/SecondVisitTypeInMyItineraryPopover'), SecondVisitTypeNameInGroup,
//		FailureHandling.OPTIONAL)
//
//	Groupflag = 'true'
//
//	WebUI.click(findTestObject('Add Attendee/CloseButtonInMyItineraryPopover'))
//}

WebUI.delay(2)

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

//WebUI.click(findTestObject('Add Attendee/MyItineraryPopOver'))

WebUI.delay(2)

//WebUI.verifyElementText(findTestObject('Add Attendee/VisitTypeNameInPopOver'), VisitType)

//if (Groupflag == 'true') {
//	WebUI.verifyElementText(findTestObject('Add Attendee/SecondVisitTypeInMyItineraryPopover'), SecondVisitTypeNameInGroup,
//		FailureHandling.OPTIONAL)
//}

CustomKeywords.'com.CommonUtilities.Quit.QuitMobi'()

