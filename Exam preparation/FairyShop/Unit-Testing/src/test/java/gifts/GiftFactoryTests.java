package gifts;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GiftFactoryTests {

    @Test (expected = IllegalArgumentException.class)
    public void testCreateGiftShouldThrowException() {
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.createGift(new Gift("test-type", 25));
        giftFactory.createGift(new Gift("test-type", 25));
    }
    @Test
    public void testCreateGiftShouldAddGiftCorrectly() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("test-type", 25);
        giftFactory.createGift(gift);
        Assert.assertEquals(1, giftFactory.getCount());
    }
    @Test
    public void testCreateGiftShouldReturnCorrectString() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("test-type", 25);
        Assert.assertEquals("Successfully added gift test-type with magic 25.00.", giftFactory.createGift(gift));
    }
    @Test (expected = NullPointerException.class)
    public void testRemoveGiftWithNullName() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("test-name", 25);
        giftFactory.createGift(gift);
        giftFactory.removeGift(null);
    }
    @Test
    public void testRemoveGiftShouldReturnCorrectBoolean() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("test-name", 25);
        giftFactory.createGift(gift);
        Assert.assertTrue(giftFactory.removeGift("test-name"));
    }
    @Test
    public void testGetPresentWithLeastMagic() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("test-name", 25);
        Gift gift2 = new Gift("test-name2", 500);
        Gift gift3 = new Gift("test-name3", 1);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(gift3, giftFactory.getPresentWithLeastMagic());
    }
    @Test
    public void testGetPresent() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("test-name", 25);
        Gift gift2 = new Gift("test-name2", 500);
        Gift gift3 = new Gift("test-name3", 1);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(gift, giftFactory.getPresent("test-name"));
    }
    @Test
    public void testGetPresents() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("test-name", 25);
        Gift gift2 = new Gift("test-name2", 500);
        Gift gift3 = new Gift("test-name3", 1);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        List<Gift> giftCollection = new ArrayList();
        giftCollection.add(gift);
        giftCollection.add(gift2);
        giftCollection.add(gift3);
        Assert.assertEquals(giftCollection.size(), giftFactory.getPresents().size());
    }

}
