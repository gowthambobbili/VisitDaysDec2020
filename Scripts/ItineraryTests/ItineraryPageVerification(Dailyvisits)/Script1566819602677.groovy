import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.geom.Arc2D.Float

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

Map AccountBasicsDetails = CustomKeywords.'com.CommonUtilities.ItineraryPage.GetDataFromAccountbasics'()

Map LocationDetails = CustomKeywords.'com.CommonUtilities.ItineraryPage.GetDataFromLocation'()

def name = LocationDetails.LocationName



def VisitDetails = WebUI.callTestCase(findTestCase('API Testcases/RegisterAUserAndGetSurveyCode'), [('SurveyLink') : 'https://metapod-student.visitdays.com/bbtesting/surv/\r\n'],
FailureHandling.STOP_ON_FAILURE)


def SurveyCode = VisitDetails["SurveyCode"]
def VisitType = VisitDetails["VisitType"]
def StudentName = VisitDetails["StudentName"]

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/HomePageElements/VisitsLeftNav'))

WebUI.click(findTestObject('Object Repository/HomePageElements/Visits/DailyVisitsLeftNav'))

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'), "When click On visit in index page, the visit details tab is not shown")

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/DetailsTabInDailyVisitsPage'))

//def VisitDateAndTime = WebUI.getText(findTestObject('Object Repository/DailyVisitsPage/Details Page/DateAndTimeOnTopVisitCard')).trim()

def LocationInDetailsPage = WebUI.getText(findTestObject('Object Repository/DailyVisitsPage/Details Page/LocationInLocationDivision')).trim()

WebUI.navigateToUrl(GlobalVariable.StudentAppUrl+GlobalVariable.Institution+"/itineraries/"+SurveyCode)

def CompleteData = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getFutureDateTime'(1, null, "EEEE, MMMM dd, yyyy").toString()

def VisitDate = Integer.parseInt(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getFutureDateTime'(1, null, "dd"))

def DateSuffix = CustomKeywords.'com.CommonUtilities.ItineraryPage.DateSuffix'(VisitDate)

def FinalDate = CompleteData.split(',')

FinalDate = FinalDate[0]+", "+FinalDate[1]+DateSuffix+", "+FinalDate[2]

println FinalDate

CustomKeywords.'com.CommonUtilities.ItineraryPage.VerifyItineraryPage'(AccountBasicsDetails, VisitDate, VisitType)

	



/*
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Object Repository/ItineraryPage/VisitType(visittype)', ["visittype":VisitType]), "When navigated to the Itinerary page of the student '"+StudentName+"' the Visit type is not shown in the page (Expected visit  type: )"+VisitType)
 def VisitTime = WebUI.getText(findTestObject('Object Repository/ItineraryPage/TimeOfSpecificVisitType(visittype)', ["visittype":VisitType]))
 println VisitTime
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(VisitTime, "8:00 AM - 9:00 AM", "In the itinerary page the time of visit is shown incorrect. Actual: "+VisitTime+", Expected: '8:00 AM - 9:00 AM'")
 println CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getFutureDateTime'(1, null, "wwww, MMMM dd, yyyy")
 //Friday, August 23rd, 2019
 def VisitTypeInItineraryPage = WebUI.getText(findTestObject('Object Repository/ItineraryPage/VisitType(visittype)', ["visittype":VisitType]))
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/ItineraryPage/VisitType(visittype)', ["visittype":VisitType]), "The visit type "+VisitType +" is not shown in then itinerary page")
 WebUI.click(findTestObject('Object Repository/ItineraryPage/VisitType(visittype)', ["visittype":VisitType]))
 */








