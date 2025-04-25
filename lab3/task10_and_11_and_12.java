package lab3;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class task10_and_11_and_12 {
    public static File[] getSubdirectories(File directory) {
        if (directory == null || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid input");
        }

        return directory.listFiles(file -> file.isDirectory());

        // return directory.listFiles(File::isDirectory);

        // return directory.listFiles(new FileFilter() {
        //     @Override
        //     public boolean accept(File file) {
        //         return file.isDirectory();
        //     }
        // });
    }

    public static String[] getFilesWithExtension(File directory, String extension) {
        if (directory == null || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid input");
        }

        return directory.list((_, name) -> name.endsWith("." + extension));
    }

    public static void sortFilesAndDirectories(File[] files) {
        Comparator<File> comparator = (file1, file2) -> {
            if (file1.isDirectory() && !file2.isDirectory()) {
                return -1;
            } else if (!file1.isDirectory() && file2.isDirectory()) {
                return 1;
            } else {
                return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
            }
        };
        Arrays.sort(files, comparator);
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Subdirectories of the current directory are:");
        File subDirs[] = getSubdirectories(new File("."));
        for (File f : subDirs) {
            System.out.println(f);
        }

        System.out.println("\nFiles with the .java extension in the lab3 directory are: ");
        for (String name : getFilesWithExtension(new File("lab3"), "java")) {
            System.out.println(name);
        }

        System.out.println("\nBefore sorting: ");
        File files[] = (new File(".")).listFiles();

        if (files == null) {
            throw new Exception("Something went wrong...");
        }

        for (File f : files) {
            System.out.print(f);
            if (f.isDirectory())
                System.out.print("/");
            System.out.println();
        }

        sortFilesAndDirectories(files);

        System.out.println("\nAfter sorting: ");
        for (File f : files) {
            System.out.print(f);
            if (f.isDirectory())
                System.out.print("/");
            System.out.println();
        }
    }
}
