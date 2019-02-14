package com.tests.samples;

import com.artos.annotation.DataProvider;
import com.artos.framework.infra.TestContext;

public class DataProviderClass {

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
