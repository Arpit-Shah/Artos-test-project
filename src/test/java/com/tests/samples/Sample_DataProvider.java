package com.tests.samples;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN ARTOS is used as a test framework AND DataProvider annotation is used THEN test logic with multiple input is easy to execute")
@TestCase(sequence = 2)
public class Sample_DataProvider implements TestExecutable {

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code DataProvider} annotation
	 * - Code demonstrates how to specify name of data provider within {@code @TestCase} annotation and how user can fetch parameters from TestContext.
	 * 		* In this example data provider method tag is "TEST_DATA_NAME_NUM" and method is implemented in class called "DataProviderClass.java"
	 * </PRE>
	 */
	@Unit(sequence = 1, dataprovider = "TEST_DATA_NAME_NUM")
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is object 1 : " + (String) context.getParameterisedObject1());
		context.getLogger().info("This is object 2 : " + (String) context.getParameterisedObject2());
		// --------------------------------------------------------------------------------------------
	}

}
