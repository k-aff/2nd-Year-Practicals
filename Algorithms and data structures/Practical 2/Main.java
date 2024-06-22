// Basic testing for the BST class using a test suite approach

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
        if (TESTS_RUN == TESTS_PASSED){
            SUITES_PASSED++;
            System.out.println(ANSI_GREEN + "All tests passed " + "\n====================" + ANSI_RESET);

        } else {
            System.out.println(ANSI_BLUE + "Some tests failed: " + (TESTS_RUN - TESTS_PASSED) + "\n===================="+
            ANSI_RESET);
        }

        TESTS_RUN = 0;
        TESTS_PASSED = 0; 
    }

    public static void assertEqualsSFB(boolean actual, boolean expected) {

        TESTS_RUN++;
        if (actual == expected) {
            TESTS_PASSED++;
            System.out.println(ANSI_GREEN + "Test " + TESTS_RUN + " Passed " + ANSI_RESET);

        } else {
            System.out.println(ANSI_RED + "Test " + TESTS_RUN + " Failed: Expected " + expected + " but got " + actual
             + ANSI_RESET);
        }
    }

    public static void assertEqualsContains(boolean actual,boolean expected) {

        TESTS_RUN++;
        if (actual == expected) {
            TESTS_PASSED++;
            System.out.println(ANSI_GREEN + "Test " + TESTS_RUN + " Passed " + ANSI_RESET);

        } else {
            System.out.println(ANSI_RED + "Test " + TESTS_RUN + " Failed: Expected " + expected + " but got " + actual
             + ANSI_RESET);
        }
    }

    public static void main(String[] args){


        BST<Integer> Amarula = new BST<Integer> ();
        Amarula.insert(23);
        Amarula.insert(24);
        Amarula.insert(2);
        Amarula.insert(3);
        Amarula.insert(16);
        Amarula.insert(19);
        Amarula.insert(30);
        Amarula.insert(20);
        Amarula.insert(5);
        Amarula.insert(46);
        Amarula.insert(37);
        Amarula.insert(22);
        Amarula.insert(18);
        Amarula.insert(29);
        Amarula.insert(13);
        Amarula.insert(33);
        Amarula.insert(198);
        Amarula.insert(108);
        Amarula.insert(147);
        Amarula.insert(3);
        Amarula.insert(148);
        Amarula.insert(26);


        start_suite("TestingContains");
        assertEqualsContains(Amarula.contains(46), true);
        end_suite();

        start_suite("TestingIsSFB");
        assertEqualsSFB(Amarula.isSuperficiallyBalanced(), false);
        end_suite();


        Amarula.delete(19);
        System.out.println(Amarula.toString());
        System.out.println("Height is " + Amarula.getHeight());
        System.out.println("Num leaves is " + Amarula.getNumLeaves());
        System.out.println("Min is " + (Amarula.findMin()));
        System.out.println("Max is " + (Amarula.findMax()));
        System.out.println("Node 33: " + Amarula.getNode(33));
        System.out.println("Node 16: " + Amarula.getNode(16));
        System.out.println("Path to Node 33: " + Amarula.printSearchPath(33));
        System.out.println("Path to Node 32: " + Amarula.printSearchPath(32));
        System.out.println("Path to Node 46: " + Amarula.printSearchPath(46));

        System.out.println(Amarula.extractBiggestSuperficiallyBalancedSubTree());

        BST<Integer> Baobab = new BST<Integer> ();

        System.out.println(Amarula.toString());
        System.out.println("Height is " + Baobab.getHeight());
        System.out.println("Num leaves is " + Baobab.getNumLeaves());
        System.out.println("Min is " + (Baobab.findMin()));
        System.out.println("Max is " + (Baobab.findMax()));
        System.out.println("Node 33: " + Baobab.getNode(33));
        System.out.println("Node 16: " + Baobab.getNode(16));
        System.out.println("Path to Node 33: " + Baobab.printSearchPath(33));
        System.out.println("Path to Node 46: " + Baobab.printSearchPath(32));


    }


}
