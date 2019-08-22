package com.tests.sample1_general;

import java.util.ArrayList;

import com.artos.annotation.AfterFailedUnit;
import com.artos.annotation.AfterTest;
import com.artos.annotation.AfterTestSuite;
import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTest;
import com.artos.annotation.BeforeTestSuite;
import com.artos.annotation.BeforeTestUnit;
import com.artos.framework.infra.Runner;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;
import com.google.common.collect.Lists;

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
		runner.setLoopCount(1);
		runner.setTestGroupList(Lists.newArrayList("FAST", "SLOW"));
		runner.setTestUnitGroupList(Lists.newArrayList("GOODPATH", "BADPATH"));
		runner.run(args);
	}

	@BeforeTestSuite
	public void beforeTestSuite(TestContext context) throws Exception {
		context.getLogger().info("This method executes before each test suite");
	}

	@AfterTestSuite
	public void afterTestSuite(TestContext context) throws Exception {
		context.getLogger().info("This method executes after each test suite");
	}

	@BeforeTest
	public void globalBeforeTest(TestContext context) throws Exception {
		context.getLogger().info("This method executes before each test");
	}

	@AfterTest
	public void globalAfterTest(TestContext context) throws Exception {
		context.getLogger().info("This method executes after each test");
	}

	@BeforeTestUnit
	public void globalBeforeTestUnit(TestContext context) throws Exception {
		context.getLogger().info("This method executes before each test unit");
	}

	@AfterTestUnit
	public void globalAfterTestUnit(TestContext context) throws Exception {
		context.getLogger().info("This method executes after each test unit");
	}

	@AfterFailedUnit
	public void globalAfterFailedTestUnit(TestContext context) throws Exception {
		context.getLogger().info("This method executes after failed test unit");
	}

}
