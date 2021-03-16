import java.util.*;

public class Album {
    private ArrayList<Song> songList;
    private String albumName;
    public LinkedList<Song> playList;

    public Album(String albumName) {
        this.songList = new ArrayList<Song>();
        this.playList = new LinkedList<Song>();
        this.albumName = albumName;
    }

    public ArrayList<Song> getSongList(String albumName) {
        return this.songList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public boolean addSong(String songTitle, double duration) {
        if(findSong(songTitle)) {
            System.out.println("add new song: " + songTitle);
            this.songList.add(new Song(songTitle, duration));
            return true;
        }
        System.out.println("song: " + songTitle + " exists in album: " + albumName);
        return false;
    }

    private boolean findSong(String songTitle) {
        for(int i = 0; i < this.songList.size(); i++) {
            if(this.songList.get(i).getTitle().equals(songTitle)) {
                return false;
            }
        }
        return true;
    }

    public boolean newPlayList(Song song) {
        if(!findSong(song.getTitle())) {
            System.out.println("Added " + song.getTitle() + " to playlist");
            this.playList.add(song);
            return true;
        }
        System.out.println(song.getTitle() + " does not exist in library");
        return false;
    }

    public void startPlayList(LinkedList playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = this.playList.listIterator();

        if(this.playList.isEmpty()) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("now playing: " + listIterator.next().getTitle());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("End playlist");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                } else {
                        System.out.println("Reached end of playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous().getTitle();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("Start of playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if(goingForward) {
                        System.out.println("Now playing " + listIterator.previous().getTitle());
                        listIterator.next();
                        goingForward = true;
                    } else if(!goingForward) {
                        System.out.println("Now playing " + listIterator.next().getTitle());
                        listIterator.previous();
                        goingForward = false;
                    }
                    break;
                case 4:
                    if(goingForward) {
                        System.out.println("removed " + listIterator.previous().getTitle());
                        listIterator.remove();
                        goingForward = true;
                    } else if(!goingForward) {
                        System.out.println("removed " + listIterator.next().getTitle());
                        listIterator.remove();
                        goingForward = false;
                    }
                    break;

                case 5:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next song\n" +
                "2 - go to previous song\n" +
                "3 - repeat song\n" +
                "4 - removed song\n" +
                "5 - print menu options");
    }


}
