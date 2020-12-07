package com.CommonUtilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import groovy.json.JsonSlurper as JsonSlurper

class ApiCalls {

	JsonSlurper js = new JsonSlurper()
	Random random = new Random()
	Times times = new Times()

	@Keyword
	def GetAccessToken() {
		def ResObject = WS.sendRequest(findTestObject('API Requests/TokenPostRequest'))
		def ResponseBody = ResObject.responseBodyContent
		JsonSlurper js = new JsonSlurper()
		def TokenRes = js.parseText(ResponseBody)
		def token = TokenRes.jwt
		println(token)
		return token
	}

	@Keyword
	def GetItineraryIdOfstudentRegisteredToAvisit(String VisitId){
		def token = GetAccessToken()
		def ResObject = WS.sendRequest(findTestObject('API Requests/GeetItineraryIdUsingVisitId', ["token":token, "VisitId":VisitId]))
		def ResponseBody = ResObject.responseBodyContent
		def StudentData = js.parseText(ResponseBody)
		println StudentData
		def ItineraryId = StudentData.data[0].attributes.itinerary_id
		println ItineraryId
		return ["token":token, "ItineraryId":ItineraryId]
	}

	@Keyword
	GetSurveyCode(Map VisitDetails){

		def ItineraryId = VisitDetails.ItineraryId
		def token = VisitDetails.token
		def ResponseBody = WS.sendRequest(findTestObject('API Requests/GetSurveyCodeV2', ["ItineraryId":ItineraryId, "token":token])).responseBodyContent
		return js.parseText(ResponseBody).code
	}



	@Keyword
	createVisitTypeUsingApi(){

		def token = getAccessToken()
		println token
		def visitType = "Visit"+random.nextInt(100000)
		println visitType
		def creteVisittypeResponse = WS.sendRequest(findTestObject('Object Repository/API Requests/VisitTypes/CreateVisitType', ["token":token, "visitype":visitType]))
		def stringResponse = creteVisittypeResponse.getResponseBodyContent()
		println stringResponse
		def jsonResponse = js.parseText(stringResponse)
		def visitTypeId = jsonResponse.data.id
		return ["visitType":visitType, "visitTypeId":visitTypeId]
	}

	@Keyword
	getAccessToken(){

		def response = WS.sendRequest(findTestObject('Object Repository/API Requests/TokenPostRequest'))
		def responseBody = response.getResponseBodyContent()
		println responseBody
		def jsonBody = js.parseText(responseBody)
		def token = jsonBody.jwt
		return token
	}

	@Keyword
	createVisitUsingApi(String visitTypeId){

		def token = GetAccessToken()
		def startDate =  times.AddOrSubtractDatesAndReturnInreequiredFormat(1, "yyyy-MM-dd")
		def startTime =  times.AddOrSubtractDatesAndReturnInreequiredFormat(1, "EEE MMM dd yyyy")
		def endDate =  times.AddOrSubtractDatesAndReturnInreequiredFormat(3, "yyyy-MM-dd")
		def endTime =  times.AddOrSubtractDatesAndReturnInreequiredFormat(3, "EEE MMM dd yyyy")
		//		def visitTypeId = createVisitTypeUsingApi().visitTypeId
		def response = WS.sendRequest(findTestObject('Object Repository/API Requests/Visits/CreateVisit', ["token":token, "startDate":startDate, "startTime":startTime, "endDate":endDate, "endTime":endTime, "visitTypeId":visitTypeId]))
		println response.getResponseBodyContent()
		def responsebody = response.getResponseBodyContent()
		return js.parseText(responsebody).data.id
	}


	@Keyword
	def registerIndividual(Map details) {

		def token = GetAccessToken()
		def firstName = "Test"+random.nextInt(1000000)
		def lastName = "user"
		def email = firstName+"@gmail.com"
		Map registrationDetails = [:]
		if(details.containsKey("firstName")) {
			registrationDetails.put("firstName", details.get("firstName"))
		}
		else {
			registrationDetails.put("firstName", firstName)
		}

		if(details.containsKey("lastName")) {
			registrationDetails.put("lastName", details.get("lastName"))
		}
		else {
			registrationDetails.put("lastName", lastName)
		}

		if(details.containsKey("email")) {
			registrationDetails.put("email", details.get("email"))
		}
		else {
			registrationDetails.put("email", email)
		}

		if(details.containsKey("phoneNumber")) {
			registrationDetails.put("phoneNumber", details.get("phoneNumber"))
		}
		else {
			registrationDetails.put("phoneNumber", "5555555555")
		}

		if(details.containsKey("applicantStatus")) {
			registrationDetails.put("applicantStatus", details.get("applicantStatus"))
		}
		else {
			registrationDetails.put("applicantStatus", "applied")
		}

		if(details.containsKey("enrollmentYear")) {
			registrationDetails.put("enrollmentYear", details.get("enrollmentYear"))
		}
		else {
			registrationDetails.put("enrollmentYear", "2023")
		}

		registrationDetails.put("visitId", details.get("visitId"))
		registrationDetails.put("visitTypeId", details.get("visitTypeId"))
		registrationDetails.put("token", token)

		def Response = WS.sendRequest(findTestObject('Object Repository/API Requests/Registrations/Individual', registrationDetails))

		def responsebody = Response.getResponseBodyContent()
		println responsebody
		def jsonResponse = js.parseText(responsebody)
		def calendarLink = jsonResponse.data.attributes.calendar_link
		def surveyCode = calendarLink.split("itineraries/")[1].split("/calendar")[0]
		def itineraryId = jsonResponse.data.id
		println itineraryId
		return ["surveyCode":surveyCode, "itineraryId":itineraryId]
	}
}