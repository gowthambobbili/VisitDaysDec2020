import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType1 = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType1)

String VisitType2 = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(VisitType2)

WebUI.click(findTestObject('Object Repository/HomePageElements/MobiLeftNav'))

WebUI.click(findTestObject('Object Repository/DiscoveryFilters/DiscoveryFiltersLeftNav'))

def discoveryFilterName=CustomKeywords.'com.CommonUtilities.CreateDiscoveryFilter.createDiscvoreyFilterWithVisitTypesRadioType'(VisitType1, VisitType2)

WebUI.click(findTestObject('Object Repository/DiscoveryFilters/EditButtonOfcreatedDiscoveryFilter',['CREATEDDISCOVERYFILTER':discoveryFilterName]))

WebUI.waitForPageLoad(0)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/DiscoveryFilters/ThreeDotMenuOfCreatedFilter'),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("three dot menu is not shown")
}
WebUI.click(findTestObject('Object Repository/DiscoveryFilters/ThreeDotMenuOfCreatedFilter'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/DiscoveryFilters/DeleteDiscoveryFilter'))

WebUI.delay(5)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/DiscoveryFilters/VerifyCretaedDiscoveryFilter',['CREATEDDISCOVERYFILTER':discoveryFilterName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("discovery filter is not deleted after clicking on delete discovery filter")
}