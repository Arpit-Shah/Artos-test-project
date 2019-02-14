package com.tests.samples;

import com.artos.annotation.KnownToFail;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.Enums.TestStatus;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 3)
public class Sample_KnownToFail implements TestExecutable {

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code @KnownToFail} annotation
	 * - Code demonstrates how to enable known to fail check by setting ktf = true
	 * 		* When known to fail check is enabled and test status is not set to KTF then this test unit will be marked as FAIL. This will allow user to know if code behavior has changed.
	 * 		* Bug reference will be printed in reports in case of test failure so user can easily find the relation between test case and then bug ticket.
	 * </PRE>
	 */
	@KnownToFail(ktf = true, bugref = "JIRA-123")
	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		if ((5 + 5) != 8) {
			context.setTestStatus(TestStatus.KTF, "This method is a known bug and developer will not fix it until next sprint");
		}
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code @KnownToFail} annotation
	 * - Code demonstrates how to disable known to fail check by setting ktf = false
	 * 		* When known to fail check is disabled, user is allowed to choose any test status and test outcome will be most sever update out of all.
	 * 		* Bug reference will be printed in reports in case of test failure so user can easily find the relation between test case and then bug ticket.
	 * </PRE>
	 */
	@KnownToFail(ktf = false, bugref = "JIRA-123")
	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		if ((5 + 5) != 8) {
			context.setTestStatus(TestStatus.PASS, "This is wrong but we do not want test case to be failed");
		}
		// --------------------------------------------------------------------------------------------
	}

}
