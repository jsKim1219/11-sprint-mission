package com.sprint.mission.discodeit.dto.response;

import java.util.List;
import org.springframework.data.domain.Slice;

public record PageResponse<T>(
    List<T> content, int number, int size, boolean hasNext, Long totalElements
) {
  
}
