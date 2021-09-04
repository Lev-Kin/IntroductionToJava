package supporting;

import java.util.Arrays;
import java.util.regex.Pattern;

public class MyMethodsRegularExpression {

    public static String[] splitSentences(String text) {
        Pattern pattern = Pattern.compile("\\.*[.!?]\\s*");
        return pattern.split(text);
    }

    public static String[] splitWords(String sentence) {
        Pattern pattern = Pattern.compile("\\s*(\\s|,|;|:|\\.)\\s*"); //  \\s*(\\s|,|!|\\.)\\s*
        return pattern.split(sentence);
    }

    public static String sortParagraphsByAmountSentences(String text) {

        String[] paragraphs = text.split("\n");
        int[] counterSentences = new int[paragraphs.length];

        int maxParagraphSentences = 0;
        for (int i = 0; i < paragraphs.length; i++) {

            String[] sentences = splitSentences(paragraphs[i]);
            counterSentences[i] = sentences.length;

            if (maxParagraphSentences < sentences.length) {
                maxParagraphSentences = sentences.length;
            }
        }

        // Запись строки от самого короткого абазаца до самого длинного
        int count;
        String result = "";
        String[] tempStr = new String[maxParagraphSentences];
        for (int i = 1; i <= maxParagraphSentences; i++) {

            count = 0;

            for (int j = 0; j < counterSentences.length; j++) {
                if (i == counterSentences[j]) {
                    tempStr[count] = paragraphs[j] + "\n";
                    count++;
                }
            }

            if (count > 1) {
                // Сортировка по длине с одинаковым количеством предложений
                for (int t = 0; t < count - 1; t++) {
                    for (int f = 0; f < count - t - 1; f++) {
                        if (tempStr[f].length() > tempStr[f + 1].length()) {
                            String temp = tempStr[f];
                            tempStr[f] = tempStr[f + 1];
                            tempStr[f + 1] = temp;
                        }
                    }
                }

                for (int k = 0; k < count; k++) {
                    result += tempStr[k];
                }
            }

            if (count == 1) {
                result += tempStr[0];
            }
        }

        return result;
    }


    public static String sortWordsByLengthInSentences(String text) {

        String[] paragraphs = text.split("\n");
        String result = "";

        for (String paragraph : paragraphs) {
            String[] sentences = splitSentences(paragraph);
            for (String sentence : sentences) {
                String[] words = splitWords(sentence);

                // Cортировка слов в предложении
                for (int i = words.length - 1; i >= 0; i--) {
                    for (int j = 0; j < i; j++) {
                        if (words[j].length() > words[j + 1].length()) {
                            String tmp = words[j];
                            words[j] = words[j + 1];
                            words[j + 1] = tmp;
                        }
                    }
                }

                for (String word : words) {
                    result += word + " ";
                }

                result += "\b. ";
            }

            result += "\n";
        }

        return result;
    }

    public static String sortLexemesInSentencesByDecreaseGivenSymbol(String text, String symbol) {

        String[] paragraphs = text.split("\n");
        String result = "";

        for (String paragraph : paragraphs) {
            String[] sentences = splitSentences(paragraph);
            for (String sentence : sentences) {
                String[] words = splitWords(sentence);

                // Cортировка лексем
                for (int i = words.length - 1; i >= 0; i--) {
                    for (int m = 0; m < i; m++) {

                        int joinRight = 0;
                        int joinLeft = 0;

                        // Cчитаем количество вхождений
                        for (int n = 0; n < words[m].length(); n++) {
                            if (String.valueOf(words[m].charAt(n)).compareToIgnoreCase(symbol) == 0) {
                                joinLeft++;
                            }
                        }

                        // Cчитаем количество вхождений следующего символа
                        for (int n = 0; n < words[m + 1].length(); n++) {
                            if (String.valueOf(words[m + 1].charAt(n)).compareToIgnoreCase(symbol) == 0) {
                                joinRight++;
                            }
                        }

                        // Cравниваем количесво вхождений
                        if (joinLeft < joinRight) {
                            String tmp = words[m];
                            words[m] = words[m + 1];
                            words[m + 1] = tmp;

                            // Eсли количество вхождений равно, сортировка по алфавиту
                        } else if (joinLeft == joinRight) {
                            String[] forCompare = {words[m], words[m + 1]};
                            Arrays.sort(forCompare);
                            words[m] = forCompare[0];
                            words[m + 1] = forCompare[1];
                        }
                    }
                }


                for (String word : words) {
                    result += word + " ";
                }

                result += "\b. ";
            }

            result += "\n";
        }

        return result;
    }



}
