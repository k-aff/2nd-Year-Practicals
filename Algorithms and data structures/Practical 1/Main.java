// Basic testing for the RecursiveArray class using a test suite approach

public class Main {

    public static String ANSI_RED = "\u001b[31;1m";
    public static String ANSI_GREEN = "\u001b[32;1m";
    public static String ANSI_BLUE = "\u001b[34;1m";
    public static String ANSI_RESET = "\u001b[31;0m";

    public static int SUITES_RUN = 0;
    public static int SUITES_PASSED = 0;

    public static int TESTS_RUN = 0;
    public static int TESTS_PASSED = 0;

    public static void start_suite(String name) {
        SUITES_RUN++;
        System.out.println("====================\nStarting:" + name + "\n====================");
    }

    public static void end_suite() {
        if (TESTS_RUN == TESTS_PASSED) {
            SUITES_PASSED++;
            System.out.println(ANSI_GREEN + "All tests passed " + "\n====================" + ANSI_RESET);

        } else {
            System.out
                    .println(ANSI_BLUE + "Some tests failed: " + (TESTS_RUN - TESTS_PASSED) + "\n====================" +
                            ANSI_RESET);
        }

        TESTS_RUN = 0;
        TESTS_PASSED = 0;
    }

    public static void assertEquals(Integer[] actual, Integer[] expected) {

        TESTS_RUN++;
        if (actual == expected) {
            TESTS_PASSED++;
            System.out.println(ANSI_GREEN + "Test " + TESTS_RUN + " Passed " + ANSI_RESET);

        } else {
            System.out.println(ANSI_RED + "Test " + TESTS_RUN + " Failed: Expected " + expected + " but got " + actual
                    + ANSI_RESET);
        }
    }

    public static void assertEqualsA(boolean actual, boolean expected) {

        TESTS_RUN++;
        if (actual == expected) {
            TESTS_PASSED++;
            System.out.println(ANSI_GREEN + "Test " + TESTS_RUN + " Passed " + ANSI_RESET);

        } else {
            System.out.println(ANSI_RED + "Test " + TESTS_RUN + " Failed: Expected " + expected + " but got " + actual
                    + ANSI_RESET);
        }
    }

    public static void assertEqualsD(boolean actual, boolean expected) {

        TESTS_RUN++;
        if (actual == expected) {
            TESTS_PASSED++;
            System.out.println(ANSI_GREEN + "Test " + TESTS_RUN + " Passed " + ANSI_RESET);

        } else {
            System.out.println(ANSI_RED + "Test " + TESTS_RUN + " Failed: Expected " + expected + " but got " + actual
                    + ANSI_RESET);
        }
    }

    public static void assertEqualsC(boolean actual, boolean expected) {

        TESTS_RUN++;
        if (actual == expected) {
            TESTS_PASSED++;
            System.out.println(ANSI_GREEN + "Test " + TESTS_RUN + " Passed " + ANSI_RESET);

        } else {
            System.out.println(ANSI_RED + "Test " + TESTS_RUN + " Failed: Expected " + expected + " but got " + actual
                    + ANSI_RESET);
        }
    }

    public static void end_all() {

        if (SUITES_RUN == SUITES_PASSED) {
            SUITES_PASSED++;
            System.out.println(ANSI_GREEN + "\n=======================" + "\n***All suites passed***"
                    + "\n=======================" + ANSI_RESET);

        } else {
            System.out.println(ANSI_BLUE + "\n=======================" + "\nSome suites failed: "
                    + (SUITES_RUN - SUITES_PASSED) + "/" + SUITES_RUN + "\n=======================" +
                    ANSI_RESET);
        }

        TESTS_RUN = 0;
        TESTS_PASSED = 0;
    }

    public static void main(String[] args) {

        start_suite("TestingIsAscending");
        RecursiveArray testArr = new RecursiveArray("7,4,15,2,11,8,10,23,76,32,19,3");
        testArr.sortAscending();
        assertEqualsA(testArr.isAscending(), true);
        end_suite();

        start_suite("TestingIsDescending");
        RecursiveArray testArr2 = new RecursiveArray("7,4,15,2,11,8,10,23,76,32,19,3");
        testArr2.sortDescending();
        assertEqualsD(testArr2.isDescending(), true);
        end_suite();

        start_suite("Testing SortAscending & IsAscending ");
        RecursiveArray testArr3 = new RecursiveArray("7,4,15,2,11,8,10,23,76,32,19,3");
        testArr3.sortAscending();
        assertEqualsA(testArr3.isAscending(), true);
        end_suite();

        start_suite("Testing SortDescending IsDescending ");
        RecursiveArray testArr4 = new RecursiveArray("7,4,15,2,11,8,10,23,76,32,19,3");
        testArr4.sortDescending();
        assertEqualsD(testArr4.isDescending(), true);
        end_suite();

        start_suite("Testing Contains");
        RecursiveArray testArr5 = new RecursiveArray("7,4,15,2,11,8,10,23,76,32,19,3");
        assertEqualsC(testArr5.contains(11), true);
        end_suite();

        start_suite("Testing Contains");
        RecursiveArray testArr6 = new RecursiveArray("45,7,21,97,1,8,10,23,76,32,19,3");
        assertEqualsC(testArr6.contains(5), false);
        end_suite();

        start_suite("Testing Append then Contains");
        testArr.append(14);
        assertEqualsC(testArr6.contains(14), false);
        end_suite();

        start_suite("Testing Prepend then Contains");
        testArr6.prepend(167);
        assertEqualsC(testArr6.contains(167), false);
        end_suite();

        start_suite("Testing Prepend then Contains then IsAscending");
        testArr.prepend(18);
        assertEqualsC(testArr.contains(18), false);
        testArr.sortAscending();
        assertEqualsA(testArr3.isAscending(), true);
        end_suite();

    }
}
