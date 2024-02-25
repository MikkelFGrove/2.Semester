package junit_test_suite;


import calculator.MiniCalculatorTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import person_details.AgeComparator;
import person_details.AgeComparatorTest;


@Suite
@SuiteDisplayName("My First Test Suite Demo")
@SelectPackages({"calculator", "person_details"})
//@SelectClasses({AgeComparatorTest.class, MiniCalculatorTest.class})
public class TestSuite {
}
