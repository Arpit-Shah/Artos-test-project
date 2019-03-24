package com.tests.sample1_general;

import com.artos.annotation.DataProvider;
import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestImportance;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.Importance;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Transform;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code DataProvider} annotation along with "dataprovider" attribute of the {@code Unit} annotation.
 * - Code demonstrates how to specify name of data provider within {@code @Unit} annotation and how user can fetch parameters from TestContext.
 * </PRE>
 */
@Group(group = "FAST")
@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN ARTOS is used as a test framework AND DataProvider annotation is used THEN test logic with multiple input is easy to execute")
@TestCase(sequence = 6, bugref = "JIRA-234")
public class Sample_6_DataProvider implements TestExecutable {

	/**
	 * <PRE>
	 * 	In this example data provider method tag is "TEST_DATA_NAME_NUM" and method is implemented within a same class with {@code DataProvider} annotation.
	 * 	This example demonstrates how to get 2D object containing [String][String]
	 * </PRE>
	 */
	@Group(group = "GOODPATH")
	@TestImportance(Importance.LOW)
	@Unit(sequence = 1, dataprovider = "TEST_DATA_NAME_NUM", bugref = "JIRA-124")
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Object 1 : " + (String) context.getParameterisedObject1());
		context.getLogger().info("Object 2 : " + (String) context.getParameterisedObject2());
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * <PRE>
	 * 	In this example data provider method tag is "TEST_DATA_NAME_OBJ" and method is implemented within a same class with {@code DataProvider} annotation.
	 * 	This example demonstrates how to get 2D object containing [String][byte[]]
	 * </PRE>
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 2, dataprovider = "TEST_DATA_NAME_OBJ")
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Object 1 : " + (String) context.getParameterisedObject1());
		context.getLogger().info("Object 2 : " + new Transform().bytesToHexString((byte[]) context.getParameterisedObject2()));
		// --------------------------------------------------------------------------------------------
	}
	
	@DataProvider(name = "TEST_DATA_NAME_NUM")
	public Object[][] dataproviderMethod_1(TestContext context) {

		// @formatter:off
		Object[][] data = new Object[][]
			{
				{"Joe", "123"},
				{"Sam", "234"},
				{"Mark", "145"},
				{"Maya", "145"},
			
			};
		return data;
		// @formatter:on
	}
	
	@DataProvider(name = "TEST_DATA_NAME_OBJ")
	public Object[][] dataproviderMethod_2(TestContext context) {

		// @formatter:off
		Object[][] data = new Object[][]
			{
				{"Joe", new byte[]{1,2,3}},
				{"Sam", new byte[]{2,2,3}},
				{"Mark", new byte[]{3,2,3}},
				{"Maya", new byte[]{4,2,3}},
			
			};
		return data;
		// @formatter:on
	}

}
