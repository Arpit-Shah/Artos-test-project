package com.tests.samples;

import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTestUnit;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 4)
public class Sample_localBeforeAfterMethods implements TestExecutable {

	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit1");
		// --------------------------------------------------------------------------------------------
	}

	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit 2");
		// --------------------------------------------------------------------------------------------
	}

	@BeforeTestUnit
	public void localBeforeTestUnit(TestContext context) throws Exception {
		context.getLogger().info("This method executes before each local test unit");
	}

	@AfterTestUnit
	public void localAfterTestUnit(TestContext context) throws Exception {
		context.getLogger().info("This method executes after each local test unit");
	}

}
