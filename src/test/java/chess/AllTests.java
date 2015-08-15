package chess;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by RM on 15.08.2015.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RookTest.class,
        QueenTest.class,
        PawnTest.class,
        KnightTest.class,
        KingTest.class,
        BishopTest.class
})
public class AllTests {


}
