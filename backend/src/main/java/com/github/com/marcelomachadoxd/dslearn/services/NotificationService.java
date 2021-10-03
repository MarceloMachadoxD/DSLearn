package com.github.com.marcelomachadoxd.dslearn.services;

import com.github.com.marcelomachadoxd.dslearn.DTO.NotificationDTO;
import com.github.com.marcelomachadoxd.dslearn.entities.Notification;
import com.github.com.marcelomachadoxd.dslearn.entities.User;
import com.github.com.marcelomachadoxd.dslearn.entities.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository repository;

    @Autowired
    AuthService authService;

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable){
       User user = authService.autenticated();

       Page<Notification> page = repository.find(user, unreadOnly, pageable);

       return page.map(x -> new NotificationDTO(x));

    }



}
