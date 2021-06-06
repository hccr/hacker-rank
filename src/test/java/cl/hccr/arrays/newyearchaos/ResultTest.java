package cl.hccr.arrays.newyearchaos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ResultTest {

    @Test
    void minimumBribes() {

    List<Integer> data = Arrays.asList(new Integer[]{1, 2, 5, 3, 7, 8, 6, 4});

        Result.minimumBribes(data);

    }


}