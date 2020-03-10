package com.lirdaw.simpleuserrolerestapi.entity;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveUserWithUseOfConstructor1() {
        String login = "testLogin";
        String password = "testPassword";
        String email = "testEmail@api.com";
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String gender = "None";

        User theUser = new User(login, password, email, firstName, lastName, gender);
        User savedUser = this.testEntityManager.persistAndFlush(theUser);

        Assert.assertEquals(savedUser.getLogin(), login);
        Assert.assertEquals(savedUser.getPassword(), password);
        Assert.assertEquals(savedUser.getEmail(), email);
        Assert.assertEquals(savedUser.getFirstName(), firstName);
        Assert.assertEquals(savedUser.getLastName(), lastName);
        Assert.assertEquals(savedUser.getGender(), gender);
        Assert.assertNull(savedUser.getRoles());
    }

    @Test
    public void saveUserWithUseOfConstructor2() {
        String login = "testLogin";
        String password = "testPassword";
        String email = "testEmail@api.com";
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String gender = "None";
        Set<Role> roles = new HashSet<>();
        roles.add(saveRole("testRole1"));
        roles.add(saveRole("testRole2"));

        User theUser = new User(login, password, email, firstName, lastName, gender, roles);
        User savedUser = this.testEntityManager.persistAndFlush(theUser);

        Assert.assertEquals(savedUser.getLogin(), login);
        Assert.assertEquals(savedUser.getPassword(), password);
        Assert.assertEquals(savedUser.getEmail(), email);
        Assert.assertEquals(savedUser.getFirstName(), firstName);
        Assert.assertEquals(savedUser.getLastName(), lastName);
        Assert.assertEquals(savedUser.getGender(), gender);
        Assert.assertEquals(savedUser.getRoles(), roles);
        Assert.assertEquals(savedUser.getRoles().size(), 2);
        Assert.assertTrue(savedUser.getRoles().containsAll(roles));
    }

    @Test
    public void saveUserWithUseOfSetters() {
        int idUser = 0;
        String login = "testLogin";
        String password = "testPassword";
        String email = "testEmail@api.com";
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String gender = "None";
        Set<Role> roles = new HashSet<>();
        roles.add(saveRole("testRole1"));
        roles.add(saveRole("testRole2"));

        User theUser = new User();
        theUser.setIdUser(idUser);
        theUser.setLogin(login);
        theUser.setPassword(password);
        theUser.setEmail(email);
        theUser.setFirstName(firstName);
        theUser.setLastName(lastName);
        theUser.setGender(gender);
        theUser.setRoles(roles);
        User savedUser = this.testEntityManager.persistAndFlush(theUser);

        Assert.assertEquals(savedUser.getLogin(), login);
        Assert.assertEquals(savedUser.getPassword(), password);
        Assert.assertEquals(savedUser.getEmail(), email);
        Assert.assertEquals(savedUser.getFirstName(), firstName);
        Assert.assertEquals(savedUser.getLastName(), lastName);
        Assert.assertEquals(savedUser.getGender(), gender);
        Assert.assertEquals(savedUser.getRoles(), roles);
        Assert.assertEquals(savedUser.getRoles().size(), 2);
        Assert.assertTrue(savedUser.getRoles().containsAll(roles));
    }

    Role saveRole(String name) {
        Role theRole = new Role(name);
        return this.testEntityManager.persistAndFlush(theRole);
    }

    @Test
    void testToString() {
        String login = "testLogin";
        String password = "testPassword";
        String email = "testEmail@api.com";
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String gender = "None";

        User theUser = new User(login, password, email, firstName, lastName, gender);
        User savedUser = this.testEntityManager.persistAndFlush(theUser);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String expectedResult = "User{idUser=" + savedUser.getIdUser() + ", login='testLogin', password='testPassword', email='testEmail@api.com', firstName='testFirstName', lastName='testLastName', gender='None', roles=null}" + System.lineSeparator();
        System.setOut(new PrintStream(outContent));

        System.out.println(savedUser.toString());

        assertEquals(expectedResult, outContent.toString());
    }
}