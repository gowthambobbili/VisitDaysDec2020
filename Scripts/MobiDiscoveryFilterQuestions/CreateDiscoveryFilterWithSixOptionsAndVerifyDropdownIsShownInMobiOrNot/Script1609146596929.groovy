import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType1 = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType1)

WebUI.delay(3)

String VisitType2 = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(VisitType2)

WebUI.click(findTestObject('Object Repository/HomePageElements/MobiLeftNav'))

WebUI.click(findTestObject('Object Repository/DiscoveryFilters/DiscoveryFiltersLeftNav'))

String discoveryFilterName=CustomKeywords.'com.CommonUtilities.CreateDiscoveryFilter.createDiscoveryFilterWithMoreThanFiveOptions'(VisitType1, VisitType2)

def option1="Option1"

def option2="Option2"

String discoveryMobiInstanceName=CustomKeywords.'com.CommonUtilities.CreateMobiInstanceWithDiscoveryFilter.createMobiInstanceWithDiscoveryFiltersSingleSelect'(discoveryFilterName)

WebUI.delay(5)

CustomKeywords.'com.CommonUtilities.DiscoveryFilterPreview.clickPreviewButtonOfCreatedDiscoveryFilter'(discoveryMobiInstanceName)

CustomKeywords.'com.CommonUtilities.DiscoveryFilterPreview.DiscoveryFilterPreviewMobiHandlingDropType'(option1,VisitType1,discoveryFilterName)

CustomKeywords.'com.CommonUtilities.Quit.ExitMobi'()