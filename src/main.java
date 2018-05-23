import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
public class main {

    public static void main(String[] args) throws IOException {

        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("/home/brianphiri/code/java/pract/voices/src/dictionary/2522.dic");

        configuration.setLanguageModelPath("/home/brianphiri/code/java/pract/voices/src/languageModels/2522.lm");

        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
        recognize.startRecognition(true);
        SpeechResult result;

        //Checking if recognizer has recognized the speech
        while ((result = recognize.getResult()) != null) {
            //Get the recognize speech
            String command = result.getHypothesis();
            System.out.println(command);
        }
    }
}
