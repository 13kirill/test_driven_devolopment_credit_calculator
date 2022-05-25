import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCalculatorTest {

    CreditCalculator sut;

    @BeforeEach
    public void started() {
        System.out.println("Test started");
        sut = new CreditCalculator();
    }

    @BeforeAll
    public static void startedAll() {
        System.out.println("Tests started");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Tests completed");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test completed");
        sut = null;
    }

    @Test
    public void monthlyPayment() {
        //arrange
        double percent = 8.2;
        double credit = 3_411_300;
        int months = 360;
        double expected = 25_508.15;

        //act
        double result = sut.monthlyPayment(credit, percent, months);

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void returnedBalance() {
        //arrange
        double percent = 8.2;
        double credit = 3_411_300;
        int months = 360;
        double expected = 9182934.0;

        //act
        double result = sut.returnedBalance(credit, percent, months);

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void overpayment() {
        //arrange
        double percent = 8.2;
        double credit = 3_411_300;
        int months = 360;
        double expected = 5771634.0;

        //act
        double result = sut.overpayment(credit, percent, months);

        //assert
        assertEquals(expected, result);
    }
}