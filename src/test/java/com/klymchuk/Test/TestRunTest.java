package com.klymchuk.Test;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.klymchuk.Entity.TestRun;

public class TestRunTest {
	
	List<TestRun> testRuns;
	Calendar calendar = Calendar.getInstance();
	
	@Before
	public void setUp() {
		testRuns = Lists.newArrayList();
		
		testRuns.add(new TestRun("test_login", calendar.getTime(), "Pass", "Win 7"));
		testRuns.add(new TestRun("check_correct_search_result", calendar.getTime(), "Pass", "Win 8"));
		testRuns.add(new TestRun("check_incorrect_search_reult", calendar.getTime(), "Fail", "Win 7"));
		testRuns.add(new TestRun("check_add_new_correct_policy", calendar.getTime(), "Pass", "Win 7"));
		testRuns.add(new TestRun("check_add_new_incorrect_policy", calendar.getTime(), "Pass", "Win 8"));
		testRuns.add(new TestRun("check_add_new_policy_without_data", calendar.getTime(), "Fail", "Win 7"));
		testRuns.add(new TestRun("test_logout", calendar.getTime(), "Pass", "Win 7"));
		testRuns.add(new TestRun("test_login", calendar.getTime(), "Pass", "Linux Ubuntu 12.04"));
		testRuns.add(new TestRun("check_correct_search_result", calendar.getTime(), "Pass", "Linux Ubuntu 12.04"));
		testRuns.add(new TestRun("check_incorrect_search_reult", calendar.getTime(), "Pass", "Linux Ubuntu 12.04"));
		testRuns.add(new TestRun("check_add_new_correct_policy", calendar.getTime(), "Fail", "Linux Ubuntu 12.04"));
		testRuns.add(new TestRun("check_add_new_incorrect_policy", calendar.getTime(), "Fail", "Linux Ubuntu 12.04"));
		testRuns.add(new TestRun("check_add_new_policy_without_data", calendar.getTime(), "Fail", "Linux Ubuntu 12.04"));
		testRuns.add(new TestRun("test_logout", calendar.getTime(), "Pass", "Ubuntu 12.04"));

	}
	
	@Test
	public void get_failed_test_on_WIN_traditional() {
		
		List<TestRun> failTests = Lists.newArrayList();
		for (TestRun testRun : testRuns) {
			if(testRun.getTestResult().equals("Fail") ||
					testRun.getTestEnvironment().startsWith("Win")) {
				failTests.add(testRun);
			}			
		}
		System.out.println(failTests); 
	}
	
	Predicate<TestRun> byFailTest = new Predicate<TestRun>() {
		@Override
		public boolean apply(TestRun input) {
			return input.getTestResult().equals("Fail");
		}
	};
	
	Predicate<TestRun> byWinEnv = new Predicate<TestRun>() {
		@Override
		public boolean apply(TestRun input) {
			return input.getTestEnvironment().startsWith("Win");
		}
	};		
	
	Predicate<TestRun> byLinuxEnv = new Predicate<TestRun>() {
		@Override
		public boolean apply(TestRun input) {
			return input.getTestEnvironment().startsWith("Linux");
		}
	};		
	
	@Test
	public void get_failed_test_on_WIN_with_guava() {
	
			Collection<TestRun> failedTests = Collections2.filter(testRuns, Predicates.and(byFailTest, byWinEnv));
		
		System.out.println(failedTests);
	}
	
	@Test
	public void get_failed_test_on_LINUX_with_guava() {
	
			Collection<TestRun> failedTests = Collections2.filter(testRuns, Predicates.and(byFailTest, byLinuxEnv));
		
		System.out.println(failedTests);
	}

}
