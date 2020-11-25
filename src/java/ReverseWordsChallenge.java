import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
    Reverse Words Challenge

    The point of the challenge was to make
    an algorithm that could reverse words in
    a string, ignoring most of the spaces.

    Link: https://edabit.com/challenge/njGTBhXa7zP3pvsnp
*/
public class ReverseWordsChallenge {
    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        String[] split = s.split("");
        Iterator<String> splitIterator = Arrays.asList(split).iterator();
        StringBuilder currentlyBuilt = new StringBuilder();
        while(splitIterator.hasNext()) {
            String letter = splitIterator.next();
            if(letter.equalsIgnoreCase(" ")) {
                if(!currentlyBuilt.toString().equals("")) words.add(currentlyBuilt.toString());
                currentlyBuilt = new StringBuilder();
            } else currentlyBuilt.append(letter);

            if(!splitIterator.hasNext() && !currentlyBuilt.toString().equals("")) words.add(currentlyBuilt.toString());
        }

        List<String> reversedWords = new ArrayList<>();
        for(int i = words.size() - 1; i >= 0; i--) reversedWords.add(words.get(i));

        Iterator<String> reversedIterator = reversedWords.iterator();
        StringBuilder reversedBuilder = new StringBuilder();
        while(reversedIterator.hasNext()) {
            String word = reversedIterator.next();

            if(reversedIterator.hasNext()) reversedBuilder.append(word).append(" ");
            else reversedBuilder.append(word);
        }

        return reversedBuilder.toString();
    }
}
