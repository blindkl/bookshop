//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Queue;
//
//public class ReadFromFiles {
//
//    public void readBooks(String filePathBooks) throws IOException {
//        File file = new File(filePathBooks);
//        List<String> forAdding = new ArrayList<>();
//        if (file.exists()) {
//            InputStream is = new FileInputStream(file);
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader reader = new BufferedReader(isr);
//            while (reader.ready()) {
//                forAdding.add(reader.readLine());
//            }
//            reader.close();
//            isr.close();
//            is.close();
//        }
//        for (String line : forAdding) {
//            String[] split = line.split(";");
//            Category newCategory = null;
//            for (Category category : categories) {
//                if (Integer.parseInt(split[6]) == category.getId()) {
//                    newCategory = category;
//                }
//            }
//            Author newIdAuthor = null;
//            for (Author author : authors) {
//                if (Integer.parseInt(split[5]) == author.getId()) {
//                    newIdAuthor = author;
//                }
//            }
//            Book book = new Book(Integer.parseInt(split[0]), split[1],
//                    Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4], newIdAuthor, newCategory);
//
//            Main.booksList.add(book);
//        }
//    }
//}
