package sesson16.bai_tap.copyFile;

import java.io.*;

public class CopyFileText {
    public void copyTextFile(String srcFile, String targetFile){
        try {
            int count = 0;
            File srcfile = new File(srcFile);
            File tgFile = new File(targetFile);
            if (!srcfile.exists()){ // Nếu tệp nguồn đã tồn tại
                throw new FileNotFoundException();
            }
            if (tgFile.exists()){ // Nếu tệp đích đã tồn tại
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(srcFile));
            FileWriter writer = new FileWriter(targetFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                count = countChar(line);
                bufferedWriter.write(line + "\n");
            }
            bufferedWriter.write("Number of characters: " + count);
            bufferedWriter.close();
            br.close();
        }
        catch (Exception e) {
            System.err.println("The source file does not exist or The target file exist!");
        }
    }
    public int countChar(String line){
        String[] arr = line.split(" ");
        int count = 0;
        for (String a: arr){
            count += a.length();
        }
        return count;
    }
    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        copyFileText.copyTextFile("H:\\codegym\\module2\\learn\\src\\sesson16\\bai_tap\\source.txt",
                "H:\\codegym\\module2\\learn\\src\\sesson16\\bai_tap\\pasteFile1");
    }
}
