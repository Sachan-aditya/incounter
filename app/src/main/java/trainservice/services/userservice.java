package trainservice.services;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import trainservice.entities.user;
public class userservice {
    private user user;
    List<user> userlist;
    private  ObjectMapper mapper=new ObjectMapper();
    private  static final String userpath="../localdb/user.json";
    public userservice(user user1) throws IOException
    {
this.user=user1;
File users=new File(userpath);
userlist=mapper.readValue(users, new TypeReference<List<user>>(){});
    }
public boolean login()
{
    Optional<user> founduser=userlist.stream().filter(user1 -> {
        return user1.getName().equals(user.getName()) && UserServiceUtil.checkpassword()
    })
}
}
