package fsm;
import com.example.fsm.FiniteStateMachine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

public class FiniteStateMachineTest{

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testStateMachine(String input, FiniteStateMachine.State expectedState) {
        FiniteStateMachine machine = new FiniteStateMachine();
        FiniteStateMachine.State result = machine.processString(input);
        assertEquals(expectedState, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("T", FiniteStateMachine.State.S_1),
                Arguments.of("TE", FiniteStateMachine.State.S_2),
                Arguments.of("TES", FiniteStateMachine.State.S_3),
                Arguments.of("TEST", FiniteStateMachine.State.F),
                Arguments.of("TESTOP", FiniteStateMachine.State.F),
                Arguments.of("", FiniteStateMachine.State.S_0),
                Arguments.of("TESTEST", FiniteStateMachine.State.F),
                Arguments.of("TTEST", FiniteStateMachine.State.F)
        );
    }
}