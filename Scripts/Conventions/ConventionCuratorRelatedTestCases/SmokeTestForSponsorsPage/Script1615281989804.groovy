import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.CommonUtilities.Verifications
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'),0,FailureHandling.OPTIONAL))
{
   WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

   WebUI.waitForPageLoad(0)
}
WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionSettingsLeftNav'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ConventionCurators/SponsorsLeftNav'))

WebUI.waitForPageLoad(0)

def rootPath="Object Repository/ConventionCurators/Sponsors/"

List elements=["ConventionsponsorsDetail",
	"ConventionSponsorsTitle",
	"SponsorsDetailsLearnCentreLink",
	"AddNewTier"
	]
Verifications verify = new Verifications()
for(element in elements) {
	verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the sponsors page the "+element+" is not present")
}
WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/AddNewTier'))

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/SizeDropDown'))

List elements2=["AddNewTier",
	"AddNewSponsorToTier",
	"ThreeDotMenuOfConventionTier",
	"LargeDisplaySizeOptionInDropDown",
	"LargestDisplaySizeOptionInDropDown",
	"MediumDisplaySizeOptionInDropDown",
	"SmallDisplaySizeOptionInDropDown",
     "SmallestDisplaySizeOptionInDropDown",
	 "SaveButton"
	]
for(element in elements2) {
	verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the create sponsors tier the "+element+" is not present")
}

WebUI.click(findTestObject('Object Repository/ConventionCurators/SponsorsLeftNav'))