package catalog;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class CatalogItemTest {

    CatalogItem catalogItem = new CatalogItem("R-1", 300,
                    new AudioFeatures("Night Visions", 185, Arrays.asList("Dan Raynolds"),Arrays.asList("Imagine Dragons")),
                    new PrintedFeatures("Harry Potter",600,  Arrays.asList("J.K. Rowling")),
                    new AudioFeatures("Piece of Mind", 200, Arrays.asList("Steve Harris"),Arrays.asList("Iron Maiden"))
    );


    CatalogItem catalogItem2 = new CatalogItem("R-2", 300,
                    new PrintedFeatures("Harry Potter",600,  Arrays.asList("J.K. Rowling"))
   );

    

    @Test
    public void testGetFeaturesGetAudioContributors() {

        List<String> result = Arrays.asList("Imagine Dragons", "Dan Raynolds");

        assertThat(catalogItem.getFeatures().get(0).getContributors(), is(result));

    }

    @Test
    public void testGetFeaturesGetPrintedContributors() {

        List<String> result = Arrays.asList("J.K. Rowling");

        assertThat(catalogItem.getFeatures().get(1).getContributors(), is(result));

    }

    @Test
    public void testCreate() {
        assertThat(catalogItem.getPrice(), is(300));
        assertThat(catalogItem.getRegistrationNumber(), is("R-1"));

    }

    @Test
    public void testNumberOfPagesAtOneItem(){
        assertThat(catalogItem.numberOfPagesAtOneItem(),is(600));
    }

    @Test
    public void testFullLengthAtOneItem(){
        assertThat(catalogItem.fullLengthAtOneItem(),is(385));
    }

    @Test
    public void testGetAllContributorsFromOneItem(){
        List<String> result = Arrays.asList("Imagine Dragons", "Dan Raynolds", "J.K. Rowling", "Iron Maiden", "Steve Harris");
        assertThat(catalogItem.getContributors(),is(result));
    }

    @Test
    public void testGetTitlesFromAllFeature(){
        List<String> result = Arrays.asList("Night Visions","Harry Potter","Piece of Mind");
        assertThat(catalogItem.getTitles(),is(result));
    }

    @Test
    public void testHasAudioFeature(){
        assertThat(catalogItem.hasAudioFeature(),is(true));
        assertThat(catalogItem2.hasAudioFeature(),is(false));
    }

    @Test
    public void testHasPrintedFeature(){
        assertThat(catalogItem.hasAudioFeature(),is(true));
        assertThat(catalogItem2.hasPrintedFeature(),is(true));
    }


}
