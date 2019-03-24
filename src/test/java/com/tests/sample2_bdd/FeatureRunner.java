package com.tests.sample2_bdd;

import java.util.ArrayList;

import com.artos.framework.infra.Runner;
import com.artos.interfaces.TestExecutable;
import com.tests.HelperClass;

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
		
		// Transfer required files
		HelperClass helper = new HelperClass();
		String scriptFile = "com.tests.feature2_bdd.xml";
		String bddFile = "television_test.feature";
		helper.emptyDir("./script");
		helper.createDir("./script");
		helper.TransferFileToScriptDir("./assets/script/", scriptFile);
		helper.TransferFileToScriptDir("./assets/script/", bddFile);

		// mimic command line argument
		args = new String[1];
		args[0] = "--testscript=com.tests.feature2_bdd.xml";
		runner.run(args);
	}
}
