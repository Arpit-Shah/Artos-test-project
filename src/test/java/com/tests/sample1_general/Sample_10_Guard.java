package com.tests.sample1_general;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Guard;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code Guard} class
 * </PRE>
 */
@Group(group = "FAST")
@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 10)
public class Sample_10_Guard implements TestExecutable {

	@Group(group = "GOODPATH")
	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		Guard.guardEquals(true, true);
		Guard.guardEquals(1, 1);
		Guard.guardEquals(123456789l, 123456789l);
		Guard.guardEquals("TEST", "TEST");
		Guard.guardEquals(new byte[] { 0x01, 0x02, 0x03 }, new byte[] { 0x01, 0x02, 0x03 });
		Guard.guardEquals((byte) 0xFF, (byte) 0xFF);
		Guard.guardEquals(new Exception("TEST 123"), "TEST 123");
		Guard.guardEquals((byte) 0xF1, (byte) 0xF2, (byte) 0x01);
		Guard.guardEquals(23, 25, 3);
		Guard.guardEquals(123456789l, 123456788l, 1);

		Guard.guardNotEquals(true, false);
		Guard.guardNotEquals(1, 2);
		Guard.guardNotEquals(123l, 123456789l);
		Guard.guardNotEquals("TEST-123", "TEST");
		Guard.guardNotEquals(new byte[] { 0x01, 0x02, 0x03 }, new byte[] { 0x04, 0x05, 0x06 });
		Guard.guardNotEquals((byte) 0x00, (byte) 0xFF);

		Guard.guardFalse(false);

		Guard.guardFormatEquals("$$.$$.$$$$", "01.00.0001");
		Guard.guardFormatNotEquals("$$.$$", "01.00.0001");

		Guard.guardGreaterOrEqualsTo(123, 124);
		Guard.guardGreaterThan(123, 124);

		Guard.guardLessOrEqualsTo(124, 123);
		Guard.guardLessThan(124, 123);

		// Many more...
		// --------------------------------------------------------------------------------------------
	}

}
