package io.easywalk.simplymessagingproducer.user;

import io.easywalk.simplymessagingproducer.user.entities.Contact;
import io.easywalk.simplymessagingproducer.user.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {


    @Autowired
    UserService service;

    @Test
    public void bulk_100000() {
        IntStream.range(1, 100000).parallel().forEach(num -> {
            Contact contact = new Contact();
            contact.setType(Contact.Type.HOME);
            contact.setContact("000000000000");
            User testUser = new User("1TestUser" + num, "1test" + num + "@example.com");
            testUser.setContacts(List.of(contact));

            User testUser01 = service.create(testUser);
            User user       = service.get(testUser01.getId());
            assertEquals(testUser01.getId(), user.getId());
        });
    }

    @Test
    public void create_succeed() {
        User testUser01 = service.create(new User("TestUser01", "test01@example.com"));
        User user       = service.get(testUser01.getId());
        assertEquals(testUser01.getId(), user.getId());
    }

    @Test
    public void update_succeed() throws Throwable {
        User testUser02 = service.create(new User("TestUser02", "test02@example.com"));
        User user       = service.get(testUser02.getId());
        assertEquals(testUser02.getId(), user.getId());

        Map<String, Object> fields = new HashMap<>();
        fields.put("name", "홍길서");
        service.updateById(user.getId(), fields);
    }

    @Test
    public void update_deleteById_succeed() throws Throwable {
        User testUser03 = service.create(new User("TestUser03", "test03@example.com"));
        User user       = service.get(testUser03.getId());
        assertEquals(testUser03.getId(), user.getId());

        Map<String, Object> fields = new HashMap<>();
        fields.put("name", "홍길서");
        service.updateById(user.getId(), fields);

        service.deleteById(user.getId());
    }

    @Test
    public void update_delete_succeed() throws Throwable {
        User testUser04 = service.create(new User("TestUser04", "test04@example.com"));
        User user       = service.get(testUser04.getId());
        assertEquals(testUser04.getId(), user.getId());

        Map<String, Object> fields = new HashMap<>();
        fields.put("name", "홍길서");
        User user1 = service.updateById(user.getId(), fields);

        service.delete(user1);
    }

    @Test
    public void update_delete_deletebyid_succeed() throws Throwable {
        User testUser05 = service.create(new User("TestUser05", "test05@example.com"));
        User user       = service.get(testUser05.getId());
        assertEquals(testUser05.getId(), user.getId());

        Map<String, Object> fields = new HashMap<>();
        fields.put("name", "홍길서");
        User user1 = service.updateById(user.getId(), fields);

        service.delete(user1);
        service.deleteById(user.getId());
    }

}