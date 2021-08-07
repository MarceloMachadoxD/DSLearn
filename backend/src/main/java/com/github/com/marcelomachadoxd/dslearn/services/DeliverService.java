package com.github.com.marcelomachadoxd.dslearn.services;

import com.github.com.marcelomachadoxd.dslearn.DTO.DeliverRevisionDTO;
import com.github.com.marcelomachadoxd.dslearn.entities.Deliver;
import com.github.com.marcelomachadoxd.dslearn.entities.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    @Autowired
    private DeliverRepository repository;

    @Transactional(readOnly = false)
    public void saveRevision(Long id, DeliverRevisionDTO dto) {
        Deliver deliver = repository.getOne(id);

        deliver.setDeliverStatus(dto.getDeliverStatus());
        deliver.setFeedback(dto.getFeedback());
        deliver.setCorrectCount(dto.getCorrectCount());
        repository.save(deliver);
    }

}
