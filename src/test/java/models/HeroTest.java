package models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HeroTest {

    @Test
    public void instantiateClass(){
        new Hero("Glory", 25, "Beauty", "Pride");
        assertTrue(true);
    }
}