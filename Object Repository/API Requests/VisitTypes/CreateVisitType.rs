<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>CreateVisitType</name>
   <tag></tag>
   <elementGuidId>54812fdb-d57a-4bc7-bf67-5bdfad07295b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;data\&quot;: {\n    \&quot;attributes\&quot;: {\n      \&quot;name\&quot;: \&quot;${visitype}\&quot;,\n      \&quot;status\&quot;: \&quot;active\&quot;,\n      \&quot;description\&quot;: \&quot;\u003cp\u003etest description\u003c/p\u003e\&quot;,\n      \&quot;check_in_type\&quot;: \&quot;manual\&quot;,\n      \&quot;registration_method\&quot;: \&quot;instant_book\&quot;,\n      \&quot;audience\&quot;: \&quot;individuals_and_groups\&quot;,\n      \&quot;close_registration_num_days\&quot;: 0,\n      \&quot;image\&quot;: null,\n      \&quot;category\&quot;: \&quot;daily\&quot;,\n      \&quot;notify_visitors\&quot;: false,\n      \&quot;active_visits_count\&quot;: null,\n      \&quot;upcoming_registrants_count\&quot;: null\n    },\n    \&quot;visit_type_channels\&quot;: [\n      {\n        \&quot;data\&quot;: {\n          \&quot;attributes\&quot;: {\n            \&quot;channel_type\&quot;: \&quot;in_person\&quot;,\n            \&quot;instructions\&quot;: \&quot;\&quot;,\n            \&quot;active\&quot;: true\n          },\n          \&quot;relationships\&quot;: {\n            \&quot;visit_type\&quot;: {\n              \&quot;data\&quot;: {\n                \&quot;type\&quot;: \&quot;visit-types\&quot;,\n                \&quot;id\&quot;: null\n              }\n            }\n          },\n          \&quot;type\&quot;: \&quot;visit-type-channels\&quot;\n        }\n      }\n    ],\n    \&quot;type\&quot;: \&quot;visit-types\&quot;\n  }\n}&quot;,
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
      <value>application/vnd.api+json, application/json</value>
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
      <name>Accept-Encoding</name>
      <type>Main</type>
      <value>gzip, deflate, br</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.apiBaseUrl}admin/visit_types</restUrl>
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
