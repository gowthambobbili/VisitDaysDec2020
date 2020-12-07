package com.CommonUtilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class VideoLibrary {
	Random r1=new Random()
	def num=r1.nextInt(1000)
	def videoName="a video"+num
	def videoAddress="https://youtu.be/tVlz6lYxGX8"
	@Keyword
	def addVideoToVideoLibrary() {
		WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

		WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink',['ConventionProvider':GlobalVariable.ConventionProvider]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/VideoLibraryLeftnav'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AddButtonInVideoLibraryPage'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/VideoName'), 0, FailureHandling.STOP_ON_FAILURE)

		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/VideoName'),videoName)

		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/YoutubetextField'),videoAddress)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/saveButtonInVideo'))

		return videoName
	}
	def getInstitutionName() {
		def institutionfullName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/SelectInstitutionName'))

		println institutionfullName

		def deleteName="swap_horiz"

		def institutionAfterDelete=institutionfullName.replace(deleteName,"")

		def institutionName=institutionAfterDelete.trim()

		println institutionName

		//		def institutionName=institutionfullName.substring(0, 10)

		return institutionName
	}
}
