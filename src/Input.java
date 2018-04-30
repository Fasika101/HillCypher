public class Input {
    private String st;      //
    private int[] in;       //

    public void Input(String st){
        this.st=st.trim().replaceAll("[^A-Za-z]+", "").toUpperCase();
        this.in = new int[this.st.length()];
        Map m = new Map();
        m.Map();
        for (int i=0;i<this.st.length();i++)
        {
            in[i]=m.getInt(this.st.charAt(i));
        }
    }

    public void Input(int in){
        int c=0;
        Map m = new Map();
        do
        {
            this.in[c]=(in%10);
            in /= 10;
            c++;
        } while(in>0);
        this.st="";
        for (int i=0; i<this.in.length; i++)
        {
            st+=m.getChar(this.in[i]);
        }
    }

    public void Input(Matrix mx){
        in = new int[mx.getRows()*mx.getCols()];
        int c=0;
        for (int i=0; i<mx.getMtx().length; i++)
        {
            for (int j=0; i<mx.getMtx().length; i++)
            {
                in[c]=mx.getEntry(i,j);
                c++;
            }
        }
        Map m = new Map();
        this.st="";
        for (int i=0; i<this.in.length; i++)
        {
            st+=m.getChar(this.in[i]);
        }
    }

    public String getSt() {
        return st;
    }

    public int[] getIn(){
        return in;
    }

    public String getInString(){
        String temp="";
        for (int i=0; i<in.length; i++)
        {
            temp+=in[i] + "\t";
        }
        temp+="\n";
        return temp;
    }
}
