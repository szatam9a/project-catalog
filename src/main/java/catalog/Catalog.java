package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        if (Validators.isDifferentThanNull(catalogItem)) {
            catalogItems.add(catalogItem);
        }
    }

    public double averagePageNumberOver(int number) {
        Validators.checkIntForAveragePage(number);
        int summer = 0;
        int counter = 0;
        for (CatalogItem c : catalogItems) {
            int thePages = c.numberOfPagesAtOneItem();
            if (thePages > 0 && thePages > number) {
                counter++;
                summer += thePages;
            }
        }
        noPageFound(counter);
        return summer / counter;
    }

    private void noPageFound(int counter) {
        if (counter == 0) {
            throw new IllegalArgumentException("No page");
        }
    }

    public void deleteItemByRegistrationNumber(String regNumber) {
        Validators.giveExceptionOnNull(regNumber);
        CatalogItem toRemove = findByRegNumber(regNumber);
        catalogItems.remove(toRemove);
    }

    private CatalogItem findByRegNumber(String regNumber) {
        for (CatalogItem c : catalogItems) {
            if (regNumber.equals(c.getRegistrationNumber()))
                return c;
        }
        throw new IllegalArgumentException("No item to Delete");
    }


    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {

        switch (searchCriteria.getSearchMethod()) {
            case 2:
                return findByBoth(searchCriteria);
            case 1:
                return findByContributor(searchCriteria);
            case 0:
                return findByTitle(searchCriteria);
            default:
                throw new IllegalArgumentException("searchCriteria is not working");
        }
    }

    private List<CatalogItem> findByBoth(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            if (c.getTitles().contains(searchCriteria.title) && c.getContributors().contains(searchCriteria.contributor)) {
                result.add(c);
            }
        }
        return result;
    }

    private List<CatalogItem> findByContributor(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            if (c.getContributors().contains(searchCriteria.contributor)) {
                result.add(c);
            }
        }
        return result;
    }

    private List<CatalogItem> findByTitle(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            if (c.getTitles().contains(searchCriteria.title)) {
                result.add(c);
            }
        }
        return result;
    }


    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem c : catalogItems) {
            sum += c.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioItems = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            if (c.hasAudioFeature())
                audioItems.add(c);
        }
        return audioItems;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem c : catalogItems) {
            if (c.hasAudioFeature()) {
                sum += c.fullLengthAtOneItem();
            }
        }
        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedItems = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            if (c.hasPrintedFeature())
                printedItems.add(c);
        }
        return printedItems;
    }

    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }
}
