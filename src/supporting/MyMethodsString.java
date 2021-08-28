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

            if(wordLength < camelCaseSymbols.length)
                wordLength = camelCaseSymbols.length;

            for (int j = 0; j < camelCaseSymbols.length; j++) {
                if (Character.isUpperCase(camelCaseSymbols[j])) {
                    countUpCharacter++;
                }
            }

            if(maxCoutnUp < countUpCharacter)
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

                if(snakeCaseWordsSymbols[i][j] == '\0')
                    break;

                result[i] += snakeCaseWordsSymbols[i][j];
            }
        }

        return result;
    }

    public static int countWordInText(String text, String wordGiven)
    {
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


    public static String replaceWordAnoterWordInText(String text, String wordGiven, String wordReplace)
    {
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




}
