import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithInprogressTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

String Individual = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def IndividualProfile = new TestObject('Registered Individual Student')

IndividualProfile.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + 
    Individual) + '\']')

WebUI.verifyElementPresent(IndividualProfile, 0)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)


CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType2= CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithInPastTimes'(VisitType2)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/HomePageElements/Visits/DailyVisitsLeftNav'))

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.delay(4)

def ThreeDotMenu = new TestObject('Three Dot Menu Of Registered Individual Student In Registered Tab')

ThreeDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Individual) + '\']/../..//i[text()=\'more_vert\']')

WebUI.click(ThreeDotMenu)

WebUI.waitForElementVisible(findTestObject('Object Repository/DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'),0)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
	0, FailureHandling.OPTIONAL)))
{
		KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')
	
		WebUI.takeScreenshot()
}
	
WebUI.delay(2)
	
WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'))

WebUI.sendKeys(findTestObject('Object Repository/DailyVisitsPage/SearchboxinAddVisitToItineraryModal'),VisitType2)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/SinglecheckboxInAddVisitToItineraryModal'))

if (!(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/Registered/ContinueButtonInAddVisitToItineraryModal'),
	0, FailureHandling.OPTIONAL)))
{
		KeywordUtil.markFailed('Continue button is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')
	
		WebUI.takeScreenshot()
}
WebUI.click(findTestObject('Object Repository/DailyVisitsPage/Registered/ContinueButtonInAddVisitToItineraryModal'))

WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'), 0)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'))
	
