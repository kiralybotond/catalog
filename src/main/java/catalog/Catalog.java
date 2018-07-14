package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        if (catalogItem == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int minPageNumberValue) {
        if (minPageNumberValue <= 0) {    //itt amúgy a nullának szerintem lenne értelme
            throw new IllegalArgumentException("Page number must be positive");
        }
        double sumOfPages = 0.0;
        double countOfPrintedCatalogItems = 0.0;
        for (CatalogItem item : catalogItems) {
            if (item.numberOfPagesAtOneItem() > minPageNumberValue) {
                sumOfPages += item.numberOfPagesAtOneItem();
                countOfPrintedCatalogItems++;
            }
        }
        if(countOfPrintedCatalogItems == 0){
            throw new IllegalArgumentException("No page");
        }
        return sumOfPages / countOfPrintedCatalogItems;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        if (Validators.isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Parameter should not be null or empty.");
        }
        for (CatalogItem item : catalogItems) {
            if (item.getRegistrationNumber().equals(registrationNumber)) {
                catalogItems.remove(item);
                break;
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {   //már le van hibakezelve
        List<CatalogItem> itemsFound = new ArrayList<>();
        for (CatalogItem catalogitem : catalogItems) {
            if (searchCriteria.hasTitle() &&
                    searchCriteria.hasContributor() &&
                    catalogitem.getTitles().contains(searchCriteria.getTitle()) &&
                    catalogitem.getContributors().contains(searchCriteria.getContributor())) {
                itemsFound.add(catalogitem);
            }
            if (!searchCriteria.hasTitle() &&
                    searchCriteria.hasContributor() &&
                    catalogitem.getContributors().contains(searchCriteria.getContributor())) {
                itemsFound.add(catalogitem);
            }
            if (searchCriteria.hasTitle() &&
                    !searchCriteria.hasContributor() &&
                    catalogitem.getTitles().contains(searchCriteria.getTitle())) {
                itemsFound.add(catalogitem);
            }
        }
        return itemsFound;
    }

    public int getAllPageNumber() {
        int totalPages = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                totalPages += item.numberOfPagesAtOneItem();
            }
        }
        return totalPages;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                audioLibraryItems.add(item);
            }
        }
        return audioLibraryItems;
    }


    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                printedLibraryItems.add(item);
            }
        }
        return printedLibraryItems;
    }

    public int getFullLength() {
        int fullLength = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                fullLength += item.fullLengthAtOneItem();
            }
        }
        return fullLength;
    }

}
