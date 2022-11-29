package com.marion.mybatis3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mybatis3ApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 测试移位操作
     */
    public static void main(String[] args) {
        long docId = 65534; // < 65535
        long bucket = (docId + (1 << 16) - 1) >>> 16;
        System.out.println(bucket);

        long docId1 = 65540; // > 65535
        long bucket1 = (docId1 + (1 << 16) - 1) >>> 16;
        System.out.println(bucket1);
    }
}
