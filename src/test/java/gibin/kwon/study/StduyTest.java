package gibin.kwon.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class StduyTest {

    @Test
    @DisplayName("splitTest")
    void splitTest() {
        String source = "1,2";
        List<String> goal = Arrays.asList("1","2");
        List<String> result = Arrays.asList(source.split(","));
        assertThat(result.equals(goal));
    }

    @Test
    @DisplayName("splitContainTest")
    void splitContainTest() {
        String source = "1";
        List<String> goal = Arrays.asList("1");
        List<String> result = Arrays.asList(source.split(","));
        assertThat(result.equals(goal));
    }

    @Test
    @DisplayName("subStringTest")
    void subStringTest() {
        String source = "(1,2)";
        String goal = "1,2";
        String result = source.substring(1,3);
        assertThat(result.equals(goal));
    }

    @Test
    @DisplayName("charAtTest")
    void charAtTest() {
        String source = "abc";
        Character goal_A = 'a';
        Character goal_B = 'b';
        Character goal_C = 'c';
        Character result_A = source.charAt(0);
        Character result_B = source.charAt(1);
        Character result_C = source.charAt(2);

        assertThat(result_A.equals(goal_A));
        assertThat(result_B.equals(goal_B));
        assertThat(result_C.equals(goal_C));

        assertThatThrownBy(() -> {
            Character result_error = source.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }

    @Test
    @DisplayName("setSizeTest")
    void setSizeTest() {
        Set<String> source = new HashSet<>(Arrays.asList("a", "b", "c"));
        assertThat(source.size()).isEqualTo(3);
    }

    @DisplayName("setContainTest")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    //@CsvSource(value = {"1: true", "2: true", "3 : true", "4:false","5:false"}, delimiter = ':')
    void setContainTest(int element) {
        Set<Integer> source = new HashSet<>(Arrays.asList(1,2,3));
        assertThat(source.contains(element)).isTrue();
        assertThat(source.contains(4)).isFalse();
        assertThat(source.contains(5)).isFalse();
    }


}