package Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {

        StringBuilder sb = new StringBuilder();

        for (String url : urls) {
           if(urlValidation(url)) {
               sb.append(String.format("Browsing: %s!", url));
           } else {
               sb.append("Invalid URL!");
           }
           sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String call() {

        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if(numberValidation(number)) {
                sb.append(String.format("Calling... %s", number));
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private boolean numberValidation(String number) {
        for (int letter = 0; letter < number.length(); letter++) {
            if(!Character.isDigit(number.charAt(letter))) {
                return false;
            }
        }
        return true;
    }

    private boolean urlValidation (String url) {
        Pattern pattern = Pattern.compile("^[\\D]+$");
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
