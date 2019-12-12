package com.chadi.aws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class ControllerTests {

    @Test
   public   void testOne() {
        System.out.println("test");
        assertEquals(2, 2);
    }
}
