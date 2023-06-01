package System;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
    @Test
    public void TestConstructor() {
        assertEquals("welson",a.getUserName());
        assertEquals("123456",a.getPassword());
        assertEquals("2003-03-24",a.getBirthDate().toString());
        assertEquals(2500.0,2500.0,0.1);
    }

}