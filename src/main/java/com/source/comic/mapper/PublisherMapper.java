package com.source.comic.mapper;

import com.source.comic.domain.EPublisher;
import com.source.comic.dto.DPublisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PublisherMapper extends EntityMapper<DPublisher, EPublisher>{
}
