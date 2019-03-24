package com.tests.sample1_general;

import java.io.File;
import java.util.concurrent.CountDownLatch;

import com.artos.annotation.Group;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

@Group(group = "SLOW")
@TestPlan(preparedBy = "Arpit Shah", preparationDate = "14/02/2019", bdd = "GIVEN..WHEN..AND..THEN..")
@TestCase(sequence = 9)
public class Sample_9_CustomPrompt implements TestExecutable {

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code Transform} class
	 * * This example shows how to launch count down timer
	 * </PRE>
	 *
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 1)
	public void testUnit_1(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("This example shows simple non-blocking countdown timer");
		CustomPrompt prompt = new CustomPrompt(5000);
		prompt.setHideButtons(true);
		prompt.start();
		Thread.sleep(5000);
		// --------------------------------------------------------------------------------------------
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code CustomPrompt} class
	 * * This example shows how to change title
	 * </PRE>
	 *
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 2)
	public void testUnit_2(TestContext context) throws Exception {
		context.getLogger().info("This example shows how to change title");
		CustomPrompt prompt = new CustomPrompt(5000);
		prompt.setHideButtons(true);
		prompt.setTitle("Hello");
		prompt.start();
		Thread.sleep(5000);
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code CustomPrompt} class
	 * * This example shows how to enable buttons
	 * </PRE>
	 *
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 3)
	public void testUnit_3(TestContext context) throws Exception {
		context.getLogger().info("This example shows how to enable buttons");
		CustomPrompt prompt = new CustomPrompt(5000);
		prompt.setHideButtons(false);
		prompt.start();
		Thread.sleep(5000);
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code CustomPrompt} class
	 * * This example shows how to change button text
	 * </PRE>
	 *
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 4)
	public void testUnit_4(TestContext context) throws Exception {
		context.getLogger().info("This example shows how to change button text");
		CustomPrompt prompt = new CustomPrompt(5000);
		prompt.setHideButtons(false);
		prompt.setBtnYesText("Hellow");
		prompt.setBtnNoText("Hi");
		prompt.start();
		Thread.sleep(5000);
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code CustomPrompt} class
	 * * This example shows how to display text
	 * </PRE>
	 *
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 5)
	public void testUnit_5(TestContext context) throws Exception {
		context.getLogger().info("This example shows how to display text");
		CustomPrompt prompt = new CustomPrompt(5000);
		prompt.setStr1("This is line 1");
		prompt.setStr2("This is line 2");
		prompt.setStr3("This is line 3");
		prompt.setStr4("This is line 4");
		prompt.setStr5("This is line 5");
		prompt.setStr6("This is line 6");
		prompt.setStr7("This is line 7");
		prompt.setStr7("This is line 8");
		prompt.setStr7("This is line 9");
		prompt.setStr7("This is line 10");
		prompt.start();
		Thread.sleep(5000);
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code CustomPrompt} class
	 * * This example shows how to display live changing text
	 * </PRE>
	 *
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 6)
	public void testUnit_6(TestContext context) throws Exception {
		context.getLogger().info("This example shows how to display live changing text");
		CustomPrompt prompt = new CustomPrompt(5000);
		prompt.setStr1("This is line 1");
		prompt.start();

		for (int i = 0; i < 35; i++) {
			prompt.setStr1("This is line " + i);
			Thread.sleep(100);
		}
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code CustomPrompt} class
	 * 		* This example shows how to display live changing text
	 * </PRE>
	 * 
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 7)
	public void testUnit_7(TestContext context) throws Exception {
		context.getLogger().info("This example shows how to display png");
		CustomPrompt prompt = new CustomPrompt(5000);
		prompt.setStr1("This is ARTOS Sample Project");
		prompt.setStr2("ARTOS logo is as shown below");
		prompt.setImage(new File("./assets/png/ARTOS.png"));
		prompt.start();
		Thread.sleep(5000);
	}

	/**
	 * <PRE>
	 * - Sample test to demonstrate the use of {@code CustomPrompt} class
	 * 		* This example shows blocking count down timer using count down latch
	 * </PRE>
	 * 
	 * @throws Exception throws an exception
	 */
	@Group(group = "GOODPATH")
	@Unit(sequence = 8)
	public void testUnit_8(TestContext context) throws Exception {
		context.getLogger().info("This example shows blocking countdown timer using countdown latch");
		CountDownLatch ctdwnLatch = new CountDownLatch(1);
		CustomPrompt prompt = new CustomPrompt(ctdwnLatch, 5000);
		prompt.start();
	}
}
