package com.spring.esAPI;

import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

class HostNameVerifier implements HostnameVerifier {

    @Override
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}

@Configuration
public class ElasticConfiguration  {
    Logger logger = LoggerFactory.getLogger(ElasticConfiguration.class);

    @Bean
    public SSLContext insecureSslContext() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        return SSLContexts.custom()
                .loadTrustMaterial(null, (x509Certificates, s) -> true)
                .build();
    }

    HostnameVerifier hostnameVerifier = new HostNameVerifier();

    @Bean
    public RestHighLevelClient elasticsearchClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String userName = Objects.isNull(System.getenv("ELS_USER_NAME")) ? Constants.ELS_USERNAME : System.getenv("ELS_USER_NAME");
        String password = Objects.isNull(System.getenv("ELS_PASSWORD")) ? Constants.ELS_PASSWORD : System.getenv("ELS_PASSWORD");
        String elsURL = Objects.isNull(System.getenv("ELS_URL")) ? Constants.ELS_URL : System.getenv("ELS_URL");
        logger.info("Connecting to els " + elsURL + " with username: " + userName);

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elsURL)
                .usingSsl(insecureSslContext(), hostnameVerifier)
                .withBasicAuth(userName, password)
                .build();
        logger.info("Connected to els successfully");
        return RestClients.create(clientConfiguration).rest();
    }
}
