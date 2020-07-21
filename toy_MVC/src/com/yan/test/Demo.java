package com.yan.test;

import com.yan.anno.Toy;
import org.junit.Test;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
@Toy(value = 1,test = 2)
public class Demo {
    @Test
    public void fun(){
        Toy annotation = this.getClass().getAnnotation(Toy.class);
        System.out.println(annotation);
        annotation.test();
        annotation.value();
    }
}
