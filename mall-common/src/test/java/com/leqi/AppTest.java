package com.leqi;

import static org.junit.Assert.assertTrue;

import com.leqi.common.utils.JwtUtils;
import com.leqi.common.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
@Slf4j
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


    @Test
    public void testToken(){
    String password = DigestUtils.md5Hex("12345");
    log.info("md5加密++"+password);
    String str  = JwtUtils.sign("admin",password);
    log.info("jwt加密++"+str);
    String username = JwtUtils.getUsername(str);
    log.info(username);
    }

}
