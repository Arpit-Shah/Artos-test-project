package com.tests.sample1_general;

import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTestUnit;
import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code @BeforeTestUnit} and {@code @AfterTestUnit} annotations
 * - Code demonstrates that method denoted with {@code @BeforeTestUnit} annotation in local scope of the test case will be executed before each test unit within the same test case
 * - Code demonstrates that method denoted with {@code @AfterTestUnit} annotation in local scope of the test case will be executed after each test unit within the same test case
 * </PRE>
 */
@Group(group = "FAST")
@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN local before-after methods are provided within a test case THEN those methods will execute around each units within a test case")
@TestCase(sequence = 0)
public class Sample_0_localBeforeAfterMethods implements TestExecutable {

	@Group(group = "GOODPATH")
	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit 1");
		// --------------------------------------------------------------------------------------------
	}

	@Group(group = "GOODPATH")
	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This is unit 2");
		// --------------------------------------------------------------------------------------------
	}

	@BeforeTestUnit
	public void beforeTestUnitLocal(TestContext context) {
		context.getLogger().info("This method executes before each test unit within this test case");
	}

	@AfterTestUnit
	public void afterTestUnitLocal(TestContext context) {
		context.getLogger().info("This method executes after each test unit within this test case");
	}

}
