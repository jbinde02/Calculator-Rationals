/**
 * This class represents a fraction. It has two ints. A numerator and a denominator. It also provides many
 * helpful methods for creating new fractions such as basic arthmetic operations and simplification. It
 * can also find the greatest common factor of a fraction and convert them to a string.
 *
 * @author Jacob Binder in conference with Nate Workman
 * @version 1.0
 */
public class Rational extends Number{
    int numerator;
    int denominator;
    /**
     * 
     */
    private Rational(){

    }

    /**
     * Constuct a new fraction with two int arguements. Denominator cannot be 0.
     * If the denominator is negative, it turns it positive and the numerator negative.
     * If the numerator and the denominator are negative, it turns them both positive.
     */
    public Rational(int numerator, int denominator) throws IllegalArgumentException{      

        if(denominator == 0){
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if(denominator<0){
            this.numerator =  numerator * -1;
            this.denominator = denominator * -1;
        }else if(denominator<0 && numerator<0){
            this.numerator =  numerator * -1;
            this.denominator = denominator * -1;
        }else{
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    /**
     * Constuct a new fraction with a double. Puts the double over 100 and multiplies by 100.
     * Rational is unsimplified.
     */
    public Rational(double value){
        double doubnumerator;
        denominator = 100;
        doubnumerator = value * 100;
        this.numerator = (int)doubnumerator;
        this.denominator = denominator;
    }

    /**
     * Gets the numerator.
     */
    public int getNumerator(){
        return numerator;
    }

    /**
     * Gets the denominator.
     */
    public int getDenominator(){
        return denominator;
    }

    /**
     * Acts on one Rational and takes another as a argument. 
     * Returns a new Rational upon completion. 
     * If the denominators are different, it multiplies the denominators to find a common factor.
     * If the denominators are different, it finds the new numerator by multiplying the numerator
     * of the first Rational by the denominator of the second and vice versa.
     * Then it just adds the numerators.
     */
    public Rational addRational(Rational r2){
        int r3n;
        int r3d;     
        if(this.denominator == r2.denominator){           
            r3d = this.denominator;
            r3n = this.numerator + r2.numerator;
        }else{
            r3d = this.denominator * r2.denominator;
            r3n = r2.denominator * this.numerator + this.denominator * r2.numerator;
        }

        return new Rational(r3n,r3d);
    }

    /**
     * Acts on one Rational and takes another as a argument. 
     * Returns a new Rational upon completion. 
     * If the denominators are different, it multiplies the denominators to find a common factor.
     * If the denominators are different, it finds the new numerator by multiplying the numerator
     * of the first Rational by the denominator of the second and vice versa.
     * Then it just subtracts the numerators.
     */
    public Rational subtractRational(Rational r2){
        int r3n;
        int r3d;     
        if(this.denominator == r2.denominator){           
            r3d = this.denominator;
            r3n = this.numerator - r2.numerator;
        }else{
            r3d = this.denominator * r2.denominator;
            r3n = r2.denominator * this.numerator - this.denominator * r2.numerator;
        }

        return new Rational(r3n,r3d);
    }

    /**
     * Returns a new fraction. Multiplies two fractions straight across.
     */
    public Rational multiplyRational(Rational r2){
        int r3n = this.numerator * r2.numerator;
        int r3d = this.denominator * r2.denominator;
        return new Rational(r3n,r3d);
    }

    /**
     * Returns a new fraction. Multiplies by the reciporcal.
     */
    public Rational divideRational(Rational r2){
        int r3n = this.numerator * r2.denominator;
        int r3d = this.denominator * r2.numerator;
        return new Rational(r3n,r3d);
    }

    /**
     * Simplifies the fraction using the greatest common factor.
     * Creates new rational.
     */
    public Rational simplifyRational(){
        Rational rsimp = new Rational(1,1);
        int gcf = this.greatestCommonFactor();
        rsimp.numerator = this.numerator/gcf;
        rsimp.denominator = this.denominator/gcf;
        return rsimp; 
    }

    /**
     * Takes a rational and finds the GCF. Sets the smaller number(from numerator and denominator)
     * equal to x and the larger equal to y. Z is then set to x for use in the loop.
     * It then looks to see if the x will go into y without a remainder. If it does than it is
     * the GCF. If not then it will divide x in half since it cannot be any number over half.
     * It then counts down until it finds a number that will divide into both x and y without
     * a remainder. If it doesn't find one, the GCF will be 1.
     */
    public int greatestCommonFactor(){
        int x = 0; //smaller number
        int y = 0; //larger number
        int z = 0; //for the loop
        int gcf = 0;
        if(this.numerator > this.denominator){
            y = this.numerator;
            x = this.denominator;
        }else{
            x = this.numerator;
            y = this.denominator;
        }
        z = x;
        if(y % x == 0){
            gcf = x;
        }else{
            x = x/2;
            for(int i = x; i>0; i--){
                if(y % x == 0 && z % x == 0){
                    gcf = x;
                    break;
                }else{
                    x--;
                }
            }
        }

        return gcf;
    }

    /**
     * Flips the value of the numerator and denominator and returns the Rational.
     */
    public Rational createReciporcal(){
        int numer = this.denominator; 
        int denom = this.numerator;
        return new Rational(numer, denominator);
    }

    /**
     * Turns the numerator and the denominator into a String.
     */
    public String toString(){
        String s = this.numerator + "/" + this.denominator;
        return s;
    }
    
    /**
     * Turns the numerator and the denominator into a String.
     */
    public void printRational(){
        System.out.print(this.toString());        
    }

    /**
     * Takes Rational argument.
     * Turns the numerator and the denominator into a String.
     */
    public boolean equals(Rational r){
        boolean b = false;
        Rational rational1 = this.simplifyRational();
        Rational rational2 = r.simplifyRational();
        if(rational1.toString().equals(rational2.toString())){
            b = true;
        }
        return b;
    }

    /**
     * Takes Object argument.
     * Turns the numerator and the denominator into a String.
     */
    public boolean equals(Object obj){
        boolean b = false;
        Rational r = (Rational)obj;
        Rational rational1 = this.simplifyRational();
        Rational rational2 = r.simplifyRational();
        if(rational1.toString().equals(rational2.toString())){
            b = true;
        }
        return b;
    }

    /**
     * Rounds down.
     */
    public int intValue(){
        int x = numerator/denominator;
        return x;
    }

    /**
     * Turns the numerator and the denominator into a String.
     */
    public double doubleValue(){
        double x = numerator;
        double y = denominator;
        double z = x/y;
        return z;
    }

    /**
     * Turns the numerator and the denominator into a String.
     */
    public float floatValue(){
        float x = numerator;
        float y = denominator;
        float z = x/y;
        return z;
    }

    /**
     * Rounds down.
     */
    public long longValue(){
        long x = numerator/denominator;
        return x;
    }

}
