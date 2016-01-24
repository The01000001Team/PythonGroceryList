package main.java;

public class DoubleToFraction {

    private int num, denom;

    public DoubleToFraction(double d) {
         String s = String.valueOf(d);
         int digitsDec = s.length() - 1 - s.indexOf('.');        

         int denom = 1;
         for(int i = 0; i < digitsDec; i++){
            d *= 10;
            denom *= 10;
         }
         int num = (int) Math.round(d);

         this.num = num; this.denom = denom;
    }

    public DoubleToFraction(int num, int denom) {
         this.num = num; this.denom = denom;
    }

    public String toString() {
        if(num % denom == 0) {
        	return String.valueOf(num/denom);
        }
        return String.valueOf((double) num/(double) denom);
    }
    
    public static double fractionToDouble(String ratio) {
    	if(ratio.contains("/")) {
    		String[] rat = ratio.split("/");
    		return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
    	}
    	else {
    		return Double.parseDouble(ratio);
    	}
    }

}