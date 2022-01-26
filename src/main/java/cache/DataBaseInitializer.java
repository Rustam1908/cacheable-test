package cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataBaseInitializer {

    private final UserRepository userRepository;

    @Autowired
    public DataBaseInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        if (userRepository.findAll().iterator().hasNext()) return;

        User user1 = new User();
        user1.setFirstName("Stam");
        user1.setLastName("Stamov");
        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("Mick");
        user2.setLastName("Mickov");
        userRepository.save(user2);

        User user3 = new User();
        user3.setFirstName("Anna");
        user3.setLastName("Annova");
        userRepository.save(user3);
    }
}
