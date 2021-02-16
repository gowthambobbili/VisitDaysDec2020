package com.CommonUtilities

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class CreateMobiInstanceWithDiscoveryFilter {
	Random random=new Random()
	def instanceTestName="Testinstance"+random.nextInt(10000)
	@Keyword
	def createMobiInstanceWithDiscoveryFiltersSingleSelect(String DiscoveryFilter1,String DiscoveryFilter2) {
		WebUI.delay(4)
		//		verifications.VerifyElementVisible(findTestObject('Object Repository/HomePageElements/Mobi/Mobi-ScriptLeftNav'), "When click Mobi left nav, the Script nav item is not shown")
		WebUI.click(findTestObject('Object Repository/HomePageElements/Mobi/Mobi-ScriptLeftNav'))
		//		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/CreateButton'), "When click Script left nav, the Create button is not shown")
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/CreateButton'))
		//		verifications.VerifyElementPresentAndStopExecutionIfFailed(findTestObject('Object Repository/MobiPage/Script/DisplayNameTextField'), "Display Name is not present in create instace page")
		WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Script/DisplayNameTextField'), instanceTestName)
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/IndividualsCheckbox'))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/GroupsCheckBox'))
		WebUI.scrollToElement(findTestObject('Object Repository/MobiPage/Script/SelectDropDownOfDiscoveryFilters'),0,FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SelectDropDownOfDiscoveryFilters'))
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/MobiPage/Script/SelectDiscoveryFilters',['DiscoveryName':DiscoveryFilter1]),0,FailureHandling.OPTIONAL)
		WebUI.waitForElementClickable(findTestObject('Object Repository/MobiPage/Script/SelectDiscoveryFilters',['DiscoveryName':DiscoveryFilter1]), 0)
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SelectDiscoveryFilters',['DiscoveryName':DiscoveryFilter1]))
		WebUI.scrollToElement(findTestObject('Object Repository/MobiPage/Script/SelectDiscoveryFilters',['DiscoveryName':DiscoveryFilter2]),0,FailureHandling.OPTIONAL)
		WebUI.waitForElementClickable(findTestObject('Object Repository/MobiPage/Script/SelectDiscoveryFilters',['DiscoveryName':DiscoveryFilter2]), 0)
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SelectDiscoveryFilters',['DiscoveryName':DiscoveryFilter2]))
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/SaveButton'))
		return instanceTestName


	}
}
