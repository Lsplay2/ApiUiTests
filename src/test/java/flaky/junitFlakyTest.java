package flaky;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class junitFlakyTest {


    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Test
    public void testJunit4() {
        Assert.assertFalse(true);
    }

}
