package mk.ukim.finki.ampleapi.config;

import mk.ukim.finki.ampleapi.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfiguration {

    private final RegistrationService registrationService;
    private static final Logger logger = LoggerFactory.getLogger(SchedulerConfiguration.class);

    public SchedulerConfiguration(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Scheduled(cron = "0 0 12 * * ?")
    void remove() {
        logger.info("Removing old unconfirmed users");
        registrationService.removeOld();
    }
}
