package com.sprint.mission.discodeit.controller;

import com.sprint.mission.discodeit.dto.BinaryContentDto;
import com.sprint.mission.discodeit.service.BinaryContentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/binary")
public class BinaryContentController {
    private final BinaryContentService binaryContentService;

    public BinaryContentController(BinaryContentService binaryContentService) {
        this.binaryContentService = binaryContentService;
    }

    @RequestMapping(value = "/{binaryId}", method = RequestMethod.GET)
    public BinaryContentDto getBinaryContent(@PathVariable UUID binaryId) {
        return binaryContentService.findById(binaryId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BinaryContentDto> getMultipleBinaryContent(
            @RequestParam List<UUID> id) {
        return binaryContentService.findAllByIdIn(id);
    }
}
