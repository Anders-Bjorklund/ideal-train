package se.hackney.softhouse.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class ValuesTest {

    @Test
    void valuesOk() {
        Values valuesA = new Values( "A|S:t Johannesgatan 16|Uppsala|75330" );
        assertEquals( valuesA.index( 0 ), "S:t Johannesgatan 16" );
        assertEquals( valuesA.index( 1 ), "Uppsala" );
        assertEquals( valuesA.index( 2 ), "75330" );
        assertEquals( valuesA.index( 3 ), "" );

        Values valuesB = new Values( "A|||Test" );
        assertEquals( valuesB.index( 0 ), "" );
        assertEquals( valuesB.index( 1 ), "" );
        assertEquals( valuesB.index( 2 ), "Test" );
        assertEquals( valuesB.index( 3 ), "" );

        Values valuesC = new Values( "A|10 Downing Street|London" );
        assertEquals( valuesC.index( 0 ), "10 Downing Street" );
        assertEquals( valuesC.index( 1 ), "London" );
        assertEquals( valuesC.index( 2 ), "" );
    }
}