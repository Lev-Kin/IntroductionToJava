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

}
