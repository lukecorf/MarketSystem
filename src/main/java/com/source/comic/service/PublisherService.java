package com.source.comic.service;

import com.source.comic.domain.EPublisher;
import com.source.comic.dto.DPublisher;
import com.source.comic.exception.InsertException;
import com.source.comic.mapper.PublisherMapper;
import com.source.comic.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository repository;

    private final PublisherMapper mapper;

    public DPublisher insert(DPublisher dClient) {
        if(Objects.nonNull(dClient.getId())){
            throw new InsertException();
        }
        return persist(dClient);
    }

    public DPublisher update(DPublisher dClient) {
        if(Objects.isNull(dClient.getId())){
            throw new InsertException();
        }
        return persist(dClient);
    }

    public DPublisher findById(Long id){
        EPublisher eClient = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,"EClient.class"));
        return mapper.toDto(eClient);
    }

    public Page<DPublisher> findAll(Pageable pageable) {
        Page<EPublisher> page = repository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    private DPublisher persist(DPublisher dClient) {
        EPublisher eClient = mapper.toEntity(dClient);
        return mapper.toDto(repository.save(eClient));
    }
}
