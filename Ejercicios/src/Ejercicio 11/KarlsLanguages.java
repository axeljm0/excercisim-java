import java.util.ArrayList;
import java.util.List;

class KarlsLanguages {

    private final List<String> languages = new ArrayList<>();

    public boolean isEmpty() {
        return languages.isEmpty();
    }

    public void addLanguage(String language) {
        languages.add(language);
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    public String firstLanguage() {
        return languages.get(0);
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        return languages.contains(language);
    }

    public boolean isExciting() {
        return languages.contains("Java") || languages.contains("Kotlin");
    }

    public static void main(String[] args) {
        KarlsLanguages languageList = new KarlsLanguages();

        System.out.println("isEmpty (inicial): " + languageList.isEmpty());

        languageList.addLanguage("Kotlin");
        languageList.addLanguage("Python");

        System.out.println("firstLanguage: " + languageList.firstLanguage());
        System.out.println("count: " + languageList.count());
        System.out.println("containsLanguage(Python): " + languageList.containsLanguage("Python"));
        System.out.println("containsLanguage(Ruby): " + languageList.containsLanguage("Ruby"));
        System.out.println("isExciting: " + languageList.isExciting());

        languageList.removeLanguage("Python");
        System.out.println("count tras remove: " + languageList.count());

        KarlsLanguages neither = new KarlsLanguages();
        neither.addLanguage("Python");
        System.out.println("isExciting (sin Java/Kotlin): " + neither.isExciting());
    }
}