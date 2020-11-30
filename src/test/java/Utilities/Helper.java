package Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {

    public static List<String> getCarRegistrationFromFile(String file){

        List<String> matchedReg = new ArrayList<>();
        String fileContent = readFileContent(file);

        Pattern pattern = Pattern.compile("[A-Z]{2}\\d{2}\\s*[A-Z]{3}");
        Matcher matcher = pattern.matcher(fileContent);

        while(matcher.find()){
            matchedReg.add(matcher.group());
        }
        return matchedReg;
    }

    public static String readFileContent(String file){

        String fileContent = "";
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public static List<String> getAllFilesInDirectory(String pathToDirectory){
        try (Stream<Path> walk = Files.walk(Paths.get(pathToDirectory))) {
            List<String> files = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
            return files;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
