package com.tests.feature1;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "user", preparationDate = "12/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 2)
public class TestCase_2 implements TestExecutable {

	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		// TODO Write Test Here
		// --------------------------------------------------------------------------------------------
	}
	
	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		// TODO Write Test Here
		// --------------------------------------------------------------------------------------------
	}

}
