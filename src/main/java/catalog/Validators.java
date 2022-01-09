package catalog;

import java.util.List;

public class Validators {
    public static boolean isBlank(String string) {
        if (string == null || string.isBlank()) return true;

        return false;
    }

    public static boolean isEmpty(List list) {
        if (list == null || list.isEmpty()) return true;

        return false;
    }

    public static boolean isDifferentThanNull(Object o) {
        if (o == null) return false;
        return true;
    }

    public static void giveExceptionOnNull(String... string) {
        for (String s : string) {
            if (s == null || Validators.isBlank(s)) {
                throw new IllegalArgumentException("cant be null or empty");
            }
        }
    }

    public static void checkIntForAveragePage(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }
    }

    public static void checkTheCriteria(SearchCriteria searchCriteria) {
        if (!searchCriteria.hasContributor() && !searchCriteria.hasTitle()){
            throw new IllegalArgumentException("InvalidSerach");
        }
    }

    public static void validateAudioFeatures(String title, int length, List<String> composer) {
        if (length<0){
            throw new IllegalArgumentException("length must be positive");
        }
        if (isBlank(title)||isEmpty(composer)){
            throw new IllegalArgumentException("no title or composer");
        }
    }

    public static void validateAudioFeatures(String title, int length, List<String> composer, List<String> performers) {
        if (length<0){
            throw new IllegalArgumentException("Length must be positive");
        }
        if (isBlank(title)){
            throw new IllegalArgumentException("Empty title");
        }
        if (isEmpty(composer)){
            throw new IllegalArgumentException("Empty composers");
        }
        if (isEmpty(performers)){
            throw new IllegalArgumentException("Empty performers");
        }
    }

    public static void validatePrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (numberOfPages<1){
            throw new IllegalArgumentException("Pages must be positive");
        }
        if (isBlank(title)){
            throw new IllegalArgumentException("Empty title");
        }
        if (isEmpty(authors)){
            throw new IllegalArgumentException("Empty authors");
        }
    }
}
