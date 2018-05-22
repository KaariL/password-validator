package e.kaari.passwordvalidator;

public class Validator {
    //variables
    private String password;
    private int Min_Length = 8;
    Validator(String s){
        this.password = s;
    }
    //set method
    public void setPassword(String p) {
        this.password = p;
    }
    //other methods
    //public
    public int validate() {
        int testsPassed = 0;
        if (isNotPassword(password)) { testsPassed++; }
        if (isGTMinLength(password)) { testsPassed++; }
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
        if(s.length()<8) {
            return false;
        }
        return true;
    }

}

