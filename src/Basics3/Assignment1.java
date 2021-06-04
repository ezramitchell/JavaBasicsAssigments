package Basics3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Assignment1 {
    public static void main(String[] args) {
        //arg 1 assumed as desired path
        //ard 2 optional depth 1 would not explore subdirectories
        if (args.length == 0) return;
        int depth = 1;
        if (args.length >= 2) {
            try {
                depth = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Depth not valid, 1 will be used");
            }
        }
        Path p = Paths.get(args[0]);
        if (p.toFile().isDirectory()) {
            try (Stream<Path> walk = Files.walk(p, depth)) {
                walk.forEach(path -> {
                    //remove base path
                    String relativePath = p.relativize(path).toString();
                    //add tabs for each subdirectory
                    long count = relativePath.chars().filter(ch -> ch == '\\').count();
                    StringBuilder sb = new StringBuilder();
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            sb.append('|');
                            sb.append('\t');
                        }
                    }
                    int index = relativePath.lastIndexOf("\\");
                    sb.append(relativePath.substring(Math.max(index + 1, 0)));
                    System.out.println(sb);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/* Copy of console, Arguments are "D:\Temp 3"
world
|	world
|	|	advancements
|	|	data
|	|	datapacks
|	|	DIM-1
|	|	DIM1
|	|	entities
|	|	level.dat
|	|	level.dat_old
|	|	playerdata
|	|	poi
|	|	region
|	|	session.lock
|	|	stats
world.zip

Process finished with exit code 0
 */
