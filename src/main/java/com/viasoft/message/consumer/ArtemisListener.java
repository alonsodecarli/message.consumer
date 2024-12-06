package com.viasoft.message.consumer;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ArtemisListener {

    @JmsListener(destination = "crm.filas::pessoa")
    public void onMessage(String message) {
        // Processando a mensagem recebida
        System.out.println("Mensagem recebida da fila: " + message);


        if (message.contains("erro")) {
            try {
                throw new Exception("Erro no processamento da mensagem");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }



    }

}
