package com.tests.sample2_bdd;

import java.util.concurrent.CountDownLatch;

import com.artos.annotation.StepDefinition;
import com.artos.annotation.TestImportance;
import com.artos.framework.Enums.Importance;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.artos.utils.CustomPrompt;

public class TestCase_1 implements TestExecutable {

	@TestImportance(Importance.CRITICAL)
	@StepDefinition("User see DisplayText \"\" \"\"")
	public void _user_see_displaytext(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Parameter 0: " + context.getStepParameter("Param0"));
		context.getLogger().info("Parameter 1: " + context.getStepParameter("Param1"));

		CountDownLatch countdownLatch = new CountDownLatch(1);
		CustomPrompt cp = new CustomPrompt(countdownLatch, 5000);
		cp.setHideButtons(true);
		cp.setStr1(context.getStepParameter("Param0"));
		cp.setStr2(context.getStepParameter("Param1"));
		cp.start();
		countdownLatch.await();
		// --------------------------------------------------------------------------------------------
	}

	@TestImportance(Importance.HIGH)
	@StepDefinition("User sets audio volume to \"\"")
	public void _user_sets_audio_volume_to(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Parameter 0: " + context.getStepParameter("Param0"));

		CountDownLatch countdownLatch = new CountDownLatch(1);
		CustomPrompt cp = new CustomPrompt(countdownLatch, 5000);
		cp.setHideButtons(true);
		cp.setStr1("Please set audio volume to");
		cp.setStr2(context.getStepParameter("Param0"));
		cp.start();
		countdownLatch.await();
		// --------------------------------------------------------------------------------------------
	}

	@TestImportance(Importance.LOW)
	@StepDefinition("User plays movie \"\"")
	public void _user_plays_movie(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Parameter 0: " + context.getStepParameter("Param0"));

		CountDownLatch countdownLatch = new CountDownLatch(1);
		CustomPrompt cp = new CustomPrompt(countdownLatch, 5000);
		cp.setHideButtons(true);
		cp.setStr1("Please play movie");
		cp.setStr2(context.getStepParameter("Param0"));
		cp.start();
		countdownLatch.await();
		// --------------------------------------------------------------------------------------------
	}

	@StepDefinition("User press \"\" button of the remote")
	public void _user_press__button_of_the_remote(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Parameter 0: " + context.getStepParameter("Param0"));

		CountDownLatch countdownLatch = new CountDownLatch(1);
		CustomPrompt cp = new CustomPrompt(countdownLatch, 5000);
		cp.setHideButtons(true);
		cp.setStr1("Press Remote Button");
		cp.setStr2(context.getStepParameter("Param0"));
		cp.start();
		countdownLatch.await();
		// --------------------------------------------------------------------------------------------
	}

	@StepDefinition("System auto configures television")
	public void _system_auto_configures_television(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info(context.getStepParameter("brightness"));
		context.getLogger().info(context.getStepParameter("pixel"));
		context.getLogger().info(context.getStepParameter("input"));
		context.getLogger().info(context.getStepParameter("headphone"));
		context.getLogger().info(context.getStepParameter("externalSpeaker"));

		CountDownLatch countdownLatch = new CountDownLatch(1);
		CustomPrompt cp = new CustomPrompt(countdownLatch, 5000);
		cp.setHideButtons(true);
		cp.setStr1("Television is configured with following settings");
		cp.setStr2("brightness : " + context.getStepParameter("brightness"));
		cp.setStr3("pixel : " + context.getStepParameter("pixel"));
		cp.setStr4("input : " + context.getStepParameter("input"));
		cp.setStr5("headphone : " + context.getStepParameter("headphone"));
		cp.setStr6("externalSpeaker : " + context.getStepParameter("externalSpeaker"));
		cp.start();
		countdownLatch.await();
		// --------------------------------------------------------------------------------------------
	}

	@StepDefinition("User validates \"\"")
	public void _user_validates(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		context.getLogger().info("Parameter 0: " + context.getStepParameter("Param0"));

		CountDownLatch countdownLatch = new CountDownLatch(1);
		CustomPrompt cp = new CustomPrompt(countdownLatch, 5000);
		cp.setStr2(context.getStepParameter("Param0"));
		cp.start();
		countdownLatch.await();

		if (cp.isButtonYesPressed()) {
			context.getLogger().info("User pressed YES");
		}
		if (cp.isButtonNoPressed()) {
			context.getLogger().info("User pressed No");
		}
		// --------------------------------------------------------------------------------------------
	}
}
