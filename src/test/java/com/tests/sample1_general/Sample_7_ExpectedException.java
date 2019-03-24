package com.tests.sample1_general;

import com.artos.annotation.ExpectedException;
import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;

@Group(group = "FAST")
@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN ARTOS is used as a test framework AND ExpectedException annotation is used THEN test exceptions are easy to handle")
@TestCase(sequence = 7)
public class Sample_7_ExpectedException implements TestExecutable {

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code ExpectedException} annotation
	 * - Code demonstrates how to specify single expected exception class
	 * 		* Test Unit execution will be terminated as soon as exception is thrown and next test unit will be run
	 * 		* If Exception is not as expected or exception did not occur then test unit will be marked as a FAIL
	 * </PRE>
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 1)
	@ExpectedException(expectedExceptions = { NumberFormatException.class })
	public void testUnit_1(TestContext context) {
		// --------------------------------------------------------------------------------------------
		// Converting String into Integer should throw an error
		Integer.parseInt("Test");
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code ExpectedException} annotation
	 * - Code demonstrates how to specify multiple expected exception classes
	 * 		* Test Unit execution will be terminated as soon as exception is thrown and next test unit will be run
	 * 		* If Exception is not as expected or exception did not occur then test unit will be marked as a FAIL
	 * </PRE>
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 2)
	@ExpectedException(expectedExceptions = { Exception.class, NumberFormatException.class })
	public void testUnit_2(TestContext context) {
		// --------------------------------------------------------------------------------------------
		// Converting String into Integer should throw an error
		Integer.parseInt("Test");
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code ExpectedException} annotation
	 * - Code demonstrates how to specify multiple expected exception classes and description
	 * 		* Test Unit execution will be terminated as soon as exception is thrown and next test unit will be run
	 * 		* If Exception is not as expected or exception did not occur then test unit will be marked as a FAIL
	 * </PRE>
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 3)
	@ExpectedException(expectedExceptions = { Exception.class, NumberFormatException.class }, contains = "This is a test code")
	public void testUnit_3(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		// test logic goes here..
		throw new Exception("This is a test code");
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code ExpectedException} annotation
	 * - Code demonstrates how to specify multiple expected exception classes and description using Regular expression
	 * 		* Test Unit execution will be terminated as soon as exception is thrown and next test unit will be run
	 * 		* If Exception is not as expected or exception did not occur then test unit will be marked as a FAIL
	 * </PRE>
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 4)
	@ExpectedException(expectedExceptions = { Exception.class, NumberFormatException.class }, contains = ".*\\btest\\b.*")
	public void testUnit_4(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		// test logic goes here..
		throw new Exception("This is a test code");
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code ExpectedException} annotation
	 * - Code demonstrates how to specify exception but do not enforce fail in absence of exception.
	 * 		* If Exception is thrown then it will be matched with expectedException class
	 * 		* If Exception will not be thrown then test will continue execution and PASS eventually
	 * </PRE>
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 5)
	@ExpectedException(enforce = false, expectedExceptions = { Exception.class, NumberFormatException.class })
	public void testUnit_5(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		// test logic goes here..
		context.getLogger().info("This test does not throw any exception");
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate exception handling without the use of @ExpectedException annotation
	 * 		* This will allow user to continue executing rest of the code in case of exception. Guarding against wrong flow will help user throw exception in case code did not do what was execpted
	 * </PRE>
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 6)
	public void testUnit_6(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		try {
			// Converting String into Integer should throw an error
			Integer.parseInt("Test");

			// This is to protect against code traveling in wrong direction
			Guard.guardWrongFlow("Expected Exception, but did not occur");

		} catch (NumberFormatException e) {
			if (!e.getMessage().equals("For input string: \"Test\"")) {
				throw e;
			}
		}

		context.getLogger().info("Do something here after exception is caught");
		// logic goes here..
		// --------------------------------------------------------------------------------------------
	}
}
