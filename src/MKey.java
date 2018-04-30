import javax.swing.text.MutableAttributeSet;

public class MKey{
    Matrix k;       //Holds the matrix key
    Matrix i;

    /**
     * Takes in the message string and determines the size of the matrix key
     * Then instantiates the matrix key
     * @param s Message string
     */
    public void MKey(String s){
        int n;      //key size
        k=new Matrix();
        if(s.length()%6==0 || s.length()%3==0 || (s.length()%3==2 && s.length()%2!=0))   //356
        {
            n=3;            //Set key size to 3
        }
        else                //124
        {
            n=2;            //set key size to 2
        }
        k.Matrix(n,n);      //instantiate empty key
        fillK();
    }

    public void fillK(){
        String s="";
        String si="";
        if (k.getRows() == 3) {
            s = "DKUUJRJER";
        } else {
            s = "ZRPR";
        }
        if (k.getRows() == 3) {
            si = "LWOHJVRAD";
        } else {
            si = "RJLZ";
        }
        i=new Matrix();
        i.Matrix(si);
        fillK(s);
    }

    public void fillK(String s){
        k.Matrix(s);
    }

    public Matrix getMatrix(){
            return k;
    }

    public Matrix getI() {
        return i;
    }

    public void setK(Matrix k){
            this.k=k;
    }
}
