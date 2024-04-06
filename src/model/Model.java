package model;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Model {
    private List<String> lines;

    public Model() {
        this.lines = new ArrayList<>();
    }
//     private void addSubNodes(DefaultMutableTreeNode parentNode, File parentFile) {
//    for(File f : parentFile.listFiles()) {
//        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(f.getName());
//        parentNode.add(childNode);
//        System.out.println("khúc chỗ đệ quy đc diễn ra");
//        if(f.isDirectory()) {
//            addSubNodes(childNode, f); // Đệ quy nếu f là một thư mục
//           
//        }
//    }
//}
   public void file() {  
        List<String> list = Stream.of("", "", "").collect(Collectors.toList()); 
    }
    public void loadFromFile(Path filePath) throws IOException {
        try (Stream<String> stream = Files.lines(filePath)) {
            lines = stream.collect(Collectors.toList());
        }
    }
 // Đệ quy duyệt thư mục - sẽ trả về danh sách các file trong thư mục
    public List<Path> listFiles(Path path) throws IOException {
        List<Path> fileList = new ArrayList<>();
        
        // Kiểm tra xem path có tồn tại không
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("Path does not exist: " + path);
        }
        
        // Kiểm tra xem path có phải là thư mục không
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path is not a directory: " + path);
        }
        
        // Sử dụng try-with-resources để mở luồng và đảm bảo đóng tự động
        try (Stream<Path> walk = Files.list(path)) {
            fileList = walk
                // Lọc ra các tệp thông thường
                .filter(Files::isRegularFile)
                // Thu thập các tệp vào danh sách
                .collect(Collectors.toList());
        }
        
        return fileList;
    }
    public void saveToFile(Path filePath) throws IOException {
        Files.write(filePath, lines);
    }

    public void setText(String text) {
        lines = Arrays.asList(text.split("\n"));
    }

    public String getText() {
        return String.join("\n", lines);	
    }

   

}
