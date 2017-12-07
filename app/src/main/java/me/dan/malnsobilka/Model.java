package me.dan.malnsobilka;

import java.util.Random;

/**
 * Created by Dan on 07.12.2017.
 */

public class Model {

    Random random = new Random();
    int n1 = random.nextInt(10) + 1;
    int n2 = random.nextInt(10) + 1;
    int result = n1 * n2;
    int rightAnswers = 0;
    int wrongAnswers = 0;
    int exampleCount = 1;
    public void setNewValues ()
    {
        n1 = random.nextInt(10) + 1;
        n2 = random.nextInt(10) + 1;
        result= n1 * n2;

    }
}
