package e.kaari.passwordvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    //variables
    private Pattern p;
    private Matcher m;
    private int Min_Length = 8;
    public Validator() {};
    //other methods
    //public
    public Integer validate(String s) {
        Integer testsPassed = 0;
        if (isNotPassword(s)) { testsPassed++; }
        if (isGTMinLength(s)) { testsPassed++; }
        if (containsNumeral(s)) { testsPassed++; }
        if (containsSpChara(s)) { testsPassed++; }
        if (containsUppAndLowCase(s)) { testsPassed++; }
        return testsPassed;
    }
    //private
    private boolean isNotPassword(String s) {
        if(s.equalsIgnoreCase("password")){
            return false;
        }
        return true;
    }
    private boolean isGTMinLength(String s) {
        if(s.length()<Min_Length) {
            return false;
        }
        return true;
    }
    private boolean containsNumeral(String s) {
       p = Pattern.compile(".*[0-9].*");
       m = p.matcher(s);
       return m.find();
    }
    private boolean containsSpChara(String s) {
        p = Pattern.compile(".*[^A-Za-z0-9].*");
        m = p.matcher(s);
        return m.find();
    }
    private boolean containsUppAndLowCase(String s) {
        String down = s.toLowerCase();
        String up = s.toUpperCase();
        if((s.equals(down))||(s.equals(up))) {
            return false;
        }
        return true;
    }
}//end class

