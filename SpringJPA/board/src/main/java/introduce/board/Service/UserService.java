package introduce.board.Service;


import introduce.board.Entity.BoardEntity;
import introduce.board.Entity.UserEntity;
import introduce.board.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
 /**   public List<UserEntity> findUser(){
        return userRepository.findById();
    }**/
}
