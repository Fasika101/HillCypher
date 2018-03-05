import org.omg.CORBA.MARSHAL;

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
        this.rows = rows;
        this.cols = cols;
        this.mtx = new int[rows][cols];
    }

    public void Matrix(String s) {
        Input in=new Input();
        in.Input(s);
        Matrix(in);
    }

    public void Matrix(Input in) {
        Matrix(in.getIn());
    }

    public void Matrix(int[] in) {
        if(in.length%6==0 || in.length%3==0 || in.length%3==2)
        {
            rows=3;
        }
        else
        {
            rows=2;
        }
        cols=in.length/rows;
        if(in.length%rows!=0)
        {
            cols++;
        }
        this.mtx = new int[rows][cols];
        fillRows(in);
    }

    /**
     * Fills a matrix with values from an array
     * @param code: array of values to fill the matrix with
     * @return true if the matrix is filled and the array is emptied
     */
    public boolean fillRows(int[] code) {
        int i=0;
        int j=0;
        for (int k=0; k<code.length; k++)
        {
            if (i==this.rows-1)
            {
                if (j==this.cols-1)
                {
                    if(k!=code.length-1)
                    {
                        return false;
                    }
                    return true;
                }
                i=0;
                j++;
            }
            i++;
        }
        return false;
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
        if (row<rows && col<cols && value>=0 && value < 26)
        {
            mtx[row][col] = value;
            return true;
        }
        return false;
    }

    /**
     * Get the value at a certain place in the matrix
     * @param row: row of the entry
     * @param col: col of the entry
     * @return the value
     */
    public int getEntry(int row, int col)
    {
        return mtx[row][col];
    }

    /**
     * Report the number of columns
     * @return cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * Report the number of rows
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    public int[][] getMtx() {
        return mtx;
    }

    public String toString (){
        String temp = "";
        for (int i=0; i<rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                temp+=mtx[rows][cols]+"\t";
            }
            temp+="\n";
        }
        return temp;
    }
}
