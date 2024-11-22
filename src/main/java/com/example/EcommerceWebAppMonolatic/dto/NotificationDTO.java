package com.example.EcommerceWebAppMonolatic.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private Long id;
    private String sender;
    private String recipient;
    private String content;
}
