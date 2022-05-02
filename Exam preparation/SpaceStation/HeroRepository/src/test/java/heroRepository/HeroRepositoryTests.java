package heroRepository;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HeroRepositoryTests {
    private HeroRepository repository;
    private Hero hero;

    @Before
    public void setUp() {
        this.repository = new HeroRepository();
        this.hero = new Hero("test_hero", 2);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroShouldFailWithNull() {
        repository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroWithExistingHeroName() {
        repository.create(this.hero);
        repository.create(this.hero);
    }

    @Test
    public void testShouldCreateHeroSuccessfully() {
        repository.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldFailToRemoveHeroWithNullName() {
        this.repository.remove(null);
    }

    @Test
    public void testShouldSuccessfullyRemoveHero(){
        this.repository.create(hero);
        Assert.assertTrue(this.repository.remove(hero.getName()));
    }

    @Test
    public void testReturnedHighestLevelHeroWhenNull() {

        Assert.assertEquals(null, this.repository.getHeroWithHighestLevel());
    }

    @Test
    public void testShouldReturnHeroWithHighestLevel() {
       Hero hero1 = new Hero("test_hero1", 10);
       Hero hero2 = new Hero("test_hero2", 20);
       Hero hero3 = new Hero("test_hero3", 30);
        this.repository.create(hero1);
        this.repository.create(hero2);
        this.repository.create(hero3);

        Assert.assertEquals(hero3, repository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHero() {
        Hero hero1 = new Hero("test_hero1", 10);
        Hero hero2 = new Hero("test_hero2", 20);
        Hero hero3 = new Hero("test_hero3", 30);
        this.repository.create(hero1);
        this.repository.create(hero2);
        this.repository.create(hero3);

        Assert.assertEquals(hero1, repository.getHero("test_hero1"));
    }

    @Test
    public void testGetHeroes() {
        Hero hero1 = new Hero("test_hero1", 10);
        Hero hero2 = new Hero("test_hero2", 20);
        Hero hero3 = new Hero("test_hero3", 30);
        this.repository.create(hero1);
        this.repository.create(hero2);
        this.repository.create(hero3);

        Hero[] heroes = new Hero[3];
        heroes[0] = hero1;
        heroes[1] = hero2;
        heroes[2] = hero3;

        Assert.assertArrayEquals(heroes, repository.getHeroes().toArray());
    }

    @Test
    public void testGetCount() {
        Hero hero1 = new Hero("test_hero1", 10);
        Hero hero2 = new Hero("test_hero2", 20);
        Hero hero3 = new Hero("test_hero3", 30);
        this.repository.create(hero1);
        this.repository.create(hero2);
        this.repository.create(hero3);

        Assert.assertEquals(3, repository.getCount());
    }
}
