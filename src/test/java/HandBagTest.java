/*
 * This file contains JUnit test cases for HandBag.java and the
 * methods from Bag.java.
 *
 * You should NOT modify this file! When you push Basics.java to
 * GitHub, it should run these tests. You can see the results in the
 * "Actions" tab of your repository.
 */

import org.junit.*;

import static org.junit.Assert.*;


public class HandBagTest {
    HandBag b;

    @Before
    public void setUp() throws Exception {
        b = new HandBag("Blue", 4);
    }

    @Test(timeout = 50)
    public void testGetColor() {
        assertEquals("Blue", b.getColor());
    }

    @Test(timeout = 50)
    public void testGetNumberOfContentsEmpty() {
        assertEquals(0, b.getNumberOfContents());
    }

    @Test(timeout = 50)
    public void testGetNumberOfContentsNonEmpty() {
        b.addItem("Cheese");
        b.addItem("Eggs");
        assertEquals(2, b.getNumberOfContents());
    }

    @Test(timeout = 50)
    public void testGetNumberOfContentsPop() {
        b.addItem("Cheese");
        b.addItem("Eggs");
        String[] s2 = {"cookies", "butter", "milk", "Cheese"};
        String[] s1 = new String[4];
        assertEquals("Eggs", b.popItem());
        assertEquals(1, b.getNumberOfContents());
        assertEquals(true, b.addItem("milk"));
        assertEquals(true, b.addItem("butter"));
        assertEquals(3, b.getNumberOfContents());
        assertEquals(true, b.addItem("cookies"));
        assertEquals(false, b.addItem("sugar"));
        assertEquals(4, b.getNumberOfContents());
        s1[0] = b.popItem();
        assertEquals(3, b.getNumberOfContents());
        s1[1] = b.popItem();
        assertEquals(2, b.getNumberOfContents());
        s1[2] = b.popItem();
        s1[3] = b.popItem();
        assertEquals(true, java.util.Arrays.equals(s1, s2));
        assertEquals(0, b.getNumberOfContents());
    }

    @Test(timeout = 50)
    public void TestGetCapacity() {
        assertEquals(4, b.getCapacity());
    }

    @Test(timeout = 50)
    public void TestSetColor() {
        b.setColor("Red");
        assertEquals("Red", b.getColor());
    }

    @Test(timeout = 50)
    public void TestIncreaseCapacity() {
        b.increaseCapacity(2);
        assertEquals(6, b.getCapacity());
        assertEquals(0, b.getNumberOfContents());
        assertEquals(null, b.popItem());
        assertEquals(true, b.addItem("cheese"));
        assertEquals(1, b.getNumberOfContents());
        assertEquals(6, b.getCapacity());
        assertEquals("cheese", b.popItem());
        assertEquals(0, b.getNumberOfContents());
        b.increaseCapacity(1);
        assertEquals(7, b.getCapacity());
        assertEquals(null, b.popItem());
        assertEquals(0, b.getNumberOfContents());
        assertEquals(true, b.addItem("cheese"));
        assertEquals(true, b.addItem("milk"));
        assertEquals(2, b.getNumberOfContents());
        b.increaseCapacity(3);
        assertEquals(10, b.getCapacity());
        assertEquals("milk", b.popItem());
        assertEquals("cheese", b.popItem());
        assertEquals(null, b.popItem());

    }

    @Test(timeout = 50)
    public void TestEnhance() {
        b.enhance();
        assertEquals(5, b.getCapacity());
    }

}