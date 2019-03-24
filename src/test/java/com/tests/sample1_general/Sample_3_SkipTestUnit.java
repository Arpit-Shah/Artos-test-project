package com.tests.sample1_general;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * - Sample test to demonstrate the use of skip attribute of the {@code Unit} annotation
 * </PRE>
 */
@Group(group = "FAST")
@TestPlan(preparedBy = "arpit", preparationDate = "23/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 3)
public class Sample_3_SkipTestUnit implements TestExecutable {

	@Group(group = "GOODPATH")
	@Unit(sequence = 1, skip = true)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit 1");
		// --------------------------------------------------------------------------------------------
	}

	@Group(group = "GOODPATH")
	@Unit(sequence = 2, skip = true)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit 2");
		// --------------------------------------------------------------------------------------------
	}

	@Group(group = "GOODPATH")
	@Unit(sequence = 3)
	public void testUnit_3(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit 3");
		// --------------------------------------------------------------------------------------------
	}

}
