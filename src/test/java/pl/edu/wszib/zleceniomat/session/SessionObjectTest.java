package pl.edu.wszib.zleceniomat.session;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.wszib.zleceniomat.session.SessionObject;

public class SessionObjectTest {

    @Test
    public void getInfoTest(){
        SessionObject sessionObject = new SessionObject();
        String info = "ABC";

        Assert.assertNull(sessionObject.getInfo());
        sessionObject.setInfo(info);
        Assert.assertEquals(info, sessionObject.getInfo());
        Assert.assertNull(sessionObject.getInfo());
    }
}
