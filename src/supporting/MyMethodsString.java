package supporting;

public class MyMethodsString {

    public static char[] wordConvertCaseCamelInSnake(String camelCase) {

        if (camelCase.isEmpty()) {
            return null;
        }

        char[] camelCaseSymbols = camelCase.toCharArray();
        int upperCaseCount = findUpperCaseCount(camelCaseSymbols);
        char[] snakeCaseSymbols = new char[camelCaseSymbols.length + upperCaseCount];

        for (int i = 0, j = 0; i < camelCaseSymbols.length; i++, j++) {

            if (Character.isUpperCase(camelCaseSymbols[i])) {
                snakeCaseSymbols[j] = '_';
                snakeCaseSymbols[++j] = Character.toLowerCase(camelCaseSymbols[i]);

            } else {
                snakeCaseSymbols[j] = camelCaseSymbols[i];
            }
        }

        return snakeCaseSymbols;
    }

    private static int findUpperCaseCount(char[] symbols) {

        int upperCaseCount = 0;

        for (int i = 0; i < symbols.length; i++) {

            if (Character.isUpperCase(symbols[i])) {
                upperCaseCount++;
            }
        }

        return upperCaseCount;
    }


    public static String[] convertCamelCaseInSnakeCase(String[] camelCase) {

        int countUpCharacter = 0;
        int wordLength = 0;
        int maxCoutnUp = 0;

        for (int i = 0; i < camelCase.length; i++) {

            char[] camelCaseSymbols = camelCase[i].toCharArray();

            if (wordLength < camelCaseSymbols.length)
                wordLength = camelCaseSymbols.length;

            for (int j = 0; j < camelCaseSymbols.length; j++) {
                if (Character.isUpperCase(camelCaseSymbols[j])) {
                    countUpCharacter++;
                }
            }

            if (maxCoutnUp < countUpCharacter)
                maxCoutnUp = countUpCharacter;

        }

        char[][] snakeCaseWordsSymbols = new char[camelCase.length][wordLength + maxCoutnUp];
        for (int i = 0; i < camelCase.length; i++) {

            char[] word = wordConvertCaseCamelInSnake(camelCase[i]);

            for (int q = 0; q < word.length; q++) {
                snakeCaseWordsSymbols[i][q] = word[q];
            }
        }

        String[] result = new String[snakeCaseWordsSymbols.length];
        for (int i = 0; i < snakeCaseWordsSymbols.length; i++) {

            result[i] = "";

            for (int j = 0; j < snakeCaseWordsSymbols[i].length; j++) {

                if (snakeCaseWordsSymbols[i][j] == '\0')
                    break;

                result[i] += snakeCaseWordsSymbols[i][j];
            }
        }

        return result;
    }

    public static int countWordInText(String text, String wordGiven) {
        char[] textArray = text.toUpperCase().toCharArray();
        char[] wordGivenArr = wordGiven.toUpperCase().toCharArray();

        int word = 0;
        int count = 0;

        // подсчет слов проверка на слова
        for (int i = 0; i < textArray.length - wordGivenArr.length - 1; i++) {

            // cлово в начале текста
            if (i == 0 && textArray[wordGivenArr.length] == ' ') {
                for (int j = 0; j < wordGivenArr.length; j++) {
                    if (textArray[i + j] == wordGivenArr[j]) {
                        count++;
                    }
                }

                if (count == wordGivenArr.length)
                    word++;

                count = 0;
            }

            // cлово в тексте
            if (textArray[i] == ' ' && textArray[i + wordGivenArr.length + 1] == ' ') {
                for (int j = 0; j < wordGivenArr.length; j++) {
                    if (i < textArray.length - wordGivenArr.length) {
                        if (textArray[i + 1 + j] == wordGivenArr[j]) {
                            count++;
                        }
                    }
                }

                if (count == wordGivenArr.length)
                    word++;

                count = 0;
            }

            // слово в тексте со знаками понтуации
            if (textArray[i] == ' ' && (textArray[i + wordGivenArr.length + 1] == '.' ||
                    textArray[i + wordGivenArr.length + 1] == '!' ||
                    textArray[i + wordGivenArr.length + 1] == '?' ||
                    textArray[i + wordGivenArr.length + 1] == ',' ||
                    textArray[i + wordGivenArr.length + 1] == ':' ||
                    textArray[i + wordGivenArr.length + 1] == ';')) {
                for (int j = 0; j < wordGivenArr.length; j++) {
                    if (i < textArray.length - wordGivenArr.length) {
                        if (textArray[i + 1 + j] == wordGivenArr[j]) {
                            count++;
                        }
                    }
                }

                if (count == wordGivenArr.length)
                    word++;

                count = 0;
            }

            // конец текста без точки
            if (i == (textArray.length - wordGivenArr.length - 2) &&
                    textArray[textArray.length - wordGivenArr.length - 1] == ' ') {
                for (int j = 0; j < wordGivenArr.length; j++) {
                    if (textArray[i + 2 + j] == wordGivenArr[j]) {
                        count++;
                    }
                }

                if (count == wordGivenArr.length)
                    word++;

                count = 0;
            }

        }

        return word;
    }


    public static String replaceWordAnoterWordInText(String text, String wordGiven, String wordReplace) {
        int numberWordsToReplace = countWordInText(text, wordGiven);

        int lengthText = text.length();
        int lengthWordG = wordGiven.length();
        int lengthWordR = wordReplace.length();
        int lengthReplaceStr = 0;

        // Определяем новую днину для измененого текста с заменами
        if (lengthWordG < lengthWordR)
            lengthReplaceStr = lengthText + ((lengthWordR - lengthWordG) * numberWordsToReplace);
        else if (lengthWordG > lengthWordR)
            lengthReplaceStr = lengthText - ((lengthWordG - lengthWordR) * numberWordsToReplace);
        else
            lengthReplaceStr = lengthText;

        char[] textChange = new char[lengthReplaceStr];

        char[] textArray = text.toCharArray();
        char[] wordGivenArr = wordGiven.toCharArray();
        char[] wordReplaceArr = wordReplace.toCharArray();

        int word = 0;
        int count = 0;

        int k = 0;

        // Ищем слова для замены и заменяем делая новый символьный массив из строки
        for (int i = 0; i < textArray.length - wordGivenArr.length - 1; i++) {

            // Cлово в начале текста
            if (i == 0 && textArray[wordGivenArr.length] == ' ') {
                for (int j = 0; j < wordGivenArr.length; j++) {
                    if (textArray[i + j] == wordGivenArr[j]) {
                        count++;
                    }
                }

                if (count == wordGivenArr.length) {
                    for (int q = 0; q < wordReplaceArr.length; q++) {
                        textChange[k] = wordReplaceArr[q];
                        k++;
                    }

                    i = i + wordGivenArr.length;

                    textChange[k++] = textArray[i];

                } else {
                    textChange[k] = textArray[i];
                    k++;
                }

                count = 0;

                // Cлово в тексте
            } else if (textArray[i] == ' ' && textArray[i + wordGivenArr.length + 1] == ' ') {
                for (int j = 0; j < wordGivenArr.length; j++) {
                    if (i < textArray.length - wordGivenArr.length) {
                        if (textArray[i + 1 + j] == wordGivenArr[j]) {
                            count++;
                        }
                    }
                }

                if (count == wordGivenArr.length) {

                    textChange[k++] = textArray[i];

                    for (int q = 0; q < wordReplaceArr.length; q++) {
                        textChange[k] = wordReplaceArr[q];
                        k++;
                    }

                    i = i + wordGivenArr.length;

                } else {
                    textChange[k] = textArray[i];
                    k++;
                }

                count = 0;

                // Cлово в тексте со знаками понтуации
            } else if (textArray[i] == ' ' && (textArray[i + wordGivenArr.length + 1] == '.' ||
                    textArray[i + wordGivenArr.length + 1] == '!' ||
                    textArray[i + wordGivenArr.length + 1] == '?' ||
                    textArray[i + wordGivenArr.length + 1] == ',' ||
                    textArray[i + wordGivenArr.length + 1] == ':' ||
                    textArray[i + wordGivenArr.length + 1] == ';')) {
                for (int j = 0; j < wordGivenArr.length; j++) {
                    if (i < textArray.length - wordGivenArr.length) {
                        if (textArray[i + 1 + j] == wordGivenArr[j]) {
                            count++;
                        }
                    }
                }

                if (count == wordGivenArr.length) {

                    textChange[k++] = textArray[i];

                    for (int q = 0; q < wordReplaceArr.length; q++) {
                        textChange[k] = wordReplaceArr[q];
                        k++;
                    }

                    i = i + wordGivenArr.length;

                } else {
                    textChange[k] = textArray[i];
                    k++;
                }

                count = 0;

                // конец текста без точки
            } else if (i == (textArray.length - wordGivenArr.length - 2) &&
                    textArray[textArray.length - wordGivenArr.length - 1] == ' ') {
                for (int j = 0; j < wordGivenArr.length; j++) {
                    if (textArray[i + 2 + j] == wordGivenArr[j]) {
                        count++;
                    }
                }

                if (count == wordGivenArr.length) {

                    textChange[k++] = textArray[i++];
                    textChange[++k] = textArray[++i];

                    for (int q = 0; q < wordReplaceArr.length; q++) {
                        textChange[k] = wordReplaceArr[q];
                        k++;
                    }

                    i = i + wordGivenArr.length;

                } else {
                    textChange[k] = textArray[i];
                    k++;
                }

                count = 0;

            } else {
                textChange[k] = textArray[i];
                k++;
            }
        }

        String resultStr = new String(textChange);

        return resultStr;
    }

    public static boolean isDigitInText(char simdol) {

        if (simdol == '0' ||
                simdol == '1' ||
                simdol == '2' ||
                simdol == '3' ||
                simdol == '4' ||
                simdol == '5' ||
                simdol == '6' ||
                simdol == '7' ||
                simdol == '8' ||
                simdol == '9') {

            return true;
        }

        return false;
    }

    public static int amountRealNumberInText(String text) {

        char[] textArray = text.toCharArray();
        char[] tempArrayForNumber = new char[textArray.length];

        int amountRealNumber = 0;

        // Переписываем строку для использования (q77d сжимаем)
        int k = 0;
        for (int i = 0; i < textArray.length - 1; i++) {
            if (i == 0) {
                tempArrayForNumber[k] = ' ';
                k++;
            }

            if (isDigitInText(textArray[i]) == true) {
                if (i != 0) {
                    tempArrayForNumber[k] = textArray[i - 1];
                    k++;
                }

                for (int j = i; j < textArray.length; j++) {
                    if (isDigitInText(textArray[j]) == false) {
                        tempArrayForNumber[k] = textArray[j];
                        k++;
                        i = j;
                        break;
                    }

                    tempArrayForNumber[k] = textArray[j];
                    k++;
                }
            }
        }

        // Определям количесво реальных чисел из сжатой строки массива символов
        int count = 0;
        for (int i = 0; i < tempArrayForNumber.length; i++) {
            if (isDigitInText(tempArrayForNumber[i]) == true) {

                for (int j = i; j < tempArrayForNumber.length; j++) {
                    if (tempArrayForNumber[j - 1] == ' ') {

                        while (isDigitInText(tempArrayForNumber[j]) == true) {
                            if (isDigitInText(tempArrayForNumber[j + 1]) == true ||
                                    tempArrayForNumber[j + 1] == ' ' ||
                                    tempArrayForNumber[j + 1] == '\0') {

                                count++;
                            }

                            j++;
                        }

                        if (count > 0)
                            amountRealNumber++;

                        count = 0;

                    }

                    if (isDigitInText(tempArrayForNumber[j]) == false) {
                        i = j;
                        break;
                    }
                }
            }
        }

        return amountRealNumber;
    }

    public static String spaceCutDuplicateAndCutAllInBack(String text) {

        char[] textArray = text.toCharArray();
        char[] tempArray = new char[textArray.length];

        // Cмещаем уберая дубликаты пробелов
        int space = 0;
        int j = 0;
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i] == ' ') {
                while (space != 1) {
                    tempArray[j] = ' ';
                    j++;
                    space = 1;
                }
            } else {
                tempArray[j] = textArray[i];
                j++;
                space = 0;
            }
        }
        tempArray[j] = '\0';

        // Определяем количество пробелов и \0 конца строки
        int countEndSpace = 0;
        for (int i = tempArray.length - 1; i > 0; i--) {
            if (tempArray[i] == '\0' || tempArray[i] == ' ') {
                countEndSpace++;
            } else {
                break;
            }
        }

        char[] editedTempArray = new char[tempArray.length - countEndSpace];
        for (int i = 0; i < editedTempArray.length; i++) {
            editedTempArray[i] = tempArray[i];
        }

        String editedStr = new String(editedTempArray);

        return editedStr;
    }

}
