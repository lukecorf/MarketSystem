package com.project.study.service;

import com.project.study.domain.EClient;
import com.project.study.dto.DClient;
import com.project.study.exception.InsertException;
import com.project.study.mapper.ClientMapper;
import com.project.study.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    private final ClientMapper mapper;

    public DClient insert(DClient dClient) {
        if(Objects.nonNull(dClient.getId())){
            throw new InsertException();
        }
        return persist(dClient);
    }

    public DClient update(DClient dClient) {
        if(Objects.isNull(dClient.getId())){
            throw new InsertException();
        }
        return persist(dClient);
    }

    public DClient findById(Long id){
        EClient eClient = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,"EClient.class"));
        return mapper.toDto(eClient);
    }

    public Page<DClient> findAll(Pageable pageable) {
        Page<EClient> page = repository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    private DClient persist(DClient dClient) {
        EClient eClient = mapper.toEntity(dClient);
        return mapper.toDto(repository.save(eClient));
    }
}
