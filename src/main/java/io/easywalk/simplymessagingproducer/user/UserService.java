package io.easywalk.simplymessagingproducer.user;

import io.easywalk.simply.serviceable.AbstractServiceable;
import io.easywalk.simply.specification.eventable.annotations.SimplyProducerService;
import io.easywalk.simplymessagingproducer.user.entities.User;
import org.springframework.stereotype.Service;

@SimplyProducerService("user")
@Service
public class UserService extends AbstractServiceable<User, Long> {
    protected UserService(UserRepository repository) {
        super(repository);
    }
}
