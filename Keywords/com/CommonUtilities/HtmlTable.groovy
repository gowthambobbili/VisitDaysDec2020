package com.CommonUtilities
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
//import kms.turing.katalon.plugins.helper.table.HTMLTableHelper


class HtmlTable {
	/**
	 * returns the column index of required column
	 * @param headers List of table headers
	 * @param columnName Required column name
	 */
	@Keyword
	def getColumnIndex(List headers, String columName){

		WebElement table = HTMLTableHelper.identifyTableByColumnHeaders(headers, 10,  FailureHandling.CONTINUE_ON_FAILURE)
		return HTMLTableHelper.getColumnIndexByHeader(table, columName, FailureHandling.STOP_ON_FAILURE)
	}
}






