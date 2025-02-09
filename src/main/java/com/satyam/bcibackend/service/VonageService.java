package com.satyam.bcibackend.service;

import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import org.springframework.stereotype.Service;

@Service
public class VonageService {

    public void sendMessage(String messageBody) {
        VonageClient client = VonageClient.builder().apiKey("0e15a53d").apiSecret("DwBbUw65dOFusJZk").build();

        TextMessage message = new TextMessage("Vonage APIs",
                "916378680236",
                messageBody
        );

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().getFirst().getStatus() == MessageStatus.OK) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Message failed with error: " + response.getMessages().getFirst().getErrorText());
        }
    }

}
