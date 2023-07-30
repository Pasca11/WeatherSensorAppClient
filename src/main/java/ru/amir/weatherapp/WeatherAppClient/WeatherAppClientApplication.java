package ru.amir.weatherapp.WeatherAppClient;

import jakarta.websocket.OnClose;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.amir.weatherapp.dto.SensorDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@SpringBootApplication
public class WeatherAppClientApplication {

	public static void main(String[] args) {
		String url = "http://localhost:8080/measurements/add";
		RestTemplate restTemplate = new RestTemplate();
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("value", Integer.toString(random.nextInt(-99, 99)));
			map.put("raining", Boolean.toString(random.nextBoolean()));
			map.put("sensor", Map.of("name", "TestSensor" + (random.nextBoolean() ? "2": "")));
			HttpEntity<Map<String, Object>> request = new HttpEntity<>(map);
			restTemplate.postForLocation(url,request);
		}
	}

}
