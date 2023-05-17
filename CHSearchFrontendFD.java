import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    /**
 * Provide a text-based user interface to the searching capaibilities of the
 * CHSearchApplication.
 *
 * @author FrontendDeveloper, courtesy of the CS400 course staff.
 */
public class CHSearchFrontendFD implements CHSearchFrontendInterface {
        private Scanner userInput;
        private CHSearchBackendInterface backend;

        /**
         * Initialize frontend to make use of a provided Scanner and CHSearchBackend.
         *
         * @param userInput can be used to read input from use, or to read from files
         *                  for testing
         * @param backend   placeholder by me, working implementation by Backend
         *                  Developer
         */
        public CHSearchFrontendFD(Scanner userInput, CHSearchBackendInterface backend) {
            this.userInput = userInput;
            this.backend = backend;
        }

        /**
         * Helper method to display a 79 column wide row of dashes: a horizontal rule.
         */
        private void hr() {
            System.out.println("-------------------------------------------------------------------------------");
        }

        @Override
        public void runCommandLoop() {

        }

        @Override
        public char mainMenuPrompt() {
            return 0;
        }

        @Override
        public void loadDataCommand() {

        }

        @Override
        public List<String> chooseSearchWordsPrompt() {

                return null;
        }

        @Override
        public void searchTitleCommand(List<String> words) {

        }

        @Override
        public void searchBodyCommand(List<String> words) {

        }

        @Override
        public void searchPostCommand(List<String> words) {

        }

        @Override
        public void displayStatsCommand() {

        }
    }


