import java.io.DataInputStream;

public class Hill {
    //doubly stochastic matrices
    //Special Orthogonal Matrix



    public static void main (String[] args){
        //Variables
        Matrix matrix= new Matrix();
        MKey key = new MKey();
        Crypt encrypt = new Crypt();

        //Set up input read
        DataInputStream dis = new DataInputStream(System.in);

        //Input message
        String message = "";
        System.out.println("Please input your message.");
        try {
            message=dis.readLine();
        }
        catch (Exception e){}

        //Create matrix
        matrix.Matrix(message);

        //Enter key?
        String userkey="";
        do {
            System.out.println("Do you want to enter the encrypting key?(y/n)");
            try {
                userkey=dis.readLine();
                userkey=userkey.toLowerCase();
            }
            catch (Exception e){}
            if (userkey.equals("y")) {
                String uk = "";
                System.out.println("Please enter the encrypting key string");
                try {
                    uk = dis.readLine();
                } catch (Exception e) {
                }
                key.fillK(uk);
            }
        }while(!userkey.equals("y") && !userkey.equals("n"));
        if(userkey.equals("y"))
        {
            String keying = "";
            System.out.println("Please input the key.");
            try {
                keying=dis.readLine();
            }
            catch (Exception e){}
            key.MKey(message);
            key.fillK(keying);
        }
        else
        {

            key.MKey(message);
            key.fillK();
        }
        //get process
        String process = "";
        do {
            System.out.println("Encrypt(e) or Decrypt(d).");
            try {
                process = dis.readLine();
                process = process.toLowerCase();
            } catch (Exception e) {
            }
        }while(!process.equals("e") && !process.equals("d"));
        if (process.equals("d") && userkey.equals("n"))
        {
            key.setK(key.getI());
        }
        encrypt.Crypt(matrix,key);
        encrypt.Mult();

        System.out.println("The resulting matrix is:\n" + encrypt.getCrypt().toString() + "\nThe message it holds is:\n"
                    + encrypt.getCrypt().message());
    }
}
