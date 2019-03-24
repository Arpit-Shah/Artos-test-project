package com.tests.sample1_general;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestImportance;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.Importance;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * - Sample test to demonstrate the use of the "testtimeout" attribute of the {@code Unit} annotation
 * </PRE>
 */
@Group(group = "SLOW")
@TestPlan(preparedBy = "arpit", preparationDate = "23/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 4)
public class Sample_4_TestTimeout implements TestExecutable {

	@TestImportance(Importance.LOW)
	@Group(group = "BADPATH")
	@Unit(sequence = 1, testtimeout = 5000)
	public void testUnit_1(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit 1");
		context.getLogger().info("This test will timeout");
		Thread.sleep(5500);
		// --------------------------------------------------------------------------------------------
	}

	@Group(group = "GOODPATH")
	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit 2");
		Thread.sleep(2000);
		// --------------------------------------------------------------------------------------------
	}

}
