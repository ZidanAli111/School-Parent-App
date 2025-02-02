package com.ielts.cmds.integration;

import static com.ielts.cmds.integration.constants.DistORSConstants.USER_AGENT;
import static com.ielts.cmds.integration.constants.DistORSConstants.USER_AGENT_KEY;

import org.springframework.http.HttpHeaders;

import com.ielts.cmds.integration.constants.DistORSConstants;

@Slf4j
public class AbstractORSLocationChangedDist extends AbstractLambda<LocationChanged, ExternalOutputType> {

    private final EnvironmentAwareAuthenticationClientFactory authenticationClientFactory;
    private AuthenticationClient authenticationClient;

    public AbstractORSLocationChangedDist() {
        this.authenticationClientFactory = new EnvironmentAwareAuthenticationClientFactory();
    }

    @Override
    protected ExternalOutputType processRequest(LocationChanged locationChanged) {
        // Partner-specific logic can be handled here or via conditional checks
        if (ThreadLocalHeaderContext.getContext().getPartnerCode().equals(getPartnerCodeConstants())) {
            final EventMapper eventMapper = getEventMapper();
            LocationV1 response = eventMapper.mapLocationResponse(locationChanged);
            log.debug("ORSLocationChangedResponse before RestTemplate call: {} ", response);
            putRequestToExternalAPI(response, System.getenv(CALLBACK_URL));
        } else {
            log.warn("Incoming partnerCode:{} does not match expected partner code:{}",
                    ThreadLocalHeaderContext.getContext().getPartnerCode(), getPartnerCodeConstants());
        }
        return null;
    }

    @Override
    protected String getTopicName() {
        return null;
    }

    void putRequestToExternalAPI(final LocationV1 resBody, final String externalUrl) {
        try {
            getAuthenticationClient();
            final HttpHeaders eventHeaders = getHttpHeaders();
            final HttpEntity<LocationV1> eventEntity = new HttpEntity<>(resBody, eventHeaders);
            log.debug("ExternalUrl : {} ; eventEntity : {} ; eventHeader : {}", externalUrl, eventEntity, eventHeaders);
            final ResponseEntity<String> response = authenticationClient.getRestTemplate().exchange(externalUrl, HttpMethod.PUT, eventEntity, String.class);
            log.trace("Response Code: {}" ,response.getStatusCode());
            log.info("Message processed successfully");

        } catch(HttpClientErrorException | JsonProcessingException | CertificateException | KeyStoreException | TokenNotReceivedException | InvalidClientException e){
            log.warn("Client Exception on processing event :", e);
        }
    }

    EventMapper getEventMapper() {
        return new EventMapper();
    }

    // These are now implemented directly in this class
    protected void setAdditionalHttpHeaders(HttpHeaders httpHeaders) {
        httpHeaders.set(USER_AGENT_KEY, System.getenv(USER_AGENT));
    }

    protected String getPartnerCodeConstants() {
        return DistORSConstants.CA;  // Now set to CA, or it could be dynamic if required
    }

    protected String getApplicationName() {
        return DistORSConstants.ORS_LOCATIONCHANGED_DIST_CA;  // The application name for CA
    }

    HttpHeaders getHttpHeaders() throws JsonProcessingException, CertificateException, KeyStoreException, TokenNotReceivedException {
        final HeaderContext eventHeader = ThreadLocalHeaderContext.getContext();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set(TRANSACTIONID, getNonNullUuidString(eventHeader.getTransactionId()));
        httpHeaders.set(CORRELATIONID, getNonNullUuidString(eventHeader.getCorrelationId()));
        httpHeaders.set(PARTNER_CODE, eventHeader.getPartnerCode());
        httpHeaders.set(EVENT_DATE_TIME, getNonNullDateTimeString(eventHeader.getEventDateTime()));
        httpHeaders.set(authenticationClient.getAuthorizationHeaderName(), authenticationClient.getAccessToken());
        setAdditionalHttpHeaders(httpHeaders);
        return httpHeaders;
    }

    public void getAuthenticationClient() throws InvalidClientException, CertificateException, KeyStoreException, JsonProcessingException {
        if (authenticationClient == null) {
            authenticationClient = authenticationClientFactory.getAuthenticationClient(ThreadLocalHeaderContext.getContext().getPartnerCode());
        }
    }

    String getNonNullUuidString(UUID uuid) {
        if(uuid != null) {
            return uuid.toString();
        } else {
            return "";
        }
    }

    String getNonNullDateTimeString(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        if(dateTime != null) {
            return dateTime.format(formatter);
        } else {
            return "";
        }
    }
}


so this is my code for the lambda function created by my senior FSE java developer


so , now my tech lead told me that ,  previously there was 3 partner and those 3 partner subclass were using the AbstractORSLocationChangedDist class , but now their will be just one partner CA, and  he want me instead of those three partner class , do everything in the AbstractORSLocationChangedDist , like
  1.  protected abstract void setAdditionalHttpHeaders(HttpHeaders httpHeaders);

 2.   protected abstract String getPartnerCodeConstants();

    3. protected abstract String getApplicationName();
these three methods will no longer be abstract and the AbstractORSLocationChangedDist  will no longer be abstract and just like the partner class implement this methods within this AbstractORSLocationChangedDist  and most of the other logics will be same , no changes

do you understand what is the requirement?