package com.CommonUtilities

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class CreateDiscoveryFilter {
	Random rd=new Random()
	def questionNo=rd.nextInt(10000)
	def discoveryFilterName="Discoveryfilter"+questionNo
	@Keyword
	def createDiscvoreyFilterWithVisitTypesRadioType(String VisitType1,String VisitType2) {
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/CreateNewDiscoveryFilterButton'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/FilterLabelName'),discoveryFilterName)
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/FirstAnswerChoiceText'),'Option1')
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/ExpandButtonToViewSpecificVisitTypesChoiceOne'))
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/SelectVisitTypesForOption1',['VISITTYPE':VisitType1]), 0, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/SelectVisitTypesForOption1',['VISITTYPE':VisitType1]))
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/SecondAnswerChoiceText'),'Option2')
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/ExpandButtonToViewSpecificVisitTypesChoiceTwo'))
		WebUI.delay(4)
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/SelectVisitTypesForOptionTwo',['VISITTYPE':VisitType2]),0,FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/SelectVisitTypesForOptionTwo',['VISITTYPE':VisitType2]))
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/Save button'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/DiscoveryFiltersLeftNav'))
		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/DiscoveryFilters/VerifyCretaedDiscoveryFilter',['CREATEDDISCOVERYFILTER':discoveryFilterName]),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("discovery filter is not created or created discovery filter is not shown in list")
		}
		return discoveryFilterName
	}
	@Keyword
	def createDiscoveryFilterWithVisitTypesMultiSelectType(String VisitType1,String VisitType2) {
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/CreateNewDiscoveryFilterButton'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/FilterLabelName'),discoveryFilterName)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AllowSelectingMultipleAnswersCheckBox'))
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/FirstAnswerChoiceText'),'Option1')
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/ExpandButtonToViewSpecificVisitTypesChoiceOne'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/SelectVisitTypesForOption1',['VISITTYPE':VisitType1]))
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/SecondAnswerChoiceText'),'Option2')
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/ExpandButtonToViewSpecificVisitTypesChoiceTwo'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/SelectVisitTypesForOptionTwo',['VISITTYPE':VisitType2]))
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/Save button'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/DiscoveryFiltersLeftNav'))
		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/DiscoveryFilters/VerifyCretaedDiscoveryFilter',['CREATEDDISCOVERYFILTER':discoveryFilterName]),0,FailureHandling.OPTIONAL))) {
			KeywordUtil.markFailed("discovery filter is not created or created discovery filter is not shown in list")
		}
		return discoveryFilterName
	}
	@Keyword
	def createDiscoveryFilterWithMoreThanFiveOptions(String VisitType1,String VisitType2) {
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/CreateNewDiscoveryFilterButton'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/FilterLabelName'),discoveryFilterName)
		//		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AllowSelectingMultipleAnswersCheckBox'))
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/FirstAnswerChoiceText'),'Option1')
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/ExpandButtonToViewSpecificVisitTypesChoiceOne'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/SelectVisitTypesForOption1',['VISITTYPE':VisitType1]))
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/SecondAnswerChoiceText'),'Option2')
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/ExpandButtonToViewSpecificVisitTypesChoiceTwo'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/SelectVisitTypesForOptionTwo',['VISITTYPE':VisitType2]))
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AddAnswerChoice'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/ThirdAnswerChoiceText'),'Option3')
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/AllCurrentAndFutureVisitTypesOption3'),0)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AllCurrentAndFutureVisitTypesOption3'))
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/AddAnswerChoice'),0)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AddAnswerChoice'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/FourthAnswerChoiceText'),'Option4')
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/AllCurrentAndFutureVisitTypesOption4'),0)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AllCurrentAndFutureVisitTypesOption4'))
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/AddAnswerChoice'),0)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AddAnswerChoice'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/FifthAnswerChoiceText'),'Option5')
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/AllCurrentAndFutureVisitTypesOption5'),0)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AllCurrentAndFutureVisitTypesOption5'))
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/AddAnswerChoice'),0)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AddAnswerChoice'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/DiscoveryFilters/SixthAnswerChoiceText'),'Option6')
		WebUI.scrollToElement(findTestObject('Object Repository/DiscoveryFilters/AllCurrentAndFutureVisitTypesOption6'),0)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/AllCurrentAndFutureVisitTypesOption6'))
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/Save button'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DiscoveryFilters/DiscoveryFiltersLeftNav'))
		if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/DiscoveryFilters/VerifyCretaedDiscoveryFilter',['CREATEDDISCOVERYFILTER':discoveryFilterName]),0,FailureHandling.OPTIONAL)))
		{
			KeywordUtil.markFailed("discovery filter is not created or created discovery filter is not shown in list")
		}
		return discoveryFilterName
	}
}
