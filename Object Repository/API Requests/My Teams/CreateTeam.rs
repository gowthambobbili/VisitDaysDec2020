<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>CreateTeam</name>
   <tag></tag>
   <elementGuidId>989b9f75-b467-43b6-a5ac-f94484e858f8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;data\&quot;: {\n    \&quot;attributes\&quot;: {\n      \&quot;name\&quot;: \&quot;Team2114\&quot;,\n      \&quot;description\&quot;: \&quot;\u003cp\u003eTeam\u003c/p\u003e\&quot;,\n      \&quot;active\&quot;: true,\n      \&quot;avatar\&quot;: null,\n      \&quot;reassign_assignee_type\&quot;: null,\n      \&quot;reassign_assignee_id\&quot;: null,\n      \&quot;reassign_ownership_type\&quot;: null,\n      \&quot;reassign_ownership_id\&quot;: null,\n      \&quot;notify_admin\&quot;: false,\n      \&quot;notify_owner\&quot;: false\n    },\n    \&quot;team_members\&quot;: [\n      {\n        \&quot;data\&quot;: {\n          \&quot;attributes\&quot;: {\n            \&quot;active\&quot;: true,\n            \&quot;notifications\&quot;: true\n          },\n          \&quot;relationships\&quot;: {\n            \&quot;admin_user\&quot;: {\n              \&quot;data\&quot;: {\n                \&quot;type\&quot;: \&quot;admin-users\&quot;,\n                \&quot;id\&quot;: \&quot;-1\&quot;\n              }\n            },\n            \&quot;team\&quot;: {\n              \&quot;data\&quot;: {\n                \&quot;type\&quot;: \&quot;teams\&quot;,\n                \&quot;id\&quot;: null\n              }\n            }\n          },\n          \&quot;type\&quot;: \&quot;team-members\&quot;\n        }\n      }\n    ],\n    \&quot;type\&quot;: \&quot;teams\&quot;\n  }\n}&quot;,
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
      <name>Host</name>
      <type>Main</type>
      <value>vd-api-staging-charizard.herokuapp.com</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Referer</name>
      <type>Main</type>
      <value>https://charizard-admin.visitdays.com/institutions/albrightsandbox/platform/my-team/teams/new</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1ODE2NzMxNzQsInN1YiI6LTEsInYiOjcwNn0.WtFdwo4Mpd5ioaP88Y0M7NoLu6pUPEYLfYNtGQ_Ip8I</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://vd-api-staging-charizard.herokuapp.com/admin/teams</restUrl>
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
