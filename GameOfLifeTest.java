//package com.gameoflife;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.gameoflife.GameOfLife;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//public class GameOfLifeTest {
//
//@Test
//    public void testNextGen()
//    {                           //test Method with given
//        int[][] genZero =
//                {
//                        {1, 1, 1, 0, 1},
//                        {0, 0, 0, 1, 0},
//                        {1, 1, 1, 0, 1},
//                        {1, 1, 1, 0, 1},
//                        {0, 0, 0, 1, 0},
//                };
//
//        int[][] genOneExpected =
//                {
//                        {0, 1, 1, 1, 0},
//                        {0, 0, 0, 0, 1},
//                        {1, 0, 0, 0, 1},
//                        {1, 0, 0, 0, 1},
//                        {0, 1, 1, 1, 0},
//                };
//        int[][] genOne = GameOfLife.nextGen(genZero, genZero.length, genZero.length);
//
//        assertTrue(Arrays.deepEquals(genOne, genOneExpected));
//    }
//
//
//}
