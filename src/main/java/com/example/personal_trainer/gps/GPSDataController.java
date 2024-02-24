package com.example.personal_trainer.gps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gps")
public class GPSDataController {

    @Autowired
    private GPSDataService gpsDataService;

    @PostMapping("/update")
    public ResponseEntity<String> updateGPSData(@RequestBody GPSData gpsData){
        gpsDataService.saveGPSData(gpsData);
        return ResponseEntity.ok("GPS data received successfully");
    }

    @MessageMapping("/sendGPSData")
    @SendTo("/topic/gps")
    public GPSData sendGPSData(@Payload GPSData gpsData){
        return gpsData;
    }
}
