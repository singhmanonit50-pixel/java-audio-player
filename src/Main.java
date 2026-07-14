import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filePath1 = "C:\\Users\\Manon\\IdeaProjects\\java-audio-player\\src\\songs\\song1.wav";
        String filePath2 = "C:\\Users\\Manon\\IdeaProjects\\java-audio-player\\src\\songs\\song2.wav";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter t for Song 1 or any other key for Song 2: ");
        char c = sc.next().charAt(0);

        String selectedFile;

        if (c == 't') {
            selectedFile = filePath1;
        } else {
            selectedFile = filePath2;
        }

        File file = new File(selectedFile);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

            System.out.println("Playing audio...");
            System.out.println("Press Enter to stop...");

            sc.nextLine(); // consume leftover newline
            sc.nextLine();

            clip.stop();
            clip.close();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file format");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        System.out.println("Program ended");
    }
}
