package com.formacion.sepe.chatgptspring.controller;

import com.formacion.sepe.chatgptspring.dto.MessageDto;
import com.formacion.sepe.chatgptspring.dto.RequestDto;
import com.formacion.sepe.chatgptspring.dto.ResponseDto;

import com.formacion.sepe.chatgptspring.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public ResponseEntity<MessageDto> chat(@RequestBody String prompt) {

        RequestDto requestDto = new RequestDto(model, chatService.getPrompt(prompt));
        ResponseDto responseDto = restTemplate.postForObject(apiUrl, requestDto, ResponseDto.class);

        if (responseDto == null || responseDto.getChoices() == null || responseDto.getChoices().isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageDto("user","No se ha podido obtener respuesta"));
        }
        return ResponseEntity.ok(responseDto.getChoices().get(0).getMessage());
    }
}
