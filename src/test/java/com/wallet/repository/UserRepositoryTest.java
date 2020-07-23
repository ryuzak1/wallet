package com.wallet.repository;


import com.wallet.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {


    @Autowired
    UserRepository repository;

    @Test
    public void testSave(){
        User u = new User();
        u.setNome("Jose");
        u.setPassword("123");
        u.setEmail("jose@jose.com");

        User responde = repository.save(u);

        assertNotNull(responde);
    }
}
