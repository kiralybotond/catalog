package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private String registrationNumber;
    private int price;
    private List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        if (Validators.isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Parameter should not be null or empty");
        }
        if (price < 0) {   //TODO: annak is van értelme, hogy az ár nulla.
            throw new IllegalArgumentException("Invalid price");
        }
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(Arrays.asList(features));
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public List<String> getContributors() {
        List<String> contributorList = new ArrayList<>();
        for (Feature item : features) {
            contributorList.addAll(item.getContributors());
        }
        return contributorList;
    }


    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature item : features) {
            titles.add(item.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem() {
        int totalNumberOfPages = 0;
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                totalNumberOfPages += item.getNumberOfPages();
            }
        }
        return totalNumberOfPages;
    }

    public int fullLengthAtOneItem() {
        int totalNumberOfPages = 0;
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                totalNumberOfPages += item.getLength();
            }
        }
        return totalNumberOfPages;
    }
}
