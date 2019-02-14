package com.tests.feature2;

import java.util.ArrayList;

import com.artos.annotation.AfterTest;
import com.artos.annotation.AfterTestSuite;
import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTest;
import com.artos.annotation.BeforeTestSuite;
import com.artos.annotation.BeforeTestUnit;
import com.artos.framework.infra.Runner;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

public class FeatureRunner {

	public static ArrayList<TestExecutable> getTestList() throws Exception {
		ArrayList<TestExecutable> tests = new ArrayList<TestExecutable>();

		// --------------------------------------------------------------------------------------------
		// TODO User May Add Test Case Manually as show in sample below
		// tests.add(new Test_123());
		// tests.add(new Test_abc());
		// --------------------------------------------------------------------------------------------

		return tests;
	}

	public static void main(String[] args) throws Exception {
		Runner runner = new Runner(FeatureRunner.class);
		runner.setTestList(getTestList());
		runner.run(args);
	}

	@BeforeTestSuite
	public void beforeTestSuite(TestContext context) {
		context.getLogger().info("This method executes before test suite");
	}

	@AfterTestSuite
	public void afterTestSuite(TestContext context) {
		context.getLogger().info("This method executes after test suite");
	}

	@BeforeTest
	public void beforeTestCase(TestContext context) {
		context.getLogger().info("This method executes before each test case");
	}

	@AfterTest
	public void afterTestCase(TestContext context) {
		context.getLogger().info("This method executes after each test case");
	}

	@BeforeTestUnit
	public void beforeTestUnit(TestContext context) {
		context.getLogger().info("This method executes before each test unit");
	}

	@AfterTestUnit
	public void afterTestUnit(TestContext context) {
		context.getLogger().info("This method executes after each test unit");
	}

}
