package de.emptydomain.maventest;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BusinessLogicTest {
    /**
     * It simplifies this test class if we extract the expected output like this.
     */
    private final List<String> EXPECTED = """
            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula
            eget dolor. Aenean massiv. Cum sociis natoque penatibus et magnis dis parturient
            """
            .lines()
            .toList();

    /**
     * This test is the simple approach: just test all the lines
     * at once.
     */
    @Test
    public void testBusinessLogic() {
        BusinessLogic logic = new BusinessLogic();
        Assert.assertEquals(EXPECTED, logic.getFinalResult());
    }

    // -- Just check a single line in each test --
    // I feel this approach is easier to implement and makes more sense than the approach
    // I had tried to explain in person.

    /**
     * Helper method that sets up the test scenario, runs it, and returns the output.
     *
     * @return the output of the test scenario
     */
    private List<String> getLinesFromTestScenario() {
        // The following line is a placeholder for actually setting up the test scenario.
        // In real life, it would contain more complicated code.
        BusinessLogic logic = new BusinessLogic();
        return logic.getFinalResult();
    }

    /**
     * Helper method that executes the test and then checks just one line in the result.
     *
     * @param i index of the line to check, 0 means first line
     */
    private void doParameterizedTest(int i) {
        List<String> actual = getLinesFromTestScenario();

        Assert.assertEquals(EXPECTED.get(i), actual.get(i));
    }

    /**
     * Test line 0 of scenario.
     */
    @Test
    public void testBusinessLogic0() {
        doParameterizedTest(0);
    }

    /**
     * Test line 1 of scenario.
     */
    @Test
    public void testBusinessLogic1() {
        doParameterizedTest(1);
    }

    /**
     * Test the number of lines for this scenario.
     */
    @Test
    public void testBusinessLogicLength() {
        List<String> actual = getLinesFromTestScenario();
        Assert.assertEquals(2, actual.size());
    }

    // -- Original approach: test a prefix of the list --
    // This means the first lines get checked many times, which is kind of superfluous.

    /**
     * Helper method that executes the test and then checks the first N lines in the result.
     * 1 means to check just the first line.  Note how this differs from the other
     * approach on {@link #doParameterizedTest(int)} where 0 means the first line.
     */
    private void doParameterizedTestOriginal(int n) {
        List<String> actual = getLinesFromTestScenario();

        for (int i = 0; i < n; i++) {
            Assert.assertEquals(EXPECTED.get(i), actual.get(i));
        }
    }

    @Test
    public void testBusinessLogicOriginal1() {
        doParameterizedTestOriginal(1);
    }

    @Test
    public void testBusinessLogicOriginal2() {
        doParameterizedTestOriginal(2);
    }

    @Test
    public void testBusinessLogicLengthOriginal() {
        List<String> actual = getLinesFromTestScenario();
        Assert.assertEquals(2, actual.size());
    }
}
