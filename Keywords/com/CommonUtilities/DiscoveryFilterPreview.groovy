package com.CommonUtilities

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class DiscoveryFilterPreview {
	@Keyword
	def clickPreviewButtonOfCreatedDiscoveryFilter(String discoveryFilterName) {
		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/MobiPage/Script/PreviewButtonOfDiscoveryFilter',['DiscoveryInstanceName':discoveryFilterName]),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("created mobi instance with discovery filters is not present in admin app")
		}
		WebUI.click(findTestObject('Object Repository/MobiPage/Script/PreviewButtonOfDiscoveryFilter',['DiscoveryInstanceName':discoveryFilterName]))
	}
	@Keyword
	def DiscoveryFilterPreviewMobiHandlingDropType(String Option,String VisitType,String DiscoveryFilterName) {
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForPageLoad(0)

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DiscoveryHeaderInMobi'),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("Discovery filter modal is not shown in mobi page")
		}

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/VerifyDiscoveryFilterNameDropDownType',['DiscoveryFilter':DiscoveryFilterName]),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("created discovery filter is not shown in mobi page")
		}


		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DropDownInDiscoveryFiltersMobi'),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("Dropdown filter options are not shown in mobi page")
		}
	}
	@Keyword
	def DiscoveryFilterPreviewMobiHandlingmultiselecttype(String Option,String VisitType) {
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForPageLoad(0)

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DiscoveryHeaderInMobi'),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("Discovery filter modal is not shown in mobi page")
		}

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DiscoveryFilterWithMultiSelectTypeOptions'),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("Discovery filter options with multiselect are not shown in mobi page")
		}
	}
	@Keyword
	def ReorderDiscoveryFiltersVerification(String question1,String question2) {
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForPageLoad(0)

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DiscoveryHeaderInMobi'),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("Discovery filter modal is not shown in mobi page")
		}
		String questionOneRawText=WebUI.getText(findTestObject('Object Repository/DiscoveryFilters/QuestionOneTextFromMobi'))

		String questionTwoRawText=WebUI.getText(findTestObject('Object Repository/DiscoveryFilters/QuestionTwoTextFromMobi'))

		println questionOneRawText

		println questionTwoRawText

		println question1

		println question2

		//		String questionOne=question1.toLowerCase()

		//		String questionTwo=question2.toLowerCase()

		if(!(questionOneRawText.contains(question1)))
		{
			KeywordUtil.markFailed("Reorder of discovery filter questions is not done")
		}
		if(!(questionTwoRawText.contains(question2)))
		{
			KeywordUtil.markFailed("Reorder of discovery filter questions is not done")
		}
	}
	@Keyword
	def DiscoveryFilterPreviewMobiHandling(String Option,String VisitType) {
		WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

		WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

		WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForPageLoad(0)

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DiscoveryHeaderInMobi'),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("Discovery filter modal is not shown in mobi page")
		}

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DiscoveryFilterOptionSelect',['OPTIONNAME':Option]),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("Discovery filter options are not shown in mobi page")
		}

		WebUI.click(findTestObject('Object Repository/Add Attendee/DiscoveryFilterOptionSelect',['OPTIONNAME':Option]))

		WebUI.click(findTestObject('Object Repository/Add Attendee/DiscoveryFilterOptionSelectTwo',['OPTIONNAME':Option]))

		WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

		WebUI.waitForPageLoad(0)

		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/VerifyCreatedVisitsInMobi',['CreatedVisit':VisitType]),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("options having visits are not shown in mobi")
		}
	}
}
