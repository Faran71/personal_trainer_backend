package com.example.personal_trainer.gps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class GPSDataService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private GPSDataRepository gpsDataRepository;

    public void saveGPSData(GPSData gpsData){
        gpsDataRepository.save(gpsData);

        messagingTemplate.convertAndSend("/topic/gps", gpsData);
    }
}
