package catalog;

public class SearchCriteria {
    public String contributor;
    public String title;
    private int searchMethod;

    private SearchCriteria(String title, String contributor) {
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        Validators.giveExceptionOnNull(contributor, title);
        return new SearchCriteria(title, contributor).setSearchMethod(2);
    }

    public static SearchCriteria createByContributor(String contributor) {
        Validators.giveExceptionOnNull(contributor);
        return new SearchCriteria(null, contributor).setSearchMethod(1);
    }

    public static SearchCriteria createByTitle(String title) {
        Validators.giveExceptionOnNull(title);
        return new SearchCriteria(title, null).setSearchMethod(0);
    }

    public boolean hasContributor() {
        if (contributor != null) {
            return true;
        }
        return false;
    }

    public boolean hasTitle() {
        if (title != null) {
            return true;
        }
        return false;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    private SearchCriteria setSearchMethod(int number){
        this.searchMethod = number;
        return this;
    }

    public int getSearchMethod() {
        return searchMethod;
    }
}
