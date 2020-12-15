package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    final String port;
    final String memoryLimit;
    final String cfInstanceIndex;
    final String cfInstanceAddress;

    public EnvController(
            @Value("${port:NOT SET}") String port,
            @Value("${memory.limit:NOT SET}") String memoryLimit,
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
            @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddress
    ) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> props = new HashMap<>();
        props.put("PORT", port);
        props.put("MEMORY_LIMIT", memoryLimit);
        props.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        props.put("CF_INSTANCE_ADDR", cfInstanceAddress);
        return props;
    }

}
