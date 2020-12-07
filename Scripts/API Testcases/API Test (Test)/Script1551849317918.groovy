import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.http.client.HttpClient as HttpClient
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return as object_return
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
import groovy.json.JsonSlurper as JsonSlurper

//String var = '2'
//Responce =  WS.sendRequest(findTestObject('API Requests/TokenPostRequest'))
//String ResBodyContent = Responce.getResponseBodyContent()
//println ResBodyContent
//def jsonSlurper = new JsonSlurper()
//def ParsedData = jsonSlurper.parseText(ResBodyContent)
//println ParsedData.data[1].first_name
//jwt
Responce = WS.sendRequest(findTestObject('API Requests/TokenPostRequest'))

String ResBodyContent = Responce.getResponseBodyContent()

println(ResBodyContent)

def jsonSlurper = new JsonSlurper()

def ParsedData = jsonSlurper.parseText(ResBodyContent)

println(ParsedData.jwt)

String token = ParsedData.jwt

String name = 'suresh'

token = ('Bearer ' + token)

println(token)

GlobalVariable.TestVar = 'soemthing@gmail.com'

//RequestObject ro = new RestRequestObjectBuilder()
secondResponce = WS.sendRequest(findTestObject('API Requests/ItineraryGetRequest'))

println(secondResponce.getStatusCode())

String seResBodyContent = secondResponce.getResponseBodyContent()

println(seResBodyContent)

def ItineraryResponce = jsonSlurper.parseText(seResBodyContent)

String ItineraryId = ItineraryResponce.data.id

println(ItineraryId)

String itinerary_id = ':' + ItineraryId
token = ('Bearer ' + token)
SurveyRespoce = WS.sendRequest(findTestObject('API Requests/SurveyCodeGetRequest'))

println(SurveyRespoce.getStatusCode())

println(SurveyRespoce.getResponseBodyContent())


