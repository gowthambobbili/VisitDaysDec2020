<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Individual</name>
   <tag></tag>
   <elementGuidId>8018f907-1062-45a6-b246-052d5f4a5fb1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;data\&quot;: {\n    \&quot;attributes\&quot;: {\n      \&quot;registration_type\&quot;: \&quot;individual\&quot;,\n      \&quot;num_guests\&quot;: 2,\n      \&quot;accessibility_needed\&quot;: false,\n      \&quot;accessibility_description\&quot;: null,\n      \&quot;first_name\&quot;: \&quot;${firstName}\&quot;,\n      \&quot;last_name\&quot;: \&quot;${lastName}\&quot;,\n      \&quot;email\&quot;: \&quot;${email}\&quot;,\n      \&quot;email_is_parent\&quot;: false,\n      \&quot;cell_phone_number\&quot;: \&quot;${phoneNumber}\&quot;,\n      \&quot;cell_phone_is_parent\&quot;: false,\n      \&quot;birthdate\&quot;: \&quot;2004-06-05T04:00:00.000Z\&quot;,\n      \&quot;address\&quot;: \&quot;Newyork\&quot;,\n      \&quot;address_line_two\&quot;: null,\n      \&quot;country\&quot;: \&quot;United States\&quot;,\n      \&quot;city\&quot;: \&quot;Newyork\&quot;,\n      \&quot;state\&quot;: \&quot;NY\&quot;,\n      \&quot;zip\&quot;: \&quot;50001\&quot;,\n      \&quot;enrollment_status\&quot;: \&quot;${applicantStatus}\&quot;,\n      \&quot;student_type\&quot;: \&quot;transfer\&quot;,\n      \&quot;enrollment_year\&quot;: \&quot;${enrollmentYear}\&quot;,\n      \&quot;school\&quot;: {\n        \&quot;id\&quot;: \&quot;22553\&quot;,\n        \&quot;type\&quot;: \&quot;school\&quot;,\n        \&quot;attributes\&quot;: {\n          \&quot;name\&quot;: \&quot;Knowledge/Power Prep Acad Intl\&quot;,\n          \&quot;city\&quot;: \&quot;Bronx\&quot;,\n          \&quot;state\&quot;: \&quot;NY\&quot;,\n          \&quot;zipcode_d\&quot;: \&quot;10458\&quot;\n        }\n      },\n      \&quot;calendar_link\&quot;: null,\n      \&quot;group_id\&quot;: null,\n      \&quot;checked_in\&quot;: false,\n      \&quot;keyword\&quot;: null,\n      \&quot;tracking_id\&quot;: null,\n      \&quot;custom_question_responses\&quot;: [\n        null,\n        null,\n        {\n          \&quot;questionId\&quot;: \&quot;6285\&quot;,\n          \&quot;questionOptionId\&quot;: \&quot;11677\&quot;\n        },\n        null,\n        null,\n        null,\n        null,\n        null,\n        null,\n        null,\n        null,\n        null,\n        null,\n        null\n      ],\n      \&quot;channel\&quot;: {\n        \&quot;name\&quot;: \&quot;in_person\&quot;,\n        \&quot;visitType\&quot;: \&quot;${visitTypeId}\&quot;\n      },\n      \&quot;user_type\&quot;: \&quot;student\&quot;\n    },\n    \&quot;relationships\&quot;: {\n      \&quot;institution_user_programs\&quot;: {\n        \&quot;data\&quot;: [\n          {\n            \&quot;type\&quot;: \&quot;programs\&quot;,\n            \&quot;id\&quot;: \&quot;10469\&quot;\n          }\n        ]\n      },\n      \&quot;visits\&quot;: {\n        \&quot;data\&quot;: [\n          {\n            \&quot;type\&quot;: \&quot;visits\&quot;,\n            \&quot;id\&quot;: \&quot;${visitId}\&quot;\n          }\n        ]\n      }\n    },\n    \&quot;type\&quot;: \&quot;registrations\&quot;\n  }\n}&quot;,
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
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/vnd.api+json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept-Encoding</name>
      <type>Main</type>
      <value>gzip, deflate, br</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept-Language</name>
      <type>Main</type>
      <value>en-US,en;q=0.9</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${token}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Connection</name>
      <type>Main</type>
      <value>keep-alive</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Institution</name>
      <type>Main</type>
      <value>${GlobalVariable.Institution}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Origin</name>
      <type>Main</type>
      <value>${GlobalVariable.Origin}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Referer</name>
      <type>Main</type>
      <value>${GlobalVariable.Referer}${GlobalVariable.Institution}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Sec-Fetch-Mode</name>
      <type>Main</type>
      <value>cors</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Sec-Fetch-Site</name>
      <type>Main</type>
      <value>cross-site</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>User-Agent</name>
      <type>Main</type>
      <value>Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.registrationEndPoint}</restUrl>
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
