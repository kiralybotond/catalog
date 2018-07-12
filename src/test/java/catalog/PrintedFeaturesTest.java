package catalog;


import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import static org.junit.Assert.*;


public class PrintedFeaturesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void missingTitle() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Empty title");

        new PrintedFeatures("",600, Arrays.asList("J.K. Rowling","Someoneelse"));
    }

    @Test
    public void invalidNumberOfPages() {
        expectedException.expect(IllegalArgumentException.class);

        new PrintedFeatures("Harry Potter",-1, Arrays.asList("J.K. Rowling","Someoneelse"));
    }

    @Test
    public void noPerformer() {
        expectedException.expect(IllegalArgumentException.class);

        new PrintedFeatures("Harry Potter",600, null);
    }

    
    @Test
    public void testCreate() {
        PrintedFeatures audioFeatures = new PrintedFeatures("Harry Potter",600, Arrays.asList("J.K. Rowling","Someoneelse"));
        assertThat(audioFeatures.getContributors().size(), is(2));
        assertThat(audioFeatures.getContributors().get(1), is ("Someoneelse"));

        assertThat(audioFeatures.getTitle(),is("Harry Potter"));
        assertThat(audioFeatures.getNumberOfPages(), is(600));
    }

}
