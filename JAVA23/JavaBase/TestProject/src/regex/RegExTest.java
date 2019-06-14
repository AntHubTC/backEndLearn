package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegExTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pattern:");
        String patternString = in.nextLine();

        Pattern pattern = null;
        try {
            pattern = Pattern.compile(patternString);
        } catch (PatternSyntaxException e){
            System.out.println("Pattern syntax error");
            System.exit(1);
        }

        while (true){
            System.out.println("Enter string to match:");
            String input = in.nextLine();
            if(input == null || input.equals("")) return;
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()){
                System.out.println("Match");
                int g = matcher.groupCount();
                if(g > 0){
                    for (int i = 0; i < input.length(); i++) {
                        for (int j = 0; j <= g; j++) {
                            if(i == matcher.start(j))
                                System.out.println("(");
                            System.out.println(input.charAt(i));
                            for (int k = 0; k <= g; k++) {
                                if(i + 1 == matcher.end(j))
                                    System.out.println(")");
                            }
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("No match");
            }
        }

    }
}
