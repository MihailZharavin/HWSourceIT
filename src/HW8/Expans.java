package HW8;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Expans {
    public static void main(String[] args) throws IOException {

        Path start = Paths.get("D:\\программы\\Java\\SourceIT");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> path.endsWith(".java"))
                    .sorted()
                    .collect(Collectors.joining(" \n "));
            System.out.print("walk(): " + joined);
        }
    }
}
