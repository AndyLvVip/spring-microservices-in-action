package aspire.demo.licensing.security;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FinanceMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceMenu.class);

    private int i = 0;

    public boolean canDelete(Authentication authentication) throws IOException {
        LOGGER.info("can-delete->" + new ObjectMapper().writeValueAsString(authentication));
        if(i++ % 2 == 0)
            return true;
        else
            return false;
    }

}
