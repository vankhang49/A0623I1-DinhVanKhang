package sesson17.bai_tap.copyBinaryFile;

import java.io.*;
import java.util.Scanner;

public class CopyBinaryFile {
    private static void readFile(String source,String target){
        try {
            File sourceF = new File(source);
            if (!sourceF.exists()){
                throw new FileNotFoundException();
            }
            File targetF = new File(target);
            if (targetF.exists()){
                System.out.println("File already exists!");
                return;
            }
            copyBinaryFile(sourceF,targetF);
            System.out.println("Copy file successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.printf("Can't copy that file");
            System.out.printf(e.getMessage());
        }

    }
    private static void copyBinaryFile(File source, File dest) throws IOException {
        InputStream ip = null;
        OutputStream op = null;
        try {
            ip = new FileInputStream(source);
            op = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = ip.read(buffer)) > 0) {
                op.write(buffer, 0, length);
            }
        } finally {
            if (ip != null) {
                ip.close();
            }
            if (op != null) {
                op.close();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.print("Enter destination file:");
        String targetPath = in.nextLine();
        readFile(sourcePath, targetPath);
    }
}
