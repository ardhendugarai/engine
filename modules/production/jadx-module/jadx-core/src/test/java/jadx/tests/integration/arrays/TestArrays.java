package jadx.tests.integration.arrays;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;
import org.junit.Test;

import static jadx.tests.api.utils.JadxMatchers.containsOne;
import static org.junit.Assert.assertThat;

public class TestArrays extends IntegrationTest {
    @Test
    public void test() {
        noDebugInfo();
        ClassNode cls = getClassNode(TestCls.class);
        String code = cls.getCode().toString();

        assertThat(code, containsOne("return new int[]{1, 2, 3, 5}[i];"));
    }

    public static class TestCls {

        public int test1(int i) {
            int[] a = new int[]{1, 2, 3, 5};
            return a[i];
        }

        public int test2(int i) {
            int[][] a = new int[i][i + 1];
            return a.length;
        }
    }
}