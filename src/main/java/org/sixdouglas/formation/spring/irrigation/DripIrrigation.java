package org.sixdouglas.formation.spring.irrigation;

import org.sixdouglas.formation.spring.irrigation.producer.GreenHouseProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;

@Component
public class DripIrrigation {
    private static Logger LOGGER = LoggerFactory.getLogger(DripIrrigation.class);

    public Flux<Drop> followDrops() {
        //TODO Create a Flux that would emit a Drop every 20 millis seconds
        return Flux.interval(Duration.ofMillis(20)).map(aLong -> Drop.builder()
                .dropperId(1)
                .greenHouseId(1)
                .rowId(1)
                .instant(Instant.now())
                .build());
    }

    public Flux<Drop> followDropper(int greenHouseId, int rowId, int dropperId) {
        //TODO use the GreenHouseProducer.getDrops() function as producer, but filter the output to fit the given criteria
        GreenHouseProducer greenHouseProducer = new GreenHouseProducer();
        Flux<Drop> fluxDrop = greenHouseProducer.getDrops().filter(drop ->
                drop.getGreenHouseId() == greenHouseId &&
                drop.getRowId() == rowId &&
                drop.getDropperId() == dropperId);
        return fluxDrop;
    }
}
