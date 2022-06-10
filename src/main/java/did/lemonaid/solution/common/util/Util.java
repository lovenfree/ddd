package did.lemonaid.solution.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Util {
    public static String getMethodName() {
        String name = new Object() {}.getClass().getEnclosingMethod().getName();
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
}
