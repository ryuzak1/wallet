package com.wallet.repository;


import com.wallet.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    public static String email="casa@casa.com";


    @Autowired
    UserRepository repository;

    @Before
    public void setUp(){
        User u = new User();
        u.setNome("Robson");
        u.setEmail(email);
        u.setPassword("123");

        repository.save(u);

    }

    @After
    public void terDown(){
        repository.deleteAll();


    }

    @Test
    public void testSave(){
        User u = new User();
        u.setNome("Jose");
        u.setPassword("123");
        u.setEmail("jose@jose.com");

        User responde = repository.save(u);
        System.out.println(responde.getNome());

        assertNotNull(responde);
    }

    public void testFindByEmail(){

        Optional<User>responde = repository.findByEmail(email);
        assertTrue(responde.isPresent());
        assertEquals(responde.get().getEmail(),email);

    }
}
