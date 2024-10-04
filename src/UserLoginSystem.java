import java.util.Scanner;

public class UserLoginSystem {
    private int maxattempts = 3;
    private int userattempts = 0;
    private String[] usernames={"Sangmitra", "NotSangmitra"};
    private String[] passwords={"hello123","password123"};

    public UserLoginSystem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String enteredusername=scanner.nextLine();
        System.out.println("Enter your password");
        String enteredpassword=scanner.nextLine();
        String result=login(enteredusername,enteredpassword);
        System.out.println(result);
    }
    public String login(String username, String password){
        if(userattempts>maxattempts){
            return "Alert: Account locked due to too many failed login attempts";
        }
        if(username.isEmpty() | password.isEmpty()){
            return "Error: empty username or password received";
        }
        for(int i=0;i<usernames.length;i++){
            if(username.equals(usernames[i]) & password.equals(passwords[i])){
                return "Login Successful";
            }
        }
        userattempts++;
        if(userattempts>maxattempts){
            return "Alert: Account locked due to too many failed login attempts";
        }
        return "Login unsuccessful, username or password incorrect";
    }

    public static void main(String[] args){
        UserLoginSystem u = new UserLoginSystem();
    }
}
