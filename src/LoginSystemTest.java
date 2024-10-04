import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class LoginSystemTest {
    private UserLoginSystem system;

    @BeforeEach
    public void setSystem(){
        system = new UserLoginSystem();
    }

    @Test
    public void validateCorrectLogin(){
        result=system.login("Sangmitra","hello123");
        assertEquals(result, "Login Successful");
    }

    @Test
    public void validateIncorrectLogin(){
        result=system.login("Sangmitra01","hey");
        assertEquals(result, "Login unsuccessful, username or password incorrect");
    }

    @Test
    public void validateLocking(){
        system.login("Sangmitra01","hey");
        system.login("Sangmitra01","hey");
        system.login("Sangmitra01","hey");
        result=system.login("Sangmitra01","hey");
        assertEquals(result, "Alert: Account locked due to too many failed login attempts");
    }

    @Test
    public void validateEmpty(){
        result=system.login("","");
        assertEquals(result,"Error: empty username or password received");
    }

    @Test
    public void validateNull(){
        result=system.login(null,null);
        assertEquals(result,"Error: no username and password entered");
    }

    @Test
    public void validateCaseSensitivity(){
        result=system.login("SAngmitra","hello123");
        assertEquals(result,"Login unsuccessful, username or password incorrect");
    }
    @Test
    public void validateSpaces(){
        result=system.login("Sangmitra ","hello123");
        assertEquals(result,"Login unsuccessful, username or password incorrect");
    }
}
