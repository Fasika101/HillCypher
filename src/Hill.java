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
        String again="";
        do {

            //Input message
            String message = "";
            System.out.println("Please input your message.");
            try {
                message = dis.readLine();
            } catch (Exception e) {
            }

            //Create matrix
            matrix.Matrix(message);

            //Enter key?
            String userkey = "";
            do {
                System.out.println("Do you want to enter the encrypting key?(y/n)");
                try {
                    userkey = dis.readLine();
                    userkey = userkey.toLowerCase();
                } catch (Exception e) {
                }
            } while (!userkey.equals("y") && !userkey.equals("n"));
            String uk = "";
            key.MKey(message);
            if (userkey.equals("y")) {
                do {
                    System.out.println("Please enter the encrypting key string");
                    try {
                        uk = dis.readLine();
                    } catch (Exception e) {
                    }
                }
                while (uk.trim().replaceAll("[^A-Za-z]+", "").toUpperCase().length() != (key.getMatrix().getRows() * key.getMatrix().getCols()));
                key.fillK(uk);
            } else {
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
            } while (!process.equals("e") && !process.equals("d"));
            if (process.equals("d") && userkey.equals("n")) {
                key.setK(key.getI());
            }
            encrypt.Crypt(matrix, key);
            encrypt.Mult();

            System.out.println("The resulting matrix is:\n" + encrypt.getCrypt().toString() + "\nThe message it holds is:\n"
                    + encrypt.getCrypt().message());
            System.out.println("Do you want to go again? (y/n)");
            try {
                again = dis.readLine();
            } catch (Exception e) {
            }
        }while(again.equals("y") || again.equals("Y"));
    }
}
