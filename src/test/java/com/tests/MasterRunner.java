package com.tests;

import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;

public class MasterRunner {

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
		Runner runner = new Runner(MasterRunner.class);
		runner.setTestList(getTestList());
		runner.run(args);
	}
}
