package catalog;

import org.junit.Test;

import java.util.Arrays;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ValidatorsTest {

    @Test
    public void testIsBlank() {
        assertThat(isBlank(null), is(true));
        assertThat(isBlank(""), is(true));
        assertThat(isBlank("    "), is(true));
        assertThat(isBlank("a"), is(false));
        assertThat(isBlank("     a       "), is(false));
    }

    @Test
    public void testIsEmpty() {
        assertThat(isEmpty(null), is(true));
        assertThat(isEmpty(Arrays.asList()), is(true));
        assertThat(isEmpty(Arrays.asList("aaa")), is(false));
        assertThat(isEmpty(Arrays.asList("aaa", "bbb")), is(false));
    }
}
