package group.learn.listviewadapter.data;

import com.github.javafaker.Faker;
import group.learn.listviewadapter.R;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    private DummyData() { }

    private static final int SMALL_AMOUNT = 100;
    private static final int MEDIUM_AMOUNT = 200;
    private static final Faker faker = new Faker();
    public static final List<String> NAMES = getDummyNames();

    public static final List<Planet> PLANETS = generatePlanets();

    public static final List<Shape> SHAPES = generateShapes();

    public static final List<Item> ITEMS =  generateItems();

    public static final List<Music> MUSIC_LIST = generateMusicList();

    private static List<String> getDummyNames() {
    List<String> names = new ArrayList<>();
        for (int i = 0; i < DummyData.SMALL_AMOUNT; i++)
            names.add(faker.name().name());
       return names;
    }






    private static List<Music> generateMusicList(){
        List<Music> musics = new ArrayList<>();
        for(int i = 0; i < DummyData.MEDIUM_AMOUNT; i++){
            Music music = new Music.MusicBuilder()
                    .title(faker.music().instrument())
                    .genre(faker.music().genre())
                    .build();
            musics.add(music);
        }
        return musics;
    }

    private static List<Planet> generatePlanets(){
        List<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Earth", "1 Moon", R.drawable.earth));
        planets.add(new Planet("Mercury", "0 Moon", R.drawable.mercury));
        planets.add(new Planet("Venus", "0 Moon", R.drawable.venus));
        planets.add(new Planet("Mars"," 2 Moon", R.drawable.mars));
        planets.add(new Planet("Jupiter", "79", R.drawable.jupiter));
        planets.add(new Planet("Saturn", "83", R.drawable.saturn));
        planets.add(new Planet("Uranus", "27", R.drawable.uranus));
        planets.add(new Planet("Neptune", "14", R.drawable.neptune));
        return planets;
    }


    private static List<Shape> generateShapes(){
        List<Shape> shapes = new ArrayList<>();
        shapes.add(Shape.builder().shapeImg(R.drawable.cube).shapeName("CUBE").build());
        shapes.add(Shape.builder().shapeImg(R.drawable.cylinder).shapeName("CYLINDER").build());
        shapes.add(Shape.builder().shapeImg(R.drawable.prism).shapeName("PRISM").build());
        shapes.add(Shape.builder().shapeImg(R.drawable.sphere).shapeName("SPHERE").build());
        return shapes;
    }

    private static List<Item> generateItems(){
        List<Item> items = new ArrayList<>();
        items.add(Item.builder().itemName("Fruits").itemDesc("Fresh Fruits from the Garden").itemImg(R.drawable.fruit).build());
        items.add(Item.builder().itemName("Vegetables").itemDesc("Delicious Vegetables").itemImg(R.drawable.vegitables).build());
        items.add(Item.builder().itemName("Bakery").itemDesc("Bread, Wheat and Beans").itemImg(R.drawable.bread).build());
        items.add(Item.builder().itemName("Beverage").itemDesc("Juice, Tea, Coffee, and Soda").itemImg(R.drawable.bread).build());
        items.add(Item.builder().itemName("Milk").itemDesc("Milk , Shakes, and Yogurt").itemImg(R.drawable.milk).build());
        items.add(Item.builder().itemName("Snacks").itemDesc("Popcorn, Donut, Drinks").itemImg(R.drawable.bread).build());
        return items;
    }

}
