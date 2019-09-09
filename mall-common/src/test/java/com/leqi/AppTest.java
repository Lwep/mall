package com.leqi;

import static org.junit.Assert.assertTrue;

import com.leqi.common.utils.Md5Utils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String str = Md5Utils.getMD5String("admin"+"ad");
        System.out.print(str);
        assertTrue( true );
    }
}
