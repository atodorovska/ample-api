package mk.ukim.finki.ampleapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageConfiguration {

    public static final String LOCATION = "upload-dir";
}
