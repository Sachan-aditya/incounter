package trainservice.util;

import org.mindrot.jbcrypt.BCrypt;

public class userserviceutil {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Method to check if a given password matches the hashed password
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);

    }
}