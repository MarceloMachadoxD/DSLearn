package com.github.com.marcelomachadoxd.dslearn.resources;

import com.github.com.marcelomachadoxd.dslearn.DTO.NotificationDTO;
import com.github.com.marcelomachadoxd.dslearn.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

    @Autowired
    private NotificationService notificationsService;


    @GetMapping
    public ResponseEntity<Page<NotificationDTO> > notificationsForCurrentUser(
            @RequestParam(name = "unreadOnly", defaultValue = "false") Boolean unreadOnly,
            Pageable pageable){
        Page<NotificationDTO> notificationsDTO = notificationsService.notificationsForCurrentUser(unreadOnly, pageable);
        return ResponseEntity.ok().body(notificationsDTO);
    }



}
