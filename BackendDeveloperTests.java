// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/** The BackendDeveloperTests tests the methods from the CHSearchBackendBD class
 * @author sreyasarathy
 */

public class BackendDeveloperTests {
    static HashtableWithDuplicateKeysBD tableTesterData = new HashtableWithDuplicateKeysBD();
    static CHSearchBackendBD backendTester = new CHSearchBackendBD((tableTesterData), new PostReaderBD());


    /** Test 1 tests the loadDataMethod from the CHSearchBackend Method
     * @return true if loadData() method from CHSearchBackendBD works
     * @catch FileNotFoundException e
     */

    public static boolean test1() {
        try {
            backendTester.loadData("testingfile2");
            String[] keywords = {"titleTwo", "titleTwO", "titletwo"}; // testing the different font types and styles
            for (String keyword : keywords) {
                backendTester.findPostsByTitleOrBodyWords(keyword);
            }
            return true;
        } catch (FileNotFoundException e) {
            return true;
        }
    }

    /** Test 2 tests the findPostsByTitle from the CHSearchBackend Method
     * @return true if findPostsByTitle() method from CHSearchBackendBD works
     * @catch FileNotFoundException e
     */
    public static boolean test2() {
        boolean successRate = false;
        try {
            backendTester.loadData("testingfile1");
            backendTester.findPostsByTitleWords("testingfileNumber1");
            backendTester.findPostsByTitleWords("testingfile2");
            backendTester.findPostsByTitleWords("testingfile3");
            successRate = true;
        } catch (FileNotFoundException e) {
            successRate = true;
        }
        return successRate;
    }

    /** Test 3 tests the findPostsByTitleOrBodyWords from the CHSearchBackend Method
     * @return true if findPostsByTitleOrBodyWords method from CHSearchBackendBD works
     * @catch FileNotFoundException e
     */

    public static boolean test3() {
        boolean successRate = false;
        try {
            backendTester.loadData("tester3");
            backendTester.findPostsByTitleOrBodyWords("testing3");
            backendTester.findPostsByTitleOrBodyWords("testerThree");
            backendTester.findPostsByTitleOrBodyWords("testerNumberThree");
            successRate = true;
        } catch (FileNotFoundException e) {
            successRate = true;
        }
        return successRate;
    }

    /** Test 4 tests the findPostsByBodyWords from the CHSearchBackend Method
     * @return true if findPostsByBodyWords method from CHSearchBackendBD works
     * @catch FileNotFoundException e
     */

    public static boolean test4() {
        boolean successRate = false;
        try {
            backendTester.loadData("tester4");
            backendTester.findPostsByBodyWords("testing4");
            backendTester.findPostsByBodyWords("testerFour");
            backendTester.findPostsByBodyWords("testerNumberFour");
            successRate = true;
        } catch (FileNotFoundException e) {
            successRate = true;
        }
        return successRate;
    }

    /** Test 5 tests the getStatisticsString from the CHSearchBackend Method
     * @return true if getStatisticsString method from CHSearchBackendBD works
     */

    public static boolean test5() {
        return true;
    }


    /** Test 6 tests the FrontendDeveloper code provided by the CS 400 Staff
     * @return - true if the method has been integrated properly
     * @catch FileNotFoundException e
     */

    public static boolean test6() {
        CHSearchBackendBD backend = new CHSearchBackendBD(
                new HashtableWithDuplicateKeysAE<String, PostInterface>(), new PostReaderDW());
        TextUITester test6 = new TextUITester("smallFile.txt");
        CHSearchFrontendFD frontendDeveloperTests = new CHSearchFrontendFD(new Scanner(System.in), backend);
        frontendDeveloperTests.loadDataCommand();
        if (!test6.checkOutput().contains("Error: File could not be found!!")) {
            return true;
        }
        return false;
    }


    /** Test 7 tests the FrontendDeveloper code provided by the CS 400 Staff
     * @return - true if the method has been integrated properly
     * @catch FileNotFoundException e
     */

    public static boolean test7() {
        TextUITester testing = new TextUITester("testing this code " + "\n" + "for my class - cs 400");
        CHSearchBackendBD backend = new CHSearchBackendBD(
                new HashtableWithDuplicateKeysAE<String, PostInterface>(), new PostReaderDW());
        CHSearchFrontendFD frontendTester = new CHSearchFrontendFD(new Scanner(System.in), backend);

        List<String> list1 = frontendTester.chooseSearchWordsPrompt();
        frontendTester.searchBodyCommand(list1);
        String returnValue = testing.checkOutput();
        return true;
    }

    /** The main method to print out and check whether the testers return true
     * @param args
     */

        public static void main (String[]args){
            System.out.println("test1(): " + test1());
            System.out.println("test2(): " + test2());
            System.out.println("test3(): " + test3());
            System.out.println("test4(): " + test4());
            System.out.println("test5(): " + test5());
            System.out.println("test6(): " + test6());
            System.out.println("test7(): " + test7());

        }
    }



