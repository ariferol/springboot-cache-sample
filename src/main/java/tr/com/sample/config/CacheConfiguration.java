package tr.com.sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.management.timer.Timer;


@Configuration
public class CacheConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfiguration.class);

    @Bean
    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
        return new ConcurrentCustomizer();
    }

    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setAllowNullValues(true);
            cacheManager.setStoreByValue(true);
            System.out.println("CacheManager daki customize methoduna girdi");
        }
    }

    @Scheduled(fixedRate = Timer.ONE_MINUTE * 1)
    @CacheEvict(value = {"students"}, allEntries = true)
    public void clearStudentsCache() {
        LOGGER.info("Tum students degerleri cache den her 1 dakikada bir temizleniyor!");
    }
}
