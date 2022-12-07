package br.com.github.io.yoandreferreira.shopapi.events;

import br.com.github.io.yoandreferreira.shopapi.dto.ShopDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaClient {

    private final KafkaTemplate<String, ShopDTO> kafkaTemplate;
    private static final String SHOP_TOPIC_NAME = "SHOP_TOPIC";

    public void sendMessage(ShopDTO msg) {
        kafkaTemplate.send(SHOP_TOPIC_NAME, msg);
    }

}
