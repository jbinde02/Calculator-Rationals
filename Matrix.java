
/**
 * This class represents a matrix of Rationals. It currently only works with 2X2 matricies.
 * Has some helpful methods to create new matricies.
 * Is immutable.
 *
 * @author Jacob Binder in conference with Nate Workman
 * @version 1.0
 */
public class Matrix{
    Rational[][] rationalMatrix;
    /**
     * 
     */
    private Matrix(){

    }

    /**
     * 
     */
    public Matrix(Rational topLeft, Rational topRight, Rational bottemLeft, Rational bottemRight)throws IllegalArgumentException{       
        rationalMatrix = new Rational[2][2];
        if(topLeft == null || topRight == null || bottemLeft == null || bottemRight == null){throw new IllegalArgumentException("Rational cannot be null");}
        this.rationalMatrix[0][0] = topLeft;
        this.rationalMatrix[0][1] = topRight;
        this.rationalMatrix[1][0] = bottemLeft;
        this.rationalMatrix[1][1] = bottemRight;
    }

    /**
     *  Adds each element with the corresponding element in the other array.
     *  @param Matrix Add by
     */
    public Matrix addMatrix(Matrix m){
        Matrix z = new Matrix(new Rational(1,1),new Rational(1,1),new Rational(1,1),new Rational(1,1));
        for(int i = 0; i<rationalMatrix.length; i++){
            for(int j = 0; j<rationalMatrix.length; j++){
                z.rationalMatrix[i][j] = this.rationalMatrix[i][j].addRational(m.rationalMatrix[i][j]);
            }
        }
        return z;
    }

    /**
     *  Subtracts each element with the corresponding element in the other array.
     *  @param Matrix Subtract by
     */
    public Matrix subtractMatrix(Matrix m){
        Matrix z = new Matrix(new Rational(1,1),new Rational(1,1),new Rational(1,1),new Rational(1,1));
        for(int i = 0; i<rationalMatrix.length; i++){
            for(int j = 0; j<rationalMatrix.length; j++){
                z.rationalMatrix[i][j] = this.rationalMatrix[i][j].subtractRational(m.rationalMatrix[i][j]);
            }
        }
        return z;
    }

    /**
     *  Simplfies each Rational in the Matrix.
     */
    public Matrix simplifyMatrix(){
        Matrix z = new Matrix(new Rational(1,1),new Rational(1,1),new Rational(1,1),new Rational(1,1));
        for(int i = 0; i<rationalMatrix.length; i++){
            for(int j = 0; j<rationalMatrix.length; j++){
                z.rationalMatrix[i][j] = this.rationalMatrix[i][j].simplifyRational();
            }
        }
        return z;
    }

    /**
     * Multiplies each element by the Rational argument.
     * @param RationalMultiply by
     */
    public Matrix timesRational(Rational r){
        Matrix z = new Matrix(new Rational(1,1),new Rational(1,1),new Rational(1,1),new Rational(1,1));
        for(int i = 0; i<rationalMatrix.length; i++){
            for(int j = 0; j<rationalMatrix.length; j++){
                z.rationalMatrix[i][j] = this.rationalMatrix[i][j].multiplyRational(r);
            }
        }
        return z;
    }

    /**
     * Multiplies two matricies.
     * @param Matrix Multiply by
     */
    public Matrix multiplyMatrix(Matrix m){

        Rational[] r1array = new Rational[rationalMatrix.length * rationalMatrix.length];
        Rational[] r2array = new Rational[rationalMatrix.length * rationalMatrix.length];
        int arraycount = 0;
        for(int i = 0; i<rationalMatrix.length; i++){
            for(int j = 0; j<rationalMatrix.length; j++){
                r1array[arraycount] = this.rationalMatrix[i][j].multiplyRational(m.rationalMatrix[j][i]);
                r2array[arraycount] = r1array[arraycount].addRational(r1array[arraycount]);
                arraycount++;
            }

        }
        Matrix z = new Matrix(r2array[0],r2array[1],r2array[2],r2array[3]);
        return z;
    }

    /**
     * Turns matrix into a String and prints it. 
     */
    public void printMatrix(){
        System.out.print(this.toString());
    }

    /**
     * Looks through matrix array and turns it into a string. Added some pipes and line breaks to make it look pretty.
     */
    public String toString(){
        String matrixString = "";
        for(int i = 0; i<rationalMatrix.length; i++){
            matrixString += "|";
            for(int j = 0; j<rationalMatrix.length; j++){
                matrixString += rationalMatrix[i][j].toString();
                matrixString += " ";
            }
            matrixString += "|\r\n";
        }
        return matrixString;
    }

    /**
     * Takes matrix argument.
     * Turns the matrices into strings and compares them.
     * 
     * @param Matrix Equal to
     */
    public boolean equals(Matrix m){
        boolean b = false;
        if(this.toString().equals(m.toString())){
            b = true;
        }
        return b;
    }

    /**
     * Takes Object argument.
     * Turns the matrices into strings and compares them.
     * 
     * @param Object Equal to
     */
    public boolean equals(Object obj){
        boolean b = false;
        if(this.toString().equals(obj.toString())){
            b = true;
        }
        return b;
    }
    
    /**
     * Gets element in Matrix
     * 
     * @param int Row
     * @param int Column
     */
    public Rational getElement(int row, int col){
        Rational r = this.rationalMatrix[row][col];
        return r;
    }
}
