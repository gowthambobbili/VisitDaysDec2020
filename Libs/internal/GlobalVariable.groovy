package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object TestVar
     
    /**
     * <p></p>
     */
    public static Object StagingUrl
     
    /**
     * <p></p>
     */
    public static Object CurrentMobiUrl
     
    /**
     * <p></p>
     */
    public static Object EvrUrl
     
    /**
     * <p></p>
     */
    public static Object EvrcUrl
     
    /**
     * <p></p>
     */
    public static Object TokenEndPoint
     
    /**
     * <p>Profile Main Staging : https:&#47;&#47;staging-mobi.visitdays.com&#47;register&#47;individual-academics?subdomain=bbtesting</p>
     */
    public static Object ReferHeader
     
    /**
     * <p></p>
     */
    public static Object RegistrationEndPoint
     
    /**
     * <p></p>
     */
    public static Object SurveyCodeEndPoint
     
    /**
     * <p>Profile Main Staging : https:&#47;&#47;staging-s.visitdays.com&#47;bbtesting&#47;surv&#47;</p>
     */
    public static Object SurveyLink
     
    /**
     * <p></p>
     */
    public static Object SurveyPageUrlInAdminApp
     
    /**
     * <p></p>
     */
    public static Object CampaignUrl
     
    /**
     * <p>Profile Abra Staging : albrightsandbox , bbtesting
Profile Charizard Staging : albrightsandbox , bbtesting
Profile Main Staging : albrightsandbox , bbtesting
Profile Metapod Staging : albrightsandbox , bbtesting
Profile Pikachu Staging : albrightsandbox , bbtesting
Profile Slowpoke : albrightsandbox , bbtesting</p>
     */
    public static Object Institution
     
    /**
     * <p></p>
     */
    public static Object SelfServeUrl
     
    /**
     * <p></p>
     */
    public static Object StudentAppUrl
     
    /**
     * <p></p>
     */
    public static Object temp
     
    /**
     * <p></p>
     */
    public static Object apiBaseUrl
     
    /**
     * <p></p>
     */
    public static Object registrationEndPoint
     
    /**
     * <p></p>
     */
    public static Object Host
     
    /**
     * <p></p>
     */
    public static Object Origin
     
    /**
     * <p></p>
     */
    public static Object Referer
     
    /**
     * <p></p>
     */
    public static Object institutionId
     
    /**
     * <p>Profile Abra Staging : https:&#47;&#47;bais-abra.visitdays.vercel.app&#47;
Profile Charizard Staging : https:&#47;&#47;bais-charizard.visitdays.vercel.app&#47;, https:&#47;&#47;nacac-charizard.visitdays.vercel.app&#47;
Profile Main Staging : https:&#47;&#47;nacac-staging.visitdays.vercel.app&#47; , https:&#47;&#47;bais-staging.visitdays.vercel.app&#47;
Profile Metapod Staging : https:&#47;&#47;bais-metapod.visitdays.vercel.app&#47;
Profile Pikachu Staging : https:&#47;&#47;bais-pikachu.visitdays.vercel.app&#47; ,https:&#47;&#47;nacac-pikachu.visitdays.vercel.app&#47;
Profile Slowpoke : https:&#47;&#47;bais-slowpoke.visitdays.vercel.app&#47;
Profile Slowpoke Staging : https:&#47;&#47;bais-slowpoke.visitdays.vercel.app&#47;</p>
     */
    public static Object studenturl
     
    /**
     * <p>Profile Abra Staging : https:&#47;&#47;bais-abra.visitdays.vercel.app
Profile Metapod Staging : https:&#47;&#47;bais-metapod.visitdays.vercel.app
Profile Slowpoke : https:&#47;&#47;bais-slowpoke.visitdays.vercel.app
Profile Slowpoke Staging : https:&#47;&#47;bais-slowpoke.visitdays.vercel.app</p>
     */
    public static Object StudentUrlCheck
     
    /**
     * <p></p>
     */
    public static Object createdConventionName
     
    /**
     * <p></p>
     */
    public static Object InstitutionValue
     
    /**
     * <p>Profile Abra Staging : nacac,bais
Profile Charizard Staging : nacac,bais
Profile Main Staging : nacac, bais
Profile Metapod Staging : nacac,bais
Profile Pikachu Staging : nacac, bais
Profile Slowpoke : nacac,bais
Profile Slowpoke Staging : bais</p>
     */
    public static Object ConventionProvider
     
    /**
     * <p></p>
     */
    public static Object MainStagingMobiUrl
     
    /**
     * <p></p>
     */
    public static Object CharizardMobiUrl
     
    /**
     * <p></p>
     */
    public static Object PikachuMobiUrl
     
    /**
     * <p></p>
     */
    public static Object ReusableMobiUrl
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            TestVar = selectedVariables['TestVar']
            StagingUrl = selectedVariables['StagingUrl']
            CurrentMobiUrl = selectedVariables['CurrentMobiUrl']
            EvrUrl = selectedVariables['EvrUrl']
            EvrcUrl = selectedVariables['EvrcUrl']
            TokenEndPoint = selectedVariables['TokenEndPoint']
            ReferHeader = selectedVariables['ReferHeader']
            RegistrationEndPoint = selectedVariables['RegistrationEndPoint']
            SurveyCodeEndPoint = selectedVariables['SurveyCodeEndPoint']
            SurveyLink = selectedVariables['SurveyLink']
            SurveyPageUrlInAdminApp = selectedVariables['SurveyPageUrlInAdminApp']
            CampaignUrl = selectedVariables['CampaignUrl']
            Institution = selectedVariables['Institution']
            SelfServeUrl = selectedVariables['SelfServeUrl']
            StudentAppUrl = selectedVariables['StudentAppUrl']
            temp = selectedVariables['temp']
            apiBaseUrl = selectedVariables['apiBaseUrl']
            registrationEndPoint = selectedVariables['registrationEndPoint']
            Host = selectedVariables['Host']
            Origin = selectedVariables['Origin']
            Referer = selectedVariables['Referer']
            institutionId = selectedVariables['institutionId']
            studenturl = selectedVariables['studenturl']
            StudentUrlCheck = selectedVariables['StudentUrlCheck']
            createdConventionName = selectedVariables['createdConventionName']
            InstitutionValue = selectedVariables['InstitutionValue']
            ConventionProvider = selectedVariables['ConventionProvider']
            MainStagingMobiUrl = selectedVariables['MainStagingMobiUrl']
            CharizardMobiUrl = selectedVariables['CharizardMobiUrl']
            PikachuMobiUrl = selectedVariables['PikachuMobiUrl']
            ReusableMobiUrl = selectedVariables['ReusableMobiUrl']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
