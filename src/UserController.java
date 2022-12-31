import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> usersList = new ArrayList<>();

    public UserController() {
    }

    public void addUser(User user){
        usersList.add(user);
    }

}
