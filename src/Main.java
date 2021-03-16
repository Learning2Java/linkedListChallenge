import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Album album = new Album("test");
        LinkedList<Song> newPlayList = new LinkedList<Song>();

        album.addSong("open and shut", 5);
        album.addSong("wheels on the bus", 5);
        album.addSong("potty song", 5);
        album.addSong("high to the sky", 5);

        album.getSongList("test");




        album.newPlayList(new Song("open and shut", 5));
        album.newPlayList(new Song("wheels on the bus", 5));
        album.newPlayList(new Song("potty song", 5));
        album.newPlayList(new Song("high to the sky", 5));


        album.startPlayList(newPlayList);





    }
}
