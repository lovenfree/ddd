package did.lemonaid.solution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
@Slf4j
@SpringBootApplication
public class SolutionBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolutionBackendApplication.class, args);
    }

}
