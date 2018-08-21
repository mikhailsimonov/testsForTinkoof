import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.tinkoff.qa.model.ResponseHeaders;
import ru.tinkoff.qa.utils.JsonConstructor;
import ru.tinkoff.qa.utils.Props;

import java.util.logging.Logger;

import static ru.tinkoff.qa.utils.HttpClient.*;
import static ru.tinkoff.qa.utils.Props.initializeProps;
import static ru.tinkoff.qa.utils.ValueGenerator.genRandomId;
import static ru.tinkoff.qa.utils.ValueGenerator.timeMilliseconds;

/**
 * @author Simonov-MS
 * Написать и автоматизировать тест-кейсы для нескольких endpoint'ов https://httpbin.org/
 * /headers
 * /anything/:code
 * /redirect/:n
 */

public class TestAnything {
    private static final Logger LOGGER = Logger.getLogger(TestBasicUrl.class.getName());
    Props pps = new Props();

    @BeforeMethod
    public void getTestData() {
        initializeProps();
    }

    @Test
    public void testGetAnything() {

        LOGGER.info(pps.getAnything()+genRandomId());
        try {
            sendGet(pps.getAnything()+genRandomId());

            LOGGER.info("Step 1: testAnything with value, verify response http code");
            Assert.assertEquals(responseCode, 200);
            if(responseCode == 200){
                LOGGER.info("Success!");
            }else {
                LOGGER.warning("Warning, details: " + responseCode);
            }

            LOGGER.info("Step 2: verify header URL of response");
            //ResponseHeaders rh = JsonConstructor.headersOfResponse(responseBody);
            //Assert.assertEquals(rh.getUrl(),pps.getAnything());
            //an example of how I checked the headers

            LOGGER.info("Step 3: testAnything, verify body i`snt empty. \n Details :" + responseBody);
            Assert.assertNotNull(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPostAnything() {

        LOGGER.info(pps.getAnything()+genRandomId());
        try {
            sendPost(pps.getAnything()+genRandomId(),"data" + timeMilliseconds());

            LOGGER.info("Test: testAnything with value, verify response http code");
            Assert.assertEquals(responseCode, 200);
            if(responseCode == 200){
                LOGGER.info("Success!");
            }else {
                LOGGER.warning("Warning, details: " + responseCode);
            }



            LOGGER.info("Test: testAnything, verify body i`snt empty. \n Details :" + responseBody);
            Assert.assertNotNull(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPutAnything() {

        LOGGER.info(pps.getAnything()+genRandomId());
        try {
            sendPut(pps.getAnything()+genRandomId());

            LOGGER.info("Test: testAnything with value, verify response http code");
            Assert.assertEquals(responseCode, 200);
            if(responseCode == 200){
                LOGGER.info("Success!");
            }else {
                LOGGER.warning("Warning, details: " + responseCode);
            }


            LOGGER.info("Test: testAnything, verify body i`snt empty. \n Details :" + responseBody);
            Assert.assertNotNull(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteAnything() {

        LOGGER.info(pps.getAnything()+genRandomId());
        try {
            sendDelete(pps.getAnything()+genRandomId());

            LOGGER.info("Test: testAnything with value, verify response http code");
            Assert.assertEquals(responseCode, 200);
            if(responseCode == 200){
                LOGGER.info("Success!");
            }else {
                LOGGER.warning("Warning, details: " + responseCode);
            }


            LOGGER.info("Test: testAnything, verify body i`snt empty. \n Details :" + responseBody);
            Assert.assertNotNull(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
