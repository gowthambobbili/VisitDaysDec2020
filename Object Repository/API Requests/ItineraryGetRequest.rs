<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ItineraryGetRequest</name>
   <tag></tag>
   <elementGuidId>8ef8a032-c422-4297-bb1d-d4e867846593</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;data\&quot;: {\n    \&quot;attributes\&quot;: {\n      \&quot;registration_type\&quot;: \&quot;individual\&quot;,\n      \&quot;num_guests\&quot;: 3,\n      \&quot;accessibility_needed\&quot;: false,\n      \&quot;accessibility_description\&quot;: null,\n      \&quot;first_name\&quot;: \&quot;test3\&quot;,\n      \&quot;last_name\&quot;: \&quot;visit12924\&quot;,\n      \&quot;email\&quot;: \&quot;test.user1@qualitlabs.com\&quot;,\n      \&quot;email_is_parent\&quot;: false,\n      \&quot;cell_phone_number\&quot;: \&quot;6456456456\&quot;,\n      \&quot;cell_phone_is_parent\&quot;: false,\n      \&quot;birthdate\&quot;: \&quot;2004-07-05T04:00:00.000Z\&quot;,\n      \&quot;address\&quot;: \&quot; Churchill Street\&quot;,\n      \&quot;address_line_two\&quot;: null,\n      \&quot;country\&quot;: \&quot;Canada\&quot;,\n      \&quot;city\&quot;: \&quot;Waterloo\&quot;,\n      \&quot;state\&quot;: \&quot;ON\&quot;,\n      \&quot;zip\&quot;: \&quot;N2L\&quot;,\n      \&quot;enrollment_status\&quot;: \&quot;applied\&quot;,\n      \&quot;student_type\&quot;: \&quot;transfer\&quot;,\n      \&quot;enrollment_year\&quot;: \&quot;2023\&quot;,\n      \&quot;school\&quot;: {\n        \&quot;id\&quot;: \&quot;7786\&quot;,\n        \&quot;type\&quot;: \&quot;school\&quot;,\n        \&quot;attributes\&quot;: {\n          \&quot;name\&quot;: \&quot;Tower Hill School\&quot;,\n          \&quot;city\&quot;: \&quot;Wilmington\&quot;,\n          \&quot;state\&quot;: \&quot;DE\&quot;,\n          \&quot;zipcode_d\&quot;: \&quot;19806\&quot;\n        }\n      },\n      \&quot;calendar_link\&quot;: null,\n      \&quot;group_id\&quot;: null,\n      \&quot;checked_in\&quot;: false,\n      \&quot;keyword\&quot;: null,\n      \&quot;custom_question_responses\&quot;: [\n        null,\n        null,\n        {\n          \&quot;questionId\&quot;: \&quot;4073\&quot;,\n          \&quot;questionOptionId\&quot;: \&quot;7006\&quot;\n        },\n        null,\n        null,\n        null,\n        null,\n        null,\n        {\n          \&quot;questionId\&quot;: \&quot;4080\&quot;,\n          \&quot;questionOptionId\&quot;: \&quot;7009\&quot;\n        },\n        {\n          \&quot;questionId\&quot;: \&quot;4084\&quot;,\n          \&quot;questionOptionId\&quot;: \&quot;11721\&quot;\n        },\n        null,\n        null,\n        null,\n        null,\n        null,\n        null,\n        null,\n        null\n      ],\n      \&quot;channel\&quot;: null,\n      \&quot;user_type\&quot;: \&quot;student\&quot;\n    },\n    \&quot;relationships\&quot;: {\n      \&quot;institution_user_programs\&quot;: {\n        \&quot;data\&quot;: [\n          {\n            \&quot;type\&quot;: \&quot;programs\&quot;,\n            \&quot;id\&quot;: \&quot;3517\&quot;\n          }\n        ]\n      },\n      \&quot;visits\&quot;: {\n        \&quot;data\&quot;: [\n          {\n            \&quot;type\&quot;: \&quot;visits\&quot;,\n            \&quot;id\&quot;: \&quot;1813372\&quot;\n          }\n        ]\n      }\n    },\n    \&quot;type\&quot;: \&quot;registrations\&quot;\n  }\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
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
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzY3NDgwNDMsInN1YiI6LTEsInYiOjcwMX0.FFlkNEoq-Wb0d7rsuljUgoik3kAeUURVLaXz1ATiXjE</value>
   </httpHeaderProperties>
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
      <name>Institution</name>
      <type>Main</type>
      <value>bbtesting</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Origin</name>
      <type>Main</type>
      <value>https://staging-mobi.visitdays.com</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Referer</name>
      <type>Main</type>
      <value>https://staging-mobi.visitdays.com/register/individual-academics?subdomain=albrightsandbox</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>User-Agent</name>
      <type>Main</type>
      <value>Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://api.mymillo.co/mobi/registrations</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'testett@ttt.com'</defaultValue>
      <description></description>
      <id>c38a17c4-5cf4-41c0-847b-7c7caa9d1675</id>
      <masked>false</masked>
      <name>Email</name>
   </variables>
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
