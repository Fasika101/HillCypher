import java.util.Arrays;
public class Map {
    private char[] c = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public void Map()
    {
        c = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    }

    public int getInt(char s){
        return (Arrays.binarySearch(c,s));
    }

    public char getChar(int i){
        return c[i];
    }

    @Override
    public String toString(){
        String temp="";
        for (int i=0; i<c.length;i++)
        {
            temp+=c[i]+"\t";
        }
        temp+="\n";
        for (int i=0; i<c.length;i++)
        {
            temp+=i+"\t";
        }
        temp+="\n";
        return temp;
    }
}
