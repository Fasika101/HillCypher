public class Crypt {
    private Matrix matrix=new Matrix();
    private MKey key=new MKey();
    private Matrix crypt = new Matrix();

    public void Crypt(Matrix matrix, MKey key)
    {
        this.matrix=matrix;
        this.key=key;
        this.crypt.Matrix(this.matrix.getRows(), this.matrix.getCols());
    }

    private void mod(){
        for (int i=0;i<crypt.getRows();i++)
        {
            for (int j=0;j<crypt.getCols();j++)
            {
                crypt.changeEntry(i,j,crypt.getEntry(i,j)%26);
            }
        }
    }
    public void Mult()
    {
        int tot=0;
        for(int i=0; i<matrix.getRows();i++)            //row of key
        {
            for(int j=0; j<matrix.getCols();j++)        //col of matrix
            {
                for (int k=0; k<matrix.getRows();k++)   //row of matrix and col of key
                {
                    tot+=matrix.getEntry(k,j)*key.getMatrix().getEntry(i,k);
                }
                crypt.changeEntry(i,j,tot);
                tot=0;
            }
        }
        mod();
    }

    public Matrix getCrypt() {
        return crypt;
    }
}
