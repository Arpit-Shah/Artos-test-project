package com.tests.samples;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestImportance;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.Importance;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code @TestImportance} annotation
 * - Code demonstrates that method/class denoted with {@code @TestImportance} will reflect their importance within report and failure highlight
 * </PRE>
 */
@TestImportance(Importance.CRITICAL)
@Group(group = "FAST")
@TestPlan(preparedBy = "arpit", preparationDate = "23/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 8)
public class Sample_8_ImportanceIndicator implements TestExecutable {

	@Group(group = "GOODPATH")
	@TestImportance(Importance.LOW)
	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "Intentially failing this test case to demonstrate Importance indicator");
		// --------------------------------------------------------------------------------------------
	}
	
	@Group(group = "GOODPATH")
	@TestImportance(Importance.HIGH)
	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "Intentially failing this test case to demonstrate Importance indicator");
		// --------------------------------------------------------------------------------------------
	}
	
	@Group(group = "GOODPATH")
	@TestImportance(Importance.MEDIUM)
	@Unit(sequence = 2)
	public void testUnit_3(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "Intentially failing this test case to demonstrate Importance indicator");
		// --------------------------------------------------------------------------------------------
	}
	
	@Group(group = "GOODPATH")
	@TestImportance(Importance.CRITICAL)
	@Unit(sequence = 2)
	public void testUnit_4(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "Intentially failing this test case to demonstrate Importance indicator");
		// --------------------------------------------------------------------------------------------
	}
	
	@Group(group = "GOODPATH")
	@TestImportance(Importance.FATAL)
	@Unit(sequence = 2)
	public void testUnit_5(TestContext context) {
		// --------------------------------------------------------------------------------------------
		context.setTestStatus(TestStatus.FAIL, "Intentially failing this test case to demonstrate Importance indicator");
		// --------------------------------------------------------------------------------------------
	}

}