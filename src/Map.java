import java.util.Arrays;
public class Map {
    private char[] c = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public void Map()
    {

    }

    public int getInt(char s){
        return (Arrays.binarySearch(c,s));
    }

    public char getChar(int i){
        return c[i];
    }

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
