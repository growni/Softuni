package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameWithNullOrEmptySpace() {
        House house = new House(null, 10);
    }

    @Test
    public void testHouseShouldSetNameCorrectly() {
        House house = new House("test-name", 2);
        Assert.assertEquals(house.getName(), "test-name");
    }

    @Test
    public void testGetCapacity() {
        House house = new House("test-name", 2);
        Assert.assertEquals(house.getCapacity(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWithBelowZeroCapacity() {
        House house = new House("test-name", -1);
    }

    @Test
    public void testShouldSetCapacityCorrectly() {
        House house = new House("test-name", 2);
        Assert.assertEquals(house.getCapacity(), 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldNotAddCatsWhenMaxCapacity() {
        House house = new House("test-name", 2);
        Cat cat1 = new Cat("test-cat1");
        Cat cat2 = new Cat("test-cat2");
        Cat cat3 = new Cat("test-cat3");
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals(house.getCount(), 2);
        house.addCat(cat3);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveCatWithNonexistentCat() {
        House house = new House("test-name", 2);
        Cat cat1 = new Cat("test-cat1");
        house.addCat(cat1);
        house.removeCat("joro");
    }

    @Test
    public void testRemoveCatShouldRemoveCorrectlyCat() {
        House house = new House("test-name", 2);
        Cat cat1 = new Cat("test-cat1");
        house.addCat(cat1);
        Assert.assertEquals(house.getCount(), 1);
        house.removeCat("test-cat1");
        Assert.assertEquals(house.getCount(), 0);

    }

    @Test
    public void testCatShouldNotBeHungryAfterSetForSale() {
        House house = new House("test-name", 2);
        Cat cat1 = new Cat("test-cat1");
        house.addCat(cat1);
        house.catForSale("test-cat1");
        Assert.assertFalse(cat1.isHungry());
    }

    @Test
    public void testStatistics() {
        House house = new House("test-name", 3);
        Cat cat1 = new Cat("test-cat1");
        Cat cat2 = new Cat("test-cat2");
        Cat cat3 = new Cat("test-cat3");
        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(cat3);
        String expected = "The cat test-cat1, test-cat2, test-cat3 is in the house test-name!";
        Assert.assertEquals(house.statistics(), expected);
    }
}
