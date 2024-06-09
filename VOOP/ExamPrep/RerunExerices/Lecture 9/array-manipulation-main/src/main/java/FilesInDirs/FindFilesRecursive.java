package FilesInDirs;

import java.io.File;
import java.util.Scanner;
public class FindFilesRecursive {
    private int numDirs;
    private int numFiles;
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
        File startDir = new File(directory);

        FindFilesRecursive ffr = new FindFilesRecursive();
        ffr.findFiles(startDir);
        System.out.println("\n*************\n" + ffr);
    }

    // Exercise: If a file is a directory: Call all files recursively,
    // else print full path to the file. Count both dirs and atomic files.
    private void findFiles(File file) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    numDirs++;
                    findFiles(f);
                } else {
                    numFiles++;
                    System.out.println(f.toPath());
                }
            }
        } else if (file.isDirectory()) {
            // Count empty directories
            numDirs++;
        }
    }

    @Override
    public String toString() {
        return "FindFilesRecursive{" + "noDirs=" + numDirs + ", noFiles=" + numFiles + '}';
    }
}
