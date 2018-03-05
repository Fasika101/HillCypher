public class MKey {
    Matrix k;

    public void MKey(String s){
        int n;
        if(s.length()%6==0 || s.length()%3==0 || s.length()%3==2)
        {
            n=3;
        }
        else
        {
            n=2;
        }
        k.Matrix(n,n);
    }
}
