import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass as CustomKeywordDelegatingMetaClass
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder as RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.VisitTypeCreationUserflow.CreateVisitTypeWithSpecifiedValues'(["WaysToMeet":"Phone"])

//CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithInprogresSameStartAndEndTimes'(VisitType, GlobalVariable.temp)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

String TokenEndPoint = GlobalVariable.TokenEndPoint

String TokenRequestMethod = 'POST'

String TokenRequestBody = '{"auth":{"email":"test.user1+itinerarycodefetcher@qualitlabs.com","password":"sample123"}}'

TestObjectProperty TokenHeader = new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json')

ArrayList TokenHeadersList = Arrays.asList(TokenHeader)

RequestObject TokenRequest = new RequestObject('Token requeset')

TokenRequest.setRestUrl(TokenEndPoint)

TokenRequest.setRestRequestMethod(TokenRequestMethod)

TokenRequest.setHttpHeaderProperties(TokenHeadersList)

TokenRequest.setBodyContent(new HttpTextBodyContent(TokenRequestBody))

String CurrentUrl = WebUI.getUrl()

String VisitId = CurrentUrl.split('visits/')[1]

Responce = WS.sendRequest(TokenRequest)

String ResBodyContent = Responce.getResponseBodyContent()

println(ResBodyContent)

def jsonSlurper = new JsonSlurper()

def ParsedData = jsonSlurper.parseText(ResBodyContent)

println(ParsedData.jwt)

String token = ParsedData.jwt

token = ('Bearer ' + token)

println(token)

String endpoint = GlobalVariable.RegistrationEndPoint

String requestMethod = 'POST'

String Institution = GlobalVariable.Institution

//String Institution = 'albright'
TestObjectProperty header1 = new TestObjectProperty('Accept', ConditionType.EQUALS, 'application/vnd.api+json')

TestObjectProperty header2 = new TestObjectProperty('Authorization', ConditionType.EQUALS, token)

TestObjectProperty header3 = new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json')

TestObjectProperty header4 = new TestObjectProperty('Institution', ConditionType.EQUALS, Institution)

TestObjectProperty header5 = new TestObjectProperty('Origin', ConditionType.EQUALS, GlobalVariable.StagingUrl)

TestObjectProperty header6 = new TestObjectProperty('Referer', ConditionType.EQUALS, GlobalVariable.ReferHeader)

TestObjectProperty header7 = new TestObjectProperty('User-Agent', ConditionType.EQUALS, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36')

ArrayList defaultHeaders = Arrays.asList(header1, header2, header3, header4, header5, header6, header7)

Random rand = new Random()

String Email = ('testemail' + rand.nextInt(10000)) + '@test.com'

String FirstName = 'Test' + rand.nextInt(10000)

String body = ((((((((((('{\n  "data": {\n    "attributes": {\n      "registration_type": "individual",\n      "num_guests": 1,\n      "accessibility_needed": false,\n      "accessibility_description": null,\n      "first_name": ' +
		'"') + FirstName) + '"') + ',\n"last_name": "test",\n"email": ') + '"') + Email) + '"') + ',\n"email_is_parent": false,\n"cell_phone_number": "3443534534",\n"cell_phone_is_parent": false,\n"birthdate": "2004-05-05T04:00:00.000Z",\n"address": " Nizampet Road",\n"address_line_two": null,\n"country": "India",\n"city": "Hyderabad",\n"state": "Telangana",\n"zip": "500072",\n"enrollment_status": "not_applied",\n"student_type": "transfer",\n"enrollment_year": "2023",\n"school": {\n\t"id": "22137",\n\t"type": "school",\n\t"attributes": {\n\t\t"name": "Followers Of Jesus School",\n\t\t"city": "Brooklyn",\n\t\t"state": "NY",\n\t\t"zipcode_d": "11208"\n\t}\n},\n"calendar_link": null,\n"group_id": null,\n"checked_in": false,\n"keyword": null,\n"custom_question_responses": [\n\tnull,\n\tnull,\n\t{\n\t\t"questionId": "6285",\n\t\t"questionOptionId": "11678"\n\t},\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull,\n\tnull\n],\n"channel": null,\n"user_type": "student"\n},\n"relationships": {\n"institution_user_programs": {\n\t"data": [\n\t\t{\n\t\t\t"type": "programs",\n\t\t\t"id": "10470"\n\t\t}\n\t]\n},\n"visits": {\n\t"data": [\n\t\t{\n\t\t\t"type": "visits",\n\t\t\t"id": ') +
		'"') + VisitId) + '"') + '\n\t\t}\n\t]\n}\n},\n"type": "registrations"\n}\n}'

/**
 * POST requests to get Itinerary ID
 */
RequestObject ro = new RequestObject('objectId')

ro.setRestUrl(endpoint)

ro.setHttpHeaderProperties(defaultHeaders)

ro.setRestRequestMethod('POST')

ro.setBodyContent(new HttpTextBodyContent(body))

ResponseObject respObj = WS.sendRequest(ro)

String StringrespObj = respObj.getResponseBodyContent()

println(StringrespObj)

def ItineraryResponce = jsonSlurper.parseText(StringrespObj)

String ItineraryId = ItineraryResponce.data.id

println(ItineraryId)

//============= Get request to get the survey code==================//
String endpointForSurveyCode = (GlobalVariable.SurveyCodeEndPoint + ItineraryId) + '/mock_send_survey'

String requestMethodForSurveyCode = 'GET'

TestObjectProperty header1ForSurveyCode = new TestObjectProperty('Authorization', ConditionType.EQUALS, token)

TestObjectProperty header3ForSurveyCode = new TestObjectProperty('Accept', ConditionType.EQUALS, 'application/json')

ArrayList defaultHeadersForSurveyCode = Arrays.asList(header1, header2)

/**
 * GET requests to get final Survey code
 */
RequestObject roForSurveyCode = new RequestObject('SurveyCode')

roForSurveyCode.setRestUrl(endpointForSurveyCode)

roForSurveyCode.setHttpHeaderProperties(defaultHeadersForSurveyCode)

roForSurveyCode.setRestRequestMethod(requestMethodForSurveyCode)

ResponseObject respObjForSurveyCode = WS.sendRequest(roForSurveyCode)

String StringrespObjForSurveyCode = respObjForSurveyCode.getResponseBodyContent()

println(StringrespObjForSurveyCode)

def SurveCodeResponce = jsonSlurper.parseText(StringrespObjForSurveyCode)

//String ItineraryId = ItineraryResponce.data.id
String SurveyCode = SurveCodeResponce.code

println(SurveyCode)

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/CheckInButton'),
//		'The registration is failed')
if(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/CheckInButton'), 5, FailureHandling.OPTIONAL))
{
	WebUI.click(findTestObject('Object Repository/DailyVisitsPage/CheckInButton'))
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/CheckInButton'),
		'When clicked the Check in button the button is still shown')
//WebUI.delay(60)

WebUI.navigateToUrl(GlobalVariable.SurveyLink + SurveyCode)

def details = ["StudentName":FirstName+' test', "CurrentUrl":CurrentUrl, "VisitType":VisitType, "SurveyCode":SurveyCode]

return details
