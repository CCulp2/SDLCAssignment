import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextSelection {
    private File inputFile;
    private String beginningText;
    private String endText;
    private BufferedReader br;

    public TextSelection(File inputFile, String beginningText, String endText) {
        this.inputFile = inputFile;
        this.beginningText = beginningText;
        this.endText = endText;
    }

    public ArrayList<String> getText() {
        ArrayList<String> arrayOfWords = new ArrayList<>();

        try {
            this.br = new BufferedReader(new FileReader(inputFile));
            String line = null;
            String sanitizedLine = null;
            String[] sanitizedWordsArray = null;

            while ((line = br.readLine()) != null) {
                if (line.contains(beginningText)) {
                    while (!line.contains(endText)) {
                        line = br.readLine();
                        sanitizedLine = StringSanitizer.removeHTML(line);
                        sanitizedLine = StringSanitizer.removePunctuation(sanitizedLine);
                        sanitizedWordsArray = sanitizedLine.split(" ");
                        for(String word : sanitizedWordsArray) {
                            if (!word.isEmpty()) {
                                arrayOfWords.add(word);
                            }
                        }

                    }
                }
            }
        } catch (IOException e){
            System.out.println(e);
        }

        return arrayOfWords;
    }

}
