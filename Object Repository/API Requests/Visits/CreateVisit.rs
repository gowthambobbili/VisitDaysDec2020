<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>CreateVisit</name>
   <tag></tag>
   <elementGuidId>9528347e-edf8-4705-8d03-0758e33da2a4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;data\&quot;: {\n    \&quot;attributes\&quot;: {\n      \&quot;start_date\&quot;: \&quot;${startDate}T05:00:00.000Z\&quot;,\n      \&quot;duration\&quot;: null,\n      \&quot;status\&quot;: \&quot;published\&quot;,\n      \&quot;start_time\&quot;: null,\n      \&quot;capacity\&quot;: null,\n      \&quot;max_guests\&quot;: null,\n      \&quot;max_registrations\&quot;: null,\n      \&quot;end_date\&quot;: \&quot;${endDate}T05:00:00.000Z\&quot;,\n      \&quot;time_zone\&quot;: \&quot;US/Eastern\&quot;,\n      \&quot;notify_admins\&quot;: true,\n      \&quot;notify_owners\&quot;: true,\n      \&quot;blackout_dates\&quot;: [],\n      \&quot;team_ids\&quot;: [],\n      \&quot;admin_user_ids\&quot;: []\n    },\n    \&quot;relationships\&quot;: {\n      \&quot;visit_type\&quot;: {\n        \&quot;data\&quot;: {\n          \&quot;type\&quot;: \&quot;visit-types\&quot;,\n          \&quot;id\&quot;: \&quot;${visitTypeId}\&quot;\n        }\n      },\n      \&quot;location\&quot;: {\n        \&quot;data\&quot;: {\n          \&quot;type\&quot;: \&quot;locations\&quot;,\n          \&quot;id\&quot;: \&quot;2032\&quot;\n        }\n      }\n    },\n    \&quot;visit_series_dates\&quot;: [\n      {\n        \&quot;data\&quot;: {\n          \&quot;attributes\&quot;: {\n            \&quot;start_time\&quot;: \&quot;${startTime} 08:00:00 GMT-0500\&quot;,\n            \&quot;end_time\&quot;: \&quot;${endTime} 09:00:00 GMT-0500\&quot;,\n            \&quot;is_all_day\&quot;: false,\n            \&quot;recurs_su\&quot;: false,\n            \&quot;recurs_mo\&quot;: false,\n            \&quot;recurs_tu\&quot;: false,\n            \&quot;recurs_we\&quot;: false,\n            \&quot;recurs_th\&quot;: true,\n            \&quot;recurs_fr\&quot;: true,\n            \&quot;recurs_sa\&quot;: true,\n            \&quot;is_expanded\&quot;: false\n          },\n          \&quot;relationships\&quot;: {\n            \&quot;visit_series\&quot;: {\n              \&quot;data\&quot;: {\n                \&quot;type\&quot;: \&quot;visit-series\&quot;,\n                \&quot;id\&quot;: null\n              }\n            }\n          },\n          \&quot;type\&quot;: \&quot;visit-series-dates\&quot;\n        }\n      }\n    ],\n    \&quot;type\&quot;: \&quot;visit-series\&quot;\n  }\n}&quot;,
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
      <name>Referer</name>
      <type>Main</type>
      <value>https://metapod-admin.visitdays.com/institutions/${GlobalVariable.institution}/platform/visits/daily/new?state=summary</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.apiBaseUrl}admin/visit_series</restUrl>
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
