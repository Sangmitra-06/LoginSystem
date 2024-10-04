/**
 * This class implements a login system with hardcoded valid username and password values from the backend.
 *
 * @author     Sangmitra Madhusudan
 * @course     COSC 4P01
 * @assignment #1
 * @student Id 7115900
 * @version    1.0
 * @since      October 4th 2024
 */


public class UserLoginSystem {
    private final int MAXATTEMPTS = 3; // constant for the maximum number of attempts allowed
    private int userAttempts = 0; // number of invalid attempts by the user
    private final String[] USERNAMES ={"Sangmitra", "NotSangmitra"}; // constant for valid usernames
    private final String[] PASSWORDS ={"hello123","password123"}; // constant for valid passwords


    /* Function that checks if a username or password is valid and present in valid usernames and passwords.
     * It also checks if a user has exceeded their invalid login attempts and locks them out of the account.
     *
     * @param username is the username to be checked as valid or invalid
     * @param password is the password to be checked as valid or invalid
     *
     * @return String is the result of the validity check, which is used in the test cases.
     */

    public String login(String username, String password){
        // locks the user out if the user is done with their login attempts
        if(userAttempts > MAXATTEMPTS){
            return "Alert: Account locked due to too many failed login attempts";
        }
        // checks if the username or password are null
        else if(username==null || password==null){
            return "Error: empty username or password received";
        }
        // checks if the username or password are empty
        else if(username.isEmpty() || password.isEmpty()){
            return "Error: empty username or password received";
        }
        // checks for validity if the username and password are not empty or null and if the user has not exceed the
        // login attempts
        for(int i = 0; i< USERNAMES.length; i++){
            // compares the username to ones present in the valid usernames and compares the password to the ones present
            // in valid passwords
            if(username.equals(USERNAMES[i]) && password.equals(PASSWORDS[i])){
                return "Login Successful";
            }
        }
        // if the attempt was invalid, update the count for the number of user attempts
        userAttempts++;
        // locks the user out if the user is done with their login attempts
        if(userAttempts > MAXATTEMPTS){
            return "Alert: Account locked due to too many failed login attempts";
        }
        return "Login unsuccessful, username or password incorrect";
    } //login
} // UserLoginSystem