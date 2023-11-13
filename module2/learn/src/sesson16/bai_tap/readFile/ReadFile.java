package sesson16.bai_tap.readFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<Countries> readFile(String filePath){
        List<Countries> countriesList = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                System.out.println(line);
                String[] arr = line.split(",");
                countriesList.add(new Countries(Integer.parseInt(arr[0]), arr[1], arr[2]));
            }
            br.close();
        }
        catch (Exception e) {
        // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
        System.err.println("The file does not exist or the content has errors!");
        }
        return countriesList;
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        List<Countries> countriesList = readFile.readFile("H:\\codegym\\module2\\learn\\src\\sesson16\\bai_tap\\readFile\\countries.csv");
        for (Countries c: countriesList){
            System.out.println(c + "\n");
        }
    }
}
