import java.util.HashMap;
import java.util.Map;

public class BankOCR {

    public static void main(String[] args) {

        final int DIGIT_HEIGHT = 3;
        final int DIGIT_WIDTH = 3;
        final int DIGITS_PER_ROW = 9;
        int checksum;

        boolean same;

        String convertedAccount;
        String comparedAccount;

        final String ACCOUNT_EXAMPLE =
                        "    _  _     _  _  _  _  _ \n" +
                        "  | _| _||_||_ |_   ||_||_|\n" +
                        "  ||_  _|  | _||_|  ||_| _|";

        char[][] extractDigit = new char[DIGIT_HEIGHT][ACCOUNT_EXAMPLE.length()];

        Map<String, String> digits = new HashMap<String, String>();
        Map<String, String> tests = new HashMap<String, String>();

        digits.put("Zero",
                        " _ \n" +
                        "| |\n" +
                        "|_|");

        digits.put("One",
                        "   \n" +
                        "  |\n" +
                        "  |");

        digits.put("Two",
                        " _ \n" +
                        " _|\n" +
                        "|_ ");

        digits.put("Three",
                        " _ \n" +
                        " _|\n" +
                        " _|");

        digits.put("Four",
                        "   \n" +
                        "|_|\n" +
                        "  |");

        digits.put("Five",
                        " _ \n" +
                        "|_ \n" +
                        " _|");

        digits.put("Six",
                        " _ \n" +
                        "|_ \n" +
                        "|_|");

        digits.put("Seven",
                        " _ \n" +
                        "  |\n" +
                        "  |");

        digits.put("Eight",
                        " _ \n" +
                        "|_|\n" +
                        "|_|");

        digits.put("Nine",
                        " _ \n" +
                        "|_|\n" +
                        " _|");

        tests.put("Test 1",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "| || || || || || || || || |\n" +
                        "|_||_||_||_||_||_||_||_||_|");

        tests.put("Test 2",
                        "                           \n" +
                        "  |  |  |  |  |  |  |  |  |\n" +
                        "  |  |  |  |  |  |  |  |  |");

        tests.put("Test 3",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        " _| _| _| _| _| _| _| _| _|\n" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ ");

        tests.put("Test 4",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        " _| _| _| _| _| _| _| _| _|\n" +
                        " _| _| _| _| _| _| _| _| _|");

        tests.put("Test 5",
                        "                           \n" +
                        "|_||_||_||_||_||_||_||_||_|\n" +
                        "  |  |  |  |  |  |  |  |  |");

        tests.put("Test 6",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                        " _| _| _| _| _| _| _| _| _|");

        tests.put("Test 7",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                        "|_||_||_||_||_||_||_||_||_|");

        tests.put("Test 8",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "  |  |  |  |  |  |  |  |  |\n" +
                        "  |  |  |  |  |  |  |  |  |");

        tests.put("Test 9",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_||_||_||_||_||_||_||_||_|\n" +
                        "|_||_||_||_||_||_||_||_||_|");


        tests.put("Test 10",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_||_||_||_||_||_||_||_||_|\n" +
                        " _| _| _| _| _| _| _| _| _|");

        tests.put("Test 11",
                        "    _  _     _  _  _  _  _ \n" +
                        "  | _| _||_||_ |_   ||_||_|\n" +
                        "  ||_  _|  | _||_|  ||_| _|");

        tests.put("Test 12",
                        " _  _  _  _  _  _  _  _    \n" +
                        "| || || || || || || ||_   |\n" +
                        "|_||_||_||_||_||_||_| _|  |");

        tests.put("Test 13",
                        "    _  _  _  _  _  _     _ \n" +
                        "|_||_|| || ||_   |  |  | _ \n" +
                        "  | _||_||_||_|  |  |  | _|");

        tests.put("Test 14",
                        "    _  _     _  _  _  _  _ \n" +
                        "  | _| _||_| _ |_   ||_||_|\n" +
                        "  ||_  _|  | _||_|  ||_| _ ");

        tests.put("Test 15",
                        "                           \n" +
                        "  |  |  |  |  |  |  |  |  |\n" +
                        "  |  |  |  |  |  |  |  |  |");

        tests.put("Test 16",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "  |  |  |  |  |  |  |  |  |\n" +
                        "  |  |  |  |  |  |  |  |  |");

        tests.put("Test 17",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        " _|| || || || || || || || |\n" +
                        "|_ |_||_||_||_||_||_||_||_|");

        tests.put("Test 18",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        " _| _| _| _| _| _| _| _| _|\n" +
                        " _| _| _| _| _| _| _| _| _|");

        tests.put("Test 19",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_||_||_||_||_||_||_||_||_|\n" +
                        "|_||_||_||_||_||_||_||_||_|");

        tests.put("Test 20",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                        " _| _| _| _| _| _| _| _| _|");

        tests.put("Test 21",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                        "|_||_||_||_||_||_||_||_||_|");

        tests.put("Test 22",
                        " _  _  _  _  _  _  _  _  _ \n" +
                        "|_||_||_||_||_||_||_||_||_|\n" +
                        " _| _| _| _| _| _| _| _| _|");

        tests.put("Test 23",
                        "    _  _  _  _  _  _     _ \n" +
                        "|_||_|| || ||_   |  |  ||_ \n" +
                        "  | _||_||_||_|  |  |  | _|");

        tests.put("Test 24",
                        "    _  _     _  _  _  _  _ \n" +
                        " _| _| _||_||_ |_   ||_||_|\n" +
                        "  ||_  _|  | _||_|  ||_| _|");

        tests.put("Test 25",
                        " _     _  _  _  _  _  _    \n" +
                        "| || || || || || || ||_   |\n" +
                        "|_||_||_||_||_||_||_| _|  |");

        tests.put("Test 26",
                        "    _  _  _  _  _  _     _ \n" +
                        "|_||_|| ||_||_   |  |  | _ \n" +
                        "  | _||_||_||_|  |  |  | _|");

        tests.put("Test 27",
                        " _     _  _  _  _  _  _  _ \n" +
                        " _||_||_ |_||_| _||_||_ |_ \n" +
                        " _|  | _||_||_||_ |_||_| _|");

        for (int m = 1; m <= tests.size(); m++) {
            System.out.println("Test " + m);
            comparedAccount = "";
            convertedAccount = "";
            for (int i = 0; i < ACCOUNT_EXAMPLE.length(); i += 3) {
                for (int j = 0; j < DIGITS_PER_ROW; j++) {
                    for (int k = 0; k < DIGIT_WIDTH; k++) {
                        for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l++) {
                            extractDigit[k][l] = tests.get("Test " + m).charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
                        }
                    }
                }
            }

            for (int i = 0; i < DIGIT_WIDTH; i++) {
                for (int j = 0; j < DIGIT_WIDTH * DIGITS_PER_ROW; j++) {
                    comparedAccount += extractDigit[i][j];
                }
            }

            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < 1; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l += 3) {

                        if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals((digits.get("Zero")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Zero")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Zero")).substring(8, 11)))) {
                            convertedAccount += 0;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("One")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("One")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("One")).substring(8, 11)))) {
                            convertedAccount += 1;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("Two")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Two")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Two")).substring(8, 11)))) {
                            convertedAccount += 2;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("Three")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Three")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Three")).substring(8, 11)))) {
                            convertedAccount += 3;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("Four")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Four")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Four")).substring(8, 11)))) {
                            convertedAccount += 4;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("Five")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Five")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Five")).substring(8, 11)))) {
                            convertedAccount += 5;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("Six")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Six")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Six")).substring(8, 11)))) {
                            convertedAccount += 6;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("Seven")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Seven")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Seven")).substring(8, 11)))) {
                            convertedAccount += 7;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("Eight")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Eight")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Eight")).substring(8, 11)))) {
                            convertedAccount += 8;
                        } else if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals((digits.get("Nine")).substring(0, 3)) &&
                                (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Nine")).substring(4, 7))) &&
                                (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals((digits.get("Nine")).substring(8, 11)))) {
                            convertedAccount += 9;
                        } else {
                            convertedAccount += '?';
                        }
                    }
                }
            }

            checksum = 0;

            if (! convertedAccount.contains("?")) {
                for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                    checksum += (i + 1) * Character.getNumericValue(convertedAccount.charAt((convertedAccount.length() - 1) - i));
                }
            }

            same = false;

            for (int i = 0; i < convertedAccount.length(); i++) {
                for (int j = convertedAccount.length() - 1; j > i; j--) {
                    if (convertedAccount.charAt(i) == convertedAccount.charAt(j)) {
                        same = true;
                    } else {
                        same = false;
                        break;
                    }
                }
            }

            if (same) {
                System.out.println(convertedAccount + " AMB");
            } else if (! same && checksum % 11 == 0 && ! convertedAccount.contains("?")) {
                System.out.println(convertedAccount);
            } else if (! same && checksum % 11 != 0 && ! convertedAccount.contains("?")) {
                System.out.println(convertedAccount + " ERR");
            } else if (convertedAccount.contains("?")) {
                System.out.println(convertedAccount + " ILL");
            }
        }
    }
}