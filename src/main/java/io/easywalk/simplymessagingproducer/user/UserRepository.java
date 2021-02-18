package io.easywalk.simplymessagingproducer.user;

import io.easywalk.simplymessagingproducer.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
