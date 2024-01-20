package group.learn.listviewadapter.data;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    private DummyData() { }

    private static final int SMALL_AMOUNT = 100;
    private static final int MEDIUM_AMOUNT = 200;
    private static final Faker faker = new Faker();
    protected static final List<String> NAMES = getDummyNames();

    protected static final List<Music> MUSIC_LIST = generateMusicList();

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

}
