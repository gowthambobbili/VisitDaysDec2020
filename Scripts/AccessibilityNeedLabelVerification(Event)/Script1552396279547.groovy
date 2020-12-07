import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateEventWithInFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'),
		'Add Registrant button is not present in daily visit page')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

//update555
//String Individual = CustomKeywords.'com.CommonUtilities.NewMobiRegistration.registerIndividualDirectlyFromVisit'(["accessibility":"true"])
//CustomKeywords.'com.CommonUtilities.NewMobiRegistration.switchToDefaultContent'()

String Individual = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'('Accessibility')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/Registered/AccessibilityRequestLabelInRegisteredTab'),
		'While regisering a individual, if user select the accessibility need then the \'Accessibility Request\' label is not present')

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

def AccessibilityLabel = new TestObject('Accessibility request label on visit card in index page')

AccessibilityLabel.addProperty('xpath', ConditionType.EQUALS, ('(//h4[contains(text(),\'' + VisitType) + '\')])[1]/../../..//span[text()=\'Accessibility Request\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(AccessibilityLabel, 'Accessibility Request label is not shown on the visit card in Index page')

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

def IndividualStudent = new TestObject('Registered individual in registered tab')

IndividualStudent.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' +
		Individual) + '\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(IndividualStudent, 'The registered individual is not shown in  the registered tab')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/ProfileAvatar'),
		'Profie dropdown is not shown in the visit page')

WebUI.click(findTestObject('Object Repository/HomePageElements/ProfileAvatar'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/ElementsUnderProfileAvatar/MyProfileOption'),
		'My profile option is not present in profile dropdown')

WebUI.click(findTestObject('Object Repository/ElementsUnderProfileAvatar/MyProfileOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/StudentNameInUserProfile'), 0)

String AdminName = WebUI.getText(findTestObject('Object Repository/UserProfile/StudentNameInUserProfile'))

WebUI.clickOffset(findTestObject('Object Repository/UserProfile/OffsetFromUserprofile'), 10, 10)

WebUI.delay(3)

WebUI.click(IndividualStudent)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/UserProfile/FirstVisitInUserProfileVisits'),
		'When clicked on the user in Registered tab, the user visits are not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/UserProfile/AccessibilityRequestHeader'),
		'When user requests Accessibility, the \'Accessibility Request\' header is not present in the user profile')

String AccessibilityDescription = WebUI.getText(findTestObject('Object Repository/UserProfile/AccessibilityrequestDescription'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(AccessibilityDescription, 'Test description', ('The accessibility description is shown in correct in the user profile(Expected: Test description, Actual: ' +
		AccessibilityDescription) + ')')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('UserProfile/ConfirmButtonInAccessibilityrequestDivision'),
		'Confirm button is not present in Accessibility Request division')

not_run: ButtonColor = WebUI.getAttribute(findTestObject('UserProfile/ConfirmButtonInAccessibilityrequestDivision'), 'background-color')

WebUI.click(findTestObject('UserProfile/ConfirmButtonInAccessibilityrequestDivision'))

WebUI.waitForElementVisible(findTestObject('UserProfile/AccessibilityRequestChechboxInAccessibilityRequestModal'), 0)

WebUI.click(findTestObject('UserProfile/AccessibilityRequestChechboxInAccessibilityRequestModal'))

/*
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ButtonColor, ConfirmButtonColor, ('Confirm button is not shown in expected color (Expected: '+ConfirmButtonColor+', Actual: ' +
 ButtonColor) + ')')
 */
WebUI.click(findTestObject('Object Repository/DailyVisitsPage/Registered/ConfirmButtonInAccessibilityRequestModal'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('UserProfile/ConfirmButtonInAccessibilityrequestDivision'),
		'When clicked Confirm button in Accessibility Request modal the button is not getting disappeared')

String StatusMessage = WebUI.getText(findTestObject('UserProfile/StatusFieldInUserProfile'))

println(StatusMessage)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(StatusMessage, (('check\n' + AdminName) + ' ') + 'confirmed',
		'When admin accepts the accessibility request, the confirmation message is shown incorrect')

WebUI.clickOffset(findTestObject('Object Repository/UserProfile/OffsetFromUserprofile'), 10, 10)

def AccessibilityAcceptedLabel = new TestObject('Accessibility Confirmed label in registered tab')

AccessibilityAcceptedLabel.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Individual) + '\']/../..//span[text()=\'Accessibility Confirmed\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(AccessibilityAcceptedLabel,
		'When admin confirms the accessibility, the Accessibility Confirmed label is not shown on the student registratioin in registered tab')

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

AccessibilityLabel.addProperty('xpath', ConditionType.EQUALS, ('(//h4[contains(text(),\'' + VisitType) + '\')])[1]/../../..//span[text()=\'Accessibility Confirmed\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(AccessibilityLabel, 'When admin confirms the accessibility, the Accessibility Confirmed label is not shown on the visit card in the index page')

