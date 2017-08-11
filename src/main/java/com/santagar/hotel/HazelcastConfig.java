package com.santagar.hotel;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class HazelcastConfig {

    @Bean
    public Config hazelCastConfig() {

        Config config = new Config();
        config.setInstanceName("hazelcast-cache");

        MapConfig hotelsCache = new MapConfig();
        hotelsCache.setTimeToLiveSeconds(60);
        hotelsCache.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put("hotels-cache",hotelsCache);

        MapConfig hotelCache = new MapConfig();
        hotelCache.setTimeToLiveSeconds(60);
        hotelCache.setEvictionPolicy(EvictionPolicy.LFU);
        config.getMapConfigs().put("hotel-cache",hotelCache);

        return config;
    }

}
