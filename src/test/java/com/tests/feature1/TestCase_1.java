package com.tests.feature1;

import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "19/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase
public class TestCase_1 implements TestExecutable {

	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("fgfgf");
		// --------------------------------------------------------------------------------------------
	}

	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("fgfgf");
		// --------------------------------------------------------------------------------------------
	}

}
