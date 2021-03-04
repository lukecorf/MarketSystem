package com.project.study.mapper;

import com.project.study.domain.EClient;
import com.project.study.dto.DClient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ClientMapper extends EntityMapper<DClient, EClient>{
}
