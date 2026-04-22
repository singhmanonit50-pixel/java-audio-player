import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        String filePath = "src\\Willow Gozilla (feat. Rusty James Miller) - Zenith Bikini.wav";
        File file = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("Playing audio...");

            Scanner sc = new Scanner(System.in);
            System.out.println("Press Enter to stop...");
            sc.nextLine();

            clip.stop();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file format");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable");
        } catch (IOException e) {
            System.out.println("Error reading file");
        } finally {
            System.out.println("Program ended");
        }
    }
}