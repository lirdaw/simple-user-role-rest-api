package com.lirdaw.simpleuserrolerestapi;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class ApplicationTestIT {
    @Test
    // test added ONLY to cover main(), not covered by application tests
    public void contextLoads() {
        Application.main(new String[]{});
    }
}