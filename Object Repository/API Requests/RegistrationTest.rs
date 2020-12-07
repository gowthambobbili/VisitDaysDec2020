<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>RegistrationTest</name>
   <tag></tag>
   <elementGuidId>592cee4f-2cdd-4d91-aad9-bb7a4c78d203</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\&quot;data\&quot;:{\&quot;attributes\&quot;:{\&quot;registration_type\&quot;:\&quot;individual\&quot;,\&quot;num_guests\&quot;:4,\&quot;accessibility_needed\&quot;:false,\&quot;accessibility_description\&quot;:null,\&quot;first_name\&quot;:\&quot;\u0027+FirstName+\u0027\&quot;,\&quot;last_name\&quot;:\&quot;Test\&quot;,\&quot;email\&quot;:\&quot;\u0027+Email+\u0027\&quot;,\&quot;email_is_parent\&quot;:false,\&quot;cell_phone_number\&quot;:\&quot;5555555555\&quot;,\&quot;cell_phone_is_parent\&quot;:false,\&quot;birthdate\&quot;:\&quot;2005-04-04T04:00:00.000Z\&quot;,\&quot;address\&quot;:\&quot;12340 Boggy Creek Road\&quot;,\&quot;address_line_two\&quot;:null,\&quot;country\&quot;:\&quot;United States\&quot;,\&quot;city\&quot;:\&quot;Orlando\&quot;,\&quot;state\&quot;:\&quot;FL\&quot;,\&quot;zip\&quot;:\&quot;32824\&quot;,\&quot;enrollment_status\&quot;:\&quot;not_applied\&quot;,\&quot;student_type\&quot;:\&quot;transfer\&quot;,\&quot;enrollment_year\&quot;:\&quot;2021\&quot;,\&quot;school\&quot;:{\&quot;id\&quot;:\&quot;46495\&quot;,\&quot;type\&quot;:\&quot;school\&quot;,\&quot;attributes\&quot;:{\&quot;name\&quot;:\&quot;Spring Creek Towers\&quot;,\&quot;city\&quot;:\&quot;Brooklyn\&quot;,\&quot;state\&quot;:\&quot;NY\&quot;,\&quot;zipcode_d\&quot;:\&quot;11239\&quot;}},\&quot;calendar_link\&quot;:null,\&quot;group_id\&quot;:null,\&quot;checked_in\&quot;:false,\&quot;keyword\&quot;:null,\&quot;tracking_id\&quot;:null,\&quot;custom_question_responses\&quot;:[null,{\&quot;questionId\&quot;:\&quot;6285\&quot;,\&quot;questionOptionId\&quot;:\&quot;11678\&quot;},null,null,null,null,null,null,null,null,null,null,null],\&quot;channel\&quot;:{\&quot;name\&quot;:\&quot;in_person\&quot;,\&quot;visitType\&quot;:\&quot;119505\&quot;},\&quot;user_type\&quot;:\&quot;student\&quot;},\&quot;relationships\&quot;:{\&quot;institution_user_programs\&quot;:{\&quot;data\&quot;:[{\&quot;type\&quot;:\&quot;programs\&quot;,\&quot;id\&quot;:\&quot;10466\&quot;}]},\&quot;visits\&quot;:{\&quot;data\&quot;:[{\&quot;type\&quot;:\&quot;visits\&quot;,\&quot;id\&quot;:\&quot;\u0027+VisitId+\u0027\&quot;}]}},\&quot;type\&quot;:\&quot;registrations\&quot;}}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://api.mymillo.co/mobi/registrations</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
