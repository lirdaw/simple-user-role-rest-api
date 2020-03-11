package com.lirdaw.simpleuserrolerestapi.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RoleTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void saveUserWithUseOfConstructor() {
        String roleName = "Test Role";
        Role theRole = new Role(roleName);

        Role savedRole = this.testEntityManager.persistAndFlush(theRole);

        Assert.assertEquals(savedRole.getName(), roleName);
    }

    @Test
    public void saveRoleWithUseOfSetters() {
        int idRole = 0;
        String roleName = "Test Role";

        Role theRole = new Role();
        theRole.setIdRole(idRole);
        theRole.setName(roleName);

        Role savedRole = this.testEntityManager.persistAndFlush(theRole);

        Assert.assertEquals(savedRole.getName(), roleName);
    }

    @Test
    void testToString() {
        String roleName = "Test Role";
        Role theRole = new Role(roleName);

        Role savedRole = this.testEntityManager.persistAndFlush(theRole);

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String expectedResult = "Role{idRole=" + savedRole.getIdRole() + ", name='Test Role'}" + System.lineSeparator();
        System.setOut(new PrintStream(outContent));

        System.out.println(savedRole.toString());

        assertEquals(expectedResult, outContent.toString());
    }
}