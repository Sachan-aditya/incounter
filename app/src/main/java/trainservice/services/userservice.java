package trainservice.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import trainservice.entities.user;
import trainservice.util.userserviceutil;

public class userservice {
    private user user;
    List<user> userList;
    private ObjectMapper mapper = new ObjectMapper();
    private static final String USER_PATH = "../localdb/user.json";

    public userservice(user user1) throws IOException {
        this.user = user1;
        File users = new File(USER_PATH);
        userList = mapper.readValue(users, new TypeReference<List<user>>() {});
    }

    public boolean login() {
        Optional<user> foundUser = userList.stream().filter(user1 ->
                user1.getUsername().equals(user.getUsername()) &&
                        userserviceutil.checkPassword(user.getPassword(), user1.getHashedPassword())
        ).findFirst();

        return foundUser.isPresent();
    }
    public boolean signup(user user1) {
        try {
            userList.add(user1);
            saveuserlistfile();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
private void saveuserlistfile()throws IOException
        {
            File userFile = new File(USER_PATH);
            mapper.writeValue(userFile, userList);

        }
        public void printicket()
        {
            for(user u:userList)
            {
                System.out.println(u.getUsername());
            }

        }
        public void fetchbooking()
        {
            printicket();
        }

}
