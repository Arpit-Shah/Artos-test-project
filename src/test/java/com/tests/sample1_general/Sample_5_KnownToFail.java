package com.tests.sample1_general;

import com.artos.annotation.Group;
import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

/**
 * <PRE>
 * - Sample test to demonstrate the use of the {@code KnownToFail} annotation
 * - ktf = true enforces check for known to fail status. If test logic sets test status to KTF or FAIL then test status will be set accordingly. If test logic did not set any test status or test status is set to PASS then framework will force FAIL the test unit.
 * - Bug reference will be printed in reports in case of test failure so user can easily find the relation between test case and then bug ticket.
 * </PRE>
 */
@Group(group = "FAST")
@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 5)
public class Sample_5_KnownToFail implements TestExecutable {

	@Group(group = "GOODPATH")
	@KnownToFail(ktf = true)
	@Unit(sequence = 1, bugref = "JIRA-123")
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		if (add(5, 5) != 10) {
			context.setTestStatus(TestStatus.KTF, "This method is a known bug and developer will not fix it until next sprint");
		}
		// --------------------------------------------------------------------------------------------
	}

	@Group(group = "BADPATH")
	@KnownToFail(ktf = true)
	@Unit(sequence = 2, bugref = "JIRA-123")
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		
		if (add(5, 5) != 10) {
			context.setTestStatus(TestStatus.PASS, "This test will intentinally fail, it is written to demonstate known to fail enforcement");
		}
		// --------------------------------------------------------------------------------------------
	}
	
	@Group(group = "GOODPATH")
	@KnownToFail(ktf = false)
	@Unit(sequence = 3, bugref = "JIRA-123")
	public void testUnit_3(TestContext context) {
		// --------------------------------------------------------------------------------------------
		if (add(5, 5) != 10) {
			context.setTestStatus(TestStatus.PASS, "This is wrong but we do not want test case to be failed");
		}
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * This function purposefully returns wrong value to demonstrate a feature
	 */
	private int add(int x, int y) {
		return (x + y) + 1;
	}

}
