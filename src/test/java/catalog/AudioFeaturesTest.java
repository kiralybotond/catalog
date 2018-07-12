package catalog;


import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class AudioFeaturesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void missingTitle() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Empty title");

        new AudioFeatures("", 300, Arrays.asList("Metallica"));
    }

    @Test
    public void invalidLength() {
        expectedException.expect(IllegalArgumentException.class);

        new AudioFeatures("Ride the Lightning", -2, Arrays.asList("Metallica"));
    }

    @Test
    public void noPerformer() {
        expectedException.expect(IllegalArgumentException.class);

        new AudioFeatures("Ride the Lightning", -2, new ArrayList<>());
    }

    @Test
    public void testCreate() {

        AudioFeatures audioFeatures = new AudioFeatures("Ride the Lightning", 300, Arrays.asList("Metallica"));

        assertThat(audioFeatures.getTitle(),is("Ride the Lightning"));
        assertThat(audioFeatures.getLength(), is(300));

        assertThat(audioFeatures.getContributors().size(), is(1));
        assertThat(audioFeatures.getContributors().get(0), is ("Metallica"));
    }

    @Test
    public void testCreateWithComposer() {

        AudioFeatures audioFeatures = new AudioFeatures("Ride the Lightning", 300, Arrays.asList("Metallica"), Arrays.asList("James Hetfield"));

        assertThat(audioFeatures.getTitle(),is("Ride the Lightning"));
        assertThat(audioFeatures.getLength(), is(300));
        
        assertThat(audioFeatures.getContributors().size(), is(2));
        assertThat(audioFeatures.getContributors().get(1), is ("Metallica"));
    }

}
