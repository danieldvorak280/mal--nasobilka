package me.dan.malnsobilka.Model;

import java.util.Random;

/**
 * Created by Dan on 07.12.2017.
 */

public class Model {

    Random random = new Random();
     public int n1 = random.nextInt(10) + 1;
    public int n2 = random.nextInt(10) + 1;
    public int result = n1 * n2;
    public int rightAnswers = 0;
    public int wrongAnswers = 0;
    public int exampleCount = 1;
    public void setNewValues ()
    {
        n1 = random.nextInt(10) + 1;
        n2 = random.nextInt(10) + 1;
        result= n1 * n2;

    }
}
