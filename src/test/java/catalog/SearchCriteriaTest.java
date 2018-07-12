package catalog;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchCriteriaTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInvalidTitle() {
        expectedException.expect(IllegalArgumentException.class);
        SearchCriteria.createByTitle(null);
    }

    @Test
    public void testInvalidContributor() {
        expectedException.expect(IllegalArgumentException.class);
        SearchCriteria.createByContributor(null);
    }

    @Test
    public void testInvalid() {
        expectedException.expect(IllegalArgumentException.class);
        SearchCriteria.createByBoth(null, "Metallica");
    }

    @Test
    public void testCreateByTitle() {
        SearchCriteria searchCriteria = SearchCriteria.createByTitle("Imagine Dragons");
        assertThat(searchCriteria.getTitle(), equalTo("Imagine Dragons"));
        assertThat(searchCriteria.hasTitle(), is(true));
        assertThat(searchCriteria.hasContributor(), is(false));
    }

    @Test
    public void testCreateByContributor() {
        SearchCriteria searchCriteria = SearchCriteria.createByContributor("Metallica");
        assertThat(searchCriteria.getContributor(), equalTo("Metallica"));
        assertThat(searchCriteria.hasTitle(), is(false));
        assertThat(searchCriteria.hasContributor(), is(true));
    }

    @Test
    public void testCreateByBoth() {
        SearchCriteria searchCriteria = SearchCriteria.createByBoth("Ride the Lightning", "Metallica");
        assertThat(searchCriteria.getTitle(), equalTo("Ride the Lightning"));
        assertThat(searchCriteria.getContributor(), equalTo("Metallica"));
        assertThat(searchCriteria.hasTitle(), is(true));
        assertThat(searchCriteria.hasContributor(), is(true));
    }

}
