import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    Consecutive Number Challenge

    The point of the challenge was to create a
    function which could detect whether or not
    there were consecutive numbers in a string.

    Link: https://edabit.com/challenge/3Xc4sz3PpyWPDw5b3
 */
public class ConsecutiveNumberChallenge {
    public static boolean isConsecutive(String s) {
        boolean hadInSequence = false;
        for(int i = 1; i < s.length(); i++) {
            if(s.length() % i == 0) {
                System.out.println("[!] Length is divisible by " + i);

                List<Integer> integers = new ArrayList<>();
                StringBuilder currentInteger = new StringBuilder();

                int currentOption = 1;
                for(String split : s.split("")) {
                    currentInteger.append(split);
                    System.out.println("[-] Appending " + split);
                    if(currentOption == i) {
                        integers.add(Integer.parseInt(currentInteger.toString()));
                        currentInteger = new StringBuilder();
                        currentOption = 1;
                    } else currentOption++;
                }

                StringBuilder integerBuilder = new StringBuilder();
                Iterator<Integer> integerIterator = integers.iterator();
                while(integerIterator.hasNext()) {
                    int integer = integerIterator.next();

                    if(integerIterator.hasNext()) integerBuilder.append(integer).append(", ");
                    else integerBuilder.append(integer);
                }

                System.out.println("[!] Found pair: " + integerBuilder.toString());

                boolean inSequence = true;
                int changingBy = 1;
                int lastInteger = 0;
                for(int integer : integers) {
                    if(lastInteger == 0 && integer - 1 == integers.get(1)) changingBy = -1;
                    if(lastInteger != 0 && integer - changingBy != lastInteger) inSequence = false;

                    lastInteger = integer;
                }

                if(inSequence) System.out.println("[!] The pair (" + integerBuilder.toString() + ") was in sequence.");
                else System.out.println("[!] The pair (" + integerBuilder.toString() + ") was not in sequence.");

                if(inSequence) hadInSequence = true;
            }
        }

        return hadInSequence;
    }
}