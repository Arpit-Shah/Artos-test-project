package com.tests.sample1_general;

import java.nio.ByteOrder;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.LogWrapper;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.Transform;
import com.google.common.collect.Lists;

/**
 * <PRE>
 * - Sample test to demonstrate the use of {@code Transform} class
 * </PRE>
 */
@Group(group = "FAST")
@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 12)
public class Sample_12_Transform implements TestExecutable {

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code Transform} class
	 * </PRE>
	 * 
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		Transform tfm = new Transform();
		LogWrapper logger = context.getLogger();

		logger.info("asciiToHexString : " + tfm.asciiToHexString("TEST_DATA"));
		logger.info("booleanToInt : " + tfm.booleanToInt(true));
		logger.info("booleanToStr : " + tfm.booleanToStr(true));
		logger.info("booleanToStringBoolean : " + tfm.booleanToStringBoolean(true));
		logger.info("bytesReverseOrder : " + tfm.bytesToHexString(tfm.bytesReverseOrder(new byte[] { 0x01, 0x02, 0x03, 0x04 })));
		logger.info("bytesToAscii : " + tfm.bytesToAscii((byte) 0x41));
		logger.info("bytesToAscii : " + tfm.bytesToAscii(new byte[] { 0x41, 0x42, 0x43, 0x44 }));
		logger.info("bytesToDecimals : " + tfm.bytesToDecimals(new byte[] { 0x00, 0x00, 0x00, 0x01 }));
		logger.info("bytesToDecimals : " + tfm.bytesToDecimals(new byte[] { 0x00, 0x00, 0x00, 0x01 }, ByteOrder.LITTLE_ENDIAN));
		logger.info("bytesToHexString : " + tfm.bytesToHexString((byte) 0x01));
		logger.info("bytesToHexString : " + tfm.bytesToHexString(new byte[] { 0x01, 0x02, 0x03, 0x04 }));
		logger.info("bytesToHexString : " + tfm.bytesToHexString((byte) 0x01, true));
		logger.info("bytesToHexString : " + tfm.bytesToHexString(new byte[] { 0x01, 0x02, 0x03, 0x04 }, true));
		logger.info("bytesToInteger : " + tfm.bytesToInteger(new byte[] { 0x00, 0x00, 0x00, 0x01 }, ByteOrder.LITTLE_ENDIAN));
		logger.info("bytesToLong : " + tfm.bytesToLong(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01 }));
		logger.info("bytesToLong : " + tfm.bytesToLong(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01 }, ByteOrder.LITTLE_ENDIAN));
		logger.info("bytesToShort : " + tfm.bytesToShort(new byte[] { 0x00, 0x00 }, ByteOrder.LITTLE_ENDIAN));
		logger.info("clearBitOfTheByte : " + tfm.bytesToHexString(tfm.clearBitOfTheByte((byte) 0xFF, 1)));
		logger.info("concat : " + tfm.bytesToHexString(tfm.concat((byte) 0x01, (byte) 0x02, (byte) 0x03)));
		logger.info("concat : " + tfm.bytesToHexString(tfm.concat(new byte[] { 0x01, 0x02, 0x03 }, new byte[] { 0x04, 0x05, 0x06 })));
		logger.info("concat : " + tfm.bytesToHexString(tfm.concat(new byte[] { 0x01, 0x02, 0x03 }, (byte) 0x04)));
		logger.info("concat : " + tfm.bytesToHexString(tfm.concat((byte) 0x04, new byte[] { 0x01, 0x02, 0x03 })));
		logger.info("getBitOfTheByte : " + tfm.getBitOfTheByte((byte) 0xFF, 0));
		logger.info("generateRandomBytes : " + tfm.bytesToHexString(tfm.generateRandomBytes(16)));
		logger.info("getHighNibble : " + tfm.bytesToHexString(tfm.getHighNibble((byte) 0xF1)));
		logger.info("getLowNibble : " + tfm.bytesToHexString(tfm.getLowNibble((byte) 0xF1)));
		logger.info("intToByte : " + tfm.bytesToHexString(tfm.intToByte(255)));
		logger.info("intToByteArray : " + tfm.bytesToHexString(tfm.intToByteArray(1234567)));
		logger.info("intToByteArray : " + tfm.bytesToHexString(tfm.intToByteArray(1234567, ByteOrder.LITTLE_ENDIAN)));
		logger.info("listToByteArray : " + tfm.bytesToHexString(tfm.listToByteArray(Lists.newArrayList((byte) 0x01, (byte) 0x02))));
		logger.info("setBitOfTheByte : " + tfm.bytesToHexString(tfm.setBitOfTheByte((byte) 0x00, 0)));
		logger.info("strAsciiToByteArray : " + tfm.bytesToHexString(tfm.strAsciiToByteArray("TEST")));
		logger.info("strHexToByte : " + tfm.bytesToHexString(tfm.strHexToByte("01")));
		logger.info("strHexToByte : " + tfm.bytesToHexString(tfm.strHexToByteArray("01 02 03")));
		logger.info("strToByteArray : " + tfm.bytesToHexString(tfm.strToByteArray("TEST")));
		logger.info("toogleBitOfTheByte : " + tfm.bytesToHexString(tfm.toogleBitOfTheByte((byte) 0xFF, 7)));
		logger.info("asciiToHexString : " + tfm.asciiToHexString("TEST"));

		// Many more...
		// --------------------------------------------------------------------------------------------
	}

}
