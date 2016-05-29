public class BankOCR {

    public static void main(String[] args) {

        final int DIGIT_HEIGHT = 3;
        final int DIGIT_WIDTH = 3;
        final int DIGITS_PER_ROW = 9;
        int checksum = 0;

        boolean same;

        String convertedAccount = "";
        String comparedAccount = "";


        final String ACCOUNT_EXAMPLE =
                "    _  _     _  _  _  _  _ \n" +
                "  | _| _||_||_ |_   ||_||_|\n" +
                "  ||_  _|  | _||_|  ||_| _|";

        char[][] extractDigit = new char[DIGIT_HEIGHT][ACCOUNT_EXAMPLE.length()];

        final String TEST1 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "| || || || || || || || || |\n" +
                "|_||_||_||_||_||_||_||_||_|";

        final String TEST2 =
                "                           \n" +
                "  |  |  |  |  |  |  |  |  |\n" +
                "  |  |  |  |  |  |  |  |  |";

        final String TEST3 =
                " _  _  _  _  _  _  _  _  _ \n" +
                " _| _| _| _| _| _| _| _| _|\n" +
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ";

        final String TEST4 =
                " _  _  _  _  _  _  _  _  _ \n" +
                " _| _| _| _| _| _| _| _| _|\n" +
                " _| _| _| _| _| _| _| _| _|";

        final String TEST5 =
                "                           \n" +
                "|_||_||_||_||_||_||_||_||_|\n" +
                "  |  |  |  |  |  |  |  |  |";

        final String TEST6 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                " _| _| _| _| _| _| _| _| _|";

        final String TEST7 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                "|_||_||_||_||_||_||_||_||_|";

        final String TEST8 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "  |  |  |  |  |  |  |  |  |\n" +
                "  |  |  |  |  |  |  |  |  |";

        final String TEST9 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "|_||_||_||_||_||_||_||_||_|\n" +
                "|_||_||_||_||_||_||_||_||_|";

        final String TEST10 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "|_||_||_||_||_||_||_||_||_|\n" +
                " _| _| _| _| _| _| _| _| _|";

        final String TEST11 =
                "    _  _     _  _  _  _  _ \n" +
                "  | _| _||_||_ |_   ||_||_|\n" +
                "  ||_  _|  | _||_|  ||_| _|";

        final String TEST12 =
                " _  _  _  _  _  _  _  _    \n" +
                "| || || || || || || ||_   |\n" +
                "|_||_||_||_||_||_||_| _|  |";

        final String TEST13 =
                "    _  _  _  _  _  _     _ \n" +
                "|_||_|| || ||_   |  |  | _ \n" +
                "  | _||_||_||_|  |  |  | _|";

        final String TEST14 =
                "    _  _     _  _  _  _  _ \n" +
                "  | _| _||_| _ |_   ||_||_|\n" +
                "  ||_  _|  | _||_|  ||_| _ ";

        final String TEST15 =
                "                           \n" +
                "  |  |  |  |  |  |  |  |  |\n" +
                "  |  |  |  |  |  |  |  |  |";

        final String TEST16 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "  |  |  |  |  |  |  |  |  |\n" +
                "  |  |  |  |  |  |  |  |  |";

        final String TEST17 =
                " _  _  _  _  _  _  _  _  _ \n" +
                " _|| || || || || || || || |\n" +
                "|_ |_||_||_||_||_||_||_||_|";

        final String TEST18 =
                " _  _  _  _  _  _  _  _  _ \n" +
                " _| _| _| _| _| _| _| _| _|\n" +
                " _| _| _| _| _| _| _| _| _|";

        final String TEST19 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "|_||_||_||_||_||_||_||_||_|\n" +
                "|_||_||_||_||_||_||_||_||_|";

        final String TEST20 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                " _| _| _| _| _| _| _| _| _|";

        final String TEST21 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                "|_||_||_||_||_||_||_||_||_|";

        final String TEST22 =
                " _  _  _  _  _  _  _  _  _ \n" +
                "|_||_||_||_||_||_||_||_||_|\n" +
                " _| _| _| _| _| _| _| _| _|";

        final String TEST23 =
                "    _  _  _  _  _  _     _ \n" +
                "|_||_|| || ||_   |  |  ||_ \n" +
                "  | _||_||_||_|  |  |  | _|";

        final String TEST24 =
                "    _  _     _  _  _  _  _ \n" +
                " _| _| _||_||_ |_   ||_||_|\n" +
                "  ||_  _|  | _||_|  ||_| _|";

        final String TEST25 =
                " _     _  _  _  _  _  _    \n" +
                "| || || || || || || ||_   |\n" +
                "|_||_||_||_||_||_||_| _|  |";

        final String TEST26 =
                "    _  _  _  _  _  _     _ \n" +
                "|_||_|| ||_||_   |  |  | _ \n" +
                "  | _||_||_||_|  |  |  | _|";

        final String TEST27 =
                " _     _  _  _  _  _  _  _ \n" +
                " _||_||_ |_||_| _||_||_ |_ \n" +
                " _|  | _||_||_||_ |_||_| _|";

        final String ZERO =
                " _ \n" +
                "| |\n" +
                "|_|";

        final String ONE =
                "   \n" +
                "  |\n" +
                "  |";

        final String TWO =
                " _ \n" +
                " _|\n" +
                "|_ ";

        final String THREE =
                " _ \n" +
                " _|\n" +
                " _|";

        final String FOUR =
                "   \n" +
                "|_|\n" +
                "  |";

        final String FIVE =
                " _ \n" +
                "|_ \n" +
                " _|";

        final String SIX =
                " _ \n" +
                "|_ \n" +
                "|_|";

        final String SEVEN =
                " _ \n" +
                "  |\n" +
                "  |";

        final String EIGTH =
                " _ \n" +
                "|_|\n" +
                "|_|";

        final String NINE =
                " _ \n" +
                "|_|\n" +
                " _|";

        final String[] DIGITS = {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGTH, NINE};

        final String[] tests = {TEST1, TEST2, TEST3, TEST4, TEST5, TEST6, TEST7, TEST8, TEST9, TEST10, TEST11, TEST12, TEST13, TEST14, TEST15,
                TEST16, TEST17, TEST18, TEST19, TEST20, TEST21, TEST22, TEST23, TEST24, TEST25, TEST26};





        System.out.println("Test1");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST1.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST1.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }









        System.out.println("Test2");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST2.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST2.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }










        System.out.println("Test3");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST3.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST3.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }











        System.out.println("Test4");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST4.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST4.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }









        System.out.println("Test5");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST5.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST5.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }












        System.out.println("Test6");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST6.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST6.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }













        System.out.println("Test7");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST7.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST7.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }


















        System.out.println("Test8");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST8.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST8.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }



















        System.out.println("Test9");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST9.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST9.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }

























        System.out.println("Test10");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST10.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST10.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }























        System.out.println("Test11");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST11.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST11.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }




















        System.out.println("Test12");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST12.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST12.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }





















        System.out.println("Test13");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST13.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST13.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }






















        System.out.println("Test14");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST14.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST14.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }























        System.out.println("Test15");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST15.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST15.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }























        System.out.println("Test16");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST16.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST16.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }
























        System.out.println("Test17");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST17.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST17.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }
























        System.out.println("Test18");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST18.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST18.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }




























        System.out.println("Test19");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST19.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST19.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }






























        System.out.println("Test20");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST20.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST20.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }






























        System.out.println("Test21");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST21.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST21.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }




























        System.out.println("Test22");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST22.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST22.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }




















        System.out.println("Test23");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST23.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST23.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }




















        System.out.println("Test24");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST24.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST24.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }





























        System.out.println("Test25");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST25.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST25.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }











        System.out.println("Test26");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST26.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST26.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }






        System.out.println("Test27");
        comparedAccount = "";
        convertedAccount = "";

        for (int i = 0; i < TEST27.length(); i +=3 ) {
            for (int j = 0; j < DIGITS_PER_ROW; j++) {
                for (int k = 0; k < DIGIT_WIDTH; k++) {
                    for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT*(j + 1); l++) {
                        extractDigit[k][l] = TEST27.charAt(l + k * (DIGIT_WIDTH * DIGITS_PER_ROW + 1));
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
                for (int l = DIGIT_HEIGHT * j; l < DIGIT_HEIGHT * (j + 1); l+= 3) {

                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_WIDTH)).equals(ZERO.substring(0, 3))  &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(4, 7)))  &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ZERO.substring(8, 11)))){
                        convertedAccount += 0;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(ONE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(ONE.substring(8, 11)))) {
                        convertedAccount += 1;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(TWO.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(TWO.substring(8, 11)))) {
                        convertedAccount += 2;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(THREE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(THREE.substring(8, 11)))) {
                        convertedAccount += 3;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FOUR.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FOUR.substring(8, 11)))) {
                        convertedAccount += 4;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(FIVE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(FIVE.substring(8, 11)))) {
                        convertedAccount += 5;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SIX.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SIX.substring(8, 11)))) {
                        convertedAccount += 6;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(SEVEN.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(SEVEN.substring(8, 11)))) {
                        convertedAccount += 7;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(EIGTH.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(EIGTH.substring(8, 11)))) {
                        convertedAccount += 8;
                    } else
                    if (comparedAccount.substring((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)), ((l + k * (DIGIT_WIDTH * DIGITS_PER_ROW)) + DIGIT_HEIGHT)).equals(NINE.substring(0, 3)) &&
                            (comparedAccount.substring((l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 1) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(4, 7))) &&
                            (comparedAccount.substring((l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW)), (l + (k + 2) * (DIGIT_WIDTH * DIGITS_PER_ROW) + DIGIT_HEIGHT)).equals(NINE.substring(8, 11)))) {
                        convertedAccount += 9;
                    } else {
                        convertedAccount += '?';
                    }
                }
            }
        }

        checksum = 0;

        if (!convertedAccount.contains("?")) {
            for (int i = convertedAccount.length() - 1; i >= 0; i--) {
                checksum += (i+1) *  Character.getNumericValue(convertedAccount.charAt((convertedAccount.length()-1) - i));
            }
        }

        same = false;

        for (int i = 0; i < convertedAccount.length(); i++) {
            for (int j = convertedAccount.length()-1; j > i; j--) {
                if (convertedAccount.charAt(i) == convertedAccount.charAt(j)){
                    same = true;
                } else {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println(convertedAccount + " AMB");
        } else if (!same && checksum % 11 == 0 && !convertedAccount.contains("?")) {
            System.out.println(convertedAccount);
        } else if (!same && checksum % 11 !=0 && !convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ERR");
        } else if (convertedAccount.contains("?")){
            System.out.println(convertedAccount + " ILL");
        }
    }
}