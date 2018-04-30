import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
    private int rows;       //number of rows in the matrix
    private int cols;       //number of cols in the matrix
    private int[][] mtx;    //the matrix itself

    /**
     * Sets the size of the matrix
     * @param rows: rows in the matrix
     * @param cols:cols in the matrix
     */
    public void Matrix(int rows, int cols) {
        this.rows = rows;                   //Set rows
        this.cols = cols;                   //Set cols
        this.mtx = new int[rows][cols];     //Create empty matrix
    }

    /**
     * Sets the size and input of the matrix from a string
     * @param s: input string
     */
    public void Matrix(String s) {
        Input in=new Input();               //Create Input
        in.Input(s);                        //instantiate Input
        Matrix(in);                         //pass off rest of work to Input function
    }

    /**
     * Sets the size and input of the matrix from an integer
     * @param i: input integer
     */
    public void Matrix(int i) {
        Input in=new Input();               //Create Input
        in.Input(i);                        //instantiate Input
        Matrix(in);                         //pass of rest of work to Input function
    }

    /**
     * Sets the size and input of the matrix from an Input object
     * @param in: the Input object
     */
    public void Matrix(Input in) {
        Matrix(in.getIn());                 //pass of work to int[] function
    }

    /**
     * Sets the size and input of the matrix from an array of integers
     * @param in: array of integers
     */
    public void Matrix(int[] in) {
        if(in.length%6==0 || in.length%3==0 || (in.length%3==2 && in.length%2!=0))          //356
        {
            rows=3;                                                     //set rows to 3
        }
        else                                                            //124
        {
            rows=2;                                                     //set rows to 2
        }
        cols=in.length/rows;                                            //set cols to length floor divide rows
        if(in.length%rows!=0)                                           //if there is overflow
        {
            cols++;                                                     //add a column
            //add the last letter(number) twice
            int[]temp=new int[in.length+1];                             //create a temp in array that is 1 bigger
            temp= Arrays.copyOf(in, in.length+1);              //copy over the in array to temp
            temp[temp.length-1]=temp[temp.length-2];                    //double the last letter
            in=temp;                                                    //set in to the temp array
        }
        this.mtx = new int[rows][cols];                                 //create the empty matrix
        fillRows(in);                                                   //pass off the row fill to other function
    }

    /**
     * Fills a matrix with values from an array
     * @param code: array of values to fill the matrix with
     * @return true if the matrix is filled and the array is emptied
     */
    public boolean fillRows(int[] code) {
        int i=0;                                                        //instantiate i to keep track of rows
        int j=0;                                                        //instantiate j to keep track of cols
        for (int k=0; k<code.length; k++)                               //iterate through code array
        {
            if (j==this.cols-1)                                //manage rows so they reset back to 0 and don't overflow
            {
                if (i==this.rows-1)                                     //manage cols so it does not overflow
                {
                    if(k!=code.length-1)                                //check for left over values in code array
                    {
                        return false;                                   //false if all values not applied
                    }
                    mtx[i][j]=code[k];
                    return true;                                     //true when code array is empty and matrix is full
                }
                mtx[i][j]=code[k];
                j=0;                                                    //reset i(rows)
                i++;                                                    //increment j(cols)
            }
            else
            {
                mtx[i][j] = code[k];
                j++;                                                        //increment i(rows)
            }
        }
        return false;                                                   //if it reaches this point it failed
    }

    /**
     * Alter a single value in the matrix
     * @param row: row of the entry
     * @param col: col of the entry
     * @param value: the int value to enter
     * @return true if successful
     */
    public boolean changeEntry(int row, int col, int value)
    {
        if(value>=26)
        {
            value=value%26;
        }
        if (row<rows && col<cols && value>=0 && value < 26)//Check the the input is in mod26, and will fit in the matrix
        {
            mtx[row][col] = value;                                      //input the value into the matrix
            return true;                                                //return true signifying successful insertion
        }
        return false;                                                   //return false signifying failed insertion
    }

    /**
     * Get the value at a certain place in the matrix
     * @param row: row of the entry
     * @param col: col of the entry
     * @return the value
     */
    public int getEntry(int row, int col)
    {
        return this.mtx[row][col];
    }       //return an entry at a specified location

    /**
     * Report the number of columns
     * @return cols
     */
    public int getCols() {
        return cols;
    }       //return the column dimension

    /**
     * Report the number of rows
     * @return rows
     */
    public int getRows() {
        return rows;
    }       //return the row dimension

    /**
     * Report the matrix object
     * @return mtx
     */
    public int[][] getMtx() {
        return mtx;
    }       //return the matrix object

    /**
     * Report the stringified matrix
     * @return string of mtx
     */
    @Override
    public String toString (){
        String temp = "";               //initialize the string to return
        for (int i=0; i<rows; i++)      //iterate through the rows
        {
            for (int j = 0; j < cols; j++)      //iterate through the columns
            {
                temp+=mtx[i][j]+"\t";     //add the value to the string followed by a tab character
            }
            temp+="\n";                         //at the end of a row add a new line
        }
        return temp;            //return the string representation of the matrix
    }

    /**
     * Report the message the matrix holds
     * @return string message
     */
    public String message(){
        String temp = "";               //initialize the string to return
        Map m = new Map();
        for (int i=0; i<rows; i++)      //iterate through the rows
        {
            for (int j = 0; j < cols; j++)      //iterate through the columns
            {
                temp+=m.getChar(mtx[i][j]);     //add the value to the string
            }
        }
        return temp;            //return the message of the matrix
    }
}
