import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tinkoff.qa.utils.Props;

import java.util.logging.Logger;

import static ru.tinkoff.qa.utils.HttpClient.responseBody;
import static ru.tinkoff.qa.utils.HttpClient.responseCode;
import static ru.tinkoff.qa.utils.HttpClient.sendGet;
import static ru.tinkoff.qa.utils.Props.initializeProps;

/**
 * @author Simonov-MS
 * Написать и автоматизировать тест-кейсы для нескольких endpoint'ов https://httpbin.org/
 * /headers
 * /anything/:code
 * /redirect/:n
 */

public class TestHeaders {
    private static final Logger LOGGER = Logger.getLogger(TestHeaders.class.getName());
    Props pps = new Props();

    @BeforeMethod
    public void getTestData() {
        initializeProps();
    }

    @Test
    public void testHeaders() {
        LOGGER.info(pps.getHeaders());
        try {
            sendGet(pps.getHeaders());

            LOGGER.info("Test: testHeaders, verify response http code");
            Assert.assertEquals(responseCode, 200);
            if(responseCode == 200){
                LOGGER.info("Success!");
            }else {
                LOGGER.warning("Warning, details: " + responseCode);
            }

            LOGGER.info("Test: testHeaders, verify body i`snt empty. \n Details :" + responseBody);
            Assert.assertNotNull(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
