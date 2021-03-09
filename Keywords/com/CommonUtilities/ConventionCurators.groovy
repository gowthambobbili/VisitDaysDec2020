package com.CommonUtilities

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper

public class ConventionCurators {
	Random rd= new Random()
	def tagName="tagName"+rd.nextInt(1000)
	@Keyword
	def createTags() {
		def tagsCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionCurators/Tags/GetTagsCount'),0).size()
		
		 println tagsCount

         def count=tagsCount+1

         WebUI.click(findTestObject('Object Repository/ConventionCurators/Tags/AddAnotherTag'))

         Random rd=new Random()

         

         WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/Tags/TagNameField',['count':count]),tagName)

         WebUI.click(findTestObject('Object Repository/ConventionCurators/Tags/Save button'))
		
		 return tagName
	}
}
